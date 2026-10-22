package com.obric.baseservice.location;

import android.content.Context;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GbtCodeDict.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/baseservice/location/GbtCodeDict;", "", "()V", "ASSET_PATH", "", "NAME_SUFFIXES", "", "TAG", "codeToName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "initialized", "", "nameToCode", "context", "Landroid/content/Context;", AlogMonitor.ALOG_RESULT_CODE, "ensureInit", "", "name", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GbtCodeDict {
    private static final String ASSET_PATH = "gb_t_2260_provinces_cities.csv";
    public static final GbtCodeDict INSTANCE = null;
    private static final List<String> NAME_SUFFIXES = null;
    private static final String TAG = "GbtCodeDict";
    private static final HashMap<String, String> codeToName = null;
    private static volatile boolean initialized;
    private static final HashMap<String, String> nameToCode = null;

    static {
        INSTANCE = new GbtCodeDict();
        NAME_SUFFIXES = CollectionsKt.listOf(new String[]{"市", "省", "区", "县", "自治区", "地区", "特别行政区"});
        nameToCode = new HashMap(800);
        codeToName = new HashMap(800);
    }

    private GbtCodeDict() {
    }

    public final synchronized void ensureInit(Context r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r14, "context");     // Catch: Throwable -> L58
        if (initialized == false) goto L61;
        monitor-exit(this);
        return;
    L61:
        Context r15 = r14.getApplicationContext();     // Catch: Throwable -> L53
        Intrinsics.checkNotNullExpressionValue(r15, "context.applicationContext");     // Catch: Throwable -> L53
        InputStream r16 = r15.getAssets().open(ASSET_PATH);     // Catch: Throwable -> L53
        Intrinsics.checkNotNullExpressionValue(r16, "context.applicationContext.assets.open(ASSET_PATH)");     // Catch: Throwable -> L53
        Reader r2 = new InputStreamReader(r16, Charsets.UTF_8);     // Catch: Throwable -> L53
        if ((r2 instanceof BufferedReader) == false) goto L11;
        BufferedReader r3 = (BufferedReader) r2;     // Catch: Throwable -> L53
    L12:
        BufferedReader r4 = r3;     // Catch: Throwable -> L53
        if ((r4 instanceof BufferedReader) == false) goto L15;
        BufferedReader r5 = r4;     // Catch: Throwable -> L53
    L16:
        BufferedReader r6 = r5;     // Catch: Throwable -> L53
        Iterator<String> r17 = TextStreamsKt.lineSequence(r6).iterator();     // Catch: Throwable -> L48
        boolean r1 = true;
    L19:
        if (r17.hasNext() == false) goto L45;
        String r7 = StringsKt.trim(r17.next()).toString();     // Catch: Throwable -> L48
        boolean r8 = false;
        if (r7.length() != 0) goto L23;
        boolean r9 = true;
    L24:
        if (r9 == true) goto L19;
        if (r1 == false) goto L30;
        if (StringsKt.startsWith$default(r7, AlogMonitor.ALOG_RESULT_CODE, false, 2, null) == true) goto L29;
        r1 = false;
        goto L30
    L29:
        r1 = false;
    L30:
        int r10 = StringsKt.indexOf$default(r7, ',', 0, false, 6, null);     // Catch: Throwable -> L48
        if (r10 <= 0) goto L19;
        if (r10 == (r7.length() - 1)) goto L19;
        String r11 = r7.substring(0, r10);     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Throwable -> L48
        String r12 = StringsKt.trim(r11).toString();     // Catch: Throwable -> L48
        String r13 = r7.substring(r10 + 1);     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L48
        String r18 = StringsKt.trim(r13).toString();     // Catch: Throwable -> L48
        if (r12.length() <= 0) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == false) goto L19;
        if (r18.length() <= 0) goto L43;
        r8 = true;
    L43:
        if (r8 == false) goto L19;
        nameToCode.put(r18, r12);     // Catch: Throwable -> L48
        codeToName.putIfAbsent(r12, r18);     // Catch: Throwable -> L48
        goto L19
    L38:
        r19 = false;
        goto L39
    L23:
        r9 = false;
        goto L24
    L45:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L53
        OLog.d(TAG, "init done, nameToCode=" + nameToCode.size() + ", codeToName=" + codeToName.size());     // Catch: Throwable -> L53
    L55:
        initialized = true;     // Catch: Throwable -> L58
        monitor-exit(this);
        return;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L15:
        r5 = new BufferedReader(r4, 8192);     // Catch: Throwable -> L53
        goto L16
    L11:
        r3 = new BufferedReader(r2, 8192);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        OLog.e(TAG, "init failed", th);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    }

    public final String nameToCode(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7;
        if (r8 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        ensureInit(r6);
        String r5 = StringsKt.trim(r8).toString();
        String r9 = nameToCode.get(r5);
        if (r9 == null) goto L16;
        OLog.d(TAG, "nameToCode direct hit, name=" + r5 + ", code=" + r9);
        return r9;
    L16:
        Iterator<String> r10 = NAME_SUFFIXES.iterator();
    L18:
        if (r10.hasNext() == false) goto L25;
        String r3 = r10.next();
        if (StringsKt.endsWith$default(r5, r3, false, 2, null) == true) goto L18;
        String r4 = r5 + r3;
        String r11 = nameToCode.get(r4);
        if (r11 == null) goto L18;
        OLog.d(TAG, "nameToCode suffix hit, raw=" + r5 + ", tried=" + r4 + ", code=" + r11);
        return r11;
    L25:
        OLog.e(TAG, "nameToCode miss, name=" + r5);
        return null;
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r1 = false;
        goto L10
    }

    public final String codeToName(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return null;
    L12:
        ensureInit(r2);
        return codeToName.get(StringsKt.trim(r4).toString());
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r0 = false;
        goto L9
    }
}
