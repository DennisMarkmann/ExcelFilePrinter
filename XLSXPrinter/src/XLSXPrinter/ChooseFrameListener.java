package XLSXPrinter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

public class ChooseFrameListener implements ActionListener {

    private final ChooseFrame chooseFrame;
    private final JTextField field;
    private final Pojo pojo;

    public ChooseFrameListener(final ChooseFrame chooseFrame, final JTextField field, final Pojo pojo) {

        this.chooseFrame = chooseFrame;
        this.field = field;
        this.pojo = pojo;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        this.chooseFrame.dispose();
        this.pojo.setSearchKey(this.field.getText());

        try {
            new ExcelFileReader().readXLSXFile(this.pojo);
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

}
