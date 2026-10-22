package com.obric.server.security.guard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.obric.server.security.broadcast.IObricSecurityBroadcastPlugin;
import com.obric.server.security.broadcast.ObricSecurityBroadcast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MinPermissionManager {
    private static final int PER_INFO_SIZE = 8;
    private static final String TAG = "MinPermissionManager";
    private JSONObject mAllPerPolicy;
    private GuardDataStorage mGuardDataStorage;
    Map<String, PermissionInfos> mPerPolicyMap;

    private static class PermissionInfos {
        public String perLevel;
        public String perName;
        public String useReason;

        /* synthetic */ PermissionInfos(MinPermissionManagerIA r1) {
            this();
        }

        private PermissionInfos() {
            this.perName = null;
            this.perLevel = null;
            this.useReason = null;
        }
    }

    private class PermissionManagerRecevier implements IObricSecurityBroadcastPlugin {
        final /* synthetic */ MinPermissionManager this$0;

        /* synthetic */ PermissionManagerRecevier(MinPermissionManager r1, MinPermissionManagerIA r2) {
            this(r1);
        }

        private PermissionManagerRecevier(MinPermissionManager r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.server.security.broadcast.IObricSecurityBroadcastPlugin
        public void onReceive(Context context, Intent intent) {
            if (intent != null) goto L4;
            return;
        L4:
            if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) == false) goto L19;
            Uri data = intent.getData();
            if (data != null) goto L8;
            return;
        L8:
            String packageName = intent.getData().getSchemeSpecificPart();
        L13:
            e = move-exception;
            Log.e(MinPermissionManager.TAG, "ACTION_PACKAGE_REMOVED: " + e.getMessage());
            return;
        L10:
            if (MinPermissionManager.m95$$Nest$fgetmAllPerPolicy(this.this$0).has(packageName) == false) goto L21;
            MinPermissionManager.m95$$Nest$fgetmAllPerPolicy(this.this$0).remove(packageName);     // Catch: Exception -> L13
            MinPermissionManager.m96$$Nest$fgetmGuardDataStorage(this.this$0).writeMinPolicy(MinPermissionManager.m95$$Nest$fgetmAllPerPolicy(this.this$0).toString());     // Catch: Exception -> L13
            return;
        L21:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllPerPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ JSONObject m95$$Nest$fgetmAllPerPolicy(MinPermissionManager r0) {
        return r0.mAllPerPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGuardDataStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ GuardDataStorage m96$$Nest$fgetmGuardDataStorage(MinPermissionManager r0) {
        return r0.mGuardDataStorage;
    }

    public MinPermissionManager() {
        this.mAllPerPolicy = new JSONObject();
        MinPermissionManagerIA r0 = null;
        this.mPerPolicyMap = null;
        this.mGuardDataStorage = null;
        final float r2 = 0.75f;
        final boolean r3 = false;
        final int r4 = PER_INFO_SIZE;
        this.mPerPolicyMap = new AnonymousClass1(this, r4, r2, r3);     // Catch: Exception -> L7
        ObricSecurityBroadcast.registerPlugin("securityguard", new ArrayList(Collections.singletonList("android.intent.action.PACKAGE_REMOVED")), new PermissionManagerRecevier(this, r0));     // Catch: Exception -> L7
        this.mGuardDataStorage = new GuardDataStorage();     // Catch: Exception -> L7
        String minPerPolicy = this.mGuardDataStorage.getMinPolicy();     // Catch: Exception -> L7
        if (TextUtils.isEmpty(minPerPolicy) == true) goto L13;
        this.mAllPerPolicy = new JSONObject(minPerPolicy);     // Catch: Exception -> L7
        return;
    L13:
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "MinPermissionManager: " + e.getMessage());
    }

    public void updateMinPerPolicy(String packageName, String perPolicy) {
        JSONObject perPolicyJson = new JSONObject(perPolicy);     // Catch: Exception -> L4
        this.mAllPerPolicy.put(packageName, perPolicyJson);     // Catch: Exception -> L4
        this.mGuardDataStorage.writeMinPolicy(this.mAllPerPolicy.toString());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "updateMinPerPolicy: " + e.getMessage());
    }

    public Bundle getPerPolicy(String packageName, String[] permissions) {
        Bundle bundle = new Bundle();
        List<String> perList = new ArrayList(Arrays.asList(permissions));
        if (perList.contains(GuardConst.FINE_LOCATION) == false) goto L6;
        String permissionGroup = GuardConst.FINE_LOCATION;
    L9:
        if (permissionGroup != null) goto L11;
        return bundle;
    L11:
        PermissionInfos perInfos = new PermissionInfos(null);
        perInfos.perName = permissionGroup;
        String level = null;
        JSONObject perPolicyJson = this.mAllPerPolicy.getJSONObject(packageName);     // Catch: Exception -> L14
        JSONObject simPerPolicy = perPolicyJson.getJSONObject(permissionGroup);     // Catch: Exception -> L14
        level = simPerPolicy.getString(IObricSecurityGuard.PER_LEVEL);     // Catch: Exception -> L14
    L17:
        if (TextUtils.isEmpty(level) == false) goto L22;
        if (GuardConst.DEFAULT_PER_POLICY.containsKey(permissionGroup) == false) goto L22;
        String level2 = GuardConst.DEFAULT_PER_POLICY.get(permissionGroup);
        level = level2;
        Log.i(TAG, "getPerPolicy: default- " + level);
    L22:
        if (TextUtils.isEmpty(level) == true) goto L24;
        bundle.putString(IObricSecurityGuard.PER_NAME, permissionGroup);
        bundle.putString(IObricSecurityGuard.PER_LEVEL, level);
    L24:
        perInfos.perLevel = level;
        this.mPerPolicyMap.put(packageName, perInfos);
        return bundle;
    L14:
        e = move-exception;
        Log.e(TAG, "getPerPolicy: " + e.getMessage());
        goto L17
    L6:
        if (perList.contains(GuardConst.COARSE_LOCATION) == false) goto L8;
        permissionGroup = GuardConst.COARSE_LOCATION;
        goto L9
    L8:
        String permissionGroup2 = GuardConst.PERMISSION_TO_GROUP.get(perList.get(0));
        permissionGroup = permissionGroup2;
        goto L9
    }

    public Bundle getCurrentAppGrantPermissionInfo(String packageName) {
        Bundle bundle = new Bundle();
        PermissionInfos perInfos = this.mPerPolicyMap.get(packageName);
        if (perInfos != null) goto L5;
    L16:
        return bundle;
    L5:
        if (TextUtils.isEmpty(perInfos.perName) == true) goto L16;
        bundle.putString(IObricSecurityGuard.PER_NAME, perInfos.perName);
        if (TextUtils.isEmpty(perInfos.perLevel) == false) goto L10;
        return bundle;
    L10:
        bundle.putString(IObricSecurityGuard.PER_LEVEL, perInfos.perLevel);
        JSONObject perPolicyJson = this.mAllPerPolicy.getJSONObject(packageName);     // Catch: Exception -> L13
        JSONObject simPerPolicy = perPolicyJson.getJSONObject(perInfos.perName);     // Catch: Exception -> L13
        bundle.putString(IObricSecurityGuard.USE_REASON, simPerPolicy.getString(IObricSecurityGuard.USE_REASON));     // Catch: Exception -> L13
    L15:
        return bundle;
    L13:
        e = move-exception;
        Log.e(TAG, "getCurrentAppGrantPermissionInfo: " + e.getMessage());
        goto L15
    }
}
