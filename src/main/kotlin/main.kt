package ru.netology

fun agoToText(wasOnlineSeconds: Int) {
    when (wasOnlineSeconds) {
        in 0..60 -> println("Был(а) только что")
        in 61..3600 -> println("Был(а) " + selectMinutes(wasOnlineSeconds))
        in 3601..86400 -> println("Был(а) " + selectWatch(wasOnlineSeconds))
        in 86401..172800 -> println("Был(а) вчера")
        in 172801..259200 -> println("Был(а) позавчера")
        in 259201..Long.MAX_VALUE -> println("Был(а) давно")
    }
}

fun selectMinutes(wasOnlineSeconds: Int): String {
    val wasOnlineMinutes = wasOnlineSeconds / 60
    return when (wasOnlineMinutes) {
        1, 21, 31, 41, 51 -> "$wasOnlineMinutes минуту назад"
        2, 22, 32, 42, 52 -> "$wasOnlineMinutes минуты назад"
        3, 23, 33, 43, 53 -> "$wasOnlineMinutes минуты назад"
        4, 24, 34, 44, 54 -> "$wasOnlineMinutes минуты назад"
        else -> "$wasOnlineMinutes минут назад"
    }
}

fun selectWatch(wasOnlineSeconds: Int): String {
    val wasOnlineHours = wasOnlineSeconds / 3600
    return when (wasOnlineHours) {
        1, 21 -> "$wasOnlineHours час назад"
        2, 3, 4, 22, 23, 24 -> "$wasOnlineHours часа назад"
        else -> "$wasOnlineHours часов назад"
    }
}

fun main() {
    val wasOnlineSeconds = 301

    agoToText(wasOnlineSeconds)
}