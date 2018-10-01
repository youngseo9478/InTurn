package day3_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;
import static java.lang.System.out;

class Able {
	String empno;
	int net, ejb, xml, total;

	public Able(int total) {
		this.total = total;
	}

	public Able(String no, int n, int e, int x) {
		empno = no;
		net = n;
		ejb = e;
		xml = x;
		total = n + e + x;
	}

	public int getTotal() {
		return total;
	}
}

// java.util에 Comparator라는 interface가 존재한다. (abstract보다 더 추상적개념)
class AbleComp implements Comparator<Able> {
	public int compare(Able obj1, Able obj2) {
		int var = 0;
		if (obj1.getTotal() > obj2.getTotal())
			var = 1;
		else if (obj1.getTotal() < obj2.getTotal())
			var = -1;

		return var;
	}
}

public class AbleEx1 {
	public static void main(String[] args) {
		Vector<Able> v = new Vector<Able>(2, 5);

		Able a1 = new Able("B123", 90, 75, 70);
		Able a2 = new Able("T723", 60, 90, 80);
		Able a3 = new Able("A427", 85, 80, 80);
		Able a4 = new Able("G523", 90, 90, 60);

		v.addElement(a1);
		v.addElement(a2);
		v.addElement(a3);
		v.addElement(a4);

		out.println("------sort 전 ----------");

		// for( A : B ) ->B에서 차례대로 객체를 꺼내서 A에다가 넣겠다
		for (Able n : v) // n=>a1,a2,a3,a4
		{
			out.println(n.empno + "," + n.getTotal());
		}
		/*
		 * size() : Vector class에 있는 메소드 : Returns the number of components in
		 * this vector.
		 */
		Able[] a = new Able[v.size()];//4개

		/* copyInto() : Copies the components of this vector into the specified array. The
		 item at index k in this vector is copied into component k of anArray*/
		v.copyInto(a);
		AbleComp comp = new AbleComp();
		Arrays.sort(a, comp);
		out.println("------sort 후 ----------");

		for (Able n : a) {
			out.println(n.empno + "," + n.getTotal());
		}
	}
}
