/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import parsing.parser;
import static parsing.parser.tokens;

public class servent {

    final static JFrame mainFrm = GUI_Ruler2.addFrm(true, false, 10, 20, 1320, 700, "Scanner", "sky.jpg", null, true);
    final static JButton scan = GUI_Ruler2.addBtn(15, 10, 150, 50, "SCAN", mainFrm);
    final static JTextArea codeText = GUI_Ruler2.addtxt(300, 200, 300, 260, "", mainFrm);
    final static JTextArea tokenText = GUI_Ruler2.addtxt(300, 200, 350, 260, "", mainFrm);
    final static JTextArea IRText = GUI_Ruler2.addtxt(300, 200, 300, 260, "", mainFrm);
    final static JTextArea assemblyText = GUI_Ruler2.addtxt(300, 200, 300, 260, "", mainFrm);
    final static JTextArea semanticText = GUI_Ruler2.addtxt(300, 200, 450, 200, "", mainFrm);
    final static JTextArea symbolText = GUI_Ruler2.addtxt(300, 200, 300, 200, "", mainFrm);

    static JScrollPane holderCode;
    static JScrollPane holderToken;
    static JScrollPane holderIR;
    static JScrollPane holderAssembly;
    static JScrollPane holderSemantic;
    static JScrollPane holderSymbol;

    final static JLabel codelbl = GUI_Ruler2.addLbl(50, 50, 320, 50, "CODE", mainFrm);
    final static JLabel tokenlbl = GUI_Ruler2.addLbl(50, 50, 320, 50, "TOKENS", mainFrm);
    final static JLabel IRlbl = GUI_Ruler2.addLbl(50, 50, 320, 50, "IR CODE", mainFrm);
    final static JLabel assemblylbl = GUI_Ruler2.addLbl(50, 50, 320, 50, "ASSEMBLY", mainFrm);
    final static JLabel Semanticlbl = GUI_Ruler2.addLbl(50, 50, 450, 50, "SRMANTICS", mainFrm);
    final static JLabel symbollbl = GUI_Ruler2.addLbl(50, 50, 320, 50, "SYMBOL TABLE", mainFrm);

    public static String[] coder;

    public static String scanCode(String code) {

        coder = spliter(removeComments(code));
        return showToken(Definaton.matcher(coder));
    }

    public static String[] spliter(String s) {
        return s.replaceAll("\n", " \n ").split(" ");
    }

    public static String removeComments(String temp) {
        return temp.replaceAll("[//][/*][/*][\\w*\\W*]*[/*][/*][//]", "");
    }

    public static void start_gui() {

        GUI_Ruler2.makeVertical(scan, codelbl, codeText, Semanticlbl, semanticText);
        GUI_Ruler2.makeHorizontal(codelbl, tokenlbl, IRlbl, assemblylbl);
        GUI_Ruler2.makeHorizontal(codeText, tokenText, IRText, assemblyText);
        GUI_Ruler2.makeHorizontal(Semanticlbl, symbollbl);
        GUI_Ruler2.makeHorizontal(semanticText, symbolText);

        holderToken = new JScrollPane(tokenText);
        holderIR = new JScrollPane(IRText);
        holderAssembly = new JScrollPane(assemblyText);
        holderCode = new JScrollPane(codeText);
        holderSemantic = new JScrollPane(semanticText);
        holderSymbol = new JScrollPane(symbolText);

        holderCode.setBounds(codeText.getX(), codeText.getY(), codeText.getWidth(), codeText.getHeight());
        holderToken.setBounds(tokenText.getX(), tokenText.getY(), tokenText.getWidth(), tokenText.getHeight());
        holderIR.setBounds(IRText.getX(), IRText.getY(), IRText.getWidth(), IRText.getHeight());
        holderAssembly.setBounds(assemblyText.getX(), assemblyText.getY(), assemblyText.getWidth(), assemblyText.getHeight());
        holderSemantic.setBounds(semanticText.getX(), semanticText.getY(), semanticText.getWidth(), semanticText.getHeight());
        holderSymbol.setBounds(symbolText.getX(), symbolText.getY(), symbolText.getWidth(), symbolText.getHeight());

        holderToken.repaint();
        mainFrm.add(holderToken, 0);

        holderIR.repaint();
        mainFrm.add(holderIR, 0);

        holderAssembly.repaint();
        mainFrm.add(holderAssembly, 0);

        holderCode.repaint();
        mainFrm.add(holderCode, 0);

        holderSemantic.repaint();
        mainFrm.add(holderSemantic, 0);

        holderSymbol.repaint();
        mainFrm.add(holderSymbol, 0);

        Component comnts[] = mainFrm.getComponents();
        for (int i = 0; i < comnts.length; i++) {
            comnts[i].repaint();
            mainFrm.repaint();

        }

        codeText.setLineWrap(true);
        tokenText.setLineWrap(true);
        IRText.setLineWrap(true);
        assemblyText.setLineWrap(true);
        semanticText.setLineWrap(true);
        symbolText.setLineWrap(true);

        scan.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                boolean temp = parser.parse(scanCode(readCode()));
                System.out.println("Parser result: " + temp);
                if (temp) {
                    String line = "\n       --------------------------------------\n";
                    semanticText.setText(semantic.semant.semantic_ana(tokens));
                    symbolText.setText(semantic.semant.get_vars());
                    System.out.println(line + IR.IR_factory.getIRAssembly());
                    IRText.setText(IR.IR_factory.getIR());
                    assemblyText.setText(IR.IR_factory.getAssembly());

                }
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

        }
        );

    }

    public static String readCode() {
        return codeText.getText();
    }

    public static String showToken(String temp) {

        tokenText.setText(temp);
        return temp;
    }

    public static String readCode_inline() {
        Scanner x = new Scanner(System.in);
        String code = "";
        String temp = "";
        while (!temp.equals("endmain")) {
            temp = x.nextLine();
            code += temp;
        }
        System.out.println(code);
        return code;
    }

}
