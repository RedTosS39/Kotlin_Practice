package dataClasses
//для хранения каких то данных использую data-классы
data class DataPerson(val name: String, val age: Int) {
    //в таких классах автоматически переопределяются свойства
    //toString() возвращает строковое представление объекта
    //equals() сравнивает два объекта на равенство
    // copy() копирует данные объекта в другой объект
    // hashCode() сравнивает хэш код объекта

    override fun toString(): String {
        return "Name: $name, Age: $age"
    }

    //Что бы класс определялся как data-класс, он должен выполнять ряд условия
    //Первичный конструктор должен иметь как минимум один параметр
    //параметры ложны предваряться ключевыми словами var/val (рекоментдуется val)
    //класс не должен определяться с модификаторами open, abstract, sealed, inner
}