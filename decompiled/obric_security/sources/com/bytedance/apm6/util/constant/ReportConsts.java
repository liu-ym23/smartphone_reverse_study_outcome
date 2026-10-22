package com.bytedance.apm6.util.constant;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReportConsts {
    public static final String COLLECT_PATH = "/monitor/collect/batch/";
    public static final List<String> DEFAULT_LOG_REPORT = null;
    public static final String EXCEPTION_PATH = "/monitor/collect/c/exception";
    public static final String HTTPS = "https://";
    public static final String TRACING_PATH = "/monitor/collect/c/trace_collect";
    public static final String ZSTD_DICT_PATH = "/monitor/collect/zstd_dict/";

    public ReportConsts() {
    }

    static {
        DEFAULT_LOG_REPORT = new ArrayList();
    }
}
