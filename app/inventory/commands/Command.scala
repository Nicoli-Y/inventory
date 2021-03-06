package inventory.commands

import java.util.UUID

import inventory.events.Event

import scala.util.Try

sealed trait Command

case class SellItem(
  quantity: Int
) extends Command

case class RestockItem(
  quantity: Int
) extends Command

case class CreateItem(
  name: String,
  description: Option[String],
  quantity: Int,
  reorderPoint: Option[Int],
  price: BigDecimal,
  packaging: Option[String]
) extends Command

case class ArchiveItem(
) extends Command

trait CommandHandler[T] {
  def apply(command: Command)(entity: Option[T]): Try[Event]
}