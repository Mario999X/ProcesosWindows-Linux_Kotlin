object Ejercicio1 {
    // LINUX
    fun linux() {

        // FREE
        println("Comando FREE")
        val freePB = ProcessBuilder("bash", "-c", "free").start()
        val reader = freePB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        //freePB.waitFor()
        println(reader)

        // MT
        println("Comando MT")
        val mtPB = ProcessBuilder("bash", "-c", "mt --v").start()
        val reader2 = mtPB.inputStream.bufferedReader().lineSequence().first()
        //mtPB.waitFor()
        println(reader2)

        // DF
        println("Comando DF")
        val dfPB = ProcessBuilder("bash", "-c", "df").start()
        val reader3 = dfPB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        //dfPB.waitFor()
        println(reader3)

        // PS
        println("Comando PS")
        val psPB = ProcessBuilder("bash", "-c", "ps").start()
        val reader4 = psPB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        //psPB.waitFor()
        println(reader4)

        // FDISK
        println("Comando FDISK")
        val fDiskPB = ProcessBuilder("bash", "-c", "fdisk -v").start()
        val reader5 = fDiskPB.inputStream.bufferedReader().lineSequence().joinToString()
        //fDiskPB.waitFor()
        println(reader5)
    }

    // WINDOWS
    fun windows() {

        // FREE-SYSTEMINFO
        println("Comando SYSTEMINFO")
        val systemInfoPB = ProcessBuilder("cmd.exe", "/c", "systeminfo").start()
        val reader = systemInfoPB.inputStream.bufferedReader().lineSequence()
            .filter { it.contains("Memoria") || it.contains("memoria") }.joinToString("\n")
        //systemInfoPB.waitFor()
        println(reader)

        // MT- No encontre equivalente en Windows

        // DF- Lo mas cercano es fsutil, pero la mayoria de opciones dan error por acceso denegado

        // PS-TASKLIST
        println("Comando TASKLIST")
        val taskListPB = ProcessBuilder("cmd.exe", "/c", "tasklist").start()
        val reader2 = taskListPB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        //taskListPB.waitFor()
        println(reader2)

        // FDISK-ª
    }
}