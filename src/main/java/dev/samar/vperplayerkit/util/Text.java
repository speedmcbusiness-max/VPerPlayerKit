package dev.samar.vperplayerkit.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

public final class Text {
    private static final MiniMessage MM = MiniMessage.miniMessage();

    private Text() {}

    /** MiniMessage without the default italic that item names get. */
    public static Component item(String raw) {
        return MM.deserialize(raw).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }

    public static Component mm(String raw) {
        return MM.deserialize(raw);
    }

    public static String replace(String raw, String... kv) {
        for (int i = 0; i + 1 < kv.length; i += 2) {
            raw = raw.replace(kv[i], kv[i + 1]);
        }
        return raw;
    }

    /** 90 seconds -> "1m", 5 hours -> "5h", 2 days -> "2d". */
    public static String agoShort(long millis) {
        long s = Math.max(0, millis / 1000);
        if (s < 60) return s + "s";
        if (s < 3600) return (s / 60) + "m";
        if (s < 86400) return (s / 3600) + "h";
        return (s / 86400) + "d";
    }

    /** "stripe_bottom" -> "Stripe Bottom" */
    public static String pretty(String key) {
        StringBuilder sb = new StringBuilder();
        for (String part : key.toLowerCase().split("_")) {
            if (part.isEmpty()) continue;
            if (sb.length() > 0) sb.append(' ');
            sb.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return sb.toString();
    }
}
