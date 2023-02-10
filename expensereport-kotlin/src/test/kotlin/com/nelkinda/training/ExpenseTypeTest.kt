package com.nelkinda.training

import com.nelkinda.training.ExpenseType.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ExpenseTypeTest {
    @ParameterizedTest
    @MethodSource("expenseLimitTestCases")
    internal fun shouldCheckLimits(type: ExpenseType, expenseAmount: Int, expected: Boolean) {
        assertEquals(expected, type.isOverLimit(expenseAmount))
    }

    companion object {
        @JvmStatic
        fun expenseLimitTestCases() = listOf(
            Arguments.of(BREAKFAST, 100, false),
            Arguments.of(BREAKFAST, 10000, true),
            Arguments.of(DINNER, 200, false),
            Arguments.of(DINNER, 20000, true),
            Arguments.of(CAR_RENTAL, 300, false),
            Arguments.of(CAR_RENTAL, 30000, false),
        )
    }
}