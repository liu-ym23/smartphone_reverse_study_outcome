package com.bytedance.securityserver.adapter.obric;

import com.bytedance.securityserver.adapter.api.IAgentManager;
import com.obric.security.agentmanager.AgentManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricAgentManagerAdapter implements IAgentManager {
    @Override // com.bytedance.securityserver.adapter.api.IAgentManager
    public final String a(String r2) {
        AgentManager r1 = AgentManager.getInstance();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getAgentInfo(r2);
    L7:
        return null;
    }

    @Override // com.bytedance.securityserver.adapter.api.IAgentManager
    public final List b() {
        AgentManager r1 = AgentManager.getInstance();
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.listRegisteredAgents();
    L7:
        return null;
    }
}
