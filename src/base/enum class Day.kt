package base

// Перечисления.
// Внутри перечислений применяются константы. Конструкторы
enum class Day() {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

// Внутри перечислений применяются Конструкторы

enum class Names(private val value: Int) {
    DIMA(0),
    SVETA(1),
    LENA(2),
    //Если перечисление содержит и свойства и функуции, то константы должны быть определенеы ';':
    GALYA(3);

    fun getDuration(names: Names): Int{
        return value - names.value;
    }

    //вспомогательные функуции:
    //valueOf(value: String) возвращает объекты перечисления по названию константы
    //values(): Возвращает массив констант текущего перечисления

    fun getValues() {
        for(name in Names.values()) {
            println(name)
        }

        println("valueOf(value: String) возвращает объекты перечисления по названию константы: + ${Names.valueOf("GALYA")}")
    }
}



//Анонимные классы и реализация интрейфейсов

// Так же классы перечислений могут применять интерейсы:
interface IPrintable {
    fun printName()
}

enum class DayTime : IPrintable{


    DAY{
        override val startHour: Int = 6
        override val endHour: Int = 22
        override fun printName() {
                println("День")
        }
    },
    NIGHT{
        override val endHour: Int = 6
        override val startHour: Int = 22
        override fun printName() {
            println("Ночь")
        }
    };

    abstract override fun printName()
    abstract val startHour: Int
    abstract val endHour: Int
}

//Хранение состояния

enum class Operation {
    ADD, SUBTRACT, MULTIPLY
}

fun operate(n1: Int, n2: Int, op: Operation): Int {
    return when(op) {
        Operation.ADD -> n1 + n2
        Operation.MULTIPLY -> n1 * n2
        Operation.SUBTRACT -> n1 - n2
    }
}