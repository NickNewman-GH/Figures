fun main() {
    // интерфейсы удобно использовать в коллекциях
    //val figures: Array<Movable>
    //val movable: Movable = Rect(0,0,1,1)
    //movable.move(1,1)
    // переменной базового класса
    val f: Figure = Rect(0,0,1,1)
    val f2: Figure = Circle(5, 5, 10)
    val f3: Figure = Square(5, 5, 10)

    println(f.area())
    println(f2.area())
    f2.resize(-2)
    println(f2.area())
    println(f3.area())
    f3.rotate(RotateDirection.CounterClockwise, 2, 2)
}