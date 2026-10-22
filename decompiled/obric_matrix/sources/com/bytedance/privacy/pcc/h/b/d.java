package com.bytedance.privacy.pcc.h.b;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c(WsConstants.KEY_PAYLOAD)
    private final String f5457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("signature")
    private final String f5458b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("client_version")
        private final String f5459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("app_info")
        private final C0175a f5460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c(WsConstants.KEY_CHANNEL_ID)
        private final String f5461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c("channel_ret")
        private final String f5462d;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.h.b.d$a$a, reason: collision with other inner class name */
        private static class C0175a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @com.google.gson.y.c(IBdInstall.PARAM_APP_ID)
            private final String f5463a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @com.google.gson.y.c("app_svc_id")
            private final String f5464b;

            C0175a(String r1, String r2) {
                this.f5463a = r1;
                this.f5464b = r2;
            }
        }

        public a(String r2, com.bytedance.privacy.pcc.b r3, String r4, String r5) {
            this.f5459a = r2;
            this.f5460b = new C0175a(r3.f5415c, r3.f5416d);
            this.f5461c = r4;
            this.f5462d = r5;
        }

        public String a() {
            return new Gson().v(this);
        }

        public String toString() {
            return a();
        }
    }

    public d(String r1, String r2) {
        this.f5457a = r1;
        this.f5458b = r2;
    }

    public String a() {
        return new Gson().v(this);
    }

    public String toString() {
        return a();
    }
}
