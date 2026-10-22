package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f508g;

    final class a implements Parcelable.Creator<DPoint> {
        a() {
        }

        private static DPoint a(Parcel r1) {
            return new DPoint(r1);
        }

        private static DPoint[] b(int r0) {
            return new DPoint[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public DPoint() {
        this.f507f = 0.0d;
        this.f508g = 0.0d;
    }

    public DPoint(double r4, double r6) {
        this.f507f = 0.0d;
        this.f508g = 0.0d;
        if (r6 <= 180.0d) goto L6;
        r6 = 180.0d;
    L6:
        if (r6 >= (-180.0d)) goto L9;
        r6 = -180.0d;
    L9:
        if (r4 <= 90.0d) goto L12;
        r4 = 90.0d;
    L12:
        if (r4 >= (-90.0d)) goto L14;
        r4 = -90.0d;
    L14:
        this.f507f = r6;
        this.f508g = r4;
    }

    protected DPoint(Parcel r3) {
        this.f507f = 0.0d;
        this.f508g = 0.0d;
        this.f507f = r3.readDouble();
        this.f508g = r3.readDouble();
    }

    public double b() {
        return this.f508g;
    }

    public double d() {
        return this.f507f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(double r4) {
        if (r4 <= 90.0d) goto L6;
        r4 = 90.0d;
    L6:
        if (r4 >= (-90.0d)) goto L8;
        r4 = -90.0d;
    L8:
        this.f508g = r4;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof DPoint) == true) goto L5;
        return false;
    L5:
        DPoint r8 = (DPoint) r7;
        if (this.f508g == r8.f508g) goto L9;
        return false;
    L9:
        if (this.f507f == r8.f507f) goto L11;
        return false;
    L11:
        return true;
    }

    public void f(double r4) {
        if (r4 <= 180.0d) goto L6;
        r4 = 180.0d;
    L6:
        if (r4 >= (-180.0d)) goto L8;
        r4 = -180.0d;
    L8:
        this.f507f = r4;
    }

    public int hashCode() {
        return Double.valueOf((this.f508g + this.f507f) * 1000000.0d).intValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeDouble(this.f507f);
        r3.writeDouble(this.f508g);
    }
}
