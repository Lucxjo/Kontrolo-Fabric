package xyz.ludoviko.ktrl.config

import io.github.cottonmc.cotton.gui.client.CottonClientScreen
import io.github.prospector.modmenu.api.ModMenuApi
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.gui.screen.Screen
import xyz.ludoviko.ktrl.ui.ConfigScreen
import java.util.function.Function

@Environment(EnvType.CLIENT)
class ModMenuIntegration : ModMenuApi {
    override fun getConfigScreenFactory(): Function<Screen, Screen> = Function { previous ->
        val description = ConfigScreen(previous)
        object : CottonClientScreen(description) {
            override fun onClose() {
                description.close(previous)
            }
        }
    }
}