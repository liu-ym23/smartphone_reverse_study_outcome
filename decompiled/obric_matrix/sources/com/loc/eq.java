package com.loc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class eq implements Parcelable {
    public static final Parcelable.Creator<eq> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f7277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f7278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f7279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f7281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f7282l;
    private String m;
    private String n;
    private String o;

    final class a implements Parcelable.Creator<eq> {
        a() {
        }

        private static eq a(Parcel r3) {
            eq r0 = new eq();
            r0.l(r3.readString());
            r0.s(r3.readString());
            r0.w(r3.readString());
            r0.y(r3.readString());
            r0.h(r3.readString());
            r0.j(r3.readLong());
            r0.q(r3.readLong());
            r0.d(r3.readLong());
            r0.g(r3.readLong());
            r0.e(r3.readString());
            return r0;
        }

        private static eq[] b(int r0) {
            return new eq[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eq createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eq[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public eq() {
        this.f7276f = 0;
        this.f7277g = 0;
        this.f7278h = 0;
        this.f7279i = 0;
        this.f7282l = "first";
        this.m = "";
        this.n = "";
        this.o = null;
    }

    public final long A() {
        long r0 = this.f7277g;
        long r2 = this.f7276f;
        if (r0 > r2) goto L7;
        return 0;
    L7:
        return r0 - r2;
    }

    public final long b() {
        long r0 = this.f7279i;
        long r2 = this.f7278h;
        if ((r0 - r2) > 0) goto L6;
        return 0;
    L6:
        return r0 - r2;
    }

    public final void d(long r1) {
        this.f7278h = r1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(String r1) {
        this.n = r1;
    }

    public final String f() {
        return this.n;
    }

    public final void g(long r1) {
        this.f7279i = r1;
    }

    public final void h(String r1) {
        this.o = r1;
    }

    public final String i() {
        return this.o;
    }

    public final void j(long r1) {
        this.f7276f = r1;
    }

    public final void l(String r1) {
        this.f7280j = r1;
    }

    public final String p() {
        return this.f7280j;
    }

    public final void q(long r1) {
        this.f7277g = r1;
    }

    public final void s(String r1) {
        this.f7281k = r1;
    }

    public final String v() {
        return this.f7281k;
    }

    public final void w(String r1) {
        this.f7282l = r1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f7280j);     // Catch: Throwable -> L4
        r3.writeString(this.f7281k);     // Catch: Throwable -> L4
        r3.writeString(this.f7282l);     // Catch: Throwable -> L4
        r3.writeString(this.m);     // Catch: Throwable -> L4
        r3.writeString(this.o);     // Catch: Throwable -> L4
        r3.writeLong(this.f7276f);     // Catch: Throwable -> L4
        r3.writeLong(this.f7277g);     // Catch: Throwable -> L4
        r3.writeLong(this.f7278h);     // Catch: Throwable -> L4
        r3.writeLong(this.f7279i);     // Catch: Throwable -> L4
        r3.writeString(this.n);     // Catch: Throwable -> L4
        return;
    }

    public final String x() {
        return this.f7282l;
    }

    public final void y(String r1) {
        this.m = r1;
    }

    public final String z() {
        return this.m;
    }
}
