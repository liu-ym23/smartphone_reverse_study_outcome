package com.bytedance.services.apm.api;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public interface IZstdDict {
    Pair<byte[], String> getDictAndDictVersion();

    void setDomain(String r1);
}
