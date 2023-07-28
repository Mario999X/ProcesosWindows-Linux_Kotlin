package jar

/*
* Por alguna razon, el programa funciona si bajamos la version de kotlin en build.gradle.kts
*     kotlin("jvm") version "1.7.10" (nueva linea)
*     kotlin("jvm") version "1.7.20" (antigua linea)
*
* Para contruir el jar, pulsamos en Gradle (derecha IntelIJ) -> build -> build
* */
fun main(args: Array<String>) {
    when (args.size) {
        2 -> {
            for (i in args[0].toInt()..args[1].toInt()) {
                println(i)
                Thread.sleep(1000)
            }
        }

        else -> println("Error")

    }
}