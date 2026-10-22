package com.bytedance.apm.report;

import a.a;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.ss.android.http.legacy.protocol.HTTP;
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

    public FileUploadServiceImpl() {
    }

    public static /* synthetic */ void access$000(FileUploadServiceImpl r0, String r1, String r2, String r3, List r4, String r5, JSONObject r6, IFileUploadCallback r7) {
        r0.uploadFilesInternal(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void access$100(String r0, String r1, String r2, String r3, String r4, JSONObject r5, String r6, IFileUploadCallback r7) {
        uploadMappingFilesInternal(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static void setMappingFileUploadHost(String r2) {
        sMappingFileUploadUrl = a.k("https://", r2, ReportConsts.MAPPING_FILE_COLLECT_PATH);
    }

    public static void setUploadHost(String r2) {
        sUploadUrl = a.k("https://", r2, ReportConsts.FILE_COLLECT_PATH);
        sHost = r2;
    }

    private void uploadFilesInternal(@NonNull String r5, @NonNull String r6, @NonNull String r7, @NonNull List<String> r8, @NonNull String r9, @Nullable JSONObject r10, @Nullable IFileUploadCallback r11) {
        IHttpService r4 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L5
        if (r4 != null) goto L7;
        r4 = new DefaultHttpServiceImpl();     // Catch: Exception -> L5
    L7:
        IMultipartUploader r12 = r4.buildMultipartUpload(sUploadUrl, "UTF-8", false);     // Catch: Exception -> L5
        r12.addFormField("aid", r5);     // Catch: Exception -> L5
        r12.addFormField("device_id", r6);     // Catch: Exception -> L5
        r12.addFormField("os", "Android");     // Catch: Exception -> L5
        r12.addFormField("process_name", "main");     // Catch: Exception -> L5
        Iterator<String> r13 = r8.iterator();     // Catch: Exception -> L5
    L9:
        String r14 = null;
        if (r13.hasNext() == false) goto L14;
        File r3 = new File(r13.next());     // Catch: Exception -> L5
        if (r3.exists() == false) goto L9;
        HashMap r15 = new HashMap();     // Catch: Exception -> L5
        r15.put("logtype", r7);     // Catch: Exception -> L5
        r15.put("scene", r9);     // Catch: Exception -> L5
        r15.put("env", "params.txt");     // Catch: Exception -> L5
        r12.addFilePart(r3.getName(), r3, null, r15);     // Catch: Exception -> L5
        goto L9
    L14:
        HashMap r16 = new HashMap();     // Catch: Exception -> L5
        r16.put("filetype", "common_params");     // Catch: Exception -> L5
        r16.put("logtype", "env");     // Catch: Exception -> L5
        if (r10 == null) goto L19;
        r14 = r10.toString();     // Catch: Exception -> L5
    L19:
        if (TextUtils.isEmpty(r14) == false) goto L23;
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L5
        r17.put("defaultData", "none commonParams");     // Catch: Exception -> L5 JSONException -> L38
    L22:
        r14 = r17.toString();     // Catch: Exception -> L5
    L23:
        r12.addFilePart("params.txt", r14, HTTP.PLAIN_TEXT_TYPE, r16);     // Catch: Exception -> L5
        String r18 = new String(r12.finish().getResponseBytes());     // Catch: Exception -> L5
        int r19 = -1;
        r19 = new JSONObject(r18).optInt("errno", -1);     // Catch: Exception -> L5 JSONException -> L27
    L29:
        if (r11 != null) goto L31;
        return;
    L31:
        if (r19 != 200) goto L33;
        r11.onSuccess();     // Catch: Exception -> L5
        return;
    L33:
        r11.onFail(r18);     // Catch: Exception -> L5
        return;
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L5
    L5:
        e = move-exception;
        if (r11 == null) goto L51;
        r11.onFail(e.getMessage());
        return;
    }

    public static void uploadMappingFiles(@NonNull final String r10, @NonNull final String r11, @NonNull final String r12, @NonNull final String r13, @NonNull final String r14, @Nullable final JSONObject r15, @Nullable final IFileUploadCallback r16) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass2(r10, r11, r12, r13, r14, r15, r16));
    }

    private static void uploadMappingFilesInternal(@NonNull String r5, @NonNull String r6, @NonNull String r7, @NonNull String r8, @NonNull String r9, @Nullable JSONObject r10, @Nullable String r11, @Nullable IFileUploadCallback r12) {
        File r0 = null;
        String r1 = null;
        File r2 = null;
        File r3 = null;
        IHttpService r4 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        if (r4 != null) goto L12;
        r4 = new DefaultHttpServiceImpl();     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
    L12:
        IMultipartUploader r13 = r4.buildMultipartUpload(sMappingFileUploadUrl, "UTF-8", false);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        r13.addFormField("aid", r5);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        r13.addFormField("os", "Android");     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        r13.addFormField("update_version_code", r6);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        r13.addFormField("channel", r7);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        r13.addFormField("release_build", r8);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        if (TextUtils.isEmpty(r11) == true) goto L15;
        r13.addFormField("device_id", r11);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
    L15:
        r13.addFormField("monitor_version", "5.0.21.5");     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        File r14 = new File(r9);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        if (r14.exists() == false) goto L25;
        String r15 = r14.getParent() + LibrarianImpl.Constants.SEPARATOR + (FileUtils.getFileNameWithoutSuffix(r14) + ".zip");     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        FileUtils.compress(r15, new String[]{r9});     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
        File r16 = new File(r15);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L10
    L79:
        r13.addFilePart(r16.getName(), r16, null, new HashMap());     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
    L26:
        HashMap r17 = new HashMap();     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        r17.put("filetype", "common_params");     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        r17.put("logtype", "env");     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        if (r10 == null) goto L31;
        r1 = r10.toString();     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
    L31:
        if (TextUtils.isEmpty(r1) == false) goto L35;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        r18.put("defaultData", "none commonParams");     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23 JSONException -> L67
    L34:
        r1 = r18.toString();     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
    L35:
        r13.addFilePart("params.txt", r1, HTTP.PLAIN_TEXT_TYPE, r17);     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        String r19 = new String(r13.finish().getResponseBytes());     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        int r20 = -1;
        r20 = new JSONObject(r19).optInt("errno", -1);     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23 JSONException -> L39
    L41:
        if (r12 != null) goto L43;
    L46:
        if (r16 == null) goto L80;
        r16.delete();     // Catch: Throwable -> L49
    L71:
        return;
    L80:
        return;
    L43:
        if (r20 != 200) goto L45;
        r12.onSuccess();     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
        goto L46
    L45:
        r12.onFail(r19);     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19 Exception -> L21 IOException -> L23
    L23:
        e = e;
        r3 = r16;
    L55:
        if (r12 == null) goto L64;
        r12.onFail(e.getMessage());     // Catch: Throwable -> L6
    L64:
        if (r3 == null) goto L83;
        r3.delete();     // Catch: Throwable -> L49
        goto L71
    L83:
        return;
    L21:
        e = e;
        r0 = r16;
    L51:
        e.printStackTrace();     // Catch: Throwable -> L6
        if (r0 == null) goto L82;
        r0.delete();     // Catch: Throwable -> L49
        goto L71
    L82:
        return;
    L19:
        th = th;
        r2 = r16;
    L58:
        if (r2 != null) goto L69;
    L63:
        throw th;
    L69:
        r2.delete();     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        th.printStackTrace();
        goto L63
    L25:
        r16 = null;
    L6:
        th = th;
    L10:
        e = e;
    L8:
        e = e;
    L49:
        th = move-exception;
        th.printStackTrace();
    }

    @Deprecated
    public void setOverSea(boolean r1) {
    }

    @Deprecated
    public void setUploadUrl(String r1) {
        sUploadUrl = r1;
    }

    @Override // com.bytedance.services.apm.api.IFileUploadService
    public void uploadFiles(@NonNull final String r12, @NonNull final String r13, @NonNull final String r14, @NonNull final List<String> r15, @NonNull final String r16, @Nullable final JSONObject r17, @Nullable final IFileUploadCallback r18) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass1(this, r12, r13, r14, r15, r16, r17, r18));
    }

    public static void uploadMappingFiles(@NonNull final String r11, @NonNull final String r12, @NonNull final String r13, @NonNull final String r14, @NonNull final String r15, @Nullable final JSONObject r16, @Nullable final String r17, @Nullable final IFileUploadCallback r18) {
        AsyncEventManager.getInstance().submitTask(new AnonymousClass3(r11, r12, r13, r14, r15, r16, r17, r18));
    }
}
