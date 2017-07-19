/*
* The Sigmiod activaiton function is one of the most common and can be visualized
* as a "hill"
*/

package neuralnet;
//falls under the IActivationFunction interface
public class Sigmoid implements IActivationFunction {

  private double a = 1.0;
  
  public Sigmoid (double _a)  {this.a = _a;}
 
 //its calc function is the inverse of 1+ e^-ax
  @Override
    public double calc(double x)  {
      return 1.0/(1.0+Math.exp(-a*x));
    }
}
