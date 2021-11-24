public class Ride 
{
   private String source;
   private String destination;
   private  User client;
   private  Driver driver;
   private  double rate;
public double getRate()
{
   return rate;
}
public Ride(String source, String destination, User client, Driver driver, double rate) 
{
      this.source = source;
      this.destination = destination;
      this.client = client;
      this.driver = driver;
      this.rate = rate;
   }
}
