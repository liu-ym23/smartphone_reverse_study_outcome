package com.bytedance.privacy.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.f.b;
import com.obric.security.keymanager.KeyManager;
import com.obric.security.keymanager.KeyManagerResult;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5362a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f5363b;

    static {
    }

    public a() {
    }

    private List<Certificate> a(Context r3, String r4, String r5, boolean r6) {
        Bundle r2 = new Bundle();
        if (r6 == false) goto L5;
        r2.putBoolean("device_health_status_required", true);
    L5:
        r2.putString("challenge", r5);
        KeyManagerResult r7 = KeyManager.getInstance().keyAttestation(r3, r4, r2);
        if (r7.getResultCode() == 0) goto L9;
        b.b(f5362a, "Attest key failed! ret:" + r7.getResultCode());
        return new ArrayList();
    L9:
        List<Certificate> r8 = r7.getCertChain();
        b.a(f5362a, "Attest key succeed! cert chain size:" + r8.size());
        return r8;
    }

    private List<Certificate> b(Context r1, String r2, String r3, Bundle r4) {
        if (r4 != null) goto L5;
        b.b(f5362a, "Attest bundle is null");
        return new ArrayList();
    L5:
        r4.putString("challenge", r3);
        KeyManagerResult r0 = KeyManager.getInstance().keyAttestation(r1, r2, r4);
        if (r0.getResultCode() == 0) goto L9;
        b.b(f5362a, "Attest key with ids failed! ret:" + r0.getResultCode());
        return new ArrayList();
    L9:
        List<Certificate> r5 = r0.getCertChain();
        if (r5 != null) goto L12;
    L16:
        b.b(f5362a, "keyAttestation result certChain invalid for keyAlias=" + r2);
        return new ArrayList();
    L12:
        if (r5.isEmpty() == true) goto L16;
        b.a(f5362a, "Attest key with ids succeed! keyAlias=" + r2 + ", cert chain size: " + r5.size());
        return r5;
    }

    private int d(Context r1, String r2, Bundle r3) {
        int r0 = KeyManager.getInstance().generateKeyPair(r1, r2, r3);
        if (r0 == 0) goto L6;
        b.b(f5362a, "Generate key pair failed! ret:" + r0);
        return r0;
    L6:
        return 0;
    }

    public static a g() {
        if (f5363b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5363b != null) goto L9;
        f5363b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5363b;
    }

    public void c(Context r3, String r4) {
        int r2 = KeyManager.getInstance().deleteKey(r3, r4, new Bundle());
        if (r2 != 0) goto L5;
        b.d(f5362a, "Deleted attest key successfully: " + r4);
        return;
    L5:
        b.b(f5362a, "Failed to delete attest key: " + r4 + ", ret: " + r2);
    }

    public List<Certificate> e(Context r5, String r6, String r7, boolean r8, Bundle r9) {
        String r0 = com.bytedance.privacy.e.a.f();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        b.b(f5362a, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r1 = f5362a;
        b.a(r1, "Request challenge succeed! challenge:" + r0);
        int r10 = d(r5, r6, r9);
        if (r10 == 0) goto L11;
        b.b(r1, "Generate attestation key pair failed! ret:" + r10);
        return new ArrayList();
    L11:
        return a(r5, r6, r0 + ":" + r7 + ":" + r6, r8);
    }

    public List<Certificate> f(Context r5, String r6, String r7, String r8, Bundle r9, Bundle r10) {
        String r0 = com.bytedance.privacy.e.a.f();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        b.b(f5362a, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r1 = f5362a;
        b.a(r1, "Request challenge succeed! challenge:" + r0);
        int r11 = d(r5, r8, r9);
        if (r11 == 0) goto L10;
        b.b(r1, "Generate attestation key pair failed! ret:" + r11);
        return new ArrayList();
    L10:
        List<Certificate> r12 = b(r5, r8, r0 + ":" + r7 + ":" + r6, r10);
        if (r12.isEmpty() == false) goto L14;
        b.b(r1, "attestKeyWithIds failed, delete keyAlias: " + r8);
        c(r5, r8);
        return new ArrayList();
    L14:
        return r12;
    }
}
