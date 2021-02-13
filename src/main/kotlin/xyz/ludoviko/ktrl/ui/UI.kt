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
        root.setSize(150, 150)
        addWeather(root)
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
        root.add(clearButton, 0, 2, 3, 1)
        root.add(rainButton, 3, 2, 3, 1)
        root.add(thunderButton, 6, 2, 3, 1)
    }
}