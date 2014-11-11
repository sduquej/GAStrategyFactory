/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package gastrategyfactory;

import factories.PopulationFactory;
import fitness.CharArrayFitnessEvaluator;


public class CharsArrayKnownSolutionGA extends GeneticAlgorithm<char[]> {
  private final char[] solution;
  
  /**
   * Constructor. Initializes the Genetic Algorithm
   * @param sb Specifies the desired selection behaviour
   * @param cb Specifies the desired crossover behaviour
   * @param mb Specifies the desired mutation behaviour
   * @param pf Factory that knows how to create chromosomes for the Population 
   * @param solution Known solution to the problem
   */
  public CharsArrayKnownSolutionGA(String sb, String cb,
          String mb, PopulationFactory pf, char[] solution) {
    super(sb, cb, mb, pf,new CharArrayFitnessEvaluator(solution));
    this.solution = solution;
  }

}