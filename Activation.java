/*
* IActivationFunction provides an interface for any particular activation
* function that is used to calculate the output of a neuron
*/

package neuralnet;

//every activation function has its own calc() that spits back the output
public interface Activation  {

  //returns the value to output
  double calc(double val);
  
  //returns the derivative of the activation at any point
  double derivative(double val);
  
  //possible activation functions
  public enum ActivationENUM {
  
    STEP, LINEAR, SIG, HYPERTAN
  }
}
