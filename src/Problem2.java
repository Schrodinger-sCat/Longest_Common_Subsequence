import java.io.File;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[]args){
        String[] m=new String[5];
        String[] p=new String[5];
        String[] friends1={"M", "W", "C", "A", "D", "B", "O", "E", "R", "P"};
        String[] friends2={"monkeys", "wearing", "coats", "are", "doctors", "because", "of", "evolution", "result", "eruption"};
        try {
            File f = new File("Input\\problem2_input.txt");
            Scanner sc = new Scanner(f);
            String main_sequence= sc.nextLine();
            String performed_sequence=sc.nextLine();
            m=main_sequence.split(" ");
            p=performed_sequence.split(" ");
            //System.out.println(main_sequence+"\n"+performed_sequence);
        }catch(Exception e){
            System.out.println("Input File not found!!!");
        }
        String[] st=new LCS(m, p).find();
        for(String s:st){
            if(s.length()!=1) System.out.print(s+" ");
            else{
                for(int i=0; i< friends1.length; i++){
                    if(friends1[i].equals(s)) System.out.print(friends2[i]+" ");
                }
            }
        }
    }
}
