package com.bytedance.apm.agent.logging;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidAgentLog implements AgentLog {
    private static final String TAG = "[tt_apm]";
    private int level;

    public AndroidAgentLog() {
        this.level = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r2) {
        if (this.level != 6) goto L6;
        Log.d("[tt_apm]", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r2) {
        if (this.level < 5) goto L6;
        Log.d("[tt_apm]", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r2) {
        if (this.level < 4) goto L6;
        Log.v("[tt_apm]", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r2) {
        if (this.level < 3) goto L6;
        Log.i("[tt_apm]", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r2) {
        if (this.level < 2) goto L6;
        Log.w("[tt_apm]", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r2) {
        if (this.level < 1) goto L6;
        Log.e("[tt_apm]", r2);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r2, Throwable r3) {
        if (this.level < 1) goto L6;
        Log.e("[tt_apm]", r2, r3);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r2) {
        if (r2 > 6) goto L9;
        if (r2 < 1) goto L9;
        this.level = r2;
        return;
    L9:
        throw new IllegalArgumentException("Log level is not between ERROR and AUDIT");
    }
}
