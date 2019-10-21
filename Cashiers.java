import java.util.*;
public class Cashiers{
   public static int[][] queues;
   public static int cust;
   public static int currentSize[];
   public static int index[];
   public static int bk[];
   public static int f[];
   public static String input;
   
   public Cashiers(){
      queues= new int [3][6];
      bk= new int[3];
      f= new int[3];
      currentSize= new int[3];
      cust= 1;
   }
   public static void main(String[] args){
   /*
      For f and bk arrays, can use index and value as address for f and bk numbers 
   */
      Scanner kb= new Scanner(System.in);
      new Cashiers();
      bk[0] = 5;
      bk[1] = 5;
      bk[2] = 5;
      display();
      do{
      System.out.println("Input command E, 1, 2, 3, F, C, or Q: ");
      input= kb.nextLine().toUpperCase();
      switch(input){
            case "E":
            enqueue();
            break;
            case "1":
            dequeue(0);
            break;
            case "2":
            dequeue(1);
            break;
            case "3":
            dequeue(2);
            break;
            case "F":
            fill();
            break;
            case "C":
            clear();
            break;
            case "Q":
            break;
            default:
            System.out.println("Invalid input!");
            break;
      }
      
      }while(!input.equals("Q"));
   }
   public static void clear(){
      for(int a= 0; a< queues.length; a++){
         for(int b= 0; b< queues[a].length; b++){
            queues[a][b]= 0; 
         }
         currentSize[a]= 0;
      }
      display();
   }
   public static void fill(){
      clear();
            for(int a= 0; a < queues.length; a++){
            if(cust == 18)
            break;
            for(int b= 0; b < queues[a].length; b++){
            if(queues[a][b] == 0){
               queues[a][b] = cust;
               cust++;
            }
         }
         currentSize[a]= 6;
      }
      display();
   }
   public static void display(){
      for(int a= 0; a < queues.length; a++){
         System.out.println();
         for(int b= 0; b < queues[a].length; b++){
            System.out.printf("%3d", queues[a][b]);
            if(b == f[a])
            System.out.print("F");
            if(b == bk[a])
            System.out.print("B");               
            System.out.printf(" \t");
         }
      }
      System.out.println("\n");
   }
   public static int dequeue(int which){//Remove f and pick new f
      
      switch(which){
         case 0:
               if(queues[0][f[0]] == 0){
                  System.out.println("It's empty!");
                  f[0]= 0;
                  }else{
                  System.out.println("Customer "+ queues[0][f[0]]+ " is finished");
                  queues[0][f[0]]= 0;
                     if(f[0] == 5){
                     f[0] = 0;
                     currentSize[0]--;
                     }else{
                     f[0]++;
                     currentSize[0]--;
                  }
               }
            break;
         case 1:
               if(queues[1][f[1]] == 0){
                  System.out.println("It's empty!");
                  f[1]= 0;
               }else{
                  System.out.println("Customer "+ queues[1][f[1]]+ " is finished");
                  queues[1][f[1]]= 0;
                  if(f[1] == 5){
                     f[1] = 0;
                     currentSize[1]--;
                  }else{
                     f[1]++;
                     currentSize[1]--;
                  }
               }
            break;
         case 2:
               if(queues[2][f[2]] == 0){
                  System.out.println("It's empty!");
                  f[2]= 0;
               }else{
                  System.out.println("Customer "+ queues[2][f[2]]+ " is finished");
                  queues[2][f[2]]= 0;
                  if(f[2] == 5){
                     f[2] = 0;
                     currentSize[2]--;
                  }else{
                     f[2]++;
                     currentSize[2]--;
                  }
               }
            break;
      }
      display();
      return 1;
   }
   public static boolean enqueue(){
      int min= Math.min(Math.min(currentSize[0], currentSize[1]), currentSize[2]);      
      if(currentSize[0] == min && currentSize[1] == min && currentSize[2] == min){
            if(min == 6){
            System.out.println("No more room!");
            return false;
         }else{
            currentSize[0]++;
            if(bk[0]== 5)
               bk[0]= 0;
            else
               bk[0]++;  
               queues[0][bk[0]]= cust++;
         }
      }else if(currentSize[0] == min && currentSize[1] == min){
            currentSize[0]++;
            if(bk[0]== 5)
               bk[0]= 0;
            else
               bk[0]++;
               queues[0][bk[0]]= cust++;
      }else if(currentSize[0] == min && currentSize[2] == min){
            currentSize[0]++;
            if(bk[0]== 5)
               bk[0]= 0;
            else
               bk[0]++;
               queues[0][bk[0]]= cust++;
      }else if(currentSize[1] == min && currentSize[2] == min){
            currentSize[1]++;
            if(bk[1]== 5)
               bk[1]= 0;
            else
               bk[1]++;
               queues[1][bk[1]]= cust++;
      }else{
            if(min == currentSize[0]){
               currentSize[0]++;
               if(bk[0]== 5)
                  bk[0]= 0;
             else
                  bk[0]++;
                  queues[0][bk[0]]= cust++;
            }else if(min == currentSize[1]){
               currentSize[1]++;
               if(bk[1]== 5)
                  bk[1]= 0;
             else
                  bk[1]++;
                  queues[1][bk[1]]= cust++;
            }else if(min == currentSize[2]){
               currentSize[2]++;
               if(bk[2]== 5)
                  bk[2]= 0;
             else
                  bk[2]++;
                  queues[2][bk[2]]= cust++;
            }else
               System.out.println("No more room!");
      }
display();
return true;
   }
}