package nestedClasses

class Person {

    class Account(val userName: String, val password: String) {

        fun showDetails() {
            println("UserName: $userName Password: $password")
        }
    }
}
//Если необходимо ограничить область применения, то исп. private

class PrivatePerson(userName: String, password: String) {

    private class PrivateAccount(val userName: String, val password: String)

    //создаем приватный экземпляр класса PrivateAccount
    private val account: PrivateAccount = PrivateAccount(userName, password)

    fun showPrivateAccountDetails() {
        println("UserName: ${account.userName} Password: ${account.password}")
    }


    //Класс так же может содержать вложенные интерфейсы, который могут содержать классы:
    //Стоит учитывать что вложенные классы по умолчанию не имеют доступа к функциям внешнего класса
    interface SomeInterface {
        class NestedClass
        interface NestedInterface
    }

    class SomeClass {
        class NestedClass
        interface NestedInterface
    }
}


//Что бы вложенный класс мог иметь доступ к функция внешнего, необходимо определить его как inner:

class BankAccount(private var sum: Int) {

    fun displaySum() {
        println("sum = $sum")
    }

    inner class Transaction(private var sum: Int){
        fun pay() {
            this@BankAccount.sum -= this@Transaction.sum
            displaySum()
        }
    }
}

//Совпадение имен:
class RepeatA {
    private val n: Int = 2
    inner class RepeatB{
       private val n: Int = 1
        fun showN() {
            //Обращаемся к свойствам внешнего класса через конструкцию:
            //this@.название_класса.название свойств
            println(n) // n from B
            println(this.n)  // n from B
            println(this@RepeatB.n) // n from B
            println(this@RepeatA.n)  // n from A
        }
    }
}
