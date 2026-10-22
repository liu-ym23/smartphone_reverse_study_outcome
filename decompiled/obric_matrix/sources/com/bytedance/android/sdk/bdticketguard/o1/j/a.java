package com.bytedance.android.sdk.bdticketguard.o1.j;

import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f969a = null;

    static {
        f969a = new a();
    }

    private a() {
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public KeyStore b() {
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
        r1.load(null);
        o.b(r1, "KeyStore.getInstance(KEY…  it.load(null)\n        }");
        return r1;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public KeyPairGenerator e(KeyGenParameterSpec r2) {
        o.g(r2, "keyGenSpec");
        KeyPairGenerator r1 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        r1.initialize(r2);
        o.b(r1, "KeyPairGenerator.getInst…ize(keyGenSpec)\n        }");
        return r1;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.j.g
    public String f() {
        return LocationInfoConst.SYSTEM;
    }
}
