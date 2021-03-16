package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.*
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import xyz.ludoviko.ktrl.config.ModConfig

class ConfigScreen(previous: Screen) : LightweightGuiDescription() {
    val config = ModConfig

    init {
        val root = WGridPanel()
        setRootPanel(root)

        root.setSize(200, 200)

        root.add(
            WLabel(TranslatableText("text.ktrl.title")), 0, 0
        )

        val tabbed = WTabPanel()

        val time = WGridPanel()
        with(time) {
            add(WLabel(TranslatableText("text.ktrl.time.label")), 0, 0) //Category Label
            add(WLabel(TranslatableText("text.ktrl.option.timeSettings.addButton1")), 0, 1)
            add(
                WTextField(Text.of(config["time.addButton1"].toString())).setChangedListener {
                    config["time.addButton1"] = it.toInt()
                }, 6, 1, 4, 1
            )

            add(WLabel(TranslatableText("text.ktrl.option.timeSettings.addButton2")), 0, 3)
            add(WTextField(Text.of(config["time.addButton2"].toString())).setChangedListener {
                config["time.addButton2"] = it.toInt()
            }, 6, 3, 4, 1)

            setSize(182, 100)
        }

        val weather = WGridPanel()
        with(weather) {
            add(WLabel(TranslatableText("text.ktrl.weather.label")), 0, 0) //Category Label
            add(WLabel(TranslatableText("text.ktrl.option.weatherSettings.weatherDelay")), 0, 1)
            add(WTextField(Text.of(config["weather.delay"].toString())), 6, 1, 4, 1)
        }

        tabbed.add(time) {
            it.title(TranslatableText("text.ktrl.time.label"))
        }

        tabbed.add(weather) {
            it.title(TranslatableText("text.ktrl.weather.label"))
        }

        root.add(tabbed, 0, 1)
        root.add(WButton(TranslatableText("gui.done")).apply {
            setOnClick { close(previous) }
        }, 0, 10, 11, 1)
        root.validate(this)
    }

    fun close(previous: Screen) {
        MinecraftClient.getInstance().openScreen(previous)
    }
}