package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WPlainPanel
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.Screen

class ConfigScreen(previous: Screen) : LightweightGuiDescription() {

    init {
        val root = WPlainPanel()
        setRootPanel(root)
    }

    fun close(previous: Screen) {
        MinecraftClient.getInstance().openScreen(previous)
    }
}