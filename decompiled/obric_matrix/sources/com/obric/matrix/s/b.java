package com.obric.matrix.s;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/matrix/exception/BaseException;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "sequenceId", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getSequenceId", "sdk_platform_server_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class b extends Throwable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9953h;

    public b(int r2, String r3, String r4) {
        o.f(r3, NotificationCompat.CATEGORY_MESSAGE);
        super(r3);
        this.f9951f = r2;
        this.f9952g = r3;
        this.f9953h = r4;
    }

    public /* synthetic */ b(int r1, String r2, String r3, int r4, g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final int a() {
        return this.f9951f;
    }

    public final String b() {
        return this.f9952g;
    }

    public final String c() {
        return this.f9953h;
    }
}
