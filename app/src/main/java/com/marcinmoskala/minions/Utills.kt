package com.marcinmoskala.minions

import java.security.SecureRandom

@JvmName("IntMean") fun Collection<Int>.mean() = sum().toFloat() / size
@JvmName("FloatMean") fun Collection<Float>.mean() = sum() / size

const val AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
private val random = SecureRandom()

fun randomString(len: Int): String {
    val sb = StringBuilder(len)
    for (i in 1..len) sb.append(AB[random.nextInt(AB.length)])
    return sb.toString()
}

fun <K, V, R> Map<K, V>.foldRight(initial: R, operation: (K, V, R) -> R)
        = toList().foldRight(initial, { m, r -> operation(m.first, m.second, r) })

fun measureTime(f: () -> Unit) {
    val startTime = System.currentTimeMillis()
    f()
    val endTime = System.currentTimeMillis()
    println("It took " + (endTime - startTime))
}