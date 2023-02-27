import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен и готов к работе...");

        while (true) {
            // Ожидаем подключения клиента
            Socket socket = serverSocket.accept();

            // Получаем входной и выходной потоки для общения с клиентом
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Ждем от клиента сообщения с именем пользователя
            String username = input.readUTF();;
            System.out.println("К нам пришел " + username);

            // Выводим клиенту приветственное сообщение
            output.writeUTF("Hello, " + username);

            socket.close();
        }
    }
}
