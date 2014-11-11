/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package fitness;

import java.util.List;

/**
 * Knows how to evaluate, based on a known solution, the fitness for an array 
 * of chars
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class CharArrayFitnessEvaluator implements FitnessEvaluator<char[]> {
  private final char[] solution;

  /**
   * Initializes the FitnessEvaluator with the known solution
   * @param solution 
   */
  public CharArrayFitnessEvaluator(char[] solution) {
    this.solution = solution;
  }
  
  /**
   * {@inheritDoc}
   * Fitness is calculated seeing how many characters match exactly the solution
   */
  @Override
  public double getFitness(char[] chromosome, List<? extends char[]> population) {
    int matches = 0;
    for (int i = 0; i < chromosome.length; i++) {
      matches += (chromosome[i] == solution[i] ? 1 : 0);
    }
    return matches*1.0/solution.length;
  }
  
  /**
   * @{inheritDoc}
   */
  @Override
  public char[] getFittest(List<? extends char[]> population) {
    double fittest = getFitness(population.get(0));
    int index = 0;
    double fitness;
    for (int i = 1; i < population.size(); i++) {
      char [] cs = population.get(i);
      if(getFitness(cs)>fittest){
        fittest = getFitness(cs);
        index = i;
      }
    }
    return population.get(index);
}
  /**
   * Calculates the fitness of a chromosome without comparing it to the rest
   * of the population
   * @param chromosome
   * @return 
   */
  private double getFitness(char[] chromosome){
    return this.getFitness(chromosome, null);
  }
}
