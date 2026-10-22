package com.ss.android.agilelogger.formatter.border;

import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultBorderFormatter implements BorderFormatter {
    private static final String BOTTOM_HORIZONTAL_BORDER = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final String DIVIDER_HORIZONTAL_BORDER = "╟───────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_HORIZONTAL_BORDER = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final char VERTICAL_BORDER_CHAR = 9553;

    public DefaultBorderFormatter() {
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(String[] r1) {
        return format2(r1);
    }

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(String[] r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.length == 0) goto L31;
        String[] r0 = new String[r8.length];
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r1) goto L13;
        String r5 = r8[r3];
        if (r5 == null) goto L12;
        r0[r4] = r5;
        r4 = r4 + 1;
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        if (r4 != 0) goto L15;
        return "";
    L15:
        StringBuilder r7 = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════\n");
    L16:
        if (r2 >= r4) goto L23;
        r7.append(appendVerticalBorder(r0[r2]));
        if (r2 == (r4 - 1)) goto L20;
        r7.append("\n╟───────────────────────────────────────────────────────────────────────────────────────────────────\n");
    L21:
        r2 = r2 + 1;
        goto L16
    L20:
        r7.append("\n╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L21
    L23:
        return r7.toString();
    L31:
        return "";
    }

    private static String appendVerticalBorder(String r6) {
        StringBuilder r0 = new StringBuilder(r6.length() + 10);
        String[] r7 = r6.split(IOUtils.LINE_SEPARATOR_UNIX);
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        if (r3 == 0) goto L6;
        r0.append(IOUtils.LINE_SEPARATOR_UNIX);
    L6:
        String r4 = r7[r3];
        r0.append(VERTICAL_BORDER_CHAR).append(r4);
        r3 = r3 + 1;
        goto L3
    L8:
        return r0.toString();
    }
}
