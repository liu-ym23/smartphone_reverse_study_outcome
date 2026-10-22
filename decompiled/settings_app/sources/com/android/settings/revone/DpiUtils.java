package com.android.settings.revone;

import android.content.Context;
import android.content.res.Resources;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DpiUtils {
    public DpiUtils() {
    }

    public static List<String> getDpiDisplayList(Context r7, String r8, List<String> r9) {
        ArrayList r0 = new ArrayList();
        Resources r10 = r7.getResources();
        if ("216".equals(r8) == false) goto L8;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_160)).equals(r9) == false) goto L8;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_1));
    L8:
        if ("160".equals(r8) == false) goto L13;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_160)).equals(r9) == false) goto L13;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_2));
    L13:
        if ("216".equals(r8) == false) goto L18;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_160)).equals(r9) == false) goto L18;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_3));
    L18:
        if ("240".equals(r8) == false) goto L23;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_216)).equals(r9) == false) goto L23;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_4));
    L23:
        if ("216".equals(r8) == false) goto L28;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_160_2)).equals(r9) == false) goto L28;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_5));
    L28:
        if ("240".equals(r8) == false) goto L33;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_216)).equals(r9) == false) goto L33;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_6));
    L33:
        if ("360".equals(r8) == false) goto L38;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_320)).equals(r9) == false) goto L38;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_7));
    L38:
        if ("320".equals(r8) == false) goto L43;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_276)).equals(r9) == false) goto L43;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_8));
    L43:
        if ("360".equals(r8) == false) goto L48;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_320)).equals(r9) == false) goto L48;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_9));
    L48:
        if ("216".equals(r8) == false) goto L53;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_184)).equals(r9) == false) goto L53;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_10));
    L53:
        if ("240".equals(r8) == false) goto L58;
        if (Arrays.asList(r10.getStringArray(R.array.dpi_160_3)).equals(r9) == false) goto L58;
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_10));
    L58:
        if ("360".equals(r8) == true) goto L60;
        return r0;
    L60:
        if (Arrays.asList(r10.getStringArray(R.array.dpi_276_2)).equals(r9) == true) goto L62;
        return r0;
    L62:
        return Arrays.asList(r10.getStringArray(R.array.dpi_display_5));
    }

    public static int[] findNearestIndex(int[] r7, int r8) {
        int r1 = Math.abs(r8 - r7[0]);
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r7.length) goto L14;
        int r4 = r7[r2];
        if (r4 == r8) goto L8;
        int r5 = Math.abs(r8 - r4);
        if (r5 > r1) goto L12;
        r3 = r2;
        r1 = r5;
    L12:
        r2 = r2 + 1;
        goto L4
    L8:
        return new int[]{0, r2};
    L14:
        return new int[]{1, r3};
    }
}
