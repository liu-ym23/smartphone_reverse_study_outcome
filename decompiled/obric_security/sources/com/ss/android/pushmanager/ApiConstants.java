package com.ss.android.pushmanager;

/* JADX INFO: loaded from: classes4.dex */
public class ApiConstants {
    public static final String API_HOST_API = "isub.snssdk.com";
    public static final String API_HOST_API_SNSSDK = "isub.snssdk.com";
    public static final String API_HOST_I = "ib.snssdk.com";
    public static final String API_HOST_I_SNSSDK = "ib.snssdk.com";
    public static final String API_HOST_LOG = "log.snssdk.com";
    public static final String API_HOST_MON = "mon.snssdk.com";
    public static final String API_HOST_SI = "security.snssdk.com";
    public static final String API_HOST_SI_SNSSDK = "security.snssdk.com";
    public static final String API_HOST_SRV = "ichannel.snssdk.com";
    public static final String API_HOST_SRV_SNSSDK = "ichannel.snssdk.com";
    public static String API_URL_PREFIX_API = "http://isub.snssdk.com";
    public static String API_URL_PREFIX_I = "http://ib.snssdk.com";
    public static String API_URL_PREFIX_SI = "https://security.snssdk.com";
    public static String API_URL_PREFIX_SRV = "http://ichannel.snssdk.com";

    static {
    }

    public ApiConstants() {
    }

    public static String i(String r2) {
        return API_URL_PREFIX_I + r2;
    }

    protected static String si(String r2) {
        return API_URL_PREFIX_SI + r2;
    }

    protected static String api(String r2) {
        return API_URL_PREFIX_API + r2;
    }

    public static String srv(String r2) {
        return API_URL_PREFIX_SRV + r2;
    }
}
