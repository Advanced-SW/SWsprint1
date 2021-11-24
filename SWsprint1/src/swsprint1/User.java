
import java.util.ArrayList;
import java.util.*;

public class User extends Person {

    boolean suspend = false;

    public void setData(String name, String password, String mobile, String email) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
    }

    public void requestRide(String source, String destination) {
        Area area = new Area(source, destination);
        Request cr = new Request();
        cr.setData(this, area);
        controlData Data = new controlData();
        ArrayList<Driver> temp = Data.getWithSource(cr);

        for (int i = 0; i < temp.size(); i++) {
            System.out.println(i + 1 + " " + temp.get(i).getName() + " " + "50 " + (temp.get(i).getAvgRate()));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of the offer");
        int offer = sc.nextInt();
        offer -= 1;

        System.out.println("Please enter rate :");
        double x = sc.nextDouble();
        Ride ride = new Ride(source, destination,this, temp.get(offer), x);
        temp.get(offer).addRide(ride);
        temp.get(offer).updateAVG();
        System.out.println("Thank you!");

    }

    public boolean isSuspend() {
        return suspend;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }
}
