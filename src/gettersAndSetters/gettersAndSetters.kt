package gettersAndSetters

//Методы доступа. Синтаксис: var name[: тип_свойства] [=инициалиация св-ва]
//[getter]if(
//[setter]

//Доступ к свойствам класса
class GetA(var name: String, var lastName: String) {

    var age: Int = 1
    set(value) {
        if (value in 1..20)
            field = value
        println(field)
    }

    val fullName: String
        get() = "$name $lastName"

}

// Использование полей для хранения значений
class GetB(val name: String) {
    private var _age = 1
    var age: Int
        set(value) {
            if(value in 1..10)
            _age = value
        }
    get() = _age

}