package testing

//Инвариантность
/*
interface IFoo<T>
open class Base(val str: String)
class Derived(str: String) : Base(str)

fun getBase(obj: IFoo<Base>) {

    val base: IFoo<Base> = obj
}

fun getDerived(obj: IFoo<Derived>) {
    val derived: IFoo<Derived> = obj
}

*/


//Ковариантность
interface IFoo<out T: Base> {
    fun getBase(str: String) : T //Функция возвращает тип Т. в Нашем случае тип Base
}

open class Base(val str: String)

class Derived(str: String) : Base(str) //Класс который отправляет сообщения

class GetSmth() : IFoo<Base> {  //В Данном случае  GetSmth() представляет тип IFoo<T>
    override fun getBase(str: String): Derived {
        return Derived("Derived Text: $str")
    }
}

fun sendIFoo() {

    val iFoo: IFoo<Base> = GetSmth()
    val message = iFoo.getBase("Message")
    println(message.str)
}

//Контравариантность
// Предполагает, что если у нас есть классы Base u Derived,
// то объекту SomeClass<Derived> мы можем присвоить знаяение SomeClass<Base>

interface IBoo<in T> {   //in Означает что обобщенный тип может получать значения типа Т через параметр функуции

    fun getBoo(x: T) //Передаем значение
}

open class BooBase(val string: String) //Создаем базовый класс, который принимает строку
class BooDerived(string: String) : BooBase(string) // Класс-нассладник от базового, который будет передавать сообщение
class InstantBoo(): IBoo<BooBase> {  // Класс который будет реализовывать интрейфейс

    override fun getBoo(x: BooBase) {
        println(x.string)
    }
}

fun getBoo() {
    val iBoo: IBoo<BooBase> = InstantBoo()
    val booDerived = BooDerived("Some Message")
    iBoo.getBoo(booDerived)
}
