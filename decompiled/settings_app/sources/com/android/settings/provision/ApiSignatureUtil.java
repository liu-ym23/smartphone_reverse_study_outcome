package com.android.settings.provision;

import android.util.Base64;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApiSignatureUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J4\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\f\u0010\u000f\u001a\u00020\u0004*\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/android/settings/provision/ApiSignatureUtil;", "", "()V", "buildQueryString", "", "params", "", "generateSignature", "method", "queryParams", "body", "", "appSec", "parseQueryString", "queryStr", "toHex", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ApiSignatureUtil {
    public static final ApiSignatureUtil INSTANCE = null;

    static {
        INSTANCE = new ApiSignatureUtil();
    }

    private ApiSignatureUtil() {
    }

    public final String generateSignature(String r3, Map<String, String> r4, byte[] r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "queryParams");
        Intrinsics.checkNotNullParameter(r6, "appSec");
        String r7 = r3 + '\n' + parseQueryString(buildQueryString(r4)) + '\n';
        if (r5 != null) goto L5;
    L11:
        Mac r8 = Mac.getInstance("HmacSHA256");
        byte[] r9 = r6.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r9, "getBytes(...)");
        r8.init(new SecretKeySpec(r9, "HmacSHA256"));
        byte[] r2 = r7.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r2, "getBytes(...)");
        String r10 = Base64.encodeToString(r8.doFinal(r2), 2);
        Intrinsics.checkNotNullExpressionValue(r10, "encodeToString(...)");
        return r10;
    L5:
        if (r5.length != 0) goto L7;
        boolean r11 = true;
    L9:
        if ((!r11) == false) goto L11;
        byte[] r12 = MessageDigest.getInstance("MD5").digest(r5);
        Intrinsics.checkNotNullExpressionValue(r12, "digest(...)");
        r7 = r7 + toHex(r12) + '\n';
        goto L11
    L7:
        r11 = false;
        goto L9
    }

    private final String buildQueryString(Map<String, String> r10) {
        if (r10.isEmpty() == false) goto L6;
        return "";
    L6:
        ArrayList r9 = new ArrayList(r10.size());
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<String, String> r0 = r11.next();
        r9.add(r0.getKey() + '=' + URLEncoder.encode(r0.getValue(), "UTF-8"));
        goto L8
    L11:
        return CollectionsKt.joinToString$default(CollectionsKt.sorted(r9), "&", null, null, 0, null, null, 62, null);
    }

    private final String parseQueryString(String r10) {
        String r0 = r10;
        if (r0.length() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L8;
        return "";
    L8:
        if (StringsKt.contains$default(r0, "_nonce", false, 2, null) == true) goto L11;
        return "";
    L11:
        return CollectionsKt.joinToString$default(CollectionsKt.sorted(StringsKt.split$default(r0, new String[]{"&"}, false, 0, 6, null)), "&", null, null, 0, null, null, 62, null);
    L5:
        r9 = false;
        goto L6
    }

    private final String toHex(byte[] r10) {
        return ArraysKt.joinToString$default(r10, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }
}
