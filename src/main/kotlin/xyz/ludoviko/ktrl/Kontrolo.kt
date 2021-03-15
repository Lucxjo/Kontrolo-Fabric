package xyz.ludoviko.ktrl

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import xyz.ludoviko.ktrl.key.Key


object Kontrolo : ModInitializer {
    private const val ID = "ktrl"

    fun id(name: String) = Identifier(ID, name)

    val logger = LogManager.getFormatterLogger()

    override fun onInitialize() {
        logger.info("Initialised!")
        Key
    }
}