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
}
