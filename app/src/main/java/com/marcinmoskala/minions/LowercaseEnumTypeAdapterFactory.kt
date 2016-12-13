package com.marcinmoskala.minions

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class LowercaseEnumTypeAdapterFactory : TypeAdapterFactory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val rawType = type.rawType as Class<T>
        if (!rawType.isEnum) return null
        return createEnumTypeAdapter(lowercaseToConstant(rawType))
    }

    private fun <T : Any> lowercaseToConstant(rawType: Class<T>): Map<String, T> = rawType
            .enumConstants
            .map { it.toString().toUpperCase() to it }
            .toMap()

    private fun <T : Any> createEnumTypeAdapter(lowercaseToConstant: Map<String, T>) = EnumTypeAdapter(lowercaseToConstant)
}

private class EnumTypeAdapter<T>(val lowercaseToConstant: Map<String, T>) : TypeAdapter<T>() {
    override fun read(reader: JsonReader): T? = when {
        reader.peek() == JsonToken.NULL -> reader.nextNull().let { null }
        else -> lowercaseToConstant[reader.nextString().toUpperCase()]
    }

    override fun write(out: JsonWriter, value: T?) {
        if (value == null) out.nullValue()
        else out.value(value.toString().toUpperCase())
    }
}