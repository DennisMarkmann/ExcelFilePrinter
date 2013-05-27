package Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception for corrupt or wrong files.
 * 
 * @author it1-markde
 * @since JRE6
 */
public class InputErrorExpception extends Exception {

    private static final long serialVersionUID = -7263300464786494488L;

    public InputErrorExpception(final String message) {
        super(message);
    }

    public void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
