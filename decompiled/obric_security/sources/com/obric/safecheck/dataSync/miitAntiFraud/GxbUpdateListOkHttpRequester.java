package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.constant.PerfConsts;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GxbUpdateListOkHttpRequester.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateListOkHttpRequester;", "", "()V", "API_PATH", "", "BASE_URL", "DATE_REGEX", "Lkotlin/text/Regex;", "SUCCESS_CODE", "", "TAG", "okHttpClient", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "getGxbUpdateList", "", "since", "parseCdnList", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateItem;", "jsonObject", "Lorg/json/JSONObject;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbUpdateListOkHttpRequester {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/get_gxb_update_list";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    private static final Regex DATE_REGEX = null;
    public static final GxbUpdateListOkHttpRequester INSTANCE = null;
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "GxbUpdateListOkHttpRequester";
    private static final OkHttpClient okHttpClient = null;

    static {
        INSTANCE = new GxbUpdateListOkHttpRequester();
        DATE_REGEX = new Regex("\\d{4}-\\d{2}-\\d{2}");
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        HttpLoggingInterceptor r1 = new HttpLoggingInterceptor(GxbUpdateListOkHttpRequester$okHttpClient$1.INSTANCE);
        r1.setLevel(HttpLoggingInterceptor.Level.BODY);
        Unit r2 = Unit.INSTANCE;
        okHttpClient = r0.addInterceptor(r1).build();
    }

    private GxbUpdateListOkHttpRequester() {
    }

    public static final /* synthetic */ List access$parseCdnList(GxbUpdateListOkHttpRequester r0, JSONObject r1) {
        return r0.parseCdnList(r1);
    }

    @JvmStatic
    public static final void getGxbUpdateList(String r3) {
        Intrinsics.checkNotNullParameter(r3, "since");
        if (DATE_REGEX.matches(r3) == true) goto L6;
        OLog.e(TAG, "get gxb update list failed, invalid since is " + r3);
        return;
    L6:
        HttpUrl r1 = HttpUrl.parse("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/get_gxb_update_list");
        if (r1 == null) goto L13;
        HttpUrl.Builder r2 = r1.newBuilder();
        if (r2 == null) goto L13;
        HttpUrl r4 = r2.addQueryParameter("since", r3).build();
        GxbAttestationHeaders r0 = GxbAttestationHeaders.INSTANCE;
        Request.Builder r5 = new Request.Builder().url(r4).get();
        Intrinsics.checkNotNullExpressionValue(r5, "Request.Builder()\n      …l)\n                .get()");
        okHttpClient.newCall(r0.addTo(r5, GxbAttestationHeaders.INSTANCE.getPemCertChain(TAG)).build()).enqueue(new AnonymousClass1());
        return;
    L13:
        OLog.e(TAG, "get gxb update list failed, invalid url");
    }

    private final List<GxbUpdateItem> parseCdnList(JSONObject r11) {
        JSONArray r10 = r11.optJSONArray("cdn_list");
        if (r10 == null) goto L5;
        ArrayList r12 = new ArrayList(r10.length());
        int r0 = r10.length();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L14;
        JSONObject r2 = r10.optJSONObject(r1);
        if (r2 == null) goto L12;
        r12.add(new GxbUpdateItem(r2.optString("file_name"), r2.optString("download_url"), r2.optString("md5"), r2.optString(PerfConsts.PERF_DISK_FILE_SIZE), r2.optString("version")));
    L12:
        r1 = r1 + 1;
        goto L7
    L14:
        return r12;
    L5:
        return CollectionsKt.emptyList();
    }
}
