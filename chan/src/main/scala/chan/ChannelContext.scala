package sw33t.channel

trait ChannelContext extends QueueProvider {
  def make[T](capacity: Int = Int.MaxValue) = {
    Channel(queue[T](capacity))
  }
}
