import java.util.ArrayList;

public class Inventaire {
   
   private int nbrObjet;

	private ArrayList<Objet> Obj = new ArrayList<Objet> ();
	
	public Inventaire() 
	{
	  ArrayList<Objet> objet = new ArrayList<Objet> ();
	  this.nbrObjet = objet.size();
	}
	
	public Inventaire(int nbrObjet, ArrayList<Objet> objet) {
	   super();
	   this.nbrObjet = objet.size();
	   this.Obj = objet;
	}
	
	public Inventaire (Inventaire sac) {
	   this.nbrObjet = sac.nbrObjet;
	   this.Obj = sac.Obj;
	}
	
	public boolean maxEspace() {
	   if(this.getNbrObjet() > 20)
	      return false;
	   else
	      return true;
	      
	}

	
	public void ajoutObj(Objet o) {
	   if(this.maxEspace() == true)
	      Obj.add(o);
	   else 
	      System.out.println( "pas assez d'espace" );
	}
	

	public void supprimerObj(int sac) {
	   Objet o = this.choiObjet(sac);
	   Obj.remove( o );
	}
	
	public Objet choiObjet(int sac) {
	   return Obj.get(sac);
	}
	
	public boolean ContientObj() {
	   if(Obj.isEmpty() == true)
	      return false;
	   return true;
	}
	
	  public void remove(Main m,Objet o)
	   {
	      m.setObj( o );
	      
	   }
   public int getNbrObjet()
   {
      return nbrObjet;
   }

   public void setNbrObjet(int aNbrObjet)
   {
      nbrObjet = aNbrObjet;
   }

   public ArrayList<Objet> getObj()
   {
      return Obj;
   }

   public void setObj(ArrayList<Objet> aObj)
   {
      Obj = aObj;
   }

 
}