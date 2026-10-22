package com.bytedance.bdturing.ttnet;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdturing.verify.b.i;
import d.b.h.a.a.h.g;
import d.b.r.d0;
import d.b.r.k0.j;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    static class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f3145a;

        a(byte[] r1) {
            this.f3145a = r1;
        }

        @Override // d.b.r.k0.j
        @Nullable
        public String a() {
            return null;
        }

        @Override // d.b.r.k0.j
        public void b(OutputStream r1) {
            r1.write(this.f3145a);
        }

        @Override // d.b.r.k0.j
        @Nullable
        public String c() {
            return null;
        }

        @Override // d.b.r.k0.j
        @Nullable
        public String e() {
            return null;
        }

        @Override // d.b.r.k0.j
        public long length() {
            return this.f3145a.length;
        }
    }

    static class b implements g.t {

        class a implements com.bytedance.bdturing.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f3146a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean[] f3147b;

            a(b r1, CountDownLatch r2, boolean[] r3) {
                this.f3146a = r2;
                this.f3147b = r3;
            }

            @Override // com.bytedance.bdturing.c
            public void a(int r1, JSONObject r2) {
                this.f3146a.countDown();
            }

            @Override // com.bytedance.bdturing.c
            public void b(int r2, JSONObject r3) {
                this.f3147b[0] = true;
                this.f3146a.countDown();
            }
        }

        b() {
        }

        @Override // d.b.h.a.a.h.g.t
        public boolean a(Map<String, List<String>> r7) {
            boolean[] r1 = {false};
            CountDownLatch r3 = new CountDownLatch(1);
            if (r7.containsKey("bdturing-verify") == false) goto L20;
            List<String> r8 = r7.get("bdturing-verify");
            if (r8 != null) goto L7;
        L18:
            return false;
        L7:
            if (r8.size() < 1) goto L18;
            i r0 = new i(r8.get(0));
            if (com.bytedance.bdturing.b.f().e() == null) goto L12;
            Activity r9 = com.bytedance.bdturing.b.f().e().getTopActivity();
        L13:
            com.bytedance.bdturing.b.f().i(r9, r0, new a(this, r3, r1));
            r3.await();     // Catch: InterruptedException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            goto L20
        L12:
            r9 = null;
        L20:
            return r1[0];
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.ttnet.c$c, reason: collision with other inner class name */
    static class C0086c implements d.b.r.j0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f3148f;

        C0086c(Map r1) {
            this.f3148f = r1;
        }

        @Override // d.b.r.j0.a
        public d0 a(d.b.r.j0.a.InterfaceC0391a r7) {
            d.b.r.h0.c r0 = r7.b();
            LinkedList r1 = new LinkedList();
            r1.addAll(r0.v());
            Iterator r2 = this.f3148f.keySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            String r3 = (String) r2.next();
            r1.add(new d.b.r.h0.b(r3, (String) this.f3148f.get(r3)));
            goto L4
        L6:
            d.b.r.h0.c.a r6 = r0.O();
            r6.b(r1);
            return r7.c(r6.a());
        }
    }

    public static void a() {
        com.bytedance.ttnet.s.d.a(com.bytedance.bdturing.ttnet.a.c());
    }

    public static void b() {
        HashMap r0 = new HashMap();
        r0.put("x-tt-bypass-bdturing", LocationInfoConst.ALLOW_USE_LOCATION);
        com.bytedance.ttnet.s.d.a(new C0086c(r0));
    }

    private static INetworkApi c(String r1) {
        return (INetworkApi) com.bytedance.ttnet.s.d.h(r1).e(INetworkApi.class);
    }

    public static byte[] d(String r1, String r2, Map<String, String> r3, Map<String, String> r4) {
        List<d.b.r.h0.b> r5 = h(r4);
        d0<d.b.r.k0.i> r6 = c(r1).doGet(true, r1, r3, r5).execute();     // Catch: Exception -> L9
        if (r6.b() != 200) goto L8;
        return f(r6.a().d());
    L8:
        return new byte[0];
    }

    public static byte[] e(String r1, String r2, Map<String, String> r3, byte[] r4, Map<String, String> r5) {
        List<d.b.r.h0.b> r6 = h(r5);
        d0<d.b.r.k0.i> r7 = c(r1).doPost(r1, r3, new a(r4), r6).execute();     // Catch: Exception -> L9
        if (r7.b() != 200) goto L8;
        return f(r7.a().d());
    L8:
        return new byte[0];
    }

    private static byte[] f(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L3:
        int r2 = r4.read(r1);
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);
        goto L3
    L7:
        return r0.toByteArray();
    }

    public static void g() {
        g.F(new b());
    }

    private static List<d.b.r.h0.b> h(Map<String, String> r4) {
        LinkedList r0 = new LinkedList();
        if (r4 == null) goto L8;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new d.b.r.h0.b(r1.getKey(), r1.getValue()));
    L8:
        return r0;
    }
}
