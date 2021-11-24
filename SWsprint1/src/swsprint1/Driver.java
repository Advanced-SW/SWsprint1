
import java.util.ArrayList;

public class Driver extends Person {

    private String license;
    private String NationalID;
    private ArrayList<String> favArea = new ArrayList();
    private ArrayList<Ride> rides = new ArrayList();
    protected double avgRate = 0.0;
    boolean verify = false;
    boolean suspend = false;

    public void setData(String name, String password, String mobile, String email, String license, String NationalID) {
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.license = license;
        this.NationalID = NationalID;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }
    
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void updateAVG() 
    {
        double ans = 0;
        for (int i = 0; i < rides.size(); i++) 
        {
            ans += rides.get(i).getRate();
        }
        ans = ans / rides.size();
        avgRate = ans;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public ArrayList<String> getFav() {
        return favArea;
    }

    public String getLicence() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void addArea(String area) {
        favArea.add(area);
    }

    @Override
    public String toString() {
        return "Driver{"
                + "licence='" + license + '\''
                + ", name='" + name + '\''
                + '}';
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public boolean isSuspend() {
        return suspend;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }
}
