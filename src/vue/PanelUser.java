package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.C_UserSimple;
import controller.Tableau;
import controller.UserSimple;

public class PanelUser extends PanelPrincipal implements ActionListener {
		
	private JPanel panelFormulaire = new JPanel();
	private JPanel panelTable = new JPanel();
	
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btEnregistrer= new JButton("Enregistrer");
	
	private JTextField txtPlateforme = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();	
	private JTextField txtMail = new JTextField();	
	private JTextField txtAge = new JTextField();
	private JTextField txtBio = new JTextField();
	private JTextField txtNaissance = new JTextField();
	private JTextField txtPseudo = new JTextField();
	private JTextField txtRole = new JTextField();
	private JTextField txtInscription = new JTextField();
	private JTextField txtModif = new JTextField();
	private JTextField txtMdp = new JTextField();	
	
	private JTable tableUserSimple;
	private Tableau unTableau;
	
	
	//Implément d'un filtre
		private JTextField txtMot=new JTextField();
		private JButton btOk= new JButton("Filtrer");
	
	public PanelUser() {
		super(Color.cyan);
		//Construction du panelFormulaire
		this.panelFormulaire.setBounds(20,40,400,600);
		this.panelFormulaire.setLayout(new GridLayout(13,2));
		//1e ligne
		this.panelFormulaire.add(new JLabel("Plateforme"));
		this.panelFormulaire.add(this.txtPlateforme);
		//2e ligne
		this.panelFormulaire.add(new JLabel("Nom"));
		this.panelFormulaire.add(this.txtNom);
		//3e ligne
		this.panelFormulaire.add(new JLabel("Prenom"));
		this.panelFormulaire.add(this.txtPrenom);
		//4e ligne
		this.panelFormulaire.add(new JLabel("Mail"));
		this.panelFormulaire.add(this.txtMail);
		//5e ligne
		this.panelFormulaire.add(new JLabel("Age"));
		this.panelFormulaire.add(this.txtAge);
		//6e ligne
		this.panelFormulaire.add(new JLabel("Bio"));
		this.panelFormulaire.add(this.txtBio);
		//7e ligne
		this.panelFormulaire.add(new JLabel("Naissance"));
		this.panelFormulaire.add(this.txtNaissance);
		//8e ligne
		this.panelFormulaire.add(new JLabel("Pseudo"));
		this.panelFormulaire.add(this.txtPseudo);
		//9e ligne
		this.panelFormulaire.add(new JLabel("Role"));
		this.panelFormulaire.add(this.txtRole);
		//10e ligne
		this.panelFormulaire.add(new JLabel("Date inscription"));
		this.panelFormulaire.add(this.txtInscription);
		//11e ligne
		this.panelFormulaire.add(new JLabel("Mot de passe"));
		this.panelFormulaire.add(this.txtMdp);
		//12e ligne
				this.panelFormulaire.add(new JLabel("Modif"));
				this.panelFormulaire.add(this.txtModif);
		//13e ligne
		this.panelFormulaire.add(this.btAnnuler);
		this.panelFormulaire.add(this.btEnregistrer);
		this.panelFormulaire.setBackground(Color.cyan);
		
		this.add(this.panelFormulaire);
		this.panelFormulaire.setVisible(true);
		
		//Construction du panelTable
		this.panelTable.setBounds(420,80,800,860);
		this.panelTable.setBackground(new Color(255, 184, 51));
		this.panelTable.setLayout(null);
		String entetes[]= {"idUser", "Plateforme", "Nom", "Prenom", "Mail", "Age","Bio","Naissance","Pseudo","Role","Date Insc","Mdp","Modif"};
		//Instanciation de la classe Tableau
		this.unTableau = new Tableau(this.obternirUsersSimples(""), entetes);
		this.tableUserSimple = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableUserSimple);
		uneScroll.setBounds(10,100,760,430);
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		
		this.tableUserSimple.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = 0;
				if(e.getClickCount()==2) {
					numLigne=tableUserSimple.getSelectedRow();
					int retour = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer l'utilisateur "+numLigne+" ?","Suppresion UserSimple",
							JOptionPane.YES_NO_OPTION);
					if(retour==0) {
						int idUserSimple = (int) unTableau.getValueAt(numLigne, 0);
						//Suppression du UserSimple dans la BDD
						C_UserSimple.deleteUserSimple(idUserSimple);
						//Suppression du UserSimple dans la table
						unTableau.supprimerLigne(numLigne);
					}
				}
				else if(e.getClickCount()== 1) {
					numLigne=tableUserSimple.getSelectedRow();
					txtPlateforme.setText(unTableau.getValueAt(numLigne, 1)+"");
					txtNom.setText(unTableau.getValueAt(numLigne, 2)+"");
					txtPrenom.setText(unTableau.getValueAt(numLigne, 3)+"");
					txtMail.setText(unTableau.getValueAt(numLigne, 4)+"");
					txtAge.setText(unTableau.getValueAt(numLigne, 5)+"");
					txtBio.setText(unTableau.getValueAt(numLigne, 6)+"");
					txtNaissance.setText(unTableau.getValueAt(numLigne, 7)+"");
					txtPseudo.setText(unTableau.getValueAt(numLigne, 8)+"");
					txtRole.setText(unTableau.getValueAt(numLigne, 9)+"");
					txtInscription.setText(unTableau.getValueAt(numLigne, 10)+"");
					txtMdp.setText(unTableau.getValueAt(numLigne, 11)+"");
					txtModif.setText(unTableau.getValueAt(numLigne, 12)+"");
					
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		//Rendre les boutons cliquables
				this.btAnnuler.addActionListener(this);
				this.btEnregistrer.addActionListener(this);
				this.btOk.addActionListener(this);
				
				//Placement du filtre
				this.txtMot.setBounds(20, 10,100,30);
				this.panelTable.add(this.txtMot);
				this.btOk.setBounds(120, 10, 100, 30);
				this.panelTable.add(this.btOk);
		
		
		
		
		
	}

	public Object [] [] obternirUsersSimples(String mot){
		ArrayList<UserSimple> lesUsersSimples = C_UserSimple.selectAllUsersSimples(mot);
		Object [][] matrice = new Object[lesUsersSimples.size()][13];
		int i=0;
		for(UserSimple unUserSimple : lesUsersSimples){
			matrice[i][0]=unUserSimple.getIdUser()+"";
			matrice[i][1]=unUserSimple.getUserSimplePlateforme();
			matrice[i][2]=unUserSimple.getUserNom();
			matrice[i][3]=unUserSimple.getUserPrenom();
			matrice[i][4]=unUserSimple.getUserMail();
			matrice[i][5]=unUserSimple.getUserAge();
			matrice[i][6]=unUserSimple.getUserBio();
			matrice[i][7]=unUserSimple.getUserNaissance();
			matrice[i][8]=unUserSimple.getUserPseudo();
			matrice[i][9]=unUserSimple.getUserRole();
			matrice[i][10]=unUserSimple.getUserDateInscription();
			matrice[i][11]=unUserSimple.getUserPassword();
			matrice[i][12]=unUserSimple.getUserSimpleCanModify();
			
			i++;	
		}
		return matrice;
	}

	public void viderChamps() {
		this.txtPlateforme.setText("");
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtMail.setText("");
		this.txtAge.setText("");
		this.txtBio.setText("");
		this.txtNaissance.setText("");
		this.txtPseudo.setText("");
		this.txtRole.setText("");
		this.txtInscription.setText("");
		this.txtMdp.setText("");
		this.txtModif.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.viderChamps();
		}
		else if(e.getSource()==this.btEnregistrer &&this.btEnregistrer.getText().equals("Modifier")) {
			String plateforme =this.txtPlateforme.getText();
			String nom= this.txtNom.getText();
			String prenom= this.txtPrenom.getText();
			String mail= this.txtMail.getText();
			int level = 1;
			String age= this.txtAge.getText();
			String bio= this.txtBio.getText();
			String naissance= this.txtNaissance.getText();
			String pseudo= this.txtPseudo.getText();
			String role= this.txtRole.getText();
			String insc= this.txtInscription.getText();
			String mdp= this.txtMdp.getText();
			int modif = 0;
			try {
				modif = Integer.parseInt(this.txtModif.getText());
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de modif (soit 0 pour non, soit 1 pour oui)");
			}
			//On récupère l'Id
			int numLigne = this.tableUserSimple.getSelectedRow();
			
			int idUserSimple= Integer.parseInt(this.unTableau.getValueAt(numLigne, 0)+"");
			//On update le client dans la Bdd
			UserSimple updateUserSimple = new UserSimple(idUserSimple,level,modif,plateforme,nom,prenom,age,bio,naissance,pseudo,mail,mdp,role,insc);
			C_UserSimple.updateUserSimple(updateUserSimple);
		
			Object[] ligne= {idUserSimple, plateforme,nom, prenom, mail, age,bio, naissance,pseudo,role,insc,mdp, modif};
			unTableau.modifierLigne(numLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie !");
			this.viderChamps();

		}
		else if(e.getSource()==this.btOk) {
			String mot=this.txtMot.getText();
			Object[][] matrice=this.obternirUsersSimples(mot);
			unTableau.setDonnees(matrice);
		}
		else if(e.getSource()==this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String plateforme =this.txtPlateforme.getText();
			String nom= this.txtNom.getText();
			String prenom= this.txtPrenom.getText();
			String mail= this.txtMail.getText();
			int level = 1;
			String age= this.txtAge.getText();
			String bio= this.txtBio.getText();
			String naissance= this.txtNaissance.getText();
			String pseudo= this.txtPseudo.getText();
			String role= this.txtRole.getText();
			String insc= this.txtInscription.getText();
			String mdp= this.txtMdp.getText();
			int modif = 0;
			try {
				modif = Integer.parseInt(this.txtModif.getText());
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie de modif (soit 0 pour non, soit 1 pour oui)");
			}
			UserSimple unUserSimple= new UserSimple(level, modif, plateforme, nom, prenom,age,bio,naissance,pseudo,mail, mdp, role, insc);
			//Insertion du new UserSimple dans la BDD
			C_UserSimple.insertUserSimple(unUserSimple);
			//Actualisation de la table d'affichage des UserSimple
			unUserSimple=C_UserSimple.selectWhereUserSimple(mail, nom, prenom);
			int idUserSimple=unUserSimple.getIdUser();
			Object[] ligne= {idUserSimple, plateforme,nom, prenom, mail, age,bio, naissance,pseudo,role,insc,mdp, modif};
			unTableau.insererLigne(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie !");
			this.viderChamps();
		}
		
		
		
		
	}
	
}
