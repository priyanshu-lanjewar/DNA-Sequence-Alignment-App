import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class DNASequencing extends JFrame {
    private JLabel l1;
    private JPanel mainpanel;
    private JLabel l2;
    private JLabel l3;
    private JTextField seq1;
    private JTextField seq2;
    private JButton configButton;
    private JButton alignButton;
    private JButton tableButton;
    private JScrollPane sp;
    private JTextArea op;
     static int sim=1;
     static int notSim=-1;
     static int gap=0;
     private List<List<Cell>> m;
     private String sequ1,sequ2;



    public DNASequencing(){
        add(mainpanel);
        setTitle("DNA Sequence Alignment App");
        ImageIcon icn = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("dna.png")));
        setIconImage(icn.getImage());
        setLocationRelativeTo(null);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        alignButton.addActionListener(e -> {
            sequ1 = "_"+seq1.getText();
            sequ2 = "_"+seq2.getText();
            op.setText(AlignmentCall.Companion.makeCall(sequ1,sequ2,sim,notSim,gap));
            op.setDisabledTextColor(Color.BLUE);
            op.setAlignmentX(Component.CENTER_ALIGNMENT);
            m = AlignmentCall.Companion.getMatrix();

        });
        configButton.addActionListener(e -> {
            Configure cf = new Configure(sim,notSim,gap);
            cf.setVisible(true);
        });
        tableButton.addActionListener(e -> {

            ScoreMatrix ma = new ScoreMatrix(m,sequ1,sequ2);
            ScoreMatrix.Companion.getF().setVisible(false);
            ma.showMatrix();
        });
    }


}