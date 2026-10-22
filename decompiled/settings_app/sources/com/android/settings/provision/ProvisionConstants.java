package com.android.settings.provision;

/* JADX INFO: loaded from: classes2.dex */
public class ProvisionConstants {
    public static final String EXTRA_SETUPWIZARD = "extra_obric_setupwizard";
    public static int REQ_ACTIVATE = 0;
    public static int REQ_BASE = 1008600;
    public static int REQ_ENTER_ACCOUNT;
    public static int REQ_ENTER_CLOUD;
    public static int REQ_ENTER_FACE;
    public static int REQ_ENTER_FINGERPRINT;
    public static int REQ_ENTER_PASSWORD;
    public static int REQ_FRP_ACTIVATE;
    public static int REQ_VERIFY_PASSWORD;
    public static int REQ_WIZARD_COMPLETE;

    public ProvisionConstants() {
    }

    static {
        REQ_WIZARD_COMPLETE = 1008600 + 1;
        REQ_ACTIVATE = 1008600 + 2;
        REQ_VERIFY_PASSWORD = 1008600 + 3;
        REQ_ENTER_FACE = 1008600 + 4;
        REQ_ENTER_FINGERPRINT = 1008600 + 5;
        REQ_ENTER_PASSWORD = 1008600 + 6;
        REQ_ENTER_ACCOUNT = 1008600 + 7;
        REQ_ENTER_CLOUD = 1008600 + 8;
        REQ_FRP_ACTIVATE = 1008600 + 9;
    }
}
