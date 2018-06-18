   import java.util.Random;
   import java.util.Scanner;




public class Map
{
      private int ligne = 30;
      private int colonne = 30;
      private Random r = new Random();
      
      //private Entite map[][] = new Entite[ligne][colonne]; //avec entite
      //protected String map[][] = new String[ligne][colonne];
      protected char map[][] = new char[ligne][colonne];
      
      public Map() {
    	  int rempli = 0;
    	  for(int i = 0 ; i<this.colonne ; i++){
              for(int j = 0 ; j<this.ligne ; j++)
               {
                   if (i == 0 || i == this.colonne-1 ||j == 0 || j == this.ligne-1)
                   {
                       map[i][j] = '#'; 
                   }
                   else 
                   {
                     int al = 1 + r.nextInt(20);
                     int m = 1 + r.nextInt(200);
                     if( al < 2 ) 
                     {
                        map[i][j] = '#';
                     }
                     else if( m < 2 && rempli == 0  )
                     {
                    	 map[i][j] = 'M';
                     }
                  	 else             
                        map[i][j] = ' ';
                   }
               }
           
           }
       }
      
      public Map(int ligne,int colonne) {

      }  
      
      public void placer(int ligne, int colonne, char deplace) {
                  
         // test si perso est dans la map
         if (ligne < 0 || colonne < 0 || ligne > getLigne() || colonne > getColonne()) {
            System.out.println("Problème, personnage non dans la grille");
            return; // pour quitter directement si y'a une erreur
         }
         
         if(this.map[ligne][colonne] == ' ')  {
            this.map[ligne][colonne] = deplace;
         }
         else {
            System.out.println("Erreur, la place est déja occupée");
         }
      }
      
         
      public int seDeplacer(int direction) {
    	  /*Pour se déplacer :
           * Voir si le personnage est dans la map
           * 1) il faut 2PA minimum 
           * 2) Une case vide qui m'entoure
           */
    	 
    	 char deplacer;
                  
         for(int i = 0 ; i < ligne ; i++ ) {
            for(int j= 0 ; j < colonne ; j++) {
               
               if( direction == 1) // deplacement haut
               { 
                  if( map[i][j] == 'J') 
                  {
                	 if(!(map[i-1][j] == ' ')) 
                 	 {
                 		 System.out.println("La case est occupé");
                 		 return 0;
                 	 }
                     if( i-1 >= 0 && map[i-1][j] == ' ' )
                     { 
                        deplacer = map[i][j]; // stock position joueur
                        map[i][j] = ' '; // on met a vide sa position
                        map[i-1][j] = deplacer; // on deplace joueur
                        return 1;
                     }
                  }
               }
               
               if( direction == 2 ) // deplacement bas
               { 
                  if( map[i][j] == 'J') 
                  {
                	 if(!(map[i+1][j] == ' ')) 
                 	 {
                 		 System.out.println("La case est occupé");
                 		 return 0;
                 	 }
                     if( i+1 <= colonne && map[i+1][j] == ' ' )
                     { 
                        deplacer = map[i][j]; // stock position joueur
                        map[i][j] = ' '; // on met a vide sa position
                        map[i+1][j] = deplacer; // on deplace joueur
                        return 1; // obliger pour pas que'J' vas tout en bas
                     }
                  }
               }
               
               if( direction == 3 ) // deplacement gauche
               { 
                  if( map[i][j] == 'J') 
                  {
                	 if(!(map[i][j-1] == ' ')) 
                 	 {
                 		 System.out.println("La case est occupé");
                 		 return 0;
                 	 }
                     if( j-1 >= 0 && map[i][j-1] == ' ' )
                     {  
                        deplacer = map[i][j]; // stock position joueur
                        map[i][j] = ' '; // on met a vide sa position
                        map[i][j-1] = deplacer; // on deplace joueur
                        return 1;
                     }
                  }
               }
               
               
               if( direction == 4) // deplacement droite
               { 
                  if( map[i][j] == 'J') 
                  {
                	 if(!(map[i][j+1] == ' ')) 
                	 {
                		 
                		 return 0;
                	 }
                     if( j+1 <= ligne && map[i][j+1] == ' ' )
                     {                       
                        deplacer = map[i][j]; // stock position joueur
                        map[i][j] = ' '; // on met a vide sa position
                        map[i][j+1] = deplacer; // on deplace joueur
                        return 1; // Pareille pour le probleme du deplacement bas
                     }
                  }
               }
         } // boucle 1er for
         } // boucle 2eme for
         return 1;
      }
      
      public boolean existeCible()
      {
         for( int i=0;i< getLigne(); i++)
         {
            for( int j=0;j< getColonne(); j++)
            {
               if ((map[i][j] == 'J') && !((map[i][j+1] == ' ') || (map[i][j+1] == '#'))) {
                  //System.out.println("Perso en vue (a gauche)");            	 
                  return true;
               }
               else if ((map[i][j] == 'J') && !((map[i][j-1] == ' ') || (map[i][j-1] == '#')))
                 // System.out.println("Perso en vue (a droite)");
                  return true;
              
               else if ((map[i][j] == 'J') && !((map[i+1][j] == ' ') || (map[i+1][j] == '#')))
                  //System.out.println("Perso en vue (deriere)");
                  return true;
               
               else if ((map[i][j] == 'J') && !((map[i-1][j] == ' ') || (map[i-1][j] == '#')))
                  //System.out.println("Perso en vue (en face)");
                  return true;
            }
         }
         return false;
       }
      
      //Methode pour déterminer le type d'objet
      public boolean typeObjetPresent(int a, int b)
      {
         for( int i=0;i< getLigne(); i++)
         {
            for( int j=0;j< getColonne(); j++)
            {
               if ( (map[i][j] == 'J') && (map[a][b] == 'A'))
               return true; //présence d'une Arme
           
               else if ((map[i][j] == 'J') && (map[a][b] == 'B'))
                     return true;//présence d'un Bouclier
               
               else if ((map[i][j] == 'J') && (map[a][b] == 'V'))      
                     return true;//présence d'un vetement
               
               else if ((map[i][j] == 'J') && (map[a][b] == 'S'))      
                     return true;//présence d'une Potion Soin
               
               else if ((map[i][j] == 'J') && (map[a][b] == 'E'))      
                     return true;//présence d'une Potion explosion
            }
         }
         return false;  
      }
      
      //Méthode pour déterminer si il y a un objet a proximité
      public boolean objetPresent()
      {
         for( int i=0;i< getLigne(); i++)
         {
            for( int j=0;j< getColonne(); j++)
            {
               if ( (map[i][j] == 'J') && (typeObjetPresent(i,(j+1)) == true))
                  return true; //présence d'un objet
               else if ((map[i][j] == 'J') && (typeObjetPresent(i,(j-1)) == true))
                     return true;//présence d'un objet
             
               else if ((map[i][j] == 'J') &&(typeObjetPresent((i+1),j) == true))      
                     return true;//présence d'un objet
               
               else if ((map[i][j] == 'J') && (typeObjetPresent((i-1),j) == true))      
                     return true;//présence d'une objet
          
            }
         }
         return false;  
      }
      
      public char getCase(int l , int c) {
         return map[l][c];
      }
      
      public int getColonne() {
         return colonne;
      }

      public void setColonne(int colonne) {
         this.colonne = colonne;
      }

      public int getLigne() {
         return ligne;
      }

      public void setLigne(int ligne) {
         this.ligne = ligne;
      }
      public void afficher() {
         for(int i = 0 ; i < this.colonne ; i++){
                 for(int j = 0 ; j < this.ligne ; j++)
                  {
                 System.out.print(map[i][j]); 
                  }                                
         System.out.print("\n");
         }
      }
   
}
