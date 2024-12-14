package h07;

import h07.Peano.NaturalNumber;
import h07.Peano.PeanoNumberExpression;
import h07.Peano.Successor;
import h07.Peano.Zero;

public class ConvertPeanoToNumberExpressionImpl implements ConvertPeanoToNumberExpression {
    @Override
    public NumberExpression convert(PeanoNumberExpression expression) {
        return () -> convertToNumber(expression.evaluate());
    }

    private int convertToNumber(NaturalNumber n) {
        if (n instanceof Zero) {
            return 0;
        }

        return 1 + convertToNumber(((Successor) n).predecessor);
    }

}
