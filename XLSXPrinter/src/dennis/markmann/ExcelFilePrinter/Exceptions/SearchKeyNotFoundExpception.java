package dennis.markmann.ExcelFilePrinter.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception for empty or not existing SearchKeys.
 * 
 * @author it1-markde
 * @since JRE6
 */
public class SearchKeyNotFoundExpception extends Exception {

    private static final long serialVersionUID = -7263300464786494488L;

    public SearchKeyNotFoundExpception(final String message) {
        super(message);
    }

    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
