package ml.brains

trait ActivationFunction {
  def apply(value: Double): Boolean
}

object ActivationFunction {
  case class StepFunction(threshold: Double) extends ActivationFunction {
    def apply(value: Double): Boolean = value >= threshold
  }
}
