import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class UserInterfaceHex extends UserInterface {

	public UserInterfaceHex(CalcEngine engine) {
		super(engine);
	}

	@Override
	protected void makeFrame() {
		super.makeFrame();
		JPanel contentPane = (JPanel) frame.getContentPane();
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));

		addButton(buttonPanel, "a");
		addButton(buttonPanel, "b");
		addButton(buttonPanel, "c");
		addButton(buttonPanel, "d");
		addButton(buttonPanel, "e");
		addButton(buttonPanel, "f");

		contentPane.add(buttonPanel, BorderLayout.WEST);
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("a") 
				|| command.equals("b") 
				|| command.equals("c") 
				|| command.equals("d")
				|| command.equals("e") 
				|| command.equals("f")){
			int number = Integer.parseInt(command, 16);
			calc.numberPressed(number);
			redisplay();
		} else {
			super.actionPerformed(event);
		}
	}
    // Convert display value integer to hex string and set it to display
	@Override
	protected void redisplay() {	
		display.setText(Integer.toHexString(calc.getDisplayValue()).toUpperCase());
	}
	

}
