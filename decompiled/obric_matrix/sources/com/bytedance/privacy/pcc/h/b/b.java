package com.bytedance.privacy.pcc.h.b;

import com.bytedance.common.wschannel.WsConstants;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("att_cert_chain")
    private final String f5428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c(WsConstants.KEY_PAYLOAD)
    private final String f5429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("signature")
    private final String f5430c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("client_version")
        private final String f5431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("client_nonce")
        private final String f5432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("app_info")
        private final C0173a f5433c;

        /* JADX INFO: renamed from: com.bytedance.privacy.pcc.h.b.b$a$a, reason: collision with other inner class name */
        private static class C0173a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @com.google.gson.y.c(IBdInstall.PARAM_APP_ID)
            private final String f5434a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @com.google.gson.y.c("app_svc_id")
            private final String f5435b;

            C0173a(String r1, String r2) {
                this.f5434a = r1;
                this.f5435b = r2;
            }
        }

        public a(String r1, String r2, com.bytedance.privacy.pcc.b r3) {
            this.f5431a = r1;
            this.f5432b = r2;
            this.f5433c = new C0173a(r3.f5415c, r3.f5416d);
        }

        public String a() {
            com.google.gson.e r0 = new com.google.gson.e();
            r0.e();
            return r0.d().v(this);
        }

        public String toString() {
            return a();
        }
    }

    public b(String r1, String r2, String r3) {
        this.f5428a = r1;
        this.f5429b = r2;
        this.f5430c = r3;
    }

    public String a() {
        com.google.gson.e r0 = new com.google.gson.e();
        r0.e();
        return r0.d().v(this);
    }

    public String toString() {
        return a();
    }
}
