package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.alog.AlogMonitor;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.httpclient.OkHttpUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: GxbAppInstallableOkHttpRequester.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\"\u0010\u0014\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableOkHttpRequester;", "", "()V", "API_PATH", "", "BASE_URL", "JSON_MEDIA_TYPE", "Lokhttp3/MediaType;", "SUCCESS_CODE", "", "TAG", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "okHttpClient", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "checkInstallable", "", "app", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppCheckItem;", "callback", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$Callback;", "apps", "", "safeToJson", "any", "GxbAppInstallableReq", "GxbAppInstallableResp", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAppInstallableOkHttpRequester {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/gxb_app_installable";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    public static final GxbAppInstallableOkHttpRequester INSTANCE = null;
    private static final MediaType JSON_MEDIA_TYPE = null;
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "GxbAppInstallableOkHttpRequester";
    private static final Lazy gson$delegate = null;
    private static final OkHttpClient okHttpClient = null;

    /* JADX INFO: compiled from: GxbAppInstallableOkHttpRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableOkHttpRequester$GxbAppInstallableReq;", "", "apps", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppCheckItem;", "(Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbAppInstallableReq {

        @SerializedName("apps")
        private final List<GxbAppInstallableRequester.GxbAppCheckItem> apps;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GxbAppInstallableReq copy$default(GxbAppInstallableReq r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.apps;
        L6:
            return r0.copy(r1);
        }

        public final List<GxbAppInstallableRequester.GxbAppCheckItem> component1() {
            return this.apps;
        }

        public final GxbAppInstallableReq copy(List<GxbAppInstallableRequester.GxbAppCheckItem> r1) {
            Intrinsics.checkNotNullParameter(r1, "apps");
            return new GxbAppInstallableReq(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof GxbAppInstallableReq) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.apps, ((GxbAppInstallableReq) r2).apps) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<GxbAppInstallableRequester.GxbAppCheckItem> r0 = this.apps;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "GxbAppInstallableReq(apps=" + this.apps + ")";
        }

        public GxbAppInstallableReq(List<GxbAppInstallableRequester.GxbAppCheckItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "apps");
            this.apps = r2;
        }

        public final List<GxbAppInstallableRequester.GxbAppCheckItem> getApps() {
            return this.apps;
        }
    }

    /* JADX INFO: compiled from: GxbAppInstallableOkHttpRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR,\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableOkHttpRequester$GxbAppInstallableResp;", "", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "data", "", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "(ILjava/lang/String;Ljava/util/Map;)V", "getCode", "()I", "getData", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbAppInstallableResp {

        @SerializedName(AlogMonitor.ALOG_RESULT_CODE)
        private final int code;

        @SerializedName("data")
        private final Map<String, List<GxbAppInstallableRequester.GxbAppInstallableRule>> data;

        @SerializedName("message")
        private final String message;

        public GxbAppInstallableResp() {
            this(0, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GxbAppInstallableResp copy$default(GxbAppInstallableResp r0, int r1, String r2, Map r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.message;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.data;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final Map<String, List<GxbAppInstallableRequester.GxbAppInstallableRule>> component3() {
            return this.data;
        }

        public final GxbAppInstallableResp copy(int r1, String r2, Map<String, ? extends List<GxbAppInstallableRequester.GxbAppInstallableRule>> r3) {
            return new GxbAppInstallableResp(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof GxbAppInstallableResp) == false) goto L12;
            GxbAppInstallableResp r4 = (GxbAppInstallableResp) r3;
            if (this.code == r4.code) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.data, r4.data) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.code) * 31;
            String r1 = this.message;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Map<String, List<GxbAppInstallableRequester.GxbAppInstallableRule>> r5 = this.data;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return "GxbAppInstallableResp(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GxbAppInstallableResp(int r1, String r2, Map<String, ? extends List<GxbAppInstallableRequester.GxbAppInstallableRule>> r3) {
            this.code = r1;
            this.message = r2;
            this.data = r3;
        }

        public final int getCode() {
            return this.code;
        }

        public /* synthetic */ GxbAppInstallableResp(int r2, String r3, Map r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            String r7 = (String) null;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            Map r8 = (Map) null;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final String getMessage() {
            return this.message;
        }

        public final Map<String, List<GxbAppInstallableRequester.GxbAppInstallableRule>> getData() {
            return this.data;
        }
    }

    @JvmStatic
    public static final void checkInstallable(GxbAppInstallableRequester.GxbAppCheckItem r2) {
        checkInstallable$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final void checkInstallable(List<GxbAppInstallableRequester.GxbAppCheckItem> r2) {
        checkInstallable$default(r2, null, 2, null);
    }

    private final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    static {
        INSTANCE = new GxbAppInstallableOkHttpRequester();
        JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
        gson$delegate = LazyKt.lazy(GxbAppInstallableOkHttpRequester$gson$2.INSTANCE);
        okHttpClient = OkHttpUtils.getInstance();
    }

    private GxbAppInstallableOkHttpRequester() {
    }

    public static final /* synthetic */ Gson access$getGson$p(GxbAppInstallableOkHttpRequester r0) {
        return r0.getGson();
    }

    public static /* synthetic */ void checkInstallable$default(List r0, GxbAppInstallableRequester.Callback r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        GxbAppInstallableRequester.Callback r4 = (GxbAppInstallableRequester.Callback) null;
    L5:
        checkInstallable(r0, r1);
    }

    @JvmStatic
    public static final void checkInstallable(List<GxbAppInstallableRequester.GxbAppCheckItem> r5, final GxbAppInstallableRequester.Callback r6) {
        Intrinsics.checkNotNullParameter(r5, "apps");
        if (r5.isEmpty() == false) goto L8;
        OLog.e(TAG, "check installable failed, apps is empty");
        if (r6 == null) goto L14;
        r6.onFailure(-1, "apps is empty", null);
        return;
    L14:
        return;
    L8:
        String r7 = INSTANCE.safeToJson(new GxbAppInstallableReq(r5));
        String r0 = GxbAttestationHeaders.INSTANCE.getPemCertChain(TAG);
        if (r0.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        OLog.d(TAG, "check installable raw request: " + r7 + ", hasAttestation=" + r2);
        GxbAttestationHeaders r1 = GxbAttestationHeaders.INSTANCE;
        Request.Builder r8 = new Request.Builder().url("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/gxb_app_installable").post(RequestBody.create(JSON_MEDIA_TYPE, r7));
        Intrinsics.checkNotNullExpressionValue(r8, "Request.Builder()\n      …MEDIA_TYPE, requestJson))");
        okHttpClient.newCall(r1.addTo(r8, r0).build()).enqueue(new AnonymousClass1(r6));
        return;
    L11:
        r2 = false;
        goto L12
    }

    public static /* synthetic */ void checkInstallable$default(GxbAppInstallableRequester.GxbAppCheckItem r0, GxbAppInstallableRequester.Callback r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        GxbAppInstallableRequester.Callback r4 = (GxbAppInstallableRequester.Callback) null;
    L5:
        checkInstallable(r0, r1);
    }

    @JvmStatic
    public static final void checkInstallable(GxbAppInstallableRequester.GxbAppCheckItem r1, GxbAppInstallableRequester.Callback r2) {
        Intrinsics.checkNotNullParameter(r1, "app");
        checkInstallable(CollectionsKt.listOf(r1), r2);
    }

    private final String safeToJson(Object r3) {
        String r2 = getGson().toJson(r3);     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r2, "gson.toJson(any)");     // Catch: Throwable -> L4
        return r2;
    L4:
        th = move-exception;
        return "(toJson failed: " + th.getMessage() + ") " + r3;
    }
}
