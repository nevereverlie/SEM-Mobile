package com.example.revisory_control_mobile.models

import java.util.*

interface Printable{
    fun printName(): String
}
enum class WeekDay(val day: Int) : Printable{
    MONDAY(1){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "Понеділок"
            else
                "Monday"
        }
    },
    TUESDAY(2){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "Вівторок"
            else
                "Tuesday"
        }
    },
    WEDNESDAY(3){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "Середа"
            else
                "Wednesday"
        }
    },
    THURSDAY(4){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "Четвер"
            else
                "Thursday"
        }
    },
    FRIDAY(5){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "П'ятниця"
            else
                "Friday"
        }
    },
    SATURDAY(6){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "Субота"
            else
                "Saturday"
        }
    },
    SUNDAY(7){
        override fun printName(): String {
            return if (Locale.getDefault().displayLanguage == "українська")
                "Неділя"
            else
                "Sunday"
        }
    }
}