package tmsdkobf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class r1 implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f464a;
    public byte[] b;
    public int c;

    public r1(Parcel r2) {
        this.f464a = r2.readInt();
        this.b = r2.createByteArray();
        this.c = r2.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f464a);
        r1.writeByteArray(this.b);
        r1.writeInt(this.c);
    }
}
