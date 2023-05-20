/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package animation;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class IsEDTExample extends JPanel {
  private boolean keepRunning;

  private static int RED = 0;

  private static int BLUE = 1;

  private static int GREEN = 2;

  private static int VARIABLE = 3;

  private static int SIZE = 3;

  private int threadShade;

  private ColorTableModel tableModel= new ColorTableModel();

  private Thread colorShadeThread;

  public IsEDTExample() {
    JTable table = new JTable(tableModel);
    table.setRowHeight(100);
    table.setDefaultRenderer(Object.class, new ColorRenderer());
    add(table);

    add(new JLabel("Thread Color Shade:"));
    ButtonGroup group = new ButtonGroup();
    JRadioButton redOption = new JRadioButton("Red");
    group.add(redOption);
    redOption.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        threadShade = RED;
      }
    });

    JRadioButton blueOption = new JRadioButton("Blue");
    group.add(blueOption);
    blueOption.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        threadShade = BLUE;
      }
    });

    JRadioButton greenOption = new JRadioButton("Green");
    group.add(greenOption);
    greenOption.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        threadShade = GREEN;
      }
    });

    redOption.setSelected(true);
    this.threadShade = RED;

    add(redOption);
    add(greenOption);
    add(blueOption);

    add(new JButton(new RandomColorAction()));

    this.keepRunning = true;
    this.colorShadeThread = new Thread(new RandomColorShadeRunnable());
    this.colorShadeThread.start();
  }

  private class RandomColorAction extends AbstractAction {
    public RandomColorAction() {
      super("Create Random Color");
    }

    public void actionPerformed(ActionEvent e) {
      IsEDTExample.this.tableModel.generateRandomColor(VARIABLE);
    }
  }

  private class ColorTableModel extends AbstractTableModel {
    private Color[][] colors = new Color[3][3];

    public ColorTableModel() {
      for (int i = 0; i < SIZE; i++) {
        for (int x = 0; x < SIZE; x++) {
          colors[i][x] = Color.white;
        }
      }
    }

    public int getRowCount() {
      return SIZE;
    }

    public int getColumnCount() {
      return SIZE;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
      return colors[rowIndex][columnIndex];
    }

    public void generateRandomColor(int type) {
      Random random = new Random(System.currentTimeMillis());
      final int row = random.nextInt(SIZE);
      final int column = random.nextInt(SIZE);
      final Color color;
      if (type == RED) {
        color = new Color(random.nextInt(256), 0, 0);
      } else if (type == BLUE) {
        color = new Color(0, 0, random.nextInt(256));
      } else if (type == GREEN) {
        color = new Color(0, random.nextInt(256), 0);
      } else {
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
      }

      if (SwingUtilities.isEventDispatchThread()) {
        colors[row][column] = color;
        fireTableCellUpdated(row, column);
      } else {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            colors[row][column] = color;
            fireTableCellUpdated(row, column);
          }
        });
      }
    }
  }

  private class ColorRenderer implements TableCellRenderer {
    private JLabel label;

    public ColorRenderer() {
      label = new JLabel();
      label.setOpaque(true);
      label.setPreferredSize(new Dimension(100, 100));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
      label.setBackground((Color) value);
      return label;
    }
  }

  private class RandomColorShadeRunnable implements Runnable {
    public void run() {
      while (keepRunning) {
        tableModel.generateRandomColor(threadShade);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
    }
  }

  public static void main(String[] a) {
    JFrame f = new JFrame("Is Event Dispatch Thread Example");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new IsEDTExample());
    f.pack();
    f.setVisible(true);
  }

}
           
         
    
    
    