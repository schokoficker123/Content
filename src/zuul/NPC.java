package zuul;

public class NPC {
	
	 private String name;
	    private String text;
	    private String kurzbeschreibung;
	    private String questname;

	    public NPC(String name, String text, String questname, String kurz) {
	        this.text=text;
	        this.name=name;
	        this.kurzbeschreibung=kurz;
	        this.questname=questname;
	    }

		@Override
	    public String toString() {
	        return name + ": \n" + this.text + "\n wenn du diese Quest annehmen möchtest tippe: questaccept " + this.questname;
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
	    public String getQname() {
	    	return this.questname;
	    }
}
