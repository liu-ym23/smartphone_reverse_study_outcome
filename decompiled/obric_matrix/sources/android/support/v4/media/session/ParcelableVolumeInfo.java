package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f200j;

    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        public ParcelableVolumeInfo a(Parcel r1) {
            return new ParcelableVolumeInfo(r1);
        }

        public ParcelableVolumeInfo[] b(int r1) {
            return new ParcelableVolumeInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ParcelableVolumeInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ParcelableVolumeInfo[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public ParcelableVolumeInfo(Parcel r2) {
        this.f196f = r2.readInt();
        this.f198h = r2.readInt();
        this.f199i = r2.readInt();
        this.f200j = r2.readInt();
        this.f197g = r2.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f196f);
        r1.writeInt(this.f198h);
        r1.writeInt(this.f199i);
        r1.writeInt(this.f200j);
        r1.writeInt(this.f197g);
    }
}
