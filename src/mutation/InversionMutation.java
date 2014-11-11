/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package mutation;

import java.util.List;


public class InversionMutation extends MutationBehaviour<char[]> {
  /**
   * {@inheritDoc}
   */
  public InversionMutation() {
    super();
  }
  
  /**
   * {@inheritDoc} 
   */
  public InversionMutation(double mutationFactor) {
    super(mutationFactor);
  }
  
  /**
   * {@inheritDoc}
   * InversionMutation swaps the position of the mutated allele with it's 
   * rightmost neighbour, if it's the last one swaps it with the first.
   * @return List of char[] objects after mutation
   */
  @Override
  public List<char[]> mutate(List<char[]> population) {
    // placeholder variable
    char temp;
    // iterate over every chromosome
    for (char[] cs : population) {
      // iterate over every allele
      for (int i = 0; i < cs.length; i++) {
        // if mutation happens
        if(Math.random()*1<MUTATION_FACTOR){
          if(i==cs.length-1){
            // If its the last allele swap with the first
            temp = cs[i];
            cs[i] = cs[0];
            cs[0] = temp;
          } else {
            // Swap with the next allele
            temp = cs[i];
            cs[i] = cs[i+1];
            cs[i+1] = temp;
          }
        }
      }
    }
    
    return population;
  }
}
