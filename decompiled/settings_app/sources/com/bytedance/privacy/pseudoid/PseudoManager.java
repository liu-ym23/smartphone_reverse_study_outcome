package com.bytedance.privacy.pseudoid;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.pseudoid.network.NetworkManager;
import com.bytedance.privacy.pseudoid.network.NetworkRequest;
import com.bytedance.privacy.pseudoid.network.NetworkResponse;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.PrivacyConfig;
import java.security.cert.Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PseudoManager {
    public static final String TAG = "PseudoManager";
    private static volatile PseudoManager pseudoManager;

    static {
    }

    public PseudoManager() {
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

    public String getPseudoDID(Context r18, String r19) {
        String r2 = r19;
        long r4 = System.currentTimeMillis();
        String r7 = TAG;
        LogUtils.i(r7, "getPseudoDID enter");
        if (r18 == null) goto L121;
        if (r2 == null) goto L121;
        String r13 = r18.getPackageName();     // Catch: Throwable -> L128 Exception -> L131
    L119:
        e = e;
    L155:
        LogUtils.e(TAG, "getPseudoDID failed, error=" + e.getClass().getSimpleName());     // Catch: Throwable -> L141
        long r15 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L138;
        String r14 = r2;
    L139:
        PseudoIDEventTrace.eventTrace(0, 0, r13, r14, r15);
        return null;
    L138:
        r14 = "";
    L141:
        th = move-exception;
        Throwable r6 = th;
        int r0 = 0;
    L143:
        long r5 = System.currentTimeMillis() - r4;
        if (r2 != null) goto L147;
        r2 = "";
    L147:
        PseudoIDEventTrace.eventTrace(r0, 0, r13, r2, r5);
        throw r6;
    L117:
        th = th;
    L130:
        r6 = th;
        r0 = 0;
        goto L143
    L8:
        if (r19.isEmpty() == false) goto L10;
    L110:
        LogUtils.e(r7, "AppId size is invalid!!");     // Catch: Throwable -> L117 Exception -> L119
        long r16 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L114;
        String r17 = r2;
    L115:
        PseudoIDEventTrace.eventTrace(-3, 0, r13, r17, r16);
        return null;
    L114:
        r17 = "";
        goto L115
    L10:
        if (r19.length() > 128) goto L110;
        String r8 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L117 Exception -> L119
        if (r8.isEmpty() == false) goto L21;
        LogUtils.e(r7, "deviceId is empty!");     // Catch: Throwable -> L117 Exception -> L119
        long r110 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L18;
        String r111 = r2;
    L19:
        PseudoIDEventTrace.eventTrace(-4, 0, r13, r111, r110);
        return null;
    L18:
        r111 = "";
        goto L19
    L21:
        int r11 = -6;
        if (PrivacyConfig.isDebug() == false) goto L34;
        if (PrivacyConfig.isForceFetchFromCloud(1) == false) goto L34;
        LogUtils.d(r7, "getPseudoDID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L117 Exception -> L119
        String r9 = r19.intern();     // Catch: Throwable -> L117 Exception -> L119
        monitor-enter(r9);     // Catch: Throwable -> L117 Exception -> L119
        deletePseudoIDs(r18, r19);     // Catch: Throwable -> L30
        monitor-exit(r9);     // Catch: Throwable -> L30
    L46:
        String r10 = r19.intern();     // Catch: Throwable -> L117 Exception -> L119
        monitor-enter(r10);     // Catch: Throwable -> L117 Exception -> L119
    L107:
        th = th;
    L108:
        monitor-exit(r10);     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L117 Exception -> L119
    L149:
        if (isRPDIDExist(r18, r2, r8) == false) goto L68;
        String r1 = queryRPDID(r18, r2, r8);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r1) == false) goto L55;
        LogUtils.e(r7, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L66
    L56:
        monitor-exit(r10);     // Catch: Throwable -> L63
        long r112 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L60;
        String r113 = r2;
    L61:
        PseudoIDEventTrace.eventTrace(r11, 0, r13, r113, r112);
        return r1;
    L60:
        r113 = "";
        goto L61
    L55:
        r11 = 0;
        goto L56
    L68:
        LogUtils.i(r7, "need to get pseudoID from cloud");     // Catch: Throwable -> L107
        if (AccountApi.INSTANCE.isLogin() == true) goto L71;
        LogUtils.i(r7, "Account is not login!!");     // Catch: Throwable -> L107
        int r12 = getPseudoIDFromCloud(r18, r8, "", r2);     // Catch: Throwable -> L107
    L85:
        if (r12 == 0) goto L94;
        LogUtils.e(r7, "get pseudoID from cloud failed, error: " + r12);     // Catch: Throwable -> L107
        monitor-exit(r10);     // Catch: Throwable -> L107
        long r114 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L91;
        String r115 = r2;
    L92:
        PseudoIDEventTrace.eventTrace(r12, 0, r13, r115, r114);
        return null;
    L91:
        r115 = "";
        goto L92
    L94:
        String r3 = queryRPDID(r18, r2, r8);     // Catch: Throwable -> L107
        if (TextUtils.isEmpty(r3) == false) goto L99;
        LogUtils.e(r7, "RPDID store success, but query failed!");     // Catch: Throwable -> L66
    L100:
        monitor-exit(r10);     // Catch: Throwable -> L63
        long r116 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L104;
        String r117 = r2;
    L105:
        PseudoIDEventTrace.eventTrace(r11, 0, r13, r117, r116);
        return r3;
    L104:
        r117 = "";
        goto L105
    L99:
        r11 = r12;
        goto L100
    L71:
        LogUtils.i(r7, "Account is login!!");     // Catch: Throwable -> L107
        String r118 = AccountApi.INSTANCE.getUserId();     // Catch: Throwable -> L107
        if (r118.isEmpty() == false) goto L84;
        LogUtils.e(r7, "Account is login, but userId is empty!");     // Catch: Throwable -> L107
        r11 = -5;
        monitor-exit(r10);     // Catch: Throwable -> L82
        long r119 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L79;
        String r120 = r2;
    L80:
        PseudoIDEventTrace.eventTrace(-5, 0, r13, r120, r119);
        return null;
    L79:
        r120 = "";
    L82:
        th = th;
        goto L108
    L84:
        r12 = getPseudoIDFromCloud(r18, r8, r118, r2);     // Catch: Throwable -> L107
    L66:
        th = th;
    L63:
        th = th;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L117 Exception -> L119
    L34:
        if (isRPDIDExist(r18, r2, r8) == false) goto L46;
        String r121 = queryRPDID(r18, r2, r8);     // Catch: Throwable -> L117 Exception -> L119
        if (TextUtils.isEmpty(r121) == false) goto L39;
        LogUtils.e(r7, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L117 Exception -> L119
    L40:
        long r122 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L43;
        String r123 = r2;
    L44:
        PseudoIDEventTrace.eventTrace(r11, 0, r13, r123, r122);
        return r121;
    L43:
        r123 = "";
        goto L44
    L39:
        r11 = 0;
    L121:
        LogUtils.e(r7, "Context or appId is null!!");     // Catch: Throwable -> L128 Exception -> L131
        long r20 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L125;
        String r21 = r2;
    L126:
        PseudoIDEventTrace.eventTrace(-2, 0, "", r21, r20);
        return null;
    L125:
        r21 = "";
    L131:
        e = e;
        r13 = "";
    L128:
        th = th;
        r13 = "";
        goto L130
    }

    public String getPseudoUID(Context r18, String r19) {
        String r2 = r19;
        long r4 = System.currentTimeMillis();
        String r7 = TAG;
        LogUtils.i(r7, "getPseudoUID enter");
        if (r18 == null) goto L122;
        if (r2 == null) goto L122;
        String r13 = r18.getPackageName();     // Catch: Throwable -> L129 Exception -> L132
    L120:
        e = e;
    L158:
        LogUtils.e(TAG, "getPseudoUID failed, error=" + e.getClass().getSimpleName());     // Catch: Throwable -> L142
        long r15 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L139;
        String r14 = r2;
    L140:
        PseudoIDEventTrace.eventTrace(0, 1, r13, r14, r15);
        return null;
    L139:
        r14 = "";
    L142:
        th = move-exception;
        Throwable r6 = th;
        int r0 = 0;
    L144:
        long r5 = System.currentTimeMillis() - r4;
        if (r2 != null) goto L148;
        r2 = "";
    L148:
        PseudoIDEventTrace.eventTrace(r0, 1, r13, r2, r5);
        throw r6;
    L118:
        th = th;
    L131:
        r6 = th;
        r0 = 0;
        goto L144
    L8:
        if (r19.isEmpty() == false) goto L10;
    L111:
        LogUtils.e(r7, "AppId size is invalid!!");     // Catch: Throwable -> L118 Exception -> L120
        long r16 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L115;
        String r17 = r2;
    L116:
        PseudoIDEventTrace.eventTrace(-3, 1, r13, r17, r16);
        return null;
    L115:
        r17 = "";
        goto L116
    L10:
        if (r19.length() > 128) goto L111;
        if (AccountApi.INSTANCE.isLogin() == true) goto L21;
        LogUtils.e(r7, "Account is not login, no userId!!");     // Catch: Throwable -> L118 Exception -> L120
        long r110 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L18;
        String r111 = r2;
    L19:
        PseudoIDEventTrace.eventTrace(-20, 1, r13, r111, r110);
        return null;
    L18:
        r111 = "";
        goto L19
    L21:
        String r8 = AccountApi.INSTANCE.getUserId();     // Catch: Throwable -> L118 Exception -> L120
        if (r8.isEmpty() == false) goto L30;
        LogUtils.e(r7, "Account is login, but userId is empty!");     // Catch: Throwable -> L118 Exception -> L120
        long r112 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L27;
        String r113 = r2;
    L28:
        PseudoIDEventTrace.eventTrace(-5, 1, r13, r113, r112);
        return null;
    L27:
        r113 = "";
        goto L28
    L30:
        int r11 = -7;
        if (PrivacyConfig.isDebug() == false) goto L43;
        if (PrivacyConfig.isForceFetchFromCloud(1) == false) goto L43;
        LogUtils.d(r7, " getPseudoUID forceFetchFromCloud enabled, skip local check.");     // Catch: Throwable -> L118 Exception -> L120
        String r9 = r19.intern();     // Catch: Throwable -> L118 Exception -> L120
        monitor-enter(r9);     // Catch: Throwable -> L118 Exception -> L120
        deletePseudoIDs(r18, r19);     // Catch: Throwable -> L39
        monitor-exit(r9);     // Catch: Throwable -> L39
    L55:
        LogUtils.i(r7, "need to get pseudoID from cloud");     // Catch: Throwable -> L118 Exception -> L120
        String r10 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L118 Exception -> L120
        if (r10.isEmpty() == false) goto L64;
        LogUtils.e(r7, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L118 Exception -> L120
        long r114 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L61;
        String r115 = r2;
    L62:
        PseudoIDEventTrace.eventTrace(-4, 1, r13, r115, r114);
        return null;
    L61:
        r115 = "";
        goto L62
    L64:
        String r12 = r19.intern();     // Catch: Throwable -> L118 Exception -> L120
        monitor-enter(r12);     // Catch: Throwable -> L118 Exception -> L120
    L162:
        th = th;
    L109:
        monitor-exit(r12);     // Catch: Throwable -> L108
    L108:
        th = th;
        goto L109
    L110:
        throw th;     // Catch: Throwable -> L118 Exception -> L120
    L152:
        if (isRPUIDExist(r18, r2, r8) == false) goto L83;
        String r1 = queryRPUID(r18, r2, r8);     // Catch: Throwable -> L108
    L81:
        th = th;
        goto L109
    L70:
        if (TextUtils.isEmpty(r1) == false) goto L73;
        LogUtils.e(r7, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L81
    L74:
        monitor-exit(r12);     // Catch: Throwable -> L104
        long r116 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L78;
        String r117 = r2;
    L79:
        PseudoIDEventTrace.eventTrace(r11, 1, r13, r117, r116);
        return r1;
    L78:
        r117 = "";
        goto L79
    L73:
        r11 = 0;
        goto L74
    L83:
        r11 = getPseudoIDFromCloud(r18, r10, r8, r2);     // Catch: Throwable -> L108
        if (r11 == 0) goto L93;
        LogUtils.e(r7, "get pseudoID from cloud failed, error: " + r11);     // Catch: Throwable -> L106
        monitor-exit(r12);     // Catch: Throwable -> L106
        long r118 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L90;
        String r119 = r2;
    L91:
        PseudoIDEventTrace.eventTrace(r11, 1, r13, r119, r118);
        return null;
    L90:
        r119 = "";
        goto L91
    L93:
        String r3 = queryRPUID(r18, r2, r8);     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(r3) == false) goto L97;
        LogUtils.e(r7, "RPUID store success, but query failed!");     // Catch: Throwable -> L104
    L97:
        monitor-exit(r12);     // Catch: Throwable -> L104
        long r120 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L101;
        String r121 = r2;
    L102:
        PseudoIDEventTrace.eventTrace(r11, 1, r13, r121, r120);
        return r3;
    L101:
        r121 = "";
    L106:
        th = th;
    L104:
        th = th;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L118 Exception -> L120
    L43:
        if (isRPUIDExist(r18, r2, r8) == false) goto L55;
        String r122 = queryRPUID(r18, r2, r8);     // Catch: Throwable -> L118 Exception -> L120
        if (TextUtils.isEmpty(r122) == false) goto L48;
        LogUtils.e(r7, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L118 Exception -> L120
    L49:
        long r123 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L52;
        String r124 = r2;
    L53:
        PseudoIDEventTrace.eventTrace(r11, 1, r13, r124, r123);
        return r122;
    L52:
        r124 = "";
        goto L53
    L48:
        r11 = 0;
    L122:
        LogUtils.e(r7, "Context or app Id is null!!");     // Catch: Throwable -> L129 Exception -> L132
        long r20 = System.currentTimeMillis() - r4;
        if (r2 == null) goto L126;
        String r21 = r2;
    L127:
        PseudoIDEventTrace.eventTrace(-2, 1, "", r21, r20);
        return null;
    L126:
        r21 = "";
    L132:
        e = e;
        r13 = "";
    L129:
        th = th;
        r13 = "";
        goto L131
    }

    private int getPseudoIDFromCloud(Context r3, String r4, String r5, String r6) {
        if (r3 == null) goto L14;
        if (r6 == null) goto L14;
        if (r4 != null) goto L8;
    L12:
        LogUtils.e(TAG, "deviceId cannot be empty!!");
        return -2;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return requestPseudoID(r3, r4, r5, r6);
    L14:
        LogUtils.e(TAG, "context or appID is null!!");
        return -2;
    }

    private int requestPseudoID(Context r10, String r11, String r12, String r13) {
        String r0 = TAG;
        LogUtils.d(r0, "request PseudoID, PackageName: " + r10.getPackageName());
        LogUtils.d(r0, "request PseudoID, appId:" + r13);
        LogUtils.d(r0, "request PseudoID, deviceId:" + r11);
        if (r12.isEmpty() == true) goto L5;
        LogUtils.d(r0, "request PseudoID, userId:" + r12);
    L5:
        NetworkRequest r1 = new NetworkRequest();
        r1.setRequestType("POST");
        r1.setRequestUrl(NetworkManager.getPseudoIDUrl());
        AttestKeyManager.getInstance().deleteAttestKey(r10, r13);
        Bundle r8 = new Bundle();
        r8.putInt(SecurityFrameworkCompat.keyAlgoKey(), SecurityFrameworkCompat.keyAlgorithmEcc());
        r8.putInt(SecurityFrameworkCompat.keyLenKey(), 256);
        r8.putInt(SecurityFrameworkCompat.keyPurposeKey(), SecurityFrameworkCompat.purposeAttestKey());
        List<Certificate> r2 = AttestKeyManager.getInstance().getAttestCertChain(r10, r13, r11, false, r8);
        if (r2 != null) goto L8;
    L42:
        LogUtils.e(r0, "Get attest cert chain failed!!");
        int r9 = -9;
    L43:
        AttestKeyManager.getInstance().deleteAttestKey(r10, r13);
        LogUtils.i(TAG, "requestPseudoID end, result:" + r9);
        return r9;
    L8:
        if (r2.isEmpty() == true) goto L42;
        r1.setCertChain(CertUtils.certsToPemString(r2, 3));     // Catch: Exception -> L40
        NetworkResponse r3 = NetworkManager.getInstance().executeRequest(r1);
        LogUtils.d(r0, "response code:" + r3.getCode());
        if (r3.getCode() >= 200) goto L15;
    L39:
        LogUtils.e(r0, "Network request failed, error code:" + r3.getCode());
        r9 = -21;
        goto L43
    L15:
        if (r3.getCode() >= 300) goto L39;
        if (r3.getPseudoID() != null) goto L20;
        LogUtils.e(r0, "Network response pseudoID is null!");
        r9 = -8;
        goto L43
    L20:
        LogUtils.d(r0, "PRDID:" + r3.getPseudoID().getRPDID());
        LogUtils.d(r0, "PRUID:" + r3.getPseudoID().getRPUID());
        if (r11.isEmpty() == false) goto L23;
        int r14 = 0;
    L31:
        if (r12.isEmpty() == false) goto L33;
    L38:
        r9 = r14;
        goto L43
    L33:
        if (r3.getPseudoID().getRPUID().isEmpty() == false) goto L35;
        LogUtils.e(r0, "Network response RPUID is empty!!");
    L25:
        r9 = -22;
        goto L43
    L35:
        r9 = storePseudoUID(r10, r13, r12, r3.getPseudoID().getRPUID());
        if (r9 == 0) goto L43;
        LogUtils.e(r0, "storePseudoUID failed!, result:" + r9);
        goto L43
    L23:
        if (r3.getPseudoID().getRPDID().isEmpty() == false) goto L26;
        LogUtils.e(r0, "Network response RPDID is empty!!");
        goto L25
    L26:
        r14 = storePseudoDID(r10, r13, r11, r3.getPseudoID().getRPDID());
        if (r14 == 0) goto L31;
        LogUtils.e(r0, "storePseudoDID failed!, result:" + r14);
    L40:
        e = move-exception;
        LogUtils.e(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        r9 = -100;
        goto L43
    }

    private boolean isRPDIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModeIfDataExist());
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.querySecretData(r3, RPIDStoreConfig.buildRPDIDAlias(r4, r5), r2);
        if (r6.isNull() == false) goto L5;
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isDeviceIdExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModeIfDataExist());
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.querySecretData(r3, RPIDStoreConfig.buildDeviceIdAlias(r4, r5), r2);
        if (r6.isNull() == false) goto L5;
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isRPUIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModeIfDataExist());
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.querySecretData(r3, RPIDStoreConfig.buildRPUIDAlias(r4, r5), r2);
        if (r6.isNull() == false) goto L5;
        return false;
    L5:
        if (r6.getResultCode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    private String queryRPDID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModePreciseQueryAndDecrypt());
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.querySecretData(r3, RPIDStoreConfig.buildRPDIDAlias(r4, r5), r2);
        if (r6.isNull() == false) goto L5;
    L15:
        LogUtils.e(TAG, "Query RPDID failed!!");
        return null;
    L5:
        if (r6.getResultCode() != 0) goto L15;
        String r7 = r6.getFirstPrivateData();
        if (r7 != null) goto L10;
    L13:
        LogUtils.e(TAG, "Query success, but RPDID is null!!");
        return null;
    L10:
        if (r7.isEmpty() == true) goto L13;
        return r7;
    }

    public String queryDIDFromRPDID(Context r4, String r5, String r6) {
        if (r4 == null) goto L31;
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        if (r5.isEmpty() == false) goto L10;
    L29:
        LogUtils.e(TAG, "AppId or rpDID size is invalid!!");
        return null;
    L10:
        if (r5.length() > 128) goto L29;
        if (r6.isEmpty() == true) goto L29;
        Bundle r0 = new Bundle();
        r0.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModePreciseQueryAndDecrypt());
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.querySecretData(r4, RPIDStoreConfig.buildDeviceIdAlias(r5, r6), r0);
        if (r7.isNull() == false) goto L17;
    L27:
        LogUtils.e(TAG, "Query original deviceId failed!!");
        return null;
    L17:
        if (r7.getResultCode() != 0) goto L27;
        String r8 = r7.getFirstPrivateData();
        if (r8 != null) goto L22;
    L25:
        LogUtils.e(TAG, "Query success, but original deviceId is null!!");
        return null;
    L22:
        if (r8.isEmpty() == true) goto L25;
        return r8;
    L31:
        LogUtils.e(TAG, "input param is null!!");
        return null;
    }

    private String queryRPUID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        r2.putInt(SecurityFrameworkCompat.secretBundleKeyQueryMode(), SecurityFrameworkCompat.queryModePreciseQueryAndDecrypt());
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.querySecretData(r3, RPIDStoreConfig.buildRPUIDAlias(r4, r5), r2);
        if (r6.isNull() == false) goto L5;
    L15:
        LogUtils.e(TAG, "Query RPUID failed!!");
        return null;
    L5:
        if (r6.getResultCode() != 0) goto L15;
        String r7 = r6.getFirstPrivateData();
        if (r7 != null) goto L10;
    L13:
        LogUtils.e(TAG, "Query success, but RPUID is null!!");
        return null;
    L10:
        if (r7.isEmpty() == true) goto L13;
        return r7;
    }

    private int storePseudoDID(Context r11, String r12, String r13, String r14) {
        if (isRPDIDExist(r11, r12, r13) == true) goto L12;
        int r0 = SecurityFrameworkCompat.addSecretData(r11, r14, r12, RPIDStoreConfig.buildRPDIDAlias(r12, r13), "RPDID", new Bundle());
        if (r0 != (-1)) goto L8;
        LogUtils.e(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r0 == 0) goto L12;
        LogUtils.e(TAG, "Store RPDID failed!! result: " + r0);
        return r0;
    L12:
        if (isDeviceIdExist(r11, r12, r14) == true) goto L20;
        int r10 = SecurityFrameworkCompat.addSecretData(r11, r13, r12, RPIDStoreConfig.buildDeviceIdAlias(r12, r14), "DID", new Bundle());
        if (r10 != (-1)) goto L17;
        LogUtils.e(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L17:
        if (r10 == 0) goto L22;
        LogUtils.e(TAG, "Store deviceID failed!! result: " + r10);
        return r10;
    L22:
        return 0;
    L20:
        return 0;
    }

    private int storePseudoUID(Context r7, String r8, String r9, String r10) {
        if (isRPUIDExist(r7, r8, r9) == true) goto L11;
        int r6 = SecurityFrameworkCompat.addSecretData(r7, r10, r8, RPIDStoreConfig.buildRPUIDAlias(r8, r9), "RPUID", new Bundle());
        if (r6 != (-1)) goto L8;
        LogUtils.e(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r6 == 0) goto L13;
        LogUtils.e(TAG, "Store RPUID failed!! result: " + r6);
        return r6;
    L13:
        return 0;
    L11:
        return 0;
    }

    private void deletePseudoIDs(Context r6, String r7) {
        if (PrivacyConfig.isDebug() == false) goto L29;
        String r0 = AccountApi.INSTANCE.getDeviceId();
        if (isRPDIDExist(r6, r7, r0) == false) goto L22;
        String r1 = queryRPDID(r6, r7, r0);
        if (r1 != null) goto L9;
    L19:
        LogUtils.e(TAG, "RPDID is already stored, but query failed!");
        return;
    L9:
        if (r1.isEmpty() == true) goto L19;
        if (isDeviceIdExist(r6, r7, r1) == false) goto L16;
        int r2 = SecurityFrameworkCompat.deleteSecretData(r6, RPIDStoreConfig.buildDeviceIdAlias(r7, r1), new Bundle());
        if (r2 == 0) goto L16;
        LogUtils.e(TAG, "delete DeviceID failed, result = " + r2);
    L16:
        int r3 = SecurityFrameworkCompat.deleteSecretData(r6, RPIDStoreConfig.buildRPDIDAlias(r7, r0), new Bundle());
        if (r3 == 0) goto L22;
        LogUtils.e(TAG, "delete RPDID failed, result = " + r3);
    L22:
        if (AccountApi.INSTANCE.isLogin() == false) goto L30;
        String r4 = AccountApi.INSTANCE.getUserId();
        if (isRPUIDExist(r6, r7, r4) == false) goto L31;
        int r5 = SecurityFrameworkCompat.deleteSecretData(r6, RPIDStoreConfig.buildRPUIDAlias(r7, r4), new Bundle());
        if (r5 == 0) goto L32;
        LogUtils.e(TAG, "delete RPUID failed, result = " + r5);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }
}
