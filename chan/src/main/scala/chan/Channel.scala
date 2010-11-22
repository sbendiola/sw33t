package sw33t.channel

object Channel extends ChannelContext

case class Channel[T](queue: Queue[T]) {
  def capacity = queue.capacity

  def apply(item: T) = queue(item)
  def apply() = queue()
}
