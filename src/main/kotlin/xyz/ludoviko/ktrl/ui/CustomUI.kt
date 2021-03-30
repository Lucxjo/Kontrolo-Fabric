package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text
import xyz.ludoviko.ktrl.config.ButtonConfig

class CustomUI(val client: MinecraftClient) : LightweightGuiDescription() {
    val root = WGridPanel()
    var config = ButtonConfig

    init {
        setRootPanel(root)
        root.setSize(150, 100)
        add()
    }

    fun add() {
        if (config["button0.active"] as Boolean) addButton(
            config["button0.title"] as String,
            config["button0.command"] as String,
            0
        )
        if (config["button1.active"] as Boolean) addButton(
            config["button1.title"] as String,
            config["button1.command"] as String,
            1
        )
        if (config["button2.active"] as Boolean) addButton(
            config["button2.title"] as String,
            config["button2.command"] as String,
            2
        )
        if (config["button3.active"] as Boolean) addButton(
            config["button3.title"] as String,
            config["button3.command"] as String,
            3
        )
        if (config["button4.active"] as Boolean) addButton(
            config["button4.title"] as String,
            config["button4.command"] as String,
            4
        )
        if (config["button5.active"] as Boolean) addButton(
            config["button5.title"] as String,
            config["button5.command"] as String,
            5
        )
    }

    fun addButton(title: String, command: String, pos: Int) {
        val button = WButton(Text.of(title))
        button.setOnClick {
            client.player?.sendChatMessage(command)
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