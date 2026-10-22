package tmsdkobf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class eb implements Parcelable {
    public static final Parcelable.Creator<eb> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f177a;
    public int b;
    public long c;
    public ArrayList d;
    public ArrayList e;
    public String f;

    class a implements Parcelable.Creator {
        a() {
        }

        public eb a(Parcel r3) {
            eb r2 = new eb();
            r2.f177a = r3.readInt();
            r2.b = r3.readInt();
            r2.c = r3.readLong();
            r2.d = r3.createStringArrayList();
            r2.e = r3.createStringArrayList();
            r2.f = r3.readString();
            return r2;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return a(r1);
        }

        public eb[] a(int r1) {
            return new eb[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public eb() {
        this.f177a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.f177a);
        r3.writeInt(this.b);
        r3.writeLong(this.c);
        r3.writeStringList(this.d);
        r3.writeStringList(this.e);
        r3.writeString(this.f);
    }
}
