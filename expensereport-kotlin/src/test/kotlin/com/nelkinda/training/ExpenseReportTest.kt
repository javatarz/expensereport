package com.nelkinda.training

import com.nelkinda.training.ExpenseType.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Date

internal class ExpenseReportTest {
    @Test
    internal fun shouldPrintExpenseReport() {
        val expenses = listOf(
            Expense(BREAKFAST, 100),
            Expense(BREAKFAST, 10000),
            Expense(DINNER, 200),
            Expense(DINNER, 20000),
            Expense(CAR_RENTAL, 700),
        )
        val frozenDate = Date()
        val expected = listOf(
            "Expenses $frozenDate",
            "Breakfast\t100\t ",
            "Breakfast\t10000\tX",
            "Dinner\t200\t ",
            "Dinner\t20000\tX",
            "Car Rental\t700\t ",
            "Meal expenses: 30300",
            "Total expenses: 31000",
        )
        val actual = mutableListOf<String>()

        ExpenseReport({ actual.add(it) }) { frozenDate }.printReport(expenses)

        assertEquals(expected, actual)
    }
}