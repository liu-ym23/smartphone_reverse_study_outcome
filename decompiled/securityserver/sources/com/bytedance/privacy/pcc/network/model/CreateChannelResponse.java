package com.bytedance.privacy.pcc.network.model;

import a.a;
import android.util.Base64;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.bridge.ILogBridge;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class CreateChannelResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Payload f18a;
    public final String b;
    public final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19d;
    public final int e;

    public static class EvidenceInfo {
    }

    public static class Payload {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ServiceInfo f20a;
        public EvidenceInfo b;
        public String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f21d;
        public String e;
    }

    public static class ServiceInfo {
    }

    public static class SvcKeyInfo {
    }

    public CreateChannelResponse(Payload r1, String r2, String r3, String r4, int r5) {
        this.f18a = r1;
        this.b = r2;
        this.c = r3;
        this.f19d = r4;
        this.e = r5;
    }

    public static CreateChannelResponse a(String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, int r15) {
        EvidenceInfo r0 = null;
        if (r7 != null) goto L5;
    L7:
        ServiceInfo r16 = null;
    L8:
        if (r8 != null) goto L10;
    L12:
        Payload r2 = new Payload();
        r2.f20a = r16;
        r2.b = r0;
        r2.c = r9;
        r2.f21d = r10;
        r2.e = r11;
        return new CreateChannelResponse(r2, r12, r13, r14, r15);
    L10:
        if (r8.isEmpty() == true) goto L12;
        r0 = (EvidenceInfo) new Gson().fromJson(r8, EvidenceInfo.class);
        goto L12
    L5:
        if (r7.isEmpty() == true) goto L7;
        r16 = (ServiceInfo) new Gson().fromJson(r7, ServiceInfo.class);
        goto L8
    }

    public static CreateChannelResponse c(String r8, String r9) {
        JsonObject r10 = JsonParser.parseString(r8).getAsJsonObject();
        int r0 = r10.get("code").getAsInt();
        if (r0 != 0) goto L10;
        JsonObject r11 = r10.getAsJsonObject("data");
        String r3 = r11.get(WsConstants.KEY_PAYLOAD).getAsString();
        String r1 = new String(Base64.decode(r3, 0), StandardCharsets.UTF_8);
        LogUtils.d("CreateChannelResponse", "CreateChannelResponse payload JSON: ".concat(r1));
        Payload r2 = (Payload) new Gson().fromJson(r1, Payload.class);
        ServiceInfo r4 = r2.f20a;
        Log.w("CreateChannelResponse", "CreateChannelResponse: serviceInfo or appSvcKeyInfo is null");
        ILogBridge r5 = LogUtils.f32a;
        if (r5 == null) goto L8;
        r5.b();
    L8:
        return new CreateChannelResponse(r2, r3, r9, r11.get("signature").getAsString(), 2);
    L10:
        throw new Exception(a.e(r0, "unexpected server code="));
    }

    public final ServiceInfo b() {
        Payload r0 = this.f18a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f20a;
    }
}
