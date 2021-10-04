package testing

open class TestingPrivacy private constructor(private val name: String){

    fun printPerson() {
        println("Name from TestingPrivacy: $name")
    }

    var age: Int = 0;

    protected constructor(_name: String, _age: Int) : this(_name) {
         age = _age
    }

    fun showAge() {
        println("age: $age")
    }
}

class TestingEmployee(name: String, age: Int) : TestingPrivacy(name, age){
    fun showPrintPerson() {
        showAge()
        printPerson()
    }
}