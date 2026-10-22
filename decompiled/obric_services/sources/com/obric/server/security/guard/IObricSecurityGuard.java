package com.obric.server.security.guard;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface IObricSecurityGuard {
    public static final String PER_LEVEL = "permission_level";
    public static final String PER_NAME = "permission_name";
    public static final String USE_REASON = "use_reason";

    Bundle getAppGrantPermissionInfo(String r1, String[] r2);

    Bundle getCurrentAppGrantPermissionInfo(String r1);

    void updateMinPerPolicy(String r1, String r2);
}
