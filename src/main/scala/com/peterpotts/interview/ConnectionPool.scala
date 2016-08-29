package com.peterpotts.interview

trait Connection {
  def write(text: String): Unit

  def close(): Unit
}

class ConnectionFactory {
  var connectionsCreated = 0

  def createConnection: Connection =
    new Connection {
      connectionsCreated += 1
      private var open = true

      def write(text: String): Unit = {
        require(open)
        println(text)
      }

      def close(): Unit = {
        open = false
      }
    }
}

class ConnectionPool(factory: ConnectionFactory) {
  private var free: List[Connection] = Nil

  private def wrap(connection: Connection): Connection =
    new Connection {
      private var open = true

      def write(text: String): Unit = {
        require(open)
        connection.write(text)
      }

      def close(): Unit = {
        open = false
        free = connection :: free
      }
    }

  def getConnection: Connection =
    free match {
      case head :: tail =>
        free = tail
        wrap(head)
      case Nil =>
        wrap(factory.createConnection)
    }
}
