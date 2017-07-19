/*
* Represents a neuron layer that receives the first level of input of the neural net
*/
package neuralnet;

public class InputLayer extends NeuralLayer {
  //only one parameter because it's the first layer
  public InputLayer(int numberofinputs) {
    this.numberOfInputs = numberofinputs;
  }
}
