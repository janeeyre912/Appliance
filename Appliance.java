/**
 *@author Lin
 *@version #1 
 * Class for a appliance of four items type,brand,serial number and price.
 * Class invariant:The price is always bigger than 1.0;first serial number is 1000000; 
 * the type and brand is nonempty string. 
 */
public class Appliance {
   private String type;
   private String brand;
   private long sNum;
   private double price;
   /**
    * fNum is the first serial number for the first appliance
    */
   private final static long fNum = 1000000;
   static int count = 0;
   
   /**
    * default constructor
    */
   public Appliance() {
	   type = "no type yet";
	   brand = "no name yet";
	   sNum = fNum + count;
	   price = 1.0;
	   count++;
	   
   }
   
   /**
    * @param a is an object includes four attributes type,brand,serial number and price of appliance.
    */
   public Appliance(Appliance a) {
	   if(a == null)
	   {
		   System.out.println("Error: null Appliance object.");
		   System.exit(0);
	   }
	   type = a.type;
	   brand = a.brand;
	   sNum = a.sNum;
	   price = a.getPrice();
	   count++;
   }
   
   /**
    * Precondition: the name of the type and brand are nonempty strings; the price is bigger than 1.0 double number. 
    * @param t String the type name
    * @param b String the brand name
    * @param p Double the price
    */
   public Appliance(String t, String b, double p) {
       setType(t);
       setBrand(b);
       sNum = fNum + count;
       setPrice(p);
       count++;
   }
  /**
   *@return String is the type of appliance
   */
   public String getType() {
	   return type;
   }
   /**
    *@return String is the brand of appliance
    */
   public String getBrand() {
	   return brand;
   } 
   /**
    *@return long is the serial number of appliance
    */
   public long getSNum() {
	   return sNum;   
   }
   /**
    *@return double is the price of appliance
    */
   public double getPrice() {
	   return price;
   }
   
   /**
    * @param t is a nonempty string.
    */
   public void setType(String t) {
	   if(t != null && t != "")
		   type = t;
	   else {
		   System.out.println("Error: Improper type value.");
		   System.exit(0);
	   }
   }
   
   /**
    * @param b is a nonempty string.
    */
   public void setBrand(String b) {
	   if(b != null && b != "")
		   brand = b;
	   else {
		   System.out.println("Error: Improper brand value.");
		   System.exit(0);
        }
   }
   
   public void setPrice(double p) {
	   if(p >= 1.0)
	   price = p;
	   else
	   {
		   System.out.println("Error:Invalid price.");
		   System.exit(0);
	   }
   }
   
   public String toString() {
	   return("Appliance Serial # " + sNum + "(where " + sNum + " is the serial number)\n" + 
              "Brand: " + brand + "\n" + "Type: " + type + "\n"+ "Price: " + price + "\n");
   }
   
   /**
    * method uses to count the number of appliances already created
    * @return the number of created Appliances
    */
   public static int findNumberOfCreatedAppliances() {
	   
	   return count;
   }
   
 /**
  * @param a is an object includes four attributes type,brand,serial number and price of appliance. 
  * @return true if the types,brands and prices are the same; otherwise returns false.
  * Also returns false if a is null.
  */
 	public boolean equals(Appliance a)
 	{
 		if ( a == null ) 
 	       	  return false;
 		else
 	          return (type.equals(a.getType()) && 
 	        		  brand.equals(a.getBrand()) && 
 	        		  price==a.getPrice());
 	
 	}
 	
}	





 	
 