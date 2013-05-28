package Gui;

import java.awt.FileDialog;
import java.awt.Frame;

import Storage.Pojo;

public class FileChooser {

    public void chooseFile(final Pojo pojo) {
        final FileDialog fd = new FileDialog(new Frame(), "");
        fd.setVisible(true);

        pojo.setPath(fd.getDirectory() + fd.getFile());

    }
}
