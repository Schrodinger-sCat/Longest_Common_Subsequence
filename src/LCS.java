import java.util.Arrays;

public class LCS {
    public String[] main_sequence;
    public String[] performed_sequence;
    public int[][] array;
    public LCS(String[] m, String[] p){
        this.main_sequence=m;
        this.performed_sequence=p;
        array= new int[m.length][p.length];
        for(int[] ar: array){
            Arrays.fill(ar, 0);
        }
        //System.out.println("test1");
    }
    public String[] find(){
        for (int i=0; i<main_sequence.length; i++) {
            for (int j=0; j<performed_sequence.length; j++) {
                if(main_sequence[i].equals(performed_sequence[j])){
                    if(i==0||j==0) array[i][j]=1;
                    else array[i][j]=array[i-1][j-1]+1;
                }
                else{
                    if(i==0 && j==0) array[i][j]=0;
                    else if(i==0 && j!=0) array[i][j]= array[i][j-1];
                    else if(i!=0 && j==0) array[i][j]= array[i-1][j];
                    else array[i][j]=max(array[i-1][j],array[i][j-1]);
                }
            }
        }
        //for(int[] a: array) System.out.println(Arrays.toString(a));
        int max=array[main_sequence.length-1][performed_sequence.length-1];
        if(max==0){
            System.out.println("No Subsequence!");
            System.exit(1);
        }
        String []st=new String[max];
        int n= performed_sequence.length;
        for (int i=main_sequence.length-1; i>=0; i--) {
            for (int j=0; j<n; j++){
                if(max==array[i][j]){
                    n=j;
                    max=max-1;
                    st[max]=performed_sequence[j];
                }
            }
            if(max==0) break;
        }
        return st;
    }
    public static int max(int m, int n){
        if(m>n) return m;
        return n;
    }
}
