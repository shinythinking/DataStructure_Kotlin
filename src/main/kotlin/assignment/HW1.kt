package shinythinking.assignment

import shinythinking.makeOutput
import shinythinking.readFile

fun getHanoi(ring: Int): Int {
    if (ring == 1) return 1

    return getHanoi(ring - 1) + ring + getHanoi(ring - 1)
}

class HW1 {
    companion object {
        const val SOURCE_FILE = "input_hw1.txt"
        const val OUTPUT_FILE = "output.txt"
    }

    fun run() {
        val input = readFile(SOURCE_FILE).split("\n")
        val testcase = input[0].toInt()
        val answer = buildString {
            for (i in 1..testcase) {
                appendLine(getHanoi(input[i].toInt()))
            }
        }
        makeOutput(OUTPUT_FILE, answer)
    }
}
