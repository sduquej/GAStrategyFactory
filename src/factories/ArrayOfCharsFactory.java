/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package factories;

import java.util.Arrays;
import java.util.List;
 /**
 * PopulationFactory for Arrays of Chars. Given an alphabet creates random
 * chromosomes with each allele corresponding to a character in the alphabet
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class ArrayOfCharsFactory extends PopulationFactory<char[]> {
  private final char[] ALPHABET;
  private final int length;
  
  public ArrayOfCharsFactory(char[] alphabet, int length) {
    this.ALPHABET = alphabet;
    this.length = length;
  }
  
  @Override
  protected char[] createNewChromosome() {
    // new chromosome with the same number of alleles as the goal
    char[] chromosome = new char[length];
    // Give an initial value to each allel on the chromosome
    for (int j = 0; j < length; j++) {
      // Obtain a random valid value from the alphabet
      chromosome[j] = ALPHABET[(int)Math.round(Math.random()*(length-1))];
    }
      return chromosome;
  }

  @Override
  public void printPopulation(List<char[]> population) {
    for (int i = 0; i < population.size(); i++) {
      char[] cs = population.get(i);
      System.out.println("Chromosome #"+(i+1)+":\t"+Arrays.toString(cs));
    }
  }
  

}
