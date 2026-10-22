package com.bytedance.apm.p;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c implements f {

    class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pattern f1678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f1679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f1680c;

        a(c r1, Pattern r2, long r3, long r5) {
            this.f1678a = r2;
            this.f1679b = r3;
            this.f1680c = r5;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r9, String r10) {
            Matcher r0 = this.f1678a.matcher(r10);
            if (r0.find() == true) goto L5;
            return false;
        L5:
            if (r0.groupCount() != 1) goto L25;
            String r1 = r0.group(1);
            if (r1 != null) goto L10;
            return false;
        L10:
            long r2 = Long.parseLong(r1);
            if (r2 > 0) goto L13;
            return false;
        L13:
            if (r2 > this.f1679b) goto L26;
            long r11 = new File(r9, r10).lastModified();
            if (r11 > 0) goto L18;
            return false;
        L18:
            if (r11 >= this.f1680c) goto L20;
            return false;
        L20:
            return true;
        L26:
            return false;
        L25:
            return false;
        }
    }

    public c() {
    }

    @Override // com.bytedance.apm.p.f
    public List<String> a(Context r10, String r11, long r12, long r14) {
        long r7 = r12 * 1000;
        long r5 = r14 * 1000;
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
        File[] r9 = r13.listFiles(new a(this, Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__\\S+__\\S+\\.alog\\.hot$"), r5, r7));
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
