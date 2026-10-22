package com.obric.cae.libs.softap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class CaeSoftApStatus implements Parcelable {
    public static final Parcelable.Creator<CaeSoftApStatus> CREATOR = null;
    public static final int ERR_CAC_RADAR_DETECTED = -5;
    public static final int ERR_CAC_TIMEOUT = -6;
    public static final int ERR_COUNTRY_NOT_CN = -2;
    public static final int ERR_INTERNAL = -7;
    public static final int ERR_INVALID_ARGUMENT = -3;
    public static final int ERR_OK = 0;
    public static final int ERR_PERMISSION_DENIED = -1;
    public static final int ERR_SERVICE_BIND_FAILED = -8;
    public static final int ERR_SERVICE_CONNECT_TIMEOUT = -9;
    public static final int ERR_SERVICE_DISCONNECTED = -10;
    public static final int ERR_START_FAILED = -4;
    public static final int STATE_CAC = 2;
    public static final int STATE_FAILED = 5;
    public static final int STATE_IDLE = 0;
    public static final int STATE_RUNNING = 3;
    public static final int STATE_STARTING = 1;
    public static final int STATE_STOPPING = 4;
    public int bandwidthMhz;
    public int channel;
    public String countryCode;
    public int errorCode;
    public String errorDetail;
    public int frequencyMhz;
    public int remainingCacSeconds;
    public int state;

    public class a implements Parcelable.Creator<CaeSoftApStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeSoftApStatus createFromParcel(Parcel r1) {
            return new CaeSoftApStatus(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeSoftApStatus[] newArray(int r1) {
            return new CaeSoftApStatus[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeSoftApStatus() {
        this.state = 0;
        this.errorCode = 0;
        this.channel = 0;
        this.frequencyMhz = 0;
        this.bandwidthMhz = 0;
        this.remainingCacSeconds = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.state);
        r1.writeInt(this.errorCode);
        r1.writeString(this.errorDetail);
        r1.writeString(this.countryCode);
        r1.writeInt(this.channel);
        r1.writeInt(this.frequencyMhz);
        r1.writeInt(this.bandwidthMhz);
        r1.writeInt(this.remainingCacSeconds);
    }

    public CaeSoftApStatus(Parcel r2) {
        this.state = 0;
        this.errorCode = 0;
        this.channel = 0;
        this.frequencyMhz = 0;
        this.bandwidthMhz = 0;
        this.remainingCacSeconds = 0;
        this.state = r2.readInt();
        this.errorCode = r2.readInt();
        this.errorDetail = r2.readString();
        this.countryCode = r2.readString();
        this.channel = r2.readInt();
        this.frequencyMhz = r2.readInt();
        this.bandwidthMhz = r2.readInt();
        this.remainingCacSeconds = r2.readInt();
    }
}
