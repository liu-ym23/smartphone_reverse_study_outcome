package com.bytedance.apm.report;

import android.text.TextUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IFileUploadCallback;
import com.bytedance.services.apm.api.IFileUploadService;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FileUploadServiceImpl implements IFileUploadService {
    public static String sHost;
    public static String sMappingFileUploadUrl;
    public static String sUploadUrl;

    @Deprecated
    public void setOverSea(boolean r1) {
    }

    public FileUploadServiceImpl() {
    }

    static /* synthetic */ void access$000(FileUploadServiceImpl r0, String r1, String r2, String r3, List r4, String r5, JSONObject r6, IFileUploadCallback r7) {
        r0.uploadFilesInternal(r1, r2, r3, r4, r5, r6, r7);
    }

    static /* synthetic */ void access$100(String r0, String r1, String r2, String r3, String r4, JSONObject r5, String r6, IFileUploadCallback r7) {
        uploadMappingFilesInternal(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    @Deprecated
    public void setUploadUrl(String r1) {
        sUploadUrl = r1;
    }

    public static void setUploadHost(String r2) {
        sUploadUrl = "https://" + r2 + ReportConsts.FILE_COLLECT_PATH;
        sHost = r2;
    }

    public static void setMappingFileUploadHost(String r2) {
        sMappingFileUploadUrl = "https://" + r2 + ReportConsts.MAPPING_FILE_COLLECT_PATH;
    }

    @Override // com.bytedance.services.apm.api.IFileUploadService
    public void uploadFiles(final String r12, final String r13, final String r14, final List<String> r15, final String r16, final JSONObject r17, final IFileUploadCallback r18) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass1(this, r12, r13, r14, r15, r16, r17, r18));
    }

    public static void uploadMappingFiles(final String r10, final String r11, final String r12, final String r13, final String r14, final JSONObject r15, final IFileUploadCallback r16) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass2(r10, r11, r12, r13, r14, r15, r16));
    }

    public static void uploadMappingFiles(final String r11, final String r12, final String r13, final String r14, final String r15, final JSONObject r16, final String r17, final IFileUploadCallback r18) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass3(r11, r12, r13, r14, r15, r16, r17, r18));
    }

    private void uploadFilesInternal(String r5, String r6, String r7, List<String> r8, String r9, JSONObject r10, IFileUploadCallback r11) {
        IHttpService r4 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L33
        if (r4 != null) goto L5;
        r4 = new DefaultHttpServiceImpl();     // Catch: Exception -> L33
    L5:
        IMultipartUploader r12 = r4.buildMultipartUpload(sUploadUrl, "UTF-8", false);     // Catch: Exception -> L33
        r12.addFormField("aid", r5);     // Catch: Exception -> L33
        r12.addFormField("device_id", r6);     // Catch: Exception -> L33
        r12.addFormField("os", "Android");     // Catch: Exception -> L33
        r12.addFormField("process_name", "main");     // Catch: Exception -> L33
        Iterator<String> r13 = r8.iterator();     // Catch: Exception -> L33
    L7:
        String r0 = null;
        if (r13.hasNext() == false) goto L12;
        File r3 = new File(r13.next());     // Catch: Exception -> L33
        if (r3.exists() == false) goto L7;
        HashMap r14 = new HashMap();     // Catch: Exception -> L33
        r14.put("logtype", r7);     // Catch: Exception -> L33
        r14.put("scene", r9);     // Catch: Exception -> L33
        r14.put("env", "params.txt");     // Catch: Exception -> L33
        r12.addFilePart(r3.getName(), r3, null, r14);     // Catch: Exception -> L33
        goto L7
    L12:
        HashMap r15 = new HashMap();     // Catch: Exception -> L33
        r15.put("filetype", "common_params");     // Catch: Exception -> L33
        r15.put("logtype", "env");     // Catch: Exception -> L33
        if (r10 == null) goto L17;
        r0 = r10.toString();     // Catch: Exception -> L33
    L17:
        if (TextUtils.isEmpty(r0) == false) goto L21;
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L33
        r16.put("defaultData", "none commonParams");     // Catch: JSONException -> L37 Exception -> L33
    L20:
        r0 = r16.toString();     // Catch: Exception -> L33
    L21:
        r12.addFilePart("params.txt", r0, "text/plain", r15);     // Catch: Exception -> L33
        String r17 = new String(r12.finish().getResponseBytes());     // Catch: Exception -> L33
        int r18 = -1;
        r18 = new JSONObject(r17).optInt("errno", -1);     // Catch: JSONException -> L25 Exception -> L33
    L27:
        if (r11 != null) goto L29;
        return;
    L29:
        if (r18 != 200) goto L31;
        r11.onSuccess();     // Catch: Exception -> L33
        return;
    L31:
        r11.onFail(r17);     // Catch: Exception -> L33
        return;
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        if (r11 == null) goto L50;
        r11.onFail(e.getMessage());
        return;
    }

    private static void uploadMappingFilesInternal(String r5, String r6, String r7, String r8, String r9, JSONObject r10, String r11, IFileUploadCallback r12) {
        File r0 = null;
        String r1 = null;
        File r2 = null;
        File r3 = null;
        IHttpService r4 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        if (r4 != null) goto L6;
        r4 = new DefaultHttpServiceImpl();     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
    L6:
        IMultipartUploader r13 = r4.buildMultipartUpload(sMappingFileUploadUrl, "UTF-8", false);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        r13.addFormField("aid", r5);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        r13.addFormField("os", "Android");     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        r13.addFormField("update_version_code", r6);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        r13.addFormField("channel", r7);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        r13.addFormField("release_build", r8);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r13.addFormField("device_id", r11);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
    L9:
        r13.addFormField("monitor_version", "5.0.21.5");     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        File r14 = new File(r9);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        if (r14.exists() == false) goto L13;
        String r15 = r14.getParent() + LibrarianImpl.Constants.SEPARATOR + (FileUtils.getFileNameWithoutSuffix(r14) + ".zip");     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        FileUtils.compress(r15, new String[]{r9});     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
        File r16 = new File(r15);     // Catch: Throwable -> L43 Exception -> L45 IOException -> L50
    L78:
        r13.addFilePart(r16.getName(), r16, null, new HashMap());     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
    L14:
        HashMap r17 = new HashMap();     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        r17.put("filetype", "common_params");     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        r17.put("logtype", "env");     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        if (r10 == null) goto L19;
        r1 = r10.toString();     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
    L19:
        if (TextUtils.isEmpty(r1) == false) goto L23;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        r18.put("defaultData", "none commonParams");     // Catch: JSONException -> L66 Throwable -> L37 Exception -> L39 IOException -> L41
    L22:
        r1 = r18.toString();     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
    L23:
        r13.addFilePart("params.txt", r1, "text/plain", r17);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        String r19 = new String(r13.finish().getResponseBytes());     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        int r20 = -1;
        r20 = new JSONObject(r19).optInt("errno", -1);     // Catch: JSONException -> L27 Throwable -> L37 Exception -> L39 IOException -> L41
    L29:
        if (r12 != null) goto L31;
    L34:
        if (r16 == null) goto L80;
        r16.delete();     // Catch: Throwable -> L63
    L70:
        return;
    L80:
        return;
    L31:
        if (r20 != 200) goto L33;
        r12.onSuccess();     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
        goto L34
    L33:
        r12.onFail(r19);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41
    L41:
        e = e;
        r3 = r16;
    L51:
        if (r12 == null) goto L60;
        r12.onFail(e.getMessage());     // Catch: Throwable -> L43
    L60:
        if (r3 == null) goto L82;
        r3.delete();     // Catch: Throwable -> L63
        goto L70
    L82:
        return;
    L39:
        e = e;
        r0 = r16;
    L46:
        e.printStackTrace();     // Catch: Throwable -> L43
        if (r0 == null) goto L81;
        r0.delete();     // Catch: Throwable -> L63
        goto L70
    L81:
        return;
    L37:
        th = th;
        r2 = r16;
    L54:
        if (r2 != null) goto L75;
    L59:
        throw th;
    L75:
        r2.delete();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();
        goto L59
    L13:
        r16 = null;
    L43:
        th = th;
    L50:
        e = e;
    L45:
        e = e;
    L63:
        th = move-exception;
        th.printStackTrace();
    }
}
