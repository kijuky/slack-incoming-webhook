package io.github.kijuky.slack.incoming_webhook.prefs

import io.github.kijuky.slack.incoming_webhook.prefs.key._

object Preferences {
  def userNodeForPackage(clazz: Class[_]): Preferences = {
    new Preferences(java.util.prefs.Preferences.userNodeForPackage(clazz))
  }
}

class Preferences(prefs: java.util.prefs.Preferences) {
  def put(key: PreferenceKey, value: String): Option[String] = {
    val previous = get(key)
    prefs.put(key.value, value)
    prefs.flush()
    previous
  }

  def get(key: PreferenceKey): Option[String] = {
    val defaultValue = s"${System.currentTimeMillis()}"
    val value = prefs.get(key.value, defaultValue)
    Option.when(value != defaultValue)(value)
  }
}
