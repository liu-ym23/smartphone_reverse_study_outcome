package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.loc.a5;
import com.loc.s4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocation> CREATOR = null;
    private Bundle A;
    private String B;
    private int C;
    private String D;
    private int E;
    private boolean F;
    private String G;
    private boolean H;
    protected String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected String f473J;
    c K;
    private String L;
    private int M;
    private int N;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f478j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f479k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f480l;
    private String m;
    private String n;
    private String o;
    private String p;
    private boolean q;
    private int r;
    private String s;
    private String t;
    private int u;
    private double v;
    private double w;
    private double x;
    private float y;
    private float z;

    final class a implements Parcelable.Creator<AMapLocation> {
        a() {
        }

        private static AMapLocation a(Parcel r6) {
            AMapLocation r1 = new AMapLocation((Location) Location.CREATOR.createFromParcel(r6));
            AMapLocation.f(r1, r6.readString());
            AMapLocation.p(r1, r6.readString());
            AMapLocation.w(r1, r6.readString());
            r1.I = r6.readString();
            AMapLocation.C(r1, r6.readString());
            AMapLocation.E(r1, r6.readString());
            AMapLocation.G(r1, r6.readString());
            AMapLocation.H(r1, r6.readString());
            AMapLocation.e(r1, r6.readInt());
            AMapLocation.i0(r1, r6.readString());
            r1.f473J = r6.readString();
            boolean r2 = true;
            if (r6.readInt() == 0) goto L5;
            boolean r0 = true;
        L6:
            AMapLocation.h(r1, r0);
            if (r6.readInt() == 0) goto L9;
            boolean r3 = true;
        L10:
            AMapLocation.q(r1, r3);
            AMapLocation.d(r1, r6.readDouble());
            AMapLocation.j0(r1, r6.readString());
            AMapLocation.j(r1, r6.readInt());
            AMapLocation.i(r1, r6.readDouble());
            if (r6.readInt() != 0) goto L14;
            r2 = false;
        L14:
            AMapLocation.y(r1, r2);
            AMapLocation.m0(r1, r6.readString());
            AMapLocation.n0(r1, r6.readString());
            AMapLocation.o0(r1, r6.readString());
            AMapLocation.p0(r1, r6.readString());
            AMapLocation.v(r1, r6.readInt());
            AMapLocation.B(r1, r6.readInt());
            AMapLocation.q0(r1, r6.readString());
            AMapLocation.r0(r1, r6.readString());
            AMapLocation.s0(r1, r6.readString());
            AMapLocation.D(r1, r6.readInt());
            AMapLocation.F(r1, r6.readInt());
            return r1;
        L9:
            r3 = false;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        private static AMapLocation[] b(int r0) {
            return new AMapLocation[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public AMapLocation(Location r6) {
        super(r6);
        this.f474f = "";
        this.f475g = "";
        this.f476h = "";
        this.f477i = "";
        this.f478j = "";
        this.f479k = "";
        this.f480l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = true;
        this.r = 0;
        this.s = "success";
        this.t = "";
        this.u = 0;
        this.v = 0.0d;
        this.w = 0.0d;
        this.x = 0.0d;
        this.y = 0.0f;
        this.z = 0.0f;
        Bundle r3 = null;
        this.A = null;
        this.C = 0;
        this.D = "";
        this.E = -1;
        this.F = false;
        this.G = "";
        this.H = false;
        this.I = "";
        this.f473J = "";
        this.K = new c();
        this.L = "GCJ02";
        this.M = 1;
        this.v = r6.getLatitude();
        this.w = r6.getLongitude();
        this.x = r6.getAltitude();
        this.z = r6.getBearing();
        this.y = r6.getSpeed();
        this.B = r6.getProvider();
        if (r6.getExtras() == null) goto L6;
        r3 = new Bundle(r6.getExtras());
    L6:
        this.A = r3;
    }

    public AMapLocation(String r6) {
        super(r6);
        this.f474f = "";
        this.f475g = "";
        this.f476h = "";
        this.f477i = "";
        this.f478j = "";
        this.f479k = "";
        this.f480l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = true;
        this.r = 0;
        this.s = "success";
        this.t = "";
        this.u = 0;
        this.v = 0.0d;
        this.w = 0.0d;
        this.x = 0.0d;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = null;
        this.C = 0;
        this.D = "";
        this.E = -1;
        this.F = false;
        this.G = "";
        this.H = false;
        this.I = "";
        this.f473J = "";
        this.K = new c();
        this.L = "GCJ02";
        this.M = 1;
        this.B = r6;
    }

    static /* synthetic */ int B(AMapLocation r0, int r1) {
        r0.E = r1;
        return r1;
    }

    static /* synthetic */ String C(AMapLocation r0, String r1) {
        r0.f475g = r1;
        return r1;
    }

    static /* synthetic */ int D(AMapLocation r0, int r1) {
        r0.M = r1;
        return r1;
    }

    static /* synthetic */ String E(AMapLocation r0, String r1) {
        r0.f477i = r1;
        return r1;
    }

    static /* synthetic */ int F(AMapLocation r0, int r1) {
        r0.N = r1;
        return r1;
    }

    static /* synthetic */ String G(AMapLocation r0, String r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ String H(AMapLocation r0, String r1) {
        r0.f476h = r1;
        return r1;
    }

    static /* synthetic */ double d(AMapLocation r0, double r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ int e(AMapLocation r0, int r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ String f(AMapLocation r0, String r1) {
        r0.f478j = r1;
        return r1;
    }

    static /* synthetic */ boolean h(AMapLocation r0, boolean r1) {
        r0.H = r1;
        return r1;
    }

    static /* synthetic */ double i(AMapLocation r0, double r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ String i0(AMapLocation r0, String r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ int j(AMapLocation r0, int r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ String j0(AMapLocation r0, String r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ String m0(AMapLocation r0, String r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ String n0(AMapLocation r0, String r1) {
        r0.f480l = r1;
        return r1;
    }

    static /* synthetic */ String o0(AMapLocation r0, String r1) {
        r0.f474f = r1;
        return r1;
    }

    static /* synthetic */ String p(AMapLocation r0, String r1) {
        r0.f479k = r1;
        return r1;
    }

    static /* synthetic */ String p0(AMapLocation r0, String r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ boolean q(AMapLocation r0, boolean r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ String q0(AMapLocation r0, String r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ String r0(AMapLocation r0, String r1) {
        r0.G = r1;
        return r1;
    }

    static /* synthetic */ String s0(AMapLocation r0, String r1) {
        r0.L = r1;
        return r1;
    }

    static /* synthetic */ int v(AMapLocation r0, int r1) {
        r0.C = r1;
        return r1;
    }

    static /* synthetic */ String w(AMapLocation r0, String r1) {
        r0.D = r1;
        return r1;
    }

    static /* synthetic */ boolean y(AMapLocation r0, boolean r1) {
        r0.F = r1;
        return r1;
    }

    public void A0(String r1) {
        this.L = r1;
    }

    public void B0(String r1) {
        this.m = r1;
    }

    public void C0(String r1) {
        this.G = r1;
    }

    public void D0(String r1) {
        this.f476h = r1;
    }

    public void E0(int r2) {
        if (this.r == 0) goto L5;
        return;
    L5:
        this.s = a5.h(r2);
        this.r = r2;
    }

    public void F0(String r1) {
        this.s = r1;
    }

    public void G0(boolean r1) {
        this.H = r1;
    }

    public void H0(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r4 = r4.replace("F", "");
        Integer.parseInt(r4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        s4.h(th, "AmapLoc", "setFloor");
        r4 = null;
    L9:
        this.f473J = r4;
    }

    public void I0(int r1) {
        this.E = r1;
    }

    public void J0(String r1) {
        this.t = r1;
    }

    public String K() {
        return this.f478j;
    }

    public void K0(c r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.K = r1;
    }

    public String L() {
        return this.f479k;
    }

    public void L0(int r1) {
        this.u = r1;
    }

    public String M() {
        return this.D;
    }

    public void M0(String r1) {
        this.p = r1;
    }

    public String N() {
        return this.I;
    }

    public void N0(boolean r1) {
        this.q = r1;
    }

    public String O() {
        return this.f475g;
    }

    public void O0(String r1) {
        this.f480l = r1;
    }

    public String P() {
        return this.f477i;
    }

    public void P0(String r1) {
        this.f474f = r1;
    }

    public String Q() {
        return this.L;
    }

    public void Q0(String r1) {
        this.n = r1;
    }

    public String R() {
        return this.m;
    }

    public void R0(int r1) {
        this.C = r1;
    }

    public String S() {
        return this.G;
    }

    public void S0(String r1) {
        this.o = r1;
    }

    public String T() {
        return this.f476h;
    }

    public void T0(int r1) {
        this.M = r1;
    }

    public int U() {
        return this.r;
    }

    public JSONObject U0(int r4) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L15
        if (r4 != 1) goto L6;
        r0.put("altitude", getAltitude());     // Catch: Throwable -> L18
        r0.put("speed", getSpeed());     // Catch: Throwable -> L18
        r0.put("bearing", getBearing());     // Catch: Throwable -> L18
    L11:
        r0.put("citycode", this.f477i);     // Catch: Throwable -> L15
        r0.put("adcode", this.f478j);     // Catch: Throwable -> L15
        r0.put("country", this.m);     // Catch: Throwable -> L15
        r0.put("province", this.f474f);     // Catch: Throwable -> L15
        r0.put("city", this.f475g);     // Catch: Throwable -> L15
        r0.put("district", this.f476h);     // Catch: Throwable -> L15
        r0.put("road", this.n);     // Catch: Throwable -> L15
        r0.put("street", this.o);     // Catch: Throwable -> L15
        r0.put("number", this.p);     // Catch: Throwable -> L15
        r0.put("poiname", this.f480l);     // Catch: Throwable -> L15
        r0.put("errorCode", this.r);     // Catch: Throwable -> L15
        r0.put("errorInfo", this.s);     // Catch: Throwable -> L15
        r0.put("locationType", this.u);     // Catch: Throwable -> L15
        r0.put("locationDetail", this.t);     // Catch: Throwable -> L15
        r0.put("aoiname", this.D);     // Catch: Throwable -> L15
        r0.put("address", this.f479k);     // Catch: Throwable -> L15
        r0.put("poiid", this.I);     // Catch: Throwable -> L15
        r0.put("floor", this.f473J);     // Catch: Throwable -> L15
        r0.put("description", this.G);     // Catch: Throwable -> L15
    L12:
        r0.put("time", getTime());     // Catch: Throwable -> L15
    L13:
        r0.put("provider", getProvider());     // Catch: Throwable -> L15
        r0.put("lon", getLongitude());     // Catch: Throwable -> L15
        r0.put("lat", getLatitude());     // Catch: Throwable -> L15
        r0.put(LocationMonitorConst.ACCURACY, getAccuracy());     // Catch: Throwable -> L15
        r0.put("isOffset", this.q);     // Catch: Throwable -> L15
        r0.put("isFixLastLocation", this.H);     // Catch: Throwable -> L15
        r0.put("coordType", this.L);     // Catch: Throwable -> L15
        return r0;
    L6:
        if (r4 == 2) goto L12;
        if (r4 == 3) goto L13;
        return r0;
    L15:
        th = move-exception;
        s4.h(th, "AmapLoc", "toStr");
        return null;
    }

    public String V() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.s);
        if (this.r == 0) goto L6;
        r0.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
        r0.append(",错误详细信息:" + this.t);
    L6:
        return r0.toString();
    }

    public String V0() {
        return W0(1);
    }

    public String W() {
        return this.f473J;
    }

    public String W0(int r3) {
        JSONObject r2 = U0(r3);     // Catch: Throwable -> L5
    L7:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.toString();
    L5:
        th = move-exception;
        s4.h(th, "AMapLocation", "toStr part2");
        r2 = null;
        goto L7
    }

    public String X() {
        return this.t;
    }

    public int Y() {
        return this.u;
    }

    public String Z() {
        return this.f480l;
    }

    public String a0() {
        return this.f474f;
    }

    public String c0() {
        return this.n;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return z();
    }

    public int d0() {
        return this.C;
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e0() {
        return this.o;
    }

    public String g0() {
        return this.p;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.x;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.z;
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.A;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.v;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.w;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.B;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.y;
    }

    public int h0() {
        return this.M;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.F;
    }

    public boolean k0() {
        return this.H;
    }

    public boolean l0() {
        return this.q;
    }

    @Override // android.location.Location
    public void setAltitude(double r1) {
        super.setAltitude(r1);
        this.x = r1;
    }

    @Override // android.location.Location
    public void setBearing(float r3) {
        super.setBearing(r3);
    L4:
        if (r3 >= 0.0f) goto L7;
        r3 = r3 + 360.0f;
    L7:
        if (r3 < 360.0f) goto L9;
        r3 = r3 - 360.0f;
        goto L7
    L9:
        this.z = r3;
    }

    @Override // android.location.Location
    public void setExtras(Bundle r2) {
        super.setExtras(r2);
        if (r2 != null) goto L5;
        Bundle r3 = null;
    L6:
        this.A = r3;
        return;
    L5:
        r3 = new Bundle(r2);
        goto L6
    }

    @Override // android.location.Location
    public void setLatitude(double r1) {
        this.v = r1;
    }

    @Override // android.location.Location
    public void setLongitude(double r1) {
        this.w = r1;
    }

    @Override // android.location.Location
    public void setMock(boolean r1) {
        this.F = r1;
    }

    @Override // android.location.Location
    public void setProvider(String r1) {
        super.setProvider(r1);
        this.B = r1;
    }

    @Override // android.location.Location
    public void setSpeed(float r1) {
        super.setSpeed(r1);
        this.y = r1;
    }

    public void t0(String r1) {
        this.f478j = r1;
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer r1 = new StringBuffer();
        r1.append("latitude=" + this.v + "#");     // Catch: Throwable -> L6
        r1.append("longitude=" + this.w + "#");     // Catch: Throwable -> L6
        r1.append("province=" + this.f474f + "#");     // Catch: Throwable -> L6
        r1.append("coordType=" + this.L + "#");     // Catch: Throwable -> L6
        r1.append("city=" + this.f475g + "#");     // Catch: Throwable -> L6
        r1.append("district=" + this.f476h + "#");     // Catch: Throwable -> L6
        r1.append("cityCode=" + this.f477i + "#");     // Catch: Throwable -> L6
        r1.append("adCode=" + this.f478j + "#");     // Catch: Throwable -> L6
        r1.append("address=" + this.f479k + "#");     // Catch: Throwable -> L6
        r1.append("country=" + this.m + "#");     // Catch: Throwable -> L6
        r1.append("road=" + this.n + "#");     // Catch: Throwable -> L6
        r1.append("poiName=" + this.f480l + "#");     // Catch: Throwable -> L6
        r1.append("street=" + this.o + "#");     // Catch: Throwable -> L6
        r1.append("streetNum=" + this.p + "#");     // Catch: Throwable -> L6
        r1.append("aoiName=" + this.D + "#");     // Catch: Throwable -> L6
        r1.append("poiid=" + this.I + "#");     // Catch: Throwable -> L6
        r1.append("floor=" + this.f473J + "#");     // Catch: Throwable -> L6
        r1.append("errorCode=" + this.r + "#");     // Catch: Throwable -> L6
        r1.append("errorInfo=" + this.s + "#");     // Catch: Throwable -> L6
        r1.append("locationDetail=" + this.t + "#");     // Catch: Throwable -> L6
        r1.append("description=" + this.G + "#");     // Catch: Throwable -> L6
        r1.append("locationType=" + this.u + "#");     // Catch: Throwable -> L6
        StringBuilder r0 = new StringBuilder("conScenario=");     // Catch: Throwable -> L6
        r0.append(this.N);     // Catch: Throwable -> L6
        r1.append(r0.toString());     // Catch: Throwable -> L6
    L5:
        return r1.toString();
    }

    public void u0(String r1) {
        this.f479k = r1;
    }

    public void v0(String r1) {
        this.D = r1;
    }

    public void w0(String r1) {
        this.I = r1;
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        super.writeToParcel(r5, r6);     // Catch: Throwable -> L16
        r5.writeString(this.f478j);     // Catch: Throwable -> L16
        r5.writeString(this.f479k);     // Catch: Throwable -> L16
        r5.writeString(this.D);     // Catch: Throwable -> L16
        r5.writeString(this.I);     // Catch: Throwable -> L16
        r5.writeString(this.f475g);     // Catch: Throwable -> L16
        r5.writeString(this.f477i);     // Catch: Throwable -> L16
        r5.writeString(this.m);     // Catch: Throwable -> L16
        r5.writeString(this.f476h);     // Catch: Throwable -> L16
        r5.writeInt(this.r);     // Catch: Throwable -> L16
        r5.writeString(this.s);     // Catch: Throwable -> L16
        r5.writeString(this.f473J);     // Catch: Throwable -> L16
        int r0 = 1;
        if (this.H == false) goto L5;
        int r7 = 1;
    L6:
        r5.writeInt(r7);     // Catch: Throwable -> L16
        if (this.q == false) goto L9;
        int r8 = 1;
    L10:
        r5.writeInt(r8);     // Catch: Throwable -> L16
        r5.writeDouble(this.v);     // Catch: Throwable -> L16
        r5.writeString(this.t);     // Catch: Throwable -> L16
        r5.writeInt(this.u);     // Catch: Throwable -> L16
        r5.writeDouble(this.w);     // Catch: Throwable -> L16
        if (this.F == true) goto L14;
        r0 = 0;
    L14:
        r5.writeInt(r0);     // Catch: Throwable -> L16
        r5.writeString(this.p);     // Catch: Throwable -> L16
        r5.writeString(this.f480l);     // Catch: Throwable -> L16
        r5.writeString(this.f474f);     // Catch: Throwable -> L16
        r5.writeString(this.n);     // Catch: Throwable -> L16
        r5.writeInt(this.C);     // Catch: Throwable -> L16
        r5.writeInt(this.E);     // Catch: Throwable -> L16
        r5.writeString(this.o);     // Catch: Throwable -> L16
        r5.writeString(this.G);     // Catch: Throwable -> L16
        r5.writeString(this.L);     // Catch: Throwable -> L16
        r5.writeInt(this.M);     // Catch: Throwable -> L16
        r5.writeInt(this.N);     // Catch: Throwable -> L16
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        r7 = 0;
    L16:
        th = move-exception;
        s4.h(th, "AMapLocation", "writeToParcel");
    }

    public void x0(String r1) {
        this.f475g = r1;
    }

    public void y0(String r1) {
        this.f477i = r1;
    }

    public AMapLocation z() {
        super.clone();     // Catch: Throwable -> L12
    L3:
        AMapLocation r0 = new AMapLocation(this);
        r0.setLatitude(this.v);     // Catch: Throwable -> L9
        r0.setLongitude(this.w);     // Catch: Throwable -> L9
        r0.t0(this.f478j);     // Catch: Throwable -> L9
        r0.u0(this.f479k);     // Catch: Throwable -> L9
        r0.v0(this.D);     // Catch: Throwable -> L9
        r0.w0(this.I);     // Catch: Throwable -> L9
        r0.x0(this.f475g);     // Catch: Throwable -> L9
        r0.y0(this.f477i);     // Catch: Throwable -> L9
        r0.B0(this.m);     // Catch: Throwable -> L9
        r0.D0(this.f476h);     // Catch: Throwable -> L9
        r0.E0(this.r);     // Catch: Throwable -> L9
        r0.F0(this.s);     // Catch: Throwable -> L9
        r0.H0(this.f473J);     // Catch: Throwable -> L9
        r0.G0(this.H);     // Catch: Throwable -> L9
        r0.N0(this.q);     // Catch: Throwable -> L9
        r0.J0(this.t);     // Catch: Throwable -> L9
        r0.L0(this.u);     // Catch: Throwable -> L9
        r0.setMock(this.F);     // Catch: Throwable -> L9
        r0.M0(this.p);     // Catch: Throwable -> L9
        r0.O0(this.f480l);     // Catch: Throwable -> L9
        r0.P0(this.f474f);     // Catch: Throwable -> L9
        r0.Q0(this.n);     // Catch: Throwable -> L9
        r0.R0(this.C);     // Catch: Throwable -> L9
        r0.I0(this.E);     // Catch: Throwable -> L9
        r0.S0(this.o);     // Catch: Throwable -> L9
        r0.C0(this.G);     // Catch: Throwable -> L9
        r0.setExtras(getExtras());     // Catch: Throwable -> L9
        c r1 = this.K;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r0.K0(r1.a());     // Catch: Throwable -> L9
    L7:
        r0.A0(this.L);     // Catch: Throwable -> L9
        r0.T0(this.M);     // Catch: Throwable -> L9
        r0.z0(this.N);     // Catch: Throwable -> L9
    L11:
        return r0;
    L9:
        th = move-exception;
        s4.h(th, "AMapLocation", "clone");
        goto L11
    }

    public void z0(int r1) {
        this.N = r1;
    }
}
