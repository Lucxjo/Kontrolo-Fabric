package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WLabel
import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class UI(val client: MinecraftClient, type: GUIType) : LightweightGuiDescription() {
    val root = WGridPanel()

    init {
        setRootPanel(root)
        root.setSize(250, 150)
        addWeather(root)
        addTime(root, 3)
        addGamemode(root, 7)
    }

    fun addWeather(root: WGridPanel, offset: Int = 0) {
        val weatherLabel = WLabel(TranslatableText("text.ktrl.weather.label"))
        val clearButton = WButton(TranslatableText("text.ktrl.weather.clear.label"))
        val rainButton = WButton(TranslatableText("text.ktrl.weather.rain.label"))
        val thunderButton = WButton(TranslatableText("text.ktrl.weather.thunder.label"))

        clearButton.setOnClick {
            client.player?.sendChatMessage("/weather clear")
            client.player?.closeScreen()
        }

        rainButton.setOnClick {
            client.player?.sendChatMessage("/weather rain")
            client.player?.closeScreen()
        }

        thunderButton.setOnClick {
            client.player?.sendChatMessage("/weather thunder")
            client.player?.closeScreen()
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
        val zeroButton = WButton(TranslatableText("text.ktrl.time.zero.label"))
        val addThousand = WButton(Text.of("+ 1000"))
        val addTenThousand = WButton(Text.of("+ 10000"))
        val timeButton = WButton(TranslatableText("text.ktrl.time.button"))

        dayButton.setOnClick {
            client.player?.sendChatMessage("/time set day")
            client.player?.closeScreen()
        }

        noonButton.setOnClick {
            client.player?.sendChatMessage("/time set noon")
            client.player?.closeScreen()
        }

        nightButton.setOnClick {
            client.player?.sendChatMessage("/time set night")
            client.player?.closeScreen()
        }

        mnButton.setOnClick {
            client.player?.sendChatMessage("/time set midnight")
            client.player?.closeScreen()
        }

        zeroButton.setOnClick {
            client.player?.sendChatMessage("/time set 0")
            client.player?.closeScreen()
        }

        addThousand.setOnClick {
            client.player?.sendChatMessage("/time add 1000")
            client.player?.closeScreen()
        }

        addTenThousand.setOnClick {
            client.player?.sendChatMessage("/time add 10000")
            client.player?.closeScreen()
        }

        timeButton.setOnClick {
            client.player?.sendChatMessage("/time query gametime")
            client.player?.closeScreen()
        }

        root.add(timeLabel, 0, 1 + offset)
        root.add(dayButton, 0, 2 + offset, 4, 1)
        root.add(noonButton, 4, 2 + offset, 4, 1)
        root.add(nightButton, 8, 2 + offset, 4, 1)
        root.add(mnButton, 12, 2 + offset, 4, 1)
        root.add(zeroButton, 0, 3 + offset, 4, 1)
        root.add(addThousand, 4, 3 + offset, 4, 1)
        root.add(addTenThousand, 8, 3 + offset, 4, 1)
        root.add(timeButton, 12, 3 + offset, 4, 1)
    }

    fun addGamemode(root: WGridPanel, offset: Int = 0) {
        val gamemodeLabel = WLabel(TranslatableText("text.ktrl.gm.label"))
        val creativeButton = WButton(TranslatableText("text.ktrl.gm.creative.label"))
        val survivalButton = WButton(TranslatableText("text.ktrl.gm.survival.label"))
        val adventureButton = WButton(TranslatableText("text.ktrl.gm.adventure.label"))
        val spectatorButton = WButton(TranslatableText("text.ktrl.gm.spectator.label"))

        creativeButton.setOnClick {
            client.player?.sendChatMessage("/gamemode creative")
            client.player?.closeScreen()
        }

        survivalButton.setOnClick {
            client.player?.sendChatMessage("/gamemode survival")
            client.player?.closeScreen()
        }

        adventureButton.setOnClick {
            client.player?.sendChatMessage("/gamemode adventure")
            client.player?.closeScreen()
        }

        spectatorButton.setOnClick {
            client.player?.sendChatMessage("/gamemode spectator")
            client.player?.closeScreen()
        }

        root.add(gamemodeLabel, 0, 1 + offset)
        root.add(creativeButton, 0, 2 + offset, 4, 1)
        root.add(survivalButton, 4, 2 + offset, 4, 1)
        root.add(adventureButton, 8, 2 + offset, 4, 1)
        root.add(spectatorButton, 12, 2 + offset, 4, 1)
    }
}