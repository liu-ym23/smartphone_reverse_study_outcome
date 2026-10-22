package ms.bd.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class l2 extends a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.r.j0.a f22414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22415b;

    class a implements d.b.r.j0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l2 f22416f;

        a(l2 r1) {
            this.f22416f = r1;
        }

        @Override // d.b.r.j0.a
        public d.b.r.d0 a(d.b.r.j0.a.InterfaceC0391a r14) {
            d.b.r.h0.c r0 = r14.b();
            d.b.r.h0.c r1 = l2.d(this.f22416f, r0);
            d.b.r.d0 r15 = r14.c(r1);
            Iterator<d.b.r.h0.b> r2 = r15.d().iterator();
        L4:
            if (r2.hasNext() == false) goto L31;
            d.b.r.h0.b r3 = r2.next();
            String r4 = r3.a();
            String r5 = r3.b();
            if ("x-bdms-dy".equals(r4) == false) goto L10;
            if (r5 == null) goto L10;
            z3.g().e(r5, r1.A());
        L10:
            if ("x-bdms-dy-sw".equals(r4) == false) goto L14;
            if (r5 == null) goto L14;
            z3.g().d(r5);
        L14:
            if ("x-bdms-cj".equals(r4) == false) goto L22;
            if (r5 == null) goto L22;
            if (r1 == null) goto L22;
            if (Integer.valueOf(r5.trim()).intValue() != 1) goto L4;
            l2.f(this.f22416f, r1.A(), r1.G());     // Catch: Exception -> L32
        L22:
            if ("x-bdms-ctrl".equals(r4) == false) goto L4;
            if (r5 == null) goto L4;
            int r6 = b.f22318b;
            Object r7 = m.a(33554445, 4, 0, null, null);
            if (r7 == null) goto L4;
            if (((Integer) r7).intValue() != 1) goto L4;
            if (ms.bd.c.a.a().c() == null) goto L4;
            String r8 = d0.c(r3.b());
            h4.c(ms.bd.c.a.a().c()).d(new String(d0.d(r8)), true);
            goto L4
        L31:
            return r15;
        }
    }

    public l2() {
    }

    static d.b.r.h0.c d(l2 r9, d.b.r.h0.c r10) {
        long r2 = r9.f22415b;
        if (r2 == (-1)) goto L35;
        int r11 = b.f22318b;
        Object r12 = m.a(50331651, 0, r2, null, null);
        if (r12 == null) goto L36;
        h4.a r0 = h4.c(ms.bd.c.a.a().c()).b(r10.G());
        if (r0 != null) goto L11;
        return r10;
    L11:
        if ("off".equals(r0.a()) == false) goto L14;
        return r10;
    L14:
        if ("async".equals(r0.a()) == false) goto L17;
        m.a(InputDeviceCompat.SOURCE_HDMI, 0, ((Long) r12).longValue(), "report-async_" + (System.currentTimeMillis() / 1000), ms.bd.c.a.a().c());
        return r10;
    L17:
        if ("sync".equals(r0.a()) == false) goto L34;
        HashMap r1 = new HashMap();
        Long r13 = (Long) r12;
        String r3 = ((String) m.a(33554444, 0, r13.longValue(), null, null)) + "&cdi=0.3&sh=report_sync";
        Object r14 = m.a(33554440, 99999, r13.longValue(), "report_sync", null);
        if (r14 != null) goto L21;
    L29:
        String r15 = "";
    L30:
        r1.put("x-bdms-payload", d0.a(d0.b(r3.getBytes())) + ";;" + d0.a(r15));
        return b4.a(r10, r1);
    L21:
        if ((r14 instanceof Object[]) == false) goto L29;
        Object[] r16 = (Object[]) r14;
        if (r16.length < 2) goto L29;
        if (r16[0] == null) goto L29;
        if (r16[1] == null) goto L29;
        r15 = r16[1].toString();
        goto L30
    L34:
        return r10;
    L36:
        return r10;
    L35:
        return r10;
    }

    static void f(l2 r3, String r4, String r5) {
        r3.getClass();
        d4 r0 = new d4(r3);     // Catch: Exception -> L14
        String r6 = r3.e(r5, WsConstants.KEY_APP_ID);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r6) == true) goto L20;
        com.bytedance.mobsec.metasec.ml.c r7 = com.bytedance.mobsec.metasec.ml.d.a(r6);     // Catch: Exception -> L14
        if (r7 == null) goto L21;
        Iterator<String> r8 = r0.keySet().iterator();     // Catch: Exception -> L14
    L9:
        if (r8.hasNext() == false) goto L23;
        String r1 = r8.next();     // Catch: Exception -> L14
        if (r4.contains(r1) == false) goto L9;
        r7.c(r0.get(r1));     // Catch: Exception -> L14
        return;
    L23:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // ms.bd.c.a4
    protected Object c(long r1) {
        this.f22415b = r1;
        a r2 = new a(this);
        this.f22414a = r2;
        com.bytedance.ttnet.s.d.a(r2);
        return Boolean.TRUE;
    }

    public String e(String r7, String r8) {
        String r6 = new URL(r7).getQuery();     // Catch: Exception -> L18
        HashMap r9 = new HashMap();     // Catch: Exception -> L18
        if (r6 == null) goto L11;
        String[] r10 = r6.split("&");     // Catch: Exception -> L18
        int r0 = r10.length;     // Catch: Exception -> L18
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        String[] r3 = r10[r2].split("=");     // Catch: Exception -> L18
        if (r3.length != 2) goto L9;
        r9.put(r3[0], r3[1]);     // Catch: Exception -> L18
    L9:
        r2 = r2 + 1;     // Catch: Exception -> L18
    L11:
        if (r9.isEmpty() == false) goto L13;
        return "";
    L13:
        if (r9.containsKey(r8) == false) goto L24;
        return (String) r9.get(r8);
    L24:
        return "";
    L25:
        return "";
    }

    protected void finalize() {
        com.bytedance.ttnet.s.d.j(this.f22414a);
        super.finalize();
    }
}
