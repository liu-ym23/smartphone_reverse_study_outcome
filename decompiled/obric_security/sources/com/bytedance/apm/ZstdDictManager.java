package com.bytedance.apm;

import android.content.SharedPreferences;
import android.util.Base64;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IZstdDict;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ZstdDictManager implements IZstdDict {
    private static final String DICT_INTERVAL = "dict_interval";
    private static final String DICT_VERSION = "dict_version";
    public static final String DICT_VERSION_HEADER_KEY = "slardar-zstd-version";
    private byte[] dict;
    private String dictVersion;
    private long interval;
    private volatile boolean isInited;
    private String url;

    public ZstdDictManager() {
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public byte[] get() {
        ensureInit();
        byte[] r0 = this.dict;
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
    L10:
        downloadDict();
    L12:
        return this.dict;
    L9:
        if ((System.currentTimeMillis() - this.interval) <= 604800000) goto L12;
    L5:
        if (r0.length <= 0) goto L7;
        return r0;
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public void setDomain(String r3) {
        this.url = "https://" + r3 + ReportConsts.ZSTD_DICT_PATH;
    }

    private void ensureInit() {
        if (this.isInited == false) goto L5;
        return;
    L5:
        this.isInited = true;
        this.dict = FileUtils.readFileToByteArray(new File(com.bytedance.apm6.foundation.context.ApmContext.getContext().getFilesDir(), "monitor_dict"));
        SharedPreferences r0 = com.bytedance.apm6.foundation.context.ApmContext.getContext().getSharedPreferences(DICT_INTERVAL, 0);
        this.interval = r0.getLong(DICT_INTERVAL, 0);
        this.dictVersion = r0.getString(DICT_VERSION, null);
    }

    public String getDictVersion() {
        ensureInit();
        return this.dictVersion;
    }

    private void downloadDict() {
        HashMap r1 = new HashMap(com.bytedance.apm6.foundation.context.ApmContext.getUrlParams());
        r1.put("slardar_zstd_dict_type", "monitor");
        r1.put("version", "1");
        r1.put(DICT_VERSION_HEADER_KEY, this.dictVersion);
        HashMap r2 = new HashMap();
        r2.put(DICT_VERSION_HEADER_KEY, this.dictVersion);
        HttpResponse r3 = com.bytedance.apm6.foundation.context.ApmContext.doGet(UrlUtils.addParamsToURL(this.url, r1), r2);     // Catch: Exception -> L9
        if (r3 != null) goto L6;
    L11:
        this.interval = System.currentTimeMillis();
        com.bytedance.apm6.foundation.context.ApmContext.getContext().getSharedPreferences(DICT_INTERVAL, 0).edit().putLong(DICT_INTERVAL, this.interval).putString(DICT_VERSION, this.dictVersion).commit();
        return;
    L6:
        if (r3.getResponseBytes() == null) goto L11;
        JSONObject r4 = new JSONObject(new String(r3.getResponseBytes()));     // Catch: Exception -> L9
        this.dictVersion = r4.getString(DICT_VERSION);     // Catch: Exception -> L9
        byte[] r5 = Base64.decode(r4.getString("dict"), 0);     // Catch: Exception -> L9
        writeFile(new File(com.bytedance.apm6.foundation.context.ApmContext.getContext().getFilesDir(), "monitor_dict"), r5);     // Catch: Exception -> L9
        this.dict = r5;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private static void writeFile(File r2, byte[] r3) throws IOException {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length == 0) goto L30;
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
    L18:
        th = th;
    L19:
        IOUtils.safeClose(r0);
        throw th;
    L10:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: Throwable -> L18 Exception -> L23
    L12:
        r2.exists();     // Catch: Throwable -> L18 Exception -> L23
        FileOutputStream r1 = new FileOutputStream(r2);     // Catch: Throwable -> L18 Exception -> L23
        r1.write(r3);     // Catch: Throwable -> L15 Exception -> L17
        r1.flush();     // Catch: Throwable -> L15 Exception -> L17
        IOUtils.safeClose(r1);
        return;
    L17:
        r0 = r1;
    L15:
        th = th;
        r0 = r1;
        goto L19
    L21:
        IOUtils.safeClose(r0);
        return;
    }
}
