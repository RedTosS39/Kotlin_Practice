package generics

// Вариантность описывает то, как обобщенные типы, типизированные классами соотносятся друг с другом

//Инвариантность - предполагает, что если у нас есть Базовый (Base) и производный (Derived) классы
//то класс C<Base> не явл. ни базовым для C<Derived>, ни производным

interface IMessenger<T: VMessage>

open class VMessage(val text: String)

class VEmailMessage(text: String) : VMessage(text)
//В Случае выше мы не можем присвоить объект IMessenger<VEmailMessage>
//Переменной типа Messenger<VMessage> и наоборот, они никак между собой не соотносятся

//Мы можем присвоить переменным по умолчанию только объекты их типа
fun changeMessengerToDefault(obj: IMessenger<VMessage>) {
    val iMessenger: IMessenger<VMessage> = obj
}

fun changeMessengerToEmail(obj: IMessenger<VEmailMessage>) {
    val vEmailMessage: IMessenger<VEmailMessage> = obj
}

//Ковариантность - предполагает. что есть базовый <Base> класс и производный <Derived>
//и что SomeClass<Base> явл. базовым и для SomeCLass<Derived>
// для обобщенного типа как ковариантного параметра исп out:

interface IPhone<out T: Call> //Ковариантный

open class Call(val text: String)

class InternetCall(text: String) : Call(text)
//теперь мы можем присовить значения

fun changeCall(obj: IPhone<InternetCall>) {
    val call: IPhone<Call> = obj
}

//оut указывает, что тип может возвращать значение из функуции типа Т
//Например
fun displayResult() {

    val iBuilder: IBuilder<Home> = HomeBuilder()
    val home = iBuilder.buildBuildings("Building construction")
    println(home.text)
}
interface IBuilder<out T: Build> {
    fun buildBuildings(text: String) : T
}


open class Build(val text: String)
class Home(text: String) : Build(text)
class HomeBuilder() : IBuilder<Home> {
    override fun buildBuildings(text: String): Home {
        return Home("Home: $text")
    }

}




