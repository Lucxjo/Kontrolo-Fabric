package xyz.ludoviko.ktrl.config

import io.github.redstoneparadox.paradoxconfig.config.ConfigCategory

object ButtonConfig : ConfigCategory("CustomButtons.json5") {
    object button0 : ConfigCategory("button0", "First button in the Custom GUI") {
        val active: Boolean by option(false, "active", "Set to true to show button")
        val title: String by option("First button", "title", "Text on the button")
        val command: String by option("", "command", "Command to excecute (include /)")
    }

    object button1 : ConfigCategory("button1", "Second button in the Custom GUI") {
        val active: Boolean by option(false, "active", "Set to true to show button")
        val title: String by option("Second button", "title", "Text on the button")
        val command: String by option("", "command", "Command to excecute (include /)")
    }

    object button2 : ConfigCategory("button2", "Third button in the Custom GUI") {
        val active: Boolean by option(false, "active", "Set to true to show button")
        val title: String by option("Third button", "title", "Text on the button")
        val command: String by option("", "command", "Command to excecute (include /)")
    }

    object button3 : ConfigCategory("button3", "Fourth button in the Custom GUI") {
        val active: Boolean by option(false, "active", "Set to true to show button")
        val title: String by option("Fourth button", "title", "Text on the button")
        val command: String by option("", "command", "Command to excecute (include /)")
    }

    object button4 : ConfigCategory("button4", "Fifth button in the Custom GUI") {
        val active: Boolean by option(false, "active", "Set to true to show button")
        val title: String by option("Fifth button", "title", "Text on the button")
        val command: String by option("", "command", "Command to excecute (include /)")
    }

    object button5 : ConfigCategory("button5", "Sixth button in the Custom GUI") {
        val active: Boolean by option(false, "active", "Set to true to show button")
        val title: String by option("Sixth button", "title", "Text on the button")
        val command: String by option("", "command", "Command to excecute (include /)")
    }
}