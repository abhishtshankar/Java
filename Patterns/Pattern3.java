/*
    1
   101
  10101
 1010101
101010101
*/
public class Pattern3 {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            for(int j=4;j>=i;j--){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print(j%2);
            }
            System.out.println();
        }
    }
}
