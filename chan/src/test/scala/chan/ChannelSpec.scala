package sw33t.channel

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar

class ChannelSpec extends FlatSpec with ShouldMatchers with MockitoSugar {
  "channels" should "have the correct buffer size" in {
    Channel.make[Int](100).capacity should be (100)
  }

  "applying an item" should "add it to the queue" in {
    val q = mock[Queue[Int]]
    val c = Channel(q)
    q(1)
    verify(q).apply(1)
  }

  "applying" should "retrieve from the queue" in {
    val q = mock[Queue[Int]]
    val c = Channel(q)
    q()
    verify(q).apply()
  }

  "channel blocks receive" should "when no items published" in {
    var received = -1L
    val c = Channel.make[Int](1)
    val start = System.currentTimeMillis
    c.synchronized {
      thread {
	c.synchronized {
	  c()
	  received = System.currentTimeMillis
	  c.notify
	}
      }
      c.wa
    }
    
    received should be (-1L)
     
    
  }

  def thread(f: => Unit) = {
    val t = new Thread(new Runnable { def run = f  } ) {
    }
    t.start
  }
}
