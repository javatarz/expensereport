package com.nelkinda.training

enum class ExpenseType(val reportName: String, private val highExpenseLimit: Int? = null) {
    DINNER("Dinner", 5000),
    BREAKFAST("Breakfast", 1000),
    CAR_RENTAL("Car Rental");

    fun isOverLimit(expenseAmount: Int): Boolean = highExpenseLimit?.let { expenseAmount > highExpenseLimit } ?: false
    fun isMealType() = this == DINNER || this == BREAKFAST
}