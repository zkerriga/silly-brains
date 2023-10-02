package ml.brains

import ai.dragonfly.math.vector.Vec
import ml.brains.ActivationFunction

import scala.util.Random

case class Neuron[N <: Int](
  weights: Vec[N],
  bias: Double,
  activationFunction: ActivationFunction,
) {
  def stimulate(inputs: Vec[N]): Boolean =
    val weightedSum = inputs.dot(weights)
    activationFunction(weightedSum)

  override def toString(): String =
    s"Neuron(weights=${weights.show},bias=$bias,$activationFunction)"
}

object Neuron {
  def random[N <: Int](random: Random)(using ValueOf[N]): Neuron[N] =
    Neuron(
      weights = Vec.random[N](MAX = 1.0, min = 0.0, r = random),
      bias = random.between(minInclusive = 0.0, maxExclusive = 1.0),
      activationFunction = ActivationFunction.StepFunction(threshold = 1),
    )
}
