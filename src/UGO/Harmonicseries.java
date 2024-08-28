package UGO;

public class Harmonicseries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double sum = 0;
		for (double i = 1; i <= 6; i++)

		{
			sum = sum + 1 / i;
		}

		System.out.println("La somme des 6 premiers termes de la série est " + sum);
	}
}