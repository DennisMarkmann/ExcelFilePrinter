package Gui;

import java.awt.FileDialog;
import java.awt.Frame;

import ExcelFilePrinter.ProgrammRestarter;
import Exceptions.InputErrorExpception;
import Storage.Pojo;

public class FileChooser {

    public final void chooseFile(final Pojo pojo) {
        final FileDialog fd = new FileDialog(new Frame("XLSX Printer"), "");
        fd.setVisible(true);
        try {
            if ((fd.getFile().substring(fd.getFile().lastIndexOf(".") + 1, (fd.getFile().lastIndexOf(".") + 5)).equals("xlsx"))) {
                pojo.setPath(fd.getDirectory() + fd.getFile());
                new ChooseFrame(pojo);

            } else {
                new InputErrorExpception("Die Datei konnte nicht eingelesen werden. Bitte wählen Sie eine gültige XLSX-Datei").showDialog();
                new ProgrammRestarter().reStartFull();
                return;
            }
        } catch (final java.lang.StringIndexOutOfBoundsException e) {
            new InputErrorExpception("Die Datei konnte nicht eingelesen werden. Bitte wählen Sie eine gültige XLSX-Datei").showDialog();
            new ProgrammRestarter().reStartFull();
            return;
        }

    }
}
