/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

import factories.ArrayOfCharsFactory;
import factories.PopulationFactory;
import gastrategyfactory.CharsArrayKnownSolutionGA;
import gastrategyfactory.GeneticAlgorithm;
import java.util.Arrays;
import java.util.List;

/**
 * Dummy example... we will try to match my student number: "14250136"
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class GenAlgRunner {
  // This is the solution
  private static final char[] GOAL = {'1', '4', '2','5','0','1','3','6'};
  // Set of valid values for an allel
  private static final char[] alphabet = {'0','1','2','3','4','5','6','7','8','9'};
  
  /**
   * Example Client code
   * @param args the command line arguments - all are ignored
   */
  public static void main(String[] args) {    
    // Number of 'Chromosomes' on the population
    int populationSize = 100;
    // Length of a Student number code
    int codeLength = GOAL.length;
    // When it is desired to stop evolving
    double tolerance = 1.0;
    int generationLimit = 100;
    
    // Factory that knows how to create Chromosomes for the problem
    PopulationFactory pf = new ArrayOfCharsFactory(alphabet, codeLength);
    
    // Desired behaviour
    String selectionBehaviour = "tournament";
    String crossoverBehaviour = "singlepoint";
    String mutationBehaviour = "add"; //Inversion has also been implemented
    
    // Creates the Genetic Algorithm
    GeneticAlgorithm ga = new CharsArrayKnownSolutionGA(selectionBehaviour, crossoverBehaviour, mutationBehaviour, pf, GOAL);
    
    // 1. Initialization - Fill the population with new chromosomes  
    List<char[]> population = ga.initiatePopulation(populationSize);

    // Prints out the initial population
    pf.printPopulation(population);
    
    // 2. Evaluation - Assesses the current population
    // Evolves until the tolerance criteria is met
    int i = 0;
    double currentFitness = ga.evaluatePopulation(population);
    while (currentFitness < tolerance && i < generationLimit){
      // 3. Selection
      population = ga.selectChromosomes(population);

      // 4. Crossover 
      population = ga.performCrossover(population);
      
      // 5. Mutation
      population = ga.mutateChromosomes(population);
      
      // Evaluates the new population
      currentFitness = ga.evaluatePopulation(population);
      char [] bestIndividual = (char[]) ga.getBestChromosome(population);
      System.out.println("Iteration #"+(++i) + "\n The fittest chromosome is: "
              + Arrays.toString(bestIndividual) + " with a fitness value of " +
              currentFitness);
    }
  }      
}



