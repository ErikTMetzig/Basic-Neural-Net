/*
* Represents an entire neural network, containing data for number of layers and inputs
*/
package neuralnet;

import java.util.*;

public class NeuralNet  {

  //first layer
  private InputLayer inputLayer;
  //all of the middle layers
  private ArrayList<HiddenLayer> hiddenLayer;
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
  public NeuralNet(int numberofinputs, int numberofoutputs, int[] numberofhiddenneurons, IActivationFunction[] hiddenAcFnc, IActivationFunction outputAcFnc)  {
    //set appropriate vars
    this.numberOfInputs = numberofinputs;
    this.numberOfOutputs = numberofoutputs;
    //initialize inputs
    input = new ArrayList<>(numberofinputs);
    inputLayer = new InputLayer(numberofinputs);
    //initialize the first hidden layer
    hiddenLayer.set(0, new HiddenLayer(numberofhiddenneurons[0], hiddenAcFnc[0], inputLayer.getNumberOfNeuronsInLayer()));
    inputLayer.setNextLayer(hiddenLayer.get(0));
    //initialize all of the other hidden layers by iteration
    for(int i = 1; i < hiddenLayer.size(); i++) {
      hiddenLayer.set(i, new HiddenLayer(numberofhiddenneurons[i], hiddenAcFnc[i], hiddenLayer.get(i - 1).getNumberOfNeuronsInLayer()));
      hiddenLayer.get(i - 1).setNextLayer(hiddenLayer.get(i));
    }
    //if the neural net is just the input and output layers, initialize
    if(numberOfHiddenLayers > 0)  {
      outputLayer = new OutputLayer(numberofoutputs, outputAcFnc, hiddenLayer.get(numberOfHiddenLayers - 1).getNumberOfNeuronsInLayer());
      hiddenLayer.get(numberOfHiddenLayers - 1).setNextLayer(outputLayer);
    }
    //if there are hidden layers, initialize
    else  {
      outputLayer = new OutputLayer(numberofinputs, outputAcFnc, numberofoutputs);
      inputLayer.setNextLayer(outputLayer);
    }
}
