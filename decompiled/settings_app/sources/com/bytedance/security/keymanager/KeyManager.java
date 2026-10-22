package com.bytedance.security.keymanager;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class KeyManager {
    private KeyManager() {
    }

    public static KeyManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public int importKey(Context r1, Bundle r2) {
        throw new RuntimeException("Stub!!");
    }

    public int importKeyLegacy(Context r1, Bundle r2) {
        throw new RuntimeException("Stub!!");
    }

    public int deleteSyncKey(Context r1, String r2) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4) {
        throw new RuntimeException("Stub!!");
    }

    public int generateKeyPair(Context r1, String r2, Bundle r3) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAttestation(Context r1, String r2, Bundle r3) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult getCertificateChain(Context r1, String r2, Bundle r3) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult sign(Context r1, String r2, byte[] r3, Bundle r4) {
        throw new RuntimeException("Stub!!");
    }

    public int verify(Context r1, String r2, byte[] r3, byte[] r4, Bundle r5) {
        throw new RuntimeException("Stub!!");
    }

    public int deleteKey(Context r1, String r2, Bundle r3) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4) {
        throw new RuntimeException("Stub!!");
    }

    public UDIDManagerResult getUDID(Context r1, Bundle r2) {
        throw new RuntimeException("Stub!!");
    }
}
