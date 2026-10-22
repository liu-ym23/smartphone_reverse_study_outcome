package p000j.l0;

import android.text.TextUtils;
import com.bytedance.keva.KevaImpl;
import com.ss.ttuploader.TTUploadResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import p000j.d0;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a m;
    private static AtomicBoolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f18135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f18136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f18137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f18138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f18139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f18140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f18141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CopyOnWriteArrayList<Integer> f18142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f18143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final C0470a f18144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<String> f18145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f18146l;

    /* JADX INFO: renamed from: j.l0.a$a, reason: collision with other inner class name */
    public static class C0470a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f18147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f18148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f18149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CopyOnWriteArrayList<String> f18150d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f18151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f18152f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicBoolean f18153g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicBoolean f18154h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<String> f18155i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<String> f18156j;

        public C0470a() {
            this.f18147a = new CopyOnWriteArrayList();
            this.f18148b = new CopyOnWriteArrayList();
            this.f18149c = new AtomicBoolean(false);
            this.f18150d = new CopyOnWriteArrayList();
            this.f18151e = new AtomicBoolean(false);
            this.f18152f = new AtomicBoolean(false);
            this.f18153g = new AtomicBoolean(false);
            this.f18154h = new AtomicBoolean(false);
            this.f18155i = new ArrayList();
            this.f18156j = new ArrayList();
        }
    }

    static {
        n = new AtomicBoolean(false);
    }

    public a() {
        new AtomicInteger(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        this.f18135a = new AtomicInteger(TTUploadResolver.HOST_MAX_CACHE_TIME);
        this.f18136b = new CopyOnWriteArrayList();
        this.f18137c = new AtomicBoolean(true);
        this.f18138d = new AtomicBoolean(false);
        this.f18139e = new AtomicInteger(320);
        this.f18140f = new AtomicInteger(0);
        this.f18141g = new AtomicBoolean(false);
        this.f18142h = new CopyOnWriteArrayList();
        this.f18143i = new CopyOnWriteArrayList();
        this.f18144j = new C0470a();
        this.f18145k = new CopyOnWriteArrayList();
        this.f18146l = new AtomicBoolean(false);
    }

    public static boolean h(String r1) {
        return i(r1, j().f18145k);
    }

    public static boolean i(String r3, List<String> r4) {
        if (TextUtils.isEmpty(r3) == true) goto L18;
        if (r4 == null) goto L18;
        if (r4.isEmpty() == true) goto L18;
        Iterator<String> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        String r0 = r5.next();
        if (TextUtils.isEmpty(r0) == true) goto L10;
        if (r3.endsWith(r0) == false) goto L10;
        return true;
    L18:
        return false;
    }

    public static a j() {
        if (m != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (m != null) goto L9;
        m = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return m;
    }

    public static boolean k() {
        return n.get();
    }

    public static void n(JSONObject r3, String r4, List<String> r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4) == true) goto L22;
        JSONArray r6 = r3.optJSONArray(r4);
        if (r6 != null) goto L9;
        return;
    L9:
        ArrayList r7 = new ArrayList();
        int r0 = 0;
    L11:
        if (r0 >= r6.length()) goto L16;
        String r1 = r6.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L15;
        r7.add(r1);
    L15:
        r0 = r0 + 1;
        goto L11
    L16:
        r5.clear();
        r5.addAll(r7);
        return;
    }

    public static void q(String r4, List<String> r5) {
        if (TextUtils.isEmpty(r4) == true) goto L14;
        if (r5 == null) goto L19;
        String[] r6 = r4.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L20;
        String r2 = r6[r1];
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (i(r2, r5) == true) goto L13;
        r5.add(r2.trim());
    L13:
        r1 = r1 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void r(boolean r1) {
        n.set(r1);
    }

    public boolean a() {
        return this.f18146l.get();
    }

    public boolean b() {
        return this.f18137c.get();
    }

    public List<String> c() {
        return this.f18136b;
    }

    public int d() {
        return this.f18135a.get();
    }

    public int e() {
        return this.f18139e.get();
    }

    public C0470a f() {
        return this.f18144j;
    }

    public int g() {
        return this.f18140f.get();
    }

    public boolean l() {
        return this.f18138d.get();
    }

    public void m(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        p(r1);
        o(r1);
    }

    public void o(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r4 = r3.optInt("ttok_enable_tls1.1", -1);
        if (r4 < 0) goto L12;
        AtomicBoolean r2 = this.f18146l;
        boolean r0 = true;
        if (r4 == 1) goto L10;
        r0 = false;
    L10:
        r2.set(r0);
        return;
    }

    public void p(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        JSONObject r0 = r7.optJSONObject("rect_request_control");
        if (r0 != null) goto L7;
        return;
    L7:
        n(r0, "scy_headers", this.f18144j.f18147a);
        n(r0, "scy_rect_wl", this.f18144j.f18148b);
        int r1 = r0.optInt("rm_inscy_out_wl", -1);
        boolean r3 = false;
        if (r1 < 0) goto L14;
        AtomicBoolean r5 = this.f18144j.f18149c;
        if (r1 != 1) goto L12;
        boolean r2 = true;
    L13:
        r5.set(r2);
        goto L14
    L12:
        r2 = false;
    L14:
        n(r0, "scy_rect_bl", this.f18144j.f18150d);
        int r4 = r0.optInt("disable_report_inscy_rect", -1);
        if (r4 < 0) goto L21;
        AtomicBoolean r6 = this.f18144j.f18151e;
        if (r4 != 1) goto L19;
        boolean r8 = true;
    L20:
        r6.set(r8);
        goto L21
    L19:
        r8 = false;
    L21:
        int r9 = r0.optInt("only_control_webview", -1);
        if (r9 < 0) goto L28;
        AtomicBoolean r10 = this.f18144j.f18152f;
        if (r9 != 1) goto L26;
        boolean r11 = true;
    L27:
        r10.set(r11);
        goto L28
    L26:
        r11 = false;
    L28:
        int r12 = r0.optInt("enable_report_full_url", -1);
        if (r12 < 0) goto L35;
        AtomicBoolean r13 = this.f18144j.f18153g;
        if (r12 != 1) goto L33;
        boolean r14 = true;
    L34:
        r13.set(r14);
        goto L35
    L33:
        r14 = false;
    L35:
        int r15 = r0.optInt("v2_on", -1);
        if (r15 < 0) goto L41;
        AtomicBoolean r16 = this.f18144j.f18154h;
        if (r15 != 1) goto L40;
        r3 = true;
    L40:
        r16.set(r3);
    L41:
        n(r0, "keep_headers_v2", this.f18144j.f18155i);
        n(r0, "rm_std_keep_headers_v2", this.f18144j.f18156j);
        q(r7.optString("share_cookie_host_list"), this.f18145k);
    }

    public boolean s(IOException r2, d0 r3, int r4) {
        if (r2 == null) goto L20;
        if (r3 == null) goto L20;
        if (r3.k() == null) goto L20;
        if (this.f18141g.get() == true) goto L12;
        return false;
    L12:
        if (this.f18142h.contains(Integer.valueOf(r4)) == true) goto L14;
        return false;
    L14:
        String r5 = r3.k().m();
        if (TextUtils.isEmpty(r5) == true) goto L20;
        if (this.f18143i.contains(r5) == false) goto L20;
        return true;
    L20:
        return false;
    }
}
