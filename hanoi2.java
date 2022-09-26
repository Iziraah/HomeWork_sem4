import java.util.Scanner;
public class hanoi2 {
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество дисков: ");
        int n = in.nextInt();
        in.close();
        hanoi(n, 1, 2);
    }

    
    public static void hanoi(int n, int a, int b) {
        if(n==1){
            System.out.printf("Перемещаем диск 1 с %d на %d\n", a,b);
        }
        else {
            int c = 6 - a -b;
            hanoi(n-1, a,c);
            System.out.printf("Перемещаем диск %d с %d на %d\n",n, a,b);
            hanoi(n-1, c, b);
        }       
    }
    } 
