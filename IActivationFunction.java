/*
* IActivationFunction provides an interface for any particular activation
* function that is used to calculate the output of a neuron
*/

package neuralnet;

//every activation function has its own calc() that spits back the output
public interface IActivationFunction  {

  double calc(double x);
  
  //most common activation functions
  public enum ActivationFunctionENUM  {
  
    STEP, LINEAR, SIGMOID, HYPERTAN
  }
}
