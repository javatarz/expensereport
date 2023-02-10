package com.nelkinda.training

import com.nelkinda.training.ExpenseType.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ExpenseTest {
    @ParameterizedTest
    @MethodSource("expenseLimitMarkers")
    internal fun shouldCheckExpenseMarkers(expense: Expense, expected: String) {
        assertEquals(expected, expense.overLimitMarker())
    }

    companion object {
        @JvmStatic
        fun expenseLimitMarkers() = listOf(
            Arguments.of(Expense(BREAKFAST, 100), " "),
            Arguments.of(Expense(BREAKFAST, 10000), "X"),
            Arguments.of(Expense(DINNER, 200), " "),
            Arguments.of(Expense(DINNER, 20000), "X"),
            Arguments.of(Expense(CAR_RENTAL, 300), " "),
            Arguments.of(Expense(CAR_RENTAL, 30000), " "),
        )
    }
}