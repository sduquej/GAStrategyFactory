/*
* This file is part of project work done for the CS613 Module
* taught in Maynooth University by Robert Cleary on 2014/2015.
*
*/

/**
 *
 * @author <a href="mailto:sebastian.duquejaramillo.2015@nuim.ie">Sebastian Duque</a>
 * Student #14250136
 */

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * A validator that makes sure the value of the parameter is a positive integer.
 *
 * @author Cedric Beust <cedric@beust.com>
 */
public class ValidTolerance implements IParameterValidator {

  @Override
  public void validate(String name, String value)
      throws ParameterException {
    double n = Double.parseDouble(value);
    if (n < 0.0 || n > 1.0) {
      throw new ParameterException("Parameter " + name
          + " should be between 0.0 and 1.0 (found " + value +")");
    }
  }

}

