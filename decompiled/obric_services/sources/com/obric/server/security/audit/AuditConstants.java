package com.obric.server.security.audit;

/* JADX INFO: loaded from: classes.dex */
final class AuditConstants {
    static final String DB_DIR = "/data/system/security_audit/agent_robots";
    static final String DB_ERROR_LOG_DIR = "/data/system/security_audit";
    static final String DB_ERROR_LOG_FILE_NAME = "db_error.log";
    static final String DB_ERROR_LOG_PATH = "/data/system/security_audit/db_error.log";
    static final String DB_FILE_NAME = "audit.db";
    static final String DB_PATH = "/data/system/security_audit/agent_robots/audit.db";
    static final long DEFAULT_SESSION_TTL_MS = 600000;
    static final String EXPECTED_SECURITY_SERVER_CERT_DIGEST = "F3A54A8B336759BD84C3305FA995E249F198FD6B6430209FA12256C6C7C61B03";
    static final long MAX_AGE_MS = 5184000000L;
    static final long MAX_DIR_BYTES = 104857600;
    static final int MAX_PAYLOAD_BYTES = 262144;
    static final int MAX_RETRY_COUNT = 5;
    static final int MAX_ROWS = 100000;
    static final long MIN_DB_USABLE_BYTES = 10485760;
    static final int REPORT_MAX_BYTES = 0;
    static final int REPORT_MAX_COUNT = 1000;
    static final String SECURITY_SERVER_PACKAGE = "com.bytedance.securityserver";
    static final long UPLOADING_TIMEOUT_MS = 1800000;
    static final int UPLOAD_STATUS_DONE = 2;
    static final int UPLOAD_STATUS_EXHAUSTED = 3;
    static final int UPLOAD_STATUS_PENDING = 0;
    static final int UPLOAD_STATUS_UPLOADING = 1;

    private AuditConstants() {
    }
}
