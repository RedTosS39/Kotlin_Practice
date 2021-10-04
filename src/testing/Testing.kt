package testing

class Message (val text: String) {


}

fun someTest(message: Message, phoneNumber: String) {
    println("${message.text} has been send to $phoneNumber")

}