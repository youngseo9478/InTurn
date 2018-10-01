package day30;

interface MouseInterface
{
	static final float CLICK = 0.02f;
	public void rightClick();
}

class FileC implements MouseInterface
{
	String fileName;
	
	public void rightClick()
	{
		System.out.println("File class에서 마우스 우클릭을 하였습니다.");
		System.out.println("File의 이름 : "+fileName);
	}
}

class ImageC implements MouseInterface
{
	String imageName;
	int width, height;
	
	public void rightClick()
	{
		System.out.println("Image class에서 마우스 우클릭을 하였습니다.");
		System.out.println("image의 이름 : "+imageName);
		System.out.println("image의 사이즈 => 폭:"+width+", 높이 : "+height);

	}
}

public class InterfaceEx2 {

	public static void main(String [] args)
	{
		FileC fc = new FileC();
		fc.fileName="education.txt";
		fc.rightClick();
		
		System.out.print("=========================");
		System.out.println();
		
		ImageC ic = new ImageC();
		ic.imageName = "study_image.bmp";
		ic.width=400;
		ic.height=200;
		ic.rightClick();
	}
}
