/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package mutation;

import java.util.List;


public class AddMutation extends MutationBehaviour<char[]> {

  /**
   * {@inheritDoc}
   */
  public AddMutation() {
    super();
  }
  
  /**
   * {@inheritDoc} 
   */
  public AddMutation(double mutationFactor) {
    super(mutationFactor);
  }
  
  /**
   * {@inheritDoc}
   * AddMutation adds one to the value of the mutated allele, and if it's 9 it makes it 0.
   * @return List of char[] objects after mutation
   */
  @Override
  public List<char[]> mutate(List<char[]> population) {
    // iterate over every chromosome
    for (char[] cs : population) {
      // iterate over every allele
      for (int i = 0; i < cs.length; i++) {
        // if mutation happens
        if(Math.random()*1<MUTATION_FACTOR){          
          if(cs[i]!='9'){
            // If its not 9 it increases the value by one
            ++cs[i];
          } else {
            // Makes it 0
            cs[i] = '0';
          }
        }
      }
    }
    return population;
  }
}
