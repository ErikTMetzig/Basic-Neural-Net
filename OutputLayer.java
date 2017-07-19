/*
* Represents the last layer of neurons in the net
*/
package neuralnet;

public class OutputLayer extends NeuralLayer  {

  public OutputLayer (int numberofneurons, IActivationFunction iaf, int numberofinputs) {
  
    this.numberOfNeuronsInLayer = numberofneurons;
    this.activationFnc = iaf;
    this.numberOfInputs = numberofinputs;
  }
}
