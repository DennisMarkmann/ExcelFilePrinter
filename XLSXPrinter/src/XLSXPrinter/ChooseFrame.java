package XLSXPrinter;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChooseFrame extends JFrame {
	private static final long serialVersionUID = 6669957942758340961L;

	public ChooseFrame(final Pojo pojo) {

		this.setTitle("XLSX Printer - Dennis Markmann");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(150, 100);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);

		final JLabel searchKeyLabel = new JLabel("SearchKey:");
		final JTextField searchKeyField = new JTextField(15);
		final JButton commitButton = new JButton("Bestätigen");

		this.add(searchKeyLabel);
		this.add(searchKeyField);
		this.add(commitButton);

		commitButton.addActionListener(new ChooseFrameListener(this,
				searchKeyField, pojo));

		this.pack();
		this.setVisible(true);
	}
}
