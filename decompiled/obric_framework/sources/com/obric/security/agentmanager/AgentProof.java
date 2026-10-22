package com.obric.security.agentmanager;

/* JADX INFO: loaded from: classes.dex */
public class AgentProof {
    private byte[] mAgentData;
    private byte[] mAgentHash;
    private String mAgentUuid;
    private byte[] mCertChain;
    private byte[] mDeviceStatus;
    private byte[] mSignature;

    public AgentProof(String agentUuid, byte[] agentData, byte[] agentHash, byte[] deviceStatus, byte[] certChain, byte[] signature) {
        this.mAgentUuid = agentUuid;
        this.mAgentData = agentData;
        this.mAgentHash = agentHash;
        this.mDeviceStatus = deviceStatus;
        this.mCertChain = certChain;
        this.mSignature = signature;
    }

    public String getAgentUuid() {
        return this.mAgentUuid;
    }

    public void setAgentUuid(String agentUuid) {
        this.mAgentUuid = agentUuid;
    }

    public byte[] getAgentData() {
        return this.mAgentData;
    }

    public void setAgentData(byte[] agentData) {
        this.mAgentData = agentData;
    }

    public byte[] getAgentHash() {
        return this.mAgentHash;
    }

    public void setAgentHash(byte[] agentHash) {
        this.mAgentHash = agentHash;
    }

    public byte[] getDeviceStatus() {
        return this.mDeviceStatus;
    }

    public void setDeviceStatus(byte[] deviceStatus) {
        this.mDeviceStatus = deviceStatus;
    }

    public byte[] getCertChain() {
        return this.mCertChain;
    }

    public void setCertChain(byte[] certChain) {
        this.mCertChain = certChain;
    }

    public byte[] getSignature() {
        return this.mSignature;
    }

    public void setSignature(byte[] signature) {
        this.mSignature = signature;
    }
}
