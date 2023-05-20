/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import aima.core.environment.nqueens.NQueensBoard;
import static aima.core.environment.nqueens.NQueensGenAlgoUtil.getBoardForIndividual;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;
import aima.core.util.datastructure.XYLocation;
import java.util.List;

/**
 *
 * @author DELL
 */
public class myfit implements FitnessFunction<Double>{

    @Override
    public double apply(Individual<Double> individual) {
			double fitness = 0;

		      System.out.println(individual.length());
                        fitness = 2;
                        
			
                        
			return fitness;
		}

    
}
