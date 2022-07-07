package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text
import xyz.ludoviko.ktrl.config.ModConfig


class CustomUI(val client: MinecraftClient) : LightweightGuiDescription() {
    val root = WGridPanel()
    var config = AutoConfig.getConfigHolder<ModConfig>(ModConfig::class.java).config

    init {
        setRootPanel(root)
        root.setSize(150, 100)
        add()
    }

    fun add() {
        if (config.customGUI.b0.active) addButton(
            config.customGUI.b0.title,
            config.customGUI.b0.command,
            0
        )
        if (config.customGUI.b1.active) addButton(
            config.customGUI.b1.title,
            config.customGUI.b1.command,
            1
        )
        if (config.customGUI.b2.active) addButton(
            config.customGUI.b2.title,
            config.customGUI.b2.command,
            2
        )
        if (config.customGUI.b3.active) addButton(
            config.customGUI.b3.title,
            config.customGUI.b3.command,
            3
        )
        if (config.customGUI.b4.active) addButton(
            config.customGUI.b4.title,
            config.customGUI.b4.command,
            4
        )
        if (config.customGUI.b5.active) addButton(
            config.customGUI.b5.title,
            config.customGUI.b5.command,
            5
        )
    }

    fun addButton(title: String, command: String, pos: Int) {
        val button = WButton(Text.of(title))
        button.setOnClick {

        }
        if (pos == 0)
            root.add(button, 0, 1, 5, 1)
        if (pos == 1)
            root.add(button, 6, 1, 5, 1)
        if (pos == 2)
            root.add(button, 0, 3, 5, 1)
        if (pos == 3)
            root.add(button, 6, 3, 5, 1)
        if (pos == 4)
            root.add(button, 0, 5, 5, 1)
        if (pos == 5)
            root.add(button, 6, 5, 5, 1)
    }
}