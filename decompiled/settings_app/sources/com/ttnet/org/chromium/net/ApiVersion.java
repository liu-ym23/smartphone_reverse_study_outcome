package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes5.dex */
public class ApiVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "06c5b28fe31a32fa61dc4ce997305cf39f62c836";
    private static final int MIN_COMPATIBLE_API_LEVEL = 3;

    public static int getApiLevel() {
        return 3;
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

    public static int getMaximumAvailableApiLevel() {
        return 16;
    }

    private ApiVersion() {
    }
}
