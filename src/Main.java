import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Главное меню");

        Scanner in = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Суровый", "Андрей", "Андреевич", "79009001122", "admin@yandex.ru", "admin1", "pass",
                "Администратор"));
        users.add(new User("Дубовый", "Евгений", "Николаевич", "7920905653", "dyb@yandex.ru", "guest1", "1111",
                "Пользователь"));
        users.add(new User("Коргинина", "Евгения", "Алесеевна", "79209061193", "dyb@yandex.ru", "1", "1",
                "Администратор"));
        users.add(new User("Великий", "Даниил", "Константинович", "79209031823", "dyb@yandex.ru", "2", "2",
                "Пользователь"));
        User currentUser = new User();

        boolean auth = true;
        while (auth) {
            System.out.println("1 Авторизироваться " +
                    "\n2 Зарегистрироваться " +
                    "\n3 Выход");
            String userType0 = in.nextLine();
            switch (userType0) {
                case "1": {
                    boolean nonunic;
                    do {
                        nonunic = true;
                        System.out.println("Введите логин");
                        String loginIn = in.nextLine();
                        System.out.println("Введите пароль");
                        String passIn = in.nextLine();
                        User user = new User(loginIn, passIn, "");
                        for (User item : users) {
                            if (user.equals(item)) {
                                if (item.getType().equals("Администратор")) {
                                    System.out.println("Вы вошли в систему, как администратор");
                                    nonunic = false;
                                    auth = nonunic;
                                    currentUser = item;
                                } else {
                                    System.out.println("Вы вошли в систему, как посетитель");
                                    nonunic = false;
                                    auth = nonunic;
                                    currentUser = item;
                                }
                            }
                        }
                        if (nonunic) {
                            System.out.println("Данные не верны");
                            System.out.println("1 Повторить " +
                                    "\n2 Вернуться в главное меню");
                            String userType4 = in.nextLine();
                            boolean stop;
                            do {
                                stop = false;
                                switch (userType4) {
                                    case "1":
                                        break;
                                    case "2":
                                        nonunic = false;
                                        break;
                                    default:
                                        stop = true;
                                }
                            } while (stop);
                        }

                    } while (nonunic);

                }
                    break;
                case "2":
                    User people = new User();
                    System.out.println("Введите Фамилию");
                    people.setSurname(in.nextLine());

                    System.out.println("Введите Имя");
                    people.setName(in.nextLine());

                    System.out.println("Введите Отчество");
                    people.setPatronymic(in.nextLine());

                    System.out.println("Введите Телефон");
                    while (!people.setTelephone(in.nextLine()))
                        ;

                    System.out.println("Введите email");
                    people.setEmail(in.nextLine());

                    boolean nonunis;
                    do {
                        System.out.println("Введите логин");
                        while (!people.setLogin(in.nextLine()))
                            ;
                        nonunis = false;
                        for (User pl : users) { // проверка на уникальность логина и пароля
                            if (pl.equalsLogin(people)) {
                                System.out.println("такой пользователь уже есть в системе");
                                nonunis = true;
                            }
                        }
                    } while (nonunis);

                    System.out.println("Введите пароль");
                    people.setPass(in.nextLine());
                    break;
                case "3":
                    return;
            }
        }
        // System.out.println(currentUser.toString());
        // Scanner in= new Scanner(System.in);
        ArrayList<Goods> products = new ArrayList<>();
        products.add(new Goods("Преступление и наказание", "350р"));
        products.add(new Goods("Игрок", "400р"));
        products.add(new Goods("Белые ночи", "399р"));
        products.add(new Goods("Униженные и оскорбленные", "299р"));
        if (currentUser.getType().equals("Администратор")) {

            // String userType1 = in.nextLine();
            while (true) {
                System.out.println("-------------");
                System.out.println("Меню администратора:" +
                        "\n1 Добавить товар" +
                        "\n2 Удаление товара" +
                        "\n3 Просмотр информации о товаре" +
                        "\n4 Просмотр информации о пользователях" +
                        "\n5 Смена роли пользователю" +
                        "\n6 Выход");

                switch (in.nextLine()) {
                    case "1":
                        products = addGood(products);
                        break;
                    case "2":
                        // Удаление книги
                        products = deleteGood(products);
                        break;
                    case "3":
                        // 3Просмотр информации о товаре
                        products = reviewGood(products);
                        break;
                    case "4":
                        // 4 Просмотр информации о пользователях
                        for (User userAll : users) {
                            System.out.println(userAll);
                        }
                        break;
                    case "5":
                        // 5 Смена роли пользовате
                        System.out.println("Введите логин пользователя ");
                        String loginId1 = in.nextLine();
                        for (User loginId : users) {
                            if (loginId.getLogin().equals(loginId1)) {

                                System.out.println("1 Сделать администратором? " +
                                        "\n2 Сделать пользователем? " +
                                        "\n3 Отменить");
                                String userType2 = in.nextLine();// без бага
                                boolean stop5;
                                do {
                                    stop5 = false;
                                    switch (userType2) {
                                        case "1":
                                            loginId.setType("Администратор");
                                            System.out.println("Выполнено");
                                            break;
                                        case "2":
                                            loginId.setType("Пользователь");
                                            System.out.println("Выполнено");
                                            break;
                                        case "3":
                                            break;
                                        default:
                                            stop5 = true;
                                    }
                                } while (stop5);
                            }
                        }
                        break;
                    case "6":
                        return;
                }
            }
        } else {
            while (true) {
                System.out.println("Меню пользователя:" +
                        "\n1 Просмотр информации о товаре" +
                        "\n2 Выход");

                String userType3 = in.nextLine();
                switch (userType3) {
                    case "1":
                        products = reviewGood(products);
                        break;
                    case "2":
                        return;
                }
            }
        }
    }

    public static ArrayList<Goods> addGood(ArrayList<Goods> products1) {
        Scanner in = new Scanner(System.in);
        Goods product = new Goods();
        System.out.println("Введите наименование книги");
        product.setNameProduct(in.nextLine());

        System.out.println("Введите цену");
        product.setPrice(in.nextLine());
        System.out.println("1 Подтвердить добавление новой книги\n2 Отменить добавление новой книги");
        String userType3 = in.nextLine();

        boolean stop;
        do {
            stop = false;
            switch (userType3) {
                case "1":
                    products1.add(product);
                    System.out.println("Книга добавлена: " +product);
                    break;
                case "2":
                    break;
                default:
                    stop = true;
            }
        } while (stop);
        return products1;
    }

    public static ArrayList<Goods> deleteGood(ArrayList<Goods> products2) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите id ");
        int book1 = Integer.parseInt(in.nextLine());
        for (Goods book : products2) {
            if (book.getIdBook() == book1) {
                in.nextLine();
                System.out.println("1 Подтвердить удаление \n2 Отменить удаление");
                boolean stop2;
                do {
                    stop2 = false;
                    switch (in.nextLine()) {
                        case "1":
                            products2.remove(book);
                            System.out.println("Книга удалена: "+book);
                            break;
                        case "2":
                            break;
                        default:
                            stop2 = true;
                    }
                } while (stop2);
                break;
            }
        }
        return products2;
    }

    public static ArrayList<Goods> reviewGood(ArrayList<Goods> products3) {
        // 3 Просмотр информации о товаре
        Scanner in = new Scanner(System.in);
        System.out.println("Список книг:");
        for (Goods book : products3) {
            System.out.println(book);
        }
        return products3;
    }
}
