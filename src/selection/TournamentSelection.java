/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package selection;

import fitness.FitnessEvaluator;
import java.util.ArrayList;
import java.util.List;

/**
* TournamentSelection runs a tournament between a subset of the population
* and selects the fittest individual for the new population.
* Note that an individual might be selected for multiple tournaments and
* can possibly win more than one of them, this is fine since it means it is
* a better 'solution' than its rivals.
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class TournamentSelection extends SelectionBehaviour<char[]> {
  
  private int tournamentSize = 0;
  /**
   * The default constructor assigns the FitnessEvaluator that will be used.
   * @param fe 
   */
  public TournamentSelection(FitnessEvaluator<char[]> fe) {
    super(fe);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<char[]> select(List<char[]> population) {
    // Sets tournamentSize to 30% of the population
    tournamentSize = (int) (population.size()*0.3);
    // Population of selected individuals
    List<char[]> selectedPopulation = new ArrayList<>(population.size());
    
    for (int i = 0; i < population.size(); i++) {
      // Population of individuals that will go to a tournament
      List<char[]> tournamentPopulation = new ArrayList<>(tournamentSize);
      // For every slot in the new population a tournament is run
      for (int j = 0; j < tournamentSize; j++) {
        // Selects a random individual
        char[] cs = population.get((int) (Math.random()*population.size()));
        tournamentPopulation.add(cs);
      }
      // The tournament winner is added to the selected population
      selectedPopulation.add(fe.getFittest(tournamentPopulation));
    }
    
    return selectedPopulation;       
  }

}
