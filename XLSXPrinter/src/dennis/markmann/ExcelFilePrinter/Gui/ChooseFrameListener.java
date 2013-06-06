package dennis.markmann.ExcelFilePrinter.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import dennis.markmann.ExcelFilePrinter.ExcelFileReader;
import dennis.markmann.ExcelFilePrinter.ProgrammRestarter;
import dennis.markmann.ExcelFilePrinter.Exceptions.InputErrorExpception;
import dennis.markmann.ExcelFilePrinter.Exceptions.SearchKeyNotFoundExpception;
import dennis.markmann.ExcelFilePrinter.Storage.Pojo;

class ChooseFrameListener implements ActionListener {

    private final ChooseFrame chooseFrame;
    private final JTextField field;
    private final Pojo pojo;
    private final JDateChooser chooser;

    ChooseFrameListener(final ChooseFrame chooseFrame, final JTextField field, final Pojo pojo, final JDateChooser chooser) {

        this.chooseFrame = chooseFrame;
        this.field = field;
        this.pojo = pojo;
        this.chooser = chooser;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {
        try {
            if ((this.field.getText() == null || this.field.getText().equals(""))
                    && (this.chooser.getDate() == null || this.chooser.getDate().equals(""))) {
                new SearchKeyNotFoundExpception("SearchKey oder Datum muss gefüllt sein.").showDialog();
                return;
            } else if (this.field.getText() != null && !this.field.getText().equals("")) {
                this.pojo.setSearchKey(this.field.getText());
            } else if (this.chooser.getDate() != null && !this.chooser.getDate().equals("")) {
                this.pojo.setDateKey(this.chooser.getDate());
            }
        } catch (final java.lang.NullPointerException e) {
            new SearchKeyNotFoundExpception("Bitte geben Sie ein gültiges Datum oder einen searchKey an.").showDialog();
            return;
        }
        this.chooseFrame.dispose();

        try {
            new ExcelFileReader().readXLSXFile(this.pojo);
        } catch (final IOException e) {
            new InputErrorExpception("Fehler bei der Dateiauswahl.").showDialog();
            new ProgrammRestarter().reStartFull();
            return;
        }

    }
}
