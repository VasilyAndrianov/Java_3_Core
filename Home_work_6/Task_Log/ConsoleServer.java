package Home_work_6.Task_Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import org.apache.log4j.Logger;

public class ConsoleServer {
    private Vector<ClientHandler> clients;
    Logger admin = Logger.getLogger("admin.ConsoleServer");
    Logger file = Logger.getLogger("file.ConsoleServer");

    public ConsoleServer() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            admin.info("Сервер запушен");
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                admin.info("Клиент подключился");
                System.out.println("Клиент подключился");
                clients.add(new ClientHandler(this, socket));
            }

        } catch (IOException e) {
            admin.fatal("This is fatal");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                admin.info("Сокет закрыт");
            } catch (IOException e) {
                admin.error("Ошибка закрытия сокета");
                e.printStackTrace();
            }
            try {
                server.close();
                admin.info("Сервер закрыт");
            } catch (IOException e) {
                admin.error("Ошибка зыкрытия сервера");
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }
}

