package queue

import org.junit.{Assert, Test}

class QueueTestSuite {
  @Test def `get and put cases`: Unit = {
    val q = new Queue(3)
    try{
      q.deQueue
      Assert.fail()
    } catch {
      case e: Error => ()
    }

    Assert.assertTrue(q.enQueue("first"))
    Assert.assertEquals("first", q.deQueue)

    Assert.assertTrue(q.enQueue("a"))
    Assert.assertTrue(q.enQueue("b"))
    Assert.assertTrue(q.enQueue("c"))
    Assert.assertFalse(q.enQueue("d"))
    Assert.assertEquals("a", q.deQueue)
    Assert.assertTrue(q.enQueue("d"))
    Assert.assertEquals("b", q.deQueue)
    Assert.assertEquals("c", q.deQueue)
    Assert.assertEquals("d", q.deQueue)
  }

  @Test def `get and put cases for a reverse queue`: Unit = {
    val q = new ReverseQueue(3)
    try{
      q.deQueue
      Assert.fail()
    } catch {
      case e: Error => ()
    }

    Assert.assertTrue(q.enQueue("ab"))
    Assert.assertEquals("ba", q.deQueue)

    Assert.assertTrue(q.enQueue("ab"))
    Assert.assertTrue(q.enQueue("cd"))
    Assert.assertTrue(q.enQueue("ef"))
    Assert.assertFalse(q.enQueue("gh"))
    Assert.assertEquals("ba", q.deQueue)
    Assert.assertTrue(q.enQueue("gh"))
    Assert.assertEquals("dc", q.deQueue)
    Assert.assertEquals("fe", q.deQueue)
    Assert.assertEquals("hg", q.deQueue)
  }

  @Test def `get and put cases on a generic queue of Strings`: Unit = {
    val q = new GenericQueue[String](3)
    try{
      q.deQueue
      Assert.fail()
    } catch {
      case e: Error => ()
    }

    Assert.assertTrue(q.enQueue("first"))
    Assert.assertEquals("first", q.deQueue)

    Assert.assertTrue(q.enQueue("a"))
    Assert.assertTrue(q.enQueue("b"))
    Assert.assertTrue(q.enQueue("c"))
    Assert.assertFalse(q.enQueue("d"))
    Assert.assertEquals("a", q.deQueue)
    Assert.assertTrue(q.enQueue("d"))
    Assert.assertEquals("b", q.deQueue)
    Assert.assertEquals("c", q.deQueue)
    Assert.assertEquals("d", q.deQueue)
  }

  @Test def `get and put cases on a generic queue of Ints`: Unit = {
    val q = new GenericQueue[Int](3)
    try {
      q.deQueue
      Assert.fail()
    } catch {
      case e: Error => ()
    }

    Assert.assertTrue(q.enQueue(1))
    Assert.assertEquals(1, q.deQueue)

    Assert.assertTrue(q.enQueue(1))
    Assert.assertTrue(q.enQueue(2))
    Assert.assertTrue(q.enQueue(3))
    Assert.assertFalse(q.enQueue(4))
    Assert.assertEquals(1, q.deQueue)
    Assert.assertTrue(q.enQueue(4))
    Assert.assertEquals(2, q.deQueue)
    Assert.assertEquals(3, q.deQueue)
    Assert.assertEquals(4, q.deQueue)
  }
}
