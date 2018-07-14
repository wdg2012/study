package demo1;

import java.util.List;

public class Test {
   public static void main(String[]args){
       Integer[]arrs = {8,9,1,3,7,10,2};
       Tree tree = new Tree();
       for (Integer value:arrs){
           tree.insert(value);
       }
       tree.select();

   }
}
