package com.ss.ttuploader;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final enum UploadEventManager extends Enum<UploadEventManager> {
    private static final /* synthetic */ UploadEventManager[] $VALUES = null;
    private static final String TAG = "UploadEventManager";
    public static final UploadEventManager instance = null;
    public static final String mImageLogType = "image_upload";
    public static final String mLogType = "video_upload";
    private JSONArray mImageJsonArray;
    private JSONArray mVideoJsonArray;

    static {
        UploadEventManager r0 = new UploadEventManager("instance", 0);
        instance = r0;
        $VALUES = new UploadEventManager[]{r0};
    }

    private UploadEventManager(String r1, int r2) {
        super(r1, r2);
        this.mVideoJsonArray = new JSONArray();
        this.mImageJsonArray = new JSONArray();
    }

    public static UploadEventManager valueOf(String r1) {
        return (UploadEventManager) Enum.valueOf(UploadEventManager.class, r1);
    }

    public static UploadEventManager[] values() {
        return (UploadEventManager[]) $VALUES.clone();
    }

    protected void addEvent(JSONObject r2) {
        monitor-enter(UploadEventManager.class);
        this.mVideoJsonArray.put(r2);     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void addImageEvent(JSONObject r2) {
        monitor-enter(UploadEventManager.class);
        this.mImageJsonArray.put(r2);     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public JSONArray popAllEvents() {
        JSONArray r0 = this.mVideoJsonArray;
        monitor-enter(UploadEventManager.class);
        this.mVideoJsonArray = new JSONArray();     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public JSONArray popAllImageEvents() {
        JSONArray r0 = this.mImageJsonArray;
        monitor-enter(UploadEventManager.class);
        this.mImageJsonArray = new JSONArray();     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
