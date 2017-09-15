package net.warvale.api.chat;


public class ChatUtils {

    public static String getLineSeparator(ChatColor chatColor) {
        return chatColor + "=====================================================";
    }

    public static final char HEART = '\u2764';
    public static final String HEART_WITH_COLOR = ChatColor.DARK_RED + "\u2764";

}
