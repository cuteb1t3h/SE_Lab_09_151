import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен и готов к работе...");

        while (true) {
            // Ожидаем подключения клиента
            Socket clientSocket = serverSocket.accept();

            // Получаем входной и выходной потоки для общения с клиентом
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Ждем от клиента сообщения с именем пользователя
            String username = input.readUTF();
            System.out.println("К нам пришел " + username);
            output.writeUTF("Hello, " + username);

            String flag;
            int count = 0;
            while ((flag = input.readUTF()) != null){
                if (flag.equals("bye")){
                    output.close();
                    input.close();
                    clientSocket.close();
                    serverSocket.close();
                    break;
                }
                if (flag.equals("exit") && username.equals("admin")){
                    output.close();
                    input.close();
                    clientSocket.close();
                    serverSocket.close();
                }
                count++;
                String message = count + " - " + flag;
                System.out.println("Получено сообщение №" + message);
                output.writeUTF(message);
            }

            // Ждем от клиента сообщения с именем пользователя
//            String username = input.readUTF();
//            System.out.println("К нам пришел " + username);

            // Выводим клиенту приветственное сообщение
//            output.writeUTF("Hello, " + username);
        }
    }
}
