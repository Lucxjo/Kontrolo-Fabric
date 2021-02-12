package xyz.ludoviko.ktrl.key

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.options.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW
import xyz.ludoviko.ktrl.ui.Screen
import xyz.ludoviko.ktrl.ui.UI


object Key {
    private val keyBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.ktrl.gui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "category.ktrl.gui"
        )
    )

    init {
        ClientTickEvents.END_CLIENT_TICK.register(
            ClientTickEvents.EndTick { client: MinecraftClient ->
                while (keyBinding.wasPressed()) {
                    client.openScreen(Screen(UI()))
                }
            }
        )
    }
}