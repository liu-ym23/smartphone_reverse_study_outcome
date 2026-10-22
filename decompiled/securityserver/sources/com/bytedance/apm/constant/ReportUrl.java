package com.bytedance.apm.constant;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReportUrl {
    public static final String DEFAULT_EXCEPTION_UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/exception";
    public static final String DEFAULT_FILE_UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/logcollect";
    public static final List<String> EXCEPTION_UPLOAD_URL_LIST = null;
    public static final List<String> FETCH_SETTING_LIST = null;
    public static final String MAINLAND_EXCEPTION_DOMAIN_HTTPS = "https://mon.zijieapi.com";
    public static final String MAINLAND_NORMAL_DOMAIN_HTTPS = "https://mon.zijieapi.com";
    public static final String MAINLAND_REPORT_DOMAIN1_HTTPS = "https://mon.toutiao.com";
    public static final String MAINLAND_SETTING_DOMAIN1_HTTPS = "https://monsetting.toutiao.com";
    public static final List<String> REPORT_TRACING_URL_LIST = null;
    public static final List<String> REPORT_URL_LIST = null;

    static {
        ArrayList r0 = new ArrayList();
        FETCH_SETTING_LIST = r0;
        r0.add("https://mon.zijieapi.com/monitor/appmonitor/v4/settings");
        r0.add("https://monsetting.toutiao.com/monitor/appmonitor/v4/settings");
        ArrayList r1 = new ArrayList();
        REPORT_URL_LIST = r1;
        r1.add("https://mon.zijieapi.com/monitor/collect/batch/");
        r1.add("https://mon.toutiao.com/monitor/collect/batch/");
        ArrayList r2 = new ArrayList();
        REPORT_TRACING_URL_LIST = r2;
        r2.add("https://mon.zijieapi.com/monitor/collect/c/trace_collect");
        ArrayList r3 = new ArrayList();
        EXCEPTION_UPLOAD_URL_LIST = r3;
        r3.add(DEFAULT_EXCEPTION_UPLOAD_URL);
        r3.add(DEFAULT_EXCEPTION_UPLOAD_URL);
    }

    public ReportUrl() {
    }
}
