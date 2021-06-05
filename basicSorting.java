import java.util.*;
public class basicSorting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int y[] = new int[10];
        for(int i = 1; i<=10; i++){
             y[i-1] = sc.nextInt();
        }    
        // BUBBLE SORT
        // for(int i = 0; i<y.length-1; i++){
        //      for(int j = 0; j<y.length-1-i; j++){
        //         if(y[j]>y[j+1]){
        //             int temp = y[j];
        //             y[j] = y[j+1];
        //             y[j+1] = temp;
        //             // for(int e: y){
        //             //     System.out.print(e + " ");
        //             //     }
        //         }        
        //         // }System.out.print("yes");
        //     }  
        // }
        
        
        //SELECETION SORT
        for(int i = 0 ; i<y.length-1; i++){
            int min = i;
            
            for(int j = i ; j<y.length; j++){
                if(y[min]>y[j]){
                    min = j;
                }
            }
            int temp = y[min];
                    y[min]= y[i];
                    y[i] = temp;
        }
        
        for(int i = 0; i<y.length ; i++){
            System.out.print(y[i] + " ");
        }
    }
}
