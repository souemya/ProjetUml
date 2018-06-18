
public class Sorciere extends PNJ {
	
	
		 public Sorciere(){
			 this.initaliser();
		 }
	 
		public void initaliser()
		{
			this.initiative();
			this.esquive();
			this.attaque();
			this.defense();
			this.degat();
		}
			
		 public String toString() {
				return "S";

		 }
	}
