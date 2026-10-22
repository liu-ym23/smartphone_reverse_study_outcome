package com.bytedance.securityserver.adapter.obric;

import com.bytedance.securityserver.adapter.api.ISecurityConfig;
import com.obric.security.securityconfig.SecurityConfigManager;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityConfigAdapter implements ISecurityConfig {
    @Override // com.bytedance.securityserver.adapter.api.ISecurityConfig
    public final int a(int r1, String r2) {
        return SecurityConfigManager.updateConfigInt(r2, r1);
    }
}
