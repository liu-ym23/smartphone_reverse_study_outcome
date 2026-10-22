package com.obric.matrix.account.larksso;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.y.c;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/account/larksso/UpdateRetClass;", "Landroid/os/Parcelable;", "code", "", "(Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/matrix/account/larksso/UpdateRetClass;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateRetClass implements Parcelable {
    public static final Parcelable.Creator<UpdateRetClass> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c("code")
    private final Integer f8580f;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<UpdateRetClass> {
        public a() {
        }

        public final UpdateRetClass a(Parcel r2) {
            o.f(r2, "parcel");
            if (r2.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            return new UpdateRetClass(r3);
        L5:
            r3 = Integer.valueOf(r2.readInt());
            goto L7
        }

        public final UpdateRetClass[] b(int r1) {
            return new UpdateRetClass[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UpdateRetClass createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UpdateRetClass[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateRetClass() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public UpdateRetClass(Integer r1) {
        this.f8580f = r1;
    }

    public /* synthetic */ UpdateRetClass(Integer r1, int r2, g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof UpdateRetClass) == true) goto L9;
        return false;
    L9:
        if (o.a(this.f8580f, ((UpdateRetClass) r4).f8580f) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f8580f;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "UpdateRetClass(code=" + this.f8580f + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.f(r1, "out");
        Integer r0 = this.f8580f;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r1.writeInt(1);
        r3 = r0.intValue();
        goto L6
    }
}
