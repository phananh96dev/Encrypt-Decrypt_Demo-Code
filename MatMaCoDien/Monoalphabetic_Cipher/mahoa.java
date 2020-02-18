import java.util.Scanner;
import java.io.*;
public class mahoa{
	public static boolean IsExist(char[] arr, char c){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == c){
				return true;
			}
		}
		return false;
	}
	//
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char Alpha[] = new char[26]; //Bang chu cai ban dau.
		for(char i = 'A'; i <= 'Z'; i++){
			Alpha[i - 65] = i;
		}
		System.out.print("Day chu cai ban dau: ");
		for(int i = 0; i <= 25; i++){
			System.out.print(Alpha[i] + " ");
		}
		//Thay doi thu tu sap xep chu cai (KEY).
		char Key[] = new char[26];
		System.out.println("\nHay tao khoa bang cach thay doi thu tu cua day chu cai ban dau: ");
		int i = 0, c;
		do{
			System.out.print(Alpha[i] + " -> ");
			try{
				c = System.in.read();
				System.in.skip(2);
				if((char)c >= 'A' && (char)c <= 'Z'){
					if(IsExist(Key, (char)c) == false){
						Key[i] = (char)c;
						i++;
					} else{
						System.out.println("Chu cai nay da ton tai!");
					}
				} else{
					System.err.println("Ky tu khong hop le. Hay dam bao ky tu nhap la chu cai in hoa!");
				}				
			} catch(Exception ex){
				System.err.println("Loi nhap!");
			}
		} while(i < 26);
		System.out.print("Key da nhap: ");
		for(i = 0; i <= 25; i++){
			System.out.print(Key[i] + " ");
		}
		//Vong lap ma hoa.
		boolean cont = true;
		do{
			//Nhap plaintext.
			String Plain;
			System.out.print("\nNhap PlainText: ");
			Plain = input.nextLine();
			//Xu ly ma.
			String Cipher = "";
			i = 0;
			while(i < Plain.length()){
				char check = '@';
				for(int j = 0; j < 26; j++){
					if(Plain.charAt(i) == Alpha[j]){
						Cipher += Key[j];
						check = Key[j];
					}
				}
				if(check == '@'){
					Cipher += Plain.charAt(i);
				}
				i++;
			}
			//In ma.
			System.out.print("CipherText: " + Cipher);
			System.out.print("\nBan co muon tiep tuc ma hoa van ban khac khong ? (true / false): ");
			input.nextLine();
			cont = input.nextBoolean();
		} while(cont == true);	
	}
}