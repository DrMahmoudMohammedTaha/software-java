/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highlighter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class HighLighter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bf;
        File file = new File("index-file");
        file.mkdirs();
        File work []= new File(file.getAbsolutePath().replace("\\index-file", "")).listFiles();
        for (int i = 0; i < work.length; i++) {
            if(work[i] .getName().contains(".htm") )
            {
                String data;
                  BufferedReader br = new BufferedReader(new FileReader(work[i]));
                  data = br.readLine();
                for (int j = 0; j < 10; j--) {
                    if(data.contains("</html>"))
                    {
                        break;}
                    data = data + " \n "+br.readLine();
                }
                String original  = "<script src=\"index-file/high.js\"></script>";
                data =data.substring(0,data.indexOf("</body>"))+ original +  data.substring(data.indexOf("</body>")) ;
                bf = new BufferedWriter(new FileWriter(work[i]));
                bf.write(data);
                bf.close();
            
            }
        }
        
        file = new File("index-file\\high.js");
        file.createNewFile();
       bf = new BufferedWriter(new FileWriter(file));
        String script = "document.onkeypress = function(evt) {\n"
                + "    evt = evt || window.event;\n"
                + "    var charCode = evt.keyCode || evt.which;\n"
                + "    var charStr = String.fromCharCode(charCode);\n"
                + "\n"
                + "if ( charStr == 'h' || charStr == 'H')\n"
                + "  {\n"
                + "\n"
                + "  	  selected = getSelectionText();\n"
                + "  	  stylizeHighlightedString();\n"
                + "  }\n"
                + "};\n"
                + "\n"
                + "\n"
                + "function getSelectionText() {\n"
                + "    var text = \"\";\n"
                + "    if (window.getSelection) {\n"
                + "        text = window.getSelection().toString();\n"
                + "    } else if (document.selection && document.selection.type != \"Control\") {\n"
                + "        text = document.selection.createRange().text;\n"
                + "    }\n"
                + "    return text;\n"
                + "}\n"
                + "\n"
                + "\n"
                + "\n"
                + "function stylizeHighlightedString() \n"
                + "{\n"
                + "  //alert(text.focusOffset - text.anchorOffset);\n"
                + "\n"
                + "  var text = window.getSelection();\n"
                + "  var start = text.anchorOffset;\n"
                + "  \n"
                + "  var end = text.focusOffset - text.anchorOffset;\n"
                + "  \n"
                + "  range = window.getSelection().getRangeAt(0);\n"
                + "  range1 = window.getSelection().toString();\n"
                + "  var selectionContents = range.extractContents();\n"
                + "  var span = document.createElement(\"span\");\n"
                + "\n"
                + "  span.appendChild(selectionContents);\n"
                + "\n"
                + "  span.setAttribute(\"class\", \"uiWebviewHighlight\");\n"
                + "  span.style.backgroundColor = \"yellow\";\n"
                + "  span.style.color = \"black\";\n"
                + "\n"
                + "  range.insertNode(span);\n"
                + "}\n"
                + "\n"
                + "";

        bf.write(script);
        bf.close();

    }

}
