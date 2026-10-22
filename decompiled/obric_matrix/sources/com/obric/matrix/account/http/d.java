package com.obric.matrix.account.http;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/matrix/account/http/AsyncThrowable;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "throwable", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "toString", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d extends Throwable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8497f;

    static {
        new d(Resp.CODE_UNKNOWN, "", k.f8527f);
    }

    public d(int r2, String r3, Throwable r4) {
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        o.f(r4, "throwable");
        super(r3, r4);
        this.f8497f = r2;
    }

    public final int a() {
        return this.f8497f;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AsyncThrowable[" + this.f8497f + ':' + getMessage() + ']';
    }
}
