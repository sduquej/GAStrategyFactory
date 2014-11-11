/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package selection;

import fitness.FitnessEvaluator;
import java.util.List;

/**
 * Rank Selection behaviour
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class RankSelection<T> extends SelectionBehaviour<T> {

  public RankSelection(FitnessEvaluator<T> fe) {
    super(fe);
  }

  @Override
  public List<T> select(List<T> population) {
    System.out.println("Rank Selection... not yet");
    return population;
  }

}
