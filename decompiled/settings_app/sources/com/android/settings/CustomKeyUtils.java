package com.android.settings;

import android.content.Context;
import java.util.Objects;
import obric.api.KeyEventSmt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CustomKeyUtils {
    public static final String ALT_KEY_LABEL = "Alt";
    private static final String APOSTROPHE_LABEL = "'";
    private static final String APOSTROPHE_VALUE = "APOSTROPHE";
    private static final String BACKSLASH_LABEL = "\\";
    private static final String BACKSLASH_VALUE = "BACKSLASH";
    private static final char[] CHARS = null;
    public static final String CMD_KEY_LABEL = "Cmd";
    private static final String COMMA_LABEL = ",";
    private static final String COMMA_VALUE = "COMMA";
    public static final String CTRL_KEY_LABEL = "Ctrl";
    private static final String DPAD_DOWN_LABEL = "↓";
    private static final String DPAD_DOWN_VALUE = "DPAD_DOWN";
    private static final String DPAD_LEFT_LABEL = "←";
    private static final String DPAD_LEFT_VALUE = "DPAD_LEFT";
    private static final String DPAD_RIGHT_LABEL = "→";
    private static final String DPAD_RIGHT_VALUE = "DPAD_RIGHT";
    private static final String DPAD_UP_LABEL = "↑";
    private static final String DPAD_UP_VALUE = "DPAD_UP";
    private static final String GRAVE_LABEL = "`";
    private static final String GRAVE_VALUE = "GRAVE";
    private static int KEYCODE_F13 = 0;
    private static int KEYCODE_F20 = 0;
    private static final String KEYCODE_PREFIX = "KEYCODE_";
    public static final String KEY_SEPARATE_FOR_SHOW = "+";
    public static final String KEY_VALUE_SEPARATE_PARSE = "\\+";
    private static final String META_ALT = "META_ALT";
    private static final String META_ALT_ON = "META_ALT_ON";
    private static final String META_CTRL = "META_CTRL";
    private static final String META_CTRL_ON = "META_CTRL_ON";
    private static final String META_META = "META_META";
    private static final String META_META_ON = "META_META_ON";
    private static final String META_SHIFT = "META_SHIFT";
    private static final String META_SHIFT_ON = "META_SHIFT_ON";
    private static final String META_STATE_NONE = "0";
    private static final String META_STATE_SEPARATE_PARSE = "\\|";
    private static final String MOVE_END_LABEL = "End";
    private static final String MOVE_END_VALUE = "MOVE_END";
    private static final String MOVE_HOME_LABEL = "Home";
    private static final String MOVE_HOME_VALUE = "MOVE_HOME";
    public static final String OPTION_KEY_LABEL = "Option";
    private static final String PAGE_DOWN_LABEL = "PageDown";
    private static final String PAGE_DOWN_VALUE = "PAGE_DOWN";
    private static final String PAGE_UP_LABEL = "PageUp";
    private static final String PAGE_UP_VALUE = "PAGE_UP";
    public static final String PARSE_SEPARATE = "\\$";
    private static final String PERIOD_LABEL = ".";
    private static final String PERIOD_VALUE = "PERIOD";
    private static final String SEMICOLON_LABEL = ";";
    private static final String SEMICOLON_VALUE = "SEMICOLON";
    public static final String SHIFT_KEY_LABEL = "Shift";
    private static final String SLASH_LABEL = "/";
    private static final String SLASH_VALUE = "SLASH";
    private static final String SYSRQ_LABEL = "PrintScreen";
    private static final String SYSRQ_VALUE = "SYSRQ";
    public static final int VALUE_LENGTH_AFTER_SPLIT = 2;
    public static final String WIN_KEY_LABEL = "Win";
    private static boolean sIsMacStyle = false;

    public static boolean filterFunctionKey(int r2) {
        if (r2 != 4) goto L5;
        return true;
    L5:
        if (r2 != 3) goto L7;
        return true;
    L7:
        if (r2 != 26) goto L9;
        return true;
    L9:
        if (r2 != 24) goto L11;
        return true;
    L11:
        if (r2 != 25) goto L13;
        return true;
    L13:
        if (r2 != 220) goto L15;
        return true;
    L15:
        if (r2 != 221) goto L17;
        return true;
    L17:
        if (r2 != 187) goto L20;
        return true;
    L20:
        if (r2 < 295) goto L24;
        if (r2 > 302) goto L24;
        return true;
    L24:
        if (r2 < 304) goto L28;
        if (r2 > 307) goto L28;
        return true;
    L28:
        if (r2 < 85) goto L32;
        if (r2 > 91) goto L32;
        return true;
    L32:
        if (r2 == 313) goto L47;
        return false;
    L47:
        return true;
    }

    public static boolean isMetaKey(int r1) {
        if (r1 != 117) goto L5;
    L28:
        return true;
    L5:
        if (r1 == 118) goto L28;
        if (r1 == 113) goto L28;
        if (r1 == 114) goto L28;
        if (r1 == 57) goto L28;
        if (r1 == 58) goto L28;
        if (r1 == 59) goto L28;
        if (r1 == 60) goto L28;
        if (r1 == 115) goto L28;
        if (r1 == 143) goto L28;
        if (r1 == 116) goto L28;
        if (r1 == 63) goto L28;
        return false;
    }

    private static boolean isNotOKFKey(int r1) {
        if (r1 <= 140) goto L5;
    L7:
        return false;
    L5:
        if (r1 < 131) goto L7;
        return true;
    }

    private static boolean isSpecialNotInputKey(int r1) {
        if (r1 != 124) goto L5;
    L17:
        return true;
    L5:
        if (r1 == 112) goto L17;
        if (r1 == 143) goto L17;
        if (r1 == 115) goto L17;
        if (r1 == 116) goto L17;
        if (r1 == 61) goto L17;
        if (r1 == 0) goto L17;
        return false;
    }

    public CustomKeyUtils() {
    }

    static {
        CHARS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '.', IOUtils.DIR_SEPARATOR_UNIX, '`', '-', '=', '[', ']', '\\', ';', '\'', '(', ')', IOUtils.DIR_SEPARATOR_UNIX, '*', '+', '@', '#'};
        KEYCODE_F20 = -1;
        KEYCODE_F13 = -1;
    }

    public static void setIsMacStyle(boolean r0) {
        sIsMacStyle = r0;
    }

    private static boolean isMacStyle() {
        return sIsMacStyle;
    }

    private static boolean isFKey(int r6) {
        if (KEYCODE_F20 != (-1)) goto L6;
        KEYCODE_F20 = KeyEventSmt.KEYCODE_F20;
    L6:
        if (KEYCODE_F13 != (-1)) goto L8;
        KEYCODE_F13 = 314;
    L8:
        int r0 = KEYCODE_F20;
        if (r0 != (-1)) goto L15;
        if (r6 > 142) goto L14;
        if (r6 < 131) goto L14;
        return true;
    L14:
        return false;
    L15:
        if (r6 > 142) goto L17;
        if (r6 < 131) goto L17;
        return true;
    L17:
        if (r6 > r0) goto L22;
        if (r6 < KEYCODE_F13) goto L22;
        return true;
    L22:
        return false;
    }

    private static boolean hasNoRealMetaKey(String r1) {
        if ("0".equals(r1) == false) goto L5;
    L14:
        return true;
    L5:
        if (hasShiftMeta(r1) == false) goto L7;
    L13:
        return false;
    L7:
        if (hasAltMeta(r1) == true) goto L13;
        if (hasCmdMeta(r1) == true) goto L13;
        if (hasCtrlMeta(r1) == true) goto L13;
        goto L13
    }

    private static boolean isInvalidMeta(String r1) {
        if (r1.contains(META_SHIFT) == false) goto L5;
    L11:
        return false;
    L5:
        if (r1.contains(META_ALT) == true) goto L11;
        if (r1.contains(META_CTRL) == true) goto L11;
        if (r1.contains(META_META) == true) goto L11;
        return true;
    }

    private static boolean isOnlyShiftMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        String r3 = r6[r2];
        if (isInvalidMeta(r3) == true) goto L10;
        if (r3.contains(META_SHIFT) == true) goto L10;
        return false;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    }

    public static boolean hasShiftMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2].contains(META_SHIFT) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean isOnlyCtrlMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        String r3 = r6[r2];
        if (isInvalidMeta(r3) == true) goto L10;
        if (r3.contains(META_CTRL) == true) goto L10;
        return false;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    }

    public static boolean hasCtrlMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2].contains(META_CTRL) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean isOnlyAltMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        String r3 = r6[r2];
        if (isInvalidMeta(r3) == true) goto L10;
        if (r3.contains(META_ALT) == true) goto L10;
        return false;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    }

    public static boolean hasAltMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2].contains(META_ALT) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean isOnlyCmdMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        String r3 = r6[r2];
        if (isInvalidMeta(r3) == true) goto L10;
        if (r3.contains(META_META) == true) goto L10;
        return false;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    }

    public static boolean hasCmdMeta(String r5) {
        String[] r6 = r5.split(META_STATE_SEPARATE_PARSE);
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2].contains(META_META) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isValidChar(char r6) {
        char[] r0 = CHARS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (Objects.equals(Character.valueOf(r0[r3]), Character.valueOf(r6)) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean shouldNotInput(int r3, String r4) {
        if (isFKey(r3) == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (isFKey(r3) == true) goto L14;
        if (isOnlyShiftMeta(r4) == false) goto L14;
        r0 = true;
    L14:
        if (isSpecialNotInputKey(r3) == false) goto L17;
        return true;
    L17:
        return r0;
    L5:
        if (hasNoRealMetaKey(r4) == false) goto L7;
        r0 = true;
        goto L9
    }

    public static boolean shouldHandByFw(boolean r3, int r4, String r5) {
        if (r3 == false) goto L10;
        if (r4 != 51) goto L9;
        if (isOnlyCmdMeta(r5) == false) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r4 != 51) goto L15;
        if (isOnlyCtrlMeta(r5) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean onlyHasAltAndCmdMeta(String r8) {
        String[] r9 = r8.split(META_STATE_SEPARATE_PARSE);
        int r0 = r9.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r2 >= r0) goto L14;
        String r6 = r9[r2];
        if (r6.contains(META_ALT) == false) goto L8;
        r3 = r3 + 1;
    L8:
        if (r6.contains(META_META) == false) goto L11;
        r4 = r4 + 1;
    L11:
        if (isInvalidMeta(r6) == false) goto L13;
        r5 = r5 + 1;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        if (r3 <= 0) goto L23;
        if (r4 > 0) goto L17;
        return false;
    L17:
        if (((r3 + r4) + r5) != r9.length) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    }

    public static boolean shouldNotOK(int r1, String r2, boolean r3) {
        if (r3 == false) goto L10;
        if (r1 != 36) goto L15;
        if (onlyHasAltAndCmdMeta(r2) == false) goto L15;
        return true;
    L15:
        if (isNotOKFKey(r1) == false) goto L20;
        if (hasNoRealMetaKey(r2) == false) goto L20;
        return true;
    L20:
        return isCommonNotOKKey(r1, r2);
    L10:
        if (r1 != 34) goto L15;
        if (isOnlyCmdMeta(r2) == false) goto L15;
        return true;
    }

    private static boolean isCommonNotOKKey(int r3, String r4) {
        if (r3 != 62) goto L5;
    L30:
        boolean r5 = true;
    L32:
        if (isOnlyAltMeta(r4) == false) goto L34;
    L39:
        boolean r6 = true;
    L40:
        if (r5 == false) goto L44;
        if (r6 == true) goto L43;
        return false;
    L43:
        return true;
    L44:
        return false;
    L34:
        if (isOnlyCmdMeta(r4) == true) goto L39;
        if (isOnlyCtrlMeta(r4) == true) goto L39;
        r6 = false;
        goto L40
    L5:
        if (r3 == 122) goto L30;
        if (r3 == 123) goto L30;
        if (r3 == 92) goto L30;
        if (r3 == 93) goto L30;
        if (r3 == 19) goto L30;
        if (r3 == 20) goto L30;
        if (r3 == 21) goto L30;
        if (r3 == 22) goto L30;
        if (r3 == 70) goto L30;
        if (r3 == 69) goto L30;
        if (r3 == 71) goto L30;
        if (r3 == 72) goto L30;
        r5 = false;
        goto L32
    }

    public static String parseKeyToLabel(String r1) {
        if (r1.startsWith(KEYCODE_PREFIX) == false) goto L7;
        return parseKeyStringToLabel(r1);
    L7:
        return parseMetaStringToLabel(r1);
    }

    public static String parseKeyStringToLabel(String r1) {
        String r2 = r1.substring(r1.indexOf("_") + 1);
        if (MOVE_HOME_VALUE.equalsIgnoreCase(r2) == false) goto L6;
        return MOVE_HOME_LABEL;
    L6:
        if (MOVE_END_VALUE.equalsIgnoreCase(r2) == false) goto L9;
        return MOVE_END_LABEL;
    L9:
        if (PAGE_UP_VALUE.equalsIgnoreCase(r2) == false) goto L12;
        return PAGE_UP_LABEL;
    L12:
        if (PAGE_DOWN_VALUE.equalsIgnoreCase(r2) == false) goto L15;
        return PAGE_DOWN_LABEL;
    L15:
        if (DPAD_UP_VALUE.equalsIgnoreCase(r2) == false) goto L18;
        return DPAD_UP_LABEL;
    L18:
        if (DPAD_DOWN_VALUE.equalsIgnoreCase(r2) == false) goto L21;
        return DPAD_DOWN_LABEL;
    L21:
        if (DPAD_LEFT_VALUE.equalsIgnoreCase(r2) == false) goto L24;
        return DPAD_LEFT_LABEL;
    L24:
        if (DPAD_RIGHT_VALUE.equalsIgnoreCase(r2) == false) goto L27;
        return DPAD_RIGHT_LABEL;
    L27:
        if (SYSRQ_VALUE.equalsIgnoreCase(r2) == false) goto L38;
        return SYSRQ_LABEL;
    L38:
        return r2;
    }

    private static String parseLabelToKeyString(String r3) {
        if (MOVE_HOME_LABEL.equalsIgnoreCase(r3) == false) goto L6;
        r3 = MOVE_HOME_VALUE;
    L54:
        return KEYCODE_PREFIX + r3;
    L6:
        if (MOVE_END_LABEL.equalsIgnoreCase(r3) == false) goto L9;
        r3 = MOVE_END_VALUE;
        goto L54
    L9:
        if (PAGE_UP_LABEL.equalsIgnoreCase(r3) == false) goto L12;
        r3 = PAGE_UP_VALUE;
        goto L54
    L12:
        if (PAGE_DOWN_LABEL.equalsIgnoreCase(r3) == false) goto L15;
        r3 = PAGE_DOWN_VALUE;
        goto L54
    L15:
        if (DPAD_UP_LABEL.equalsIgnoreCase(r3) == false) goto L17;
        r3 = DPAD_UP_VALUE;
        goto L54
    L17:
        String r0 = DPAD_DOWN_VALUE;
        if (DPAD_DOWN_VALUE.equalsIgnoreCase(r3) == false) goto L21;
    L19:
        r3 = r0;
        goto L54
    L21:
        if (DPAD_LEFT_LABEL.equalsIgnoreCase(r3) == false) goto L24;
        r3 = DPAD_LEFT_VALUE;
        goto L54
    L24:
        if (DPAD_RIGHT_LABEL.equalsIgnoreCase(r3) == false) goto L27;
        r3 = DPAD_RIGHT_VALUE;
        goto L54
    L27:
        if (SYSRQ_LABEL.equalsIgnoreCase(r3) == false) goto L30;
        r3 = SYSRQ_VALUE;
        goto L54
    L30:
        if (COMMA_LABEL.equalsIgnoreCase(r3) == false) goto L33;
        r3 = COMMA_VALUE;
        goto L54
    L33:
        if (".".equalsIgnoreCase(r3) == false) goto L36;
    L34:
        r3 = PERIOD_VALUE;
        goto L54
    L36:
        if (".".equalsIgnoreCase(r3) == true) goto L34;
        if ("/".equalsIgnoreCase(r3) == false) goto L42;
        r3 = SLASH_VALUE;
        goto L54
    L42:
        if (GRAVE_LABEL.equalsIgnoreCase(r3) == false) goto L44;
        r3 = GRAVE_VALUE;
        goto L54
    L44:
        r0 = BACKSLASH_VALUE;
        if (BACKSLASH_VALUE.equalsIgnoreCase(r3) == true) goto L19;
        r0 = SEMICOLON_VALUE;
        if (SEMICOLON_VALUE.equalsIgnoreCase(r3) == true) goto L19;
        r0 = APOSTROPHE_VALUE;
        if (APOSTROPHE_VALUE.equalsIgnoreCase(r3) == false) goto L54;
        goto L19
    }

    private static String parseMetaStringToLabel(String r1) {
        if (r1.contains(META_ALT) == false) goto L10;
        if (isMacStyle() == false) goto L7;
        return OPTION_KEY_LABEL;
    L7:
        return ALT_KEY_LABEL;
    L10:
        if (r1.contains(META_SHIFT) == false) goto L14;
        return SHIFT_KEY_LABEL;
    L14:
        if (r1.contains(META_CTRL) == false) goto L18;
        return CTRL_KEY_LABEL;
    L18:
        if (r1.contains(META_META) == true) goto L20;
        return r1;
    L20:
        if (isMacStyle() == false) goto L22;
        return CMD_KEY_LABEL;
    L22:
        return WIN_KEY_LABEL;
    }

    private static String parseLabelToString(String r1) {
        if (r1.equals(ALT_KEY_LABEL) == false) goto L5;
        return META_ALT_ON;
    L5:
        if (r1.equals(OPTION_KEY_LABEL) == false) goto L8;
        return META_ALT_ON;
    L8:
        if (r1.equals(SHIFT_KEY_LABEL) == false) goto L12;
        return META_SHIFT_ON;
    L12:
        if (r1.equals(CTRL_KEY_LABEL) == false) goto L16;
        return META_CTRL_ON;
    L16:
        if (r1.equals(CMD_KEY_LABEL) == false) goto L18;
        return META_META_ON;
    L18:
        if (r1.equals(WIN_KEY_LABEL) == false) goto L21;
        return META_META_ON;
    L21:
        return parseLabelToKeyString(r1);
    }

    public static String parseLabelToKeyValue(Context r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        if (r3.equals(r2.getString(R.string.key_none)) == false) goto L5;
        r0.append("NONE");
    L13:
        return r0.toString();
    L5:
        String[] r4 = r3.split(KEY_VALUE_SEPARATE_PARSE);
        int r5 = 0;
    L7:
        if (r5 >= r4.length) goto L13;
        r0.append(parseLabelToString(r4[r5]));
        if (r5 == (r4.length - 1)) goto L11;
        r0.append(KEY_SEPARATE_FOR_SHOW);
    L11:
        r5 = r5 + 1;
        goto L7
    }
}
