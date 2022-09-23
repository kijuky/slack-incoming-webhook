package io.github.kijuky.slack.incoming_webhook

import io.github.kijuky.slack.incoming_webhook.prefs._
import io.github.kijuky.slack.incoming_webhook.prefs.key._

final case class Config(
  command: Command,
  message: Option[String],
  webhookUrl: Option[String]
)

object Config {
  def apply(): Config = {
    preferences(getClass) { prefs =>
      apply(
        command = Notify,
        message = None,
        webhookUrl = prefs.get(WebhookUrl)
      )
    }
  }
}

sealed trait Command
case object Notify extends Command
