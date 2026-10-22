package com.obric.security.audit;

/* JADX INFO: loaded from: classes.dex */
public final class AuditResult {
    public static final int ERR_DB_ERROR = 6;
    public static final int ERR_INVALID_JSON = 4;
    public static final int ERR_MISSING_AGENT = 5;
    public static final int ERR_PAYLOAD_TOO_LARGE = 9;
    public static final int ERR_PERMISSION_DENIED = 3;
    public static final int ERR_RATE_LIMIT = 1;
    public static final int ERR_REMOTE_EXCEPTION = 8;
    public static final int ERR_ROBOTS_DISABLED = -10;
    public static final int ERR_SERVICE_NOT_READY = 2;
    public static final int ERR_TIMEOUT = 7;
    public static final int ERR_UNKNOWN = 100;
    public static final int OK = 0;

    private AuditResult() {
    }
}
