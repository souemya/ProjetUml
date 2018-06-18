public class Main extends Personnage 
{
   private Objet obj;
 
   public Main()
   {
      this.obj=null;
      
   }
   public Main (Arme a) { 
      this.obj = a;
   }
   
   public boolean existeObjet(Main a)
   {
      if (this.getObj()!= null)
         return true;
      else 
      {
         System.out.println( "pas d'objet" );
         return false; 
      }
   }
   
  
   public Objet getObj()
   {
      return obj;
   }

   public void setObj(Objet aObj)
   {
      obj = aObj;
   }

 
}