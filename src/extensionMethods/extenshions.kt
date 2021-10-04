package extensionMethods

//Функции расширения - позволяют добавлять функцианал к типам (кроме private и protected)
// fun Тип.Имя(параметр) : возвращаемый тип{
//      Тело функции
// }


fun getFoo() {
    val hello: String = "Hello World"
    println(hello.fooCount('o')) //2
    println(hello.fooCount('l')) //3

    val ch = 'a'
    val chString = ch.fooChar(ch)
    println(chString.fooCount('a'))

    println(4.fooSquad()) //16
    println(9.fooSquad()) //81
}

// Через this мы можем ссылать к объектам того типа, для которого создается функуция
fun String.fooCount(c: Char) : Int{
    var count: Int = 0

    for(n in this)
        if(n == c) count++
    return count
}

fun Int.fooSquad(): Int {
    return this * this
}

fun Char.fooChar(ch: Char): String {
    return ch.toString()
}

