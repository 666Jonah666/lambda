package h07.Peano;


import h07.ConvertNumberToPeanoExpression;
import h07.ConvertNumberToPeanoExpressionImpl;
import h07.NumberExpression;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Represents a factory for Peano number expressions.
 */
public class PeanoNumberExpressionFactory {
    /**
     * Converts an array of number expressions to an array of Peano number expressions.
     *
     * @param numberExpressions the number expressions to convert
     * @return the converted Peano number expressions
     */
    @StudentImplementationRequired
    public static PeanoNumberExpression[] fromNumberExpressions(NumberExpression[] numberExpressions) {

        PeanoNumberExpression[] result = new PeanoNumberExpression[numberExpressions.length];
        ConvertNumberToPeanoExpressionImpl converter = new ConvertNumberToPeanoExpressionImpl();

        for (int i = 0; i < numberExpressions.length; i++) {
            result[i] = converter.convert(numberExpressions[i]);
        }

        return result;
    }

    /**
     * Folds an array of Peano number expressions into a single Peano number expression.
     *
     * @param peanoNumberExpressions the Peano number expressions to fold
     * @param initial the initial Peano number expression
     * @param operation the operation to apply
     * @return the folded Peano number expression
     */
    @StudentImplementationRequired
    public static PeanoNumberExpression fold(PeanoNumberExpression[] peanoNumberExpressions, PeanoNumberExpression initial, PeanoArithmeticExpression operation) {

        PeanoNumberExpression result = initial;

        for (PeanoNumberExpression peanoNumberExpression : peanoNumberExpressions) {
            result = operation.evaluate(result, peanoNumberExpression);
        }

        return result;
    }
}
