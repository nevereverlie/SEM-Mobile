package com.example.revisory_control_mobile.models

interface Printable{
    fun printName(): String
}
enum class WeekDay(val day: Int) : Printable{
    MONDAY(1){
        override fun printName(): String {
            return "Понеділок"
        }
    },
    TUESDAY(2){
        override fun printName(): String {
            return "Вівторок"
        }
    },
    WEDNESDAY(3){
        override fun printName(): String {
            return "Середа"
        }
    },
    THURSDAY(4){
        override fun printName(): String {
            return "Четвег"
        }
    },
    FRIDAY(5){
        override fun printName(): String {
            return "П'ятниця"
        }
    },
    SATURDAY(6){
        override fun printName(): String {
            return "Субота"
        }
    },
    SUNDAY(7){
        override fun printName(): String {
            return "Неділя"
        }
    }
}