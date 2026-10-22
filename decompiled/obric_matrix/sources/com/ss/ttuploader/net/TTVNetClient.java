package com.ss.ttuploader.net;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTVNetClient {
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;

    public interface CompletionListener {
        void onCompletion(JSONObject r1, Error r2);
    }

    public TTVNetClient() {
    }

    public void cancel() {
    }

    public void startTask(String r1, CompletionListener r2) {
    }

    public void startTask(String r1, Map<String, String> r2, CompletionListener r3) {
    }

    public void startTask(String r1, Map<String, String> r2, JSONObject r3, int r4, CompletionListener r5) {
    }
}
