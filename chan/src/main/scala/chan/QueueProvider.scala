package sw33t.channel

import java.util.concurrent.LinkedBlockingQueue

trait QueueProvider {
  def queue[T](capacity: Int = Int.MaxValue): Queue[T] = {
    val c = capacity
    new Queue[T] {
      private val q = new LinkedBlockingQueue[T](capacity)
      def apply(item: T) = {
	q.offer(item)
      }

      def capacity = c
 
      def apply(): T = {
        q.take
      }
    }
  }
}
