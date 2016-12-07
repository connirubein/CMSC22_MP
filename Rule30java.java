import java.util.Scanner;

public class Rule30java{
 public static final int theThreads = 10;
 
 public static void main(String[] args) throws Exception{
   
   int first = 1;
   int a = 0;
   Scanner sc = new Scanner(System.in);
   int x = sc.nextInt();
   
   int[][] table = new int[theThreads][theThreads];
   
   for(int i=0; i<x; i++){
    for (int j=0; j<x; j++){
     table[i][j] = a;
    }
   }
   
   table[0][x/2] = first;
   int j = 0;
   for(; j<x-1; j++){
    System.out.print(table[0][j]);
   }
   
   System.out.println(table[0][j]);
   
   Baliog_MP5[] newThread = new Baliog_MP5[theThreads];
   
   int last = 1+(x / theThreads)-first;
   int i = 0;
   for (int b = x/theThreads; i < theThreads; i++) {
     if (i == theThreads-first) {
       last = x;
     }
     
    newThread[i] = new Baliog_MP5(table, first, last);
    first = last;
    last = first + b;
   }

   for (i = 0; i < theThreads; i++) {
    newThread[i].start();
    while (true) {
      if (! newThread[i].isAlive()){
        break;
      }
      try {
        newThread[i].join();
      }
      catch (Exception e) {
      }
   }
  }
   
 }

}