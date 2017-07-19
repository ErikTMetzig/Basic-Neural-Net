/*
* The Sigmiod activaiton function is one of the most common and can be visualized
* as a "hill"
*/

package neuralnet;

//falls under the IActivationFunction interface
public class Sig implements Activation {

  private double value;
  
  //only constructor
  public Sigmoid (double x)  {this.value = x;}
  
  public void setValue(double val)  { 
    this.value = val; 
  }
 
 //its calc function is the inverse of 1+ e^-ax
  @Override
    public double calc(double x)  {
      return 1.0/(1.0+Math.exp(-a*x));
    }
  
  //returns the derivative of the function at any point
  @Override
    public double derivative(double x)  {
      double holder = calc(x)*(1-calc(x));
      return holder;
    }
}
