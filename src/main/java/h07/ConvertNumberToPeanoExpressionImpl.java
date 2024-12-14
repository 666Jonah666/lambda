package h07;

import h07.Peano.NaturalNumber;
import h07.Peano.PeanoNumberExpression;
import h07.Peano.Successor;
import h07.Peano.Zero;

public class ConvertNumberToPeanoExpressionImpl implements ConvertNumberToPeanoExpression {
    @Override
    public PeanoNumberExpression convert(NumberExpression expression) {
        return () -> convertToPeano(expression.evaluate());
    }

    private NaturalNumber convertToPeano(int n) {
        if (n == 0) {
            return new Zero();
        }

        return new Successor(convertToPeano(n - 1));
    }
}
