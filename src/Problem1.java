import java.io.File;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[]args){
        String[] m=new String[5];
        String[] p=new String[5];
        try {
            File f = new File("Input\\problem1_input.txt");
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
        for(String s:st) System.out.print(s+" ");
        double percentage=((double)st.length/(double)m.length)*100;
        System.out.print("\n"+percentage+"%");
        if(percentage>=50.0) System.out.print(" PASSED");
        else System.out.print(" Failed");
    }
}
