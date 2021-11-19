// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Figure(0) {

    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun resize(zoom: Int) {
        if (zoom > 0)
            width *= zoom; height *= zoom
        if (zoom < 0)
            width /= -zoom; height /= -zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        x -= centerX
        y -= centerY
        x = y.also { y = x }
        when (direction){
            RotateDirection.Clockwise -> y = -y
            RotateDirection.CounterClockwise -> x = -x
        }
        x += centerX
        y += centerY
        height = width.also { width = height }
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float {
        return (width*height).toFloat()
    }
}