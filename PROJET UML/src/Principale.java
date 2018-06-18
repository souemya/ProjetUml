	import java.awt.desktop.SystemSleepEvent;
	import java.util.Scanner;
	
	
	public class Principale {
	
		public static void main(String[] args) {
			// Creation et affichage de la map
			Map m = new Map();
			// Creation et affichage d'un personnage
			System.out.println("Bienvenu dans notre jeu ! Crée par Saied Suroth et Soumeya Souid.\n"
					+ "Le but est simple vous incarnerez un personnage que vous aller créer dans un premier temps.\n"
					+ "Puis dans un second temps, vous allez devoir survivre face aux monstres qui voudront qu'une seule chose, votre mort !\n"
					+ "Un personnage est crée de base, vous allez devoir lui attribuer des points de caractéristiques !\n"
					+ "Bonne chance !\n");
				
			Personnage J = new PJ();
			//J.choisirDegres();
			
			Personnage M = new Monstre(3,3,3,3,3);
			System.out.println("Caractéristique du monstre : \n");
			System.out.println("- force : " + M.getForce() + "\n"
							  +"- adresse : " + M.getAdresse() +"\n"
							  +"- resistance : " + M.getResistance()+"\n"
							  +"+ initiative : " + M.initiative()+"\n"
							  +"+ attaque : " + M.attaque()+"\n"
							  +"+ defense : " + M.defense()+"\n"
							  +"+ degats : " + M.degat()+"\n"
							  +"+ esquive : " + M.esquive()+"\n");
			System.out.println("Creation de votre personnage");
			System.out.println("Voici le personnage dans la map : "+ J);
	
			m.placer(5, 3, 'J');
			
			
			System.out.println("\nCreation des monstres et mise en place des monstres aleatoirement");
			System.out.println("Voici le montre dans la map : "+ M);
			Objet a = new Objet();
			
			m.placer(5, 4, 'M');
			
			m.afficher();
			
			System.out.println("\nJOUEUR 1 : Etat joueur si attaquer ou pas\n");
			System.out.println("Voici les pv de votre personnage : "+J.getVie() +"\n");
	
			System.out.println("Vos objets équipés :\n");
			//Objet a = new Objet();
			//System.out.println(a.getObjet);
			
			//Inventaire i = new Inventaire();
			System.out.println("Votre inventaire : \n");
			//System.out.println(i+"\n");
			
			System.out.println("Vos Caractéristiques : \n");
			System.out.println("- force : " + J.getForce() + "\n"
							  +"- adresse : " + J.getAdresse() +"\n"
							  +"- resistance : " + J.getResistance()+"\n"
							  +"+ initiative : " + J.initiative()+"\n"
							  +"+ attaque : " + J.attaque()+"\n"
							  +"+ defense : " + J.defense()+"\n"
							  +"+ degats : " + J.degat()+"\n"
							  +"+ esquive : " + J.esquive()+"\n");
			System.out.print("Votre niveau de blessure : ");
			J.afficheBlessure();
			System.out.println("\nVos points d'actions : " + J.getPointAction()+"\n");
			System.out.println("Vous pouvez : \n");
			System.out.println("1 - Vous déplacez (2PA)");
			System.out.println("2 - Vous pouvez attaquer (3PA)");
			System.out.println("3 - Vous pouvez utiliser un objet (PA variable)");
			System.out.println("4 - Vous pouvez ramasser/déposer un objet (2PA)");
			System.out.println("5 - Vous pouvez finir et garder les PA restants\n");
			System.out.println("Votre choix : ");
			
			while(J.getPointAction()<=6 && J.getPointAction() > 0) {
			Scanner choix = new Scanner(System.in); //choix de l'utilisateur
			int nb = choix.nextInt();
			
				while(nb < 1 || nb > 5) {
					System.out.println("Erreur, veuillez saisir une valeur comprise entre 1 et 5\n.");
					nb = choix.nextInt();
				}
			
			if(nb == 1) 
			{
				
				System.out.println("Dans quelle direction ? 1 = haut / 2 = bas / 3 = gauche / 4 = droite\n");
				Scanner deplac = new Scanner(System.in);
				int direct = deplac.nextInt();
				while( direct < 1 || direct > 4 ) 
				{ //
					System.out.println("Problème de saisie, veuillez saisir une valeur comprise entre 1 et 4\n");
					direct = deplac.nextInt();
				}
				if(m.seDeplacer(direct) == 1)
				{
					m.afficher();
					J.assezDePA(1);
					System.out.println("Vous vous êtes déplacé, vous avez perdu 2PA\n");
				}
				else if (m.seDeplacer(direct) == 0)
				{
					System.out.println("La case est occupé\n"
							+ "Vous etes toujours au meme endroit\n");
					m.seDeplacer(direct);
					m.afficher();
				}
			}
			
			else if(nb == 2) {
				J.assezDePA(2);
				//System.out.println("Test 2 attaquer");
				J.attaquer(M);
				m.afficher();
				
			}
			else if(nb == 3) {
				//m.utiliserObj();
				System.out.println("Test 3 utiliser objet");
			}
			else if(nb == 4) {
				//m.ramasserObj();
				//m.deposerObj();
				System.out.println("Test 4 ramasser/deposer obj");
			}
			else if(nb == 5) {
				//m.garderPA();
				System.out.println("Test 5 finir et garder les PA restants");
			}
			
			
			System.out.println("Vos objets équipés :\n");
			//Objet a = new Objet();
			//System.out.println(a.getObjet);
			
			//Inventaire i = new Inventaire();
			System.out.println("Votre inventaire : \n");
			//System.out.println(i+"\n");
			
			System.out.println("Vos Caractéristiques : \n");
			System.out.println("- force : " + J.getForce() + "\n"
							  +"- adresse : " + J.getAdresse() +"\n"
							  +"- resistance : " + J.getResistance()+"\n"
							  +"+ initiative : " + J.initiative()+"\n"
							  +"+ attaque : " + J.attaque()+"\n"
							  +"+ defense : " + J.defense()+"\n"
							  +"+ degats : " + J.degat()+"\n"
							  +"+ esquive : " + J.esquive()+"\n");
			
			System.out.print("Votre niveau de blessure : ");
			J.afficheBlessure();
			System.out.println("\nVos points d'actions : " + J.getPointAction()+"\n");
			if(J.getPointAction() > 0) 
				{
					System.out.println("Vous pouvez : \n");
					System.out.println("1 - Vous déplacez (2PA)");
					System.out.println("2 - Vous pouvez attaquer (3PA)");
					System.out.println("3 - Vous pouvez utiliser un objet (PA variable)");
					System.out.println("4 - Vous pouvez ramasser/déposer un objet (2PA)");
					System.out.println("5 - Vous pouvez finir et garder les PA restants\n");
					System.out.println("Votre choix : ");
				}
			}
			
			System.out.println("Vous n'avez plus de PA, passer votre tour !");
			//m.garderPA();*/
		}
	}
	
	
