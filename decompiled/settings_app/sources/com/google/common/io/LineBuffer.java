package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class LineBuffer {
    private StringBuilder line;
    private boolean sawReturn;

    protected abstract void handleLine(String r1, String r2) throws IOException;

    LineBuffer() {
        this.line = new StringBuilder();
    }

    protected void add(char[] r7, int r8, int r9) throws IOException {
        if (this.sawReturn == false) goto L12;
        if (r9 <= 0) goto L12;
        if (r7[r8] != '\n') goto L8;
        boolean r0 = true;
    L10:
        if (finishLine(r0) == false) goto L12;
        int r1 = r8 + 1;
    L13:
        int r10 = r8 + r9;
        int r11 = r1;
    L14:
        if (r1 >= r10) goto L32;
        char r4 = r7[r1];
        if (r4 != '\n') goto L18;
        this.line.append(r7, r11, r1 - r11);
        finishLine(true);
    L30:
        r11 = r1 + 1;
    L31:
        r1 = r1 + 1;
        goto L14
    L18:
        if (r4 != '\r') goto L31;
        this.line.append(r7, r11, r1 - r11);
        this.sawReturn = true;
        int r12 = r1 + 1;
        if (r12 >= r10) goto L30;
        if (r7[r12] != '\n') goto L25;
        boolean r5 = true;
    L27:
        if (finishLine(r5) == false) goto L30;
        r1 = r12;
        goto L30
    L25:
        r5 = false;
        goto L27
    L32:
        this.line.append(r7, r11, r10 - r11);
        return;
    L8:
        r0 = false;
    L12:
        r1 = r8;
        goto L13
    }

    private boolean finishLine(boolean r3) throws IOException {
        if (this.sawReturn == false) goto L7;
        if (r3 == false) goto L6;
        String r0 = "\r\n";
    L10:
        handleLine(this.line.toString(), r0);
        this.line = new StringBuilder();
        this.sawReturn = false;
        return r3;
    L6:
        r0 = "\r";
        goto L10
    L7:
        if (r3 == false) goto L9;
        r0 = "\n";
        goto L10
    L9:
        r0 = "";
        goto L10
    }

    protected void finish() throws IOException {
        if (this.sawReturn == false) goto L5;
    L6:
        finishLine(false);
        return;
    L5:
        if (this.line.length() > 0) goto L6;
    }
}
