/*
* Represents any neural layer with another layer on both sides
*/
package neuralnet;

public class MiddleLayer extends NeuralLayer  {
  
  public HiddenLayer(int numberofneurons, IActivationFunction iaf, int numberofinputs)  {
  
    this.numberOfNeuronsInLayer = numberofneurons;
    this.activationFnc = iaf;
    this.numberOfInputs = numberofinputs;
  }
  
  //link the previous layer to the network
  @Override
  public void setPreviousLayer(NeuralLayer prev)  {
    this.previousLayer = prev;
    if(prev.nextLayer != this)
      prev.setNextLayer(this);
  }
  //link the next layer to the network
  @Override
  public void setNextLayer(NeuralLayer next)  {
    nextLayer = next;
    if(next.previousLayer != this)
      next.setPrevousLayer(this)
  }
}
