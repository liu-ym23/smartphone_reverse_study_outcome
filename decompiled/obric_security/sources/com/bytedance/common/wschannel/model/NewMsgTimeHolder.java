package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class NewMsgTimeHolder implements Parcelable {
    public static final Parcelable.Creator<NewMsgTimeHolder> CREATOR = null;
    public final long endDecodeTs;
    public final long receiveRawDataTs;
    public final long startDecodeTs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewMsgTimeHolder(long r1, long r3, long r5) {
        this.receiveRawDataTs = r1;
        this.startDecodeTs = r3;
        this.endDecodeTs = r5;
    }

    protected NewMsgTimeHolder(Parcel r3) {
        this.receiveRawDataTs = r3.readLong();
        this.startDecodeTs = r3.readLong();
        this.endDecodeTs = r3.readLong();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.receiveRawDataTs);
        r3.writeLong(this.startDecodeTs);
        r3.writeLong(this.endDecodeTs);
    }
}
