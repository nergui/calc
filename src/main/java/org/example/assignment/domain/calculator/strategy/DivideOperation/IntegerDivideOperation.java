package org.example.assignment.domain.calculator.strategy.DivideOperation;

import lombok.extern.slf4j.Slf4j;
import org.example.assignment.domain.calculator.strategy.Operation;

@Slf4j
public class IntegerDivideOperation implements Operation {
	@Override
	public Number execute(Number num1, Number num2) {
		if (num2.intValue() == 0) {
			log.error("IntegerDivideOperation: Division by zero is not allowed");
			throw new ArithmeticException("Division by zero is not allowed");
		}
		// (-2147483648) / -1 = 2147483648, greater than Integer.MAX_VALUE
		if (num1.intValue() == Integer.MIN_VALUE && num2.intValue() == -1) {
			log.error("IntegerDivideOperation: Overflow occurred when dividing Integer.MIN_VALUE by -1");
			throw new ArithmeticException("Integer overflow in division");
		}

		// Convert to double to maintain precision in division
		return num1.doubleValue() / num2.doubleValue();
	}
}