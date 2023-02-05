package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.C_Technicien;
import controller.Technicien;

public class PanelProfil extends PanelPrincipal implements ActionListener{
	
	private JTextArea txtProfil = new JTextArea();
	private JPanel panelUpdate = new JPanel();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btModifier = new JButton("Modifier");
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();	
	private JTextField txtEmail = new JTextField();	
	private JTextField txtQualification = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();	
	private boolean visible;
	private int idtechnicien;
	
	private JButton btModifierProfil = new JButton("Modifier Profil");

	public PanelProfil(Technicien unTechnicien) {
		super(Color.blue);
		this.idtechnicien = unTechnicien.getIdtechnicien();
		
		String message ="";
		message="Nom du technicien : "+ unTechnicien.getNom()+"\n";
		message +="Prenom du technicien : "+ unTechnicien.getPrenom()+"\n";
		message +="Email du technicien : "+ unTechnicien.getEmail()+"\n";
		message +="Qualification du technicien : "+ unTechnicien.getQualification()+"\n";
		
		this.txtProfil.setBounds(40, 40, 300, 300);
		this.txtProfil.setText(message);
		
		//construction du panelProfil
		this.panelUpdate.setBounds(400,40,300,300);
		this.panelUpdate.setLayout(new GridLayout(6,2));
		this.panelUpdate.add(new JLabel("Nom:"));
		this.panelUpdate.add(this.txtNom);
		this.panelUpdate.add(new JLabel("Prenom:"));
		this.panelUpdate.add(this.txtPrenom);
		this.panelUpdate.add(new JLabel("Email:"));
		this.panelUpdate.add(this.txtEmail);
		this.panelUpdate.add(new JLabel("Qualification:"));
		this.panelUpdate.add(this.txtQualification);
		this.panelUpdate.add(new JLabel("Mot de passe:"));
		this.panelUpdate.add(this.txtMdp);
		this.panelUpdate.add(this.btAnnuler);
		this.panelUpdate.add(this.btModifier);
		this.panelUpdate.setBackground(Color.red);
		this.panelUpdate.setVisible(false);
		this.visible = false;
		
		this.add(this.panelUpdate);
		
		//Ajout du bouton modifier profil
		this.btModifierProfil.setBounds(100,360,200,30);
		this.add(this.btModifierProfil);
		
		this.add(txtProfil);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btModifierProfil.addActionListener(this);
		
		//REMPLIR LES CHAMPS AVEC LES INFOS
		this.txtNom.setText(unTechnicien.getNom());
		this.txtPrenom.setText(unTechnicien.getPrenom());
		this.txtEmail.setText(unTechnicien.getEmail());
		this.txtQualification.setText(unTechnicien.getQualification());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btModifierProfil) {
		
			if(this.visible== false) {
				this.panelUpdate.setVisible(true);
				
				this.visible = true;
			}else {
				this.panelUpdate.setVisible(false);
				this.visible=false;
			}
		}
		else if(e.getSource() == this.btAnnuler) {
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtEmail.setText("");
			this.txtQualification.setText("");
			this.txtMdp.setText("");
			
		}
		else if(e.getSource() == this.btModifier) {
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
			String qualification = this.txtQualification.getText();
			String mdp =  new String (this.txtMdp.getPassword());
			Technicien updateTechnicien = new Technicien(this.idtechnicien, nom, prenom, email, mdp, qualification);
			//Modification dans la bdd
			C_Technicien.updateTechnicien(updateTechnicien);
			JOptionPane.showMessageDialog(this,"Modification réussi");
			this.panelUpdate.setVisible(false);
			this.visible= false;
			//modification des infos dan sle textArea
			String message ="";
			message="Nom du technicien : "+ nom+"\n";
			message +="Prenom du technicien : "+ prenom+"\n";
			message +="Email du technicien : "+ email+"\n";
			message +="Qualification du technicien : "+ qualification+"\n";
			this.txtProfil.setText(message);
			
		}
		
	}

}
