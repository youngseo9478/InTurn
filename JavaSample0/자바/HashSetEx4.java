package day4_7;
/*
 * ###Iterator###
 * public interface Iterator<E>
An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework. 
Iterators differ from enumerations in two ways:

1.Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
2.Method names have been improved.

This interface is a member of the Java Collections Framework.

###iterator()###
Iterator<E> iterator()
Returns an iterator over the elements in this set. 
The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
*/
import java.util.*;
public class HashSetEx4 {

	public static void main(String[] args)
	{
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHap = new HashSet();
		HashSet setCha = new HashSet();
		HashSet setKyo = new HashSet();
		
		setA.add("1");	setA.add("2");
		setA.add("3");	setA.add("4");
		setA.add("5");
		System.out.println("A = "+setA);
		
		setB.add("4");	setB.add("5");
		setB.add("6");	setB.add("7");
		setB.add("8");
		System.out.println("B = "+setB);
		
		//교집합은 A와 B가 동시에 가지는 원소를 나타냄
		Iterator it = setB.iterator();
		while(it.hasNext())
		{
			Object tmp = it.next();
			if(setA.contains(tmp)) //setB의 원소가 setA에 포함되면 setKyo에 넣는것
				setKyo.add(tmp);
		}
		
		//A-B는 A에는 포함되나 B는 가지지 않는 값들로만 모아야 한다.
		it = setA.iterator();
		while(it.hasNext())
		{
			Object tmp = it.next();
			if(!setB.contains(tmp)) //B가 A의 원소를 포함하지 않는 setA의원소를 setCha에 넣어준다.
				setCha.add(tmp);
		}
		
		//합집합은 setA,setB 둘다 setHap에 넣으면 알아서 중복된 값은 저장되지 않음.
		it = setA.iterator();
		while(it.hasNext())
			setHap.add(it.next());		
		it = setB.iterator();
		while(it.hasNext())
			setHap.add(it.next());
		
		System.out.println("A교집합B = "+setKyo);
		System.out.println("A차집합B = "+setCha);
		System.out.println("A합집합B = "+setHap);
	}
}
