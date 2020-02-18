import java.util.Scanner;
public class mahoa{
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
		//Nhap PlainText:
		String P;
		System.out.print("Nhap PlainText (Day chu cai in hoa khong dau): ");
		P = input.nextLine();
		//Nhap Key:
		String K;
		System.out.print("Nhap Key (Day chu cai in hoa khong dau): ");
		K = input.nextLine();
		input.close();
		//Do dai key:
		int m = K.length();
		//Format key de co do dai = P:
		K = FormatKey(K, P.length());
		//Ma hoa:
		String C = "";
		int i = 0;
		while(i < P.length()){
			int ch = (((int)P.charAt(i) - 65) + (((int)K.charAt(i % m)) - 65)) % 26;
			if(ch < 0){
				ch += 26;
			}
			C += (char)(ch + 65);
			i++;
		}
		
		System.out.println("-> CipherText: " + C);
	}
}