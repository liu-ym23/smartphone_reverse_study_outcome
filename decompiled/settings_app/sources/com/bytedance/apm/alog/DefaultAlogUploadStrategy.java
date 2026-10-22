package com.bytedance.apm.alog;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAlogUploadStrategy implements IAlogUploadStrategy {
    public DefaultAlogUploadStrategy() {
    }

    @Override // com.bytedance.apm.alog.IAlogUploadStrategy
    public List<String> getUploadAlogFiles(Context r10, String r11, long r12, long r14) {
        final long r7 = r12 * 1000;
        final long r5 = r14 * 1000;
        if (r7 <= r5) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        return null;
    L7:
        File r13 = new File(r11);
        if (r13.exists() == true) goto L10;
    L19:
        return null;
    L10:
        if (r13.isDirectory() == false) goto L19;
        final Pattern r4 = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__\\S+__\\S+\\.alog\\.hot$");
        File[] r9 = r13.listFiles(new AnonymousClass1(this, r4, r5, r7));
        ArrayList r15 = new ArrayList();
        if (r9 != null) goto L15;
        return null;
    L15:
        int r16 = r9.length;
        int r17 = 0;
    L16:
        if (r17 >= r16) goto L18;
        r15.add(r9[r17].getAbsolutePath());
        r17 = r17 + 1;
        goto L16
    L18:
        return r15;
    }
}
