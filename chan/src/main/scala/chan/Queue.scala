package sw33t.channel

trait Queue[T] {
  def capacity: Int
  def apply(): T
  def apply(item: T)
}
