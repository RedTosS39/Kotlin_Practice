package exceptions

//Исключения представляют собой события, которые возникают при выполнении программы и нарушают ее нормальный ход
fun getException() {
    try {
        //Код генерирующий исключение
    } catch (e: Exception) {
        //обработка исключения
    } finally {

        //Постобработка (не обязательный блок)
    }

    //Пример:
    val numbersArr = arrayOf(0, 0, 3, 4)

    try {
        val x: Int = numbersArr[0]
        val z: Int = numbersArr[1] / x
        println("z  = $z")

    } catch (e: Exception) {
        println("Exception")
        println("Сообщение об исключении: " + e.message) //Сообщение об исключениях
        for(line in e.stackTrace) { //stackTrace набор строк, где было сгенерировано исключение
            println("at $line")
        }
    } finally {
        println("Program has been finished")
    }

    //Для обработки нескольких исключений можно определить разные блоки catch
    try {
        println(numbersArr[5])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Out of Bounds!")

        for (line in e.stackTrace) {
            println("at $line")
        }
    } catch (e: Exception) {
        println("Exception")
        println(e.message)
    }


    //Генерация исключения
    //Например если возраст не укладывается в диапозон.


    fun checkAge(age: Int): Int {
        if (age < 1 || age > 110) throw Exception("Invalid value $age")
        println("Age $age is valid")
        return age
    }
    //И Затем должны обработать
    try {
        checkAge(111)
    } catch (e: Exception) {
        println(e.message)
    }

    //Так же try может возвращать значения:
    val checkAge1 =  try { checkAge(5) } catch(e: Exception) { null }
    val checkAge2 =  try { checkAge(112) } catch(e: Exception) { null }
    println(checkAge1)
    println(checkAge2)

}


