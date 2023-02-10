package com.nelkinda.training

data class Expense(val type: ExpenseType, val amount: Int = 0) {
    fun overLimitMarker(): String = if (type.isOverLimit(amount)) "X" else " "
}