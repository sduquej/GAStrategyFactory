/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package gastrategyfactory;

import crossover.CrossoverBehaviour;
import factories.BehaviourFactory;
import factories.PopulationFactory;
import fitness.FitnessEvaluator;
import java.util.List;
import mutation.MutationBehaviour;
import selection.SelectionBehaviour;

/**
 * The basic process for a genetic algorithm is:
 * 1. Initialization
 * 2. Evaluation
 * 3. Selection
 * 4. Crossover
 * 5. Mutation
 * And repeat! - until we reach a termination condition.
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 * @param <T> Chromosomes' object type.
 */
public abstract class GeneticAlgorithm<T> {
  private final SelectionBehaviour sb;
  private final CrossoverBehaviour cb;
  private final MutationBehaviour mb;
  private final PopulationFactory pf;
  private final BehaviourFactory bf;
  private final FitnessEvaluator fe;

  /**
   * Constructor. Initializes the Genetic Algorithm
   * @param sb Specifies the desired selection behaviour
   * @param cb Specifies the desired crossover behaviour
   * @param mb Specifies the desired mutation behaviour
   * @param pf Factory that knows how to create chromosomes for the Population
   * @param fe FitnessEvaluator for chromosomes of the given type
   */
  public GeneticAlgorithm(String sb, String cb, String mb, PopulationFactory pf, FitnessEvaluator fe) {
    this.bf = BehaviourFactory.getFactoryInstance();
    BehaviourFactory.setFe(fe);
    this.sb = bf.createSelectionAlgorithm(sb);
    this.cb = bf.createCrossoverAlgorithm(cb);
    this.mb = bf.createMutationAlgorithm(mb);
    this.pf = pf;
    this.fe = fe;
  }
  
  /**
   * 1. Initialization 
   * Generates random population of a given number of chromosomes
   * @param populationSize number of chromosomes that the population will have
   * @return initial population
   */
  public List<T> initiatePopulation(int populationSize){
    List<T> population = pf.generateInitialPopulation(populationSize);
    return population;
  }
  
  /**
   * 2. Evaluation 
   * Evaluates the fitness f(x) of each chromosome x in the population
   * Returns the value of the fittest chromosome
   * @param currentPopulation
   * @return the fitness of the fittest chromosome
   */
  public double evaluatePopulation(List<T> currentPopulation){
    T fittestChromosome = getBestChromosome(currentPopulation);
    return fe.getFitness(fittestChromosome, currentPopulation);
  }
  
  /**
   * Identifies and returns the fittest chromosome in the population
   * @param currentPopulation
   * @return fittest chromosome in the given population
   */
  public T getBestChromosome(List<T> currentPopulation){
    return (T) fe.getFittest(currentPopulation);
  }
  
  /**
   * 3. Selection
   * We want to be constantly improving our populations overall fitness. 
   * Selection helps us to do this by discarding the bad designs and only 
   * keeping the best individuals in the population.  
   * There are a few different selection methods but the basic idea is the same,
   * make it more likely that fitter individuals will be selected for our next 
   * generation.
   * @param rankedPopulation Current population sorted by fitness
   * @return List of the individuals selected for crossover
   */
  public List<T> selectChromosomes(List<T> rankedPopulation){
    List <T> selectedPopulation = sb.select(rankedPopulation);
    return selectedPopulation;
  }
  
  /**
   * 4. Crossover
   * During crossover we create new individuals by combining aspects of our 
   * selected individuals. We can think of this as mimicking how sex works in 
   * nature. The hope is that by combining certain traits from two or more 
   * individuals we will create an even 'fitter' offspring which will inherit 
   * the best traits from each of it's parents.
   * @param selectedPopulation Chromosomes selected for crossover
   * @return List of chromosomes after they've been through crossover
   */
  public List<T> performCrossover(List<T> selectedPopulation){
    List <T> nextGeneration = cb.crossover(selectedPopulation);
    return nextGeneration;
  }
  
  /**
   * 5. Mutation 
   * We need to add a little bit randomness into our populations' genetics 
   * otherwise every combination of solutions we can create would be in our 
   * initial population. Mutation typically works by making very small changes 
   * at random to an individuals genome.
   * @param nextPopulation
   * @return
   */
  public List<T> mutateChromosomes(List<T> nextPopulation){
    List <T> mutatedGeneration = mb.mutate(nextPopulation);
    return mutatedGeneration;
  }
  
}
