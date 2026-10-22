package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes3.dex */
public class ImplVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "012c1a211ba31a9e43e920539640249b4a8bd14d";

    public static int getApiLevel() {
        return 16;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getCronetVersionWithLastChange() {
        return "107.0.5273.2@012c1a21";
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }

    private ImplVersion() {
    }
}
