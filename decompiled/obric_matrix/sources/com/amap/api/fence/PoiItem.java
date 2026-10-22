package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private double f472l;
    private String m;
    private String n;
    private String o;
    private String p;

    final class a implements Parcelable.Creator<PoiItem> {
        a() {
        }

        private static PoiItem a(Parcel r1) {
            return new PoiItem(r1);
        }

        private static PoiItem[] b(int r0) {
            return new PoiItem[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public PoiItem() {
        this.f466f = "";
        this.f467g = "";
        this.f468h = "";
        this.f469i = "";
        this.f470j = "";
        this.f471k = 0.0d;
        this.f472l = 0.0d;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
    }

    protected PoiItem(Parcel r4) {
        this.f466f = "";
        this.f467g = "";
        this.f468h = "";
        this.f469i = "";
        this.f470j = "";
        this.f471k = 0.0d;
        this.f472l = 0.0d;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.f466f = r4.readString();
        this.f467g = r4.readString();
        this.f468h = r4.readString();
        this.f469i = r4.readString();
        this.f470j = r4.readString();
        this.f471k = r4.readDouble();
        this.f472l = r4.readDouble();
        this.m = r4.readString();
        this.n = r4.readString();
        this.o = r4.readString();
        this.p = r4.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f466f);
        r3.writeString(this.f467g);
        r3.writeString(this.f468h);
        r3.writeString(this.f469i);
        r3.writeString(this.f470j);
        r3.writeDouble(this.f471k);
        r3.writeDouble(this.f472l);
        r3.writeString(this.m);
        r3.writeString(this.n);
        r3.writeString(this.o);
        r3.writeString(this.p);
    }
}
