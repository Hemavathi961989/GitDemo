package UGO;

public class Charstroperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String txt = "Jouer avec Java";
		String tocompare = "Jouer avec Pierre";

		System.out.println("Longueur de la chaîne " + txt.length());
		System.out.println("Conversion en majuscule " + txt.toUpperCase());
		System.out.println("Conversion en minuscule " + txt.toLowerCase());
		System.out.println("Concaténation avec la chaîne " + txt.concat(":o)"));
		System.out.println("Remplacer le caractère " + txt.replace('r', 'z'));
		System.out.println("Comparer avec la chaîne " + txt.compareTo(tocompare));

	}

}
