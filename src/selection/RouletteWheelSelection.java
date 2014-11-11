/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package selection;

import fitness.FitnessEvaluator;
import java.util.List;
/**
 * Roulette Wheel selection behaviour
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class RouletteWheelSelection<T> extends SelectionBehaviour<T> {
  /**
   * The default constructor assigns the FitnessEvaluator that will be used.
   * @param fe 
   */
  public RouletteWheelSelection(FitnessEvaluator<T> fe) {
    super(fe);
  }

  @Override
  public List<T> select(List<T> population) {
    System.out.println("Roulette Wheel Selection... ideally");
    return population;
  }

}
