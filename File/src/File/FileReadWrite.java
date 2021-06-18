package File;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileReadWrite {
	public static void main(String args[]) throws IOException{
		FileInputStream fileIn;
		
		File file = new File("Test.txt");
		
		FileOutputStream fileOut= new FileOutputStream(file,true);
		fileIn = new FileInputStream(file);
		
		String text = "Hello Good morning";
		
		for(int i=0;i<text.length();i++) {
			fileOut.write(text.charAt(i));
		}
		
		System.out.println("Written in file");
		
		int character;
		
		while((character =fileIn.read())!=-1) {
			System.out.print((char)character);
		}
		
		fileOut.close();
		fileIn.close();
	}
}
