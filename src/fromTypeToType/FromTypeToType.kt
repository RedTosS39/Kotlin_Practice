package fromTypeToType

val str: String = "1a"
fun getSmth() {
    try {
        val int: Int = str.toInt()
        println(int)
    } catch (e: Exception) {
        println(e.message)
    }

    //Проверяем
    checkEmployment(tom)
    checkEmployment(bob)
    checkEmployment(sam)
    checkPerson(tom)
    checkPerson(bob)
    identifyPerson(sam)
    identifyPerson(bob)
    identifyPerson(tom)
}

//  Smart cast и Оператор is
// is - позволяет проверить выражение на принадлежность опр. типу
// значение is тип данных (возвращает true)


val tom = Person("Tom")
val bob = Employee("Bob", "Apple")
val sam = Manager("Sam", "")

fun checkEmployment(person: Person) {

    if(person is Employee && person.company.isNotEmpty()) {
        println("${person.name} works in ${person.company}")
    } else {
        println("${person.name} doesn't have a job")
    }
}

fun checkPerson(person: Person) {
    if(person !is Employee) println("${person.name} doesn't have a job")
        else println("${person.name}} works in ${person.company}}")
}

fun identifyPerson(person: Person) {
    when(person){
        is Manager -> println("${person.name} is a Manager")
        is Employee -> println("${person.name} is a Employee")
        else -> println("${person.name} is just a Person")
    }
}

open class Person(val name: String)
open class Employee(name: String, val company: String): Person(name)
class Manager(name: String, company: String) : Employee(name, company)
