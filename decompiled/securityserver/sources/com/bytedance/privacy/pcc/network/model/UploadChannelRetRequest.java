package com.bytedance.privacy.pcc.network.model;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes.dex */
public class UploadChannelRetRequest {

    public static class Payload {

        public static class AppInfoPayload {
        }

        public final String toString() {
            return new Gson().toJson(this);
        }
    }

    public final String toString() {
        return new Gson().toJson(this);
    }
}
