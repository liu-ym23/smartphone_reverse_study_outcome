package com.bytedance.framwork.core.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.alog.DefaultAlogUploadStrategy;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.alog.IAlogUploadStrategy;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.entity.UploadRequest;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.ProcessUtils;
import com.bytedance.article.common.monitor.stack.ExceptionMonitor;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MonitorCommon {
    private static volatile IAlogUploadStrategy sAlogUploadStrategy;
    private static final MonitorCommon sInstance = null;

    public interface IGetCommonParams {
        Map<String, String> getCommonParams();

        String getSessionId();

        long getUid();
    }

    public MonitorCommon() {
    }

    static {
        sInstance = new MonitorCommon();
        sAlogUploadStrategy = new DefaultAlogUploadStrategy();
    }

    @Deprecated
    public static void setDefaultReportUrlList(List<String> r1) {
        if (ListUtils.isEmpty(r1) == true) goto L6;
        ApmDelegate.getInstance().setDefaultLogReportUrlsCompat(r1);
        return;
    }

    @Deprecated
    public static void setConfigUrl(List<String> r1) {
        if (ListUtils.isEmpty(r1) == true) goto L6;
        ApmDelegate.getInstance().setConfigUrlCompat(r1);
        return;
    }

    @Deprecated
    public static void setExceptionUploadUrl(String r3) {
        if (ApmDelegate.getInstance().isStarted() == true) goto L6;
        ExceptionMonitor.setUploadUrl(r3);
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        ApmDelegate.getInstance().setExceptionLogReportUrlsCompat(Arrays.asList(new String[]{r3}));
        return;
    }

    public static void setStopWhenInBackground(boolean r0) {
        ApmContext.setStopWhenBackground(r0);
    }

    @Deprecated
    public static MonitorCommon getInstance() {
        if (ApmDelegate.getInstance().isConfigReady() == true) goto L5;
        return null;
    L5:
        return sInstance;
    }

    @Deprecated
    public static boolean init(Context r1, JSONObject r2, final IGetCommonParams r3) {
        ApmDelegate.getInstance().start(ApmStartConfig.builder().params(r2).dynamicParams(new AnonymousClass1(r3)).build());
        return true;
    }

    @Deprecated
    public static boolean Init(Context r0, JSONObject r1, IGetCommonParams r2) {
        return init(r0, r1, r2);
    }

    @Deprecated
    public static void activeUploadAlog(String r8, long r9, long r11, String r13, IALogActiveUploadObserver r14) {
        ApmAgent.activeUploadAlog(r8, r9, r11, r13, r14, null);
    }

    @Deprecated
    public static void activeUploadAlog(final String r10, final long r11, final long r13, final String r15, final com.bytedance.article.common.monitor.alog.IALogActiveUploadObserver r16) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass2(r10, r11, r13, r15, r16));
    }

    @Deprecated
    public boolean addHeaderInfo(String r1, String r2) {
        return ApmContext.extendHeader(r1, r2);
    }

    public static void tryUploadAlog(String r8, long r9, long r11, String r13, com.bytedance.article.common.monitor.alog.IALogActiveUploadObserver r14) {
        if (ApmContext.getContext() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r8) == false) goto L9;
        return;
    L9:
        if (new File(r8).exists() == true) goto L11;
        return;
    L11:
        if (r14 == null) goto L13;
        r14.flushAlogDataToFile();
    L13:
        activeUploadAlogInternal(r8, r9, r11, r13, null);
    }

    private static void activeUploadAlogInternal(String r9, long r10, long r12, String r14, IALogActiveUploadCallback r15) {
        if (sAlogUploadStrategy == null) goto L5;
        List<String> r0 = sAlogUploadStrategy.getUploadAlogFiles(ApmContext.getContext(), r9, r10, r12);
    L7:
        if (ListUtils.isEmpty(r0) == true) goto L20;
        UploadRequest r11 = buildUploadRequest(r0);
        if (checkParamsForUploadRequest(r11) == true) goto L14;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 5, null);
        if (r15 == null) goto L41;
        r15.onCallback(false, null);
        return;
    L41:
        return;
    L14:
        String r13 = zipUploadFile(r11.getAlogFiles());
        if (TextUtils.isEmpty(r13) == false) goto L17;
        boolean r16 = AlogUploadService.uploadAlogFiles(r11.getAid(), r11.getDid(), r11.getProcessName(), r11.getAlogFiles(), r14, r11.getCommonParams());
    L18:
        if (r15 == null) goto L42;
        r15.onCallback(r16, null);
        return;
    L42:
        return;
    L17:
        ArrayList r5 = new ArrayList();
        r5.add(r13);
        r16 = AlogUploadService.uploadAlogFiles(r11.getAid(), r11.getDid(), r11.getProcessName(), r5, r14, r11.getCommonParams());
        new File(r13).delete();
        goto L18
    L20:
        JSONObject r17 = new JSONObject();
        r17.put("e_dir", r9);     // Catch: Exception -> L36
        r17.put("e_start_time", r10);     // Catch: Exception -> L36
        r17.put("e_end_time", r12);     // Catch: Exception -> L36
        File r18 = new File(r9);     // Catch: Exception -> L36
        if (r18.exists() == true) goto L25;
    L30:
        r17.put("e_file", "null");     // Catch: Exception -> L36
        goto L31
    L25:
        if (r18.listFiles() == null) goto L30;
        StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L36
        r19.append("[");     // Catch: Exception -> L36
        File[] r110 = r18.listFiles();     // Catch: Exception -> L36
        int r111 = r110.length;     // Catch: Exception -> L36
        int r112 = 0;
    L27:
        if (r112 >= r111) goto L29;
        r19.append(r110[r112].getName());     // Catch: Exception -> L36
        r19.append(",");     // Catch: Exception -> L36
        r112 = r112 + 1;     // Catch: Exception -> L36
        goto L27
    L29:
        r19.append("]");     // Catch: Exception -> L36
        r17.put("e_file", r19.toString());     // Catch: Exception -> L36
    L31:
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 4, r17);
        if (r15 == null) goto L44;
        r15.onCallback(false, null);     // Catch: Exception -> L35
        return;
    L45:
        return;
    L44:
        return;
    L5:
        r0 = null;
        goto L7
    }

    private static String zipUploadFile(List<String> r4) {
        File r0 = new File(r4.get(0));
        File r2 = new File(r0.getParent(), getZipFileName(r0.getName()));
        if (r2.exists() == false) goto L10;
        r2.delete();
    L10:
        FileUtils.compress(r2.getAbsolutePath(), (String[]) r4.toArray(new String[0]));     // Catch: Exception -> L8
        return r2.getAbsolutePath();
    L8:
        return null;
    }

    private static String getZipFileName(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L11;
        return r4 + ".zip";
    L11:
        return r4.substring(0, r0) + ".zip";
    }

    private static UploadRequest buildUploadRequest(List<String> r4) {
        UploadRequest r0 = new UploadRequest();
        JSONObject r1 = ApmContext.getHeader();
        if (r1 == null) goto L6;
        r0.setAid(r1.optString("aid"));
        r0.setDid(r1.optString("device_id"));
    L6:
        if (ProcessUtils.getCurProcessName(ApmContext.getContext()).contains(":") == false) goto L8;
        String r2 = ProcessUtils.getCurProcessName(ApmContext.getContext());
    L9:
        r0.setProcessName(r2);
        r0.setAlogFiles(r4);
        r0.setCommonParams(r1);
        return r0;
    L8:
        r2 = "main";
        goto L9
    }

    private static boolean checkParamsForUploadRequest(UploadRequest r1) {
        if (TextUtils.isEmpty(r1.getAid()) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r1.getDid()) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r1.getProcessName()) == false) goto L9;
        return false;
    L9:
        if (r1.getAlogFiles() != null) goto L11;
        return false;
    L11:
        if (r1.getAlogFiles().size() == 0) goto L20;
        return true;
    L20:
        return false;
    }
}
