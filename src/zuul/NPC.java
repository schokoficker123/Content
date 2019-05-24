package zuul;

public class NPC {
	
	 private String name;
	    private String text;
	    private String kurzbeschreibung;

	    public NPC(String name, String text, String kurz) {
	        this.text=text;
	        this.name=name;
	        this.kurzbeschreibung=kurz;
	    }

		@Override
	    public String toString() {
	        return name + ": \n" + this.text;
	    }
		public String npcName() {
	        return name;
	    }

	    public String getName() {
	        return this.name;
	    }
	    
	    public String getKurz() {
	    	return this.kurzbeschreibung;
	    }
}
