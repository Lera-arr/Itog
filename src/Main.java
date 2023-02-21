import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Главное меню");

   Scanner in= new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Суровый","Андрей","Андреевич","79009001122","admin@yandex.ru","admin1", "pass", "Администратор"));
        users.add(new User("Дубовый","Евгений","Николаевич","79209031123","dyb@yandex.ru","guest1", "1111", "Пользователь"));
        users.add(new User("Дубовый","Евгений","Николаевич","79209031123","dyb@yandex.ru","1", "1", "Администратор"));
        User currentUser= new User();
        boolean auth=true;
        while(auth) {
            System.out.println("1 – Авторизироваться \n2 – Зарегистрироваться \n3-Выход");

            switch (in.nextLine()) {
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
                                    currentUser=item;
                                } else {
                                    System.out.println("Вы вошли в систему, как посетитель");
                                    nonunic = false;
                                    auth = nonunic;
                                    currentUser=item;
                                }
                            }
                        }
                        if (nonunic) {
                            System.out.println("Данные не верны");
                            System.out.println("1 Повторить \n2 Вернуться в главное меню");
                            boolean stop;
                            do {
                                stop = false;
                                switch (in.nextLine()) {
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
                    while (!people.setTelephone(in.nextLine())) ;

                    System.out.println("Введите email");
                    people.setEmail(in.nextLine());

                    boolean nonunis;
                    do {
                        System.out.println("Введите логин");
                        while (!people.setLogin(in.nextLine())) ;
                        nonunis = false;
                        for (User pl : users) { //проверка на уникальность логина и пароля
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
//        System.out.println(currentUser.toString());
            //Scanner in= new Scanner(System.in);
            ArrayList<Goods> products = new ArrayList<>();
            products.add(new Goods("Преступление и наказание", "350р"));
            products.add(new Goods( "Игрок", "400р"));
            products.add(new Goods("Белые ночи", "399р"));
            products.add(new Goods("Униженные и оскорбленные", "299р"));
            if (currentUser.getType().equals("Администратор")){


            while (true) {
                System.out.println("1 Добавить товар" +
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
                        System.out.println("Введите id ");
                        int book1 = Integer.parseInt(in.nextLine());
                        for (Goods book : products) {
                            if (book.getIdBook() == book1) {
                                in.nextLine();
                                System.out.println("1 Подтвердить удаление \n2 Отменить удаление");
                                boolean stop2;
                                do {
                                    stop2 = false;
                                    switch (in.nextLine()) {
                                        case "1":
                                            products.remove(book);
                                            break;
                                        case "2":
                                            break;
                                        default:
                                            stop2 = true;
                                    }
                                } while (stop2);
                            }
                        }
                        break;
                    case "3":
// 3Просмотр информации о товаре
                        for (Goods book : products) {
                            System.out.println(book);
                        }
                        break;
                    case "4":
// 4  Просмотр информации о пользователях
                        for (User userAll : users) {
                            System.out.println(userAll);
                        }
                        break;
                    case "5":
//5 Смена роли пользовате
                        System.out.println("Введите логин пользователя ");
                        String loginId1 = in.nextLine();
                        for (User loginId : users) {
                            if (loginId.getLogin().equals(loginId1)) {

                                System.out.println("1 Сделать администратором? \n2 Сделать пользователем? \n3 Отменить");
                                String userType = in.nextLine();
                                boolean stop5;
                                do {
                                    stop5 = false;
                                    switch (userType) {
                                        case "1":
                                            loginId.setType("Администратор");
                                            break;
                                        case "2":
                                            loginId.setType("Пользователь");
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
        }
        else {
                while (true) {
                    System.out.println("1 Просмотр информации о товаре" +
                            "\n2 Выход");
                    in.nextLine();
                }

        }


        }
    public static ArrayList addGood(ArrayList products1) {
        Scanner in= new Scanner(System.in);
        Goods product = new Goods();
        System.out.println("Введите наименование книги");
        product.setNameProduct(in.nextLine());

        System.out.println("Введите цену");
        product.setPrice(in.nextLine());

        in.nextLine();
        System.out.println("1 Подтвердить добавление новой книги\n2 Отменить добавление новой книги");
        boolean stop;
        do{
            stop=false;
            switch (in.nextLine()){
                case "1":
                    products1.add(product);
                    break;
                case "2":
                    break;
                default:stop=true;
            }
        }while(stop);
        return products1;
    }
    }

