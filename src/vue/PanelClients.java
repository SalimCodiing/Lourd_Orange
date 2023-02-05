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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.C_Client;
import controller.Client;
import controller.Tableau;

public class PanelClients extends PanelPrincipal implements ActionListener {

	private static final Client[] LesClients = null;
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();	
	private JTextField txtEmail = new JTextField();	
	private JTextField txtAdresse = new JTextField();
	private JTextField txtTel = new JTextField();
		
	//déclarations de table des clients
	private JTable tableClients;
	private Tableau unTableau; 
	
	
	//implementation d'un filtre
	private JTextField txtMot = new JTextField();
	private JButton btOk = new JButton("Filtrer");
	
	
	public PanelClients() {
		super(Color.cyan);
		
		
		//construction du panelForm
		this.panelForm.setBounds(40,40,300,300);
		this.panelForm.setLayout( new GridLayout(6,2));
		
		this.panelForm.add(new JLabel("Nom:"));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prenom:"));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(new JLabel("Email:"));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Adresse:"));
		this.panelForm.add(this.txtAdresse);
		this.panelForm.add(new JLabel("Téléphone:"));
		this.panelForm.add(this.txtTel);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.setBackground(Color.pink);
		this.panelForm.setVisible(true);
		
		this.add(this.panelForm);
		
		//Construction du PanelTable
		this.panelTable.setBounds(400,80,600,300);
		this.panelTable.setBackground(new Color(255,184,51));
		this.panelTable.setLayout(null);
		String entetes [] = {"Idclient", "Nom", "Prénom", "Email","Adresse", "Téléphone"};
		//instanciation de la calss tableau du controller
		unTableau = new Tableau(this.obtenirClients(""), entetes);
		this.tableClients = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableClients);
		uneScroll.setBounds(20,20,450,250);
		this.panelTable.add(uneScroll);
		
		this.add(this.panelTable);
		//rendre ecoutable le JTable avec gestion de la suppression d'une ligne
		this.tableClients.addMouseListener(new MouseListener() {
			
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
				int numLigne;
				if(e.getClickCount() == 2) {
					numLigne = tableClients.getSelectedRow();
					int retour = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer ce client ?","Suppression Client",
							JOptionPane.YES_NO_OPTION);
					if(retour ==0) {
						//suppression du client dans la base
						int idclient = (int) unTableau.getValueAt(numLigne, 0);
						C_Client.deleteClien(idclient);
						// suppression de la ligne
						unTableau.supprimerLigne(numLigne);
					}
				}else if(e.getClickCount()== 1){
					numLigne = tableClients.getSelectedRow();
					txtNom.setText(unTableau.getValueAt(numLigne, 1)+ "");
					txtPrenom.setText(unTableau.getValueAt(numLigne, 2)+ "");
					txtEmail.setText(unTableau.getValueAt(numLigne, 3)+ "");
					txtAdresse.setText(unTableau.getValueAt(numLigne, 4)+ "");
					txtTel.setText(unTableau.getValueAt(numLigne, 5)+ "");
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		// rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btOk.addActionListener(this);
		
		//placement du filtre
		this.txtMot.setBounds(500,40,150,30);
		this.add(this.txtMot);
		this.btOk.setBounds(670,40,100,30);
		this.add(this.btOk);
		
		
		
	}

	
	public Object [][] obtenirClients(String mot){
		ArrayList<Client> lesClients = C_Client.selectAllClients(mot);
		Object [][] matrice = new Object [lesClients.size()][6];
		int i = 0;
		for(Client unClient : lesClients) {
			matrice[i] [0] = unClient.getIdclient()+ "";
			matrice[i] [1] = unClient.getNom();
			matrice[i] [2] = unClient.getPrenom();
			matrice[i] [3] = unClient.getEmail();
			matrice[i] [4] = unClient.getAdresse();
			matrice[i] [5] = unClient.getTel();
			i++;
		}
		
		return matrice;
	}

	public void viderChamps() {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtAdresse.setText("");
		this.txtTel.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.btAnnuler) {
			this.viderChamps();
		}
		else if(e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
			String adresse = this.txtAdresse.getText();
			String tel = this.txtTel.getText();
			
			//instancier un client
			Client unClient = new Client(nom, prenom, email, adresse, tel);
			//insertion du new Client dans la bdd
			C_Client.insertClient(unClient);
			
			//actualisation de la table d'affichage des clients
			unClient = C_Client.selectWhereClient(email, nom, prenom);
			int idclient = unClient.getIdclient();
			Object ligne []= {idclient,nom, prenom, email, adresse, tel};
			unTableau.insererLigne(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie du client");
			this.viderChamps();
			
			
		}else if(e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
			String adresse = this.txtAdresse.getText();
			String tel = this.txtTel.getText();
			int numLigne = tableClients.getSelectedRow();
			int idclient = (int) unTableau.getValueAt(numLigne, 0);
			//instanciation de la classe Client
			Client unClient = new Client(idclient,nom, prenom, email, adresse, email);
			//C_client update dans la base de données
			C_Client.updateClient(unClient);
			//update dans le tableau
			Object ligne []= {idclient,nom, prenom, email, adresse, tel};
			unTableau.modifierLigne(numLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussite");
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");
		}
		else if(e.getSource()== this.btOk) {
			String mot = this.txtMot.getText();
			Object [] [] matrice = this.obtenirClients(mot);
			unTableau.setDonnees(matrice);
		}
	}

	

}
