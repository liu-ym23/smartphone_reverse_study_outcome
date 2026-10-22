package com.obric.matrix.u;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/model/BaseMonitorData;", "", "serverLogId", "", "serverErrorCode", "", "serverDescription", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getServerDescription", "()Ljava/lang/String;", "setServerDescription", "(Ljava/lang/String;)V", "getServerErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getServerLogId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/matrix/model/BaseMonitorData;", "equals", "", "other", "handleResponseErrorMsg", "errorMsg", "hashCode", "toString", "sdk_platform_server_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f10037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10038c;

    public a() {
        this(null, null, null, 7, null);
    }

    public a(String r1, Integer r2, String r3) {
        this.f10036a = r1;
        this.f10037b = r2;
        this.f10038c = r3;
        this.f10038c = d(r3);
    }

    public /* synthetic */ a(String r2, Integer r3, String r4, int r5, g r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f10038c;
    }

    public final Integer b() {
        return this.f10037b;
    }

    public final String c() {
        return this.f10036a;
    }

    public final String d(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        o.c(r4);
        if (k.F(r4, "Exception in CronetUrlRequest", false, 2, null) == false) goto L9;
        return "Network error";
    L9:
        return r4;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (o.a(this.f10036a, r6.f10036a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10037b, r6.f10037b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10038c, r6.f10038c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f10036a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f10037b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f10038c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BaseMonitorData(serverLogId=" + this.f10036a + ", serverErrorCode=" + this.f10037b + ", serverDescription=" + this.f10038c + ')';
    }
}
