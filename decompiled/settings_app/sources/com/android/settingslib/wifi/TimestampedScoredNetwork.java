package com.android.settingslib.wifi;

import android.net.ScoredNetwork;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
class TimestampedScoredNetwork implements Parcelable {
    public static final Parcelable.Creator<TimestampedScoredNetwork> CREATOR = null;
    private ScoredNetwork mScore;
    private long mUpdatedTimestampMillis;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    TimestampedScoredNetwork(ScoredNetwork r1, long r2) {
        this.mScore = r1;
        this.mUpdatedTimestampMillis = r2;
    }

    protected TimestampedScoredNetwork(Parcel r3) {
        this.mScore = r3.readParcelable(ScoredNetwork.class.getClassLoader());
        this.mUpdatedTimestampMillis = r3.readLong();
    }

    public void update(ScoredNetwork r1, long r2) {
        this.mScore = r1;
        this.mUpdatedTimestampMillis = r2;
    }

    public ScoredNetwork getScore() {
        return this.mScore;
    }

    public long getUpdatedTimestampMillis() {
        return this.mUpdatedTimestampMillis;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeParcelable(this.mScore, r4);
        r3.writeLong(this.mUpdatedTimestampMillis);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
