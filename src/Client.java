import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) throws Exception {
        // Создаем сокет для подключения к серверу
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

        // Получаем входной и выходной потоки для общения с сервером
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Вводим имя в консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String username = scanner.nextLine();

        // Отправляем имя пользователя на сервер, выводим ответ от сервера на консоль
        output.writeUTF(username);
        System.out.println(input.readUTF());

        String flag;
        do {
//            System.out.println("Введите сообщение: ");
            flag = scanner.nextLine();
            output.writeUTF(flag);

            String message = input.readUTF();
            System.out.println("Ответ сервера: " + message);
        }while (!flag.equals("bye"));

        output.close();
        input.close();
        socket.close();
    }
}
