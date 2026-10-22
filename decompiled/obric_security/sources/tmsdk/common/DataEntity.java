package tmsdk.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public final class DataEntity implements Parcelable {
    public static final Parcelable.Creator<DataEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f37a;
    private int b;

    class a implements Parcelable.Creator {
        a() {
        }

        public DataEntity a(Parcel r2) {
            return new DataEntity(r2, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public DataEntity[] a(int r1) {
            return new DataEntity[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DataEntity(int r1) {
        this.b = r1;
        this.f37a = new Bundle();
    }

    /* synthetic */ DataEntity(Parcel r1, DataEntityIA r2) {
        this(r1);
    }

    public Bundle bundle() {
        return this.f37a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int what() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.b);
        r1.writeBundle(this.f37a);
    }

    private DataEntity(Parcel r2) {
        this.b = r2.readInt();
        this.f37a = r2.readBundle();
    }
}
