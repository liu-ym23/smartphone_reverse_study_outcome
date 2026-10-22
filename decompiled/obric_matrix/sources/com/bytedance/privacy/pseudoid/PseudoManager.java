package com.bytedance.privacy.pseudoid;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.f.d;
import com.bytedance.privacy.pseudoid.d.c;
import com.obric.security.secretdata.AddResult;
import com.obric.security.secretdata.QueryResult;
import com.obric.security.secretdata.SecretData;
import com.obric.security.secretdata.SecretDataManager;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PseudoManager {
    public static final String TAG = "PseudoManager";
    private static volatile PseudoManager pseudoManager;

    static {
    }

    public PseudoManager() {
    }

    private void deletePseudoIDs(Context r7, String r8) {
        if (d.a() == false) goto L29;
        com.bytedance.privacy.pseudoid.c.a r0 = com.bytedance.privacy.pseudoid.c.a.f5466a;
        String r1 = r0.a();
        if (isRPDIDExist(r7, r8, r1) == false) goto L22;
        String r2 = queryRPDID(r7, r8, r1);
        if (r2 != null) goto L9;
    L19:
        com.bytedance.privacy.f.b.b(TAG, "RPDID is already stored, but query failed!");
        return;
    L9:
        if (r2.isEmpty() == true) goto L19;
        if (isDeviceIdExist(r7, r8, r2) == false) goto L16;
        int r3 = SecretDataManager.getInstance().deleteData(r7, b.b(r8, r2), new Bundle());
        if (r3 == 0) goto L16;
        com.bytedance.privacy.f.b.b(TAG, "delete DeviceID failed, result = " + r3);
    L16:
        int r4 = SecretDataManager.getInstance().deleteData(r7, b.c(r8, r1), new Bundle());
        if (r4 == 0) goto L22;
        com.bytedance.privacy.f.b.b(TAG, "delete RPDID failed, result = " + r4);
    L22:
        if (r0.f() == false) goto L30;
        String r5 = r0.c();
        if (isRPUIDExist(r7, r8, r5) == false) goto L31;
        int r6 = SecretDataManager.getInstance().deleteData(r7, b.d(r8, r5), new Bundle());
        if (r6 == 0) goto L32;
        com.bytedance.privacy.f.b.b(TAG, "delete RPUID failed, result = " + r6);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public static PseudoManager getInstance() {
        if (pseudoManager != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pseudoManager != null) goto L9;
        pseudoManager = new PseudoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return pseudoManager;
    }

    private int getPseudoIDFromCloud(Context r3, String r4, String r5, String r6) {
        if (r3 == null) goto L15;
        if (r6 == null) goto L15;
        if (r4 != null) goto L8;
    L12:
        String r2 = TAG;
        String r7 = "deviceId cannot be empty!!";
    L13:
        com.bytedance.privacy.f.b.b(r2, r7);
        return -2;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return requestPseudoID(r3, r4, r5, r6);
    L15:
        r2 = TAG;
        r7 = "context or appID is null!!";
        goto L13
    }

    private boolean isDeviceIdExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 0);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, b.b(r4, r5), r2);
        if (r6 != null) goto L5;
    L9:
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L9;
        return true;
    }

    private boolean isRPDIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 0);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, b.c(r4, r5), r2);
        if (r6 != null) goto L5;
    L9:
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L9;
        return true;
    }

    private boolean isRPUIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 0);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, b.d(r4, r5), r2);
        if (r6 != null) goto L5;
    L9:
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L9;
        return true;
    }

    private String queryRPDID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 2);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, b.c(r4, r5), r2);
        if (r6 != null) goto L5;
    L17:
        String r7 = TAG;
        String r8 = "Query RPDID failed!!";
    L15:
        com.bytedance.privacy.f.b.b(r7, r8);
        return null;
    L5:
        if (r6.getResultCode() != 0) goto L17;
        SecretData r9 = (SecretData) r6.getDataList().get(0);
        if (r9.privateData != null) goto L10;
    L14:
        r7 = TAG;
        r8 = "Query success, but RPDID is null!!";
        goto L15
    L10:
        if (r9.privateData.isEmpty() == true) goto L14;
        return r9.privateData;
    }

    private String queryRPUID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt("query_mode", 2);
        QueryResult r6 = SecretDataManager.getInstance().queryData(r3, b.d(r4, r5), r2);
        if (r6 != null) goto L5;
    L17:
        String r7 = TAG;
        String r8 = "Query RPUID failed!!";
    L15:
        com.bytedance.privacy.f.b.b(r7, r8);
        return null;
    L5:
        if (r6.getResultCode() != 0) goto L17;
        SecretData r9 = (SecretData) r6.getDataList().get(0);
        if (r9.privateData != null) goto L10;
    L14:
        r7 = TAG;
        r8 = "Query success, but RPUID is null!!";
        goto L15
    L10:
        if (r9.privateData.isEmpty() == true) goto L14;
        return r9.privateData;
    }

    private int requestPseudoID(Context r11, String r12, String r13, String r14) {
        String r0 = TAG;
        com.bytedance.privacy.f.b.a(r0, "request PseudoID, PackageName: " + r11.getPackageName());
        com.bytedance.privacy.f.b.a(r0, "request PseudoID, appId:" + r14);
        com.bytedance.privacy.f.b.a(r0, "request PseudoID, deviceId:" + r12);
        if (r13.isEmpty() == true) goto L5;
        com.bytedance.privacy.f.b.a(r0, "request PseudoID, userId:" + r13);
    L5:
        com.bytedance.privacy.pseudoid.d.b r1 = new com.bytedance.privacy.pseudoid.d.b();
        r1.e("POST");
        r1.f(com.bytedance.privacy.pseudoid.d.a.f());
        int r2 = 0;
        com.bytedance.privacy.d.a.g().c(r11, r14);
        Bundle r9 = new Bundle();
        r9.putInt("key_algorithm", 2);
        r9.putInt("key_length", 256);
        r9.putInt("key_purpose", 64);
        List<Certificate> r3 = com.bytedance.privacy.d.a.g().e(r11, r14, r12, false, r9);
        int r4 = -22;
        if (r3 != null) goto L8;
    L41:
        com.bytedance.privacy.f.b.b(r0, "Get attest cert chain failed!!");
        r4 = -9;
    L42:
        com.bytedance.privacy.d.a.g().c(r11, r14);
        com.bytedance.privacy.f.b.d(TAG, "requestPseudoID end, result:" + r4);
        return r4;
    L8:
        if (r3.isEmpty() == true) goto L41;
        r1.d(com.bytedance.privacy.f.a.a(r3, 3));     // Catch: Exception -> L39
        c r5 = com.bytedance.privacy.pseudoid.d.a.d().c(r1);
        com.bytedance.privacy.f.b.a(r0, "response code:" + r5.a());
        com.bytedance.privacy.f.b.a(r0, "response msg:" + r5.b());
        if (r5.a() >= 200) goto L15;
    L38:
        com.bytedance.privacy.f.b.b(r0, "Network request failed, error code:" + r5.a());
        r4 = -21;
        goto L42
    L15:
        if (r5.a() >= 300) goto L38;
        if (r5.c() != null) goto L20;
        com.bytedance.privacy.f.b.b(r0, "Network response pseudoID is null!");
        r4 = -8;
        goto L42
    L20:
        com.bytedance.privacy.f.b.a(r0, "PRDID:" + r5.c().a());
        com.bytedance.privacy.f.b.a(r0, "PRUID:" + r5.c().b());
        if (r12.isEmpty() == true) goto L30;
        if (r5.c().a().isEmpty() == false) goto L26;
        String r10 = "Network response RPDID is empty!!";
    L25:
        com.bytedance.privacy.f.b.b(r0, r10);
        goto L42
    L26:
        r2 = storePseudoDID(r11, r14, r12, r5.c().a());
        if (r2 == 0) goto L30;
        com.bytedance.privacy.f.b.b(r0, "storePseudoDID failed!, result:" + r2);
    L37:
        r4 = r2;
    L30:
        if (r13.isEmpty() == true) goto L37;
        if (r5.c().b().isEmpty() == false) goto L34;
        r10 = "Network response RPUID is empty!!";
        goto L25
    L34:
        r4 = storePseudoUID(r11, r14, r13, r5.c().b());
        if (r4 == 0) goto L42;
        r10 = "storePseudoUID failed!, result:" + r4;
    L39:
        e = move-exception;
        com.bytedance.privacy.f.b.b(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        r4 = -100;
        goto L42
    }

    private int storePseudoDID(Context r6, String r7, String r8, String r9) {
        if (isRPDIDExist(r6, r7, r8) == true) goto L13;
        SecretData r0 = new SecretData();
        r0.privateData = r9;
        r0.associate = r7;
        r0.alias = b.c(r7, r8);
        r0.dataType = "RPDID";
        AddResult r1 = SecretDataManager.getInstance().addData(r6, r0, new Bundle());
        if (r1 != null) goto L9;
    L6:
        com.bytedance.privacy.f.b.b(TAG, "addResult is null, SecretDataManager service failed!!");
        return -14;
    L9:
        if (r1.getResultCode() == 0) goto L13;
        com.bytedance.privacy.f.b.b(TAG, "Store RPDID failed!! result: " + r1.getResultCode());
        return r1.getResultCode();
    L13:
        if (isDeviceIdExist(r6, r7, r9) == true) goto L21;
        SecretData r5 = new SecretData();
        r5.privateData = r8;
        r5.associate = r7;
        r5.alias = b.b(r7, r9);
        r5.dataType = "DID";
        AddResult r10 = SecretDataManager.getInstance().addData(r6, r5, new Bundle());
        if (r10 == null) goto L6;
        if (r10.getResultCode() == 0) goto L23;
        com.bytedance.privacy.f.b.b(TAG, "Store deviceID failed!! result: " + r10.getResultCode());
        return r10.getResultCode();
    L23:
        return 0;
    L21:
        return 0;
    }

    private int storePseudoUID(Context r1, String r2, String r3, String r4) {
        if (isRPUIDExist(r1, r2, r3) == true) goto L12;
        SecretData r0 = new SecretData();
        r0.privateData = r4;
        r0.associate = r2;
        r0.alias = b.d(r2, r3);
        r0.dataType = "RPUID";
        AddResult r5 = SecretDataManager.getInstance().addData(r1, r0, new Bundle());
        if (r5 != null) goto L9;
        com.bytedance.privacy.f.b.b(TAG, "addResult is null, SecretDataManager service failed!!");
        return -14;
    L9:
        if (r5.getResultCode() == 0) goto L14;
        com.bytedance.privacy.f.b.b(TAG, "Store RPUID failed!! result: " + r5.getResultCode());
        return r5.getResultCode();
    L14:
        return 0;
    L12:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.bytedance.privacy.pseudoid.PseudoManager] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public String getPseudoDID(Context r16, String r17) {
        String r2 = r17;
        long r4 = System.currentTimeMillis();
        String r6 = TAG;
        com.bytedance.privacy.f.b.d(r6, "getPseudoDID enter");
        if (r16 == null) goto L125;
        if (r2 == null) goto L125;
        String r11 = r16.getPackageName();     // Catch: Throwable -> L132 Exception -> L135
    L123:
        e = e;
        String r10 = r11;
    L162:
    L148:
        th = move-exception;
        Throwable r7 = th;
        r11 = r10;
    L150:
        long r5 = System.currentTimeMillis() - r4;
        if (r2 != null) goto L154;
        r2 = "";
    L154:
        a.a(0, 0, r11, r2, r5);
        throw r7;
    L138:
        if (e.getMessage() != null) goto L140;
        String r0 = e.getClass().getSimpleName();     // Catch: Throwable -> L148
    L141:
        com.bytedance.privacy.f.b.b(TAG, "getPseudoDID failed, error: " + r0);     // Catch: Throwable -> L148
        long r12 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L145;
        String r13 = r2;
    L146:
        a.a(0, 0, r10, r13, r12);
        return null;
    L145:
        r13 = "";
        goto L146
    L140:
        r0 = e.getMessage();     // Catch: Throwable -> L148
    L121:
        th = move-exception;
        r7 = th;
        goto L150
    L8:
        if (r17.isEmpty() == false) goto L10;
    L114:
        com.bytedance.privacy.f.b.b(r6, "AppId size is invalid!!");     // Catch: Throwable -> L121 Exception -> L123
        long r14 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L118;
        String r15 = r2;
    L119:
        a.a(-3, 0, r11, r15, r14);
        return null;
    L118:
        r15 = "";
        goto L119
    L10:
        if (r17.length() > 128) goto L114;
        com.bytedance.privacy.pseudoid.c.a r3 = com.bytedance.privacy.pseudoid.c.a.f5466a;     // Catch: Throwable -> L121 Exception -> L123
        ?? r9 = r3.a();     // Catch: Throwable -> L121 Exception -> L123
        if (r9.isEmpty() == false) goto L22;
        com.bytedance.privacy.f.b.b(r6, "deviceId is empty!");     // Catch: Throwable -> L121 Exception -> L123
        long r18 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L18;
        String r19 = r2;
    L19:
        a.a(-4, 0, r11, r19, r18);
        return null;
    L18:
        r19 = "";
        goto L19
    L22:
        if (d.a() == false) goto L34;
        if (d.b(1) == false) goto L34;
        com.bytedance.privacy.f.b.a(r6, "getPseudoDID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L121 Exception -> L123
        String r110 = r17.intern();     // Catch: Throwable -> L121 Exception -> L123
        monitor-enter(r110);     // Catch: Throwable -> L121 Exception -> L123
        deletePseudoIDs(r16, r17);     // Catch: Throwable -> L30
        monitor-exit(r110);     // Catch: Throwable -> L30
    L46:
        String r111 = r17.intern();     // Catch: Throwable -> L121 Exception -> L123
        monitor-enter(r111);     // Catch: Throwable -> L121 Exception -> L123
    L172:
        th = th;
    L112:
        monitor-exit(r111);     // Catch: Throwable -> L111
    L111:
        th = th;
        goto L112
    L113:
        throw th;     // Catch: Throwable -> L121 Exception -> L123
    L167:
        if (isRPDIDExist(r16, r2, r9) == false) goto L68;
        String r1 = queryRPDID(r16, r2, r9);     // Catch: Throwable -> L111
    L66:
        th = th;
        goto L112
    L52:
        if (TextUtils.isEmpty(r1) == false) goto L55;
        com.bytedance.privacy.f.b.b(r6, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L66
        int r20 = -6;
    L56:
        monitor-exit(r111);     // Catch: Throwable -> L63
        long r112 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L60;
        String r113 = r2;
    L61:
        a.a(r20, 0, r11, r113, r112);
        return r1;
    L60:
        r113 = "";
        goto L61
    L55:
        r20 = 0;
        goto L56
    L68:
        com.bytedance.privacy.f.b.d(r6, "need to get pseudoID from cloud");     // Catch: Throwable -> L111
        if (r3.f() == true) goto L72;
        com.bytedance.privacy.f.b.d(r6, "Account is not login!!");     // Catch: Throwable -> L111
        String r8 = "";
    L71:
        int r21 = getPseudoIDFromCloud(r16, r9, r8, r2);     // Catch: Throwable -> L111
        if (r21 == 0) goto L94;
        com.bytedance.privacy.f.b.b(r6, "get pseudoID from cloud failed, error: " + r21);     // Catch: Throwable -> L109
        monitor-exit(r111);     // Catch: Throwable -> L109
        long r114 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L91;
        String r115 = r2;
    L92:
        a.a(r21, 0, r11, r115, r114);
        return null;
    L91:
        r115 = "";
        goto L92
    L94:
        String r22 = queryRPDID(r16, r2, r9);     // Catch: Throwable -> L109
    L107:
        th = th;
        goto L112
    L96:
        if (TextUtils.isEmpty(r22) == false) goto L99;
        com.bytedance.privacy.f.b.b(r6, "RPDID store success, but query failed!");     // Catch: Throwable -> L107
        int r23 = -6;
    L100:
        monitor-exit(r111);     // Catch: Throwable -> L63
        long r116 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L104;
        String r117 = r2;
    L105:
        a.a(r23, 0, r11, r117, r116);
        return r22;
    L104:
        r117 = "";
        goto L105
    L99:
        r23 = r21;
    L109:
        th = th;
        goto L112
    L72:
        com.bytedance.privacy.f.b.d(r6, "Account is login!!");     // Catch: Throwable -> L111
        r8 = r3.c();     // Catch: Throwable -> L111
        if (r8.isEmpty() == false) goto L71;
        com.bytedance.privacy.f.b.b(r6, "Account is login, but userId is empty!");     // Catch: Throwable -> L111
        r9 = -5;
        monitor-exit(r111);     // Catch: Throwable -> L83
        long r118 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L80;
        String r119 = r2;
    L81:
        a.a(-5, 0, r11, r119, r118);
        return null;
    L80:
        r119 = "";
    L83:
        th = th;
    L63:
        th = th;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L121 Exception -> L123
    L34:
        if (isRPDIDExist(r16, r2, r9) == false) goto L46;
        String r24 = queryRPDID(r16, r2, r9);     // Catch: Throwable -> L121 Exception -> L123
        if (TextUtils.isEmpty(r24) == false) goto L39;
        com.bytedance.privacy.f.b.b(r6, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L121 Exception -> L123
        int r25 = -6;
    L40:
        long r120 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L43;
        String r121 = r2;
    L44:
        a.a(r25, 0, r11, r121, r120);
        return r24;
    L43:
        r121 = "";
        goto L44
    L39:
        r25 = 0;
    L125:
        com.bytedance.privacy.f.b.b(r6, "Context or appId is null!!");     // Catch: Throwable -> L132 Exception -> L135
        long r26 = System.currentTimeMillis() - r4;
        if (r2 != null) goto L130;
        r2 = "";
    L130:
        a.a(-2, 0, "", r2, r26);
        return null;
    L135:
        e = e;
        r10 = "";
    L132:
        th = move-exception;
        r7 = th;
        r11 = "";
        goto L150
    }

    public String getPseudoUID(Context r16, String r17) {
        String r2 = r17;
        long r4 = System.currentTimeMillis();
        String r6 = TAG;
        com.bytedance.privacy.f.b.d(r6, "getPseudoUID enter");
        if (r16 == null) goto L124;
        if (r2 == null) goto L124;
        String r11 = r16.getPackageName();     // Catch: Throwable -> L131 Exception -> L134
    L122:
        e = e;
        String r10 = r11;
    L164:
    L147:
        th = move-exception;
        Throwable r7 = th;
        r11 = r10;
    L149:
        long r5 = System.currentTimeMillis() - r4;
        if (r2 != null) goto L153;
        r2 = "";
    L153:
        a.a(0, 1, r11, r2, r5);
        throw r7;
    L137:
        if (e.getMessage() != null) goto L139;
        String r0 = e.getClass().getSimpleName();     // Catch: Throwable -> L147
    L140:
        com.bytedance.privacy.f.b.b(TAG, "getPseudoUID failed, error: " + r0);     // Catch: Throwable -> L147
        long r12 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L144;
        String r13 = r2;
    L145:
        a.a(0, 1, r10, r13, r12);
        return null;
    L144:
        r13 = "";
        goto L145
    L139:
        r0 = e.getMessage();     // Catch: Throwable -> L147
    L120:
        th = move-exception;
        r7 = th;
        goto L149
    L8:
        if (r17.isEmpty() == false) goto L10;
    L113:
        com.bytedance.privacy.f.b.b(r6, "AppId size is invalid!!");     // Catch: Throwable -> L120 Exception -> L122
        long r14 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L117;
        String r15 = r2;
    L118:
        a.a(-3, 1, r11, r15, r14);
        return null;
    L117:
        r15 = "";
        goto L118
    L10:
        if (r17.length() > 128) goto L113;
        com.bytedance.privacy.pseudoid.c.a r3 = com.bytedance.privacy.pseudoid.c.a.f5466a;     // Catch: Throwable -> L120 Exception -> L122
        if (r3.f() == true) goto L21;
        com.bytedance.privacy.f.b.b(r6, "Account is not login, no userId!!");     // Catch: Throwable -> L120 Exception -> L122
        long r18 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L18;
        String r19 = r2;
    L19:
        a.a(-20, 1, r11, r19, r18);
        return null;
    L18:
        r19 = "";
        goto L19
    L21:
        String r9 = r3.c();     // Catch: Throwable -> L120 Exception -> L122
        if (r9.isEmpty() == false) goto L31;
        com.bytedance.privacy.f.b.b(r6, "Account is login, but userId is empty!");     // Catch: Throwable -> L120 Exception -> L122
        long r110 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L27;
        String r111 = r2;
    L28:
        a.a(-5, 1, r11, r111, r110);
        return null;
    L27:
        r111 = "";
        goto L28
    L31:
        if (d.a() == false) goto L43;
        if (d.b(1) == false) goto L43;
        com.bytedance.privacy.f.b.a(r6, " getPseudoUID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L120 Exception -> L122
        String r112 = r17.intern();     // Catch: Throwable -> L120 Exception -> L122
        monitor-enter(r112);     // Catch: Throwable -> L120 Exception -> L122
        deletePseudoIDs(r16, r17);     // Catch: Throwable -> L39
        monitor-exit(r112);     // Catch: Throwable -> L39
    L55:
        com.bytedance.privacy.f.b.d(r6, "need to get pseudoID from cloud");     // Catch: Throwable -> L120 Exception -> L122
        String r8 = r3.a();     // Catch: Throwable -> L120 Exception -> L122
        if (r8.isEmpty() == false) goto L64;
        com.bytedance.privacy.f.b.b(r6, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L120 Exception -> L122
        long r113 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L61;
        String r114 = r2;
    L62:
        a.a(-4, 1, r11, r114, r113);
        return null;
    L61:
        r114 = "";
        goto L62
    L64:
        String r115 = r17.intern();     // Catch: Throwable -> L120 Exception -> L122
        monitor-enter(r115);     // Catch: Throwable -> L120 Exception -> L122
    L110:
        th = th;
    L111:
        monitor-exit(r115);     // Catch: Throwable -> L110
        throw th;     // Catch: Throwable -> L120 Exception -> L122
    L67:
        if (isRPUIDExist(r16, r2, r9) == false) goto L85;
        String r1 = queryRPUID(r16, r2, r9);     // Catch: Throwable -> L110
    L83:
        th = th;
    L155:
        goto L111
    L70:
        if (TextUtils.isEmpty(r1) == false) goto L73;
        com.bytedance.privacy.f.b.b(r6, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L83
        int r20 = -7;
    L158:
        monitor-exit(r115);     // Catch: Throwable -> L81
        long r116 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L78;
        String r117 = r2;
    L79:
        a.a(r20, 1, r11, r117, r116);
        return r1;
    L78:
        r117 = "";
    L81:
        th = th;
        goto L155
    L73:
        r20 = 0;
        goto L158
    L85:
        int r21 = getPseudoIDFromCloud(r16, r8, r9, r2);     // Catch: Throwable -> L110
        if (r21 == 0) goto L95;
        com.bytedance.privacy.f.b.b(r6, "get pseudoID from cloud failed, error: " + r21);     // Catch: Throwable -> L108
        monitor-exit(r115);     // Catch: Throwable -> L108
        long r118 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L92;
        String r119 = r2;
    L93:
        a.a(r21, 1, r11, r119, r118);
        return null;
    L92:
        r119 = "";
        goto L93
    L95:
        String r22 = queryRPUID(r16, r2, r9);     // Catch: Throwable -> L108
    L106:
        th = th;
        goto L155
    L97:
        if (TextUtils.isEmpty(r22) == false) goto L99;
        com.bytedance.privacy.f.b.b(r6, "RPUID store success, but query failed!");     // Catch: Throwable -> L106
    L99:
        monitor-exit(r115);     // Catch: Throwable -> L106
        long r120 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L103;
        String r121 = r2;
    L104:
        a.a(r21, 1, r11, r121, r120);
        return r22;
    L103:
        r121 = "";
    L108:
        th = th;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L120 Exception -> L122
    L43:
        if (isRPUIDExist(r16, r2, r9) == false) goto L55;
        String r23 = queryRPUID(r16, r2, r9);     // Catch: Throwable -> L120 Exception -> L122
        if (TextUtils.isEmpty(r23) == false) goto L48;
        com.bytedance.privacy.f.b.b(r6, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L120 Exception -> L122
        int r24 = -7;
    L49:
        long r122 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L52;
        String r123 = r2;
    L53:
        a.a(r24, 1, r11, r123, r122);
        return r23;
    L52:
        r123 = "";
        goto L53
    L48:
        r24 = 0;
    L124:
        com.bytedance.privacy.f.b.b(r6, "Context or app Id is null!!");     // Catch: Throwable -> L131 Exception -> L134
        long r25 = System.currentTimeMillis() - r4;
        if (r2 != null) goto L129;
        r2 = "";
    L129:
        a.a(-2, 1, "", r2, r25);
        return null;
    L134:
        e = e;
        r10 = "";
    L131:
        th = move-exception;
        r7 = th;
        r11 = "";
        goto L149
    }

    public String queryDIDFromRPDID(Context r4, String r5, String r6) {
        if (r4 == null) goto L31;
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        if (r5.isEmpty() == false) goto L10;
    L30:
        String r7 = TAG;
        String r8 = "AppId or rpDID size is invalid!!";
    L27:
        com.bytedance.privacy.f.b.b(r7, r8);
        return null;
    L10:
        if (r5.length() > 128) goto L30;
        if (r6.isEmpty() == true) goto L30;
        Bundle r0 = new Bundle();
        r0.putInt("query_mode", 2);
        QueryResult r9 = SecretDataManager.getInstance().queryData(r4, b.b(r5, r6), r0);
        if (r9 != null) goto L17;
    L29:
        r7 = TAG;
        r8 = "Query original deviceId failed!!";
        goto L27
    L17:
        if (r9.getResultCode() != 0) goto L29;
        SecretData r10 = (SecretData) r9.getDataList().get(0);
        if (r10.privateData != null) goto L22;
    L26:
        r7 = TAG;
        r8 = "Query success, but original deviceId is null!!";
        goto L27
    L22:
        if (r10.privateData.isEmpty() == true) goto L26;
        return r10.privateData;
    L31:
        r7 = TAG;
        r8 = "input param is null!!";
        goto L27
    }
}
