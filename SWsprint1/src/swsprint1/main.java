
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Welcome! what do you want to do today ?");
        System.out.println("To register : Please enter '1' ");
        System.out.println("To login : Please enter '2' ");

        Scanner sc = new Scanner(System.in);
        int choice1 = sc.nextInt();
        controlData cd = new controlData();
        switch (choice1) {
            case 1:
                Scanner s = new Scanner(System.in);
                System.out.println("To sign up as a driver please enter '1' ");
                System.out.println("To sign up as a passenger please enter '2' ");
                String userName,
                 mobileNumber,
                 email,
                 password,
                 nationalID,
                 license;
                int choice2 = sc.nextInt();
                switch (choice2) {

                    case 1:
                        Driver d = new Driver();
                        System.out.println("Username* :");
                        userName = s.nextLine();
                        System.out.println("Mobile Number* :");
                        mobileNumber = s.nextLine();
                        System.out.println("Email 'optional' :");
                        email = s.nextLine();
                        System.out.println("Password* :");
                        password = s.nextLine();
                        System.out.println("NationalID* :");
                        nationalID = s.nextLine();
                        System.out.println("License* :");
                        license = s.nextLine();
                        d.setData(userName, password, mobileNumber, email, license, nationalID);
                        System.out.println("Please wait to be verified..... ");
                        Admin ad = new Admin();
                        ad.verify(d);
                        System.out.println("You have been verified !");
                        cd.registerD(d);
                        cd.login(userName, password);
                        while (true) {
                            System.out.println("You can choose from the following options :");
                            System.out.println("1-Add favourite area ");
                            System.out.println("2-List my ratings");
                            System.out.println("3-List old rides");
                            System.out.println("4-Exit");
                            int ch = s.nextInt();
                            switch (ch) {
                                case 1:
                                    Scanner input = new Scanner(System.in);
                                    System.out.println("Please enter new area");
                                    String area = input.nextLine();
                                    d.addArea(area);
                                    break;
                                case 2:
                                    for (int i = 0; i < d.getRides().size(); i++) {
                                        System.out.println(d.getRides().get(i).getRate());
                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < d.getRides().size(); i++) {
                                        System.out.println(d.getRides().get(i).toString());
                                    }
                                    break;
                            }
                            if (ch == 4) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        User u = new User();
                        System.out.println("Username* :");
                        userName = s.nextLine();
                        System.out.println("Mobile Number* :");
                        mobileNumber = s.nextLine();
                        System.out.println("Email 'optional' :");
                        email = s.nextLine();
                        System.out.println("Password* :");
                        password = s.nextLine();
                        u.setData(userName, password, mobileNumber, email);
                        System.out.println("You have been registered!");
                        //controlData cd = new controlData();
                        cd.registerC(u);
                        cd.login(userName, password);
                        System.out.println("Please enter your source location: ");
                        String source = s.nextLine();
                        System.out.println("Please enter your destination location: ");
                        String dest = s.nextLine();
                        u.requestRide(source, dest);
                        System.out.println("Thank you for using our system");
                        break;

                }
                break;
            case 2:
                Scanner in = new Scanner(System.in);
                System.out.println("Username* :");
                userName = in.nextLine();

                System.out.println("Password* :");
                password = in.nextLine();
                Person p = new Person();
                cd.login(userName, password);
                if (p instanceof Driver) {
                    while (true) {
                        System.out.println("Welcome " + cd.get(p).name + "! you have logged in  ");
                        System.out.println("You can choose from the following options :");
                        System.out.println("1-Add favourite area ");
                        System.out.println("2-List my ratings");
                        System.out.println("3-List old rides");
                        int ch = sc.nextInt();
                        switch (ch) {
                            case 1:

                                System.out.println("Please enter new area");
                                String area = sc.nextLine();
                                ((Driver) p).addArea(area);
                                break;
                            case 2:
                                for (int i = 0; i < ((Driver) p).getRides().size(); i++) {
                                    System.out.println(((Driver) p).getRides().get(i).getRate());

                                }
                                break;
                            case 3:
                                for (int i = 0; i < ((Driver) p).getRides().size(); i++) {
                                    System.out.println(((Driver) p).getRides().get(i).toString());
                                }
                                break;

                        }
                        if (ch == 4) {
                            break;
                        }
                    }
                } else if (p instanceof User) {
                    System.out.println("Welcome " + cd.get(p).name + "! you have logged in  ");
                    System.out.println("Please enter your source location: ");
                    String source = sc.nextLine();
                    System.out.println("Please enter your destination location: ");
                    String dest = sc.nextLine();
                    ((User) p).requestRide(source, dest);
                }

                break;
        }
    }
}
