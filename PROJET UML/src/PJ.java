import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;


public class PJ extends Main  {
	
	//private int xp;
	private Main droite;
	private Main gauche;
   private Inventaire sac;
	
	

   public PJ ()
	{
      super();
	   this.droite = null;
	   this.gauche = null;
	}
   
   public PJ(Main dr, Main g)
   {
      super();
      this.droite = dr;
      this.gauche = g;
   }
   
   
	//redéfinire la méthode attaque

	
	
	   
	public void ramasserObjet (Objet a ) 
	{
	   //On entre dans l'algo que si il y a un objet a proximiter
	   if (this.objetPresent()==true)
	   {
	      if (this.assezDePA(4) == true)
	      {
	         this.setPointAction( this.getPointAction() -2 ); 
	      }
	   }
	      
	 
	}
	
	public void deposerObjet(Main a, Objet b) 
	{
	   if (this.existeObjet(a) == true)
	   {
	      
	   }
	   
		
	} 
	public void pointObj() {
	   
	}
	
	
	
   public void utiliserObjet (Objet obj, PJ J) {

	   if ((this.assezDePA(4) == true) && (objetPresent() == true))
      {
         this.setPointAction( this.getPointAction() -3); 
         int choiJoueur;
         int choiObjt;
         Scanner sc = new Scanner (System.in);
         if( obj instanceof Arme)
         {
            do {
               System.out.println("choisir la main : 1)droite ou 2)gauche");
               choiJoueur = sc.nextInt();
               if (choiJoueur == 1)
               {
                  if(J.existeObjet(droite) == false)
                  {
                     J.droite.setObj( obj );;
                     this.sac.remove(droite, obj); 
                  }
                  else if(this.sac.ContientObj() == true)
                     this.sac.getObj().get(1);// Je prend le premier objet de la liste
                   
               }
               else //(choiJoueur == 2)
               {
                  if(J.existeObjet(gauche) == false)
                  {
                    J.gauche.setObj( obj );;
                    this.sac.remove(gauche, obj);   
                  }
                  else if(this.sac.ContientObj() == true)
                    this.sac.getObj().get(1);// Je prend le premier objet de la liste
               }
            }while (choiJoueur!=1 && choiJoueur!=2);
         }
         else if( obj instanceof Bouclier)
         {
         }
         
         else if( obj instanceof Vetement)
         {
            
         }
      // Classe pas encore créée: else if( obj instanceof Potion)
      }

		 
	
	}
	

	
   public Main getDroite()
   {
      return droite;
   }

   public void setDroite(Main aDroite)
   {
      droite = aDroite;
   }

   public Main getGauche()
   {
      return gauche;
   }

   public void setGauche(Main aGauche)
   {
      gauche = aGauche;
   }

   public Inventaire getSac()
   {
      return sac;
   }

   public void setSac(Inventaire aSac)
   {
      sac = aSac;
   }

   public String toString() {
		return "J";
	}
}