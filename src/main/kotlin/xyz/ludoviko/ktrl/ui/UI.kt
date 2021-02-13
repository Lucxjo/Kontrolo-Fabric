package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WLabel
import net.minecraft.client.MinecraftClient
import net.minecraft.text.TranslatableText

class UI(val client: MinecraftClient) : LightweightGuiDescription() {
    val root = WGridPanel()

    init {
        setRootPanel(root)
        root.setSize(200, 150)
        addWeather(root)
        addTime(root)
    }

    fun addWeather(root: WGridPanel) {
        val weatherLabel = WLabel(TranslatableText("text.ktrl.weather.label"))
        val clearButton = WButton(TranslatableText("text.ktrl.weather.clear.label"))
        val rainButton = WButton(TranslatableText("text.ktrl.weather.rain.label"))
        val thunderButton = WButton(TranslatableText("text.ktrl.weather.thunder.label"))

        clearButton.setOnClick {
            client.player?.sendChatMessage("/weather clear")
        }

        rainButton.setOnClick {
            client.player?.sendChatMessage("/weather rain")
        }

        thunderButton.setOnClick {
            client.player?.sendChatMessage("/weather thunder")
        }

        root.add(weatherLabel, 0, 1)
        root.add(clearButton, 0, 2, 4, 1)
        root.add(rainButton, 4, 2, 4, 1)
        root.add(thunderButton, 8, 2, 4, 1)
    }

    fun addTime(root: WGridPanel) {
        val timeLabel = WLabel(TranslatableText("text.ktrl.time.label"))
        val dayButton = WButton(TranslatableText("text.ktrl.time.day.label"))
        val noonButton = WButton(TranslatableText("text.ktrl.time.noon.label"))
        val nightButton = WButton(TranslatableText("text.ktrl.time.night.label"))
        val mnButton = WButton(TranslatableText("text.ktrl.time.mn.label"))

        dayButton.setOnClick {
            client.player?.sendChatMessage("/time set day")
        }

        noonButton.setOnClick {
            client.player?.sendChatMessage("/time set noon")
        }

        nightButton.setOnClick {
            client.player?.sendChatMessage("/time set night")
        }

        mnButton.setOnClick {
            client.player?.sendChatMessage("/time set midnight")
        }

        root.add(timeLabel, 0, 4)
        root.add(dayButton, 0, 5, 3, 1)
        root.add(noonButton, 3, 5, 3, 1)
        root.add(nightButton, 6, 5, 3, 1)
        root.add(mnButton, 9, 5, 3, 1)
    }
}