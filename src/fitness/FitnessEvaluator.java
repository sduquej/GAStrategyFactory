/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package fitness;

import java.util.List;

/**
 * Interface for fitness evaluation
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 * @param <T> Object type of the chromosomes that will be evaluated
 */
public interface FitnessEvaluator<T> {

  /**
   * Returns the fitness of the given chromosome
   * @param chromosome Chromosome for which fitness will be assessed
   * @param population Population to which the chromosome belongs
   * @return Fitness value of the specified chromosome.
   */
  double getFitness(T chromosome, List<? extends T> population);
  
  /**
   * Returns the fittest chromosome of a population
   * @param population
   * @return 
   */
  T getFittest(List<? extends T> population);

}
