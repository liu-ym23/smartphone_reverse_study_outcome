package com.bytedance.bdinstall.storage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Cache implements ICache {
    private Cache mSuccessor;

    interface ICacheAgent<L> {
        boolean checkValid(L r1);

        L getCache();

        boolean isValueEqual(L r1, L r2);

        L load(L r1, L r2, Cache r3);

        void restoreCache(L r1);
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract void cacheString(String r1, String r2);

    protected abstract void cacheStringArray(String r1, String[] r2);

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract String getCachedString(String r1);

    protected abstract String[] getCachedStringArray(String r1);

    public Cache() {
    }

    private Cache getSuccessor() {
        return this.mSuccessor;
    }

    void setSuccessor(Cache r1) {
        this.mSuccessor = r1;
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadOpenUdid(String r2, String r3) {
        return (String) load(r2, r3, new AnonymousClass1(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadClientUdid(String r2, String r3) {
        return (String) load(r2, r3, new AnonymousClass2(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadSerialNumber(String r2, String r3) {
        return (String) load(r2, r3, new AnonymousClass3(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String[] loadAccId(String[] r2, String[] r3) {
        return (String[]) load(r2, r3, new AnonymousClass4(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadUdid(String r2, String r3) {
        return (String) load(r2, r3, new AnonymousClass5(this));
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadDeviceId(String r2, String r3) {
        return (String) load(r2, r3, new AnonymousClass6(this));
    }

    private <T> T load(T r4, T r5, ICacheAgent<T> r6) {
        if (r6 == null) goto L25;
        Cache r3 = getSuccessor();
        T r0 = r6.getCache();
        boolean r1 = r6.checkValid(r4);
        boolean r2 = r6.checkValid(r0);
        if (r1 == true) goto L7;
        if (r2 == false) goto L7;
        r4 = r0;
    L7:
        if (r3 == null) goto L12;
        T r7 = r6.load(r4, r5, r3);
        if (r6.isValueEqual(r7, r0) == true) goto L11;
        r6.restoreCache(r7);
    L11:
        return r7;
    L12:
        if (r1 == true) goto L15;
        if (r2 == true) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == true) goto L18;
    L19:
        if (r1 == true) goto L21;
    L23:
        return r5;
    L21:
        if (r6.isValueEqual(r5, r0) == true) goto L23;
    L22:
        r6.restoreCache(r5);
        goto L23
    L18:
        if (r6.checkValid(r5) == true) goto L22;
    L15:
        r8 = false;
        r5 = r4;
        goto L16
    L25:
        throw new IllegalArgumentException("agent == null");
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r1) {
        Cache r0 = getSuccessor();
        if (r0 == null) goto L6;
        r0.clear(r1);
        return;
    }
}
