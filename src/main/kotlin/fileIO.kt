package shinythinking

import java.io.File
import java.io.IOException

fun readFile(path: String): String {
    val inputFile = File(path)
    if (!inputFile.exists()) {
        return "Error"
    }

    return buildString {
        try {
            inputFile.bufferedReader().use { reader ->
                reader.forEachLine { line ->
                    appendLine(line)
                }
            }
        } catch (e: IOException) {
            return "Error"
        }
    }
}

fun makeOutput(path: String, answer: String) {
    val outputFile = File(path)
    outputFile.bufferedWriter().use { writer ->
        writer.write(answer)
    }
}