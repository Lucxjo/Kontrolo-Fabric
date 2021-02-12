package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WLabel
import net.minecraft.text.TranslatableText

class UI : LightweightGuiDescription() {
    val root = WGridPanel()

    init {
        setRootPanel(root)
        root.setSize(150, 150)

        val weatherLabel = WLabel(TranslatableText("text.ktrl.weather.label"))
        root.add(weatherLabel, 0, 1)
    }
}