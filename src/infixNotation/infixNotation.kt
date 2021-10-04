package infixNotation

//Инфиксная нотация представляяе помешение оператора или функуции перед операндами или аргументами.
//Для определения инфиксной функции в начале ее определения указывается ключевое слово infix:
//infix fun funcName(параметр: тип параметра): возвращаемый тип {}
//!!! ПАРАМЕТР НЕ ДОЛЖЕН ИМЕТЬ ЗНАЧЕИЙ ПО УМОЛЧАНИЮ И НЕ ДОЛЖЕН БЫТЬ ANY
//Два способа определения инфиксной функции: Либо внутри класса, либо как функция расширения


//1 Внтури класса

fun getInf() {
    //1 Пример
    val acc = Account(100)
    acc put 150

    //Это равонсильно вызову:
    acc.put(150)
    acc.printSum()

    //2 Пример
    val secAcc = SecondAccount(100)
    secAcc put 100
    secAcc.printSecondSum()

    //3 пример
    val hello = "hello world"
    val lCount = hello wordCount 'l'
    val oCount = hello wordCount 'o'
    println(lCount)
    println(oCount)

}

class Account(var sum: Int) {
    infix fun put(amount: Int) {
        sum += amount
    }
    fun printSum() = println(sum)
}

//2 функция расширения

class SecondAccount(var sumS: Int) {
    fun printSecondSum() = println(sumS)
}

infix fun SecondAccount.put(amount: Int) {
    this.sumS += amount
}

//Инфиксные функуции могут определяться как функции расширения
infix fun String.wordCount(c: Char): Int{
    var count = 0
    for(n in this)
        if (n == c) count++
    return count
}