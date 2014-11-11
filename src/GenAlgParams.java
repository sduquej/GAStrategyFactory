/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;

/**
 * Class that encapsulates the possible command line parameters for the GA.
 * Used with JCommander allows easy command line parsing
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class GenAlgParams {
  // Number of 'Chromosomes' on the population
  @Parameter(names = "-popsize", 
          description = "Size of the population. Positive integer)", 
          validateWith = PositiveInteger.class)
  private int populationSize = 20;
  
  // When it is desired to stop evolving
  @Parameter(names = "-tol", 
          description = "Fitness acceptance criteria for the evolution. Value between 0.0 and 1.0",
          validateWith = ValidTolerance.class)
  private double tolerance = 1.0;
  
  @Parameter(names = "-genLimit", 
          description = "Maximum number of generations that will occur until evolution stops",
          validateWith = PositiveInteger.class)
  private int generationLimit = 50;
  
  @Parameter(names ={"-h", "-help", "--help"}, 
          description = "Displays usage information",
          help = true)
  private boolean help;
  
  // Getters
  public int getGenerationLimit() {
    return generationLimit;
  }

  public int getPopulationSize() {
    return populationSize;
  }

  public double getTolerance() {
    return tolerance;
  }

  public boolean isHelp() {
    return help;
  }
 
  
}
