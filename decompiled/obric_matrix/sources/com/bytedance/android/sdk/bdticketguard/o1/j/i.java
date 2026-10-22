package com.bytedance.android.sdk.bdticketguard.o1.j;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.bytedance.android.sdk.bdticketguard.p1.k;
import com.bytedance.android.sdk.bdticketguard.s0;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f1010b = null;

    static {
        f1010b = new i();
    }

    private i() {
    }

    private final String k(String r7) {
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L11
        Object r8 = r0.getDeclaredMethod("get", new Class[]{String.class}).invoke(r0, new Object[]{r7});     // Catch: Throwable -> L11
        if (r8 == null) goto L10;
        String r9 = (String) r8;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r9) == false) goto L16;
        return null;
    L16:
        return r9;
    L10:
        throw new b0("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        s0.f1065a.c("HuaweiAttestationAdapter", "get prop failed", th);
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public KeyStore b() {
        KeyStore r1 = KeyStore.getInstance("HwKeystore");
        r1.load(null);
        o.b(r1, "KeyStore.getInstance(HW_…  it.load(null)\n        }");
        return r1;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public KeyPairGenerator e(KeyGenParameterSpec r2) {
        o.g(r2, "keyGenSpec");
        KeyPairGenerator r1 = KeyPairGenerator.getInstance("EC", "HwUniversalKeyStoreProvider");
        r1.initialize(r2);
        o.b(r1, "KeyPairGenerator.getInst…ize(keyGenSpec)\n        }");
        return r1;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public String f() {
        return "Huawei";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public boolean g() {
        Object r0 = Class.forName("com.huawei.security.keystore.HwUniversalKeyStoreProvider").newInstance();     // Catch: Throwable -> L8
        if (r0 == null) goto L7;
        Security.addProvider((Provider) r0);     // Catch: Throwable -> L8
        s0.f1065a.e("HuaweiAttestationAdapter", "install hw provider success");     // Catch: Throwable -> L8
        return true;
    L7:
        throw new b0("null cannot be cast to non-null type java.security.Provider");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        s0.f1065a.c("HuaweiAttestationAdapter", "install hw provider failed", th);
        return false;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public boolean h() {
        return k.f1023J.v().b().booleanValue();
    }

    public final String j() {
        String r0 = f1009a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (m() == true) goto L8;
        return null;
    L8:
        String r2 = k("hw_sc.build.platform.version");
        if (r2 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return null;
    L17:
        f1009a = r2;
        return r2;
    L11:
        if (r2.length() == 0) goto L14;
        r1 = false;
        goto L15
    }

    public final boolean l() {
        boolean r2 = false;
        if (k.f1023J.O().b().booleanValue() == false) goto L16;
        String r4 = j();
        if (r4 != null) goto L12;
    L13:
        r2 = true;
    L15:
        return !r2;
    L12:
        if (r4.length() != 0) goto L15;
    L16:
        boolean r5 = Class.forName("com.huawei.security.keystore.HwUniversalKeyStoreProvider").newInstance() instanceof Provider;     // Catch: Throwable -> L6
        s0.f1065a.e("HuaweiAttestationAdapter", "create hw provider success");     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        s0.f1065a.c("HuaweiAttestationAdapter", "create hw provider failed", th);
        return false;
    }

    public final boolean m() {
        Class<?> r0 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L5
        return o.a("harmony", r0.getMethod("getOsBrand", new Class[0]).invoke(r0, new Object[0]));
    L8:
        return false;
    }
}
