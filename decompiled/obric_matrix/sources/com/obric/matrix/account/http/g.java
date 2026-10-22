package com.obric.matrix.account.http;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/account/http/Fail;", "T", "Lcom/obric/matrix/account/http/Async;", WsConstants.KEY_CONNECTION_ERROR, "Lcom/obric/matrix/account/http/AsyncThrowable;", "value", "(Lcom/obric/matrix/account/http/AsyncThrowable;Ljava/lang/Object;)V", "getError", "()Lcom/obric/matrix/account/http/AsyncThrowable;", "Ljava/lang/Object;", "component1", "component2", "()Ljava/lang/Object;", "copy", "(Lcom/obric/matrix/account/http/AsyncThrowable;Ljava/lang/Object;)Lcom/obric/matrix/account/http/Fail;", "equals", "", "other", "", "hashCode", "", "toString", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f8498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f8499c;

    public g(d r9, T r10) {
        o.f(r9, WsConstants.KEY_CONNECTION_ERROR);
        super(true, true, r10, null, 8, null);
        this.f8498b = r9;
        this.f8499c = r10;
    }

    public /* synthetic */ g(d r1, Object r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof g) == true) goto L5;
        return false;
    L5:
        d r5 = ((g) r4).f8498b;
        if (o.a(e0.b(this.f8498b.getClass()), e0.b(r5.getClass())) == true) goto L8;
        return false;
    L8:
        if (this.f8498b.a() == r5.a()) goto L10;
        return false;
    L10:
        if (o.a(this.f8498b.getMessage(), r5.getMessage()) == false) goto L17;
        StackTraceElement[] r3 = this.f8498b.getStackTrace();
        o.e(r3, "error.stackTrace");
        Object r6 = kotlin.i0.i.x(r3);
        StackTraceElement[] r7 = r5.getStackTrace();
        o.e(r7, "otherError.stackTrace");
        if (o.a(r6, kotlin.i0.i.x(r7)) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public int hashCode() {
        StackTraceElement[] r3 = this.f8498b.getStackTrace();
        o.e(r3, "error.stackTrace");
        return Arrays.hashCode(new Object[]{e0.b(this.f8498b.getClass()), this.f8498b.getMessage(), kotlin.i0.i.x(r3)});
    }

    public String toString() {
        return "Fail(error=" + this.f8498b + ", value=" + this.f8499c + ')';
    }
}
