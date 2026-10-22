package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.matrix.sdk.network.BaseResponseModel;
import com.obric.matrix.sdk.network.HttpRequestManager;
import com.obric.olog.Constants;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbAppInstallHitReporter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\"\u0010\u0010\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter;", "", "()V", "API_PATH", "", "BASE_URL", "SUCCESS_CODE", "", "TAG", "TYPE", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", Constants.REPORT_FIELD, "", "type", "ruleNo", "alarmCnt", "installAppNum", "callback", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$Callback;", "items", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitItem;", "safeToJson", "any", "Callback", "GxbAppInstallHitApi", "GxbAppInstallHitItem", "GxbAppInstallHitReq", "GxbAppInstallHitResp", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAppInstallHitReporter {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/gxb_app_install_hit";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    public static final GxbAppInstallHitReporter INSTANCE = null;
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "GxbAppInstallHitReporter";
    public static final int TYPE = 2;
    private static final Lazy gson$delegate = null;

    /* JADX INFO: compiled from: GxbAppInstallHitReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$Callback;", "", "onFailure", "", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "throwable", "", "onSuccess", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void onFailure(int r1, String r2, Throwable r3);

        void onSuccess();
    }

    /* JADX INFO: compiled from: GxbAppInstallHitReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitApi;", "", Constants.REPORT_FIELD, "Lio/reactivex/Observable;", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitResp;", "appId", "", "pemCertChain", ProviderConstants.Sms.BODY, "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitReq;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private interface GxbAppInstallHitApi {
        @Headers({"Content-Type: application/json"})
        @POST("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/gxb_app_install_hit")
        Observable<GxbAppInstallHitResp> report(@Header(GxbAttestationHeaders.HEADER_APP_ID) String r1, @Header(GxbAttestationHeaders.HEADER_CERT_CHAIN) String r2, @Body GxbAppInstallHitReq r3);
    }

    /* JADX INFO: compiled from: GxbAppInstallHitReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitItem;", "", "type", "", "ruleNo", "", "alarmCnt", "installAppNum", "(ILjava/lang/String;II)V", "getAlarmCnt", "()I", "getInstallAppNum", "getRuleNo", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GxbAppInstallHitItem {

        @SerializedName("alarm_cnt")
        private final int alarmCnt;

        @SerializedName("install_appnum")
        private final int installAppNum;

        @SerializedName("rule_no")
        private final String ruleNo;

        @SerializedName("type")
        private final int type;

        public static /* synthetic */ GxbAppInstallHitItem copy$default(GxbAppInstallHitItem r0, int r1, String r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.ruleNo;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.alarmCnt;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.installAppNum;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.type;
        }

        public final String component2() {
            return this.ruleNo;
        }

        public final int component3() {
            return this.alarmCnt;
        }

        public final int component4() {
            return this.installAppNum;
        }

        public final GxbAppInstallHitItem copy(int r1, String r2, int r3, int r4) {
            return new GxbAppInstallHitItem(r1, r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof GxbAppInstallHitItem) == false) goto L14;
            GxbAppInstallHitItem r4 = (GxbAppInstallHitItem) r3;
            if (this.type == r4.type) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.ruleNo, r4.ruleNo) == true) goto L10;
            return false;
        L10:
            if (this.alarmCnt == r4.alarmCnt) goto L12;
            return false;
        L12:
            if (this.installAppNum == r4.installAppNum) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.type) * 31;
            String r1 = this.ruleNo;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((((r0 + r2) * 31) + Integer.hashCode(this.alarmCnt)) * 31) + Integer.hashCode(this.installAppNum);
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "GxbAppInstallHitItem(type=" + this.type + ", ruleNo=" + this.ruleNo + ", alarmCnt=" + this.alarmCnt + ", installAppNum=" + this.installAppNum + ")";
        }

        public GxbAppInstallHitItem(int r1, String r2, int r3, int r4) {
            this.type = r1;
            this.ruleNo = r2;
            this.alarmCnt = r3;
            this.installAppNum = r4;
        }

        public final int getType() {
            return this.type;
        }

        public /* synthetic */ GxbAppInstallHitItem(int r2, String r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
            String r8 = (String) null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 1;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = 1;
        L11:
            this(r2, r3, r4, r5);
        }

        public final String getRuleNo() {
            return this.ruleNo;
        }

        public final int getAlarmCnt() {
            return this.alarmCnt;
        }

        public final int getInstallAppNum() {
            return this.installAppNum;
        }
    }

    /* JADX INFO: compiled from: GxbAppInstallHitReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitReq;", "", "hits", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitItem;", "(Ljava/util/List;)V", "getHits", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbAppInstallHitReq {

        @SerializedName("hits")
        private final List<GxbAppInstallHitItem> hits;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GxbAppInstallHitReq copy$default(GxbAppInstallHitReq r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.hits;
        L6:
            return r0.copy(r1);
        }

        public final List<GxbAppInstallHitItem> component1() {
            return this.hits;
        }

        public final GxbAppInstallHitReq copy(List<GxbAppInstallHitItem> r1) {
            Intrinsics.checkNotNullParameter(r1, "hits");
            return new GxbAppInstallHitReq(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof GxbAppInstallHitReq) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.hits, ((GxbAppInstallHitReq) r2).hits) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<GxbAppInstallHitItem> r0 = this.hits;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "GxbAppInstallHitReq(hits=" + this.hits + ")";
        }

        public GxbAppInstallHitReq(List<GxbAppInstallHitItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "hits");
            this.hits = r2;
        }

        public final List<GxbAppInstallHitItem> getHits() {
            return this.hits;
        }
    }

    /* JADX INFO: compiled from: GxbAppInstallHitReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallHitReporter$GxbAppInstallHitResp;", "Lcom/obric/matrix/sdk/network/BaseResponseModel;", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbAppInstallHitResp extends BaseResponseModel {

        @SerializedName(AlogMonitor.ALOG_RESULT_CODE)
        private final int code;

        @SerializedName("message")
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public GxbAppInstallHitResp() {
            int r2 = 0;
            this(r2, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ GxbAppInstallHitResp copy$default(GxbAppInstallHitResp r0, int r1, String r2, int r3, Object r4) {
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

        public final GxbAppInstallHitResp copy(int r1, String r2) {
            return new GxbAppInstallHitResp(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof GxbAppInstallHitResp) == false) goto L10;
            GxbAppInstallHitResp r4 = (GxbAppInstallHitResp) r3;
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
            return "GxbAppInstallHitResp(code=" + this.code + ", message=" + this.message + ")";
        }

        public final int getCode() {
            return this.code;
        }

        public /* synthetic */ GxbAppInstallHitResp(int r1, String r2, int r3, DefaultConstructorMarker r4) {
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

        public GxbAppInstallHitResp(int r1, String r2) {
            this.code = r1;
            this.message = r2;
        }
    }

    private final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    @JvmStatic
    public static final void report(int r7, String r8) {
        report$default(r7, r8, 0, 0, null, 28, null);
    }

    @JvmStatic
    public static final void report(int r7, String r8, int r9) {
        report$default(r7, r8, r9, 0, null, 24, null);
    }

    @JvmStatic
    public static final void report(int r7, String r8, int r9, int r10) {
        report$default(r7, r8, r9, r10, null, 16, null);
    }

    @JvmStatic
    public static final void report(List<GxbAppInstallHitItem> r2) {
        report$default(r2, null, 2, null);
    }

    static {
        INSTANCE = new GxbAppInstallHitReporter();
        gson$delegate = LazyKt.lazy(GxbAppInstallHitReporter$gson$2.INSTANCE);
    }

    private GxbAppInstallHitReporter() {
    }

    public static final /* synthetic */ String access$safeToJson(GxbAppInstallHitReporter r0, Object r1) {
        return r0.safeToJson(r1);
    }

    public static /* synthetic */ void report$default(int r0, String r1, int r2, int r3, Callback r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 16) == 0) goto L11;
        r4 = null;
        Callback r7 = (Callback) null;
    L11:
        report(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void report(int r1, String r2, int r3, int r4, Callback r5) {
        report(CollectionsKt.listOf(new GxbAppInstallHitItem(r1, r2, r3, r4)), r5);
    }

    public static /* synthetic */ void report$default(List r0, Callback r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        Callback r4 = (Callback) null;
    L5:
        report(r0, r1);
    }

    @JvmStatic
    public static final void report(final List<GxbAppInstallHitItem> r10, final Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "items");
        if (r10.isEmpty() == false) goto L8;
        OLog.e(TAG, "report skipped, items is empty");
        if (r11 == null) goto L10;
        r11.onFailure(-1, "items is empty", null);
        return;
    L10:
        return;
    L8:
        final GxbAppInstallHitReq r0 = new GxbAppInstallHitReq(r10);
        OLog.d(TAG, "report raw request: " + INSTANCE.safeToJson(r0));
        HttpRequestManager r3 = HttpRequestManager.INSTANCE;
        final Function1<GxbAppInstallHitResp, Unit> r1 = new AnonymousClass2(r10, r11);
        final Function1<Throwable, Unit> r2 = new AnonymousClass3(r10, r11);
        r3.request(GxbAppInstallHitApi.class, new GxbAppInstallHitReporter$report$$inlined$request$1(r0), new GxbAppInstallHitReporter$report$$inlined$request$2(r1), new GxbAppInstallHitReporter$report$$inlined$request$3(r2), HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER(), HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER());
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
