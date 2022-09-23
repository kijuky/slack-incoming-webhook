package io.github.kijuky.slack.incoming_webhook

import io.github.kijuky.slack.incoming_webhook.prefs._
import io.github.kijuky.slack.incoming_webhook.prefs.key._

object Main extends App {
  Parser.parse(args, Config()) match {
    case Some(Config(Notify, Some(message), Some(webhookUrl))) =>
      notify(message, webhookUrl)
    case _ =>
      System.err.println("illegal arguments")
  }

  def notify(message: String, webhookUrl: String): Unit = {
    val response = Client(webhookUrl).send(message)
    (response.getCode.intValue(), response.getBody) match {
      case (200, body) =>
        preferences(getClass) { prefs =>
          prefs.put(WebhookUrl, webhookUrl)
        }

        println(body)
      case (_, error) =>
        System.err.println(error)
    }
  }
}
