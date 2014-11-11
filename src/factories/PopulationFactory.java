/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package factories;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for creating random chromosomes and initial populations
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 * @param <T> Object type handled by the Factory
 */
public abstract class PopulationFactory<T> {
  /**
   * Performs the initialization step for the Genetic Algorithm.
   * @param populationSize Number of chromosomes in the population
   * @return Initial population with random elements
  */
  public List<T> generateInitialPopulation(int populationSize){
    List<T> population = new ArrayList<>(populationSize);
    for (int i = 0; i < populationSize; i++) {
      population.add(createNewChromosome());
    }
    return population;
  }
  
  /**
   * Prints the content of a given population
   * @param population 
   */
  public abstract void printPopulation(List<T> population);
  
  
  /**
   * Creates a new chromosome for the initial population
   * @return New Chromosome with random values
   */
  protected abstract T createNewChromosome();
}
