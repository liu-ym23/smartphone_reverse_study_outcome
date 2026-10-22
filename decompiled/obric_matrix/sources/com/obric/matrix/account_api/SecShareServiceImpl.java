package com.obric.matrix.account_api;

import android.content.Context;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/account_api/SecShareServiceImpl;", "Lcom/obric/matrix/account_api/ISecShareService;", "()V", "initSecShare", "", "context", "Landroid/content/Context;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SecShareServiceImpl implements ISecShareService {
    public SecShareServiceImpl() {
    }

    @Override // com.obric.matrix.account_api.ISecShareService
    public void initSecShare(Context r1) {
        o.f(r1, "context");
        e.f8822a.e(r1);
    }
}
