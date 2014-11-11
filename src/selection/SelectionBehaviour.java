/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package selection;

import fitness.FitnessEvaluator;
import java.util.List;

/**
 *
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 * @param <T> Chromosome's type
 */
public abstract class SelectionBehaviour<T> {
  FitnessEvaluator<T> fe;
  
  /**
   * Most SelectionBehaviours are based on the fitness of the chromosomes
   * The default constructor assigns the FitnessEvaluator that will be used.
   * @param fe 
   */
  public SelectionBehaviour(FitnessEvaluator<T> fe) {
    this.fe = fe;
  }
  
  /**
   * Performs selection on a given population and returns the selected individuals.
   * @param population Current population
   * @return List of selected chromosomes for crossover
   */
  public abstract List<T> select(List<T> population);

}
