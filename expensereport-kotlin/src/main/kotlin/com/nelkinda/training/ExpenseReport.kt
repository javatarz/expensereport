package com.nelkinda.training

import java.util.Date

class ExpenseReport(
    private val printer: (String) -> Any = ::println,
    private val dateProvider: () -> Date = { Date() }
) {
    fun printReport(expenses: List<Expense>) {
        printer("Expenses ${dateProvider()}")

        expenses.forEach {
            printer(it.type.reportName + "\t" + it.amount + "\t" + it.overLimitMarker())
        }

        val (mealExpenses, otherExpenses) = expenses
            .partition { it.type == ExpenseType.DINNER || it.type == ExpenseType.BREAKFAST }
        val mealExpenseTotal = mealExpenses.sumOf { it.amount }
        val total = mealExpenseTotal + otherExpenses.sumOf { it.amount }

        printer("Meal expenses: $mealExpenseTotal")
        printer("Total expenses: $total")
    }
}
