package com.bytedanceos.cloud;

import android.content.Context;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityPackageWhiteListData {
    private static String KEY_VERSION = "version";
    private static final String TAG = "SecurityPackageWhiteListData";
    public static final String TYPE_MEMORY_CLEAN = "memory_clear_packages_white_list";
    private int mId;
    private List<String> mMemoryPackages;
    private String mSourceJsonData;
    private int mVersion;

    static {
    }

    public SecurityPackageWhiteListData() {
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int mVersion) {
        this.mVersion = mVersion;
    }

    public String getSourceJsonData() {
        return this.mSourceJsonData;
    }

    public void setSourceJsonData(String sourceJsonData) {
        this.mSourceJsonData = sourceJsonData;
    }

    public List<String> getMemoryPackages() {
        return this.mMemoryPackages;
    }

    public void setMemoryPackages(List<String> packages) {
        this.mMemoryPackages = packages;
    }

    public boolean isValid() {
        List<String> r0 = this.mMemoryPackages;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.size() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static SecurityPackageWhiteListData getDataFromFile(Context context) {
        String r0 = SecurityPackageWhiteListFile.getFromFile(context);
        if (r0 != null) goto L7;
        return null;
    L7:
        return getDataByJson(r0);
    }

    public static SecurityPackageWhiteListData getDataByJson(String json) {
        SecurityPackageWhiteListData r1 = null;
        JSONObject r2 = new JSONObject(json);     // Catch: Exception -> L10
        SecurityPackageWhiteListData r3 = new SecurityPackageWhiteListData();     // Catch: Exception -> L10
        r3.setVersion(r2.getInt(KEY_VERSION));     // Catch: Exception -> L8
        if (r2.getJSONArray(TYPE_MEMORY_CLEAN) == null) goto L17;
        r3.setMemoryPackages(parsePackages(r2.getJSONArray(TYPE_MEMORY_CLEAN)));     // Catch: Exception -> L8
        return r3;
    L17:
        return r3;
    L8:
        e = e;
        r1 = r3;
    L11:
        OLog.w(TAG, "parse config exception :" + e.getMessage());
        return r1;
    L10:
        e = e;
        goto L11
    }

    private static List<String> parsePackages(JSONArray datas) {
        if (datas != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = datas.length();     // Catch: Exception -> L10
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        r0.add(datas.getString(r2));     // Catch: Exception -> L10
        r2 = r2 + 1;
    L12:
        return r0;
    L10:
        e = move-exception;
        OLog.w(TAG, "parse config type exception :" + e.getMessage());
        goto L12
    }
}
