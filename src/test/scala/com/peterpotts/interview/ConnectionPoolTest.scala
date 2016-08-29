package com.peterpotts.interview

import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

class ConnectionPoolTest extends WordSpec with Matchers with MockitoSugar {
  "A connection pool" should {
    "reuse connections" in {
      val factory = new ConnectionFactory
      val pool = new ConnectionPool(factory)
      factory.connectionsCreated shouldEqual 0
      val connection1 = pool.getConnection
      factory.connectionsCreated shouldEqual 1
      connection1.write("test1")
      connection1.close()
      val connection2 = pool.getConnection
      factory.connectionsCreated shouldEqual 1
      intercept[IllegalArgumentException](connection1.write("test2"))
      connection2.write("test3")
      val connection3 = pool.getConnection
      factory.connectionsCreated shouldEqual 2
      connection2.close()
      connection3.close()
    }
  }
}

