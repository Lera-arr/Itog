import java.util.Objects;
import java.util.Scanner;

public class User {
    private String login;
    private String pass;
    private String type;
    private String surname;
    private String name;
    private String patronymic;
    private String telephone;
    private String email;


    public User()
    {}
    public User(String login, String pass, String type) {
        this.login = login;
        this.pass = pass;
        this.type = type;
    }
    public User(String surname, String name,String patronymic,String telephone,String email,String login, String pass, String type) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.telephone = telephone;
        this.email = email;
        this.login = login;
        this.pass = pass;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public boolean setLogin(String login) {
        if(login.matches("[A-Za-z0-9]*") && !login.isEmpty()){
           this.login = login;
            return true;
        } else{
            System.out.println("Введите данные на латинице");
            return false;
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean setTelephone(String telephone) {
        if(telephone.matches("\\+7|7|8\\d{10}")){
            this.telephone = telephone;
            return true;
        } else{
            System.out.println("Ошибка некоректные данные");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    public boolean equalsLogin(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(login, user.login);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(login, user.login)) return false;
        return Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getType()+" "+ getLogin()+" "+getPass()+" "+getEmail()+" "+getName()+" "+ getPatronymic()+" "+ getSurname()+" "+getTelephone();
    }


}


