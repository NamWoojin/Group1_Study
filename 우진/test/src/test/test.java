package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class test {
   static class T extends Thread{
      int sum = 0;
      
      public void run() {
         for(int i=1; i<=3; i++) {
            try {
               Thread.sleep(100);
            } catch (Exception e) {
               // TODO: handle exception
            }
            sum += i;
         }
      }
      
      int getSum() {
         return sum;
      }
   }
   public static void main(String[] args) throws Exception {
      T t1 = new T();
      t1.start();
      T t2 = new T();
      t2.start();
      
      System.out.println(t1.getSum() + t2.getSum());
   }
}