package com.marcinmoskala.minions

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import kotlin.reflect.KClass

var globalGson: Gson = GsonBuilder().create()

fun Any?.toJson() = if (this == null) null else globalGson.toJson(this)

@JvmName("toJsonNonNullable") fun Any.toJson() = globalGson.toJson(this)!!

inline fun <reified T : Any> String.fromJson() = fromJson(T::class)

fun <T : Any> String.fromJson(clazz: KClass<T>) = try {
    globalGson.fromJson(this, clazz.java)
} catch (e: JsonSyntaxException) {
    logError(e, "Error in parsing \"$this\" to ${clazz.java}")
    null
}
