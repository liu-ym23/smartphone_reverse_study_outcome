package com.bytedance.securityserver.robotspolicy;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class RobotsPolicyContract {
    public static final String AUTHORITY = "com.obric.agentrobots.provider";
    public static final Uri BASE_CONTENT_URI = null;
    public static final String COL_PACKAGE_NAME = "package_name";
    public static final String COL_POLICY_JSON = "policy";
    public static final String COL_VERSION = "version";
    public static final String MIME_TYPE_DIR = "vnd.android.cursor.dir/vnd.obric.policy";
    public static final String PATH_POLICY = "policy";
    public static final Uri POLICY_URI = null;
    public static final String TABLE_POLICY = "policy";

    static {
        Uri r0 = Uri.parse("content://com.obric.agentrobots.provider");
        BASE_CONTENT_URI = r0;
        POLICY_URI = r0.buildUpon().appendPath("policy").build();
    }

    private RobotsPolicyContract() {
    }

    public static Uri buildPolicyUri() {
        return POLICY_URI;
    }
}
