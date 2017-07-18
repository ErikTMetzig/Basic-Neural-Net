//package for neural net classes
package neuralnet;

import java.util.*;
import java.math.*;

/*
* Defines a neuron - the fundamental element of a neural network. Artificial neurons must have:
* 1.) Inputs 2.) Weights 3.) Bias 4.) Activation Function 5.) Output
*/
public class Neuron {

  //array of weights to measure the strength of each incoming neuron
  protected ArrayList<Double> weight;
  //array of all incoming inputs, whether it be abstract input or other neurons
  private ArrayList<Double> input;
  //the value that this neuron will give off
  private Double output;
  //for recording previous neural states
  private Double outputBeforeActivation;
  //tracks size of input
  private int numberOfInputs = 0;
  //affects the output by a consistent amount, so when all inputs = 0, output != 0
  protected Double bias = 1.0;
  //Adds a non-linear multiplier to inputs, like Sigmoid or Hyperbolic activation
  private IActivationFunction activationFunction;
  
  /*
  * Constructor class for a Neuron
  * @param numberOfInputs - the number of inputs that this neuron will have to take in
  * @param iaf - The particular activation function for this neuron (ex: Sigmoid, Linear, Hard Limiting)
  */
  public Neuron(int numberOfInputs, IActivationFunction iaf)  {
  
    //set appropriate values
    numberOfInputs = numberofinputs;
    weight = new ArrayList<>(numberofinputs + 1);
    input = new ArrayList<>(numberofinputs);
    activationFunction = iaf;
    }
    
  /*
  * Assigns the initial values to weights by randomly generating numbers
  */
  publc void init() {
  
    Random rand = new Random();
    
    //iterate through each weight and assign a random value
    for(int i  = 0; i < numberOfInputs; i++)  {
  
      double newWeight = rand.nextDouble();
      
      try {
      
        this.weight.set(i, newWeight);
        }
      
      //must prevent an attempt to set a value outside the bounds of the array
      catch(IndexOutOfBoundsException iobe) {
        
        this.weight.add(newWeight);
      }
    }
  }
  
  /*
  * Calculates the output value by summing the products of all inputs and weights, adding bias
  * and saving to outputBeforeActivation. The output value is then calculated by activation function.
  */
  public void calc()  {
  
    //set a default value
    outputBeforeActivation = 0.0;
    
    //if there are actual inputs and weights, sum all inputs, weights, bias
    if(numberOfInputs > 0)  {
      
      if(input != null && weight != null) {
        
        for(int i = 0; i < numberOfInputs; i++) {
        
          //save value to desired var
          outputBeforeActivation += (i == numberOfInputs?bias:input.get(i)) * weight.get(i);
        }
      }
    }
    //derive actual output from our calculated value
    output = activationFunction.calc(outputBeforeActivation);
  }
}
  
