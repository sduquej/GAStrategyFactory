/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package crossover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SinglePointCrossover extends CrossoverBehaviour<char[]> {
  // Random number generator
  Random rng = new Random();
  
   /**
    * {@inheritDoc}
    * SinglePointCrossover takes a random position and swaps the content of the
    * two arrays
    * @return List of char[] objects after crossover has happened.
    */
  @Override
  public List<char[]> crossover(List<char[]> population) {
    List<char[]> crossOverPopulation = new ArrayList<>();
    char[] offspringOne, offspringTwo;
    // number of alleles of each chromosome
    int length = population.get(0).length;
    // Gets a random crossover point for the next population
    int crossOverPoint = rng.nextInt(length);
    // If population is odd, offset would be 1
    int offset = 0;
    // If the population is of odd number of chromosomes the first one remains unchanged
    if(population.size()%2!=0){
      crossOverPopulation.add(population.get(0));
      offset = 1;
    }
    // If the population is of even number of chromosomes all can be crossedover
    for (int i = offset; i < population.size(); i+=2) {
      offspringOne = joinArrays(Arrays.copyOfRange(population.get(i),0, 
                                                      crossOverPoint), 
              Arrays.copyOfRange(population.get(i+1), crossOverPoint, length));
      offspringTwo = joinArrays(Arrays.copyOfRange(population.get(i+1),0, 
                                                      crossOverPoint), 
              Arrays.copyOfRange(population.get(i), crossOverPoint, length));
      
      crossOverPopulation.add(offspringOne);
      crossOverPopulation.add(offspringTwo);
    }
    return crossOverPopulation;
  }
  /**
   * Joins two arrays in a single one
   * Inspired on: http://stackoverflow.com/questions/80476/how-to-concatenate-two-arrays-in-java
   * Could be useful placing it as a static method in a Utils class.
   * @param first first array
   * @param second second array
   * @return Array formed by the two inputs.
   */
  private char[] joinArrays(char[] first, char[] second) {
    char[] result = Arrays.copyOf(first, first.length + second.length);
    System.arraycopy(second, 0, result, first.length, second.length);
    return result;
  }
}
