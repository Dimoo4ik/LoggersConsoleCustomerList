import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static final Logger queriesLogger = LogManager.getLogger("org.example.QueriesLogger");
    private static final Logger errorsLogger = LogManager.getLogger("org.example.ErrorsLogger");

    public static void main(String[] args) {



        Clients clients1 = new Clients("Дима", "dimamin11@gmail.com ", "79631601418");
        Clients clients2 = new Clients("Михаил", "mix11@gmail.com ", "79991112233");
        Clients clients3 = new Clients("Влад", "vlad11@gmail.com ", "78882224455");

        ArrayList<Clients> clientsArrayList = new ArrayList<>() {{
            add(clients1);
            add(clients2);
            add(clients3);
        }};


        String regyarNomer = "[0-9]";
        String regyarEmail = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";
        String regyarName = "[a-zA-Z]";


        while (true) {
            System.out.println("Введите Help");
            String text = new Scanner(System.in).nextLine();

            if (text.equals("Help")) {

                System.out.println("Вывести всех клиентов из списка\n" +
                        "Удалить клиента из списка\n" +
                        "Добавить клиента\n");

                text = new Scanner(System.in).nextLine();

                if (text.equals("Вывести всех клиентов из списка")) {

                    for (Clients i : clientsArrayList) {
                        System.out.println(i);
                    }


                } else if (text.equals("Удалить клиента из списка")) {

                    try {
                        System.out.println("Введите index клиента какого вы хотите удалить ");
                        int index = new Scanner(System.in).nextInt();

                        clientsArrayList.remove(index - 1);
                        queriesLogger.debug("Клиент удолен");

                    } catch (Exception exception) {
                        errorsLogger.error("Ошибка при удолении");
                    }


                } else if (text.equals("Добавить клиента")) {


                    System.out.println("Введите имя клиента: ");
                    String name = new Scanner(System.in).nextLine();


                    System.out.println("Введите email клиента: ");
                    String email = new Scanner(System.in).nextLine();

                    System.out.println("Введите номер телефона клиента: ");
                    String phone = new Scanner(System.in).nextLine();

                    if (email.matches(regyarEmail) && name.matches(regyarName) && name.matches(regyarNomer)) {
                        queriesLogger.debug("Клиент создан");

                        clientsArrayList.add(new Clients(name, email, phone));


                    } else {
                        errorsLogger.error("Ошибка при СОЗДАНИИ КЛИЕНТА");
                    }

                }

            }
        }
    }
}
