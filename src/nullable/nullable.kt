package nullable
// val d: Int = null - недопустимо, т.к. Int допускает только значения типа Int
//Что бы превратить обычный тип в тип nullable нужно после названия типа поставить ?

val d : Int? = null  // - допустимо
//Nullable Тип могут иметь и классы:

fun getN() {
    var sam: N? = N("N")
    sam = null
}

class N(val name: String)

//Nullable типы имеют ряд ограничений

//1. Нельзя напрямую присвоить из значение переменным
//var str: String? = "Hello"
//val hello: String = str  ОШИБКА. hello не допускает null

//2. У них нельзя вызывать функуции и свойста, которые есть у обычных типов
/*
var str: String? = "Hello"
str.Length  ошибка!
 */

// ОПЕРАТОР ?:
//Он позволяет предоставить альтернативное значение если присваемое значение равно null

var name: String? = null
var bob: String = name ?: "BOB"
var num: Int? = null
val numbs: Int = num ?: 0

// ОПЕРАТОР ?.
//Позволяет проверить и на null и обратиться к функции
// Например если у строки null,то мы не сможем проверить ее длину, но с оператором ?. смодем
var message: String? = "Hello"
val length: Int? = message?.length
val length2: Int = message?.length ?: 0

//Пример
fun getExample() {

    var tom: Ex? = Ex("tom")
    val tomName: String? = tom?.str?.toUpperCase()
    println(tomName)  //123

    var tim: Ex? = null
    val timName: String? = tim?.str?.toUpperCase()
    println(timName)  //null

    var tem: Ex? = Ex(null)
    val temName: String? = tem?.str?.toUpperCase()
    println(temName)  //null

    //Или можно так, присвоев значение по умолчанию
val tamName: String = tom?.str?.toUpperCase() ?: "Tam"

}
class Ex(val str: String?)

//Оператор !! (not null assertion)
//Принимает один операнд, если операнд == null, то генерирует исключение, else: возвращает значение
//Пример:

fun getExample2() {
    try {
        val x: String? = "X"
        val id: String = x!!
        println(id)

        val y: String? = null
        val getX: Int = y!!.length
        println(getX)

    } catch (e: Exception) {
        println(e.message)
    }
}
