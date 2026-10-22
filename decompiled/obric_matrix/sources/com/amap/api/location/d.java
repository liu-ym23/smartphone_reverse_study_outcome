package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.loc.s4;
import com.loc.v4;
import com.loc.y4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f518e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f519f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f520g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f521h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f522i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f523j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f524k = 32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f525l = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DPoint f528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    DPoint f529d;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f530a = null;

        static {
            int[] r0 = new int[b.values().length];
            f530a = r0;
            r0[b.f531f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f530a[b.f532g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f530a[b.f533h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f530a[b.f534i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f530a[b.f535j.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f530a[b.f536k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f530a[b.f537l.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f531f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f532g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f533h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f534i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f535j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f536k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f537l = null;
        private static final /* synthetic */ b[] m = null;

        static {
            b r0 = new b("BAIDU", 0);
            f531f = r0;
            b r1 = new b("MAPBAR", 1);
            f532g = r1;
            b r3 = new b("MAPABC", 2);
            f533h = r3;
            b r5 = new b("SOSOMAP", 3);
            f534i = r5;
            b r7 = new b("ALIYUN", 4);
            f535j = r7;
            b r9 = new b("GOOGLE", 5);
            f536k = r9;
            b r11 = new b("GPS", 6);
            f537l = r11;
            m = new b[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) m.clone();
        }
    }

    static {
    }

    public d(Context r2) {
        this.f527b = null;
        this.f528c = null;
        this.f529d = null;
        this.f526a = r2;
    }

    public static boolean d(double r0, double r2) {
        return s4.i(r0, r2);
    }

    public synchronized DPoint a() {
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L4:
        if (this.f527b == null) goto L61;
        DPoint r0 = this.f528c;     // Catch: Throwable -> L62
        if (r0 == null) goto L59;
        if (r0.d() > 180.0d) goto L57;
        if (this.f528c.d() < (-180.0d)) goto L57;
        if (this.f528c.b() > 90.0d) goto L55;
        if (this.f528c.b() < (-90.0d)) goto L55;
        boolean r1 = false;
        String r2 = null;
        switch(a.f530a[this.f527b.ordinal()]) {
            case 1: goto L42;
            case 2: goto L39;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L23;
            case 7: goto L18;
            default: goto L46;
        };     // Catch: Throwable -> L62
    L18:
        int r3 = f518e;     // Catch: Throwable -> L62
        int r4 = f525l;     // Catch: Throwable -> L62
        if ((r3 & r4) != 0) goto L21;
        r2 = "gps";
        f518e = r3 | r4;     // Catch: Throwable -> L62
        r1 = true;
    L21:
        DPoint r5 = v4.d(this.f526a, this.f528c);     // Catch: Throwable -> L62
    L22:
        this.f529d = r5;     // Catch: Throwable -> L62
        goto L46
    L23:
        int r6 = f518e;     // Catch: Throwable -> L62
        int r7 = f524k;     // Catch: Throwable -> L62
        if ((r6 & r7) != 0) goto L26;
        r2 = "google";
        f518e = r6 | r7;     // Catch: Throwable -> L62
        r1 = true;
    L26:
        r5 = this.f528c;     // Catch: Throwable -> L62
        goto L22
    L27:
        int r8 = f518e;     // Catch: Throwable -> L62
        int r9 = f523j;     // Catch: Throwable -> L62
        if ((r8 & r9) != 0) goto L30;
        r2 = "aliyun";
        f518e = r8 | r9;     // Catch: Throwable -> L62
        r1 = true;
    L30:
        r5 = this.f528c;     // Catch: Throwable -> L62
        goto L22
    L31:
        int r10 = f518e;     // Catch: Throwable -> L62
        int r11 = f522i;     // Catch: Throwable -> L62
        if ((r10 & r11) != 0) goto L34;
        r2 = "sosomap";
        f518e = r10 | r11;     // Catch: Throwable -> L62
        r1 = true;
    L34:
        r5 = this.f528c;     // Catch: Throwable -> L62
        goto L22
    L35:
        int r12 = f518e;     // Catch: Throwable -> L62
        int r13 = f521h;     // Catch: Throwable -> L62
        if ((r12 & r13) != 0) goto L38;
        r2 = "mapabc";
        f518e = r12 | r13;     // Catch: Throwable -> L62
        r1 = true;
    L38:
        r5 = this.f528c;     // Catch: Throwable -> L62
        goto L22
    L39:
        this.f529d = v4.h(this.f526a, this.f528c);     // Catch: Throwable -> L62
        int r14 = f518e;     // Catch: Throwable -> L62
        int r15 = f520g;     // Catch: Throwable -> L62
        if ((r14 & r15) != 0) goto L46;
        r2 = "mapbar";
    L45:
        f518e = r14 | r15;     // Catch: Throwable -> L62
        r1 = true;
        goto L46
    L42:
        this.f529d = v4.e(this.f528c);     // Catch: Throwable -> L62
        r14 = f518e;     // Catch: Throwable -> L62
        r15 = f519f;     // Catch: Throwable -> L62
        if ((r14 & r15) != 0) goto L46;
        r2 = "baidu";
    L46:
        if (r1 == false) goto L51;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r2) == true) goto L50;
        r16.put("amap_loc_coordinate", r2);     // Catch: Throwable -> L62
    L50:
        y4.n(this.f526a, "O021", r16);     // Catch: Throwable -> L62
    L51:
        DPoint r17 = this.f529d;     // Catch: Throwable -> L62
        monitor-exit(this);
        return r17;
    L55:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L62
    L57:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L62
    L59:
        throw new IllegalArgumentException("转换坐标源不能为空");     // Catch: Throwable -> L62
    L61:
        throw new IllegalArgumentException("转换坐标类型不能为空");     // Catch: Throwable -> L62
    }

    public synchronized d b(DPoint r5) {
        monitor-enter(this);
        if (r5 == null) goto L22;
        if (r5.d() > 180.0d) goto L18;
        if (r5.d() < (-180.0d)) goto L18;
        if (r5.b() > 90.0d) goto L16;
        if (r5.b() < (-90.0d)) goto L16;
        this.f528c = r5;     // Catch: Throwable -> L19
        monitor-exit(this);
        return this;
    L16:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L19
    L18:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L19
    L22:
        throw new IllegalArgumentException("传入经纬度对象为空");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized d c(b r1) {
        monitor-enter(this);
        this.f527b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }
}
