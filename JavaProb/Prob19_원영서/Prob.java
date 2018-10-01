package porb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Prob {

	public static void main(String[] args) {
		String file1 = "c://file/text1.txt";
		String file2 = "c://file/text2.txt";

		ArrayList list = null;
		Iterator<String> it = null;

		FileCompareUtil fcu = new FileCompareUtil();
		try {
			list = fcu.compareFile(file1, file2);
			it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class FileCompareUtil {

	FileReader fr1 = null;
	FileReader fr2 = null;
	BufferedReader br1 = null;
	BufferedReader br2 = null;

	ArrayList compareFile(String fstFileName, String scdFileName) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		try {
			fr1 = new FileReader(fstFileName);
			fr2 = new FileReader(scdFileName);

			br1 = new BufferedReader(fr1);
			br2 = new BufferedReader(fr2);

			String read1 = null;
			String read2 = null;
			int count = 0;
			while ((read1 = br1.readLine()) != null && (read2 = br2.readLine()) != null) {
				count++;
				if (!read1.equals(read2)) {
					list.add("LINE" + count + ":" + read2);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(fr1 + ", " + fr2 + "파일을 모두 준비해주세요");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr1 != null)
					fr1.close();
				if (fr2 != null)
					fr2.close();
				if (br1 != null)
					br1.close();
				if (br2 != null)
					br2.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}
}