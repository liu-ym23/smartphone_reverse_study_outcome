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
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0019\u001a\u001b\u001c\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\"\u0010\u000f\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester;", "", "()V", "API_PATH", "", "BASE_URL", "SUCCESS_CODE", "", "TAG", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "checkInstallable", "", "app", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppCheckItem;", "callback", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$Callback;", "apps", "", "safeToJson", "any", "Callback", "GxbAppCheckItem", "GxbAppInstallableApi", "GxbAppInstallableReq", "GxbAppInstallableResp", "GxbAppInstallableRule", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAppInstallableRequester {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/gxb_app_installable";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    public static final GxbAppInstallableRequester INSTANCE = null;
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "GxbAppInstallableRequester";
    private static final Lazy gson$delegate = null;

    /* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\n\u001a\u00020\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\fH&¨\u0006\u000f"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$Callback;", "", "onFailure", "", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "throwable", "", "onSuccess", "data", "", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void onFailure(int r1, String r2, Throwable r3);

        void onSuccess(Map<String, ? extends List<GxbAppInstallableRule>> r1);
    }

    /* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppCheckItem;", "", "packageName", "", "appMd5", "signMd5", "signSha1", "signSha256", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppMd5", "()Ljava/lang/String;", "getPackageName", "getSignMd5", "getSignSha1", "getSignSha256", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GxbAppCheckItem {

        @SerializedName("app_md5")
        private final String appMd5;

        @SerializedName("package_name")
        private final String packageName;

        @SerializedName("sign_md5")
        private final String signMd5;

        @SerializedName("sign_sha1")
        private final String signSha1;

        @SerializedName("sign_sha256")
        private final String signSha256;

        public static /* synthetic */ GxbAppCheckItem copy$default(GxbAppCheckItem r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.packageName;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.appMd5;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.signMd5;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.signSha1;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.signSha256;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.packageName;
        }

        public final String component2() {
            return this.appMd5;
        }

        public final String component3() {
            return this.signMd5;
        }

        public final String component4() {
            return this.signSha1;
        }

        public final String component5() {
            return this.signSha256;
        }

        public final GxbAppCheckItem copy(String r7, String r8, String r9, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r7, "packageName");
            return new GxbAppCheckItem(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof GxbAppCheckItem) == false) goto L16;
            GxbAppCheckItem r4 = (GxbAppCheckItem) r3;
            if (Intrinsics.areEqual(this.packageName, r4.packageName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.appMd5, r4.appMd5) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.signMd5, r4.signMd5) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.signSha1, r4.signSha1) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.signSha256, r4.signSha256) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            String r0 = this.packageName;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.appMd5;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.signMd5;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.signSha1;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.signSha256;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "GxbAppCheckItem(packageName=" + this.packageName + ", appMd5=" + this.appMd5 + ", signMd5=" + this.signMd5 + ", signSha1=" + this.signSha1 + ", signSha256=" + this.signSha256 + ")";
        }

        public GxbAppCheckItem(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "packageName");
            this.packageName = r2;
            this.appMd5 = r3;
            this.signMd5 = r4;
            this.signSha1 = r5;
            this.signSha256 = r6;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public /* synthetic */ GxbAppCheckItem(String r8, String r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L5;
            String r15 = (String) null;
            String r3 = null;
        L7:
            if ((r13 & 4) == 0) goto L9;
            String r16 = (String) null;
            String r4 = null;
        L11:
            if ((r13 & 8) == 0) goto L13;
            String r17 = (String) null;
            String r5 = null;
        L15:
            if ((r13 & 16) == 0) goto L17;
            String r18 = (String) null;
            String r6 = null;
        L18:
            this(r8, r3, r4, r5, r6);
            return;
        L17:
            r6 = r12;
            goto L18
        L13:
            r5 = r11;
            goto L15
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public final String getAppMd5() {
            return this.appMd5;
        }

        public final String getSignMd5() {
            return this.signMd5;
        }

        public final String getSignSha1() {
            return this.signSha1;
        }

        public final String getSignSha256() {
            return this.signSha256;
        }
    }

    /* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableApi;", "", "checkInstallable", "Lio/reactivex/Observable;", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableResp;", "appId", "", "pemCertChain", ProviderConstants.Sms.BODY, "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableReq;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private interface GxbAppInstallableApi {
        @Headers({"Content-Type: application/json"})
        @POST("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/gxb_app_installable")
        Observable<GxbAppInstallableResp> checkInstallable(@Header(GxbAttestationHeaders.HEADER_APP_ID) String r1, @Header(GxbAttestationHeaders.HEADER_CERT_CHAIN) String r2, @Body GxbAppInstallableReq r3);
    }

    /* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableReq;", "", "apps", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppCheckItem;", "(Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbAppInstallableReq {

        @SerializedName("apps")
        private final List<GxbAppCheckItem> apps;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GxbAppInstallableReq copy$default(GxbAppInstallableReq r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.apps;
        L6:
            return r0.copy(r1);
        }

        public final List<GxbAppCheckItem> component1() {
            return this.apps;
        }

        public final GxbAppInstallableReq copy(List<GxbAppCheckItem> r1) {
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
            List<GxbAppCheckItem> r0 = this.apps;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "GxbAppInstallableReq(apps=" + this.apps + ")";
        }

        public GxbAppInstallableReq(List<GxbAppCheckItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "apps");
            this.apps = r2;
        }

        public final List<GxbAppCheckItem> getApps() {
            return this.apps;
        }
    }

    /* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR,\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableResp;", "Lcom/obric/matrix/sdk/network/BaseResponseModel;", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "data", "", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "(ILjava/lang/String;Ljava/util/Map;)V", "getCode", "()I", "getData", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbAppInstallableResp extends BaseResponseModel {

        @SerializedName(AlogMonitor.ALOG_RESULT_CODE)
        private final int code;

        @SerializedName("data")
        private final Map<String, List<GxbAppInstallableRule>> data;

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

        public final Map<String, List<GxbAppInstallableRule>> component3() {
            return this.data;
        }

        public final GxbAppInstallableResp copy(int r1, String r2, Map<String, ? extends List<GxbAppInstallableRule>> r3) {
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
            Map<String, List<GxbAppInstallableRule>> r5 = this.data;
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

        public final Map<String, List<GxbAppInstallableRule>> getData() {
            return this.data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GxbAppInstallableResp(int r1, String r2, Map<String, ? extends List<GxbAppInstallableRule>> r3) {
            this.code = r1;
            this.message = r2;
            this.data = r3;
        }
    }

    /* JADX INFO: compiled from: GxbAppInstallableRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "", "area", "", "areaType", "ruleNo", "ruleType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getArea", "()Ljava/lang/String;", "getAreaType", "getRuleNo", "getRuleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GxbAppInstallableRule {

        @SerializedName("area")
        private final String area;

        @SerializedName("area_type")
        private final String areaType;

        @SerializedName("rule_no")
        private final String ruleNo;

        @SerializedName("rule_type")
        private final Integer ruleType;

        public GxbAppInstallableRule() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ GxbAppInstallableRule copy$default(GxbAppInstallableRule r0, String r1, String r2, String r3, Integer r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.area;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.areaType;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.ruleNo;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.ruleType;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.area;
        }

        public final String component2() {
            return this.areaType;
        }

        public final String component3() {
            return this.ruleNo;
        }

        public final Integer component4() {
            return this.ruleType;
        }

        public final GxbAppInstallableRule copy(String r1, String r2, String r3, Integer r4) {
            return new GxbAppInstallableRule(r1, r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof GxbAppInstallableRule) == false) goto L14;
            GxbAppInstallableRule r4 = (GxbAppInstallableRule) r3;
            if (Intrinsics.areEqual(this.area, r4.area) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.areaType, r4.areaType) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.ruleNo, r4.ruleNo) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ruleType, r4.ruleType) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r0 = this.area;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.areaType;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.ruleNo;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.ruleType;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "GxbAppInstallableRule(area=" + this.area + ", areaType=" + this.areaType + ", ruleNo=" + this.ruleNo + ", ruleType=" + this.ruleType + ")";
        }

        public GxbAppInstallableRule(String r1, String r2, String r3, Integer r4) {
            this.area = r1;
            this.areaType = r2;
            this.ruleNo = r3;
            this.ruleType = r4;
        }

        public /* synthetic */ GxbAppInstallableRule(String r2, String r3, String r4, Integer r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            String r8 = (String) null;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            String r9 = (String) null;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            String r10 = (String) null;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            Integer r11 = (Integer) null;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }

        public final String getArea() {
            return this.area;
        }

        public final String getAreaType() {
            return this.areaType;
        }

        public final String getRuleNo() {
            return this.ruleNo;
        }

        public final Integer getRuleType() {
            return this.ruleType;
        }
    }

    @JvmStatic
    public static final void checkInstallable(GxbAppCheckItem r2) {
        checkInstallable$default(r2, null, 2, null);
    }

    @JvmStatic
    public static final void checkInstallable(List<GxbAppCheckItem> r2) {
        checkInstallable$default(r2, null, 2, null);
    }

    private final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    static {
        INSTANCE = new GxbAppInstallableRequester();
        gson$delegate = LazyKt.lazy(GxbAppInstallableRequester$gson$2.INSTANCE);
    }

    private GxbAppInstallableRequester() {
    }

    public static final /* synthetic */ String access$safeToJson(GxbAppInstallableRequester r0, Object r1) {
        return r0.safeToJson(r1);
    }

    public static /* synthetic */ void checkInstallable$default(List r0, Callback r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        Callback r4 = (Callback) null;
    L5:
        checkInstallable(r0, r1);
    }

    @JvmStatic
    public static final void checkInstallable(List<GxbAppCheckItem> r9, final Callback r10) {
        Intrinsics.checkNotNullParameter(r9, "apps");
        if (r9.isEmpty() == false) goto L8;
        OLog.e(TAG, "check installable failed, apps is empty");
        if (r10 == null) goto L10;
        r10.onFailure(-1, "apps is empty", null);
        return;
    L10:
        return;
    L8:
        final GxbAppInstallableReq r0 = new GxbAppInstallableReq(r9);
        OLog.d(TAG, "check installable raw request: " + INSTANCE.safeToJson(r0));
        HttpRequestManager r2 = HttpRequestManager.INSTANCE;
        final Function1<GxbAppInstallableResp, Unit> r11 = new AnonymousClass2(r10);
        final Function1<Throwable, Unit> r1 = new AnonymousClass3(r10);
        r2.request(GxbAppInstallableApi.class, new GxbAppInstallableRequester$checkInstallable$$inlined$request$1(r0), new GxbAppInstallableRequester$checkInstallable$$inlined$request$2(r11), new GxbAppInstallableRequester$checkInstallable$$inlined$request$3(r1), HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER(), HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER());
    }

    public static /* synthetic */ void checkInstallable$default(GxbAppCheckItem r0, Callback r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        Callback r4 = (Callback) null;
    L5:
        checkInstallable(r0, r1);
    }

    @JvmStatic
    public static final void checkInstallable(GxbAppCheckItem r1, Callback r2) {
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
