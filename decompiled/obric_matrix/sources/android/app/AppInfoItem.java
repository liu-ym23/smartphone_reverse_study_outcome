package android.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AppInfoItem implements Parcelable {
    public static final Parcelable.Creator<AppInfoItem> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f95f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f96g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f97h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f98i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f99j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f100k;

    class a implements Parcelable.Creator<AppInfoItem> {
        a() {
        }

        public AppInfoItem a(Parcel r1) {
            return new AppInfoItem(r1);
        }

        public AppInfoItem[] b(int r1) {
            return new AppInfoItem[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoItem createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoItem[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public AppInfoItem() {
    }

    protected AppInfoItem(Parcel r3) {
        this.f95f = r3.readString();
        this.f96g = r3.readString();
        this.f97h = r3.readInt();
        this.f98i = r3.readLong();
        this.f99j = r3.readString();
        if (r3.readInt() == 0) goto L5;
        boolean r4 = true;
    L6:
        this.f100k = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f95f);
        r3.writeString(this.f96g);
        r3.writeInt(this.f97h);
        r3.writeLong(this.f98i);
        r3.writeString(this.f99j);
        r3.writeInt(this.f100k ? 1 : 0);
    }
}
