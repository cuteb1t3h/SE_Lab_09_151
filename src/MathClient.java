import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MathClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) throws Exception {
        // Создаем сокет для подключения к серверу
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

        // Получаем входной и выходной потоки для общения с сервером
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Вводим номер задачи в консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи: ");
        String variant = scanner.nextLine();
        output.writeUTF(variant);

        System.out.println("Введите значение a: ");
        String a = scanner.nextLine();
        output.writeUTF(a);

        System.out.println("Введите значение b: ");
        String b = scanner.nextLine();
        output.writeUTF(b);

        System.out.println("Введите значение c: ");
        String c = scanner.nextLine();
        output.writeUTF(c);

        System.out.println("Введите значение d: ");
        String d = scanner.nextLine();
        output.writeUTF(d);

        System.out.println("Введите значение o: ");
        String o = scanner.nextLine();
        output.writeUTF(o);

        System.out.println("Введите значение x: ");
        String x = scanner.nextLine();
        output.writeUTF(x);

        System.out.println("Введите значение y: ");
        String y = scanner.nextLine();
        output.writeUTF(y);

        System.out.println("Введите значение n: ");
        String n = scanner.nextLine();
        output.writeUTF(n);

        // Отправляем номер задачи на сервер, выводим ответ от сервера на консоль
        System.out.println(input.readUTF());

        String flag;
        do {
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
