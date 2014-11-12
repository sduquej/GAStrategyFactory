/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
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
    // Length of a Student number code
    int codeLength = GOAL.length;
    
    // command line parameters
    GenAlgParams gaParams = new GenAlgParams();
    try {
      // parses the parameters
      JCommander jcommander = new JCommander(gaParams,args);
      
      // if the help flag was set it prints the help and finishes
      if (gaParams.isHelp()) {
        jcommander.setProgramName("GenAlgRunner");
        jcommander.usage();
        System.exit(0);
      }
    } catch (ParameterException e) {
      // if a given parameter is invalid it alerts the user and finishes
      System.out.println(e.getMessage());
      System.exit(-1);
    }
  
    // copies locally the value of the parameters
    double tolerance = gaParams.getTolerance();
    int populationSize = gaParams.getPopulationSize();
    int generationLimit = gaParams.getGenerationLimit();
    
    // Factory that knows how to create Chromosomes for the problem
    PopulationFactory<char[]> pf = new ArrayOfCharsFactory(alphabet, codeLength);
    
    // Desired behaviour
    String selectionBehaviour = "tournament";
    String crossoverBehaviour = "singlepoint";
    String mutationBehaviour = "add"; //Inversion has also been implemented
    
    // Creates the Genetic Algorithm
    GeneticAlgorithm<char[]> ga = new CharsArrayKnownSolutionGA(selectionBehaviour, crossoverBehaviour, mutationBehaviour, pf, GOAL);
    
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
      char [] bestIndividual = ga.getBestChromosome(population);
      System.out.println("Iteration #"+(++i) + "\n The fittest chromosome is: "
              + Arrays.toString(bestIndividual) + " with a fitness value of " +
              currentFitness);
    }
  }      
}



