package XLSXPrinter;

import javax.swing.JOptionPane;

/**
 * Exception bei leeren oder nicht gefundenen SearchKeys.
 * 
 * @author it1-markde
 * @since JRE6
 */
public class SearchKeyNotFoundExpception extends Exception {

    private static final long serialVersionUID = -7263300464786494488L;

    public SearchKeyNotFoundExpception(final String message) {
        super(message);
    }

    public void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
