package anonymous

open class PersonAnon(val name: String) {

    open fun PrintName() {
        println("My AnonName: $name")
    }
}

//Анонимный класс : Насследуемый класс()
val tom = object  : PersonAnon("Tom") {

    val company = "JetBrains"
    override fun PrintName() {
        println("Hi! My name is $name, I work in $company")
    }
}

//Анонимный объект может передаваться в качестве аргумента в вызов функции

fun hello (person: Person) {
    person.sayHello()
}

open class Person(val name: String) {
    open fun sayHello() = println("Hello $name")
}


fun printSayHello () {
    tom.PrintName()

    //Анонимный объект как аргумент функции
    hello(
        object : Person("Sam") {
            val company = "Apple"
            override fun sayHello() {
                println("$name works in $company")
            }
        })

    //Пример обычного вызова
    val p = Person("Dima")
    hello(p)
}

//Объект как результат функуции
open class Human(val name: String)

private fun createPerson(_name: String, _comp: String) = object: Human(_name) {
    val company = _comp
}

fun showCreatePerson() {
    //Объект как результат функуции
    val joe = createPerson("Joe", "Google")

    println("Joe.Name: " + joe.name) //Вызовет  Joe
    println("Joe.company: " + joe.company) // Joe.company: Google

}