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
	        return name + ", " + this.text;
	    }

	    public String getName() {
	        return this.name;
	    }
	
	

}
