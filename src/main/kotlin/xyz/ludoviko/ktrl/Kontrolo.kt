package xyz.ludoviko.ktrl

import de.guntram.mcmod.crowdintranslate.CrowdinTranslate
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import xyz.ludoviko.ktrl.config.ModConfig
import xyz.ludoviko.ktrl.key.Key


object Kontrolo : ModInitializer {
    private const val ID = "ktrl"

    val logger = LogManager.getFormatterLogger()

    override fun onInitialize() {
        logger.info("Initialised!")
        CrowdinTranslate.downloadTranslations("kontrolo", this.ID)
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