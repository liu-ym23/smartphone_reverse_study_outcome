package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes3.dex */
public class NullAgentLog implements AgentLog {
    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r1, Throwable r2) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return 5;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r1) {
    }

    public NullAgentLog() {
    }
}
