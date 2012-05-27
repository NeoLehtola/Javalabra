
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author neom
 */
public class VuoroKuuntelija implements ActionListener {
    
    private int vuorot;
    private JLabel label;
    
    public VuoroKuuntelija(int vuorot, JLabel label) {
        this.label = label;
        this.vuorot = vuorot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.label.setText(this.vuorot + "");
    }
    
}
