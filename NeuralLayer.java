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
  
  protected void init() {
  
    for(int i = 0; i < numberOfNeuronsInLayer; i++) {
      
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
    
    protected void calc() {
    
      for(int i = 0; i < numberOfNeuronsInLayer; i++) {
      
        neuron.get(i).setInputs(this.input);
        neuron.get(i).calc();
        
        try {
          output.set(i, neuron.get(i).getOutput());
          }
        
        catch(IndexOutOfBoundsException iobe) {
        
          output.add(neuron.get(i).getOutput());
          }
       }
     }
  }
  
  
