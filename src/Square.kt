class Square(var x: Int, var y: Int, var widthHeight: Int) : Figure(0)  {

    constructor(square: Square) : this(square.x, square.y, square.widthHeight)

    override fun resize(zoom: Int) {
        if (zoom > 0)
            widthHeight *= zoom
        if (zoom < 0)
            widthHeight /= -zoom
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
        return (widthHeight*widthHeight).toFloat()
    }
}