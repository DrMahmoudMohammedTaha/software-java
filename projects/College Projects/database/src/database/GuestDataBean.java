// Fig. 27.21: GuestDataBean.java
// Class GuestDataBean makes a database connection and supports 
// inserting and retrieving data from the database.
package database;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import com.sun.rowset.CachedRowSetImpl; // CachedRowSet implementation

public class GuestDataBean 
{
   private CachedRowSet rowSet;

   // construct TitlesBean object 
   public GuestDataBean() throws Exception
   {
      // load the MySQL driver
      Class.forName( "com.mysql.jdbc.Driver" );
      
      // specify properties of CachedRowSet
      rowSet = new CachedRowSetImpl();  
      rowSet.setUrl( "jdbc:mysql://localhost/guestbook" ); 
      rowSet.setUsername( "jhtp6" );
      rowSet.setPassword( "jhtp6" );

	  // obtain list of titles
      rowSet.setCommand( 
         "SELECT firstName, lastName, email FROM guests" );
      rowSet.execute();
   } // end GuestDataBean constructor

   // return an ArrayList of GuestBeans
   public ArrayList< GuestBean > getGuestList() throws SQLException
   {
      ArrayList< GuestBean > guestList = new ArrayList< GuestBean >();

      rowSet.beforeFirst(); // move cursor before the first row

      // get row data
      while ( rowSet.next() ) 
      {
         GuestBean guest = new GuestBean();

         guest.setFirstName( rowSet.getString( 1 ) );
         guest.setLastName( rowSet.getString( 2 ) );
         guest.setEmail( rowSet.getString( 3 ) );

         guestList.add( guest ); 
      } // end while

      return guestList;
   } // end method getGuestList
   
   // insert a guest in guestbook database
   public void addGuest( GuestBean guest ) throws SQLException
   {
      rowSet.moveToInsertRow(); // move cursor to the insert row

      // update the three columns of the insert row 
      rowSet.updateString( 1, guest.getFirstName() ); 
      rowSet.updateString( 2, guest.getLastName() ); 
      rowSet.updateString( 3, guest.getEmail() ); 
      rowSet.insertRow(); // insert row to rowSet
      rowSet.moveToCurrentRow(); // move cursor to the current row
      rowSet.acceptChanges(); // propagate changes to database
   } // end method addGuest
} // end class GuestDataBean


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
