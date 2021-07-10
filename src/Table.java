import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Table extends JFrame{
    private JPanel tpan;
    private JTextArea table;
    private List<List<Cell>> arr;
    private String s1,s2;
    Object[][] array;
    String[] col;
    Vector<String> h=new Vector<>();
    Vector<Vector<Object>> hh=new Vector<>();
    public Table(List<List<Cell>> arrr,String st1, String st2){
        add(tpan);
        setSize(300,300);
        setLocationRelativeTo(null);
        arr = arrr;
        s1=st1;
        s2=st2;
        ImageIcon icn = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("dna.png")));
        setIconImage(icn.getImage());

        array = new Object[s2.length()][s1.length()+1];

        for (int i=0;i<array.length;i++){
            array[i][0]=s2.charAt(i);

        }

        for(int i=0;i<array.length;i++){
            for(int j=1;j<array[0].length;j++){
                array[i][j]=arr.get(i).get(j-1).getCellScore();
            }
        }
        String op="";
        System.out.println();
        for (Object o[] : array){
            for (Object b:o){
                op+=" "+ b +" ";
            }
            op=op+"\n";
        }
        col = new String[s1.length()];
        for(int i=0;i<s1.length();i++){
            col[i] = String.valueOf(s1.charAt(i));
        }
        String c=" * ";
        for (String s : col){
            c = c + " "+s+" ";
        }
        c= c+"\n";
        table.setText(c+op);
    }
}
