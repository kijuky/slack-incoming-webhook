package io.github.kijuky.slack.incoming_webhook.prefs.key

sealed abstract class PreferenceKey(val value: String)
case object WebhookUrl extends PreferenceKey("webhookUrl")
