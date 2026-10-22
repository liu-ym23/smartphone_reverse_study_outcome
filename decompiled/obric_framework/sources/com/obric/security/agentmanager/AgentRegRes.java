package com.obric.security.agentmanager;

/* JADX INFO: loaded from: classes.dex */
public class AgentRegRes {
    private AgentProof mAgentProof;
    private int mResultCode;

    public AgentRegRes(int resultCode, AgentProof agentProof) {
        this.mResultCode = AgentManagerErrCode.AGENT_ERR_UNKNOWN;
        this.mResultCode = resultCode;
        this.mAgentProof = agentProof;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public void setResultCode(int resultCode) {
        this.mResultCode = resultCode;
    }

    public AgentProof getAgentProof() {
        return this.mAgentProof;
    }

    public void setAgentProof(AgentProof agentProof) {
        this.mAgentProof = agentProof;
    }
}
