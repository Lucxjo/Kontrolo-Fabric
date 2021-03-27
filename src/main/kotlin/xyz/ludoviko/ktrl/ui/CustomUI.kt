package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WText
import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text
import xyz.ludoviko.ktrl.config.ButtonConfig

class CustomUI(val client: MinecraftClient) : LightweightGuiDescription() {
    val root = WGridPanel()
    var config = ButtonConfig

    init {
        setRootPanel(root)
        root.setSize(150, 150)
        add()
    }

    fun add() {
        if (config.amount != 0) {
            for (i in 0 until config.amount) {
                if (config.buttons[i.toString()]?.isNotEmpty() == true) {
                    val button = config.buttons[i.toString()]
                    addButton(button?.get("title")!!, button.get("cmd")!!)
                }
            }
        } else {
            root.add(WText(Text.of("No custom buttons!")), 0, 2)
        }
    }

    fun addButton(title: String, command: String) {
        val button = WButton(Text.of(title))
        button.setOnClick {
            client.player?.sendChatMessage(command)
        }
        root.add(button, 0, 1)
    }
}