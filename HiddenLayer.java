/*
* Represents any neural layer with another layer on both sides
*/
package neuralnet;

public class HiddenLayer extends NeuralLayer  {
  
  public HiddenLayer(int numberofneurons, IActivationFunction iaf, int numberofinputs)  {
  
    this.numberOfNeuronsInLayer = numberofneurons;
    this.activationFnc = iaf;
    this.numberOfInputs = numberofinputs;
  }
}
