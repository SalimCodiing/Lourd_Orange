package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Orange;

public class VueGenerale extends JFrame implements ActionListener {
	private JPanel panelMenu= new JPanel();
	private JButton btClients = new JButton("Gestion Clients");
	private JButton btTechniciens = new JButton("Gestion Techniciens");
	private JButton btInterventions = new JButton("Gestion Interventions");
	private JButton btStats = new JButton("Statistiques");
	private JButton BtProfil = new JButton("Mon Profil");
	private JButton btQuitter = new JButton("Quitter");
	
	private static PanelProfil unPanelProfil = new PanelProfil();
	private static PanelInterventions unPanelInterventions = new PanelInterventions();
	private static PanelClients unPanelClients = new PanelClients();
	private static PanelTechniciens unPanelTechniciens = new PanelTechniciens();
	private static PanelStats unPanelStats = new PanelStats();
	
	public VueGenerale() {
		this.setTitle("Gestion des interventions");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground( new Color(20,103,240));
		this.setBounds(100,100, 1200, 700);
		this.setLayout(null);
		
		//construction du panel menu
		this.panelMenu.setBounds(150,20,1000,40);
		this.panelMenu.setBackground(new Color(255,184,51));
		this.panelMenu.setLayout(new GridLayout(1,5));
		this.panelMenu.add(BtProfil);
		this.panelMenu.add(btClients);
		this.panelMenu.add(btTechniciens);
		this.panelMenu.add(btInterventions);
		this.panelMenu.add(btStats);
		this.panelMenu.add(btQuitter);
		this.add(this.panelMenu);
		// rendre les boutons ecoutables
		this.btQuitter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btTechniciens.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btStats.addActionListener(this);
		this.BtProfil.addActionListener(this);
		
		//insertions des panneaux dans la fenetre
		this.add(unPanelClients);
		this.add(unPanelProfil);
		this.add(unPanelTechniciens);
		this.add(unPanelInterventions);
		this.add(unPanelStats);
		
		
		this.setVisible(false);
	}
	public static void activerPanel(int choix) {
		unPanelProfil.setVisible(false);
		unPanelClients.setVisible(false);
		unPanelTechniciens.setVisible(false);
		unPanelInterventions.setVisible(false);
		unPanelStats.setVisible(false);
		switch(choix) {
		case 1: unPanelProfil.setVisible(true);break;
		case 2: unPanelClients.setVisible(true);break;
		case 3: unPanelTechniciens.setVisible(true);break;
		case 4: unPanelInterventions.setVisible(true);break;
		case 5: unPanelStats.setVisible(true);break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btQuitter){
			int retour = JOptionPane.showConfirmDialog(this,"Voulez vous vraiment quitter l'application ?",
					"Quitter l'application",JOptionPane.YES_NO_CANCEL_OPTION);
			if(retour == 0) {
				this.dispose();
				Orange.gererVueConnexion(true);
			}
			
		}
		else if(e.getSource()== this.BtProfil) {
			activerPanel(1);
		}
		else if(e.getSource()== this.btClients) {
			activerPanel(2);
		}
		else if(e.getSource()== this.btTechniciens) {
			activerPanel(3);
		}
		else if(e.getSource()== this.btInterventions) {
			activerPanel(4);
		}
		else if(e.getSource()== this.btStats) {
			activerPanel(5);
		}
		
	}
}
