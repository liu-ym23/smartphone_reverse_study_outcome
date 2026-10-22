package com.android.settings;

import android.content.Context;
import android.icu.lang.UCharacter;
import androidx.core.view.PointerIconCompat;
import com.google.zxing.pdf417.PDF417Common;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.utils.AnimTokens;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenBrightnessUtils {
    private static final int[] BRIGHTNESS_MASK_ARR = null;
    private static final int[] BRIGHTNESS_MASK_DC_ARR = null;
    private static final int[] DARWIN_ALPHA_MASK = null;
    private static final int[] DARWIN_BRIGHTNESS_MASK = null;
    private static final int MIN_BRIGHTNESS = 15;

    public ScreenBrightnessUtils() {
    }

    static {
        BRIGHTNESS_MASK_ARR = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, UCharacter.UnicodeBlock.MENDE_KIKAKUI_ID, 233, UCharacter.UnicodeBlock.LATIN_EXTENDED_E_ID, UCharacter.UnicodeBlock.KHUDAWADI_ID, UCharacter.UnicodeBlock.GRANTHA_ID, UCharacter.UnicodeBlock.ELBASAN_ID, 225, 224, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.CAUCASIAN_ALBANIAN_ID, UCharacter.UnicodeBlock.BASSA_VAH_ID, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, UCharacter.UnicodeBlock.SORA_SOMPENG_ID, UCharacter.UnicodeBlock.SHARADA_ID, UCharacter.UnicodeBlock.MIAO_ID, UCharacter.UnicodeBlock.MEROITIC_HIEROGLYPHS_ID, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, 213, 212, 211, 210, 209, 209, 206, 206, 205, 204, 204, 203, 202, 201, 200, 200, 200, 199, 198, 197, 197, 196, 195, 195, 195, 194, 193, 193, 193, 192, 191, 190, 190, 189, 189, 187, 187, 186, 186, 185, 184, 184, 183, 182, 182, 181, 180, 180, 178, 178, 178, 177, 177, 176, 175, 174, 174, 173, 172, 171, 170, 169, 168, 167, 166, 166, 165, 164, 163, 162, 162, 161, 160, 159, 158, 157, 157, 156, 155, 154, 153, 152, 151, 150, 149, 148, 150, 146, 146, 145, 144, 143, 142, 142, 141, 141, 139, 138, 138, 137, 136, 135, 134, 133, 132, 131, 129, 128, 127, 127, 126, 125, 124, 123, 122, 121, 120, 119, 118, 117, 116, 115, 114, 113, 112, 111, 110, 109, 107, 106, 106, 105, 104, 103, 102, 101, 100, 99, 98, 97, 96, 95, 94, 93, 93, 92, 90, 89, 88, 88, 85, 84, 84, 83, 82, 81, 80, 79, 77, 76, 75, 74, 73, 72, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 59, 58, 57, 56, 54, 53, 52, 51, 49, 48, 47, 45, 44, 44, 43, 41, 40, 39, 38, 37, 36, 35, 34, 33, 30, 29, 28, 26, 25, 24, 22, 21, 20, 19, 17, 16, 15, 14, 13, 11, 10, 10, 9, 8, 6, 5, 4, 3, 0};
        BRIGHTNESS_MASK_DC_ARR = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, UCharacter.UnicodeBlock.SHARADA_ID, UCharacter.UnicodeBlock.SHARADA_ID, UCharacter.UnicodeBlock.MIAO_ID, UCharacter.UnicodeBlock.MIAO_ID, UCharacter.UnicodeBlock.MEROITIC_HIEROGLYPHS_ID, UCharacter.UnicodeBlock.MEROITIC_HIEROGLYPHS_ID, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, 213, 213, 213, 212, 212, 211, 211, 211, 210, 210, 210, 209, 209, 208, 208, 207, 206, 206, 205, 204, 204, 203, 203, 202, 201, 201, 200, 200, 199, 199, 198, 198, 197, 197, 196, 195, 195, 195, 194, 193, 192, 192, 191, 190, 189, 189, 188, 187, 186, 186, 186, 185, 184, 184, 183, 183, 182, 182, 181, 180, 180, 179, 179, 178, 177, 176, 175, 174, 173, 172, 172, 171, 170, 169, 168, 167, 166, 165, 165, 163, 162, 162, 161, 160, 159, 158, 158, 157, 156, 155, 154, 153, 152, 151, 151, 150, 149, 148, 148, 147, 146, 145, 144, 144, 143, 142, 142, 140, 139, 139, 138, 137, 134, 134, 133, 132, 131, 130, 128, 127, 127, 125, 124, 123, 122, 121, 121, 120, 119, 117, 117, 116, 115, 114, 113, 112, 110, 110, 108, 107, 106, 105, 105, 103, 102, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 92, 91, 90, 89, 88, 86, 85, 84, 83, 82, 81, 80, 79, 78, 76, 75, 75, 73, 72, 71, 70, 68, 67, 67, 66, 64, 64, 62, 62, 60, 59, 57, 56, 55, 53, 52, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 38, 37, 36, 35, 34, 33, 30, 29, 28, 27, 26, 26, 23, 22, 20, 19, 18, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 5, 5, 3, 0};
        DARWIN_BRIGHTNESS_MASK = new int[]{2043, 2032, 2021, 2012, 2004, 1993, 1983, 1974, 1963, 1955, 1948, 1938, 1928, 1920, 1909, ODatePickerView.YEAR_FROM, 1892, 1883, 1875, 1866, 1858, 1850, 1842, 1831, 1823, 1815, 1808, 1799, 1791, 1784, 1776, 1768, 1760, 1753, 1745, 1735, 1727, 1719, 1710, 1700, 1694, 1685, 1676, 1669, 1660, 1650, 1643, 1633, 1623, 1615, 1605, 1598, 1588, 1579, 1569, 1560, 1550, 1542, 1533, 1523, 1513, 1502, 1492, 1482, 1472, 1460, 1450, 1440, 1433, 1426, 1416, 1404, 1393, 1383, 1373, 1363, 1353, 1343, 1330, 1322, 1312, EntityType.DOUBAO_ACCOUNT, 1290, 1281, 1270, 1261, 1251, 1241, 1232, 1222, 1212, 1202, 1193, 1185, 1174, 1163, 1152, 1140, 1132, 1122, 1112, 1102, 1089, 1078, 1068, 1057, 1047, 1036, 1024, PointerIconCompat.TYPE_ALL_SCROLL, 1002, 991, 981, 972, 960, 950, 940, PDF417Common.NUMBER_OF_CODEWORDS, 919, 911, 903, 894, 883, 873, 860, 850, 840, 830, 820, 809, 797, 787, 775, 764, 753, 742, 732, 720, 708, 697, 684, 672, 658, 640, 624, 618, 616, 610, 598, 584, 574, AnimTokens.OUI_ANIMATION_DURATION_LONG_3, 545, 530, 520, 506, 492, 480, 472, 463, 452, 442, 428, 416, 404, 394, 380, 366, 356, 342, 326, 306, 292, UCharacter.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_F_ID, UCharacter.UnicodeBlock.ANATOLIAN_HIEROGLYPHS_ID, 244, UCharacter.UnicodeBlock.MANICHAEAN_ID, UCharacter.UnicodeBlock.CAUCASIAN_ALBANIAN_ID, 212, 202, 190, 180, 170, 158, 142, 130, 110, 100, 90, 70, 48, 28, 22, 10};
        DARWIN_ALPHA_MASK = new int[]{50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, UCharacter.UnicodeBlock.MEROITIC_CURSIVE_ID, UCharacter.UnicodeBlock.MEROITIC_HIEROGLYPHS_ID, UCharacter.UnicodeBlock.MIAO_ID, UCharacter.UnicodeBlock.SHARADA_ID, UCharacter.UnicodeBlock.SORA_SOMPENG_ID, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, UCharacter.UnicodeBlock.TAKRI_ID, UCharacter.UnicodeBlock.BASSA_VAH_ID, UCharacter.UnicodeBlock.CAUCASIAN_ALBANIAN_ID, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, 224, 225, UCharacter.UnicodeBlock.ELBASAN_ID, UCharacter.UnicodeBlock.GEOMETRIC_SHAPES_EXTENDED_ID, UCharacter.UnicodeBlock.GRANTHA_ID, UCharacter.UnicodeBlock.KHOJKI_ID, UCharacter.UnicodeBlock.KHUDAWADI_ID, UCharacter.UnicodeBlock.LATIN_EXTENDED_E_ID, UCharacter.UnicodeBlock.LINEAR_A_ID, 233, UCharacter.UnicodeBlock.MANICHAEAN_ID, UCharacter.UnicodeBlock.MENDE_KIKAKUI_ID, UCharacter.UnicodeBlock.MODI_ID, UCharacter.UnicodeBlock.MRO_ID, UCharacter.UnicodeBlock.MYANMAR_EXTENDED_B_ID, UCharacter.UnicodeBlock.NABATAEAN_ID, 240, UCharacter.UnicodeBlock.OLD_PERMIC_ID, UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID, 244};
        int r0 = 0;
    L3:
        int[] r1 = DARWIN_BRIGHTNESS_MASK;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r1[r0] / 8;
        r0 = r0 + 1;
        goto L3
    }

    public static int getScreenBrightness(Context r3) {
        return getAlphaForBrightnessMask(r3, android.provider.Settings.System.getInt(r3.getContentResolver(), AdaptConstants.SCREEN_BRIGHTNESS, -1));
    }

    private static int getAlphaForBrightnessMask(Context r3, int r4) {
        if (SettingsFeature.isDarwin() == false) goto L22;
        int[] r5 = DARWIN_BRIGHTNESS_MASK;
        if (r4 >= r5[r5.length - 1]) goto L8;
        int r6 = r5.length - 1;
    L20:
        return DARWIN_ALPHA_MASK[r6];
    L8:
        if (r4 <= r5[0]) goto L10;
    L9:
        r6 = 0;
        goto L20
    L10:
        int r7 = 0;
    L11:
        int[] r1 = DARWIN_BRIGHTNESS_MASK;
        if (r7 >= (r1.length - 1)) goto L9;
        if (r4 >= r1[r7]) goto L18;
        int r2 = r7 + 1;
        if (r4 < r1[r2]) goto L18;
        r6 = r2;
    L18:
        r7 = r7 + 1;
        goto L11
    L22:
        if (r4 >= 15) goto L25;
        r4 = 15;
    L25:
        if (isDcDimmingEnable(r3) == false) goto L27;
        int[] r8 = BRIGHTNESS_MASK_DC_ARR;
    L29:
        if (r4 <= (r8.length - 1)) goto L32;
        r4 = r8.length - 1;
    L32:
        return r8[r4];
    L27:
        r8 = BRIGHTNESS_MASK_ARR;
        goto L29
    }

    private static boolean isDcDimmingEnable(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "reduce_screen_strobe", -1) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
