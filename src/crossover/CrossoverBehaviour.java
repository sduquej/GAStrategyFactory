/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package crossover;

import java.util.List;

/**
 *
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 * @param <T> Chromosome's type
 */
public abstract class CrossoverBehaviour<T> {

  public CrossoverBehaviour() {
  }
  
  /**
   * Iterates over the chromosomes of a given population and performs crossover
   * @param population Current population
   * @return List of chromosomes after crossover has happened
   */
  public abstract List<T> crossover(List<T> population);
}
