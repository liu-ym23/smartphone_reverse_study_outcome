package com.bytedance.securityserver.permission;

import a.a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import com.bytedance.securityserver.SecurityConst;
import com.bytedance.securityserver.WorkflowManager;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.api.ISecurityGuard;
import com.bytedance.securityserver.broadcast.BroadcastManager;
import com.bytedance.securityserver.broadcast.IReceiverCall;
import com.bytedance.securityserver.utils.GlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MinPermissionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkflowManager f59a;
    public final Context b;

    /* JADX INFO: renamed from: com.bytedance.securityserver.permission.MinPermissionManager$1, reason: invalid class name */
    class AnonymousClass1 implements WorkflowManager.ApiCallback {
        @Override // com.bytedance.securityserver.WorkflowManager.ApiCallback
        public final void onError(String r2) {
            Log.e("Workflow", "Error: " + r2);
        }

        @Override // com.bytedance.securityserver.WorkflowManager.ApiCallback
        public final void onSuccess(String r8) {
            String r0 = null;
            if (r8 != null) goto L5;
        L14:
            String r9 = null;
        L46:
            JSONObject r2 = new JSONObject(r9);     // Catch: Error -> L22 Exception -> L24
            if (r2.length() <= 0) goto L26;
            String r10 = r2.keys().next();     // Catch: Error -> L22 Exception -> L24
        L27:
            if (r10 == null) goto L29;
            r0 = r2.getString(r10);     // Catch: Error -> L22 Exception -> L24
        L29:
            JSONObject r3 = new JSONObject(r0);     // Catch: Error -> L22 Exception -> L24
            if (r3.length() != 0) goto L33;
            Log.e("MinPermissionManager", "appPolicy is empty");     // Catch: Error -> L22 Exception -> L24
            return;
        L33:
            JSONObject r1 = new JSONObject();     // Catch: Error -> L22 Exception -> L24
            Iterator<String> r4 = r3.keys();     // Catch: Error -> L22 Exception -> L24
        L35:
            if (r4.hasNext() == false) goto L37;
            String r5 = r4.next();     // Catch: Error -> L22 Exception -> L24
            r1.put((String) SecurityConst.b.get(r5), r3.getJSONObject(r5));     // Catch: Error -> L22 Exception -> L24
            goto L35
        L37:
            ISecurityGuard r6 = SecurityLibFactory.c();     // Catch: Error -> L22 Exception -> L24
            if (r6 == null) goto L48;
            r6.c(r10, r1.toString());     // Catch: Error -> L22 Exception -> L24
            return;
        L48:
            return;
        L26:
            r10 = null;
        L22:
            e = move-exception;
            Log.e("MinPermissionManager", "parse per_policy occur exception, " + e.getMessage());
            return;
        L24:
            e = move-exception;
            a.C(e, new StringBuilder("parse per_policy occur exception, "), "MinPermissionManager");
            return;
        L5:
            if (r8.isEmpty() == true) goto L14;
            MediaType r7 = WorkflowManager.c;     // Catch: JSONException -> L17
            int r11 = r8.indexOf("data: ");     // Catch: JSONException -> L17
            if (r11 != (-1)) goto L10;
        L9:
            String r12 = null;
        L13:
            if (r12 == null) goto L14;
            r9 = new JSONObject(new JSONObject(r12).getString("content")).getString("per_policy");     // Catch: JSONException -> L17
            goto L46
        L10:
            int r13 = r11 + 6;     // Catch: JSONException -> L17
            int r14 = r8.lastIndexOf("}");     // Catch: JSONException -> L17
            if (r13 >= r14) goto L9;
            r12 = r8.substring(r13, r14 + 1);     // Catch: JSONException -> L17
        L17:
            e = move-exception;
            Log.e("MinPermissionManager", "parse per_policy occur exception, " + e.getMessage());
            goto L14
        }
    }

    public class PermissionReceiver implements IReceiverCall {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MinPermissionManager f60a;

        public PermissionReceiver(MinPermissionManager r1) {
            this.f60a = r1;
        }

        @Override // com.bytedance.securityserver.broadcast.IReceiverCall
        public final void a(Intent r4) {
            String r0 = r4.getAction();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r4.getData() != null) goto L8;
            return;
        L8:
            String r5 = r4.getData().getSchemeSpecificPart();
            if (r0.equals("android.intent.action.PACKAGE_ADDED") == false) goto L21;
        L15:
            e = move-exception;
            a.C(e, new StringBuilder("ACTION_PACKAGE_ADDED occur exception, "), "MinPermissionManager");
            return;
        L12:
            if (Settings.Global.getInt(GlobalContext.f82a.getContentResolver(), "device_provisioned", 0) != 1) goto L20;
            MinPermissionManager.a(this.f60a, r5);     // Catch: Exception -> L15
            return;
        L20:
            return;
        }
    }

    public MinPermissionManager(Context r4) {
        this.b = r4;
        if (WorkflowManager.f35d != null) goto L5;
        WorkflowManager.f35d = new WorkflowManager();
    L5:
        this.f59a = WorkflowManager.f35d;
        ArrayList r5 = new ArrayList();
        r5.add("android.intent.action.PACKAGE_ADDED");
        r5.add("android.intent.action.PACKAGE_REMOVED");
        r5.add("android.intent.action.PACKAGE_REPLACED");
        PermissionReceiver r0 = new PermissionReceiver(this);
        HashMap r3 = BroadcastManager.f54a;
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        String r7 = (String) r6.next();
        ((Set) BroadcastManager.f54a.computeIfAbsent(r7, new com.bytedance.securityserver.broadcast.a())).add(r0);
        goto L7
    }

    public static void a(MinPermissionManager r8, String r9) {
        PackageManager r0 = r8.b.getPackageManager();
        ArrayList r2 = new ArrayList();
        String[] r1 = r0.getPackageInfo(r9, 4096).requestedPermissions;     // Catch: Exception -> L11
        if (r1 == null) goto L15;
        int r3 = r1.length;     // Catch: Exception -> L11
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L15;
        String r5 = r1[r4];     // Catch: Exception -> L11
        HashMap r6 = SecurityConst.f34a;     // Catch: Exception -> L11
        if (r6.containsKey(r5) == false) goto L13;
        String r7 = (String) r6.get(r5);     // Catch: Exception -> L11
        r2.add(r7);     // Catch: Exception -> L11
        Log.i("MinPermissionManager", "getAppPermissions: " + r7);     // Catch: Exception -> L11
    L13:
        r4 = r4 + 1;
    L15:
        HashMap r10 = new HashMap();
        r10.put("package_name", r9);
        r10.put("request_permission", r2);
        r8.f59a.a(r10, new AnonymousClass1());
        return;
    L11:
        e = move-exception;
        a.C(e, new StringBuilder("getAppPermissions occur exception, "), "MinPermissionManager");
        goto L15
    }
}
