package XLSXPrinter;

import java.awt.FileDialog;
import java.awt.Frame;

public class FileChooser {

    public void chooseFile(final Pojo pojo) {
        final FileDialog fd = new FileDialog(new Frame(), "");
        fd.setVisible(true);
        pojo.setPath(fd.getDirectory() + fd.getFile());

    }
}
