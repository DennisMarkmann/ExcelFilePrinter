package ExcelFilePrinter;

import Gui.ChooseFrame;
import Gui.FileChooser;
import Storage.Pojo;

public class ProgrammRestarter {

    final void reStart(final Pojo pojo) {
        final String path = pojo.getPath();
        final Pojo newPojo = new Pojo();
        newPojo.setPath(path);
        new ChooseFrame(pojo);

    }

    public final void reStartFull() {
        final Pojo pojo = new Pojo();
        new FileChooser().chooseFile(pojo);
    }
}
