/**
 * Treesort --- Class to sort integers provided by the user from least to greatest. Does this by performing
 * repeated inserts into a DictBinTree object for every given integer, followed by calling orderedTraversal.
 * @author      Torvald Johnson
 * SDU Login:   tjohn16
 */
 
import java.util.Scanner;

public class Treesort {
  /**
   * The scanner will continue to accept and insert integers, separated by whitespace, until a non-initeger 
   * character or the end-of-file character is sent (using Ctrl-D on mac or linux, and Ctrl-Z on windows.)
   * Then orderedTraversal is run, and the output is printed to the console.
   */
  public static void main(String[] args){
    Dict d = new DictBinTree();
    
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter an integer");
    
    while (in.hasNext()) {
        if (in.hasNextInt()) {
            d.insert(in.nextInt());
        }
        else { 
            break;
        }
    }
    
    int[] list = d.orderedTraversal();
  	System.out.println("Output is:");	
  	for (int i=0; i<list.length; i++) {
  	    System.out.print(" " + list[i]);
  	}
  }
}