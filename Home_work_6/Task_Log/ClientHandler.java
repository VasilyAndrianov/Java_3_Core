package Home_work_6.Task_Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.apache.log4j.Logger;


public class ClientHandler {
    private ConsoleServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    Logger admin = Logger.getLogger("admin.ClientHandler");
    Logger file = Logger.getLogger("file.ClientHandler");

    public ClientHandler(ConsoleServer server, Socket socket) {

        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                admin.info("Клиент прислал команду, о завершеии работы");
                                out.writeUTF("/serverClosed");
                                admin.info("Сервер закрыт");
                                break;
                            }
                            System.out.println("Client " + str);
                            file.info("Сообщение от клиента " + str);
                            server.broadcastMsg(str);
                        }
                    } catch (IOException e) {
                        admin.error("This is error");
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            admin.error("This is error - socket.getInputStream");
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            admin.error("This is error - socket.getOutputStream");
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            admin.error("This is error - socket.close");
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            admin.error("This is error - out.writeUTF(msg)");
            e.printStackTrace();
        }
    }
}
