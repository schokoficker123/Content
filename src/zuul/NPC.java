package zuul;

public class NPC {
	
	 private String name;
	    private String text;

	    public NPC(String name, String text) {
	        this.text=text;
	        this.name=name;
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
	
	

}
