package extras

import utils.OSController

fun main(){
    val comprobador: Boolean = OSController.init()

    if (!comprobador){
        val winPB = ProcessBuilder().command("cmd.exe", "/c", "ping google.es").start()
        val reader1 = winPB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        println(reader1)
    } else {
        val linPB = ProcessBuilder().command("bash", "-c", "ping -c 5 google.es").start()
        val reader2 = linPB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        println(reader2)
    }
}

