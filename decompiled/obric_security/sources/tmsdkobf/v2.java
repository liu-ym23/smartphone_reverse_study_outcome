package tmsdkobf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public interface v2 {

    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f564a;
        public long b;
        public r2 c;
        public c d;

        /* JADX INFO: renamed from: tmsdkobf.v2$a$a, reason: collision with other inner class name */
        class C0109a implements Parcelable.Creator {
            C0109a() {
            }

            public a a(Parcel r1) {
                return a.m2453$$Nest$sma(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r1) {
                return a(r1);
            }

            public a[] a(int r1) {
                return new a[r1];
            }
        }

        /* JADX INFO: renamed from: -$$Nest$sma, reason: not valid java name */
        static /* bridge */ /* synthetic */ a m2453$$Nest$sma(Parcel r0) {
            return a(r0);
        }

        static {
            CREATOR = new C0109a();
        }

        public a(long r1, long r3, r2 r5) {
            this.f564a = r1;
            this.b = r3;
            this.c = r5;
        }

        private static r2 a(byte[] r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (r2.length != 0) goto L7;
            return null;
        L7:
            return (r2) z7.a(r2, new r2(), false);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeLong(this.f564a);
            r3.writeLong(this.b);
            byte[] r5 = a(this.c);
            r3.writeInt(r5.length);
            if (r5.length <= 0) goto L6;
            r3.writeByteArray(r5);
        L6:
            if (this.d == null) goto L8;
            r3.writeByte((byte) 1);
            r3.writeInt(this.d.f566a);
            r3.writeInt(this.d.b);
            return;
        L8:
            r3.writeByte((byte) 0);
        }

        private static byte[] a(r2 r1) {
            byte[] r0 = new byte[0];
            if (r1 != null) goto L6;
            return r0;
        L6:
            return z7.a(r1);
        }

        private static a a(Parcel r7) {
            long r1 = r7.readLong();
            long r3 = r7.readLong();
            int r0 = r7.readInt();
            if (r0 <= 0) goto L5;
            byte[] r2 = new byte[r0];
            r7.readByteArray(r2);
        L6:
            a r6 = new a(r1, r3, a(r2));
            if (r7.readByte() != 1) goto L9;
            r6.d = new c(r7.readInt(), r7.readInt());
        L9:
            return r6;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f565a;

        public b() {
            this.f565a = 0;
        }

        public abstract void a(a r1);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f566a;
        public int b;

        public c(int r1, int r2) {
            this.f566a = r1;
            this.b = r2;
        }
    }

    void a(int r1, b r2);

    void a(a r1, int r2, int r3);
}
