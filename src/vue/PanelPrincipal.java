package vue;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelPrincipal extends JPanel{
	public PanelPrincipal(Color uneCouleur) {
		this.setBounds(100,100,900,500);
		this.setBackground(uneCouleur);
		this.setLayout(null);
		this.setVisible(false);
	}
}
