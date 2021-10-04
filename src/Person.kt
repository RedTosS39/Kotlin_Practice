class Person(_name: String, _age: Int){

    var name: String =_name
    var age: Int = _age

    var secondName: String = ""

    constructor(_name: String, _age: Int, _secondName: String) : this(_name, _age) {
        secondName = _secondName
    }

    fun sayAbout(name: String, age: Int) {
        println("My name is: $name\nI'm $age old")
    }
}