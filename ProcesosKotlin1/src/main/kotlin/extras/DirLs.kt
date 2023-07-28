package extras

import utils.OSController

fun main(){
    val comprobador: Boolean = OSController.init()

    if (!comprobador){
        val winPB = ProcessBuilder("cmd.exe", "/c", "dir").start()
        val filterWin = winPB.inputStream.bufferedReader().lineSequence().filter { it.contains("kts") }.joinToString("\n")
        //println(filterWin)
        winPB.waitFor()

        val fileWin = filterWin.lines().first().split(" ").last()
        println(fileWin)

        val winPB2 = ProcessBuilder("cmd.exe", "/c", "type $fileWin").start()
        winPB2.waitFor()

        val findGrepWin = ProcessBuilder("cmd.exe", "/c", """find "jvm" """).start()

        val readOutputWin = winPB2.inputStream.bufferedReader().readText()
        findGrepWin.outputStream.bufferedWriter().use { it.write(readOutputWin) }

        val outputWin = findGrepWin.inputStream.bufferedReader().readText()
        findGrepWin.waitFor()

        println(outputWin)
    } else {
        val linPB = ProcessBuilder("bash", "-c", "ls .").start()
        val filterLin = linPB.inputStream.bufferedReader().lineSequence().filter { it.contains("kts") }.joinToString("\n")
        //println(filterLin)
        linPB.waitFor()

        val fileLin = filterLin.lines().first().split(" ").last()
        println(fileLin)

        val linPB2 = ProcessBuilder("bash", "-c", "cat $fileLin").start()
        linPB2.waitFor()

        val findGrepLin = ProcessBuilder("bash", "-c", "grep jvm").start()

        val readOutputLin = linPB2.inputStream.bufferedReader().readText()
        findGrepLin.outputStream.bufferedWriter().use { it.write(readOutputLin) }

        val outputLin = findGrepLin.inputStream.bufferedReader().readText()
        findGrepLin.waitFor()

        println(outputLin)
    }
}