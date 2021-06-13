package xyz.ludoviko.ktrl

import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import xyz.ludoviko.ktrl.config.ModConfig
import xyz.ludoviko.ktrl.key.Key


object Kontrolo : ModInitializer {
    private const val ID = "ktrl"

    fun id(name: String) = Identifier(ID, name)

    val logger = LogManager.getFormatterLogger()

    override fun onInitialize() {
        logger.info("Initialised!")
        Key

        AutoConfig.register(
            ModConfig::class.java
        ) { definition: Config?, configClass: Class<ModConfig?>? ->
            JanksonConfigSerializer(
                definition,
                configClass
            )
        }
    }
}