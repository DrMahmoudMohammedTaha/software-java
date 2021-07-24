// Fig. 27.20: GuestBean.java
// JavaBean to store data for a guest in the guest book.
package database;

public class GuestBean 
{
   private String firstName;
   private String lastName;
   private String email;

   // set the guest's first name
   public void setFirstName( String name )
   {
      firstName = name;  
   } // end method setFirstName
   
   // get the guest's first name
   public String getFirstName()
   {
      return firstName;  
   } // end method getFirstName

   // set the guest's last name
   public void setLastName( String name )
   {
      lastName = name;  
   } // end method setLastName

   // get the guest's last name
   public String getLastName()
   {
      return lastName;  
   } // end method getLastName

   // set the guest's email address
   public void setEmail( String address )
   {
      email = address;
   } // end method setEmail

   // get the guest's email address
   public String getEmail()
   {
      return email;  
   } // end method getEmail
} // end class GuestBean


 /**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
