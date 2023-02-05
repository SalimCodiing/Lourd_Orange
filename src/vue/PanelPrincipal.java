package vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PanelPrincipal extends JPanel {
	//private JLabel lbTitre = new JLabel("Bonjour !");
	public PanelPrincipal(Color uneCouleur) {	
		this.setBounds(10,100,1200,800);
		this.setBackground(uneCouleur);
		this.setLayout(null);
		this.setVisible(false);
		//ImageIcon logo = new ImageIcon ("src/images/logo.png");
		//JLabel monLogo = new JLabel(logo);
		//monLogo.setBounds(50,300,400,400);
		//this.add(monLogo);
		//this.lbTitre.setBounds(500,350,400,290);
		//lbTitre.setFont( new Font("Bookman Old Style",Font.PLAIN, 50));
		//this.add(this.lbTitre);
	}
}
