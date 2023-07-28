import utils.OSController
import java.io.File
import java.nio.file.Paths

private val FS = File.separator

fun main(){

    val listaNumeros = ArrayList<String>()

    println("Lanzando ejercicio 2")
    val comprobador: Boolean = OSController.init()

    val userDir = System.getProperty("user.dir")
    val pathJar = Paths.get(userDir + FS + "build" + FS + "libs")

    var line: String?

    if (!comprobador){
        val windowsPB = ProcessBuilder("cmd.exe", "/c", "cd $pathJar & java -jar ProcesosKotlin2-1.0.jar 10 50").start()

        val reader = windowsPB.inputStream.bufferedReader()
        while (reader.readLine().also { line = it } != null){
            listaNumeros.add(line.toString())
        }
        windowsPB.waitFor()

        val listaAlReves = listaNumeros.asReversed();
        println(listaNumeros)
        println(listaAlReves)
    } else {

        val linuxPB = ProcessBuilder("bash", "-c", "cd $pathJar && java -jar ProcesosKotlin2-1.0.jar 10 50").start()

        val reader = linuxPB.inputStream.bufferedReader()
        while (reader.readLine().also { line = it } != null){
            listaNumeros.add(line.toString())
        }
        linuxPB.waitFor()

        val listaAlRevesLinux = listaNumeros.asReversed();
        println(listaNumeros)
        println(listaAlRevesLinux)
    }
}