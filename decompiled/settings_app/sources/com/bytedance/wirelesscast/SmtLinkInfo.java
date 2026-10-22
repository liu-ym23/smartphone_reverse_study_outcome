package com.bytedance.wirelesscast;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class SmtLinkInfo implements Parcelable {
    public static final Parcelable.Creator<SmtLinkInfo> CREATOR = null;
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_DISCONNECTING = 5;
    public static final int STATE_IDLE = 0;
    public static final int STATE_STOPPING = 4;
    public static final int STATE_WAITING_CONNECT = 1;
    public String mIp;
    public String mName;
    public int mStatus;

    public interface OnConnectedListener {
        void disconnect();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SmtLinkInfo() {
    }

    public SmtLinkInfo(String r1, String r2, int r3) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.mName = r1;
        this.mIp = r2;
        this.mStatus = r3;
    }

    public SmtLinkInfo(String r2, String r3) {
        this(r2, r3, 0);
    }

    public SmtLinkInfo(SmtLinkInfo r2) {
        this.mName = r2.mName;
        this.mIp = r2.mIp;
        this.mStatus = r2.mStatus;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int r1) {
        this.mStatus = r1;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.mName = r1;
    }

    public String getIp() {
        return this.mIp;
    }

    public void setIp(String r1) {
        this.mIp = r1;
    }

    public boolean isConnect() {
        if (3 != this.mStatus) goto L5;
        return true;
    L5:
        return false;
    }

    public void setConnect(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 3;
    L5:
        this.mStatus = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }

    protected SmtLinkInfo(Parcel r2) {
        this.mName = r2.readString();
        this.mIp = r2.readString();
        this.mStatus = r2.readInt();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mName);
        r1.writeString(this.mIp);
        r1.writeInt(this.mStatus);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        SmtLinkInfo r6 = (SmtLinkInfo) r5;
        if (Objects.equals(this.mName, r6.mName) == false) goto L16;
        if (Objects.equals(this.mIp, r6.mIp) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mName, this.mIp});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Info{ name=");
        r0.append(this.mName);
        r0.append(", ip=").append(this.mIp);
        int r3 = this.mStatus;
        if (r3 != 0) goto L5;
        r0.append(", st=IDLE");
    L21:
        r0.append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    L5:
        if (r3 != 1) goto L7;
        r0.append(", st=WAITING_CONNECT");
        goto L21
    L7:
        if (r3 != 2) goto L9;
        r0.append(", st=CONNECTING");
        goto L21
    L9:
        if (r3 != 3) goto L11;
        r0.append(", st=CONNECTED");
        goto L21
    L11:
        if (r3 != 4) goto L13;
        r0.append(", st=STOPPING");
        goto L21
    L13:
        if (r3 != 5) goto L21;
        r0.append(", st=DISCONNECTING");
        goto L21
    }
}
