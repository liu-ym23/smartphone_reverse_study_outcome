package com.bytedance.privacy.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.network.ChallengeManager;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttestKeyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AttestKeyManager f10a;

    public static void a(Context r3, String r4) {
        int r5 = SecurityFrameworkCompat.e(r3, r4, new Bundle());
        SecurityFrameworkCompat.i();
        if (r5 != 0) goto L5;
        LogUtils.d("AttestKeyManager", "Deleted attest key successfully: " + r4);
        return;
    L5:
        LogUtils.b("AttestKeyManager", "Failed to delete attest key: " + r4 + ", ret: " + r5);
    }

    public static int b(Context r0, String r1, Bundle r2) {
        int r3 = SecurityFrameworkCompat.h(r0, r1, r2);
        SecurityFrameworkCompat.i();
        if (r3 == 0) goto L6;
        LogUtils.b("AttestKeyManager", "Generate key pair failed! ret:" + r3);
        return r3;
    L6:
        SecurityFrameworkCompat.i();
        return 0;
    }

    public static List c(Context r4, String r5, Bundle r6, Bundle r7) {
        String r0 = ChallengeManager.b();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        LogUtils.b("AttestKeyManager", "Request challenge failed!!");
        return new ArrayList();
    L6:
        LogUtils.a("AttestKeyManager", "Request challenge succeed! challenge:" + r0);
        int r8 = b(r4, "ocean_securityserver", r6);
        SecurityFrameworkCompat.i();
        if (r8 == 0) goto L10;
        LogUtils.b("AttestKeyManager", "Generate attestation key pair failed! ret:" + r8);
        return new ArrayList();
    L10:
        SecurityFrameworkCompat.d();
        r7.putString("challenge", r0 + ":" + r5 + ":ocean_securityserver");
        SecurityFrameworkCompat.KeyManagerResultCompat r9 = SecurityFrameworkCompat.k(r4, "ocean_securityserver", r7);
        SecurityFrameworkCompat.i();
        int r10 = r9.f29a;
        if (r10 == 0) goto L13;
        LogUtils.b("AttestKeyManager", "Attest key with ids failed! ret:" + r10);
        List r11 = new ArrayList();
    L21:
        if (r11.isEmpty() == false) goto L24;
        LogUtils.b("AttestKeyManager", "attestKeyWithIds failed, delete keyAlias: ocean_securityserver");
        a(r4, "ocean_securityserver");
        return new ArrayList();
    L24:
        return r11;
    L13:
        r11 = r9.b;
        if (r11 != null) goto L16;
    L19:
        LogUtils.b("AttestKeyManager", "keyAttestation result certChain invalid for keyAlias=ocean_securityserver");
        r11 = new ArrayList();
        goto L21
    L16:
        if (r11.isEmpty() == true) goto L19;
        LogUtils.a("AttestKeyManager", "Attest key with ids succeed! keyAlias=ocean_securityserver, cert chain size: " + r11.size());
        goto L21
    }

    public static AttestKeyManager d() {
        if (f10a != null) goto L16;
        monitor-enter(AttestKeyManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f10a != null) goto L11;
        f10a = new AttestKeyManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AttestKeyManager.class);     // Catch: Throwable -> L9
    L16:
        return f10a;
    }
}
