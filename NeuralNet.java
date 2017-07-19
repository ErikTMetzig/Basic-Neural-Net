/*
* Represents an entire neural network, containing data for number of layers and inputs
*/
package neuralnet;

import java.util.*;

public class NeuralNet  {

  private InputLayer inputLayer;
  private ArrayList<HiddenLayer> hiddenLayer;
  private OutputLayer outputLayer;
  private int numberOfHiddenLayers;
  private int numberOfInputs;
  private int numberOfOutputs;
  private ArrayList<Double> input;
  private ArrayList<Double> output;
  
  public NeuralNet(int numberofinputs, int numberofoutputs, int[] numberofhiddenneurons, IActivationFunction[] hiddenAcFnc, IActivationFunction outputAcFnc)  {
    
    this.numberOfInputs = numberofinputs;
    this.numberOfOutputs = numberofoutputs;
    
    input = new ArrayList<>(numberofinputs);
    inputLayer = new InputLayer(numberofinputs);
}
