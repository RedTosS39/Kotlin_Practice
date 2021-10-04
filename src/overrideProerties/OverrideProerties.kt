package overrideProerties

//Переопределение свойств
open class OPersonA (val name: String, open var age: Int = 1) {

}

 class OEmployeeA(name: String) : OPersonA(name) {

    override var age: Int = 10
}

// Переопределение сразу в первичном конструкторе:

class OEmployeeB(name: String, override var age: Int = 2) : OPersonA(name, age) {}

fun getOverrideProperties() {
    val personA = OPersonA("PersonA")
    println("Name: ${personA.name} Age: ${personA.age}") //PersonA, 1

    val oEmployeeA =  OEmployeeA("oEmployeeA")
    println("Name: ${oEmployeeA.name} Age: ${oEmployeeA.age}") // oEmployeeA, 10

    val oEmployeeB = OEmployeeB("oEmployeeB")
    println("Name: ${oEmployeeB.name} Age: ${oEmployeeB.age}") // oEmployeeB, 2
}

// Переопределение Геттеров и Сеттеров

open class FooA(val name: String) {
    open val info: String
    get() = "class fooA: person  $name - $age"

    open var age: Int = 1
        set(value) {
            if(value in 1..110)
                field = value
        }

    //Переопределение методов
    open fun display() {
        println(info)
    }
}

open class FooB(name: String, val company: String) : FooA(name) {

    override val info: String
        get() = "class fooB: $name - $age"

    override var age: Int = 22
        set(value) {
            if(value in 20..100)
            field = value
        }

    override fun display() {
        println("$info work in $company")
    }

}

// Переопределение в иерархии наследования классов

open class Pers(val name: String) {

    open val info: String
        get() = "Name: $name"

    open fun display() {
        println("Name: $name")
    }

    open  fun displayA() {
        println("Name: $name ")
    }
}

open class Empl(name: String, val company: String) : Pers(name) {

    override fun displayA() {
        println("Name: $name Company: $company")
    }

    final override fun display() {
        println("Name: $name Company: $company")
    }
}

class Manager(name: String, company: String): Empl(name, company) {

    //с помощью super. в производном классе можно обащаться к реализации из базового класса
    override val info: String
        get() = "${super.info} Company: $company"

    override fun displayA() {
        super.displayA()
        println("Company: $company")
    }

    //ЗАПРЕТ ПЕРЕОПРЕДЕЛЕНИЯ
    /*
     т.к. в Empl стоит final, то переопределить функцию нельзя
     override fun display() {
        println("Name: $name Company: $company Position: Manager")
    }
     */

}
