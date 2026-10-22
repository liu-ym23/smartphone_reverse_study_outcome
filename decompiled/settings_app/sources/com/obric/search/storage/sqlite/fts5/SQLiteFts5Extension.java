package com.obric.search.storage.sqlite.fts5;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import coil.util.Utils;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.android.settingslib.SliceBroadcastRelay;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.search.common.log.RuntimeLogger;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SQLiteFts5Extension.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0086 J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0082 J!\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0082 J*\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c0\u001cH\u0082 ¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J \u0010#\u001a\u00020\u00102\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/search/storage/sqlite/fts5/SQLiteFts5Extension;", "", "()V", "TAG", "", "isInitDone", "", "getOTokenizerResult", "", "Lkotlin/Triple;", "", "type", "input", "getSynonyms", UserDictionaryAddWordContents.EXTRA_WORD, "init", "", "nativeGetSynonyms", "nativeSetSynonymFd", SlardarSettingsConsts.PERF_KEY_FD, "Ljava/io/FileDescriptor;", "start", "", "length", "nativeSetTokenizerSamePinyinExcludedMap", "keys", "", PowerUsageDetail.EXTRA_DETAIL_VALUES, "", "([I[[Ljava/lang/String;)V", "setSynonymAsset", "context", "Landroid/content/Context;", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "setTokenizerSamePinyinConfig", "excludedMap", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteFts5Extension {
    public static final SQLiteFts5Extension INSTANCE = null;
    public static final String TAG = "SQLiteFts5Extension";
    private static volatile boolean isInitDone;

    private final native List<String> nativeGetSynonyms(String r1);

    private final native void nativeSetSynonymFd(FileDescriptor r1, long r2, long r4);

    private final native void nativeSetTokenizerSamePinyinExcludedMap(int[] r1, String[][] r2);

    public final native List<Triple<String, Integer, Integer>> getOTokenizerResult(int r1, String r2);

    private SQLiteFts5Extension() {
    }

    static {
        SQLiteFts5Extension r0 = new SQLiteFts5Extension();
        INSTANCE = r0;
        r0.init();
    }

    public final synchronized void init() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isInitDone == true) goto L6;
        SQLiteGlobal.loadLib();     // Catch: Throwable -> L8
        System.loadLibrary(TAG);     // Catch: Throwable -> L8
        isInitDone = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final void setSynonymAsset(Context r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, SliceBroadcastRelay.EXTRA_URI);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L47
        SQLiteFts5Extension r1 = this;     // Catch: Throwable -> L47
        String r2 = r12.getScheme();     // Catch: Throwable -> L47
        Unit r3 = null;
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullExpressionValue(r2, "scheme");     // Catch: Throwable -> L47
        String r4 = r2.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).toLowerCase(Locale.ROOT)");     // Catch: Throwable -> L47
    L10:
        if (Intrinsics.areEqual(r4, "file") == false) goto L32;
        String r5 = r12.getHost();     // Catch: Throwable -> L47
        if (r5 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r5, WifiAuthorizeUtils.AUTO_LOGIN_HOST);     // Catch: Throwable -> L47
        String r6 = r5.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(Locale.ROOT)");     // Catch: Throwable -> L47
    L16:
        if (Intrinsics.areEqual(r6, Utils.ASSET_FILE_PATH_ROOT) == false) goto L32;
        String r13 = r12.getPath();     // Catch: Throwable -> L47
        if (r13 != null) goto L20;
        r13 = "";
    L20:
        Intrinsics.checkNotNullExpressionValue(r13, "uri.path ?: \"\"");     // Catch: Throwable -> L47
        if (StringsKt.startsWith$default(r13, LibrarianImpl.Constants.SEPARATOR, false, 2, null) == false) goto L23;
        r13 = r13.substring(1);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L47
    L23:
        AssetFileDescriptor r14 = r11.getAssets().openFd(r13);     // Catch: Throwable -> L47
        AssetFileDescriptor r15 = r14;     // Catch: Throwable -> L27
        FileDescriptor r7 = r15.getFileDescriptor();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r7, "it.fileDescriptor");     // Catch: Throwable -> L27
        nativeSetSynonymFd(r7, r15.getStartOffset(), r15.getLength());     // Catch: Throwable -> L27
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L47
    L44:
        Object r16 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r17 = Result.m1511exceptionOrNullimpl(r16);
        if (r17 == null) goto L63;
        RuntimeLogger.INSTANCE.error(TAG, "setSynonymAsset error! " + r17.getMessage());
        return;
    L63:
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L14:
        r6 = null;
    L32:
        AssetFileDescriptor r18 = r11.getContentResolver().openAssetFileDescriptor(r12, "r");     // Catch: Throwable -> L47
        if (r18 == null) goto L43;
        AssetFileDescriptor r19 = r18;     // Catch: Throwable -> L47
        AssetFileDescriptor r8 = r19;     // Catch: Throwable -> L38
        FileDescriptor r9 = r8.getFileDescriptor();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r9, "it.fileDescriptor");     // Catch: Throwable -> L38
        nativeSetSynonymFd(r9, r8.getStartOffset(), r8.getLength());     // Catch: Throwable -> L38
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r19, null);     // Catch: Throwable -> L47
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L47
        goto L43
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L43:
        if (r3 != null) goto L44;
        throw new FileNotFoundException(r12 + " not found");     // Catch: Throwable -> L47
    L7:
        r4 = null;
    L47:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r16 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    public final List<String> getSynonyms(String r2) {
        Intrinsics.checkNotNullParameter(r2, UserDictionaryAddWordContents.EXTRA_WORD);
        if (StringsKt.isBlank(r2) == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return nativeGetSynonyms(r2);
    }

    public final void setTokenizerSamePinyinConfig(Map<Integer, ? extends List<String>> r8) {
        Intrinsics.checkNotNullParameter(r8, "excludedMap");
        int[] r0 = CollectionsKt.toIntArray(r8.keySet());
        int r1 = r0.length;
        String[][] r2 = new String[r1][];
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r2[r4] = new String[0];
        r4 = r4 + 1;
        goto L3
    L5:
        int r3 = r0.length;
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L12;
        List<String> r6 = r8.get(Integer.valueOf(r0[r5]));
        if (r6 == null) goto L11;
        Object[] r7 = r6.toArray(new String[0]);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r2[r5] = (String[]) r7;
    L11:
        r5 = r5 + 1;
        goto L6
    L12:
        nativeSetTokenizerSamePinyinExcludedMap(r0, r2);
    }
}
