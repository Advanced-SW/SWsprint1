
import java.util.ArrayList;
import java.util.*;

public class controlData extends Database implements MData {

    public boolean login(String NAME, String password) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getName().equals(NAME) && temp.get(i).getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public void registerD(Driver driver) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        temp.add(driver);
        setUsers(temp);
    }

    public void registerC(User client) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        temp.add(client);
        setUsers(temp);
    }

    @Override
    public void update(Person p1) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getName().equals(p1.getName()) && temp.get(i).getPassword().equals(p1.getPassword())) {
                temp.remove(i);
                temp.add(p1);
                break;
            }
        }
        setUsers(temp);
    }

    @Override
    public void set(Person p1) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        temp.add(p1);
        setUsers(temp);
    }

    @Override
    public void delete(Person p1) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getName().equals(p1.getName()) && temp.get(i).getPassword().equals(p1.getPassword())) {
                temp.remove(i);

                break;
            }
        }
        setUsers(temp);
    }

    @Override
    public Person get(Person p1) {
        ArrayList<Person> temp = new ArrayList();
        temp = getUsers();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getName().equals(p1.getName()) && temp.get(i).getPassword().equals(p1.getPassword())) {
                return temp.remove(i);

            }
        }
        return null;
    }

    public ArrayList<Driver> getWithSource(Request cr) {
        ArrayList<Person> temp = new ArrayList();
        ArrayList<Driver> ans = new ArrayList();
        temp = getUsers();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) instanceof Driver) {
                for (int j = 0; j < ((Driver) temp.get(i)).getFav().size(); j++) {
                    if (((Driver) temp.get(i)).getFav().get(j).equals(cr.getArea().getSource())) {
                        ans.add(((Driver) temp.get(i)));
                    }

                }
            }
        }
        return ans;
    }
}
