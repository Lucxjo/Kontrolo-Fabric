package xyz.ludoviko.ktrl.config

import io.github.prospector.modmenu.api.ConfigScreenFactory
import io.github.prospector.modmenu.api.ModMenuApi
import me.shedaniel.autoconfig.AutoConfig
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.client.gui.screen.Screen


@Environment(EnvType.CLIENT)
internal class ModMenuIntegration : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return if (FabricLoader.getInstance().isModLoaded("cloth-config2")) {
            ConfigScreenFactory { parent: Screen? ->
                AutoConfig.getConfigScreen(
                    ModConfig::class.java, parent
                ).get()
            }
        } else super.getModConfigScreenFactory()
    }
}