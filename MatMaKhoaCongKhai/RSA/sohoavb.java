import java.util.Scanner;
import java.io.*;
public class sohoavb{
	public static void main(String[] args){		
	//So hoa 1 ky tu
		/*char c;
		int i = 0;
		System.out.print("Nhap 1 ky tu: ");
		try{
			i = System.in.read();
			System.in.skip(2);
		} catch(IOException e){
			System.out.println(e);
		}		
		c = (char)i;
		System.out.println("Ky tu vua nhap: " + c);
		String bin = Integer.toBinaryString(i);
		System.out.println("Binary string: " + bin);
		int dec = Integer.parseInt(bin, 2);
		System.out.println("Decimal: " + dec);*/
	//So hoa 1 doan vb
		/*Scanner input = new Scanner(System.in);
		String data;
		System.out.print("Nhap 1 doan van ban: \n\t");
		data = input.nextLine();
		int n = data.length();
		int digit[] = new int[n];
		System.out.println("VB da duoc so hoa: ");
		for(int j = 0; j < n; j++){
			int ch = (int)data.charAt(j);
			digit[j] = ch;
			System.out.print(digit[j] + "\n");
		}*/
	//So hoa file
		try{
			File file = new File("vbtho.txt");
			FileInputStream fis = new FileInputStream(file);
			System.out.println("File vb da duoc so hoa: ");
			int d = 0;
			while((d = fis.read()) != -1){
				System.out.print(d + "\n");
			}
		} catch(Exception e){
			System.out.println(e);
		}		
	}
}