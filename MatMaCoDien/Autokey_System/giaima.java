import java.util.Scanner;
public class giaima{
	public static String FormatKey(String C, String K){
		int l = K.length();
		if(l >= C.length()){
			return K;
		} else{
			for(int i = 0; i < C.length() - l; i++){
				K += C.charAt(i);
			}
			return K;
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
		System.out.print("Nhap Key (Day chu cai in hoa khong dau) voi Key <= Ciphertext: ");
		K = input.nextLine();
		input.close();
		//Do dai key:
		int m = K.length();
		//Format key de co do dai = P:
		K = FormatKey(C, K);
		//Giai ma:
		String P = "";
		int i = 0;
		while(i < C.length()){ //m){
			int ch = (((int)C.charAt(i) - 65) - (((int)K.charAt(i % m)) - 65)) % 26;
			if(ch < 0){
				ch += 26;
			}
			P += (char)(ch + 65);
			i++;
		}
		/*if(C.length() > m){
			i = m;
			while(i < C.length()){
				int ch = (((int)C.charAt(i) - 65) - (((int)K.charAt(i)) - 65)) % 26;
				if(ch < 0){
					ch += 26;
				}
				P += (char)(ch + 65);
				i++;
			}
		}*/
		System.out.println("-> PlainText: " + P);
	}
}