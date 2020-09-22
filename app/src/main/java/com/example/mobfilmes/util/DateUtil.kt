package com.example.mobfilmes.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        @SuppressLint("SimpleDateFormat")
        val PATTERN_1 = SimpleDateFormat("dd-MM-yyyy")

        @SuppressLint("SimpleDateFormat")
        val PATTERN_2 = SimpleDateFormat("yyyy-MM-dd")

        fun formatDate(date: Date, pattern: SimpleDateFormat): String {
            return pattern.format(date)
        }

        fun parseToDate(date: String, pattern: SimpleDateFormat): Date {
            return pattern.parse(date) as Date
        }
    }
}