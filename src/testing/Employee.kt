package testing

class Employee(name: String, age: Int) : Person(name, age) {

    fun printEmployee() {
        println("Employee name is: $name")

        printPerson()
    }


}