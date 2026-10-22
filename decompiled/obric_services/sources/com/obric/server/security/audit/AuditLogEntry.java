package com.obric.server.security.audit;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class AuditLogEntry {
    public String agentName;
    public String deviceId;
    public String instructionId;
    public String intentType;
    public int isAgentRelated;
    public String logSource;
    public byte[] payloadEncrypted;
    public int payloadFormat;
    public byte[] payloadRaw;
    public String targetActivity;
    public String targetPackage;
    public String timestampStr;
    public long ts;
    public String uid;
    public boolean uploadEnabled;

    public static class Builder {
        private final AuditLogEntry entry;

        public Builder() {
            this.entry = new AuditLogEntry(null);
        }

        public Builder ts(long val) {
            this.entry.ts = val;
            return this;
        }

        public Builder instructionId(String val) {
            this.entry.instructionId = val;
            return this;
        }

        public Builder targetPackage(String val) {
            this.entry.targetPackage = val;
            return this;
        }

        public Builder deviceId(String val) {
            this.entry.deviceId = val;
            return this;
        }

        public Builder uid(String val) {
            this.entry.uid = val;
            return this;
        }

        public Builder isAgentRelated(int val) {
            this.entry.isAgentRelated = val;
            return this;
        }

        public Builder payloadFormat(int val) {
            this.entry.payloadFormat = val;
            return this;
        }

        public Builder payloadRaw(byte[] val) {
            this.entry.payloadRaw = val;
            return this;
        }

        public Builder payloadEncrypted(byte[] val) {
            this.entry.payloadEncrypted = val;
            return this;
        }

        public Builder uploadEnabled(boolean val) {
            this.entry.uploadEnabled = val;
            return this;
        }

        public Builder logSource(String val) {
            this.entry.logSource = val;
            return this;
        }

        public Builder timestampStr(String val) {
            this.entry.timestampStr = val;
            return this;
        }

        public Builder targetActivity(String val) {
            this.entry.targetActivity = val;
            return this;
        }

        public Builder intentType(String val) {
            this.entry.intentType = val;
            return this;
        }

        public Builder agentName(String val) {
            this.entry.agentName = val;
            return this;
        }

        public Builder payloadRaw(String json) {
            AuditLogEntry r0 = this.entry;
            if (json == null) goto L5;
            byte[] r1 = json.getBytes(StandardCharsets.UTF_8);
        L6:
            r0.payloadRaw = r1;
            this.entry.payloadFormat = 2;
            return this;
        L5:
            r1 = null;
            goto L6
        }

        public AuditLogEntry build() {
            return this.entry;
        }
    }

    /* synthetic */ AuditLogEntry(AuditLogEntryIA r1) {
        this();
    }

    private AuditLogEntry() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
