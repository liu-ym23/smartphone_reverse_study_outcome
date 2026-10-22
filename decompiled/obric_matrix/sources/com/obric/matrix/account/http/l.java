package com.obric.matrix.account.http;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÂ\u0003J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/account/http/Success;", "T", "Lcom/obric/matrix/account/http/Async;", "value", WsConstants.KEY_PAYLOAD, "", "(Ljava/lang/Object;Ljava/lang/String;)V", "Ljava/lang/Object;", "component1", "()Ljava/lang/Object;", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/obric/matrix/account/http/Success;", "equals", "", "other", "", "hashCode", "", "toString", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f8528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8529c;

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public l(T r7, String r8) {
        super(true, false, r7, r8, null);
        this.f8528b = r7;
        this.f8529c = r8;
    }

    public /* synthetic */ l(Object r2, String r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (o.a(this.f8528b, r6.f8528b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f8529c, r6.f8529c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        T r0 = this.f8528b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f8529c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Success(value=" + this.f8528b + ", payload=" + this.f8529c + ')';
    }
}
