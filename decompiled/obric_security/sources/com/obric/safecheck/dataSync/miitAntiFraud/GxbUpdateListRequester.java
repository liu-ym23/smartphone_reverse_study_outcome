package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import com.obric.matrix.sdk.network.BaseResponseModel;
import com.obric.matrix.sdk.network.HttpRequestManager;
import com.obric.olog.OLog;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: GxbUpdateListRequester.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListRequester;", "", "()V", "API_PATH", "", "BASE_URL", "DATE_REGEX", "Lkotlin/text/Regex;", "SUCCESS_CODE", "", "TAG", "getGxbUpdateList", "", "since", "callback", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListRequester$Callback;", "Callback", "GxbUpdateListApi", "GxbUpdateListResp", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbUpdateListRequester {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/get_gxb_update_list";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    private static final Regex DATE_REGEX = null;
    public static final GxbUpdateListRequester INSTANCE = null;
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "GxbUpdateListRequester";

    /* JADX INFO: compiled from: GxbUpdateListRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListRequester$Callback;", "", "onFailure", "", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "throwable", "", "onSuccess", "cdnList", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateItem;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void onFailure(int r1, String r2, Throwable r3);

        void onSuccess(List<GxbUpdateItem> r1);
    }

    /* JADX INFO: compiled from: GxbUpdateListRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListRequester$GxbUpdateListApi;", "", "getGxbUpdateList", "Lio/reactivex/Observable;", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListRequester$GxbUpdateListResp;", "appId", "", "pemCertChain", "since", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private interface GxbUpdateListApi {
        @GET("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/get_gxb_update_list")
        Observable<GxbUpdateListResp> getGxbUpdateList(@Header(GxbAttestationHeaders.HEADER_APP_ID) String r1, @Header(GxbAttestationHeaders.HEADER_CERT_CHAIN) String r2, @Query("since") String r3);
    }

    /* JADX INFO: compiled from: GxbUpdateListRequester.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListRequester$GxbUpdateListResp;", "Lcom/obric/matrix/sdk/network/BaseResponseModel;", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "cdnList", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateItem;", "(ILjava/lang/String;Ljava/util/List;)V", "getCdnList", "()Ljava/util/List;", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class GxbUpdateListResp extends BaseResponseModel {

        @SerializedName("cdn_list")
        private final List<GxbUpdateItem> cdnList;

        @SerializedName(AlogMonitor.ALOG_RESULT_CODE)
        private final int code;

        @SerializedName("message")
        private final String message;

        public GxbUpdateListResp() {
            this(0, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GxbUpdateListResp copy$default(GxbUpdateListResp r0, int r1, String r2, List r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.message;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.cdnList;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final List<GxbUpdateItem> component3() {
            return this.cdnList;
        }

        public final GxbUpdateListResp copy(int r1, String r2, List<GxbUpdateItem> r3) {
            return new GxbUpdateListResp(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof GxbUpdateListResp) == false) goto L12;
            GxbUpdateListResp r4 = (GxbUpdateListResp) r3;
            if (this.code == r4.code) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.cdnList, r4.cdnList) == true) goto L19;
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
            List<GxbUpdateItem> r5 = this.cdnList;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return "GxbUpdateListResp(code=" + this.code + ", message=" + this.message + ", cdnList=" + this.cdnList + ")";
        }

        public final int getCode() {
            return this.code;
        }

        public /* synthetic */ GxbUpdateListResp(int r2, String r3, List r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            String r7 = (String) null;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            List r8 = (List) null;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final String getMessage() {
            return this.message;
        }

        public final List<GxbUpdateItem> getCdnList() {
            return this.cdnList;
        }

        public GxbUpdateListResp(int r1, String r2, List<GxbUpdateItem> r3) {
            this.code = r1;
            this.message = r2;
            this.cdnList = r3;
        }
    }

    @JvmStatic
    public static final void getGxbUpdateList(String r2) {
        getGxbUpdateList$default(r2, null, 2, null);
    }

    static {
        INSTANCE = new GxbUpdateListRequester();
        DATE_REGEX = new Regex("\\d{4}-\\d{2}-\\d{2}");
    }

    private GxbUpdateListRequester() {
    }

    public static /* synthetic */ void getGxbUpdateList$default(String r0, Callback r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        Callback r4 = (Callback) null;
    L5:
        getGxbUpdateList(r0, r1);
    }

    @JvmStatic
    public static final void getGxbUpdateList(final String r9, final Callback r10) {
        Intrinsics.checkNotNullParameter(r9, "since");
        if (DATE_REGEX.matches(r9) == true) goto L8;
        OLog.e(TAG, "get gxb update list failed, invalid since is " + r9);
        if (r10 == null) goto L10;
        r10.onFailure(-1, "invalid since: " + r9, null);
        return;
    L10:
        return;
    L8:
        HttpRequestManager r2 = HttpRequestManager.INSTANCE;
        final Function1<GxbUpdateListResp, Unit> r0 = new AnonymousClass2(r10);
        final Function1<Throwable, Unit> r1 = new AnonymousClass3(r10);
        r2.request(GxbUpdateListApi.class, new GxbUpdateListRequester$getGxbUpdateList$$inlined$request$1(r9), new GxbUpdateListRequester$getGxbUpdateList$$inlined$request$2(r0), new GxbUpdateListRequester$getGxbUpdateList$$inlined$request$3(r1), HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER(), HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER());
    }
}
