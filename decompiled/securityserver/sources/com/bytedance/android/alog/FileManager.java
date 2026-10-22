package com.bytedance.android.alog;

import android.text.TextUtils;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class FileManager {
    public FileManager() {
    }

    public static File[] getLogs(String r8, String r9, String r10, final long r11, final long r13) {
        if (r11 > r13) goto L5;
        File r0 = new File(r8);
        if (r0.exists() == false) goto L27;
        if (r0.isDirectory() == false) goto L27;
        if (TextUtils.isEmpty(r9) == true) goto L14;
        r9 = r9.replace(':', '-');
    L14:
        StringBuilder r12 = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r3 = "\\S+";
        if (TextUtils.isEmpty(r9) == false) goto L17;
        String r14 = "\\S+";
    L18:
        r12.append(r14);
        r12.append("__");
        if (TextUtils.isEmpty(r10) == true) goto L22;
        r3 = Pattern.quote(r10);
    L22:
        r12.append(r3);
        r12.append("\\.alog\\.hot$");
        final Pattern r4 = Pattern.compile(r12.toString());
        File[] r15 = r0.listFiles(new AnonymousClass1(r4, r13, r11));
        if (r15 == null) goto L25;
        return r15;
    L25:
        return new File[0];
    L17:
        r14 = Pattern.quote(r9);
    L27:
        return new File[0];
    L5:
        return new File[0];
    }
}
