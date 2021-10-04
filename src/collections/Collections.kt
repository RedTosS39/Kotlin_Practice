package collections

import java.util.ArrayList

//коллекции Бывают изменяемые (mutable) и не изменяемые (immutable)
fun getCollection(){

    //LIST
    val list = listOf("111", "222", "333") //Создается ArrayList (по умолчанию)
    val text = list[0]
    println(text.elementAtOrNull(4))
    println("Неизменяемый список, 0 элемент = $text")

    //добавить
    val mutList = mutableListOf("111", "222", "333")
    val arrListOf = arrayListOf("arr", "list", "of") //Изменяемый список
    arrListOf.add(0,"New Element") // Добавляем элемент по индексу
    arrListOf.addAll(mutList) //Добавляет коллекцию элементов

    for (element in arrListOf) println("arrListOf содержит: $element")


    for(element in mutList) println("Начальный изменяемый список: $element")
    //Добавляем элемент
    mutList.add("4444")
    for(element in mutList) {
        println("Изменяемый список: $element")
    }

    //Set (immutable)
    //представляет собой неупорядоченный набор  !!!уникальных!!! объектов
    //contains(element) - возвращет true если содержит element
    //isEmpty() - возвращет true, если набор пуст
    //minus(element) - возвращает новый набор, в котором отсутствует element, но не изменяет исходный набор
    //plus(element) -  возвращает новый набор, в который добавлен element, но не изменяет исходный набор

    //для создания используется setOf()
    val setImmutable = setOf("", "2234", 4, true)
    println(setImmutable.size)
    println(setImmutable.contains(true)) //true
    println(setImmutable.minus(""))
    println(setImmutable.plus("new element"))
    println(setImmutable.isEmpty()) //false
    for(n in setImmutable) print(n) //22344true


    //Изменяемая коллекция mutableSetOf()


    //LinkedHashSet - объединяет возможности хеш-таблицы и связанного списка
    // создается с помощью linkedSetOf()
    //HashSet - представляет собой хеш-таблицу. hashSetOf()

    val linkedSet: LinkedHashSet<Int> = linkedSetOf(1, 2, 3)
    val hashSet: HashSet<Int> = hashSetOf(6, 7)
    val setMutable: MutableSet<Int> = mutableSetOf(1, 4, 8, 9, 5)

    setMutable.add(5)
    setMutable.addAll(hashSet)  //добавляем набор
    println(setMutable.remove(1))
    for (n in setMutable) print(n)


    //Map (immutable)
    //Коллекция Мар представляет коллекцию объектов, где каждый элемент имеет ключ и значение
    val mapList: Map<String, Int> = mapOf("Usa" to 300, "Russia" to 145)
    println(mapList["Usa"])
    for(m in mapList) println("${m.key} to ${m.value}")

    //mutableMap()
    //linkedMapOf()
    //hashMapOf()

    val mutableMap: MutableMap<String, Int> = mutableMapOf("value1" to 1, "value2" to 2)
    mutableMap.put("value3", 3) //добавляет ключ, значение
    mutableMap.remove("value2") //удаляет значение по ключу

    for (m in mutableMap) {
        println("${m.key} ${m.value}")
    }

    val linkedMap: LinkedHashMap<Int, String>

}