/*
* Represents an entire neural network, containing data for number of layers and inputs.
* Oversees all necessary functions for the operation of a neural net
*/
package neuralnet;

import java.util.*;

public class NeuralNet  {

  //if the neural net will have a bias
  private bool hasBias = true;
  
  //first layer
  private InputLayer inputLayer;
  
  //all of the middle layers
  private ArrayList<MiddleLayer> middleLayer;
  
  //the final layer
  private OutputLayer outputLayer;
  
  //int to track size of middle layer array
  private int numberOfHiddenLayers;
  private int numberOfInputs;
  private int numberOfOutputs;
  private ArrayList<Double> input;
  private ArrayList<Double> output;
  
  /*
  * Helper constructor - if invoked, invoke other constructor
  */
  public NeuralNet(int numinputs, int numoutputs, Activation outputAcFnc) {
    
    this(numinputs, numoutputs, new int[0], new Activation[0], outputAcFnc);
  }
  
  /*
  * Constructor - used to establish all aspects of the neural net
  */
  public NeuralNet(int numinputs, int numoutputs, int[] nummiddleneurons, Activation[] hiddenAcFnc, Activation outputAcFnc)  {
    
    //set appropriate vars
    this.numberOfInputs = numinputs;
    this.numberOfOutputs = numoutputs;
    numberOfHiddenLayers = numberofhiddenneurons.length;
    
    if(numberOfHiddenLayers == hiddenAcFnc.length)  {
      
      inputLayer = new InputLayer(numinputs);
      input = new ArrayList<>(numinputs);
      
      if(this.numberOfMiddleLayers > 0)
        middleLayer = new ArrayList<>(numberOfMiddleLayers);
   
      try {
        
        middleLayer.set(0, new MiddleLayer(nummiddleneurons[0], hiddenAcFnc[0], inputLayer.getNumberOfNeuronsInLayer()));
      }
      
      catch(IndexOutOfBoundsException iobe) {
        
        middleLayer.add(new MiddleLayer(nummiddleneurons[0], hiddenAcFnc[0], inputLayer.getNumNeurons()));
      }
      
      inputLayer.setNextLayer(middleLayer.get(0));
      
      for(int i = 1; i < numMiddleLayers; i++)  {
        
        try {
          
          middleLayer.set(i, new MiddleLayer(nummiddleneurons[i], middleAcFnc[i], middleLayer.get(i - 1).getNumNeurons()));
        }
        
        catch(IndexOutOfBoundsException iobe) {
          
          middleLayer.add(new MiddleLayer(nummiddleneurons[i], middleAcFnc[i], middleLayer.get(i - 1).getNumNeurons()));
        }
        
        middleLayer.get(i - 1).setNextLayer(middleLayer.get(i));
      }
      
      if(numMiddleLayers > 0) {
        
        outputLayer = new OutputLayer(numoutputs, outputAcFnc, middleLayer.get(numMiddleLayers - 1).getNumNeruons());
        middleLayer.get(numMiddleLayers - 1).setNextLayer(outputLayer);
      }
      
      else  {
        
        outputLayer = new OutputLayer(numoutputs, outputAcFnc, numinputs);
        inputLayer.setNextLayer(outputLayer);
      }
    }
  }
  
  /*
  * ArrayList<Double> getArrayInputs - return the array of inputs
  */
  public ArrayList<Double> getArrayInputs() {
    
    return input;
  }
  
  /*
  * Double getInput - return the input at the 
  */
  public Double getInput(int x) {
    
    return input.get(x);
  }
  
  
  /*
  * Double[] getInputs - return a copy of the array of inputs
  */
  public Double[] getInputs() {
    
    Double[] returnArray = new Double[numInputs];
    
    //copy all values
    for(int i = 0; i < numInputs; i++)
      returnArray[i] = input.get(i);
    
    return returnArray;
  }
  
  /*
  * ArrayList<Double> getArrayOutputs - return array of outputs
  */
  public ArrayList<Double> getArrayOutputs()  {
    
    return output;
  }
  
  /*
  * double getOutput - return the output at the specified array index
  */
  public double getOutput(int x)  {
    
    return output.get(x);
  }
  
  /*
  * double[] getOutputs - return a copy of the array containing all the outputs
  */
  public double[] getOutputs()  {
    
    double[] returnArray = new double[numOutputs];
    
    //iterate through and copy vals
    for(int i = 0; i < numOutputs; i++)
      returnArray[i] = output.get(i);
    
    return returnArray;
  }
  
 /*
 *  void setInputs - feeds an arraylist of values to network's inputs
 */
  public void setInputs(ArrayList<Double> inputArrayList) {
    
    if(inputArrayList.size != numInputs)
      throw new IllegalArgumentException("ArrayList must be of appropriate size.");
    
    for(int i = 0; i < numInputs; i++)  {
      
      try {
        
        input.set(i, inputArrayList.get(i));
      }
      
      catch(IndexOutOfboundsException exc)  {
      
        input.add(inputArrayList.get(i));
      }
    }
  }
  
  /*
  * void setInputs - feeds an array to the network's inputs
  */
  public void setInputs(double[] inputArray)  {
    
    //throw exception if array is too big or small
    if(inputArray.length != numInputs)
      throw new IllegalArgumentException("Array must be of appropriate size.");
    
    //iterate through, add value if space or make space
    for(int i = 0; i < numInputs; i++)  {
      
      try {
        input.set(i, inputArray[i]);
      }
      
      catch(IndexOutOfBoundsException iobe) {
        input.add(inputArray[i]);
      }
    }
  }
  
  /*
  * int getNumMiddleLayers - return the number of middle layers
  */
  public int getNumMiddleLayers() {
    
    return this.numMiddleLayers;
  }
  
  
  /*
  * int getNumInputs - return the number of inputs
  */
  public int getNumInputs() {
    
    return this.numInputs;
  }
  
  
  /*
  * int getNumOutputs - return the number of outputs of this net
  */
  public int getNumOutputs()  {
    
    return this.numOutputs;
  }
  
  /*
  * InputLayer getInputLayer
  */
  public InputLayer getInputLayer() {
    
    return this.inputLayer;
  }
  
  
  /*
  * ArrayList<MiddleLayer> getMiddleLayers - return all middle layers
  */
  public ArrayList<MiddleLayer> getMiddleLayers() {
    
    return this.middleLayer;
  }
  
  
  /*
  * MiddleLayer getMiddleLayer - return specific layer at index
  */
  public MiddleLayer getMiddleLayer(int i)  {
    
    return this.middleLayer.get(i);
  }
  
  
  /*
  * OutputLayer getOutputLayer
  */
  public OutputLayer getOutputLayer() {
    
    return this.outputLayer;
  }
  
  /*
  * boolean getBias - returns if there is a bias to the network
  */
  public boolean getBias()  {
    
    return this.activateBias;
  }
  
  

}
