import java.util.ArrayList;
import java.util.*;

public class Admin extends Person{
    public void verify(Person p1)
    {
        controlData Data=new controlData();
        ArrayList <Person> temp=new ArrayList();
        temp=Data.getUsers();
        for(int i=0;i<temp.size();i++)
        {
            if (temp.get(i).getName().equals(p1.getName())&&temp.get(i).getPassword().equals(p1.getPassword()))
            {
                if (temp.get(i) instanceof  Driver) {
                    if (((Driver) temp.get(i)).isVerify()==false)
                    {
                        ((Driver) temp.get(i)).setVerify(true);
                    }
                }

            }
        }
        }



    public void suspend(Person p1)
    {
        controlData Data=new controlData();
        ArrayList <Person> temp=new ArrayList();
        temp=Data.getUsers();
        for(int i=0;i<temp.size();i++)
        {
            if (temp.get(i).getName().equals(p1.getName())&&temp.get(i).getPassword().equals(p1.getPassword()))
            {
                if (temp.get(i) instanceof  Driver) {
                    if (((Driver) temp.get(i)).isSuspend()==false)
                    {
                        ((Driver) temp.get(i)).setSuspend(true);
                    }
                }
                else if(temp.get(i) instanceof  User)
                {
                    if (((User) temp.get(i)).isSuspend()==false)
                    {
                        ((User) temp.get(i)).setSuspend(true);
                    }
                }
            }
        }

    }
}
