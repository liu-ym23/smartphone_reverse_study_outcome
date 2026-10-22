package com.bytedance.securityserver.adapter.obric;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.securityserver.adapter.api.IKeyManager;
import com.bytedance.securityserver.adapter.api.IUDIDResult;
import com.obric.security.keymanager.KeyManager;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyManagerAdapter implements IKeyManager {
    @Override // com.bytedance.securityserver.adapter.api.IKeyManager
    public final IUDIDResult a(Context r2, Bundle r3) {
        return new ObricUDIDResultAdapter(KeyManager.getInstance().getUDID(r2, r3));
    }
}
