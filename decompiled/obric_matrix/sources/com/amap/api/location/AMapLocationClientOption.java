package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.loc.s4;

/* JADX INFO: loaded from: classes.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = null;
    private static c G;
    static String H;
    public static boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static long f481J;
    private boolean A;
    private boolean B;
    private float C;
    private d D;
    boolean E;
    String F;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f488l;
    private b m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private long u;
    private long v;
    private e w;
    private boolean x;
    private int y;
    private int z;

    final class a implements Parcelable.Creator<AMapLocationClientOption> {
        a() {
        }

        private static AMapLocationClientOption a(Parcel r1) {
            return new AMapLocationClientOption(r1);
        }

        private static AMapLocationClientOption[] b(int r0) {
            return new AMapLocationClientOption[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption[] newArray(int r1) {
            return b(r1);
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f489f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f490g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f491h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ b[] f492i = null;

        static {
            b r0 = new b("Battery_Saving", 0);
            f489f = r0;
            b r1 = new b("Device_Sensors", 1);
            f490g = r1;
            b r3 = new b("Hight_Accuracy", 2);
            f491h = r3;
            f492i = new b[]{r0, r1, r3};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f492i.clone();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f493f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f494g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ c[] f495h = null;

        static {
            c r0 = new c("HTTP", 0, 0);
            f493f = r0;
            c r1 = new c("HTTPS", 1, 1);
            f494g = r1;
            f495h = new c[]{r0, r1};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f495h.clone();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f496f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f497g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f498h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ d[] f499i = null;

        static {
            d r0 = new d("SignIn", 0);
            f496f = r0;
            d r1 = new d("Transport", 1);
            f497g = r1;
            d r3 = new d("Sport", 2);
            f498h = r3;
            f499i = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f499i.clone();
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f500f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f501g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f502h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ e[] f503i = null;

        static {
            e r0 = new e("DEFAULT", 0);
            f500f = r0;
            e r1 = new e("ZH", 1);
            f501g = r1;
            e r3 = new e("EN", 2);
            f502h = r3;
            f503i = new e[]{r0, r1, r3};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f503i.clone();
        }
    }

    static {
        G = c.f493f;
        H = "";
        CREATOR = new a();
        I = true;
        f481J = 30000;
    }

    public AMapLocationClientOption() {
        this.f482f = 2000;
        this.f483g = s4.f7776i;
        this.f484h = false;
        this.f485i = true;
        this.f486j = true;
        this.f487k = true;
        this.f488l = true;
        this.m = b.f491h;
        this.n = false;
        this.o = false;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = 30000;
        this.v = 30000;
        this.w = e.f500f;
        this.x = false;
        this.y = 1500;
        this.z = RegionBean.DEFAULT_EXPIRE_TIME;
        this.A = false;
        this.B = true;
        this.C = 0.0f;
        this.D = null;
        this.E = false;
        this.F = null;
    }

    protected AMapLocationClientOption(Parcel r10) {
        this.f482f = 2000;
        this.f483g = s4.f7776i;
        boolean r0 = false;
        this.f484h = false;
        this.f485i = true;
        this.f486j = true;
        this.f487k = true;
        this.f488l = true;
        b r2 = b.f491h;
        this.m = r2;
        this.n = false;
        this.o = false;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = 30000;
        this.v = 30000;
        e r3 = e.f500f;
        this.w = r3;
        this.x = false;
        this.y = 1500;
        this.z = RegionBean.DEFAULT_EXPIRE_TIME;
        this.A = false;
        this.B = true;
        this.C = 0.0f;
        d r4 = null;
        this.D = null;
        this.E = false;
        this.F = null;
        this.f482f = r10.readLong();
        this.f483g = r10.readLong();
        if (r10.readByte() == 0) goto L5;
        boolean r5 = true;
    L6:
        this.f484h = r5;
        if (r10.readByte() == 0) goto L9;
        boolean r6 = true;
    L10:
        this.f485i = r6;
        if (r10.readByte() == 0) goto L13;
        boolean r7 = true;
    L14:
        this.f486j = r7;
        if (r10.readByte() == 0) goto L17;
        boolean r8 = true;
    L18:
        this.f487k = r8;
        if (r10.readByte() == 0) goto L21;
        boolean r9 = true;
    L22:
        this.f488l = r9;
        int r11 = r10.readInt();
        if (r11 == (-1)) goto L26;
        r2 = b.values()[r11];
    L26:
        this.m = r2;
        if (r10.readByte() == 0) goto L29;
        boolean r12 = true;
    L30:
        this.n = r12;
        if (r10.readByte() == 0) goto L33;
        boolean r13 = true;
    L34:
        this.o = r13;
        if (r10.readByte() == 0) goto L37;
        boolean r14 = true;
    L38:
        this.A = r14;
        if (r10.readByte() == 0) goto L41;
        boolean r15 = true;
    L42:
        this.B = r15;
        if (r10.readByte() == 0) goto L45;
        boolean r16 = true;
    L46:
        this.p = r16;
        if (r10.readByte() == 0) goto L49;
        boolean r17 = true;
    L50:
        this.q = r17;
        if (r10.readByte() == 0) goto L53;
        boolean r18 = true;
    L54:
        this.r = r18;
        if (r10.readByte() == 0) goto L57;
        boolean r19 = true;
    L58:
        this.s = r19;
        if (r10.readByte() == 0) goto L61;
        boolean r20 = true;
    L62:
        this.t = r20;
        this.u = r10.readLong();
        int r21 = r10.readInt();
        if (r21 != (-1)) goto L65;
        c r22 = c.f493f;
    L66:
        G = r22;
        int r23 = r10.readInt();
        if (r23 == (-1)) goto L70;
        r3 = e.values()[r23];
    L70:
        this.w = r3;
        this.C = r10.readFloat();
        int r24 = r10.readInt();
        if (r24 == (-1)) goto L74;
        r4 = d.values()[r24];
    L74:
        this.D = r4;
        if (r10.readByte() == 0) goto L77;
        r0 = true;
    L77:
        I = r0;
        this.v = r10.readLong();
        return;
    L65:
        r22 = c.values()[r21];
        goto L66
    L61:
        r20 = false;
        goto L62
    L57:
        r19 = false;
        goto L58
    L53:
        r18 = false;
        goto L54
    L49:
        r17 = false;
        goto L50
    L45:
        r16 = false;
        goto L46
    L41:
        r15 = false;
        goto L42
    L37:
        r14 = false;
        goto L38
    L33:
        r13 = false;
        goto L34
    L29:
        r12 = false;
        goto L30
    L21:
        r9 = false;
        goto L22
    L17:
        r8 = false;
        goto L18
    L13:
        r7 = false;
        goto L14
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public static boolean E() {
        return false;
    }

    public static boolean P() {
        return I;
    }

    public static void U(boolean r0) {
    }

    public static void Z(c r0) {
        G = r0;
    }

    private AMapLocationClientOption d(AMapLocationClientOption r3) {
        this.f482f = r3.f482f;
        this.f484h = r3.f484h;
        this.m = r3.m;
        this.f485i = r3.f485i;
        this.n = r3.n;
        this.o = r3.o;
        this.A = r3.A;
        this.f486j = r3.f486j;
        this.f487k = r3.f487k;
        this.f483g = r3.f483g;
        this.p = r3.p;
        this.q = r3.q;
        this.r = r3.r;
        this.s = r3.R();
        this.t = r3.T();
        this.u = r3.u;
        Z(r3.C());
        this.w = r3.w;
        U(E());
        this.C = r3.C;
        this.D = r3.D;
        d0(P());
        e0(r3.D());
        this.v = r3.v;
        this.z = r3.j();
        this.x = r3.h();
        this.y = r3.i();
        this.B = r3.Q();
        return this;
    }

    public static void d0(boolean r0) {
        I = r0;
    }

    public static void e0(long r0) {
        f481J = r0;
    }

    public static String f() {
        return H;
    }

    public b B() {
        return this.m;
    }

    public c C() {
        return G;
    }

    public long D() {
        return f481J;
    }

    public boolean F() {
        return this.o;
    }

    public boolean G() {
        return this.n;
    }

    public boolean H() {
        return this.q;
    }

    public boolean K() {
        return this.f485i;
    }

    public boolean L() {
        return this.f486j;
    }

    public boolean M() {
        return this.p;
    }

    public boolean N() {
        return this.f484h;
    }

    public boolean O() {
        return this.r;
    }

    public boolean Q() {
        return this.B;
    }

    public boolean R() {
        return this.s;
    }

    public boolean S() {
        return this.f487k;
    }

    public boolean T() {
        return this.t;
    }

    public AMapLocationClientOption V(long r1) {
        this.f483g = r1;
        return this;
    }

    public AMapLocationClientOption W(long r4) {
        if (r4 > 800) goto L5;
        r4 = 800;
    L5:
        this.f482f = r4;
        return this;
    }

    public AMapLocationClientOption X(boolean r1) {
        this.q = r1;
        return this;
    }

    public AMapLocationClientOption Y(b r1) {
        this.m = r1;
        return this;
    }

    public AMapLocationClientOption a0(boolean r1) {
        this.f486j = r1;
        return this;
    }

    public AMapLocationClientOption c0(boolean r1) {
        this.f484h = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return e();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AMapLocationClientOption e() {
        super.clone();     // Catch: Throwable -> L4
    L6:
        AMapLocationClientOption r0 = new AMapLocationClientOption();
        r0.d(this);
        return r0;
    L4:
        th = move-exception;
        th.printStackTrace();
        goto L6
    }

    public boolean h() {
        return this.x;
    }

    public int i() {
        return this.y;
    }

    public int j() {
        return this.z;
    }

    public float p() {
        return this.C;
    }

    public e q() {
        return this.w;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f482f) + "#isOnceLocation:" + String.valueOf(this.f484h) + "#locationMode:" + String.valueOf(this.m) + "#locationProtocol:" + String.valueOf(G) + "#isMockEnable:" + String.valueOf(this.f485i) + "#isKillProcess:" + String.valueOf(this.n) + "#isGpsFirst:" + String.valueOf(this.o) + "#isBeidouFirst:" + String.valueOf(this.A) + "#isSelfStartServiceEnable:" + String.valueOf(this.B) + "#isNeedAddress:" + String.valueOf(this.f486j) + "#isWifiActiveScan:" + String.valueOf(this.f487k) + "#wifiScan:" + String.valueOf(this.t) + "#httpTimeOut:" + String.valueOf(this.f483g) + "#isLocationCacheEnable:" + String.valueOf(this.q) + "#isOnceLocationLatest:" + String.valueOf(this.r) + "#sensorEnable:" + String.valueOf(this.s) + "#geoLanguage:" + String.valueOf(this.w) + "#locationPurpose:" + String.valueOf(this.D) + "#callback:" + String.valueOf(this.x) + "#time:" + String.valueOf(this.y) + "#";
    }

    public long v() {
        return this.v;
    }

    public long w() {
        return this.f483g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeLong(this.f482f);
        r4.writeLong(this.f483g);
        r4.writeByte(this.f484h ? 1 : 0);
        r4.writeByte(this.f485i ? 1 : 0);
        r4.writeByte(this.f486j ? 1 : 0);
        r4.writeByte(this.f487k ? 1 : 0);
        r4.writeByte(this.f488l ? 1 : 0);
        b r6 = this.m;
        int r0 = -1;
        if (r6 != null) goto L5;
        int r7 = -1;
    L6:
        r4.writeInt(r7);
        r4.writeByte(this.n ? 1 : 0);
        r4.writeByte(this.o ? 1 : 0);
        r4.writeByte(this.A ? 1 : 0);
        r4.writeByte(this.B ? 1 : 0);
        r4.writeByte(this.p ? 1 : 0);
        r4.writeByte(this.q ? 1 : 0);
        r4.writeByte(this.r ? 1 : 0);
        r4.writeByte(this.s ? 1 : 0);
        r4.writeByte(this.t ? 1 : 0);
        r4.writeLong(this.u);
        if (G != null) goto L9;
        int r8 = -1;
    L10:
        r4.writeInt(r8);
        e r9 = this.w;
        if (r9 != null) goto L13;
        int r10 = -1;
    L14:
        r4.writeInt(r10);
        r4.writeFloat(this.C);
        d r11 = this.D;
        if (r11 == null) goto L18;
        r0 = r11.ordinal();
    L18:
        r4.writeInt(r0);
        r4.writeInt(I ? 1 : 0);
        r4.writeLong(this.v);
        return;
    L13:
        r10 = r9.ordinal();
        goto L14
    L9:
        r8 = C().ordinal();
        goto L10
    L5:
        r7 = r6.ordinal();
        goto L6
    }

    public long y() {
        return this.f482f;
    }

    public long z() {
        return this.u;
    }
}
