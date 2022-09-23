package io.github.kijuky.slack.incoming_webhook

import com.slack.api.Slack
import com.slack.api.webhook.WebhookResponse

case class Client(webhookUrl: String) {
  private val slack = Slack.getInstance()

  def send(text: String): WebhookResponse = {
    import com.slack.api.model.block.Blocks._
    import com.slack.api.model.block.composition.BlockCompositions._
    import com.slack.api.webhook.WebhookPayloads._

    slack.send(
      webhookUrl,
      payload(
        _.text(text)
          .blocks(asBlocks(section(_.text(markdownText(text)))))
      )
    )
  }
}
