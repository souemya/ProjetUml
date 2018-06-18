import java.util.Scanner;

public abstract class  Personnage extends Map { //caracteristique du personnage
      protected int vie; 
      protected int force;
      protected int adresse;
      protected int resistance;
      protected int pointAction;
      private int niveau;
      
      private Arme arme;
      private Vetement vet;
      private Bouclier boucl;
      
      public Personnage() { // initialisation d'un perso par defaut
         this.vie = 7;
         this.force = 10;
         this.adresse = 10;
         this.resistance = 10;
         this.pointAction = 6;
         this.niveau = 0;
      }
      
      public Personnage(int force, int adr, int res) {
         // pour creer un perso avec les parametres qu'a choisi le joueur
         this.vie = 7;
         this.force = force;
         this.adresse = adr;
         this.resistance = res;
         this.pointAction = 6;
      }
      
      public void choisirDegres() {
      		System.out.println("Crée votre personnage\n");
      		System.out.println("Veuillez attribuer les points de caractéristiques à votre personnage.\n18 points à attribuer.\n");
      		System.out.println("1- Force\n2- Adresse\n3- Resistance\n");
      		int saisie = 0;
		
      		while(saisie < 18) {
			saisie = 0;
			Scanner point = new Scanner(System.in);
			System.out.println("Veuillez indiquez le nombre de points pour la force de votre personnage : \n");
			this.force = point.nextInt();
			
			while(this.force > 18) { // saisie controle
				System.out.println("Saisissez un nombre inférieur à 18\n");
				this.force = point.nextInt();
			}
			saisie += this.force; // compte les points attribuer
			
			System.out.println("Veuillez indiquez le nombre de points pour la résistance de votre personnage : ");
			int reste = 18 - this.force; // reste des points a attribuer
			
			System.out.println("Il vous reste : "+ reste + " points a attribuer");
			this.resistance = point.nextInt();
			
			while(this.resistance > 18 || this.resistance > reste) { // saisie controle
				System.out.println("Saisissez un nombre inférieur a : "+ reste +"\n");
				this.resistance = point.nextInt();
			}
			saisie += this.resistance;
			
			System.out.println("Veuillez indiquez le nombre de points pour l'adresse de votre personnage : ");
			reste -= this.resistance;
			System.out.println("Il vous reste : "+ reste + " points a attribuer");
			this.adresse = point.nextInt();
			while(this.adresse > 18 || this.adresse > reste || this.adresse < reste) {
				System.out.println("Vous devez utilisez tous les points restants : "+ reste +"\n");
				this.adresse = point.nextInt();
			}
			saisie += this.adresse;
			reste -= this.adresse;
			if(reste !=0) {
				System.out.println("Problème de saisie");
			}
			if(saisie == 18) {
			System.out.println("Tous vos points ont été attribué");
			System.out.println("Par defaut votre personnage a 7 vie et 6 PA\n");
			setVie(7);
			setPointAction(6);
			}
			else
				saisie = 0;
			}
      }
      
    //Utilisation de try Catch pour ne pas que la methode ce bloque si il manque une valeur
      /** Capacité personnages à attaquer avant les autres */ 
      public int initiative () 
      {
         /*if(this.getAdresse()> vet.getEncombrement())
            return (this.getAdresse() - vet.getEncombrement());
         return 0;  */
         try {
           // if(this.getAdresse()> vet.getEncombrement())
               return (this.getAdresse());// - vet.getEncombrement());
         }catch (Exception e) {}           
            return 0;
         
      }
      
      /**Capacité de toucher l'adversair pdnt qu'il attaque */
      public int  attaque() 
      {
         try {
            return (this.getAdresse());//+ this.arme.getManiabilite());
            }catch (Exception e) {}
            
            try {
               this.getAdresse();
            }catch (Exception e) {}
            
            return 0;
         //return (this.getAdresse()+ arme.getManiabilite());
      }
      
      
      /**Capacité d'éviter les coup dont il est la cible */
       public int  esquive() 
      {
         /*if (this.getAdresse()>vet.getEncombrement())
            return (this.getAdresse() - vet.getEncombrement());
         return 0;*/
         
         try {
            if (this.getAdresse()>vet.getEncombrement())
               return (this.getAdresse() - vet.getEncombrement());
            }catch (Exception e) {}
            
            try {
               return this.getAdresse();
            }catch (Exception e) {}
            
            return 0; 
      }
      
      
      /**Capacité de supporter dommage physique*/
      public int defense() 
      {
         try {
            return (this.getResistance() + vet.getSolidite());
            }catch (Exception e) {}
            
            try {
               return this.getResistance();
            }catch (Exception e) {}
            
            return 0;
      }
      
      
      /** Capacité de la puissance des coups portés par le personnage.*/
      public int degat() 
      {
         try {
         return (this.getForce() + arme.getImpact());
         }catch (Exception e) {}
         
         try {
            return this.getForce();
         }catch (Exception e) {}
         
         return 0;
      }
       
      
      //Methode pour déterminer le nbr de PA utiliser pour attaquer
      public boolean assezDePA(int actionJ) 
      {
    	 if (actionJ == 1) {// assez de PA pour se deplacer
    		 if (this.getPointAction() >=2)  
    			 setPointAction(this.pointAction-2);
    			 return true;
    	 }
    	 
    	 if (actionJ == 2) {// assez de PA pour attaquer
    		 if(this.getPointAction() >= 3)
    			 
    			 return true;
    	 }
    	 
    	 if (actionJ == 3) {// assez de PA pour utiliser un objet
    		 if(this.getPointAction() >= 3)
    			 setPointAction(this.pointAction-3);
    			 return true;
    	 }
    	 
    	 if (actionJ == 4) {// assez de PA pour ramasser/deposer objet
    		 if(this.getPointAction() >= 2)
    			 setPointAction(this.pointAction-2);
    			 return true;
    	 }
         else 
            System.out.println("Pas assez de PA pour l'action souhaité");
            return false;
      }
     
    //Méthode pour déterminé si une cible est touché
      public boolean toucheCible(Personnage cible)
      {
        if(this.attaque() > cible.esquive())
              return true;
        else 
           return false;
      }
      
      //Méthode pour déterminé si une cible touché est blessé
      public boolean cibleBlessé(Personnage cible)
      {
            if(cible.defense() < this.degat () )
               return true;
            else 
               return false;
      }
      
     /* Personnage attaquant : this
       * Personnage cible : un parametre
       * personnage qui se défend : pers cible */    
      
     /* Je peux attaquer SSI 
       *    1) Une cible se trouve a proximité.
       *    2) Je dois avoir 3PA minimum.
       *    3) Je dois avoir un objet. */
      
      /*cible blessé => cible touché
       *    La cible est touché : score d’attaque (attaquant)>score d’esquive(cible)
       *    la cible est blessé : score defense (cible) < score de degat (attaquant) */
       
      public void attaquer (Personnage cible)//Main m, 
      {
          
          //int pointBlessure = (int) ( (this.degat() - cible.defense()) /3 ); 
                   
          //Je peux attaquer 
          if(/*(this.existeCible() == true) && */(this.assezDePA(2) == true)) //&& (m.existeObjet(m)==true) )
          { 
        	  setPointAction(this.pointAction-3);  
          }
        
           //la cible est touchée
          if((this.toucheCible(cible) == true) &&  (this.cibleBlessé(cible) == true ))
          
          {
             if (cible.getVie() == 1) 
             {
            	cible.setVie(0);
                System.out.println("La cible meurt");
                //effacer Perso
             }
             else
                cible.setVie( cible.getVie() - 1);//pointBlessure);
                cible.afficheBlessure();
          }
    
       }
      
    //Méthode pour déterminer le niveau de blessure    
      public void afficheBlessure()
      {
         if (this.getVie()==7)
            System.out.println("Aucune blessure");
         else if (this.getVie()==6)
            System.out.println("Blessures superficielles");
         else if (this.getVie()==5)
            System.out.println("Légèrement blessé");
         else if (this.getVie()==4)
            System.out.println("Blessé");
         else if (this.getVie()==3)
            System.out.println("Gravement blessé");
         else if (this.getVie()==2)
            System.out.println("Inconscient");
         else
            System.out.println("La cible meurt");
      }
            
      public void passerSonTour() {
          
          this.setPointAction( (this.getPointAction()/2) + 6 );
          
       }
      
      public int getPointAction() {
         return pointAction;
      }

      public void setPointAction(int pointAction) {
         this.pointAction = pointAction;}
      
      public int getForce() {
         return force;
      }

      public void setForce(int force) {
         this.force = force;
      }

      public int getAdresse() {
         return adresse;
      }

      public void setAdresse(int adresse) {
         this.adresse = adresse;
      }

      public int getResistance() {
         return resistance;
      }

      public void setResistance(int resistance) {
         this.resistance = resistance;
      }
            
      public int getVie() {
         return vie;
      }

      public void setVie(int vie) {
         this.vie = vie;
      }
      
      /*public String toString() {
         return "J";
      }*/
   }
