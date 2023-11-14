package com.carlos.noteappcleanarchitecture.data.local.converter

import androidx.room.TypeConverter
import java.util.Date

class DataConverter {

    @TypeConverter
    fun toData(date: Long?): Date? {
        return date?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}