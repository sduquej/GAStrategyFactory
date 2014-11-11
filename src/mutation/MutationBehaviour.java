/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package mutation;

import java.util.List;

/**
 *
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 * @param <T> Object type of the chromosomes that will be mutated
 */
public abstract class MutationBehaviour<T> {

  /**
   * Constant with the probability for a mutation
   */
  protected final double MUTATION_FACTOR;
  
  /**
   * Default constructor, assigns a default value of 0.05 to the MUTATION_FACTOR
   */
  public MutationBehaviour() {
     MUTATION_FACTOR = 0.05; 
  }
  
  /**
   * Constructor with custom mutation factor
   * @param mutationFactor probability for a mutation to happen
   */
  public MutationBehaviour(double mutationFactor) {
    if(mutationFactor <= 1.00 && mutationFactor >= 0.00) {
      this.MUTATION_FACTOR = mutationFactor;
    } else {
      // Invalid parameter, might be good to throw an exception or something...
      throw new IllegalArgumentException("The value for mutation factor must be between 0 and 1, got: "+mutationFactor);
    }
  }
  
  /**
   * Iterates over the chromosomes of a given population and might mutate some
   * of them. Then returns the mutated population
   * @param population Current population
   * @return List of chromosomes after they are subject to mutation
   */
  public abstract List<T> mutate(List<T> population);
}
