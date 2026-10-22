package com.bytedance.privacy.security;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.privacy.utils.LogUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityFrameworkCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Impl f28a;

    /* JADX INFO: renamed from: com.bytedance.privacy.security.SecurityFrameworkCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class AiassistantImpl implements Impl {
        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int a(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            SecretData r0 = new SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            AddResult r8 = SecretDataManager.getInstance().addData(r2, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L9;
            return r8.getResultCode();
        L9:
            return -1;
        L7:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final KeyManagerResultCompat b(Context r2, byte[] r3, Bundle r4) {
            KeyManagerResult r1 = KeyManager.getInstance().sign(r2, "pcc_sign_key", r3, r4);     // Catch: Throwable -> L7
            if (r1 != null) goto L10;
            return KeyManagerResultCompat.a();
        L10:
            return new KeyManagerResultCompat(r1.getResultCode(), r1.getCertChain(), r1.getOutData());
        L7:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "sign failed", th);
            return KeyManagerResultCompat.a();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final SecretQueryResult c(Context r4, String r5, Bundle r6) {
            QueryResult r7 = SecretDataManager.getInstance().queryData(r4, r5, r6);     // Catch: Throwable -> L14
            if (r7 == null) goto L6;
            List r8 = r7.getDataList();     // Catch: Throwable -> L14
            if (r8 != null) goto L10;
        L16:
            String r9 = null;
        L18:
            return new SecretQueryResult(r7.getResultCode(), r9, false);
        L10:
            if (r8.isEmpty() == true) goto L16;
            SecretData r10 = (SecretData) r8.get(0);     // Catch: Throwable -> L14
            if (r10 == null) goto L16;
            r9 = r10.privateData;     // Catch: Throwable -> L14
            goto L18
        L6:
            return new SecretQueryResult(-1, null, true);
        L14:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "SecretDataManager.queryData failed", th);
            return new SecretQueryResult(-1, null, true);
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final String d() {
            return "com.aiassistant.security";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int e(Context r1, String r2, Bundle r3) {
            return KeyManager.getInstance().generateKeyPair(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int f(Context r1, String r2, Bundle r3) {
            return SecretDataManager.getInstance().deleteData(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "SecretDataManager.deleteData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final KeyManagerResultCompat g(Context r1, String r2, Bundle r3) {
            KeyManagerResult r0 = KeyManager.getInstance().keyAttestation(r1, r2, r3);     // Catch: Throwable -> L6
            if (r0 != null) goto L9;
            return KeyManagerResultCompat.a();
        L9:
            return new KeyManagerResultCompat(r0.getResultCode(), r0.getCertChain(), r0.getOutData());
        L6:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "keyAttestation failed", th);
            return KeyManagerResultCompat.a();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int h(Context r1, String r2, Bundle r3) {
            return KeyManager.getInstance().deleteKey(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "deleteKey failed", th);
            return -1;
        }
    }

    public interface Impl {
        int a(Context r1, String r2, String r3, String r4, String r5, Bundle r6);

        KeyManagerResultCompat b(Context r1, byte[] r2, Bundle r3);

        SecretQueryResult c(Context r1, String r2, Bundle r3);

        String d();

        int e(Context r1, String r2, Bundle r3);

        int f(Context r1, String r2, Bundle r3);

        KeyManagerResultCompat g(Context r1, String r2, Bundle r3);

        int h(Context r1, String r2, Bundle r3);
    }

    public static final class KeyManagerResultCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29a;
        public final List b;
        public final byte[] c;

        public KeyManagerResultCompat(int r1, List r2, byte[] r3) {
            this.f29a = r1;
            if (r2 != null) goto L6;
            r2 = Collections.emptyList();
        L6:
            this.b = r2;
            this.c = r3;
        }

        public static KeyManagerResultCompat a() {
            return new KeyManagerResultCompat(-1, Collections.emptyList(), null);
        }
    }

    public static final class ObricImpl implements Impl {
        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int a(Context r2, String r3, String r4, String r5, String r6, Bundle r7) {
            com.obric.security.secretdata.SecretData r0 = new com.obric.security.secretdata.SecretData();     // Catch: Throwable -> L7
            r0.privateData = r3;     // Catch: Throwable -> L7
            r0.associate = r4;     // Catch: Throwable -> L7
            r0.alias = r5;     // Catch: Throwable -> L7
            r0.dataType = r6;     // Catch: Throwable -> L7
            com.obric.security.secretdata.AddResult r8 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r2, r0, r7);     // Catch: Throwable -> L7
            if (r8 == null) goto L9;
            return r8.getResultCode();
        L9:
            return -1;
        L7:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "SecretDataManager.addData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final KeyManagerResultCompat b(Context r2, byte[] r3, Bundle r4) {
            com.obric.security.keymanager.KeyManagerResult r1 = com.obric.security.keymanager.KeyManager.getInstance().sign(r2, "pcc_sign_key", r3, r4);     // Catch: Throwable -> L7
            if (r1 != null) goto L10;
            return KeyManagerResultCompat.a();
        L10:
            return new KeyManagerResultCompat(r1.getResultCode(), r1.getCertChain(), r1.getOutData());
        L7:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "sign failed", th);
            return KeyManagerResultCompat.a();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final SecretQueryResult c(Context r4, String r5, Bundle r6) {
            com.obric.security.secretdata.QueryResult r7 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r4, r5, r6);     // Catch: Throwable -> L14
            if (r7 == null) goto L6;
            List r8 = r7.getDataList();     // Catch: Throwable -> L14
            if (r8 != null) goto L10;
        L16:
            String r9 = null;
        L18:
            return new SecretQueryResult(r7.getResultCode(), r9, false);
        L10:
            if (r8.isEmpty() == true) goto L16;
            com.obric.security.secretdata.SecretData r10 = (com.obric.security.secretdata.SecretData) r8.get(0);     // Catch: Throwable -> L14
            if (r10 == null) goto L16;
            r9 = r10.privateData;     // Catch: Throwable -> L14
            goto L18
        L6:
            return new SecretQueryResult(-1, null, true);
        L14:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "SecretDataManager.queryData failed", th);
            return new SecretQueryResult(-1, null, true);
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final String d() {
            return "com.obric.security";
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int e(Context r1, String r2, Bundle r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "generateKeyPair failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int f(Context r1, String r2, Bundle r3) {
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "SecretDataManager.deleteData failed", th);
            return -1;
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final KeyManagerResultCompat g(Context r1, String r2, Bundle r3) {
            com.obric.security.keymanager.KeyManagerResult r0 = com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r1, r2, r3);     // Catch: Throwable -> L6
            if (r0 != null) goto L9;
            return KeyManagerResultCompat.a();
        L9:
            return new KeyManagerResultCompat(r0.getResultCode(), r0.getCertChain(), r0.getOutData());
        L6:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "keyAttestation failed", th);
            return KeyManagerResultCompat.a();
        }

        @Override // com.bytedance.privacy.security.SecurityFrameworkCompat.Impl
        public final int h(Context r1, String r2, Bundle r3) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r1, r2, r3);
        L4:
            th = move-exception;
            LogUtils.c("SecurityFrameworkCompat", "deleteKey failed", th);
            return -1;
        }
    }

    public static final class SecretQueryResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f30a;
        public final int b;
        public final String c;

        public SecretQueryResult(int r1, String r2, boolean r3) {
            this.f30a = r3;
            this.b = r1;
            this.c = r2;
        }
    }

    public static int a(Context r7, String r8, String r9, String r10, String r11, Bundle r12) {
        return i().a(r7, r8, r9, r10, r11, r12);
    }

    public static String b() {
        i();
        return "attest_rpdid";
    }

    public static String c() {
        i();
        return "attest_rpuid";
    }

    public static String d() {
        i();
        return "challenge";
    }

    public static int e(Context r1, String r2, Bundle r3) {
        return i().h(r1, r2, r3);
    }

    public static int f(Context r1, String r2, Bundle r3) {
        return i().f(r1, r2, r3);
    }

    public static String g() {
        i();
        return "device_health_status_required";
    }

    public static int h(Context r1, String r2, Bundle r3) {
        return i().e(r1, r2, r3);
    }

    public static Impl i() {
        Impl r1 = f28a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        monitor-enter(SecurityFrameworkCompat.class);
        Impl r2 = f28a;     // Catch: Throwable -> L11
        if (r2 == null) goto L14;
        monitor-exit(SecurityFrameworkCompat.class);     // Catch: Throwable -> L11
        return r2;
    L14:
        boolean r3 = true;
        Class.forName("com.obric.security.secretdata.SecretDataManager", false, null);     // Catch: Throwable -> L11 ClassNotFoundException -> L17
        boolean r4 = true;
    L36:
        Class.forName("com.aiassistant.security.secretdata.SecretDataManager", false, null);     // Catch: Throwable -> L11 ClassNotFoundException -> L22
    L24:
        if (r4 == false) goto L26;
        Impl r5 = new ObricImpl();     // Catch: Throwable -> L11
    L28:
        f28a = r5;     // Catch: Throwable -> L11
        LogUtils.d("SecurityFrameworkCompat", "Using security framework package: ".concat(r5.d()));     // Catch: Throwable -> L11
        monitor-exit(SecurityFrameworkCompat.class);     // Catch: Throwable -> L11
        return r5;
    L26:
        if (r3 == false) goto L31;
        r5 = new AiassistantImpl();     // Catch: Throwable -> L11
        goto L28
    L31:
        LogUtils.b("SecurityFrameworkCompat", "No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L11
        throw new IllegalStateException("No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L11
    L22:
        e = move-exception;
        LogUtils.b("SecurityFrameworkCompat", "Class not found:" + e);     // Catch: Throwable -> L11
        r3 = false;
        goto L24
    L17:
        e = move-exception;
        LogUtils.b("SecurityFrameworkCompat", "Class not found:" + e);     // Catch: Throwable -> L11
        r4 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static String j() {
        i();
        return "key_algorithm";
    }

    public static KeyManagerResultCompat k(Context r1, String r2, Bundle r3) {
        return i().g(r1, r2, r3);
    }

    public static String l() {
        i();
        return "key_length";
    }

    public static String m() {
        i();
        return "key_purpose";
    }

    public static int n() {
        i();
        return 64;
    }

    public static SecretQueryResult o(Context r1, String r2, Bundle r3) {
        return i().c(r1, r2, r3);
    }

    public static String p() {
        i();
        return "query_mode";
    }

    public static KeyManagerResultCompat q(Context r1, byte[] r2, Bundle r3) {
        return i().b(r1, r2, r3);
    }
}
