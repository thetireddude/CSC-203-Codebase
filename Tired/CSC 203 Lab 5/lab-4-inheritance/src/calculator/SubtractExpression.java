package calculator;
public class SubtractExpression extends BinaryExpression
   implements Expression
{

   public SubtractExpression(final Expression lft, final Expression rht)
   {
      super(lft, rht, "-");
   }

   public double applyOperator(double lft, double rht){
      return lft - rht;
   }
}

