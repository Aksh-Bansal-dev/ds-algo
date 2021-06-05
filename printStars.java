import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) {
    //   for(int i = 1; i<=10; i++){
    //       for(int j = 1; j<=10; j++){
    //           System.out.print(i*j + " ");
    //       }
    //       System.out.println(" ");
    //   }
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    for(int i = 1; i<=x; i++){
        
        for(int j= 1; j<=i; j++){
            System.out.print("* ");
        }
        for(int f = x; f>i; f--){
            System.out.print("o ");
        }
        for(int a = x; a>i; a--){
            System.out.print("o ");
        }
        for(int b= 1; b<=i; b++){
            System.out.print("* ");
        }
        System.out.println(" ");
        if(i ==x){
            for(int k=1 ; k<=x ; k++){
                for(int m = 1; m<=k; m++){
                    System.out.print("o ");
                }
                for(int n = x; n>k; n--){
                    System.out.print("* ");
                    
                }
                for(int c = x; c>k; c--){
                    System.out.print("* ");
                    
                }
                for(int d = 1; d<=k; d++){
                    System.out.print("o ");
                }
                System.out.println(" ");
            }
        }
        
    }

      
    }
}
