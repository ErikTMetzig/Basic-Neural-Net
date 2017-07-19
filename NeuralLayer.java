/*
* Abstract class that represents a "Layer" of neurons - contains similar details 
* as regular neurons, also has functions for initialization and calculation
* Specific layer types will be InputLayer, HiddenLayer, OutputLayer
*/

package neuralnet;

import java.util.*;

public abstract class NeuralLayer {

  protected int numberOfNeuronsInLayer;
  //all of the individual neurons included
  private ArrayList<Neuron> neuron;
  //the activation function for the entire layer
  protected IActivationFunction activationFnc;
  protected NeuralLayer previousLayer;
  protected NeuralLayer nextLayer;
  //same as for individual neurons
  protected ArrayList<Double> input;
  protected ArrayList<Double> output;
  protected int numberOfInputs;
  
  //abstract method that is implemented in each specific layer type object
  public NeuralLayer()  {};
  
  //sets up each neuron within the layer
  protected void init() {
  
    //iterate through each neuron
    for(int i = 0; i < numberOfNeuronsInLayer; i++) {
     
      //initialize the neuron or create one and initialize
      try {
        
        neuron.get(i).setActivationFunction(activationFnc);
        neuron.get(i).init();
        }
      
      catch(IndexOutOfBoundsException iobe) {
        
        neuron.add(new Neuron(numberOfInputs, activationFnc));
        neuron.get(i).init();
        }
      }
    }
    
    //calculates the outputs for every neuron in the layer
    protected void calc() {
    
      for(int i = 0; i < numberOfNeuronsInLayer; i++) {
      
        //set appropriate inputs and then calculate
        neuron.get(i).setInputs(this.input);
        neuron.get(i).calc();
        
        //try to set appropriate value if possible, or add
        try {
          output.set(i, neuron.get(i).getOutput());
          }
        
        catch(IndexOutOfBoundsException iobe) {
        
          output.add(neuron.get(i).getOutput());
          }
       }
     }

  //field accessability method
  public void setNextLayer(neuralLayer layer) {
    this.nextLayer = layer;
  }
  
  //field accessability method
  public int getNumberOfNeuronsInLayer()  {
    return this.numberOfNeuronsInLayer;
}
  
  
