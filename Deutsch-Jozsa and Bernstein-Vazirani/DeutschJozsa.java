interface Function {
  int test(String s);
}

public class DeutschJozsa {
  /**
   * This method is to solve the Deutsch-Jozsa problem.
   * It can define if the function f is constant or balanced
   * f is constant if either f always outputs 0 or f always outputs 1
   * f is balanced if f outputs 0 on exactly half of the inputs
   * @param f a function f : {0,1}^n -> {0,1}
   * @param n the bit string size
   * @return return 0 if f is constant and 1 if f is balanced
   */
  public static int constant(Function f, int n) {
    //Generate a random binary bits string with size n
    String s = "";
    for (int i = 0; i < n; i++) {
      //Generate a random binary bit 0 or 1
      int b = ((int)(Math.random() * 100) + 1) % 2;
      String bit = Integer.toString(b);
      s += bit;
    }

    //Caculate te number of possible inputs which is
    //the number of the function will be called
    int times = (int)Math.pow(2, n);

    //Count how many 1s the function outputs
    int count = 0;
    for(int i = 0; i < times; i++) {
      if(f.test(s) == 1) {
        count++;
      }
    }

    //Check if f is constant or balanced
    if (count == 0 || count == times) {
      //f is constant if either f always outputs 0 or f always outputs 1
      //It means the count value should be 0 or the number of times that the function is called
      return 0;
    } else {
      //f is balanced if f outputs 0 on exactly half of the inputs
      return 1;
    }
  }

  public static void main(String[] args) {
    Function funcSet = new Function() {
      @Override
      public int test(String s) {
        double random = Math.random();
        if (random < 0.5) {
          return 0;
        } else {
          return 1;
        }
      }
    };

    int output = constant(funcSet, 3);
    System.out.println(output);
  }
}