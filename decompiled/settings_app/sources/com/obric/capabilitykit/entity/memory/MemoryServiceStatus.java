package com.obric.capabilitykit.entity.memory;

import com.bytedance.apm.alog.AlogMonitor;
import cz.msebera.android.httpclient.util.VersionInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryServiceStatus;", "", AlogMonitor.ALOG_RESULT_CODE, "", "(Ljava/lang/String;II)V", "getCode", "()I", "AVAILABLE", VersionInfo.UNAVAILABLE, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum MemoryServiceStatus extends Enum<MemoryServiceStatus> {
    private static final /* synthetic */ MemoryServiceStatus[] $VALUES = null;
    public static final MemoryServiceStatus AVAILABLE = null;
    public static final MemoryServiceStatus UNAVAILABLE = null;
    private final int code;

    private static final /* synthetic */ MemoryServiceStatus[] $values() {
        return new MemoryServiceStatus[]{AVAILABLE, UNAVAILABLE};
    }

    static {
        AVAILABLE = new MemoryServiceStatus("AVAILABLE", 0, 0);
        UNAVAILABLE = new MemoryServiceStatus(VersionInfo.UNAVAILABLE, 1, 1);
        $VALUES = $values();
    }

    private MemoryServiceStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static MemoryServiceStatus valueOf(String r1) {
        return (MemoryServiceStatus) Enum.valueOf(MemoryServiceStatus.class, r1);
    }

    public static MemoryServiceStatus[] values() {
        return (MemoryServiceStatus[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
