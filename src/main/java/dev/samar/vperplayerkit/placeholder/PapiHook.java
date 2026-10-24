package dev.samar.vperplayerkit.placeholder;

import dev.samar.vperplayerkit.VPerPlayerKit;

/** Kept separate so PlaceholderAPI classes are only loaded when the plugin is installed. */
public final class PapiHook {
    private PapiHook() {}

    public static void register(VPerPlayerKit plugin) {
        new VPerPlayerKitExpansion(plugin).register();
    }
}
