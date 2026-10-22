package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class NewMsgTimeHolder implements Parcelable {
    public static final Parcelable.Creator<NewMsgTimeHolder> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f3574h;

    static class a implements Parcelable.Creator<NewMsgTimeHolder> {
        a() {
        }

        public NewMsgTimeHolder a(Parcel r1) {
            return new NewMsgTimeHolder(r1);
        }

        public NewMsgTimeHolder[] b(int r1) {
            return new NewMsgTimeHolder[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NewMsgTimeHolder createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NewMsgTimeHolder[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public NewMsgTimeHolder(long r1, long r3, long r5) {
        this.f3572f = r1;
        this.f3573g = r3;
        this.f3574h = r5;
    }

    protected NewMsgTimeHolder(Parcel r3) {
        this.f3572f = r3.readLong();
        this.f3573g = r3.readLong();
        this.f3574h = r3.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.f3572f);
        r3.writeLong(this.f3573g);
        r3.writeLong(this.f3574h);
    }
}
