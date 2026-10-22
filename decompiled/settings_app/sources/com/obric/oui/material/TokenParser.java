package com.obric.oui.material;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TokenParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\bJ1\u0010\b\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004¢\u0006\u0002\u0010\u000bJ;\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086\bJ>\u0010\u0013\u001a\u00020\r\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012J9\u0010\u0015\u001a\u00020\r\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u000f2\u0006\u0010\u0018\u001a\u0002H\u00162\u0006\u0010\u0019\u001a\u0002H\u0017H\u0002¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/material/TokenParser;", "", "()V", "createTokenMap", "", "", ExifInterface.GPS_DIRECTION_TRUE, "target", "parse", "name", "tokens", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/Object;", "register", "", AccountConst.KEY_TOKEN_MAP, "", "customTokenOwner", "overrideExisting", "", "registerTokens", "customTokens", "putIfAbsentCompat", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "key", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenParser {
    public static final TokenParser INSTANCE = null;

    static {
        INSTANCE = new TokenParser();
    }

    private TokenParser() {
    }

    public final /* synthetic */ <T> Map<String, T> createTokenMap(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        LinkedHashMap r1 = new LinkedHashMap();
        Field[] r2 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r2, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r3 = r2.length;     // Catch: Exception -> L11
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L13;
        Field r5 = r2[r4];     // Catch: Exception -> L11
        r4 = r4 + 1;     // Catch: Exception -> L11
        if (Object.class.isAssignableFrom(r5.getType()) == false) goto L4;
        r5.setAccessible(true);     // Catch: Exception -> L11
        Object r6 = r5.get(r10);     // Catch: Exception -> L11
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L11
        if ((r6 instanceof Object) == false) goto L4;
        String r7 = r5.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r7, "field.name");     // Catch: Exception -> L11
        String r8 = r7;     // Catch: Exception -> L11
        Locale r9 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "ROOT");     // Catch: Exception -> L11
        Locale r11 = r9;     // Catch: Exception -> L11
        String r12 = r7.toLowerCase(r9);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r6, "value");     // Catch: Exception -> L11
        r1.put(r12, r6);     // Catch: Exception -> L11
    L13:
        return r1;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r10.getClass().getSimpleName()), e);
        goto L13
    }

    public final <T> T parse(String r3, Map<String, ? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "tokens");
        if (r3 != null) goto L5;
    L4:
        String r5 = null;
    L9:
        String r0 = r5;
        if (r0 != null) goto L12;
    L15:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        return null;
    L19:
        return r4.get(r5);
    L12:
        if (r0.length() == 0) goto L15;
        r1 = false;
        goto L16
    L5:
        Locale r2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r2, "ROOT");
        String r6 = r3.toLowerCase(r2);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(locale)");
        if (r6 == null) goto L4;
        r5 = StringsKt.trim(r6).toString();
        goto L9
    }

    public static /* synthetic */ void register$default(TokenParser r9, Map r10, Object r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = true;
    L5:
        Intrinsics.checkNotNullParameter(r10, AccountConst.KEY_TOKEN_MAP);
        Intrinsics.checkNotNullParameter(r11, "customTokenOwner");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        LinkedHashMap r1 = new LinkedHashMap();
        Field[] r2 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r2, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L14
        int r3 = r2.length;     // Catch: Exception -> L14
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L16;
        Field r5 = r2[r4];     // Catch: Exception -> L14
        r4 = r4 + 1;     // Catch: Exception -> L14
        if (Object.class.isAssignableFrom(r5.getType()) == false) goto L7;
        r5.setAccessible(true);     // Catch: Exception -> L14
        Object r6 = r5.get(r11);     // Catch: Exception -> L14
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L14
        if ((r6 instanceof Object) == false) goto L7;
        String r7 = r5.getName();     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r7, "field.name");     // Catch: Exception -> L14
        String r8 = r7;     // Catch: Exception -> L14
        Locale r15 = Locale.ROOT;     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r15, "ROOT");     // Catch: Exception -> L14
        Locale r16 = r15;     // Catch: Exception -> L14
        String r17 = r7.toLowerCase(r15);     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r6, "value");     // Catch: Exception -> L14
        r1.put(r17, r6);     // Catch: Exception -> L14
    L16:
        r9.registerTokens(r10, r1, r12);
        return;
    L14:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L16
    }

    public final /* synthetic */ <T> void register(Map<String, T> r11, Object r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, AccountConst.KEY_TOKEN_MAP);
        Intrinsics.checkNotNullParameter(r12, "customTokenOwner");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        LinkedHashMap r2 = new LinkedHashMap();
        Field[] r3 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r3, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r4 = r3.length;     // Catch: Exception -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L13;
        Field r6 = r3[r5];     // Catch: Exception -> L11
        r5 = r5 + 1;     // Catch: Exception -> L11
        if (Object.class.isAssignableFrom(r6.getType()) == false) goto L4;
        r6.setAccessible(true);     // Catch: Exception -> L11
        Object r7 = r6.get(r12);     // Catch: Exception -> L11
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L11
        if ((r7 instanceof Object) == false) goto L4;
        String r8 = r6.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r8, "field.name");     // Catch: Exception -> L11
        String r9 = r8;     // Catch: Exception -> L11
        Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "ROOT");     // Catch: Exception -> L11
        Locale r14 = r10;     // Catch: Exception -> L11
        String r15 = r8.toLowerCase(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r7, "value");     // Catch: Exception -> L11
        r2.put(r15, r7);     // Catch: Exception -> L11
    L13:
        registerTokens(r11, r2, r13);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r12.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerTokens$default(TokenParser r0, Map r1, Map r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        r0.registerTokens(r1, r2, r3);
    }

    public final <T> void registerTokens(Map<String, T> r7, Map<String, ? extends T> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, AccountConst.KEY_TOKEN_MAP);
        Intrinsics.checkNotNullParameter(r8, "customTokens");
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r9 == false) goto L16;
        Iterator<Map.Entry<String, ? extends T>> r6 = r8.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L25;
        Map.Entry<String, ? extends T> r10 = r6.next();
        String r11 = r10.getKey();
        T r12 = r10.getValue();
        Locale r4 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r4, "ROOT");
        String r13 = r11.toLowerCase(r4);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");
        String r14 = StringsKt.trim(r13).toString();
        if (r14.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L9;
        r7.put(r14, r12);
        goto L9
    L13:
        r5 = false;
        goto L14
    L25:
        return;
    L16:
        Iterator<Map.Entry<String, ? extends T>> r15 = r8.entrySet().iterator();
    L18:
        if (r15.hasNext() == false) goto L36;
        Map.Entry<String, ? extends T> r16 = r15.next();
        String r17 = r16.getKey();
        T r18 = r16.getValue();
        Locale r19 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r19, "ROOT");
        String r20 = r17.toLowerCase(r19);
        Intrinsics.checkNotNullExpressionValue(r20, "this as java.lang.String).toLowerCase(locale)");
        String r21 = StringsKt.trim(r20).toString();
        if (r21.length() <= 0) goto L22;
        boolean r22 = true;
    L23:
        if (r22 == false) goto L18;
        putIfAbsentCompat(r7, r21, r18);
        goto L18
    L22:
        r22 = false;
        goto L23
    }

    private final <K, V> void putIfAbsentCompat(Map<K, V> r1, K r2, V r3) {
        if (r1.containsKey(r2) == true) goto L6;
        r1.put(r2, r3);
        return;
    }
}
