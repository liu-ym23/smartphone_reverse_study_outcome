package com.bytedance.framwork.core.sdklib.net;

/* JADX INFO: loaded from: classes3.dex */
public interface ISendLog {
    public static final int COMPRESS_TYPE_GZIP = 1;

    NetResponse sendLog(String r1, byte[] r2);
}
