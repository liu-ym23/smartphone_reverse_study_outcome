package com.obric.capabilitykit.entity.app;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingState;", "", "()V", "FINISHED", "", "RECORDING", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AuditoryRecordingState {
    public static final int FINISHED = 1;
    public static final AuditoryRecordingState INSTANCE = null;
    public static final int RECORDING = 0;

    static {
        INSTANCE = new AuditoryRecordingState();
    }

    private AuditoryRecordingState() {
    }
}
