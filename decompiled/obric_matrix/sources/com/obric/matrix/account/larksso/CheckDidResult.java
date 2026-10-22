package com.obric.matrix.account.larksso;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.y.c;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/account/larksso/CheckDidResult;", "Landroid/os/Parcelable;", "isNeed", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckDidResult implements Parcelable {
    public static final Parcelable.Creator<CheckDidResult> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c("is_need")
    private final boolean f8546f;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<CheckDidResult> {
        public a() {
        }

        public final CheckDidResult a(Parcel r1) {
            o.f(r1, "parcel");
            if (r1.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            return new CheckDidResult(r2);
        L5:
            r2 = false;
            goto L7
        }

        public final CheckDidResult[] b(int r1) {
            return new CheckDidResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CheckDidResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CheckDidResult[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public CheckDidResult(boolean r1) {
        this.f8546f = r1;
    }

    public final boolean b() {
        return this.f8546f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CheckDidResult) == true) goto L9;
        return false;
    L9:
        if (this.f8546f == ((CheckDidResult) r4).f8546f) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        boolean r0 = this.f8546f;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public String toString() {
        return "CheckDidResult(isNeed=" + this.f8546f + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.f(r1, "out");
        r1.writeInt(this.f8546f ? 1 : 0);
    }
}
