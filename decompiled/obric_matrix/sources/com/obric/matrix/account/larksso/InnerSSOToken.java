package com.obric.matrix.account.larksso;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.y.c;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/account/larksso/InnerSSOToken;", "Landroid/os/Parcelable;", "innerSsoToken", "", "(Ljava/lang/String;)V", "getInnerSsoToken", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InnerSSOToken implements Parcelable {
    public static final Parcelable.Creator<InnerSSOToken> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c("inner_sso_token")
    private final String f8547f;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<InnerSSOToken> {
        public a() {
        }

        public final InnerSSOToken a(Parcel r1) {
            o.f(r1, "parcel");
            return new InnerSSOToken(r1.readString());
        }

        public final InnerSSOToken[] b(int r1) {
            return new InnerSSOToken[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InnerSSOToken createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InnerSSOToken[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InnerSSOToken() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public InnerSSOToken(String r1) {
        this.f8547f = r1;
    }

    public /* synthetic */ InnerSSOToken(String r1, int r2, g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String b() {
        return this.f8547f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof InnerSSOToken) == true) goto L9;
        return false;
    L9:
        if (o.a(this.f8547f, ((InnerSSOToken) r4).f8547f) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.f8547f;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "InnerSSOToken(innerSsoToken=" + this.f8547f + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.f(r1, "out");
        r1.writeString(this.f8547f);
    }
}
