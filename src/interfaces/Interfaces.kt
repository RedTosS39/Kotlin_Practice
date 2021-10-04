package interfaces

//Интерфейс представляет собой контракт, который должен реализовать класс.

//Интерфейс может содержать объявление свойств, функций, а так же их реализацию

interface Movable {

    var speed: Int //Объявление свойства
    fun move() // Определение функции без реализации
    fun stop() {  // Определение функции c реализацией
       println("Остановочка")
    }
}

//Реализация свойств
interface Info {

    //Первое свойство имеет ГЕТТЕР, поэтому оно имеет реализацию по умолчанию
    val model: String
        get() = "Undefined"
    // Второе свойство не меет реализации => оно является абстрактным (обязано быть реализовано в насследнике)
    val number: String

    // Реализуем данный интерфейс в классе Car
}

class Car(override var model: String, //не обязательно указывать get или set
          override var number: String,
          override var speed: Int) : Movable, Info {

    override fun move() {
        println("Машина едет со скоростью: $speed км в час")
    }
}

class Aircraft: Movable {

    override var speed: Int = 600
    override fun move() {
        println("Самолет летит со скоростью: $speed км в час")
    }

    override fun stop() {
        println("Приземление")
    }
}

// Правила переопределения
//Что если интерфейс и базовый класс будут иметь одинаковые называния методов?

open class Video() {
    open fun play() { println("Play video") }
}

interface AudioPlayable {
    fun play() { println("Play Audio") }
}

class MediaPlayer(): Video(), AudioPlayable {

    //Функцию play() Обязательно нужно переопределить
    override fun play() {
        super<Video>.play() //Явно указываем к чему относится функуция <Video>
        super<AudioPlayable>.play() //Явно указываем к чему относится функуция <AudioPlayable>
    }

}