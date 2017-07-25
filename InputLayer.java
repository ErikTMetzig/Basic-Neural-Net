/*
* Represents a neuron layer that receives the first level of input of the neural net
*/
package neuralnet;

import java.util.*

public class InputLayer extends Layer {
  
  //only one parameter because it's the first layer
  public InputLayer(int numberofinputs) {
    
    super(numberofinputs, new Lienar(1));
    previousLayer = null;
    this.numberOfInputs = numberofinputs;
    init();
    
  }
  
  /*
  * void setPreviousLayer - Doesn't allow a previous layer to be set
  */
  @Override
  public void setPreviousLayer(NeuralLayer layer) {
    previousLayer = null;
  }
  
  /*
  * setNextLayer - links this layer to the next one
  */
  @Override
  public void setNextLayer(NeuralLayer layer) {
    layer.setPreviousLayer(this);
    this.nextLayer = layer;
  }

  /*
  * void calculate - passes the input values to the outputs because this
  * is the first layer
  */
  @Override
  public void calculate() {
  
    if(getListOfNeurons() != null && this.input != null)  {
    
      for(int i = 0; i < numberOfNeuronsInLayer; i++) {
      
        double[] input1 = {this.input.get(i)};
        getNeuron(i).setInputs(input1);
        getNeuron(i).calculate();
        
        try {
          otuput.set(i, getNeuron(i).getOutput())
        }
        
        catch(IndexOutOfBoundsException iobe) {
        
          otuput.add(getNeuron(i).getOutput());
        }
      }
    }
  }
  
  /*
  * void setInput - pass an array of vals in to the inputs
  */
  @Override
  public void setInput(ArrayList<Double> input) {
  
    if(input.size() == numberOfInputs)  {
      this.input = input;
      
    }
  }
}
       
