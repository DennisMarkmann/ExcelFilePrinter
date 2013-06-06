package dennis.markmann.ExcelFilePrinter;

import dennis.markmann.ExcelFilePrinter.Gui.FileChooser;
import dennis.markmann.ExcelFilePrinter.Storage.Pojo;

public final class Main { // NO_UCD (unused code)

    private Main() {

    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Pojo pojo = new Pojo();
        new FileChooser().chooseFile(pojo);

    }
}
