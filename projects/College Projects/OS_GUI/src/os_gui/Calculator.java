package os_gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator {

    private static int in1 = 0, in2 = 0;
    public static String operation = "";
    private static boolean visited = false, first = true;
    private static JFrame cal = GUI_Ruler.addFrm(false, false, 300, 100, 250, 600,
            "Calculator", "CAL_BACK.jpg", "CAL_ICON.png", false, false, false);
    private static JButton btnArr[] = new JButton[20];
    private static JLabel screen = GUI_Ruler.addLbl(20, 20, 150, 50, null, cal);

    public static String opcodes[] = {"+", "-", "*", "/", "sin", "cos", "tan", "^", "ln"};

    private static void arrangeCalculator() {

        for (int i = 0; i < 10; i++) {
            btnArr[i] = GUI_Ruler.addBtn(10, 10, 60, 60, i + "", null, cal);
            final int temper = i;
            btnArr[i].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {

                    int temp = (first) ? in1 : in2;
                    temp *= 10;
                    temp += Integer.parseInt(btnArr[temper].getText());
                    if (first) {
                        in1 = temp;
                    } else {
                        in2 = temp;
                    }
                    screen.setText(temp + "");
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                }

                @Override
                public void mouseExited(MouseEvent me) {
                }

            });

        }

        btnArr[10] = GUI_Ruler.addBtn(10, 10, 60, 60, "=", null, cal);
        btnArr[10].addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                
                chooser(operation);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        for (int i = 11; i < 20; i++) {
            btnArr[i] = GUI_Ruler.addBtn(10, 10, 60, 60, opcodes[i - 11], null, cal);
            final int temper = i - 11;
            btnArr[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    operation = opcodes[temper];
                    first = !first;
                    screen.setText("");
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                }

                @Override
                public void mouseExited(MouseEvent me) {
                }

            });

        }

        GUI_Ruler.makeVertical(screen, btnArr[0], btnArr[3], btnArr[6], btnArr[9], btnArr[11], btnArr[14], btnArr[17]);
        for (int i = 0; i < 9; i += 3) {
            GUI_Ruler.makeHorizontal(20, btnArr[i], btnArr[i + 1], btnArr[i + 2]);
        }

        GUI_Ruler.makeHorizontal(20, btnArr[9], btnArr[10]);
        GUI_Ruler.makeHorizontal(20, btnArr[11], btnArr[12], btnArr[13]);
        GUI_Ruler.makeHorizontal(20, btnArr[14], btnArr[15], btnArr[16]);
        GUI_Ruler.makeHorizontal(20, btnArr[17], btnArr[18], btnArr[19]);
        cal.setVisible(true);

    }

    public static void viewCalculator() {
        if (!visited) {
            arrangeCalculator();
        } else {
            cal.setVisible(true);
        }
    }

    private static void chooser(String s) {
        switch (s) {
            case "+":
                screen.setText(add(in1, in2) + "");
                break;
            case "-":
                screen.setText(sub(in1, in2) + "");
                break;
            case "*":
                screen.setText(mul(in1, in2) + "");
                break;
            case "/":
                screen.setText(div(in1, in2) + "");
                break;
            case "sin":
                screen.setText(sin(in1) + "");
                break;
            case "cos":
                screen.setText(cos(in1) + "");
                break;
            case "tan":
                screen.setText(tan(in1) + "");
                break;
            case "^":
                screen.setText(power(in1, in2) + "");
                break;
            case "ln":
                screen.setText(ln(in1) + "");
                break;
        }
        in1 = in2 = 0;
        operation = "";
        first = false;
    }

    private static double add(double input1, double input2) {
        return input1 + input2;
    }

    private static double sub(double input1, double input2) {
        return input1 - input2;
    }

    private static double div(double input1, double input2) {
        if (input2 == 0) {
            return 0;
        }
        return input1 / input2;
    }

    private static double mul(double input1, double input2) {

        return input1 * input2;
    }

    private static double power(double num, int power) {

        return Math.pow(num, power);
    }

    private static double sin(double num) {

        return Math.sin(num);
    }

    private static double cos(double num) {

        return Math.cos(num);
    }

    private static double tan(double num) {

        return Math.tan(num);
    }

    private static double ln(double num) {

        return Math.log(num);
    }

}
