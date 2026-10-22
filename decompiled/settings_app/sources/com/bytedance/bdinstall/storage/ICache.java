package com.bytedance.bdinstall.storage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ICache {
    void cacheString(String r1, String r2);

    void clear(List<String> r1);

    String getCachedString(String r1);

    String[] loadAccId(String[] r1, String[] r2);

    String loadClientUdid(String r1, String r2);

    String loadDeviceId(String r1, String r2);

    String loadOpenUdid(String r1, String r2);

    String loadSerialNumber(String r1, String r2);

    String loadUdid(String r1, String r2);
}
