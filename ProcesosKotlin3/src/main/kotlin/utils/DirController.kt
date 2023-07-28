package utils

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object DirController {
    private val FS = File.separator

    fun init() {
        val workinDir = System.getProperty("user.dir")

        val pruebaPath = Paths.get(workinDir + FS + "data")

        if (Files.isDirectory(pruebaPath) && Files.exists(pruebaPath)) {
            println("Carpeta data comprobada")
        } else {
            Files.createDirectory(pruebaPath)
            println("Carpeta data creada")
        }
    }
}