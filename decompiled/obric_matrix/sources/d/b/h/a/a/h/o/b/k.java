package d.b.h.a.a.h.o.b;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements p000j.l0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f13501a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13502a = null;

        static {
            int[] r0 = new int[d.b.h.a.a.h.o.b.x.b.a.values().length];
            f13502a = r0;
            r0[d.b.h.a.a.h.o.b.x.b.a.f13580g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f13502a[d.b.h.a.a.h.o.b.x.b.a.f13584k.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f13502a[d.b.h.a.a.h.o.b.x.b.a.f13582i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f13502a[d.b.h.a.a.h.o.b.x.b.a.f13583j.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f13502a[d.b.h.a.a.h.o.b.x.b.a.f13581h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f13502a[d.b.h.a.a.h.o.b.x.b.a.f13585l.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f13502a[d.b.h.a.a.h.o.b.x.b.a.f13579f.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public k() {
    }

    private String b(List<InetAddress> r5, d.b.h.a.a.h.o.b.x.b.a r6) {
        JSONObject r4 = new JSONObject();
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L32
        Iterator<InetAddress> r7 = r5.iterator();     // Catch: Exception -> L32
    L5:
        if (r7.hasNext() == false) goto L11;
        InetAddress r1 = r7.next();     // Catch: Exception -> L32
        if (r1 == null) goto L5;
        if (TextUtils.isEmpty(r1.getHostAddress()) == true) goto L5;
        r0.put(r1.getHostAddress());     // Catch: Exception -> L32
        goto L5
    L11:
        r4.put("address_list", r0);     // Catch: Exception -> L32
        int r2 = 1;
        if (d.b.h.a.a.h.o.b.x.e.q().s().get() == false) goto L14;
        int r3 = 1;
    L15:
        r4.put("httpdns_prefer", r3);     // Catch: Exception -> L32
        v r8 = v.f13554g;     // Catch: Exception -> L32
        u r9 = u.f13547g;     // Catch: Exception -> L32
        switch(a.f13502a[r6.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L24;
        };     // Catch: Exception -> L32
    L18:
        r8 = v.f13559l;     // Catch: Exception -> L32
        goto L24
    L19:
        r8 = v.f13555h;     // Catch: Exception -> L32
        r9 = u.f13548h;     // Catch: Exception -> L32
        boolean r10 = true;
    L25:
        r4.put("source", r8.f13560f);     // Catch: Exception -> L32
        r4.put("cache_source", r9.f13553f);     // Catch: Exception -> L32
        if (r10 == true) goto L29;
        r2 = 0;
    L29:
        r4.put("from_stale_cache", r2);     // Catch: Exception -> L32
        goto L31
    L20:
        r8 = v.f13558k;     // Catch: Exception -> L32
        goto L24
    L21:
        r8 = v.f13557j;     // Catch: Exception -> L32
        goto L24
    L22:
        r8 = v.f13555h;     // Catch: Exception -> L32
        r9 = u.f13549i;     // Catch: Exception -> L32
        goto L24
    L23:
        r8 = v.f13555h;     // Catch: Exception -> L32
        r9 = u.f13548h;     // Catch: Exception -> L32
    L24:
        r10 = false;
        goto L25
    L14:
        r3 = 0;
    L31:
        return r4.toString();
    }

    public static k c() {
        if (f13501a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13501a != null) goto L9;
        f13501a = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f13501a;
    }

    @Override // p000j.l0.b
    public p000j.l0.c a(String r5, int r6) {
        Logger.debug();
        d.b.h.a.a.h.o.b.x.b r7 = d.b.h.a.a.h.o.b.x.e.q().n(r5);
        d.b.h.a.a.h.o.b.x.b.a r0 = d.b.h.a.a.h.o.b.x.b.a.f13579f;
        List<InetAddress> r1 = new ArrayList();
        if (r7 != null) goto L5;
    L25:
        r1 = p000j.r.f18184a.a(r5);     // Catch: UnknownHostException -> L24
        r0 = d.b.h.a.a.h.o.b.x.b.a.f13583j;     // Catch: UnknownHostException -> L24
    L23:
        return new p000j.l0.c(r1, b(r1, r0));
    L5:
        if (r7.f13576f.isEmpty() == true) goto L7;
    L8:
        Iterator<String> r2 = r7.f13577g.iterator();
        Iterator<String> r3 = r7.f13576f.iterator();
    L10:
        if (r2.hasNext() == true) goto L16;
        if (r3.hasNext() == true) goto L16;
        r0 = r7.f13578h;
    L16:
        if (r2.hasNext() == false) goto L19;
        r1.add(InetAddress.getByName(r2.next()));
    L19:
        if (r3.hasNext() == false) goto L10;
        r1.add(InetAddress.getByName(r3.next()));
        goto L10
    L7:
        if (r7.f13577g.isEmpty() == true) goto L25;
        goto L8
    }
}
