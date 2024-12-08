package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ValidationIdentification {
	
	

	public static boolean verifierId(String identifiant, String motDePasse) throws FileNotFoundException, IOException {
		
		String pathFichierTexte = "/donnees/Compte.txt";
		
		try(InputStream inStream = ValidationIdentification.class.getResourceAsStream(pathFichierTexte);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] details = line.split(",");
				if(details.length == 2) {
					String loginID = details[0].trim();
					String password = details[1].trim();
					
					if (loginID.equals(identifiant) && password.equals(motDePasse)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean verifierFomartTelephone(String telephone) {
		 String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}";
	      
	     return telephone != null && telephone.matches(regex);
	}
}
