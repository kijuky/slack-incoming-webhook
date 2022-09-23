# Slack incoming webhook

[Slack Incoming-Webhook](https://api.slack.com/messaging/webhooks) のCLIクライアントです。

## インストール

```shell
brew tap kijuky/tools
brew install slack-incoming-webhook
```

## 使い方

[Slack Incoming-Webhook を追加](https://slack.com/intl/ja-jp/help/articles/115005265063) して Webhook URL を発行します。

```shell
slack-incoming-webhook --url $SLACK_WEBHOOK_URL message
```

アクセスが成功した場合、[Preferences](https://docs.oracle.com/en/java/javase/19/core/preferences-api1.html) にurlをキャッシュするため、以降はurlを省略できます。

```shell
slack-incoming-webhook message2
```
