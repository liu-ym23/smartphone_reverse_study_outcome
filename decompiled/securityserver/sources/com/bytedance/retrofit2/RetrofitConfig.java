package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitConfig {
    private static boolean loadServiceMethodOpt = false;

    public RetrofitConfig() {
    }

    public static void enableLoadServiceMethodOpt() {
        loadServiceMethodOpt = true;
    }

    public static boolean isLoadServiceMethodOptOpen() {
        return loadServiceMethodOpt;
    }
}
