import ml.brains.Neuron
import scala.util.Random
import ai.dragonfly.math.vector.Vec

def testAnd(neuron: Neuron[2]): Unit =
  val `1, 1 => 1` = neuron.stimulate(Vec(1, 1))
  val `1, 0 => 0` = neuron.stimulate(Vec(1, 0))
  val `0, 1 => 0` = neuron.stimulate(Vec(0, 1))
  val `0, 0 => 0` = neuron.stimulate(Vec(0, 0))
  println(s"1, 1 => 1, actual ${`1, 1 => 1`}, and it's ${`1, 1 => 1` == true}")
  println(s"1, 0 => 0, actual ${`1, 0 => 0`}, and it's ${`1, 0 => 0` == false}")
  println(s"0, 1 => 0, actual ${`0, 1 => 0`}, and it's ${`0, 1 => 0` == false}")
  println(s"0, 0 => 0, actual ${`0, 0 => 0`}, and it's ${`0, 0 => 0` == false}")

@main def test: Unit =
  println("Creating a neuron!")
  val rng = Random(seed = 42L)

  val neuron: Neuron[2] = Neuron.random[2](rng)

  println(neuron)

  testAnd(neuron)
