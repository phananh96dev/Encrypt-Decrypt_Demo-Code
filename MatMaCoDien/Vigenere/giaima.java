import java.util.Scanner;
public class giaima{
	public static String FormatKey(String key, int len){
		if(key.length() >= len){
			return key;
		} else{
			String f = "";
			int i = 0, j = 0;
			while(i < len){
				f += key.charAt(j);
				if(j == key.length()-1){
					j = 0;
				} else{
					j++;
				}
				i++;
			}
			return f;
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//Nhap CipherText:
		String C;
		System.out.print("Nhap CipherText (Day chu cai in hoa khong dau): ");
		C = input.nextLine();
		//Nhap Key:
		String K;
		System.out.print("Nhap Key (Day chu cai in hoa khong dau): ");
		K = input.nextLine();
		input.close();
		//Do dai key:
		int m = K.length();
		//Format key de co do dai = P:
		K = FormatKey(K, C.length());
		//Giai ma:
		String P = "";
		int i = 0;
		while(i < C.length()){
			int ch = (((int)C.charAt(i) - 65) - (((int)K.charAt(i % m)) - 65)) % 26;
			if(ch < 0){
				ch += 26;
			}
			P += (char)(ch + 65);
			i++;
		}
		System.out.println("-> PlainText: " + P);
	}
}