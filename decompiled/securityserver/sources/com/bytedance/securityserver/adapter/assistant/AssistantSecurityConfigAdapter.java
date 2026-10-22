package com.bytedance.securityserver.adapter.assistant;

import android.util.Log;
import com.aiassistant.security.securityconfig.SecurityConfigManager;
import com.bytedance.securityserver.adapter.api.ISecurityConfig;

/* JADX INFO: loaded from: classes.dex */
public class AssistantSecurityConfigAdapter implements ISecurityConfig {
    @Override // com.bytedance.securityserver.adapter.api.ISecurityConfig
    public final int a(int r2, String r3) {
        Log.d("AssistantSecurityConfigAdapter", "updateConfigInt called, key=" + r3 + ", value=" + r2);
        return SecurityConfigManager.updateConfigInt(r3, r2);
    }
}
