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
  private int numInputs = 0;
  //affects the output by a consistent amount, so when all inputs = 0, output != 0
  protected Double bias = 1.0;
  //Adds a non-linear multiplier to inputs, like Sigmoid or Hyperbolic activation
  private Activation activationFunction;
  
  /*
  * Constructor class for a Neuron
  * @param numberOfInputs - the number of inputs that this neuron will have to take in
  * @param iaf - The particular activation function for this neuron (ex: Sigmoid, Linear, Hard Limiting)
  */
  public Neuron(int numberOfInputs, Activation iaf)  {
  
    //set appropriate values
    this.numInputs = numberofinputs;
    this.weight = new ArrayList<>(numberofinputs + 1);
    this.input = new ArrayList<>(numberofinputs);
    this.activationFunction = iaf;
    }
    
  /*
  * Assigns the initial values to weights by randomly generating numbers
  */
  publc void initialize() {
  
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
  * void calculate - Calculates the output value by summing the products of all inputs and weights, adding bias
  * and saving to outputBeforeActivation. The output value is then calculated by activation function.
  */
  public void calculate()  {
  
    //set a default value
    this.outputBeforeActivation = 0.0;
    
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
  
  /*
  * Double calculate - secondary calculate function which adds an additional array factor
  */
  public Double calculate(Double[] inputArray)  {
    
    //if no inputs, simply calculate from activation
    if(numInputs <= 0)
      return Activation.calculate(0.0);
    
    //if inputs
    else  {
      
      Double holderOutputBeforeActivation = 0.0;
      
      if(this.weight != null) {
        
        //iterate through each input and calculate
        for(int i = 0; i < numInputs; i++)  {
          
          holderOutputBeforeActivation += (i == numInputs?bias:_input[i]) * weight.get(i);
        }
      }
      
      //return
      return Activation.calculate(holderOutputBeforeActivation);
    }
  }
  
  
}
  
