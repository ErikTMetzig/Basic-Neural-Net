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
  
}
