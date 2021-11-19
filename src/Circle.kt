import kotlin.math.PI

class Circle(var x: Int, var y: Int, var radius: Int) : Figure(0) {

    constructor(circle: Circle) : this(circle.x, circle.y, circle.radius)

    override fun resize(zoom: Int) {
        if (zoom > 0)
            radius *= zoom
        if (zoom < 0)
            radius /= -zoom
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
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float {
        return (PI * radius * radius).toFloat()
    }
}