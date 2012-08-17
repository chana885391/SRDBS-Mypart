
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class ProgressBar {
    public static void main(String args[]) {
    JFrame f = new JFrame("JProgressBar Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = f.getContentPane();
    JProgressBar progressBar = new JProgressBar();
    progressBar.setValue(25);
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Reading...");
    progressBar.setBorder(border);
    content.add(progressBar, BorderLayout.NORTH);
    f.setSize(300, 100);
    f.setVisible(true);
  }

}
