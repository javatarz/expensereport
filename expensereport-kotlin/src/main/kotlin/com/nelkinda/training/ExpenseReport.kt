package com.nelkinda.training

import java.util.*

class ExpenseReport(
    private val printer: (String) -> Any = ::println,
    private val dateProvider: () -> Date = { Date() }
) {
    fun printReport(expenses: List<Expense>) {
        printer("Expenses ${dateProvider()}")

        expenses.forEach {
            printer(it.type.reportName + "\t" + it.amount + "\t" + it.overLimitMarker())
        }

        val (mealExpenseTotal, otherExpensesTotal) = expenses.partition { it.type.isMealType() }
            .toList()
            .map { it.sumOf { e -> e.amount } }
        val total = mealExpenseTotal + otherExpensesTotal

        printer("Meal expenses: $mealExpenseTotal")
        printer("Total expenses: $total")
    }
}
