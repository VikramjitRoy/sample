public class MaximumTest {
   // to determine the largest of three Comparable objects
   
   public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
      T max = x;   // assuming x is initially the largest
      
      if(y.compareTo(max) > 0) {
         max = y;   // y is the largest now
      }
      
      if(z.compareTo(max) > 0) {
         max = z;   // z is the largest now                 
      }
      return max;   // returning the largest object   
   }
   
   public static void main(String args[]) {
      System.out.printf("Max of %d, %d and %d is %d\n\n", 
         9, 4, 5, maximum( 9, 4, 5 ));

      System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
         6.9, 8.2, 7.5, maximum( 6.9, 8.2, 7.5 ));

      System.out.printf("Max of %s, %s and %s is %s\n","hi",
         "hello", "there", maximum("hi", "hello", "there"));
   }
}