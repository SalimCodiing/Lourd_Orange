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


import controller.C_UserAdmin;

import controller.UserAdmin;

public class PanelProfil extends PanelPrincipal implements ActionListener {
	
	private JTextArea txtProfil = new JTextArea();
	private JPanel panelUpdate = new JPanel();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btModifier = new JButton("Modifier");
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();	
	private JTextField txtMail = new JTextField();	
	private JTextField txtPseudo = new JTextField();
	private JTextField txtAge = new JTextField();
	private JTextField txtBio = new JTextField();
	private JTextField txtNaissance = new JTextField();
	private JTextField txtLevel = new JTextField();
	private JTextField txtRole = new JTextField();
	private JTextField txtGrade = new JTextField();
	private JTextField txtFonction = new JTextField();
	private JTextField txtDateInscription = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();	
	private boolean visible;
	private int idUserAdmin;
	
	private JButton btModifierProfil = new JButton("Modifier Profil");
	
	public PanelProfil(UserAdmin unUserAdmin) {
		super(Color.WHITE);
		this.idUserAdmin = unUserAdmin.getIdUser();
		
		String message ="";
		message="Nom : "+ unUserAdmin.getUserNom()+"\n";
		message +="Prenom : "+ unUserAdmin.getUserPrenom()+"\n";
		message +="Email : "+ unUserAdmin.getUserMail()+"\n";
		message +="Mdp : "+ unUserAdmin.getUserPassword()+"\n";
		message +="Pseudo : "+ unUserAdmin.getUserPseudo()+"\n";
		message +="Age : "+ unUserAdmin.getUserBio()+"\n";
		message +="Bio : "+ unUserAdmin.getUserPseudo()+"\n";
		message +="Naissance : "+ unUserAdmin.getUserNaissance()+"\n";
		message +="Level : "+ unUserAdmin.getUserLevel()+"\n";
		message +="Role : "+ unUserAdmin.getUserRole()+"\n";
		message +="Grade : "+ unUserAdmin.getUserAdminGrade()+"\n";
		message +="Fonction : "+ unUserAdmin.getUserAdminFonction()+"\n";
		message +="Date Inscription : "+ unUserAdmin.getUserDateInscription()+"\n";
		
		this.txtProfil.setBounds(40, 40, 300, 300);
		this.txtProfil.setText(message);
		
		//construction du panelProfil
				this.panelUpdate.setBounds(400,40,500,600);
				this.panelUpdate.setLayout(new GridLayout(14,2));
				this.panelUpdate.add(new JLabel("Nom:"));
				this.panelUpdate.add(this.txtNom);
				this.panelUpdate.add(new JLabel("Prenom:"));
				this.panelUpdate.add(this.txtPrenom);
				this.panelUpdate.add(new JLabel("Mail:"));
				this.panelUpdate.add(this.txtMail);
				this.panelUpdate.add(new JLabel("Mot de passe:"));
				this.panelUpdate.add(this.txtMdp);
				this.panelUpdate.add(new JLabel("Pseudo:"));
				this.panelUpdate.add(this.txtPseudo);
				this.panelUpdate.add(new JLabel("Age:"));
				this.panelUpdate.add(this.txtAge);
				this.panelUpdate.add(new JLabel("Bio:"));
				this.panelUpdate.add(this.txtBio);
				this.panelUpdate.add(new JLabel("Naissance:"));
				this.panelUpdate.add(this.txtNaissance);
				this.panelUpdate.add(new JLabel("Level:"));
				this.panelUpdate.add(this.txtLevel);
				this.panelUpdate.add(new JLabel("Role:"));
				this.panelUpdate.add(this.txtRole);
				this.panelUpdate.add(new JLabel("Grade:"));
				this.panelUpdate.add(this.txtGrade);
				this.panelUpdate.add(new JLabel("Fonction:"));
				this.panelUpdate.add(this.txtFonction);
				this.panelUpdate.add(new JLabel("Date Inscription:"));
				this.panelUpdate.add(this.txtDateInscription);
				this.panelUpdate.add(this.btAnnuler);
				this.panelUpdate.add(this.btModifier);
				this.panelUpdate.setBackground(Color.white);
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
				this.txtNom.setText(unUserAdmin.getUserNom());
				this.txtPrenom.setText(unUserAdmin.getUserPrenom());
				this.txtMail.setText(unUserAdmin.getUserMail());
				this.txtMdp.setText(unUserAdmin.getUserPassword());
				this.txtPseudo.setText(unUserAdmin.getUserPseudo());
				this.txtAge.setText(unUserAdmin.getUserAge());
				this.txtBio.setText(unUserAdmin.getUserBio());
				this.txtNaissance.setText(unUserAdmin.getUserNaissance());
				this.txtRole.setText(unUserAdmin.getUserRole());
				this.txtGrade.setText(unUserAdmin.getUserAdminGrade());
				this.txtFonction.setText(unUserAdmin.getUserAdminFonction());	
				this.txtDateInscription.setText(unUserAdmin.getUserDateInscription());
				
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
			this.txtMail.setText("");
			this.txtMdp.setText("");
			this.txtPseudo.setText("");
			this.txtAge.setText("");
			this.txtBio.setText("");
			this.txtNaissance.setText("");
			this.txtRole.setText("");
			this.txtGrade.setText("");
			this.txtFonction.setText("");
			this.txtDateInscription.setText("");
			
		}
		else if(e.getSource() == this.btModifier) {
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String mail = this.txtMail.getText();
			String pseudo = this.txtPseudo.getText();
			String age = this.txtAge.getText();
			String bio = this.txtBio.getText();
			String naissance = this.txtNaissance.getText();
			String level = this.txtLevel.getText();
			String role = this.txtRole.getText();
			String grade = this.txtGrade.getText();
			String fonction = this.txtFonction.getText();
			String inscription = this.txtDateInscription.getText();
			String mdp =  new String (this.txtMdp.getPassword());
			UserAdmin updateUserAdmin = new UserAdmin(this.idUserAdmin,3,true, grade,fonction,nom, prenom, age, bio, pseudo, naissance, mail, mdp, role, inscription,
					"UserAdminApp","UserAdminApp",null,null);
			//Modification dans la bdd
			C_UserAdmin.updateUserAdmin(updateUserAdmin);
			JOptionPane.showMessageDialog(this,"Modification réussi");
			this.panelUpdate.setVisible(false);
			this.visible= false;
			//modification des infos dan sle textArea
			String message ="";
			message="Nom : "+ nom+"\n";
			message +="Prenom : "+ prenom+"\n";
			message +="Email : "+ mail+"\n";
			message +="Mdp : "+ mdp+"\n";
			message +="Pseudo : "+ pseudo+"\n";
			message +="Age : "+ age+"\n";
			message +="Bio : "+ bio+"\n";
			message +="Naissance : "+ naissance+"\n";
			message +="Level : "+ level+"\n";
			message +="Role : "+ role+"\n";
			message +="Grade : "+ grade+"\n";
			message +="Fonction : "+ fonction+"\n";
			message +="Date Inscription : "+ inscription+"\n";
			this.txtProfil.setText(message);
			
		}
		
	}
}
