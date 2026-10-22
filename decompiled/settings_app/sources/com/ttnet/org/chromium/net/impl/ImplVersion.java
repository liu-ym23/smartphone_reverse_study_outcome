package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes5.dex */
public class ImplVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "06c5b28fe31a32fa61dc4ce997305cf39f62c836";

    public static int getApiLevel() {
        return 16;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "107.0.5273.2@06c5b28f";
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }

    private ImplVersion() {
    }
}
