package xyz.ludoviko.ktrl.config

import io.github.redstoneparadox.paradoxconfig.config.ConfigCategory

object ModConfig : ConfigCategory("Kontrolo.json5") {

    object Time : ConfigCategory("time", "Config for time buttons") {
        var addButton1: Int by option(1000, "addButton1", "First add button (default: 1000).")

        var addButton2: Int by option(10000, "addButton2", "Second add button (default: 10000).")
    }

    object Weather : ConfigCategory("weather", "Config for weather buttons") {
        var weatherDelay: Int by option(1500, "delay", "Delay for how long a weather condition lasts (ticks).")
    }
}