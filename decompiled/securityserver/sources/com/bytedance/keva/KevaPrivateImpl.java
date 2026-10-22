package com.bytedance.keva;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaPrivateImpl extends KevaImpl {
    public KevaPrivateImpl(String r1, int r2) {
        super(r1, r2);
    }

    private Object fetchObject(String r5, Object r6) {
        KevaImpl.KevaValueWrapper r4 = this.mValueMap.get(r5);
        if (r4 != null) goto L5;
        return r6;
    L5:
        if (r4.offset != 0) goto L8;
        return r6;
    L8:
        return r4.value;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Map buildNewMap(Map r1) {
        return super.buildNewMap(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r5) {
        monitor-enter(this);
        KevaImpl.KevaValueWrapper r6 = this.mValueMap.get(r5);     // Catch: Throwable -> L8
        if (r6 != null) goto L6;
    L10:
        boolean r7 = false;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r7;
    L6:
        if (r6.offset == 0) goto L10;
        r7 = true;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L9
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L11;
        if (r0.next().getValue().offset == 0) goto L5;
        r1 = r1 + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void dump() {
        super.dump();
    }

    @Override // com.bytedance.keva.KevaImpl
    public /* bridge */ /* synthetic */ void dumpNative() {
        super.dumpNative();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void erase(String r1) {
        super.erase(r1);
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r1, boolean r2) {
        return ((Boolean) fetchObject(r1, Boolean.valueOf(r2))).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r11, byte[] r12, int r13, boolean r14) {
        KevaImpl.KevaValueWrapper r0 = this.mValueMap.get(r11);
        if (r0 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r0.offset == 0) goto L17;
        if (r0.loaded == true) goto L16;
        byte[] r10 = fetchBytes(this.mHandle, r11, r0.offset, r12, r13);
        if (r14 == true) goto L13;
        if (r10 == r12) goto L14;
        r0.value = r10;
        r0.loaded = true;
    L14:
        return r10;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (byte[]) r0.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r1, double r2) {
        return ((Double) fetchObject(r1, Double.valueOf(r2))).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r1, float r2) {
        return ((Float) fetchObject(r1, Float.valueOf(r2))).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r1, int r2) {
        return ((Integer) fetchObject(r1, Integer.valueOf(r2))).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r1, long r2) {
        return ((Long) fetchObject(r1, Long.valueOf(r2))).longValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r10, String r11, boolean r12) {
        KevaImpl.KevaValueWrapper r0 = this.mValueMap.get(r10);
        if (r0 != null) goto L5;
    L17:
        return r11;
    L5:
        if (r0.offset == 0) goto L17;
        if (r0.loaded == true) goto L16;
        String r9 = fetchString(this.mHandle, r10, r0.offset, r11);
        if (r12 == true) goto L13;
        if (r9 == r11) goto L14;
        r0.value = r9;
        r0.loaded = true;
    L14:
        return r9;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (String) r0.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r11, String[] r12, boolean r13) {
        KevaImpl.KevaValueWrapper r0 = this.mValueMap.get(r11);
        if (r0 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r0.offset == 0) goto L17;
        if (r0.loaded == true) goto L16;
        String[] r10 = fetchStringArray(this.mHandle, r11, r0.offset, r12, 3);
        if (r13 == true) goto L13;
        if (r10 == r12) goto L14;
        r0.value = r10;
        r0.loaded = true;
    L14:
        return r10;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (String[]) r0.value;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        Map<String, ?> r0 = buildNewMap(new HashMap());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r1, boolean r2) {
        return super.getBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r1, byte[] r2) {
        return super.getBytes(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r1, byte[] r2) {
        return super.getBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r1, double r2) {
        return super.getDouble(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r1, float r2) {
        return super.getFloat(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r1, int r2) {
        return super.getInt(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r1, long r2) {
        return super.getLong(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r1, String r2) {
        return super.getString(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r1, String[] r2) {
        return super.getStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r1, String[] r2) {
        return super.getStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r1, String r2) {
        return super.getStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r1, Set r2) {
        return super.getStringSet(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r1, Set r2) {
        return super.getStringSetJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r1) {
        super.registerChangeListener(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r1, boolean r2) {
        super.storeBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r1, byte[] r2) {
        super.storeBytes(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r1, byte[] r2) {
        super.storeBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r1, double r2) {
        super.storeDouble(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r1, float r2) {
        super.storeFloat(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r1, int r2) {
        super.storeInt(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r1, long r2) {
        super.storeLong(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r1, String r2) {
        super.storeString(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r1, String[] r2) {
        super.storeStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r1, String[] r2) {
        super.storeStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r1, String r2) {
        super.storeStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r1, Set r2) {
        super.storeStringSet(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r1, Set r2) {
        super.storeStringSetJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r1) {
        super.unRegisterChangeListener(r1);
    }
}
