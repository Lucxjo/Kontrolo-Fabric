package xyz.ludoviko.ktrl.config

import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.annotation.ConfigEntry

@Config(name = "kontrolo")
class ModConfig : ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    val main = Main()

    @ConfigEntry.Gui.CollapsibleObject
    val customGUI = CustomGUI()

    class Main {
        @ConfigEntry.Gui.CollapsibleObject
        val time = Time()

        @ConfigEntry.Gui.CollapsibleObject
        val weather = Weather()

        class Time {
            var addButton1 = 1000
            var addButton2 = 10000
        }

        class Weather {
            var delay = 1500
        }
    }

    class CustomGUI {

        @ConfigEntry.Gui.CollapsibleObject
        val b0 = button0()

        @ConfigEntry.Gui.CollapsibleObject
        val b1 = button1()

        @ConfigEntry.Gui.CollapsibleObject
        val b2 = button2()

        @ConfigEntry.Gui.CollapsibleObject
        val b3 = button3()

        @ConfigEntry.Gui.CollapsibleObject
        val b4 = button4()

        @ConfigEntry.Gui.CollapsibleObject
        val b5 = button5()

        class button0 {
            val active = false
            val title = "First button"
            val command = "/say Hello"
        }

        class button1 {
            val active = false
            val title = "Second button"
            val command = "/say Hello"
        }

        class button2 {
            val active = false
            val title = "Third button"
            val command = "/say Hello"
        }

        class button3 {
            val active = false
            val title = "Fourth button"
            val command = "/say Hello"
        }

        class button4 {
            val active = false
            val title = "Fifth button"
            val command = "/say Hello"
        }

        class button5 {
            val active = false
            val title = "Sixth button"
            val command = "/say Hello"
        }
    }
}