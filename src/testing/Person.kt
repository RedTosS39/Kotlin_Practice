package testing

 open class Person(protected val name: String, private val _age: Int){

     private  val age = _age

     protected fun printPerson() {
         printName()
         printAge()
     }

     private fun printName() {
        println("Hi, my name is $name")
     }

     private fun printAge() {
         println("I'm $age old")
     }

}