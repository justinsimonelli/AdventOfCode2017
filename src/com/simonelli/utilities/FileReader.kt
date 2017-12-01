package com.simonelli.utilities

import java.io.File
import java.io.InputStream

class FileReader{

    fun getPuzzleInput(filePath: String): String {
        val inputStream: InputStream = File(filePath).inputStream()
        return inputStream.bufferedReader().use { it.readText() }
    }
}