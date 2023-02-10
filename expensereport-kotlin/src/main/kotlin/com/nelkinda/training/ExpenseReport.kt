package com.nelkinda.training

import java.util.Date

class ExpenseReport(
    private val printer: (String) -> Any = ::println,
    private val dateProvider: () -> Date = { Date() }
) {
    fun printReport(expenses: List<Expense>) {
        var total = 0
        var mealExpenses = 0

        printer("Expenses ${dateProvider()}")

        for (expense in expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount
            }

            val mealOverExpensesMarker = expense.overLimitMarker()

            printer(expense.type.reportName + "\t" + expense.amount + "\t" + mealOverExpensesMarker)

            total += expense.amount
        }

        printer("Meal expenses: $mealExpenses")
        printer("Total expenses: $total")
    }
}
