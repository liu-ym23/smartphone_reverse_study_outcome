package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.obric.matrix.sdk.network.BaseResponseModel;
import com.obric.matrix.sdk.network.HttpRequestManager;
import com.obric.olog.Constants;
import com.obric.olog.OLog;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PushTokenReporter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenReporter;", "", "()V", "API_PATH", "", "BASE_URL", "SUCCESS_CODE", "", "TAG", Constants.REPORT_FIELD, "", "deviceToken", "PushTokenApi", "PushTokenReq", "PushTokenResp", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushTokenReporter {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/push_token";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    public static final PushTokenReporter INSTANCE = null;
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "PushTokenReporter";

    /* JADX INFO: compiled from: PushTokenReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenReporter$PushTokenApi;", "", "reportPushToken", "Lio/reactivex/Observable;", "Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenReporter$PushTokenResp;", "appId", "", "pemCertChain", "requestBody", "Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenReporter$PushTokenReq;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private interface PushTokenApi {
        @POST("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/push_token")
        Observable<PushTokenResp> reportPushToken(@Header(GxbAttestationHeaders.HEADER_APP_ID) String r1, @Header(GxbAttestationHeaders.HEADER_CERT_CHAIN) String r2, @Body PushTokenReq r3);
    }

    /* JADX INFO: compiled from: PushTokenReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenReporter$PushTokenReq;", "", "push_token", "", "(Ljava/lang/String;)V", "getPush_token", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class PushTokenReq {
        private final String push_token;

        public static /* synthetic */ PushTokenReq copy$default(PushTokenReq r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.push_token;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.push_token;
        }

        public final PushTokenReq copy(String r1) {
            Intrinsics.checkNotNullParameter(r1, "push_token");
            return new PushTokenReq(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof PushTokenReq) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.push_token, ((PushTokenReq) r2).push_token) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.push_token;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "PushTokenReq(push_token=" + this.push_token + ")";
        }

        public PushTokenReq(String r2) {
            Intrinsics.checkNotNullParameter(r2, "push_token");
            this.push_token = r2;
        }

        public final String getPush_token() {
            return this.push_token;
        }
    }

    /* JADX INFO: compiled from: PushTokenReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenReporter$PushTokenResp;", "Lcom/obric/matrix/sdk/network/BaseResponseModel;", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class PushTokenResp extends BaseResponseModel {

        @SerializedName(AlogMonitor.ALOG_RESULT_CODE)
        private final int code;

        @SerializedName("message")
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public PushTokenResp() {
            int r2 = 0;
            this(r2, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PushTokenResp copy$default(PushTokenResp r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.message;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final PushTokenResp copy(int r1, String r2) {
            return new PushTokenResp(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof PushTokenResp) == false) goto L10;
            PushTokenResp r4 = (PushTokenResp) r3;
            if (this.code == r4.code) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.message, r4.message) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.code) * 31;
            String r1 = this.message;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "PushTokenResp(code=" + this.code + ", message=" + this.message + ")";
        }

        public final int getCode() {
            return this.code;
        }

        public /* synthetic */ PushTokenResp(int r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
            String r5 = (String) null;
        L8:
            this(r1, r2);
        }

        public final String getMessage() {
            return this.message;
        }

        public PushTokenResp(int r1, String r2) {
            this.code = r1;
            this.message = r2;
        }
    }

    static {
        INSTANCE = new PushTokenReporter();
    }

    private PushTokenReporter() {
    }

    @JvmStatic
    public static final void report(final String r8) {
        Intrinsics.checkNotNullParameter(r8, "deviceToken");
        if (StringsKt.isBlank(r8) == false) goto L6;
        OLog.w(TAG, "skip report push token, token is blank");
        return;
    L6:
        HttpRequestManager r1 = HttpRequestManager.INSTANCE;
        final AnonymousClass2 r0 = AnonymousClass2.INSTANCE;
        final AnonymousClass3 r2 = AnonymousClass3.INSTANCE;
        Scheduler r6 = HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER();
        Scheduler r7 = HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER();
        Function r9 = new PushTokenReporter$report$$inlined$request$1(r8);
        HttpRequestManager.HttpErrorCallback r4 = null;
        if (r0 == null) goto L9;
        HttpRequestManager.HttpSuccessCallback<PushTokenResp> r5 = new PushTokenReporter$report$$inlined$request$2(r0);
    L10:
        HttpRequestManager.HttpSuccessCallback<PushTokenResp> r3 = r5;
        if (r2 == null) goto L13;
        r4 = new PushTokenReporter$report$$inlined$request$3(r2);
    L13:
        r1.request(PushTokenApi.class, r9, r3, r4, r6, r7);
        return;
    L9:
        r5 = null;
        goto L10
    }
}
