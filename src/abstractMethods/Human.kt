package abstractMethods

abstract class Human (val name: String) {

    //Мы не можем создать объект абстрактного класса, но можем создать переменную
    fun hello() {
        println("hello $name")
    }

    //Абстрактные классы могут иметь Абстрактные метода, которые не содержат реализации
    abstract var age: Int
    abstract fun getAge()

}

//Абстарктные классы можно насследовать
class Person(name: String) : Human(name) {

    override var age: Int = 1

    override fun getAge() {
        println("I'm $age years old")
    }
}

//Абстрактные свойства можно так же реализовать в первичном конструкторе
class FooA(name: String, override var age: Int) : Human(name) {

    override fun getAge() {
        println ("fooA age: $age")
    }
}