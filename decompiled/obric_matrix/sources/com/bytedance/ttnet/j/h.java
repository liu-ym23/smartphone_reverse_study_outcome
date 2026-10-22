package com.bytedance.ttnet.j;

import com.bytedance.common.utility.Logger;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f6380a;

    class a extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6381k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f6382l;
        final /* synthetic */ h m;

        a(h r1, String r2, String r3, String r4) {
            this.m = r1;
            this.f6381k = r3;
            this.f6382l = r4;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            h.a(this.m, this.f6381k, this.f6382l);
        }
    }

    public h() {
    }

    static /* synthetic */ void a(h r0, String r1, String r2) {
        r0.b(r1, r2);
    }

    private void b(String r10, String r11) {
        CookieHandler r0 = CookieHandler.getDefault();
        if (r0 != null) goto L5;
        return;
    L5:
        List<String> r12 = e(r10);
        List<String> r13 = e(r11);
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<String> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        String r3 = r14.next();
        boolean r4 = com.bytedance.ttnet.s.e.d(r3, r12);
        Logger.debug();
        if (r4 == true) goto L10;
        r2.add(r3);
        goto L7
    L10:
        r1.add(r3);
        goto L7
    L13:
        if (r2.isEmpty() == false) goto L16;
        return;
    L16:
        if (r1.isEmpty() == false) goto L19;
        r1 = r2;
    L19:
        Map<String, List<String>> r15 = new HashMap();
        Iterator r16 = r1.iterator();
    L21:
        if (r16.hasNext() == false) goto L26;
        r15 = r0.get(new URI("https://" + ((String) r16.next()) + "/"), null);     // Catch: Throwable -> L52
        if (r15.size() <= 0) goto L21;
        Logger.debug();     // Catch: Throwable -> L52
    L26:
        if (r15 != null) goto L28;
        return;
    L28:
        if (r15.isEmpty() == true) goto L79;
        List<String> r17 = r15.get("Cookie");
        if (r17 != null) goto L33;
    L34:
        r17 = r15.get("cookie");
        if (r17 != null) goto L37;
        return;
    L37:
        if (r17.isEmpty() == true) goto L80;
    L39:
        LinkedHashMap r18 = new LinkedHashMap();
        List<String> r9 = f(r17);
        Iterator r19 = r2.iterator();
    L41:
        if (r19.hasNext() == false) goto L81;
        String r5 = (String) r19.next();
        ArrayList r6 = new ArrayList();
        URI r7 = new URI("https://" + r5 + "/");     // Catch: Throwable -> L53
        Iterator<String> r8 = r9.iterator();     // Catch: Throwable -> L53
    L45:
        if (r8.hasNext() == false) goto L49;
        String r20 = r8.next();     // Catch: Throwable -> L53
        if (com.bytedance.common.utility.k.c(r20) == true) goto L45;
        r6.add(r20 + "; Domain=" + r5);     // Catch: Throwable -> L53
        goto L45
    L49:
        r18.put("Set-Cookie", r6);     // Catch: Throwable -> L53
        r0.put(r7, r18);     // Catch: Throwable -> L53
        goto L41
    L81:
        return;
    L80:
        return;
    L33:
        if (r17.isEmpty() == false) goto L39;
    }

    public static h c() {
        if (f6380a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6380a != null) goto L9;
        f6380a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f6380a;
    }

    private List<String> e(String r5) {
        ArrayList r4 = new ArrayList();
        if (com.bytedance.common.utility.k.c(r5) == false) goto L5;
        return r4;
    L5:
        String[] r6 = r5.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        String r2 = r6[r1];
        if (com.bytedance.common.utility.k.c(r2) == true) goto L10;
        r4.add(r2.trim());
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        return r4;
    }

    private List<String> f(List<String> r6) {
        ArrayList r5 = new ArrayList();
        Iterator<String> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        String[] r0 = r7.next().split(";");
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L4;
        String r3 = r0[r2];
        if (com.bytedance.common.utility.k.c(r3) == true) goto L10;
        r5.add(r3.trim());
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return r5;
    }

    public void d(String r3, String r4) {
        if (r4.equals(r3) == false) goto L5;
        return;
    L5:
        new a(this, "Sync-Cookie", r3, r4).b();
    }
}
