package com.bytedance.securityserver.utils;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.securityserver.adapter.SecurityAuditReportParse;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.TypeDetector;
import com.bytedance.securityserver.adapter.api.ISecurityAuditReportManager;
import com.bytedance.securityserver.adapter.api.ISecurityAuditReportResult;
import com.bytedance.securityserver.adapter.api.ITeaReportBridge;
import com.bytedance.securityserver.adapter.assistant.AssistantSecurityAuditReportManagerAdapter;
import com.bytedance.securityserver.adapter.obric.ObricSecurityAuditReportManagerAdapter;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.bytedance.securityserver.securitylog.SecurityLogConfigUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class EventUploadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScheduledExecutorService f81a;

    public static JSONObject a(JSONObject r4, ISecurityAuditReportResult r5, long r6, String r8, String r9, String r10, String r11) {
        JSONObject r0 = new JSONObject();
        r0.put("report_time", r5.c());
        r0.put(RobotsPolicyContract.COL_VERSION, r5.b());
        r0.put("batch_id", r5.a());
        if (r6 < 0) goto L6;
        r0.put("batch_id", String.valueOf(r6));
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L9;
        r0.put("block_hash", r8);
    L9:
        if (TextUtils.isEmpty(r9) == true) goto L12;
        r0.put("prev_hash", r9);
    L12:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        r0.put("merkle_root", r10);
    L15:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        r0.put("signature", r11);
    L18:
        if (r4.has("leaf_hash") == false) goto L23;
        if (r4.isNull("leaf_hash") == true) goto L23;
        r0.put("leaf_hash", r4.get("leaf_hash"));
    L23:
        if (r4.has("proof_path") == false) goto L28;
        if (r4.isNull("proof_path") == true) goto L28;
        r0.put("proof_path", String.valueOf(r4.get("proof_path")));
    L28:
        if (r4.has("ts") == true) goto L30;
    L32:
        String r7 = "";
    L33:
        r0.put("ts", r7);
        r0.put("device_log_id", r4.optString(ReportProtocal.KEY_LOG_ID, ""));
        r0.put("instruction_id", r4.optString("instruction_id", ""));
        r0.put("device_id", r4.optString("device_id", ""));
        r0.put("uid", r4.optString("uid", ""));
        r0.put("target_package", r4.optString("target_package", ""));
        if (r4.has("payload_encrypted") == true) goto L36;
    L38:
        return r0;
    L36:
        if (r4.isNull("payload_encrypted") == true) goto L38;
        r0.put("payload_raw", r4.get("payload_encrypted"));
        goto L38
    L30:
        if (r4.isNull("ts") == true) goto L32;
        r7 = String.valueOf(r4.get("ts"));
        goto L33
    }

    public static void b() {
        if (SecurityLogConfigUtils.a(GlobalContext.f82a) == true) goto L7;
        Log.i("SecurityAuditUpload", "reportSecurityAuditOnce: security log disabled");
        return;
    L7:
        monitor-enter(SecurityLibFactory.class);
        ISecurityAuditReportManager r0 = SecurityLibFactory.f;     // Catch: Throwable -> L16
        int r2 = 1;
        if (r0 == null) goto L13;
        monitor-exit(SecurityLibFactory.class);
    L12:
        ISecurityAuditReportManager r1 = r0;
        if (r1 != null) goto L27;
        Log.w("SecurityAuditUpload", "reportSecurityAuditOnce: audit report manager unavailable");
        return;
    L27:
        int r3 = r1.c();
        if (r3 > 0) goto L30;
        return;
    L30:
        int r4 = (r3 + 999) / 1000;
        int r6 = 0;
        int r7 = 0;
    L31:
        if (r6 >= r4) goto L36;
        SecurityAuditReportParse r15 = r1.d();
        if (r15 == null) goto L36;
        if (TextUtils.isEmpty(r15.f39a) == true) goto L36;
        String r14 = "uploadOneBatch: confirmed failure, batchId=";
        String r13 = "SecurityAuditUpload";
        JSONObject r8 = new JSONObject(r15.f39a);     // Catch: Throwable -> L70
        JSONArray r12 = r8.optJSONArray("records");     // Catch: Throwable -> L70
        long r16 = r8.optLong("block_seq", -1);     // Catch: Throwable -> L70
        String r18 = r8.optString("block_hash", "");     // Catch: Throwable -> L70
        String r19 = r8.optString("prev_hash", "");     // Catch: Throwable -> L70
        String r20 = r8.optString("merkle_root", "");     // Catch: Throwable -> L70
        String r5 = r8.optString("signature", "");     // Catch: Throwable -> L70
        int r10 = 0;
        int r11 = 0;
    L40:
        if (r12 == null) goto L69;
    L67:
        th = th;
        int r23 = r3;
        int r24 = r4;
        String r9 = r13;
        String r17 = r14;
        SecurityAuditReportParse r21 = r15;
    L88:
        Log.e(r9, "uploadOneBatch: security audit upload failed", th);     // Catch: Throwable -> L80
        r1.b(r21.b);
        Log.w(r9, r17 + r21.b);
        boolean r22 = false;
    L74:
        if (r22 == true) goto L77;
        r11 = -1;
    L77:
        if (r11 < 0) goto L83;
        r7 = r7 + r11;
        r6 = r6 + 1;
        r3 = r23;
        r4 = r24;
        r2 = 1;
    L83:
        if (r7 <= 0) goto L106;
        StringBuilder r25 = a.a.r("reportSecurityAuditOnce: pendingCount=", r23, ", batchRounds=", r24, ", total reported count=");
        r25.append(r7);
        Log.i("SecurityAuditUpload", r25.toString());
        return;
    L106:
        return;
    L80:
        th = move-exception;
        r1.b(r21.b);
        Log.w(r9, r17 + r21.b);
        throw th;
    L42:
        if (r10 >= r12.length()) goto L69;
        JSONObject r26 = r12.optJSONObject(r10);     // Catch: Throwable -> L67
        if (r26 != null) goto L46;
        r23 = r3;
        r24 = r4;
        r9 = r13;
        r17 = r14;
        r21 = r15;
    L90:
        r10 = r10 + 1;     // Catch: Throwable -> L62
        r14 = r17;
        r15 = r21;
        r13 = r9;
        r12 = r12;
        r3 = r23;
        r4 = r24;
        r2 = 1;
    L62:
        th = th;
        r11 = r2;
        goto L88
    L46:
        r2 = r11;
        r9 = r13;
        r23 = r3;
        r17 = r14;
        r24 = r4;
        r21 = r15;
        JSONObject r27 = a(r26, r15, r16, r18, r19, r20, r5);     // Catch: Throwable -> L62
        monitor-enter(SecurityLibFactory.class);     // Catch: Throwable -> L62
        ITeaReportBridge r110 = SecurityLibFactory.g;     // Catch: Throwable -> L64
        monitor-exit(SecurityLibFactory.class);     // Catch: Throwable -> L62
        if (r110 != null) goto L53;
    L56:
        Log.w("SecurityAuditUpload", "reportEvent: TeaReportBridge not ready, skip event=security_audit_report_result");     // Catch: Throwable -> L62
        boolean r28 = false;
    L57:
        if (r28 == false) goto L61;
        r11 = r2 + 1;     // Catch: Throwable -> L62
        goto L90
    L61:
        throw new IllegalStateException("TeaReportBridge not ready or event rejected");     // Catch: Throwable -> L62
    L53:
        if (r110.isInitialized() == false) goto L56;
        r110.a(r27);     // Catch: Throwable -> L62
        r28 = true;
        goto L57
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L69:
        r23 = r3;
        r24 = r4;
        int r29 = r11;
        SecurityAuditReportParse r30 = r15;
        r1.a(r30.b);
        Log.d(r13, "uploadOneBatch: confirmed success, batchId=" + r30.b + ", count=" + r29);
        r11 = r29;
        r22 = true;
    L70:
        th = th;
        r23 = r3;
        r24 = r4;
        r9 = "SecurityAuditUpload";
        r17 = "uploadOneBatch: confirmed failure, batchId=";
        r21 = r15;
        r11 = 0;
    L36:
        r23 = r3;
        r24 = r4;
        goto L83
    L13:
        int r31 = TypeDetector.a();     // Catch: Throwable -> L16
        if (r31 != 1) goto L19;
        SecurityLibFactory.f = new ObricSecurityAuditReportManagerAdapter();     // Catch: Throwable -> L16
    L21:
        r0 = SecurityLibFactory.f;     // Catch: Throwable -> L16
        monitor-exit(SecurityLibFactory.class);
        goto L12
    L19:
        if (r31 != 2) goto L21;
        SecurityLibFactory.f = new AssistantSecurityAuditReportManagerAdapter();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void c() {
        monitor-enter(EventUploadUtils.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SecurityLogConfigUtils.a(GlobalContext.f82a) == true) goto L12;
        Log.i("SecurityAuditUpload", "startSecurityAuditReportTask: security log disabled");     // Catch: Throwable -> L9
        monitor-exit(EventUploadUtils.class);
        return;
    L12:
        if (f81a == null) goto L30;
        Log.i("SecurityAuditUpload", "startSecurityAuditReportTask: already started");     // Catch: Throwable -> L9
        monitor-exit(EventUploadUtils.class);
        return;
    L30:
        boolean r2 = "1".equals((String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"persist.security.audit.test_mode", "0"}));     // Catch: Throwable -> L19
    L20:
        if (r2 == false) goto L23;
        long r3 = 30000;
    L22:
        long r8 = r3;
        f81a = Executors.newSingleThreadScheduledExecutor(new a());     // Catch: Throwable -> L9
        Log.i("SecurityAuditUpload", "startSecurityAuditReportTask: initialDelayMs=5000, periodMs=" + r8);     // Catch: Throwable -> L9
        f81a.scheduleWithFixedDelay(new c(), PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, r8, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9
        monitor-exit(EventUploadUtils.class);
        return;
    L23:
        r3 = 14400000;
    L19:
        r2 = false;
        goto L20
    }
}
