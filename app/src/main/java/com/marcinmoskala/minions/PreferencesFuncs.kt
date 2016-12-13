package com.marcinmoskala.minions

import android.content.SharedPreferences
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import org.joda.time.DateTime
import org.joda.time.LocalDate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

private val gson: Gson by lazy {
    LowercaseEnumTypeAdapterFactory()
    GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapterFactory(LowercaseEnumTypeAdapterFactory())
            .create()
}

fun Any?.toJson() = if(this == null) null else gson.toJson(this)

inline fun <reified T: Any> String.fromJson() = fromJson(T::class)

fun <T: Any> String.fromJson(clazz: KClass<T>) = try {
    gson.fromJson(this, clazz.java)
} catch (e: JsonSyntaxException) {
    logError(e, "Error in parsing \"$this\" to ${clazz.java}")
    null
}


inline fun <reified T : Any> bindToPreferenceField(default: T?, key: String? = null) = PreferenceFieldBinder(T::class, default, key)

@Suppress("UNCHECKED_CAST")
class PreferenceFieldBinder<T : Any>(val clazz: KClass<T>, val default: T?, val key: String? = null) : ReadWriteProperty<SharedPreferences, T?> {

    override operator fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T? = readValue(property, thisRef)

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T?) {
        if (value == null) {
            removeValue(property, thisRef)
        } else {
            saveValue(property, thisRef, value)
        }
    }

    private fun readValue(property: KProperty<*>, thisRef: SharedPreferences): T? = when (clazz.simpleName) {
        "Long" -> thisRef.getLong(getKey(property), default as Long) as? T
        "Int" -> thisRef.getInt(getKey(property), default as Int) as? T
        "String" -> thisRef.getString(getKey(property), default as? String) as? T
        "Boolean" -> thisRef.getBoolean(getKey(property), default as Boolean) as? T
        else -> thisRef.getString(getKey(property), default?.toJson())?.fromJson(clazz)
    }

    private fun removeValue(property: KProperty<*>, thisRef: SharedPreferences) {
        thisRef.edit().remove(getKey(property)).apply()
    }

    private fun saveValue(property: KProperty<*>, thisRef: SharedPreferences, value: T?) {
        thisRef.edit().apply {
            when (clazz.simpleName) {
                "Long" -> putLong(getKey(property), value as Long)
                "Int" -> putInt(getKey(property), value as Int)
                "String" -> putString(getKey(property), value as String?)
                "Boolean" -> putBoolean(getKey(property), value as Boolean)
                else -> putString(getKey(property), value.toJson())
            }
        }.apply()
    }

    private fun getKey(property: KProperty<*>) = key ?: "${property.name}Key"
}