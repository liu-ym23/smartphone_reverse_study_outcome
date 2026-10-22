package com.ttnet.org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = null;
    private final long mHigh;
    private final long mLow;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ UnguessableToken(long r1, long r3, AnonymousClass1 r5) {
        this(r1, r3);
    }

    private UnguessableToken(long r1, long r3) {
        this.mHigh = r1;
        this.mLow = r3;
    }

    private static UnguessableToken create(long r1, long r3) {
        return new UnguessableToken(r1, r3);
    }

    public long getHighForSerialization() {
        return this.mHigh;
    }

    public long getLowForSerialization() {
        return this.mLow;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mHigh);
        r3.writeLong(this.mLow);
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if (getClass() != r6.getClass()) goto L16;
        UnguessableToken r7 = (UnguessableToken) r6;
        if (r7.mHigh == this.mHigh) goto L10;
        return false;
    L10:
        if (r7.mLow != this.mLow) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        long r0 = this.mLow;
        int r1 = (int) (r0 ^ (r0 >>> 32));
        long r3 = this.mHigh;
        int r2 = r1 * 31;
        return r2 + ((int) ((r3 >>> 32) ^ r3));
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel r0 = Parcel.obtain();
        writeToParcel(r0, 0);
        r0.setDataPosition(0);
        UnguessableToken r2 = CREATOR.createFromParcel(r0);
        r0.recycle();
        return r2;
    }
}
