package android.security.obric.guard;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObricSecurityGuardStub {
    public ObricSecurityGuardStub() {
    }

    public static ObricSecurityGuardStub getInstance() {
        return null;
    }

    public abstract int getActivityRiskType(String r1, String r2, Bundle r3);

    public abstract Bundle getAppGrantPermissionInfo(String r1, String r2);

    public abstract Bundle getCurrentAppGrantPermissionInfo(String r1);

    public abstract String getSecurityPolicy(String r1);

    public abstract void updateMinPerPolicy(String r1, String r2);

    public abstract void updatePolicyFile(String r1, String r2);
}
