import utils.OSController
import java.io.File
import java.nio.file.Paths

private val FS = File.separator

fun main() {
    println("Lanzando ejercicio 3")

    val comprobador: Boolean = OSController.init()

    val userDir = System.getProperty("user.dir")
    val pathJar = Paths.get(userDir + FS + "build" + FS + "libs")

    print("¿Cuantos segundos quiere entre cada copia de seguridad?: ")
    val segundosPedidos = readln().toIntOrNull()

    if (!comprobador) {
        val windowsPB =
            ProcessBuilder("cmd.exe", "/c", "cd $pathJar & java -jar ProcesosKotlin3-1.0.jar $segundosPedidos").start()

        windowsPB.waitFor()
        val exitWin = windowsPB.exitValue()
        println("Valor de salida del proceso de ejercicio 3: $exitWin")
    } else {
        val linuxPB =
            ProcessBuilder("bash", "-c", "cd $pathJar && java -jar ProcesosKotlin3-1.0.jar $segundosPedidos").start()

        linuxPB.waitFor()
        val exitLin = linuxPB.exitValue()
        println("Valor de salida del proceso de ejercicio 3: $exitLin")
    }
}