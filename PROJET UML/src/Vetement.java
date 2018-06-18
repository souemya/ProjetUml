//******************************************************************
// Nom de la classe : Vetement
// Nom du projet    : ProjetUml
// Nom du fichier   : Vetement.java
// Creation         : 16 juin 2018
// Créateur         : Soumeya Souid 
// Commentaire 	  : 
//******************************************************************
public class Vetement extends Objet 
{
   private int encombrement;
   private int solidite;
   
   public Vetement()
   {
      this.encombrement= 5;
      this.solidite=10;
   }
   
   
   
   
   public int getEncombrement()
   {
      return encombrement;
   }
   public void setEncombrement(int aEncombrement)
   {
      encombrement = aEncombrement;
   }
   public int getSolidite()
   {
      return solidite;
   }
   public void setSolidite(int aSolidite)
   {
      solidite = aSolidite;
   }

}
