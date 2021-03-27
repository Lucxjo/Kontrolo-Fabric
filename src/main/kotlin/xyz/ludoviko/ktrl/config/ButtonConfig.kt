package xyz.ludoviko.ktrl.config

import io.github.redstoneparadox.paradoxconfig.config.ConfigCategory

object ButtonConfig : ConfigCategory("CustomButtons.json5") {
    var amount: Int by option(1, "amount")
    var buttons: Map<String, Map<String, String>> by option(
        mapOf(
            "0" to mapOf(
                "title" to "Creative",
                "cmd" to "/gamemode creative"
            )
        ), "buttons"
    )
}