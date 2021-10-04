package delegats

/*  Пример перенаправления функций одного класса другому
interface Base {
    fun someBase()
}

class BaseImpl() : Base {

    override fun someBase() {

    }
}

class Derived(someBase: Base) : Base by someBase

*/

interface Messenger {
    fun send(message: String)
}

class InstantMessenger(val programName: String) : Messenger {

    override fun send(message: String) = println("$programName Send message: $message")
}

interface PhotoDevice {
    fun takePhoto()
}

class PhotoCamera : PhotoDevice {
    override fun takePhoto() = println("Take a photo")

}

class SmartPhone(val name: String, m: Messenger, p: PhotoDevice) : Messenger by m, PhotoDevice by p

fun getDelegate() {

    val canon = PhotoCamera()
    val telegram = InstantMessenger("Telegram")
    val smartPhone = SmartPhone("IPhone", telegram, canon)

    smartPhone.send("Hello Kotlin")
    smartPhone.takePhoto()
}

//Класс может переопределить часть функций интерфейса, в этом случае выполнение этих функций не делегируется например

interface MessengerA {
    fun sendTextMessage()
    fun sendVideMessage()
    val programName: String
}

class InstMessenger(override val programName: String) : MessengerA {

    override fun sendTextMessage() = println("$programName sent text message")
    override fun sendVideMessage() = println("$programName sent video message")
}

class SmartPhoneA(val name: String, m: MessengerA) : MessengerA by m {

    override fun sendTextMessage() = println("$name has been send sms")
}

fun getMessageA() {
    val telegramA = InstMessenger("Telegram")
    val nokia = SmartPhoneA("Nokia", telegramA)

    //тут переопредена часть функций интерфейса,поэтому часть функций не делегируется
    nokia.sendTextMessage() //Nokia has been send sms

    //А тут делегируется
    nokia.sendVideMessage() //Telegram sent video message
}

