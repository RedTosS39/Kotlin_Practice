package delegats

import anonymous.Person
import kotlin.reflect.KProperty

//Синтаксис  var/val name: Type by X
//X - класс - делегат.

//ДЛЯ СВОЙСТВ: val
// Делегаты свойств не могут применять интерфейсов, однако должны предоставлять функции getValue(), setValue()
// getValue() для свойств может принимать параметры:
// thisRef - тот же тип, что и свойство, к которому применяется делегат (может быть и родительский тип)
// property - должен предоставлять тот же тип KProperty<*> или его родительский тип

//ДЛЯ СВОЙСТВ: var
// setValue() для свойств может принимать параметры:
// thisRef - тот же тип, что и свойство, к которому применяется делегат (может быть и родительский тип)
// property - должен предоставлять тот же тип KProperty<*> или его родительский тип
// value - должен представлять тот же тип что и свойство или его родительский тип


fun  getPers() {
    val tom = Pers("Tom", 10)
    println("Установлено значение:" + tom.age)  //10

    tom.age = 34
    println("Установлено значение:" + tom.age)  //10

}

class Pers(val name: String, _age: Int) {

    var age: Int by LoggedDelegate(_age)
}

class LoggedDelegate(private var persAge: Int) {
    operator fun getValue(thisRef: Pers, property: KProperty<*>): Int {
        println("Запрошено свойство: ${property.name}")
        return persAge
    }

    operator fun setValue(thisRef: Pers, property: KProperty<*>, value: Int) {
        println("Устанавливаемое значение: $value")
        if(value in 1..10) {
            persAge = value
        }

    }
}
