package day30;
/*parser : 번역, 분석   ->파싱
 * 리턴형이 인터페이스일 수 있다. -> 연관성이 없는데도 
 * 기능상을 구현되는건 똑같은데(ㅁㅔ소드는 같은데) 객체는 서로 다른 걸 사용하게됨*/

interface Parsable
{
	//구문 분석 잡업을 수행한다.
	public abstract void parse(String fileName);
}

class ParserManager
{
	//리턴타입이 parsable인터페이스읻.
	public static Parsable getParser(String type)
	{
		if(type.equals("XML"))
		{
			return new XMLParser();
		}//if,else 에 써놓은것처럼 두가지가똑같은 결과인데 참고하라고 두종류로 만들어 본것이고 덧붙이자면 if에 쓴 방식이 더 간결해서 좋다.
		else
		{
			Parsable p = new HTMLParser();
			return p;
			//return new HTMLParser();
		}
	}
}

class XMLParser implements Parsable
{
	public void parse(String fileName)
	{
		System.out.println(fileName+"- XML parsing completed");
	}
}
class HTMLParser implements Parsable
{
	public void parse(String fileName)
	{
		System.out.println(fileName+"- HTML parsing completed");
	}
}

public class ParserTest {

	public static void main(String[] args)
	{
		Parsable parser = ParserManager.getParser("XML");
		parser.parse("document1.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
		
	}
}
