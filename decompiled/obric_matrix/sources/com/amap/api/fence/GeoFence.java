package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeoFence implements Parcelable {
    public static final Parcelable.Creator<GeoFence> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PendingIntent f462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PoiItem f464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<DistrictItem> f465l;
    private List<List<DPoint>> m;
    private float n;
    private long o;
    private int p;
    private float q;
    private float r;
    private DPoint s;
    private int t;
    private long u;
    private boolean v;
    private AMapLocation w;

    final class a implements Parcelable.Creator<GeoFence> {
        a() {
        }

        private static GeoFence a(Parcel r1) {
            return new GeoFence(r1);
        }

        private static GeoFence[] b(int r0) {
            return new GeoFence[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public GeoFence() {
        this.f462i = null;
        this.f463j = 0;
        this.f464k = null;
        this.f465l = null;
        this.n = 0.0f;
        this.o = -1;
        this.p = 1;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = null;
        this.t = 0;
        this.u = -1;
        this.v = true;
        this.w = null;
    }

    protected GeoFence(Parcel r7) {
        this.f462i = null;
        boolean r1 = false;
        this.f463j = 0;
        this.f464k = null;
        this.f465l = null;
        this.n = 0.0f;
        this.o = -1;
        this.p = 1;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = null;
        this.t = 0;
        this.u = -1;
        this.v = true;
        this.w = null;
        this.f459f = r7.readString();
        this.f460g = r7.readString();
        this.f461h = r7.readString();
        this.f462i = (PendingIntent) r7.readParcelable(PendingIntent.class.getClassLoader());
        this.f463j = r7.readInt();
        this.f464k = (PoiItem) r7.readParcelable(PoiItem.class.getClassLoader());
        this.f465l = r7.createTypedArrayList(DistrictItem.CREATOR);
        this.n = r7.readFloat();
        this.o = r7.readLong();
        this.p = r7.readInt();
        this.q = r7.readFloat();
        this.r = r7.readFloat();
        this.s = (DPoint) r7.readParcelable(DPoint.class.getClassLoader());
        this.t = r7.readInt();
        this.u = r7.readLong();
        int r0 = r7.readInt();
        if (r0 == 0) goto L8;
        this.m = new ArrayList();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        this.m.add(r7.createTypedArrayList(DPoint.CREATOR));
        r2 = r2 + 1;
    L8:
        if (r7.readByte() == 0) goto L10;
        r1 = true;
    L10:
        this.v = r1;
        this.w = (AMapLocation) r7.readParcelable(AMapLocation.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof GeoFence) == true) goto L5;
        return false;
    L5:
        GeoFence r5 = (GeoFence) r4;
        if (TextUtils.isEmpty(this.f460g) == false) goto L11;
        if (TextUtils.isEmpty(r5.f460g) == true) goto L13;
        return false;
    L13:
        DPoint r0 = this.s;
        if (r0 != null) goto L19;
        if (r5.s == null) goto L22;
        return false;
    L22:
        if (this.n == r5.n) goto L24;
        return false;
    L24:
        List<List<DPoint>> r3 = this.m;
        if (r3 != null) goto L30;
        if (r5.m == null) goto L32;
        return false;
    L32:
        return true;
    L30:
        if (r3.equals(r5.m) == true) goto L34;
        return false;
    L34:
        return true;
    L19:
        if (r0.equals(r5.s) == true) goto L22;
        return false;
    L11:
        if (this.f460g.equals(r5.f460g) == true) goto L13;
        return false;
    }

    public int hashCode() {
        return ((this.f460g.hashCode() + this.m.hashCode()) + this.s.hashCode()) + ((int) (this.n * 100.0f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f459f);
        r3.writeString(this.f460g);
        r3.writeString(this.f461h);
        r3.writeParcelable(this.f462i, r4);
        r3.writeInt(this.f463j);
        r3.writeParcelable(this.f464k, r4);
        r3.writeTypedList(this.f465l);
        r3.writeFloat(this.n);
        r3.writeLong(this.o);
        r3.writeInt(this.p);
        r3.writeFloat(this.q);
        r3.writeFloat(this.r);
        r3.writeParcelable(this.s, r4);
        r3.writeInt(this.t);
        r3.writeLong(this.u);
        List<List<DPoint>> r0 = this.m;
        if (r0 != null) goto L5;
    L10:
        r3.writeByte(this.v ? 1 : 0);
        r3.writeParcelable(this.w, r4);
        return;
    L5:
        if (r0.isEmpty() == true) goto L10;
        r3.writeInt(this.m.size());
        Iterator<List<DPoint>> r1 = this.m.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r3.writeTypedList(r1.next());
        goto L8
    }
}
