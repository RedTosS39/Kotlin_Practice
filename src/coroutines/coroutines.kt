package coroutines

import kotlinx.coroutines.*

//coroutineScope - создает (контекст корутины)
//Сама корутина запускается в функции launch
// и запускает ее независимо от прочего кода

//ВЫнесение кода коррутин в отдельную функцию
suspend fun funCor() = coroutineScope {

    launch {
        corA()
    }
    println("Hi coroutines")

    //запуск нескольких корутин
    launch {
        for (n in 1..5) {
            delay(400L)
            println(n)
        }
    }

    launch {
        corB()
    }
}

suspend fun corA() {
    for (n in 6 downTo -1) {
        delay(400L)
        println(n)
    }
}

suspend fun corB() {
    try {
        when (val x: Int = readLine()!!.toInt()) {
            in 1..2 -> {
                println(x)
            }
            else -> {
                corA()
            }
        }
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}

/* Корутина может выпольняться только в области корутин (coroutine scope)
* - это пространство, имеющее жизненный цикл и сама управляет жизненным циклом внутри*/


