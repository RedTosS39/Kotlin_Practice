
import gettersAndSetters.GetA
import gettersAndSetters.GetB
import overrideProerties.FooA
import overrideProerties.FooB
import overrideProerties.getOverrideProperties
import testing.Employee
import testing.TestingEmployee
import testing.Person as testingPerson
import emeil.send as emailSend
import  emeil.Message as EmailMessage
import testing.Message as SmsMessage
import  testing.someTest as smsSend
import  abstractMethods.*
import anonymous.printSayHello
import anonymous.printSayHello
import anonymous.showCreatePerson
import base.Day
import base.Names
import base.Operation
import base.operate
import collections.getCollection
import coroutines.funCor
import dataClasses.DataPerson
import delegats.getDelegate
import delegats.getMessageA
import delegats.getPers
import exceptions.getException
import extensionMethods.getFoo
import fromTypeToType.getSmth
import generics.*
import infixNotation.getInf
import interfaces.Aircraft
import interfaces.Car
import interfaces.Movable
import nestedClasses.BankAccount
import nestedClasses.PrivatePerson
import nestedClasses.RepeatA
import testing.getBoo
import testing.sendIFoo

import nestedClasses.Person as NestedPerson

suspend fun main() {

    val tim = Person("Dima", 23, "qwer")
    val tom = Person("Tom", 23)

    tim.sayAbout(tim.name, tim.age)
    tom.sayAbout(tom.name, tom.age)

    val myMessage = EmailMessage("Hello ")
    emailSend(myMessage, "to@from.com")

    val mySms = SmsMessage("this is sms message")
    smsSend(mySms, "12354")

    //Вызов подкласса (класса насследника)

   /* val bob = Employee("Bob", "Apple")
    bob.printName()
    bob.printCompany()
*/

    val sam = testingPerson("Sam", 12)
    // sam.printPerson(); - нельзя вызвать, т.к. printPerson() - protected и видим только в насследниках

    val bob = Employee("Bob", 12)
    bob.printEmployee()

    //Модификаторы доступа в функциях
    val testingPrivacy = TestingEmployee("Testing", 1)
    testingPrivacy.showPrintPerson();

    //Getters and Setters

    var getterA = GetA("Getter", "Setter")

    println(getterA.fullName)

    val getterB = GetB("getterB")
    println(getterB.age) // 1

    getterB.age = 3
    println(getterB.age) // 3

    getterB.age = 11
    println(getterB.age) // 3

    //Переопределение свойств (Override)
    getOverrideProperties()

    // Переопределение Геттеров и Сеттеров

    val fooA = FooA("FooA")
    val fooB = FooB("FooB", "apple")

    fooA.display()
    fooB.display()

    //Абстрактные классы и методы

    //Мы не можем создать объект абстрактного класса,
    // val alice: Human = Human("Alice") !Нельзя!

    //но можем создать переменную:
    val kate: Human = Person("Kate")
    kate.hello()
    kate.getAge()

    //Реальный пример с Геометрическими фигурами

    val figure: Figure = Rectangle(10.2F, 20F)
    figure.getResult()

    //Примеры с интерфейсами
    val car: Movable = Car("223", "Num: 222", 20)
    car.move()
    car.stop()

    val aircraft: Movable = Aircraft()
    aircraft.move()
    aircraft.stop()

    // Вложенные классы и методы
    val userAcc = NestedPerson.Account("Name", "1234")
    userAcc.showDetails()

    //приватные вложенные классы

    val privateAcc = PrivatePerson("Private Username", "Private Password")
    privateAcc.showPrivateAccountDetails()

    //доступ внутреннего класса к внешнему:
    //в том числе с примером совпадения имен
    val bank = BankAccount(5000)
    bank.Transaction(1000).pay()


    //DATA классы
    val alice: DataPerson = DataPerson("Alice", 23)
    println(alice.toString())

        //Пример копирования данных
    val sara = alice.copy(name = "Sara")
    println(sara.toString())

        //декомпозиция на переменные
    val (userName, userAge) = alice
    println("Name: $userName, Age: $userAge")


    // Перечисления.
    val day1: Day = Day.FRIDAY

    println(day1)
    println(Day.MONDAY)


    //Вызов функции в перечислениях
    val name1: Names = Names.DIMA;
    val name2: Names = Names.GALYA
    println(name1.getDuration(name2))

    println( name1.ordinal) // возвращает порядковый номер константы
    println(name2.name) //возвращает название константы в виде строки

    name2.getValues()

    //Хранение состояний в перечислениях
    println(operate(1, 2, Operation.SUBTRACT))
    println(operate(1, 2, Operation.ADD))
    println(operate(1, 2, Operation.MULTIPLY))


    //Делегаты
    getDelegate()
    getMessageA()

    //Анонимные методы
    printSayHello()
    showCreatePerson()


    //GENERICS
    getType()
    getWord()
    getDisplay()
    displayBiggest()

    //Ковариантности
    displayResult()

    //Практика по дженерикам
    println("Практика: ")
    sendIFoo()
    getBoo()

    //исключения
    getException()

    //Делегирование свойств
    getPers()

    //Преобразование типов
    getSmth()

    //Расширение функуций
    getFoo()

    //Инфиксные функции
    getInf()
    //Коллекции
    getCollection()

    //Корутины
    funCor()
}

