/*
package GeneticAlgos.BinaryStringOptimization;

import java.util.Scanner;

*/
/**
 * Created by chyvn on 12-02-2017.
 *
 *  Main is the driver function.
 *
 *//*

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int populationSize = scanner.nextInt();
        int chromosomeSize = scanner.nextInt();

        Population population = new Population(populationSize, chromosomeSize);
        Chromosome target = new Chromosome(chromosomeSize);

        System.out.print("The target chromosome is : ");
        target.display();

        GA g = new GA();
        Chromosome optimalSolution = g.optimize(population, target);

        System.out.print("The optimal solution is found : ");
        target.display();
    }
}



boolean hasCycle(Node head) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int counter = 0;
	while(head != null) {
		if (map.containsValue(head.data)) return false;
		else {
			map.put(counter++, head.data);
		}
	head = head.next;
	}
	return true;
}

boolean isBalanced(String expression) {
	Stack<Character> stack = new Stack<>();
	for (int i = 0; i < expression.length(); i++) {
		char a = expression.charAt(i);
		if (a == '{' || a == '(' || a == '[') stack.push(a);
		else if (a == '}' && '{' != stack.peek()) return false;
		else if (a == ')' && '(' != stack.peek()) return false;
		else if (a == ']' && '[' != stack.peek()) return false;
		stack.pop();
	}
	if (stack.empty()) return true;
	else return false;
}
		
			
	
	
	
	
	
	
	
	
	
	
	
	
	*/
