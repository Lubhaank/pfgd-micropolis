package micropolisj.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import micropolisj.engine.Micropolis;

public class LoanAmountEntryPane extends JDialog {
	
	int amount;
	
	String amountS;
	
	JTextField textField;
	
	JButton enterBtn;
	
	Micropolis engine;
	
	MainWindow owner;
	
	public LoanAmountEntryPane(MainWindow owner, Micropolis engine) {
		
		super(owner);
		
		this.engine = engine;
		
		this.owner = owner;
		
		setTitle("Loan Amount");
		setModal(true);
		
		JPanel p1 = new JPanel(new BorderLayout());
		p1.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		getContentPane().add(p1, BorderLayout.CENTER);
		
		
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		textField = new JTextField(10);
		p1.add(textField, BorderLayout.WEST);
		JButton btn;
		btn = new JButton("Enter");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				onEnterClicked();
			}});
		btn.setEnabled(true);
		buttonPane.add(btn);
		enterBtn = btn;
		
		pack();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(owner);
		getRootPane().registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}},
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
			JComponent.WHEN_IN_FOCUSED_WINDOW);
		
	}
	
	private void onEnterClicked() {
		
		
		amount = Integer.parseInt(textField.getText());
		
		owner.setEngine(engine);
		dispose();
	}
	public int getamount() {
		
		return amount;
	}
	
	
	
	
	
	
	

}
