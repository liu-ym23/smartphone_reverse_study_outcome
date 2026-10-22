package com.bytedance.securityserver.adapter.assistant;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.bytedance.securityserver.adapter.api.IKeyManager;
import com.bytedance.securityserver.adapter.api.IUDIDResult;

/* JADX INFO: loaded from: classes.dex */
public class AssistantKeyManagerAdapter implements IKeyManager {
    @Override // com.bytedance.securityserver.adapter.api.IKeyManager
    public final IUDIDResult a(Context r2, Bundle r3) {
        return new AssistantUDIDResultAdapter(KeyManager.getInstance().getUDID(r2, r3));
    }
}
