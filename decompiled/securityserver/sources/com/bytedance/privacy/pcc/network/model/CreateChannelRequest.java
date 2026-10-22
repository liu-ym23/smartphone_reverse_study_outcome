package com.bytedance.privacy.pcc.network.model;

import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: classes.dex */
public class CreateChannelRequest {

    public static class Payload {

        public static class AppInfoPayload {
        }

        public final String toString() {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
        }
    }

    public final String toString() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
