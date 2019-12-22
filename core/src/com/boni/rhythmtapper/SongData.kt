package com.boni.rhythmtapper

import com.badlogic.gdx.files.FileHandle

class SongData(
        private var songName: String,
        private var songDuration: Float,
        private val keyTimeList: ArrayList<KeyTimePair>,
        private var keyTimeIndex: Int
) {

    fun addKeyTime(k: String, t: Float) {
        keyTimeList.add(KeyTimePair(k, t))
    }

    fun resetIndex() {
        keyTimeIndex = 0
    }

    fun advanceIndex() {
        keyTimeIndex++
    }

    fun getCurrentKeyTime() = keyTimeList[keyTimeIndex]

    fun keyTimeCount() = keyTimeList.count()

    fun isFinished() = keyTimeIndex > keyTimeCount()

    fun writeToFile(file: FileHandle) {
        file.writeString("$songName\n", false)
        file.writeString("$songDuration\n", true)

        keyTimeList.forEach {
            val data = "${it.key},${it.time}\n"
            file.writeString(data, true)
        }
    }

    fun readFromFile(file: FileHandle) {
        val rawData = file.readString()
        val dataArray = rawData.split("\n")

        songName = dataArray.first()
        songDuration = dataArray[1].toFloat()

        keyTimeList.clear()

        for (i in 2 until dataArray.count()) {
            val keyTimeData = dataArray[i].split(",")
            val key = keyTimeData.first()
            val time = keyTimeData[1].toFloat()

            keyTimeList.add(KeyTimePair(key, time))
        }
    }

    class KeyTimePair(val key: String, val time: Float)
}