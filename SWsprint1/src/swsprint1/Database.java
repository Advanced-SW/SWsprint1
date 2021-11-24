import java.util.ArrayList;

public class Database {
    private static ArrayList<Person>users=new ArrayList();
    private static ArrayList<Driver>drivers=new ArrayList();
    private static ArrayList<User>clients=new ArrayList();

    public static ArrayList<Person> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<Person> users) {
        Database.users = users;
    }

    public static ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public static void setDrivers(ArrayList<Driver> drivers) {
        Database.drivers = drivers;
    }

    public static ArrayList<User> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<User> clients) {
        Database.clients = clients;
    }
    public void print()
    {
        for(int i=0;i<users.size();i++)
        {
            System.out.println(users.get(i).toString());
        }
    }
}
