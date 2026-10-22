package d.b.h.a.a.h.o.b.z;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<String> f13640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<String> f13641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<String> f13642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<String> f13643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<String> f13644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected List<String> f13645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected List<String> f13646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f13651l;
    protected int m;
    private List<String> n;

    /* JADX INFO: renamed from: d.b.h.a.a.h.o.b.z.a$a, reason: collision with other inner class name */
    public static final enum EnumC0361a extends Enum<EnumC0361a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0361a f13652f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0361a f13653g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0361a f13654h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0361a f13655i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumC0361a[] f13656j = null;

        static {
            EnumC0361a r0 = new EnumC0361a("DISPATCH_NONE", 0);
            f13652f = r0;
            EnumC0361a r1 = new EnumC0361a("DISPATCH_HIT", 1);
            f13653g = r1;
            EnumC0361a r3 = new EnumC0361a("DISPATCH_DROP", 2);
            f13654h = r3;
            EnumC0361a r5 = new EnumC0361a("DISPATCH_DELAY", 3);
            f13655i = r5;
            f13656j = new EnumC0361a[]{r0, r1, r3, r5};
        }

        private EnumC0361a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0361a valueOf(String r1) {
            return (EnumC0361a) Enum.valueOf(EnumC0361a.class, r1);
        }

        public static EnumC0361a[] values() {
            return (EnumC0361a[]) f13656j.clone();
        }
    }

    static {
    }

    public a() {
        this.f13640a = new ArrayList();
        this.f13641b = new ArrayList();
        this.f13642c = new ArrayList();
        this.f13643d = new ArrayList();
        this.f13644e = new ArrayList();
        this.f13645f = new ArrayList();
        this.f13646g = new ArrayList();
        this.n = new ArrayList();
    }

    public static a a(String r7, JSONObject r8, int r9, long r10, long r12, long r14, String r16, long r17, List<String> r19, int r20) {
        if (r7.equals("tc") == false) goto L5;
        a r1 = new j();
    L7:
        if (r7.equals("dispatch") == false) goto L10;
        r1 = new g();
    L10:
        if (r7.equals("delay") == false) goto L12;
        r1 = new c();
    L12:
        if (r1 != null) goto L14;
        return null;
    L14:
        r1.n(r9);
        r1.m(r10, r12);
        r1.o(r14);
        r1.q(r19);
        r1.p(r20);
        if (r1.e(r8, r16, r17) == false) goto L17;
        return r1;
    L17:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    private boolean h() {
        long r0 = this.f13647h;
        if (r0 != 0) goto L8;
        if (this.f13648i != 0) goto L8;
        return true;
    L8:
        if (r0 != (-1)) goto L10;
    L18:
        return false;
    L10:
        if (this.f13648i == (-1)) goto L18;
        long r2 = System.currentTimeMillis();
        if (r2 > this.f13647h) goto L15;
    L17:
        Logger.debug();
        goto L18
    L15:
        if (r2 >= this.f13648i) goto L17;
        return true;
    }

    public static boolean j(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return false;
    L9:
        Pattern.compile(r2);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    private void l(JSONObject r2, String r3, List<String> r4, boolean r5) {
        JSONArray r1 = r2.optJSONArray(r3);
        if (r1 == null) goto L14;
        int r6 = 0;
    L6:
        if (r6 >= r1.length()) goto L19;
        String r7 = r1.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L13;
        if (r5 == true) goto L11;
    L12:
        r4.add(r7);
        goto L13
    L11:
        if (j(r7) == true) goto L12;
    L13:
        r6 = r6 + 1;
        goto L6
    L19:
        return;
    }

    private void m(long r1, long r3) {
        this.f13647h = r1;
        this.f13648i = r3;
    }

    private void n(int r1) {
        this.f13649j = r1;
    }

    private void o(long r1) {
        this.f13650k = r1;
    }

    private void p(int r1) {
        if (r1 >= 0) goto L4;
        r1 = Integer.MAX_VALUE;
    L4:
        this.m = r1;
    }

    private void q(List<String> r1) {
        this.n = r1;
    }

    public int b() {
        return this.f13649j;
    }

    public long c() {
        return this.f13650k;
    }

    public String d() {
        return this.f13651l;
    }

    public abstract boolean e(JSONObject r1, String r2, long r3);

    public boolean f(m r4) {
        if (r4.a() <= this.f13649j) goto L7;
        Logger.debug();
        return false;
    L7:
        if (this.n.isEmpty() == true) goto L15;
        if (TextUtils.isEmpty(r4.c()) == true) goto L15;
        if (this.n.contains(r4.c()) == true) goto L15;
        Logger.debug();
        return false;
    L15:
        return h();
    }

    public boolean g() {
        return h();
    }

    protected boolean i(Uri r6) {
        if (this.f13640a.isEmpty() == false) goto L5;
    L4:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L15;
        Logger.debug();
        return false;
    L15:
        String r1 = r6.getPath();
        if (TextUtils.isEmpty(r1) == false) goto L19;
        return false;
    L19:
        if (this.f13641b.isEmpty() == true) goto L28;
        Iterator<String> r3 = this.f13641b.iterator();
    L22:
        if (r3.hasNext() == false) goto L28;
        if (r1.equals(r3.next()) == false) goto L22;
        Logger.debug();
        return true;
    L28:
        if (this.f13642c.isEmpty() == true) goto L37;
        Iterator<String> r4 = this.f13642c.iterator();
    L31:
        if (r4.hasNext() == false) goto L37;
        if (r1.startsWith(r4.next()) == false) goto L31;
        Logger.debug();
        return true;
    L37:
        if (this.f13643d.isEmpty() == true) goto L46;
        Iterator<String> r5 = this.f13643d.iterator();
    L40:
        if (r5.hasNext() == false) goto L46;
        if (r1.contains(r5.next()) == false) goto L40;
        Logger.debug();
        return true;
    L46:
        if (this.f13644e.isEmpty() == true) goto L55;
        Iterator<String> r7 = this.f13644e.iterator();
    L49:
        if (r7.hasNext() == false) goto L55;
        if (r1.matches(r7.next()) == false) goto L49;
        Logger.debug();
        return true;
    L55:
        if (this.f13645f.isEmpty() == false) goto L57;
    L74:
        return false;
    L57:
        if (this.f13646g.isEmpty() == true) goto L67;
        Iterator<String> r8 = this.f13646g.iterator();
    L60:
        if (r8.hasNext() == false) goto L64;
        if (r1.contains(r8.next()) == false) goto L60;
        boolean r2 = true;
    L65:
        if (r2 == true) goto L67;
        return false;
    L64:
        r2 = false;
    L67:
        Iterator<String> r9 = this.f13645f.iterator();
    L69:
        if (r9.hasNext() == false) goto L74;
        if (r6.toString().matches(r9.next()) == false) goto L69;
        Logger.debug();
        return true;
    L5:
        Iterator<String> r10 = this.f13640a.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        if (d.b.h.a.a.h.s.l.i(r6.getHost(), r10.next()) == false) goto L7;
    L11:
        r0 = false;
        goto L12
    }

    protected void k(JSONObject r5) {
        l(r5, "host_group", this.f13640a, false);
        l(r5, "equal_group", this.f13641b, false);
        l(r5, "prefixes_group", this.f13642c, false);
        l(r5, "contain_group", this.f13643d, false);
        l(r5, "pattern_group", this.f13644e, true);
        l(r5, "url_group", this.f13645f, true);
        l(r5, "path_contain", this.f13646g, false);
    }
}
