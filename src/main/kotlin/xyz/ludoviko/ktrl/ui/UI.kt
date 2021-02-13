package xyz.ludoviko.ktrl.ui

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WLabel
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class UI : LightweightGuiDescription() {
    val root = WGridPanel()

    init {
        setRootPanel(root)
        root.setSize(150, 150)
        addWeather(root)
    }

    fun addWeather(root: WGridPanel) {
        val weatherLabel = WLabel(TranslatableText("text.ktrl.weather.label"))
        val clearButton = WButton(Text.of("Clear"))
        val rainButton = WButton(Text.of("Rain"))
        val thunderButton = WButton(Text.of("Thunder"))

        root.add(weatherLabel, 0, 1)
        root.add(clearButton, 0, 2, 3, 1)
    }
}