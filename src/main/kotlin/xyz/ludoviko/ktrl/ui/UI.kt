package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WLabel
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text
import xyz.ludoviko.ktrl.Kontrolo
import xyz.ludoviko.ktrl.config.ModConfig


class UI(val client: MinecraftClient, type: GUIType) : LightweightGuiDescription() {
    val root = WGridPanel()
    var config = AutoConfig.getConfigHolder(ModConfig::class.java).config

    init {
        setRootPanel(root)


        if (type == GUIType.ALL) {
            root.setSize(320, 200)
            addWeather(root)
            addTime(root, 3)
            addGamemode(root, 7)
        } else if (type == GUIType.WEATHER) {
            root.setSize(250, 70)
            addWeather(root, size = 1)
        } else if (type == GUIType.TIME) {
            root.setSize(330, 100)
            addTime(root)
        } else if (type == GUIType.GM) {
            root.setSize(330, 80)
            addGamemode(root)
        } else {
            Kontrolo.logger.error("GUIType issue!")
        }
    }

    fun addWeather(root: WGridPanel, offset: Int = 0, size: Int = 0) {
        val weatherLabel = WLabel(Text.translatable("text.ktrl.weather.label"))
        val clearButton = WButton(Text.translatable("text.ktrl.weather.clear.label"))
        val rainButton = WButton(Text.translatable("text.ktrl.weather.rain.label"))
        val thunderButton = WButton(Text.translatable("text.ktrl.weather.thunder.label"))

        clearButton.setOnClick {
            client.player?.sendCommand("weather clear ${config.main.weather.delay}")
            client.player?.closeScreen()
        }

        rainButton.setOnClick {
            client.player?.sendCommand("weather rain ${config.main.weather.delay}")
            client.player?.closeScreen()
        }

        thunderButton.setOnClick {
            client.player?.sendCommand("weather thunder ${config.main.weather.delay}")
            client.player?.closeScreen()
        }

        root.add(weatherLabel, 1, 1 + offset)
        root.add(clearButton, 1, 2 + offset, 5 - size, 1)
        root.add(rainButton, 6 - size, 2 + offset, 5 - size, 1)
        root.add(thunderButton, if (size != 0) 11 - (size + 1) else 11, 2 + offset, 5 - size, 1)
    }

    fun addTime(root: WGridPanel, offset: Int = 0) {
        val timeLabel = WLabel(Text.translatable("text.ktrl.time.label"))
        val dayButton = WButton(Text.translatable("text.ktrl.time.day.label"))
        val noonButton = WButton(Text.translatable("text.ktrl.time.noon.label"))
        val nightButton = WButton(Text.translatable("text.ktrl.time.night.label"))
        val mnButton = WButton(Text.translatable("text.ktrl.time.mn.label"))
        val zeroButton = WButton(Text.translatable("text.ktrl.time.zero.label"))
        val addThousand = WButton(Text.of("+ ${config.main.time.addButton1}"))
        val addTenThousand = WButton(Text.of("+ ${config.main.time.addButton2}"))
        val timeButton = WButton(Text.translatable("text.ktrl.time.button"))

        dayButton.setOnClick {
            client.player?.sendCommand("time set day")
            client.player?.closeScreen()
        }

        noonButton.setOnClick {
            client.player?.sendCommand("time set noon")
            client.player?.closeScreen()
        }

        nightButton.setOnClick {
            client.player?.sendCommand("time set night")
            client.player?.closeScreen()
        }

        mnButton.setOnClick {
            client.player?.sendCommand("time set midnight")
            client.player?.closeScreen()
        }

        zeroButton.setOnClick {
            client.player?.sendCommand("time set 0")
            client.player?.closeScreen()
        }

        addThousand.setOnClick {
            client.player?.sendCommand("time add ${config.main.time.addButton1}")
            client.player?.closeScreen()
        }

        addTenThousand.setOnClick {
            client.player?.sendCommand("time add ${config.main.time.addButton2}")
            client.player?.closeScreen()
        }

        timeButton.setOnClick {
            client.player?.sendCommand("time query gametime")
            client.player?.closeScreen()
        }

        root.add(timeLabel, 1, 1 + offset)
        root.add(dayButton, 1, 2 + offset, 4, 1)
        root.add(noonButton, 5, 2 + offset, 4, 1)
        root.add(nightButton, 9, 2 + offset, 4, 1)
        root.add(mnButton, 13, 2 + offset, 4, 1)
        root.add(zeroButton, 1, 3 + offset, 4, 1)
        root.add(addThousand, 5, 3 + offset, 4, 1)
        root.add(addTenThousand, 9, 3 + offset, 4, 1)
        root.add(timeButton, 13, 3 + offset, 4, 1)
    }

    fun addGamemode(root: WGridPanel, offset: Int = 0) {
        val gamemodeLabel = WLabel(Text.translatable("text.ktrl.gm.label"))
        val creativeButton = WButton(Text.translatable("text.ktrl.gm.creative.label"))
        val survivalButton = WButton(Text.translatable("text.ktrl.gm.survival.label"))
        val adventureButton = WButton(Text.translatable("text.ktrl.gm.adventure.label"))
        val spectatorButton = WButton(Text.translatable("text.ktrl.gm.spectator.label"))

        creativeButton.setOnClick {
            client.player?.sendCommand("gamemode creative")
            client.player?.closeScreen()
        }

        survivalButton.setOnClick {
            client.player?.sendCommand("gamemode survival")
            client.player?.closeScreen()
        }

        adventureButton.setOnClick {
            client.player?.sendCommand("gamemode adventure")
            client.player?.closeScreen()
        }

        spectatorButton.setOnClick {
            client.player?.sendCommand("gamemode spectator")
            client.player?.closeScreen()
        }

        root.add(gamemodeLabel, 1, 1 + offset)
        root.add(creativeButton, 1, 2 + offset, 4, 1)
        root.add(survivalButton, 5, 2 + offset, 4, 1)
        root.add(adventureButton, 9, 2 + offset, 4, 1)
        root.add(spectatorButton, 13, 2 + offset, 4, 1)
    }
}