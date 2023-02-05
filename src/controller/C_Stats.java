package controller;

import java.util.ArrayList;

import models.ModeleStats;

public class C_Stats {

	public static ArrayList<Stats> selectAllInterventionsTech(){
		return ModeleStats.selectAllInterventionsTech();
	}
}
