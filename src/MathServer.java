import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MathServer {
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

            // Ждем от клиента сообщения с номером варианта
            String variant = input.readUTF();
            System.out.println("Выбранный вариант " + variant);

            double result;
            double a = Double.parseDouble(input.readUTF());
            System.out.println("a = " + a);
            double b = Double.parseDouble(input.readUTF());
            System.out.println("b = " + b);
            double c = Double.parseDouble(input.readUTF());
            System.out.println("c = " + c);
            double d = Double.parseDouble(input.readUTF());
            System.out.println("d = " + d);
            double o = Double.parseDouble(input.readUTF());
            System.out.println("o = " + o);
            double x = Double.parseDouble(input.readUTF());
            System.out.println("x = " + x);
            double y = Double.parseDouble(input.readUTF());
            System.out.println("y = " + y);
            double n = Double.parseDouble(input.readUTF());
            System.out.println("n = " + n);

            switch (variant) {
                case "V1":
                    result = ((Math.pow((5 * a), n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.pow(Math.cos(x), 3))));
                    output.writeUTF("" + result);
                case "V2":
                    result = ((Math.abs(x - y)) / Math.pow((1 + 2 * x), a)) - Math.pow(Math.E, Math.sqrt(1 + o));
                    output.writeUTF("" + result);
                case "V3":
                    result = Math.sqrt(a + a * x + a * Math.sqrt(Math.sin(x)));
                    output.writeUTF("" + result);
                case "V4":
                    result = Math.log10(Math.pow(a, 7)) + Math.pow((Math.acos(x) / Math.asin(x)), 2) + Math.PI / Math.sqrt(Math.abs(a + x));
                    output.writeUTF("" + result);
                case "V5":
                    result = Math.pow(((Math.pow(a + b, 2)) / c + d) + Math.pow(Math.E, (Math.sqrt(x + 1))), 1.0 / 5);
                    output.writeUTF("" + result);
                case "V6":
                    result = Math.pow(Math.E, (2 * Math.sin(4 * x) + Math.pow(Math.cos(Math.pow(x, 2)), 2)) / (3 * x));
                    output.writeUTF("" + result);
                case "V7":
                    result = 0.75 * (((1 + Math.pow(x, 2)) / (1 - x)) + 0.5 * Math.tan(x));
                    output.writeUTF("" + result);


                if (input.readUTF().equals("bye")){
                    output.close();
                    input.close();
                    clientSocket.close();
                    serverSocket.close();
                    break;
                }
            }
        }
    }
}
