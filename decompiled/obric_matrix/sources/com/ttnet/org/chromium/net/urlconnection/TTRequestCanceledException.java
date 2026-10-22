package com.ttnet.org.chromium.net.urlconnection;

import com.obric.matrix.account.http.Resp;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class TTRequestCanceledException extends IOException {
    public TTRequestCanceledException(String r1) {
        super(r1);
    }

    public int getCronetInternalErrorCode() {
        return Resp.CODE_UNKNOWN;
    }
}
