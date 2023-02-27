import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) throws IOException {

        // Создаем сокет для подключения к серверу
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

        // Получаем входной и выходной потоки для общения с сервером
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output  = new DataOutputStream(socket.getOutputStream());

        // Вводим имя в консоли
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String username = scanner.nextLine();

        // Отправляем имя пользователя на сервер
        output.writeUTF(username);

        // Читаем ответ от сервера и выводим его на консоль
        String response = input.readUTF();
        System.out.println(response);

        socket.close();
    }
}
