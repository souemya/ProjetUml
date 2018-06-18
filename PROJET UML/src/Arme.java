
public class Arme extends Objet{
  private int maniabilite;
  private int impact;
	
	public Arme () {
		this.maniabilite = 0;
		this.impact=0;
	}
	
	
	
	 public int getManiabilite()
   {
      return maniabilite;
   }



   public void setManiabilite(int aManiabilite)
   {
      maniabilite = aManiabilite;
   }



   public int getImpact()
   {
      return impact;
   }



   public void setImpact(int aImpact)
   {
      impact = aImpact;
   }



   public String toString()
	 {
			return "A";
	 }
}
