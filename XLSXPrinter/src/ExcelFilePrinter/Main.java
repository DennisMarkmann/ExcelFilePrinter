package ExcelFilePrinter;

import Gui.FileChooser;
import Storage.Pojo;

public class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Pojo pojo = new Pojo();
        new FileChooser().chooseFile(pojo);

    }
}
