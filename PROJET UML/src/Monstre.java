
public class Monstre extends PNJ {
	
	
		public Monstre (int force,int adr,int vie, int resistance,int pointAction) {
			super();
			this.force = force;
			this.adresse = adr;
			this.resistance = resistance;
			this.pointAction = pointAction;
			this.vie = vie;
			this.attaque();
			this.defense();
			this.degat();
			this.initiative();
			this.esquive();		
		}
		 
		/* public void initaliser()
		 {
				this.initiative(5,3);
				this.esquive(5,3);
				this.attaque(5,3);
				this.defense(5,3);
				this.degat(5,3);
				
		 }*/
		
		 public String toString() 
		 {
			return "M";
		 }
	 

}
