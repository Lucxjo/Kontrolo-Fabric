package xyz.ludoviko.ktrl.key

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW
import xyz.ludoviko.ktrl.ui.CustomUI
import xyz.ludoviko.ktrl.ui.GUIType
import xyz.ludoviko.ktrl.ui.Screen
import xyz.ludoviko.ktrl.ui.UI


object Key {
    private val mainBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.ktrl.gui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "category.ktrl.gui"
        )
    )
    private val weatherBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.ktrl.gui.weather",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            "category.ktrl.gui"
        )
    )
    private val timeBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.ktrl.gui.time",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            "category.ktrl.gui"
        )
    )
    private val gmBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.ktrl.gui.gm",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            "category.ktrl.gui"
        )
    )

    private val cBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(
        KeyBinding(
            "key.ktrl.gui.custom",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            "category.ktrl.gui"
        )
    )

    init {
        ClientTickEvents.END_CLIENT_TICK.register(
            ClientTickEvents.EndTick { client: MinecraftClient ->
                while (mainBinding.wasPressed()) {
                    client.openScreen(Screen(UI(client, GUIType.ALL)))
                }

                while (weatherBinding.wasPressed()) {
                    client.openScreen(Screen(UI(client, GUIType.WEATHER)))
                }

                while (timeBinding.wasPressed()) {
                    client.openScreen(Screen(UI(client, GUIType.TIME)))
                }

                while (gmBinding.wasPressed()) {
                    client.openScreen(Screen(UI(client, GUIType.GM)))
                }
                while (cBinding.wasPressed()) {
                    client.openScreen(Screen(CustomUI(client)))
                }
            }
        )
    }
}