
public class Word {
	public static void main(String[] args) throws InterruptedException {
		Save s=new Save();
		SpellCheck sp=new SpellCheck();
		Typing t=new Typing();
		Thread save=new Thread(s,"Save Document");
		Thread type=new Thread(t,"Type Document");
		Thread spell=new Thread(sp,"Spell Checking Document");
		type.setPriority(10);
		type.start();
		type.join();
		save.start();
		spell.start();
	}
}
