
public class Objet {

	private String Obj;
	public final static String[] nomObjets = {"Arme", "Bouclier"};
	public final static String[] typePotion = {"Soin", "Explosion"};
	


	public Objet() {
		this.Obj = "";
		
	}


	public String getObj() {
		return Obj;
	}

	public void setObj(String obj) {
		Obj = obj;
	}
}
