package org.miejski.recommendations.correlation

import org.scalatest.{FunSuite, Matchers}

class PearsonCorrelationTest extends FunSuite with Matchers {


  test("should properly count correlation") {

    val first = Seq(2.0, 5.0, 7.0, 1.0, 8.0).map(Option(_)).asInstanceOf[Seq[Option[Double]]]
    val second = Seq(4.0, 3.0, 6.0, 1.0, 5.0).map(Option(_))

    PearsonCorrelation.compute(first, second) shouldEqual 0.7927
  }

  test("should properly compute 2 same dataset") {
    val data = Seq(2.0, 5.0, 7.0, 1.0, 8.0).map(Option(_))
    PearsonCorrelation.compute(data, data) shouldEqual 1.0
  }

  test("should say -1 at different data") {
    val first = Seq(2.0, 0.0).map(Option(_))
    val second = Seq(-1.0, 6.0).map(Option(_))

    PearsonCorrelation.compute(first, second) shouldEqual -1.0
  }
}
