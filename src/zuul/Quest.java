	package zuul;

public class Quest {

	private String nameDerQuest;
	private String aufgabe;

	public Quest(String nameDerQuest, String aufgabe) {
		this.aufgabe = aufgabe;
		this.nameDerQuest = nameDerQuest;
	}

	@Override
	public String toString() {

		return "\n" + nameDerQuest + "\n " + "Aufgabe: " + "\n" + this.aufgabe;
	}

	public String getName() {
		return this.nameDerQuest;
	}

}
