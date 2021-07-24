package javaapplication25;

// Fig. 25.25: DisplayAuthors.java
// Displaying the contents of the authors table.
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors 
{
   // JDBC driver name and database URL                              
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
   static final String DATABASE_URL = "jdbc:mysql://localhost/books";
   
   // launch the application
   public static void main( String args[] )
   {
      Connection connection = null; // manages connection
      Statement statement = null; // query statement

      // connect to database books and query database
      try 
      {
         Class.forName( JDBC_DRIVER ); // load database driver class

         // establish connection to database
         connection = 
            DriverManager.getConnection( DATABASE_URL, "jhtp6", "jhtp6" );

         // create Statement for querying database
         statement = connection.createStatement();
         
         // query database
         ResultSet resultSet = statement.executeQuery( 
            "SELECT authorID, firstName, lastName FROM authors" );
         
         // process query results
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
         System.out.println( "Authors Table of Books Database:" );

         for ( int i = 1; i <= numberOfColumns; i++ )
            System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
         System.out.println();
         
         while ( resultSet.next() ) 
         {
            for ( int i = 1; i <= numberOfColumns; i++ )
               System.out.printf( "%-8s\t", resultSet.getObject( i ) );
            System.out.println();
         } // end while
      }  // end try
      catch ( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
      catch ( ClassNotFoundException classNotFound ) 
      {
         classNotFound.printStackTrace();            
         System.exit( 1 );
      } // end catch
      finally // ensure statement and connection are closed properly
      {                                                             
         try                                                        
         {                                                          
            statement.close();                                      
            connection.close();                                     
         } // end try                                               
         catch ( Exception exception )                        
         {                                                          
            exception.printStackTrace();                                     
            System.exit( 1 );                                       
         } // end catch                                             
      } // end finally                  
   } // end main
}  // end class DisplayAuthors


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

 