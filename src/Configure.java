import javax.swing.*;
import java.util.Objects;


public class Configure extends JFrame {
    private JPanel p1;
    private JSpinner gapScr;
    private JSpinner notSimScr;
    private JSpinner simScr;
    private JButton updateButton;
    private JButton defaultButton;

    public Configure(int sim, int notSim, int gap){
        add(p1);
        setSize(300,220);
        simScr.setValue(sim);
        notSimScr.setValue(notSim);
        gapScr.setValue(gap);
        ImageIcon icn = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("dna.png")));
        setIconImage(icn.getImage());
        setLocationRelativeTo(null);

        defaultButton.addActionListener(e -> {
            DNASequencing.notSim = -1;
            DNASequencing.sim = 1;
            DNASequencing.gap = 0;
            this.setVisible(false);
        });
        updateButton.addActionListener(e -> {
            DNASequencing.notSim = (int) notSimScr.getValue();
            DNASequencing.sim = (int) simScr.getValue();
            DNASequencing.gap = (int) gapScr.getValue();
            this.setVisible(false);
        });
    }
}
