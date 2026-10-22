package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3571f;

    static class a implements Parcelable.Creator<IntegerParcelable> {
        a() {
        }

        public IntegerParcelable a(Parcel r1) {
            return new IntegerParcelable(r1);
        }

        public IntegerParcelable[] b(int r1) {
            return new IntegerParcelable[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntegerParcelable createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntegerParcelable[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public IntegerParcelable(int r1) {
        this.f3571f = r1;
    }

    protected IntegerParcelable(Parcel r1) {
        this.f3571f = r1.readInt();
    }

    public int b() {
        return this.f3571f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f3571f);
    }
}
