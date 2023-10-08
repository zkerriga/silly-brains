package example

import example.Line as MyLine

import org.nspl.*
import org.nspl.canvasrenderer.*
import scala.util.Random.nextDouble
import org.scalajs.dom.*

object Main {
  def draw(node: Node) = {
    val someData =
      0 until 100 map (_ => nextDouble() -> nextDouble())

    val plot = xyplot(someData)(
      par
        .withMain(MyLine.hello)
        .withXLab("x axis label")
        .withYLab("y axis label")
    )

    val (canvas, _) = render(plot, width = 600, height = 600)

    node.appendChild(canvas)
  }

  def main(args: Array[String]): Unit = {
    draw(document.body)
  }
}
