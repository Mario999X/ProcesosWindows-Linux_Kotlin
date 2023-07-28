import utils.OSController

fun main(){

    val comprobador: Boolean = OSController.init()

    if (!comprobador){
        Ejercicio1.windows()
    } else {
        Ejercicio1.linux()
    }
}