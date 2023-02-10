package com.nelkinda.training

import java.util.Date

data class Expense(val type: ExpenseType, val amount: Int = 0) {
    fun overLimitMarker(): String = if (type.isOverLimit(amount)) "X" else " "
}

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
