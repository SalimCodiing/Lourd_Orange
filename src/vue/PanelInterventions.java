package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.C_Client;
import controller.C_Intervention;
import controller.C_Technicien;
import controller.Client;
import controller.Intervention;
import controller.Technicien;

public class PanelInterventions extends PanelPrincipal implements ActionListener{
	private JPanel panelForm = new JPanel();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTextField txtMateriel = new JTextField();
	private JTextField txtPanne= new JTextField();
	private JTextField txtDate = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrix = new JTextField();
	private JComboBox<String> cbxIdClient = new JComboBox<String>();
	private JComboBox<String> cbxIdTechnicien = new JComboBox<String>();
	
	public PanelInterventions() {
		super(new Color (255,184,51));
		
		//Construcyion du panelform
		this.panelForm.setBounds(40,80,300,300);
		this.panelForm.setLayout( new GridLayout(7,2));
		
		this.panelForm.add(new JLabel("Matériel:"));
		this.panelForm.add(this.txtMateriel);
		this.panelForm.add(new JLabel("Panne:"));
		this.panelForm.add(this.txtPanne);
		this.panelForm.add(new JLabel("Prix:"));
		this.panelForm.add(this.txtPrix);
		this.panelForm.add(new JLabel("Date Intervention:"));
		this.panelForm.add(this.txtDate);
		this.panelForm.add(new JLabel("Le client:"));
		this.panelForm.add(this.cbxIdClient);
		this.panelForm.add(new JLabel("Le technicien:"));
		this.panelForm.add(this.cbxIdTechnicien);
		this.panelForm.add(btAnnuler);
		this.panelForm.add(btEnregistrer);
		this.add(this.panelForm);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);

		
		//remplir les comboBox
		this.remplirCBX();
		
		
	}
	public void remplirCBX() {
		this.cbxIdClient.removeAllItems();
		this.cbxIdTechnicien.removeAllItems();
		ArrayList<Client> lesClients = C_Client.selectAllClients("");
		for(Client unClient : lesClients) {
			this.cbxIdClient.addItem(unClient.getIdclient()+"-"+unClient.getNom()+"-"+unClient.getPrenom());
		}
		ArrayList<Technicien> lesTechniciens = C_Technicien.selectAllTechniciens("");
		for(Technicien unTechnicien : lesTechniciens) {
			this.cbxIdTechnicien.addItem(unTechnicien.getIdtechnicien()+"-"+unTechnicien.getNom()+"-"+unTechnicien.getPrenom());
		}
	}
	public void viderChamps() {
		this.txtMateriel.setText("");
		this.txtPanne.setText("");
		this.txtDate.setText("");
		this.txtPrix.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btAnnuler) {
			this.viderChamps();
		}
		else if(e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String materiel = this.txtMateriel.getText();
			String panne = this.txtPanne.getText();
			String dateinter = this.txtDate.getText();
			float prix = 0;
			try {
				prix = Float.parseFloat(this.txtPrix.getText());
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de prix");
			}
			// récupération des id client et id technicien
			String chaine = this.cbxIdClient.getSelectedItem().toString();
			String tab [] = chaine.split("-");
			int idclient = Integer.parseInt(tab[0]);
			
			chaine = this.cbxIdTechnicien.getSelectedItem().toString();
			tab  = chaine.split("-");
			int idtechnicien = Integer.parseInt(tab[0]);
			System.out.println(chaine);
			System.out.println(tab[0]);
			
			
			//instancier un intervention
			Intervention uneIntervention = new Intervention(materiel,panne,dateinter,prix,idclient,idtechnicien);
			
		
			//insertion du new Client dans la bdd
			C_Intervention.insertIntervention(uneIntervention);
			
			
			JOptionPane.showMessageDialog(this, "Insertion réussie de l'intervention");
			this.viderChamps();
		
	}
	}

}
