package yg;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0012\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lyg/a;", "", "", "a", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "setWorker", "(Ljava/lang/Boolean;)V", "worker", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPublicPath", "(Ljava/lang/String;)V", "publicPath", "setPageName", "pageName", "d", "setSnapshot", "snapshot", "setNsr", "nsr", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("worker")
    private Boolean f23257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("public_path")
    private String f23258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("page_name")
    private String f23259c;

    @SerializedName("snapshot")
    private Boolean d;

    @SerializedName("nsr")
    private Boolean e;

    public final Boolean a() {
        return this.e;
    }

    public final String b() {
        return this.f23259c;
    }

    public final String c() {
        return this.f23258b;
    }

    public final Boolean d() {
        return this.d;
    }

    public final Boolean e() {
        return this.f23257a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(this.f23257a, r10.f23257a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23258b, r10.f23258b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23259c, r10.f23259c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r5 = this.f23257a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f23258b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f23259c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.e;
        if (r22 == null) goto L23;
        r10 = r22.hashCode();
    L23:
        return r21 + r10;
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "InlineManifest(worker=" + this.f23257a + ", publicPath=" + this.f23258b + ", pageName=" + this.f23259c + ", snapshot=" + this.d + ", nsr=" + this.e + ')';
    }
}
