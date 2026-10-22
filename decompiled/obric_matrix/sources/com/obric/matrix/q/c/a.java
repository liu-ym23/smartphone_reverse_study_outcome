package com.obric.matrix.q.c;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/base/define/InternalException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "toString", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9846g;

    public a(int r2, String r3, Throwable r4) {
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        super(r4);
        this.f9845f = r2;
        this.f9846g = r3;
    }

    public /* synthetic */ a(int r1, String r2, Throwable r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "code: " + this.f9845f + ", msg: " + this.f9846g + ", cause: " + getCause();
    }
}
