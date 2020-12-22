/**
 *@author Lin
 *@version #1 
 * Class for build a inventory system for helping in acquiring and keeping
 * track of appliances at the store.
 */

import java.util.Scanner;
public class ApplianceDriver {
	
	static Scanner keyIn = new Scanner(System.in);
	public static void main(String[] args) {
	 		
	 		int n1 = 0, n2 = 0; 
	 		int option1= 0, option2 = 0, option3 = 0;
	 		int i = 0, count1 = 0;
	 		final String p = "c249";
	 		long num = 0;
	 		final long fNum = 1000000;
	 		final long maxAppliances = 99999;
	 		String p1, p2;
			Appliance [] inventory = new Appliance[n1];
			
	 		 //welcome header
		    System.out.println("-------------------------------------------------\n"
		                     + "      Welcome to Inventory System              \n"
		                     + "-------------------------------------------------\n");
		    
		    //prompt the user for the size of the inventory array
		 do
			 {  
			    System.out.println("How many appliances do you want to record? (must be <= 99999) and > 0");
				checkInt();
				n1 = keyIn.nextInt(); 
			    if(n1 <= 0 || n1 > maxAppliances) {
			       System.out.println("Invalid Number! please enter number between 0 and 99999!");
			    }    
			}
			while (n1 <= 0 || n1 > maxAppliances);
		    inventory = new Appliance[n1];
			
    label:		//return to the main menu when condition is not meet
	 do {
		   do {
				    //display a main menu
			   
					System.out.println("What do you want to do?\n" +
			                        "   1.Enter new appliances (password required)\n" +
					                "   2.Change information of an appliance(password required)\n" +
			                        "   3.Display all appliances by a specific brand\n" +
					                "   4.Display all appliances under a certain a price.\n" +
			                        "   5.Quit\n" +
					                "Please enter your choice>");
					checkInt();
					option1 = keyIn.nextInt();	
					if(option1 < 1 || option1 > 5)
					System.out.println("Invalid Enter! please enter number, from 1 to 5.");
				    }
				   while(option1 < 1 || option1 > 5 );
				  
				   //option1:enter new appliances
				  if(option1 == 1) {
				      keyIn.nextLine();
				      i = 0;
				      do 
				         {
					         System.out.println("Please enter the password:");
					         p1 = keyIn.nextLine();
					         i++;
					         if(!p1.equals(p) && i <= 3) {
					        	 System.out.println("Password Error!");
					         }
				         }
				      while(!p1.equals(p) && i < 3);
				      
				       count1++;
					   if(count1 == 4) {
					      System.out.println("Program detected suspicious activities and will terminate immediately!");
					      System.exit(0);
				          }
				 
				      if(p1.equals(p)) {
				    	   count1 = 0;
				           System.out.println("How many appliances do you want to enter?");
				           checkInt();
				           n2 = keyIn.nextInt();
				          
				           if(n2 > n1 - Appliance.findNumberOfCreatedAppliances())
				                 {
				        	         System.out.println("Invalid number! Bigger than your max storage!");
				                 }
				           
				           else if (n2 <= 0)
				                {
				        	         System.out.println("Invalid number! Must bigger than 0!");
				                }
				           
				           else if(n2 <= n1 - Appliance.findNumberOfCreatedAppliances()) {
				              do {
						            System.out.println("Enter the brand:");
						            keyIn.nextLine();
						            String brand = keyIn.nextLine();
						            
						            String type = selectType();
						            System.out.println("Enter the price:");
						            checkDouble();
						            double price = keyIn.nextDouble();
								    
					                Appliance a = new Appliance(type,brand,price);
					               
					                inventory[Appliance.findNumberOfCreatedAppliances()-1] = a;	
					                System.out.println(a);
						            n2--;
							   	  }
				              while(n2 != 0);
			              }
				            
				      }
				  } //end of option 1
				
	             //option 2 :change information
				   else if(option1 == 2) {
	        	         i = 0;
	        	         keyIn.nextLine();
			             do {
				                 System.out.println("Please enter the password:");
				                 p2 = keyIn.nextLine();
				                 i++; 
				                 if(!p2.equals(p)&& i <= 3) {
				                	 System.out.println("Password Error!");
				                 }
				             }
			             while(!p2.equals(p) && i < 3);
			             if(p2.equals(p)) {
			                 do {
				                    System.out.println("Please enter the serial number of the appliance:");
				                    checkLong();
				                    num = keyIn.nextLong();
				                   
				                    if(num < fNum + Appliance.findNumberOfCreatedAppliances() && num >= fNum)
				                    	break;
				                    if(num >= fNum + Appliance.findNumberOfCreatedAppliances() || num < fNum)
				                    	System.out.println("The serial number is not exist! Must less than " +
			                                      (fNum + Appliance.findNumberOfCreatedAppliances()) +
			                                      " more than or equal to " + fNum + "\n");
				                             
				                    do
				                    {
				                    System.out.println( "Do you want to :\n" + 
						                              "1.re-enter another serial number\n" + 
						                              "2.quit to the main menu?");
				                                     checkInt();
				                                     option2 = keyIn.nextInt();
				                                     if(option2 == 2) continue label;
				                                     if(option2 < 1 || option2 > 2)
				                     				 System.out.println("Invalid Enter! please enter number, between 1 and 2.");
				                                    
				                     }while(option2 < 1 || option2 > 2);
			                    } 
			                while( option2 == 1 );
			                
			                System.out.println(inventory[(int) (num - fNum)]);
			    	        do {
					                  System.out.println("What information would you like to change?\n" +
					                                    "1. brand\n" +
					                                    "2. type\n" +
					                                    "3. price\n" +
					                                    "4. Quit\n" +
					                                    "Enter your choice >");	
					                                     checkInt();
				                                         option3 = keyIn.nextInt();
							 
							 
					                  switch(option3) {
							 
							               case 1: keyIn.nextLine();
								                   System.out.println("Please enter the name of the new brand:");
							                       inventory[(int)(num - fNum)].setBrand(keyIn.nextLine());
							                       System.out.println(inventory[(int)(num - fNum)]);break;
							 
							               case 2: inventory[(int)(num - fNum)].setType(selectType());
						                           System.out.println(inventory[(int)(num - fNum)]);break;
						                
					                       case 3: System.out.println("Please enter the new price:");
					                               checkDouble();
					                               inventory[(int)(num - fNum)].setPrice(keyIn.nextDouble());
					                               System.out.println(inventory[(int)(num - fNum)]);break;
					      
					                       case 4 : break;
					                     
					                       default: System.out.println("Invalid number!");break;
							          }
					 
				              }
			                while(option3 != 4);
			             }
			        }//end of option2
		         
				   //option 3: Display all appliances by a special brand
		          else if (option1 == 3) {
				          keyIn.nextLine();
				          System.out.println("Please enter the name of the brand:");
				          findAppliancesBy(keyIn.nextLine(),inventory);
				        } //end of option 3
				
			       //option 4 : Display all appliances under a certain a price
			      else if (option1 == 4) {
				         System.out.println("Please enter the price:");
				         checkDouble();
				         findCheaperThan(keyIn.nextDouble(),inventory); 
			           }//end of option 4
				
				
			      //option 5: Quit
			      else if(option1 == 5) {
				          System.out.println("Thank you for using inventory system!");
				          System.exit(0);
			          }//end of option 5
			
		   }
      while(count1 < 4 );
				
	      keyIn.close();	
	  }//end of main method
 
	/**
	 * displays the information of all appliances in the inventory with the input brand
	 * @param brand is a nonempty string.
	 * @param inventory is an appliance object array.
	 */
	 public static void findAppliancesBy(String brand, Appliance[] inventory) {
		int j = 0;
		for(int i = 0;i < Appliance.findNumberOfCreatedAppliances(); i++)
		 {
		       if(brand.equalsIgnoreCase(inventory[i].getBrand())) {
		           System.out.println(inventory[i]); j++;
		         }     
		  }
		 if(j == 0) {
		      System.out.println("No item is this brand : " + brand);
	         }
	  }
	 
	 /**
	  * displays all appliances in the store that have a price smaller than the entered value.
	  * @param price is a double number.
	  * @param inventory is an appliance object array.
	  */
	  public static void findCheaperThan(double price,Appliance[] inventory) {
		 int j = 0;
		 for(int i = 0;i < Appliance.findNumberOfCreatedAppliances(); i++)
		 {
		        if(inventory[i].getPrice() < price) {
			         System.out.println(inventory[i]); j++;
		            }  
	       }
		  if(j == 0) {
	         System.out.println("No item less than $" + price);
            }
	   }
	  
	  /**
	   * uses to help users enter the certain 9 appliance types in the system
	   * @return a string, is the proper name of the type.
	   */
      public static String selectType() {
		
		
		 int optionT;
		 do {
			  System.out.println("Enter the type number(1-9):\n" + 
	             "1. Fridge\n" +
		         "2. Air Conditioner\n"+
		         "3. Washer\n"+
		         "4. Dryer\n"+
		         "5. Freezer\n"+
		         "6. Stove\n"+
		         "7. Disherwasher\n"+
		         "8. Water Heaters\n"+
		         "9. Microwave");
		       checkInt();
		       optionT = keyIn.nextInt();
		       
	         }
	     while(optionT < 1 || optionT > 9);
		
				
		 String type = "";
		 switch(optionT) 
		    {
			      case 1: type = "Fridge"; break;
				  case 2: type = "Air Conditioner"; break;
				  case 3: type = "Washer"; break;
				  case 4: type = "Dryer"; break;
				  case 5: type = "Freezer"; break;
				  case 6: type = "Stove" ; break;
				  case 7: type = "Disherwasher"; break;
				  case 8: type = "Water Heaters"; break;
				  case 9: type = "Microwave"; break;
				  default: break;
		    }
		return type;
		
    
     }
     /**
      * uses to check the users' keyboard input is valid integer number, prompt users to enter again if invalid.
      */
      public static void checkInt() {
    	  while(!(keyIn.hasNextInt())) {
				System.out.println("Invalid Enter! please enter number, example(4, not four )!");
				keyIn.next();
			}
      }
      
      /**
       * uses to check the users' keyboard input is valid Long number, prompt users to enter again if invalid.
       */
       public static void checkLong() {
     	  while(!(keyIn.hasNextLong())) {
 				System.out.println("Invalid Enter! please enter number, example(1000000, not ONE Million)!");
 				keyIn.next();
 			}
       }
      /**
       * uses to check the users' keyboard input is valid double number, prompt users to enter again if invalid.
       */
      public static void checkDouble() {
    	  while(!(keyIn.hasNextDouble())) {
				System.out.println("Invalid Enter! please enter number, example(4.0, not four point zero )!");
				keyIn.next();
			}
      }

}	