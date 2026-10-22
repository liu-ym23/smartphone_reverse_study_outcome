package com.obric.matrix.account.http;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B-\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/account/http/Async;", "T", "", "complete", "", "shouldLoad", "value", WsConstants.KEY_PAYLOAD, "", "(ZZLjava/lang/Object;Ljava/lang/String;)V", "getComplete", "()Z", "getShouldLoad", "Ljava/lang/Object;", "invoke", "()Ljava/lang/Object;", "Lcom/obric/matrix/account/http/Uninitialized;", "Lcom/obric/matrix/account/http/Loading;", "Lcom/obric/matrix/account/http/Success;", "Lcom/obric/matrix/account/http/Fail;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f8493a;

    private b(boolean r1, boolean r2, T r3, String r4) {
        this.f8493a = r3;
    }

    public /* synthetic */ b(boolean r7, boolean r8, Object r9, String r10, int r11, kotlin.n0.d.g r12) {
        if ((r11 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r7, r8, r9, r10, null);
    }

    public /* synthetic */ b(boolean r1, boolean r2, Object r3, String r4, kotlin.n0.d.g r5) {
        this(r1, r2, r3, r4);
    }

    public T a() {
        return this.f8493a;
    }
}
