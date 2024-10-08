package org.example.assignment.domain.calculator.strategy.DivideOperation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.extern.slf4j.Slf4j;
import org.example.assignment.domain.calculator.strategy.Operation;

@Slf4j
public class BigDecimalDivideOperation implements Operation {

	// Precision and scale for division
	public static final int SCALE = 15;
	@Override
	public Number execute(Number num1, Number num2) {
		BigDecimal bd1 = toBigDecimal(num1);
		BigDecimal bd2 = toBigDecimal(num2);
		if (bd2.compareTo(BigDecimal.ZERO) == 0) {
			log.error("BigDecimalDivideOperation: Division by zero is not allowed");
			throw new ArithmeticException("Division by zero is not allowed");
		}
		return bd1.divide(bd2, SCALE, RoundingMode.HALF_UP);
	}

	private BigDecimal toBigDecimal(Number number) {
		if (number instanceof BigDecimal) {
			return (BigDecimal) number;
		} else {
			return new BigDecimal(number.toString());
		}
	}
}