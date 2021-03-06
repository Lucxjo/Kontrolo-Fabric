package xyz.ludoviko.ktrl.config

import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.annotation.ConfigEntry

@Config(name = "ktrl")
class ModConfig : ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    val timeSettings = Time()

    @ConfigEntry.Gui.CollapsibleObject
    val weatherSettings = Weather()

    inner class Time {
        var addButton1 = 1000
        var addButton2 = 10000
    }

    inner class Weather {
        var weatherDelay = 1500
    }
}