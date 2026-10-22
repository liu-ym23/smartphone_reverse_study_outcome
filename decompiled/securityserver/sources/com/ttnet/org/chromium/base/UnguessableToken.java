package com.ttnet.org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = null;
    private final long mHigh;
    private final long mLow;

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ UnguessableToken(long r1, long r3, AnonymousClass1 r5) {
        this(r1, r3);
    }

    @CalledByNative
    private static UnguessableToken create(long r1, long r3) {
        return new UnguessableToken(r1, r3);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel r0 = Parcel.obtain();
        writeToParcel(r0, 0);
        r0.setDataPosition(0);
        UnguessableToken r2 = CREATOR.createFromParcel(r0);
        r0.recycle();
        return r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r6) {
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

    @CalledByNative
    public long getHighForSerialization() {
        return this.mHigh;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.mLow;
    }

    public int hashCode() {
        long r0 = this.mLow;
        int r1 = (int) (r0 ^ (r0 >>> 32));
        long r3 = this.mHigh;
        int r2 = r1 * 31;
        return r2 + ((int) ((r3 >>> 32) ^ r3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mHigh);
        r3.writeLong(this.mLow);
    }

    private UnguessableToken(long r1, long r3) {
        this.mHigh = r1;
        this.mLow = r3;
    }
}
