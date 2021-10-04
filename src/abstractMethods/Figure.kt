package abstractMethods

import kotlin.math.abs

abstract class Figure {

    abstract fun perimetr(): Float //Метод получения периметра
    abstract fun area() : Float //Метод получения площади
    abstract  fun getResult()
}

//Производные класс прямоугольника
class Rectangle(var width: Float, var height: Float): Figure() {

    //Переопределение получения периметра
    override fun perimetr(): Float {
        return width * 2 +  height * 2;
    }

    //Переопределение получения площади
    override fun area(): Float {
        return width * height;
    }

    override fun getResult() {
        println(perimetr())
        println(area())
    }
}