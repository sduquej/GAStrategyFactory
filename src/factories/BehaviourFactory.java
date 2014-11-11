/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

package factories;

import crossover.CrossoverBehaviour;
import crossover.SinglePointCrossover;
import crossover.UniformCrossover;
import fitness.FitnessEvaluator;
import mutation.AddMutation;
import mutation.InversionMutation;
import mutation.MutationBehaviour;
import selection.RankSelection;
import selection.RouletteWheelSelection;
import selection.SelectionBehaviour;
import selection.TournamentSelection;

/**
 * This is a Singleton Simple Factory for the creation of different behaviours
 * for Selection, Crossover and Mutation.
 * I chose Simple Factory because, being the simplest to implement, solves the
 * issue for this particular program.
 * Personally, I think an abstract factory does not fit with the program 
 * specification. The factory method would also work, but as I said, Simple 
 * Factory was enough and gets the job done.
 * The Factory is a SINGLETON. There will only be one instance created at any
 * point, and this instance is created only when the class is first referenced.
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */
public class BehaviourFactory {
  private static final BehaviourFactory INSTANCE = new BehaviourFactory();
  private static FitnessEvaluator fe;
  /**
   * Private constructor. Can't create instances of the Factory.
   */
  private BehaviourFactory(){
  }
  
  /**
   * This method works as Factory for Selection Behaviour. Takes a string with
   * the description and returns an instance of the implemented behaviour.
   * @param behaviour Specifies the desired selection Behaviour
   * @return SelectionBehaviour implementation based on the parameter
   */
  public SelectionBehaviour createSelectionAlgorithm(String behaviour){
    SelectionBehaviour sb;
    if (behaviour.equalsIgnoreCase("tournament")){
      sb = new TournamentSelection(fe);
    }else if (behaviour.equalsIgnoreCase("rank")){
      sb = new RankSelection(fe);
    } else if (behaviour.equalsIgnoreCase("roulettewheel")){
      sb = new RouletteWheelSelection(fe);
    } else {
      throw new IllegalArgumentException("There is no such '"+behaviour+"' for Selection Behaviour");
    }
    return sb;
  }
  
  /**
   * This method works as Factory for Crossover Behaviour. Takes a string with
   * the description and returns an instance of the implemented behaviour.
   * @param behaviour Specifies the desired crossover Behaviour
   * @return CrossoverBehaviour implementation based on the parameter
   */
  public CrossoverBehaviour createCrossoverAlgorithm(String behaviour){
    CrossoverBehaviour cb;
    if (behaviour.equalsIgnoreCase("singlepoint")){
      cb = new SinglePointCrossover();
    } else if (behaviour.equalsIgnoreCase("uniform")){
      cb = new UniformCrossover();
    } else {
      throw new IllegalArgumentException("There is no such '"+behaviour+"' for Crossover Behaviour");
    }
    return cb;
  }
  
  /**
   * This method works as Factory for Mutation Behaviour. Takes a string with
   * the description and returns an instance of the implemented behaviour.
   * @param behaviour Specifies the desired mutation Behaviour
   * @return MutationBehaviour implementation based on the parameter
   */
  public MutationBehaviour createMutationAlgorithm(String behaviour){
    MutationBehaviour sb;
    if (behaviour.equalsIgnoreCase("add")){
      sb = new AddMutation();
    } else if (behaviour.equalsIgnoreCase("inversion")){
      sb = new InversionMutation();
    } else {
      throw new IllegalArgumentException("There is no such '"+behaviour+"' for Mutation Behaviour");
    }
    return sb;
  }

  /**
   * Sets the FitnessEvaluator instance on the BehaviourFactory
   * @param fe FitnessEvaluator instance
   */
  public static void setFe(FitnessEvaluator fe) {
    BehaviourFactory.fe = fe;
  }
  
  
  /**
   * Singleton method used to obtain a reference to the existing Factory instance.
   * @return BehaviourFactory instance.
   */
  public static BehaviourFactory getFactoryInstance(){
    return INSTANCE;
  }
}
