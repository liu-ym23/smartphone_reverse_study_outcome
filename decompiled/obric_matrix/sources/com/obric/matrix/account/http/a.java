package com.obric.matrix.account.http;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\u0003\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/account/http/ApiRespInterceptedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "resp", "Lcom/obric/matrix/account/http/Resp;", "", "e", "", "(Lcom/obric/matrix/account/http/Resp;Ljava/lang/Throwable;)V", "getResp", "()Lcom/obric/matrix/account/http/Resp;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends RuntimeException {
    public a(Resp<? extends Object> r1, Throwable r2) {
        super(r2);
    }
}
