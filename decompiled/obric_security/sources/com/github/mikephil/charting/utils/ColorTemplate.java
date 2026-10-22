package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.obric.oui.utils.AnimTokens;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ColorTemplate {
    public static final int[] COLORFUL_COLORS = null;
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] JOYFUL_COLORS = null;
    public static final int[] LIBERTY_COLORS = null;
    public static final int[] MATERIAL_COLORS = null;
    public static final int[] PASTEL_COLORS = null;
    public static final int[] VORDIPLOM_COLORS = null;

    public static int colorWithAlpha(int r1, int r2) {
        return (r1 & 16777215) | ((r2 & 255) << 24);
    }

    public ColorTemplate() {
    }

    static {
        LIBERTY_COLORS = new int[]{Color.rgb(HttpStatus.SC_MULTI_STATUS, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, 130)};
        JOYFUL_COLORS = new int[]{Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)};
        PASTEL_COLORS = new int[]{Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};
        COLORFUL_COLORS = new int[]{Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, AnimTokens.OUI_ANIMATION_DURATION_SHORT_3, 31), Color.rgb(179, 100, 53)};
        VORDIPLOM_COLORS = new int[]{Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};
        MATERIAL_COLORS = new int[]{rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};
    }

    public static int rgb(String r2) {
        int r3 = (int) Long.parseLong(r2.replace("#", ""), 16);
        return Color.rgb((r3 >> 16) & 255, (r3 >> 8) & 255, (r3 >> 0) & 255);
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, 229);
    }

    public static List<Integer> createColors(Resources r4, int[] r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Integer.valueOf(r4.getColor(r5[r2])));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static List<Integer> createColors(int[] r4) {
        ArrayList r0 = new ArrayList();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Integer.valueOf(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
