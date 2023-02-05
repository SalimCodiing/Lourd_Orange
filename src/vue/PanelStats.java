package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.C_Client;
import controller.C_Stats;
import controller.Stats;
import controller.Tableau;

public class PanelStats extends PanelPrincipal{

	
	private JPanel panelTech = new JPanel();
	
	private JTable tableStats;
	private Tableau unTableau;
	
	
	
	public PanelStats() {
		super(Color.pink);
		
		// construction du panelTech
		this.panelTech.setBounds(40,80,340,300);
		this.panelTech.setLayout(null);
		String entetes [] = {"Nom", "Prenom", "NB Interventions"};
		//instanciation de la calss tableau du controller
		unTableau = new Tableau(this.obtenirStats(""), entetes);
		this.tableStats = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableStats);
		uneScroll.setBounds(20,20,300,260);
		this.panelTech.add(uneScroll);
		
		this.add(this.panelTech);
		
		
		
	}
	
	public Object [][] obtenirStats(String mot){
		ArrayList<Stats> lesStats = C_Stats.selectAllInterventionsTech();
		Object [][] matrice = new Object [lesStats.size()][3];
		int i = 0;
		for(Stats uneStats : lesStats) {
			matrice[i] [0] = uneStats.getNom();
			matrice[i] [1] = uneStats.getPrenom();
			matrice[i] [2] = uneStats.getNb()+"";
			
			i++;
		}
		
		return matrice;
	}

}
