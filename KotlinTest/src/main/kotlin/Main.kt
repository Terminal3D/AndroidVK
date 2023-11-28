import kotlinx.coroutines.*

fun main() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    runBlocking {
        repeat(3) {
            launch(CoroutineName("Coroutine")) {
                println("${coroutineContext[CoroutineName]?.name} has started")
                for (i in states) {
                    println("${coroutineContext[CoroutineName]?.name} - $i")
                    delay(50)
                }
            }
        }
    }

}