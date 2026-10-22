package com.bytedance.android.alog;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f609a = 9;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<String> f612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f613e;

    /* JADX INFO: renamed from: com.bytedance.android.alog.a$a, reason: collision with other inner class name */
    static class C0028a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Pattern f615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f617d;

        C0028a(ArrayList r1, Pattern r2, long r3, long r5) {
            this.f614a = r1;
            this.f615b = r2;
            this.f616c = r3;
            this.f617d = r5;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r9, String r10) {
            this.f614a.add(r10);
            Matcher r0 = this.f615b.matcher(r10);
            if (r0.find() == true) goto L5;
        L21:
            return false;
        L5:
            if (r0.groupCount() != 1) goto L21;
            String r1 = r0.group(1);
            if (r1 != null) goto L10;
            return false;
        L10:
            long r2 = Long.parseLong(r1);
            if (r2 <= 0) goto L21;
            if (r2 > this.f616c) goto L21;
            long r11 = new File(r9, r10).lastModified();
            if (r11 <= 0) goto L21;
            if (r11 < this.f617d) goto L21;
            return true;
        }
    }

    static {
    }

    static HashMap<String, String> a() {
        HashMap<String, String> r0 = new HashMap();
        r0.put("start", Long.toString(f610b));
        r0.put("end", Long.toString(f611c));
        r0.put("reason", f613e);
        if (f612d == null) goto L12;
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r2 = f612d.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        if (r3.endsWith(".alog.hot") == false) goto L10;
        r3 = r3.substring(0, r3.length() - f609a);
    L10:
        r1.append(r3);
        r1.append(";");
        goto L6
    L11:
        r0.put("file", r1.toString());
    L12:
        f613e = null;
        f612d = null;
        return r0;
    }

    static File[] b(String r9, String r10, String r11, long r12, long r14) {
        f610b = r12;
        f611c = r14;
        f613e = null;
        f612d = null;
        if (r12 <= r14) goto L7;
        String r13 = "time interval is invalid";
    L5:
        f613e = r13;
        return new File[0];
    L7:
        File r0 = new File(r9);
        if (r0.exists() == true) goto L10;
    L31:
        r13 = "log dir not exists";
        goto L5
    L10:
        if (r0.isDirectory() == false) goto L31;
        if (TextUtils.isEmpty(r10) == true) goto L15;
        r10 = r10.replace(':', '-');
    L15:
        StringBuilder r15 = new StringBuilder();
        r15.append("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r3 = "\\S+";
        if (TextUtils.isEmpty(r10) == false) goto L18;
        String r16 = "\\S+";
    L19:
        r15.append(r16);
        r15.append("__");
        if (TextUtils.isEmpty(r11) == true) goto L23;
        r3 = Pattern.quote(r11);
    L23:
        r15.append(r3);
        r15.append("\\.alog\\.hot$");
        Pattern r4 = Pattern.compile(r15.toString());
        ArrayList<String> r17 = new ArrayList();
        File[] r18 = r0.listFiles(new C0028a(r17, r4, r14, r12));
        if (r18 != null) goto L26;
    L27:
        f613e = "log file not found";
        f612d = r17;
    L28:
        if (r18 == null) goto L30;
        return r18;
    L30:
        return new File[0];
    L26:
        if (r18.length != 0) goto L28;
    L18:
        r16 = Pattern.quote(r10);
        goto L19
    }
}
