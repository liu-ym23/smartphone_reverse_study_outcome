package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<DPoint> f458i;

    final class a implements Parcelable.Creator<DistrictItem> {
        a() {
        }

        private static DistrictItem a(Parcel r1) {
            return new DistrictItem(r1);
        }

        private static DistrictItem[] b(int r0) {
            return new DistrictItem[r0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public DistrictItem() {
        this.f455f = "";
        this.f456g = null;
        this.f457h = null;
        this.f458i = null;
    }

    protected DistrictItem(Parcel r2) {
        this.f455f = "";
        this.f456g = null;
        this.f457h = null;
        this.f458i = null;
        this.f455f = r2.readString();
        this.f456g = r2.readString();
        this.f457h = r2.readString();
        this.f458i = r2.createTypedArrayList(DPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.f455f);
        r1.writeString(this.f456g);
        r1.writeString(this.f457h);
        r1.writeTypedList(this.f458i);
    }
}
