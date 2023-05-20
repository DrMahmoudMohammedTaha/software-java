// Fig. 28.28: DisplayQueryResults.java
// Display the contents of the Authors table in the books database.

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;


public class DisplayQueryResults extends JFrame {

    // database URL, username and password
    static final String DATABASE_URL  = "jdbc:mysql://localhost/books";
    static final String USERNAME  = "deitel";
    static final String PASSWORD  = "deitel";

}
