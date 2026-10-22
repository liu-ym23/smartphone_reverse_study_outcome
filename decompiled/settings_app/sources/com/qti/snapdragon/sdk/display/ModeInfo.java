package com.qti.snapdragon.sdk.display;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class ModeInfo implements Parcelable {
    public static final Parcelable.Creator<ModeInfo> CREATOR = null;
    private int id;
    private ColorManager.MODE_TYPE modeType;
    private String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ModeInfo(int r2, String r3, int r4) {
        this.id = -1;
        this.name = null;
        this.modeType = ColorManager.MODE_TYPE.MODE_SYSTEM;
        this.id = r2;
        this.name = r3;
        this.modeType = ColorManager.MODE_TYPE.values()[r4];
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ColorManager.MODE_TYPE getModeType() {
        return this.modeType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.id);
        r1.writeString(this.name);
        r1.writeInt(this.modeType.getValue());
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
