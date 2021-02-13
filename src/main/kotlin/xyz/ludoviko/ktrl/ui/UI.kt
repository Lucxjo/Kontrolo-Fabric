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
        root.setSize(250, 150)
        addWeather(root)
        addTime(root, 3)
        addGamemode(root, 6)
    }

    fun addWeather(root: WGridPanel, offset: Int = 0) {
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

        root.add(weatherLabel, 0, 1 + offset)
        root.add(clearButton, 0, 2 + offset, 5, 1)
        root.add(rainButton, 5, 2 + offset, 5, 1)
        root.add(thunderButton, 10, 2 + offset, 5, 1)
    }

    fun addTime(root: WGridPanel, offset: Int = 0) {
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

        root.add(timeLabel, 0, 1 + offset)
        root.add(dayButton, 0, 2 + offset, 4, 1)
        root.add(noonButton, 4, 2 + offset, 4, 1)
        root.add(nightButton, 8, 2 + offset, 4, 1)
        root.add(mnButton, 12, 2 + offset, 4, 1)
    }

    fun addGamemode(root: WGridPanel, offset: Int = 0) {
        val gamemodeLabel = WLabel(TranslatableText("text.ktrl.gm.label"))
        val creativeButton = WButton(TranslatableText("text.ktrl.gm.creative.label"))
        val survivalButton = WButton(TranslatableText("text.ktrl.gm.survival.label"))
        val adventureButton = WButton(TranslatableText("text.ktrl.gm.adventure.label"))
        val spectatorButton = WButton(TranslatableText("text.ktrl.gm.spectator.label"))

        creativeButton.setOnClick {
            client.player?.sendChatMessage("/gamemode creative")
        }

        survivalButton.setOnClick {
            client.player?.sendChatMessage("/gamemode survival")
        }

        adventureButton.setOnClick {
            client.player?.sendChatMessage("/gamemode adventure")
        }

        spectatorButton.setOnClick {
            client.player?.sendChatMessage("/gamemode spectator")
        }

        root.add(gamemodeLabel, 0, 1 + offset)
        root.add(creativeButton, 0, 2 + offset, 4, 1)
        root.add(survivalButton, 4, 2 + offset, 4, 1)
        root.add(adventureButton, 8, 2 + offset, 4, 1)
        root.add(spectatorButton, 12, 2 + offset, 4, 1)
    }
}