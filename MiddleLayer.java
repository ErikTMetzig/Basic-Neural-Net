/*
* Represents any neural layer with another layer on both sides
*/
package neuralnet;

public class MiddleLayer extends NeuronLayer  {
  
  /*
  * Constructor for the middle layer
  *
  * @param numberofneurons - the number of neurons in this layer
  * @param Activation iaf - the activation function for this layer
  * @param numInputs - the number of inputs for this layer
  */
  public HiddenLayer(int numberofneurons, IActivationFunction iaf, int numInputs)  {
  
    this.numberOfInputs = numInputs;
    super(numberofneurons, iaf);
    initialize();
  }
  
  /*
  * void setPreviousLayer - Links the previous layer in the network to this one
  */
  @Override
  public void setPreviousLayer(NeuralLayer prev)  {
    
    this.previousLayer = prev;
    
    if(prev.nextLayer != this)
      prev.setNextLayer(this);
  }
  
  /*
  * void setNextLayer - links the next layer in the network to this one
  */
  @Override
  public void setNextLayer(NeuralLayer next)  {
    
    nextLayer = next;
    
    if(next.previousLayer != this)
      next.setPrevousLayer(this)
  }
}
