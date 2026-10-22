package com.obric.cae.libs.nfc;

import com.obric.cae.libs.bluetooth.a;
import com.obric.cae.libs.utils.LogUtil;

/* JADX INFO: loaded from: classes4.dex */
public class CaeNfcOmapiExecutor {
    public final ICaeNfcOmapiExecutor a;

    public CaeNfcOmapiExecutor(ICaeNfcOmapiExecutor r1) {
        this.a = r1;
    }

    public String getEseId() {
        ICaeNfcOmapiExecutor r3 = this.a;
        if (r3 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "getEseId: service is null");
        return null;
    L11:
        return r3.getEseId();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcOmapiExecutor");
        return null;
    }
}
