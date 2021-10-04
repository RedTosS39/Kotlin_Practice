package generics


//При использовании типа GPerson необходимо его типизировать опр. Типом.
// (указать какой тип будет передаваться через Т

fun getType() {

    // val tom: GPerson<Int> = GPerson(23, "Tom")
    // val bob: GPerson<String> = GPerson("A234", "Bob")
    // т.к. Конструктор использует тип Т, то можно не указывать конкретный тип объекта

    val tom = GPerson(23, "Tom")
    val bob = GPerson("A234", "Bob")

    println("${tom.id} + ${tom.name}")
    println("${bob.id} + ${bob.name}")

    val sam = GPerson(123, "sam")
    sam.checkId(123) //Same

    val people: Array<String> = arrayOf("Tom", "Bob")

    for (p in people) println(p)
    val numbers: Array<Int> = arrayOf(1, 2, 3)
    for (n in numbers) println(n)
}

class GPerson<T>(val id: T, val name: String) {

    fun checkId(_id: T) {
        if(id == _id) {
            println("Same")
        } else {
            println("Different")
        }
    }
}

//Применение нескольких параметров
class Word<K, V>(val source: K, var target: V)

fun getWord() {
    val word1: Word<String, String> = Word("One", "Two")
    val word2: Word<String, Int> = Word("One", 2)

    println("${word1.source} - ${word1.target}")
    println("${word2.source} - ${word2.target}")
}

//Обобщение функций

fun <T> display(obj: T) {  //функция типа <T> принимает параметр (Т)
    println(obj)
}

fun getDisplay() {
    display("Hello Kotlin")
    display(234)
    display(true)

    //функция отправки сообщений
    val email = EmailMessage("функция отправки сообщений: Email")
    val sms = SmsMessage("функция отправки сообщений: SMS")
    gSend(email)
    gSend(sms)


    getBiggest2(2,3)
    println("Выполнение нескольких ограничений:" + getBiggest3(2, 3))

    //Функция множественных ограничений:
    val gEmail = GEmailMessage("Функция множественных ограничений:  gEmail")
    gSendMessage(gEmail)

    val gText = GTextMessage("Функция множественных ограничений:  gText")
    gSendMessage(gText)

    //Ограничения классов:
    val email2 = GEmailMessage("Ограничения классов 1")
    val outlook = GMessenger<GEmailMessage>()
    outlook.gSendMessage(email2)

    val smsMessage2 = GTextMessage("Ограничения классов 2")
    val skype = GMessenger<GTextMessage>()
    skype.gSendMessage(smsMessage2)
}

//Определим функцию, которая будет возвращать массив

fun <T> getBiggest(args1: Array<T>, args2: Array<T>) : Array<T> {
    return if (args1.size > args2.size) args1
    else args2
}

fun displayBiggest() {
    val arr1 = getBiggest(arrayOf(1,2,3), arrayOf(3, 2, 4, 5))
    arr1.forEach { item -> print("$item") }
    println()

    val arr2 = getBiggest(arrayOf("Dima"), arrayOf("Dima", "Sasha"))
    arr2.forEach { i -> print(i) }
    println()
}

//Ограничения

//Мы не можем сравинвать a:T и b: T т.к. в Т могут передаваться различные типы
//Однако можно сравить типы, которые поддерживают интерфейс Comparable
//т.е. нам нужно, что бы два параметра представляли один и тот же тип:

fun <T: Comparable<T>> getBiggest2(a: T, b: T): T {
    return if(a > b)  a
        else b
}

//Допустим, нам требуется определить функцию для отправки сообщений
//fun gSend использует ограничение T:GMessage т.е. она принимает объекты, который должен реализовать GMessage
fun <T: GMessage> gSend(message: T) {
    println(message.text)
}

interface GMessage {
    val text: String
}

class EmailMessage(override val text: String) : GMessage
class SmsMessage( override val text: String) : GMessage

//Установка нескольких ограничений

//Например
//в данном случае у T два ограничения:
//1. Т должно поддерживать интерфейс Comparable<T>
//2. Т должно быть целочисленное (Наследуется от базового класса  Numbers)
//Если ограничений много, то исп. where
fun<T> getBiggest3(a: T, b: T) : T where T: Comparable<T>, T: Number {
    return if(a > b) a
        else b
}

//Полобным образом мы можешь использовать собственные типы в качестве ограничений

fun <T> gSendMessage(message: T) where T: Message, T: Logger {
    message.log()
}

//Ограничения в классах
//Классы как и функции могут принимать обобщения.
//Например, установка одного ограничения:

class GMessenger <T>() where T: Message, T: Logger  {

    fun gSendMessage(mes: T) {
        mes.log()
    }
}

interface Message { val text: String }
interface Logger { fun log() }

class GEmailMessage(override val text: String) : Message, Logger {

    override fun log() = println("GEmailMessage:  $text")
}

class GTextMessage(override val text: String) : Message, Logger {

    override fun log() = println("GTextMessage: $text")
}