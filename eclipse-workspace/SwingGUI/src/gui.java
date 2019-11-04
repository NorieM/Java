
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

class gui {
    public static void main(String args[]) {
        displayJFrame();
    }

    static void displayJFrame() {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JButton button = new JButton("Press");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/centre the jdialog when the button is pressed

                JFileChooser getfilename = new JFileChooser();

                getfilename.setMultiSelectionEnabled(true);

                FileNameExtensionFilter xlfilter = new FileNameExtensionFilter("Excel Workbooks", "xlsm");

                getfilename.setFileFilter(xlfilter);

                int returnval = getfilename.showOpenDialog(frame);

                if (returnval == JFileChooser.APPROVE_OPTION) {
                    Arrays.asList(getfilename.getSelectedFiles()).forEach(file -> {
                        System.out.println(file.getName());
                    });

                }

            }
        });

        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}