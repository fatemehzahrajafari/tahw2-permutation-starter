package ir.ac.kntu;
import java.util.Arrays;

public class Permutation {
    public static String[] permutation;
    
    public static int index=0;
	public static int fact(int num){
		if(num==1 || num==0){
			return (1);
		}
		else{
			return (num*fact(num-1));
		}
	}
    
    
    public static void perm1(String s) { 
        perm2("",s);
    }
    public static void perm2(String prefix,String remain) { 
		if(remain.length()==1){
			String newString=prefix.concat(remain);
			permutation[index]=newString;
			index++;
		}
		else{
			for(int i=0,j=0;i<remain.length();i++,j++){
				String aldString=remain.substring(0,i)+remain.substring(i+1,remain.length());
				String helpString=prefix+Character.toString(remain.charAt(i));
				perm2(helpString,aldString);
				}
		}
    }
    public static void main(String[] args) {
		String args1=args[0];
		String args2=args[1];
		int number1=Integer.parseInt(args1);
		int number2=Integer.parseInt(args2);
		int number=number2-number1;
		char[] permArray=new char[number];
		for(int i=number1,m=0;i<number2;i++,m++){
			if(i>=0 && i<26){
				permArray[m]=(char)(i+97);
			}
			if(i>=26 && i<52){
				permArray[m]=(char)(i+39);
			}
		}
		String s=new String(permArray);
		if(number1==number2){
			permutation=new String[0];
		}
		else if(number1<0 || number2>52){
			permutation=new String[0];
		}
		else{
		permutation=new String[fact(s.length())];
		perm1(s);
		}
		System.out.println(Arrays.toString(permutation));
        
    }
}
