package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import ExcelFilePrinter.ExcelFileReader;
import Exceptions.SearchKeyNotFoundExpception;
import Storage.Pojo;

import com.toedter.calendar.JDateChooser;

public class ChooseFrameListener implements ActionListener {

    private final ChooseFrame chooseFrame;
    private final JTextField field;
    private final Pojo pojo;
    private final JDateChooser chooser;

    public ChooseFrameListener(
            final ChooseFrame chooseFrame,
            final JTextField field,
            final Pojo pojo,
            final JDateChooser chooser) {

        this.chooseFrame = chooseFrame;
        this.field = field;
        this.pojo = pojo;
        this.chooser = chooser;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        if ((this.field == null || this.field.equals("")) && (this.chooser == null || this.chooser.equals(""))) {
            new SearchKeyNotFoundExpception("SearchKey oder Datum muss gefüllt sein.").showDialog();
            return;
        } else if (this.field != null && !this.field.equals("")) {
            this.pojo.setSearchKey(this.field.getText());
        } else if (this.chooser != null && !this.chooser.equals("")) {
            this.pojo.setDateKey(this.chooser.getDate());
        }

        this.chooseFrame.dispose();

        try {
            new ExcelFileReader().readXLSXFile(this.pojo);
        } catch (final IOException e) {
            System.exit(1);
        }

    }
}
