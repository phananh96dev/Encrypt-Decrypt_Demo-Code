import java.util.Scanner;
public class giaima{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char Alpha[] = new char[26]; //Bang chu cai ban dau.
		for(char i = 'A'; i <= 'Z'; i++){
			Alpha[i - 65] = i;
		}
		//Nhap ciphertext.
		String Cipher;
		System.out.print("Nhap CipherText: ");
		Cipher = input.nextLine();
		//Nhap Key.
		String Key;
		System.out.print("Nhap Key: ");
		Key = input.nextLine();
		//Giai ma.
		String Plain = "";
		int i = 0;
		while(i < Cipher.length()){
			char check = '@';
			for(int j = 0; j < 26; j++){
				if(Cipher.charAt(i) == Key.charAt(j)){
					Plain += Alpha[j];
					check = Alpha[j];
				}
			}
			if(check == '@'){
				Plain += Cipher.charAt(i);
			}
			i++;
		}
		//In plaintext.
		System.out.println("PlainText: " + Plain);
	}
}