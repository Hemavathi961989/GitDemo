package UGO;

import java.util.Scanner;

public class Cylinderheightdia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		float d, h, r, v, tsa, p, lsa, pi = 3.142f;

		System.out.println("Entrez le diamètre: ");
		d = sc.nextFloat();
		System.out.println("Entrez la hauteur: ");
		h = sc.nextFloat();

		r = d / 2;
		System.out.println("Rayon de la cylindre: " + r + "cms");

		v = pi * r * r * h;
		System.out.println("Volume du cylindre: " + v + "cms");

		tsa = 2 * pi * r * (h + r);
		System.out.println("Surface totale du Cylindre: " + tsa + "Square units");

		p = (2 * d) + (2 * h);
		System.out.println("Périmètre du Cylindre: " + p + "cms");

		lsa = 2 * pi * r * h;
		System.out.println("Surface latérale du cylindre: " + lsa + "Square units");

	}

}
