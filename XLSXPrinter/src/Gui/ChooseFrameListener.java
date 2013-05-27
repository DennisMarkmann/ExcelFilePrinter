package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import ExcelFilePrinter.ExcelFileReader;
import ExcelFilePrinter.Pojo;
import Exceptions.SearchKeyNotFoundExpception;

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

        if (!this.field.getText().equals("") && this.field != null) {
            this.pojo.setSearchKey(this.field.getText());
        } else if (!this.chooser.getDate().equals("") && this.chooser != null) {
            this.pojo.setDateKey(this.chooser.getDate());
        } else {
            new SearchKeyNotFoundExpception("SearchKey muss gefüllt sein.").showDialog();
            return;
        }

        this.chooseFrame.dispose();

        try {
            new ExcelFileReader().readXLSXFile(this.pojo);
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }
}
