/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.environment.nqueens.NQueensGenAlgoUtil;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.GeneticAlgorithmForNumbers;
import aima.core.search.local.Individual;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Genetic {

    /**
     * @param args the command line arguments
     */
      static  EightPuzzleBoard epb;
      static EightPuzzleBoard boardWithThreeMoveSolution = new EightPuzzleBoard(
			new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });;

    public static void main(String[] args) {
   
        
		epb = new EightPuzzleBoard(boardWithThreeMoveSolution);
                //geneticAlgorithmDemo();
        
        
    }

    	private static void geneticAlgorithmDemo() {
		System.out.println("\nGenetic Alogirthm -->");
		try {
			/*
                    public GeneticAlgorithmForNumbers(int individualLength, 
                    double min, double max, double mutationProbability)
                    Constructor.
                    Parameters:
                    individualLength - vector length used for the representations of individuals. 
                    Use 1 for analysis of functions f(x).
                    min - minimal value to be used in vector elements. 
                    max - maximal value to be used in vector elements. 
                    mutationProbability - probability of mutations.
                    
                    */
                    GeneticAlgorithmForNumbers gSearch = new GeneticAlgorithmForNumbers(10, 1, 8, 0.9);
                 
                      ArrayList<Individual<Double> > g = new ArrayList();
                    for (int i = 0; i < 10; i++) {
                        g.add(gSearch.createRandomIndividual());
                        //System.out.println(g.get(i));
                    }
                    Individual<Double> gg = gSearch.geneticAlgorithm(g, new myfit(), 100);
                    System.out.println(gg);
                
                } catch (Exception e) {
			e.printStackTrace();
		}

	}


    
}
