package jar

import utils.DirController
import java.io.File
import kotlin.time.Duration.Companion.seconds

private lateinit var file: String

fun main(args: Array<String>) {
    when (args.size) {
        1 -> {
            val FS = File.separator
            val workinDir = System.getProperty("user.dir")

            DirController.init()

            var repeticiones = 0

            val filePath = File((workinDir + FS + "data" + FS + "prueba.txt"))
            val segundos = args[0].toLongOrNull()?.seconds
            println("¿Cuantos segundos quiere entre cada copia de seguridad?:  $segundos ")

            while (repeticiones < (5..10).random()) {
                repeticiones += 1

                file = """--- COPIA DE SEGURIDAD ---
                | $repeticiones repeticiones
            """.trimMargin()

                filePath.writeText(file)

                println("--- COPIA REALIZADA | $repeticiones ---")

                if (segundos != null) {
                    Thread.sleep(segundos.inWholeMilliseconds)
                }

            }
        } else -> println("Error")
    }
}