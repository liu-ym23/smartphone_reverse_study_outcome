package com.obric.security.devenvcheck;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.obric.olog.OLog;
import com.obric.security.health.score.HealthModuleIds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WlanCheckResultProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020 H\u0016JO\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010%\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010'J;\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010)¨\u0006+"}, d2 = {"Lcom/obric/security/devenvcheck/WlanCheckResultProvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "enforceSelfCaller", "", "enforceSystemCaller", "getType", "handleAddTrusted", "ctx", "Landroid/content/Context;", "handleQuery", "handleRemoveTrusted", "handleRemoveTrustedBySsid", "handleSave", "insert", "values", "Landroid/content/ContentValues;", "isSystemApp", "", "uid", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", HealthModuleIds.UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanCheckResultProvider extends ContentProvider {
    public static final String AUTHORITY = "com.obric.security.wlan.provider";
    private static final Uri CALL_URI = null;
    public static final Companion Companion = null;
    private static final String KEY_INDEX = "wifi_keys";
    private static final int MAX_RECORDS = 4;
    public static final String METHOD_ADD_TRUSTED = "add_trusted";
    public static final String METHOD_QUERY_WIFI_SAFETY = "query_wifi_safety";
    public static final String METHOD_REMOVE_TRUSTED = "remove_trusted";
    public static final String METHOD_REMOVE_TRUSTED_BY_SSID = "remove_trusted_by_ssid";
    public static final String METHOD_SAVE_WIFI_RESULT = "save_wifi_result";
    public static final String PARAM_BSSID = "bssid";
    public static final String PARAM_IS_SAFE = "is_safe";
    public static final String PARAM_RISKS = "risks";
    public static final String PARAM_SSID = "ssid";
    public static final String PARAM_TRUSTED_KEY = "trusted_key";
    private static final String PERMISSION_ACCESS = "com.obric.security.CALL_SECURE_PROVIDER";
    private static final String PREFIX_IS_SAFE = "is_safe::";
    private static final String PREFIX_RISKS = "risks::";
    private static final String PREFIX_TIMESTAMP = "ts::";
    public static final String RESULT_IS_SAFE = "is_safe";
    private static final String SP_NAME = "wlan_security_check_result";
    private static final String TAG = "WlanWifiCheck";

    /* JADX INFO: compiled from: WlanCheckResultProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0004H\u0002J4\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002J6\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/security/devenvcheck/WlanCheckResultProvider$Companion;", "", "()V", "AUTHORITY", "", "CALL_URI", "Landroid/net/Uri;", "KEY_INDEX", "MAX_RECORDS", "", "METHOD_ADD_TRUSTED", "METHOD_QUERY_WIFI_SAFETY", "METHOD_REMOVE_TRUSTED", "METHOD_REMOVE_TRUSTED_BY_SSID", "METHOD_SAVE_WIFI_RESULT", "PARAM_BSSID", "PARAM_IS_SAFE", "PARAM_RISKS", "PARAM_SSID", "PARAM_TRUSTED_KEY", "PERMISSION_ACCESS", "PREFIX_IS_SAFE", "PREFIX_RISKS", "PREFIX_TIMESTAMP", "RESULT_IS_SAFE", "SP_NAME", "TAG", "clearResult", "", "context", "Landroid/content/Context;", "removeResult", "ssid", "bssid", "removeResultBySsid", "saveResult", "isSafe", "", "risks", "", "wifiKey", "writeResult", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ void access$removeResultBySsid(Companion r0, Context r1, String r2) {
            r0.removeResultBySsid(r1, r2);
        }

        public static final /* synthetic */ String access$wifiKey(Companion r0, String r1, String r2) {
            return r0.wifiKey(r1, r2);
        }

        public static final /* synthetic */ void access$writeResult(Companion r0, Context r1, boolean r2, String r3, String r4, List r5) {
            r0.writeResult(r1, r2, r3, r4, r5);
        }

        private final String wifiKey(String r1, String r2) {
            return r2 + "|" + r1;
        }

        public final void saveResult(Context r5, boolean r6, String r7, String r8, List<String> r9) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r7, "ssid");
            Intrinsics.checkNotNullParameter(r8, "bssid");
            Intrinsics.checkNotNullParameter(r9, "risks");
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
            Companion r4 = this;     // Catch: Throwable -> L5
            Bundle r10 = new Bundle();     // Catch: Throwable -> L5
            r10.putString("ssid", r7);     // Catch: Throwable -> L5
            r10.putString("bssid", r8);     // Catch: Throwable -> L5
            r10.putBoolean("is_safe", r6);     // Catch: Throwable -> L5
            r10.putStringArrayList("risks", new ArrayList(r9));     // Catch: Throwable -> L5
            Object r11 = Result.m774constructorimpl(r5.getContentResolver().call(WlanCheckResultProvider.access$getCALL_URI$cp(), WlanCheckResultProvider.METHOD_SAVE_WIFI_RESULT, null, r10));     // Catch: Throwable -> L5
        L7:
            Throwable r12 = Result.m777exceptionOrNullimpl(r11);
            if (r12 == null) goto L13;
            OLog.w("WlanWifiCheck", "saveResult: call failed, key=" + WlanCheckResultProvider.Companion.wifiKey(r7, r8), r12);
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r11 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        private final void writeResult(Context r17, boolean r18, String r19, String r20, List<String> r21) {
            final SharedPreferences r2 = r17.getSharedPreferences(WlanCheckResultProvider.SP_NAME, 0);
            String r0 = wifiKey(r19, r20);
            Set<String> r3 = r2.getStringSet(WlanCheckResultProvider.KEY_INDEX, SetsKt.emptySet());
            if (r3 != null) goto L5;
            r3 = SetsKt.emptySet();
        L5:
            Set<String> r4 = CollectionsKt.toMutableSet(r3);
            SharedPreferences.Editor r5 = r2.edit().putBoolean(WlanCheckResultProvider.PREFIX_IS_SAFE + r0, r18).putLong(WlanCheckResultProvider.PREFIX_TIMESTAMP + r0, System.currentTimeMillis()).putStringSet(WlanCheckResultProvider.PREFIX_RISKS + r0, CollectionsKt.toSet(r21));
            r4.add(r0);
            if (r4.size() <= 4) goto L18;
            final long r12 = System.currentTimeMillis();
            ArrayList r14 = new ArrayList();
            Iterator<T> r6 = r4.iterator();
        L9:
            if (r6.hasNext() == false) goto L14;
            Object r15 = r6.next();
            if ((!Intrinsics.areEqual((String) r15, r0)) == false) goto L9;
            r14.add(r15);
            goto L9
        L14:
            Iterator r7 = CollectionsKt.take(CollectionsKt.sortedWith(r14, new WlanCheckResultProvider$Companion$writeResult$$inlined$sortedBy$1(r2, r12)), r4.size() - 4).iterator();
        L16:
            if (r7.hasNext() == false) goto L18;
            String r8 = (String) r7.next();
            r5.remove(WlanCheckResultProvider.PREFIX_IS_SAFE + r8).remove(WlanCheckResultProvider.PREFIX_TIMESTAMP + r8).remove(WlanCheckResultProvider.PREFIX_RISKS + r8);
            r4.remove(r8);
            OLog.d("WlanWifiCheck", "writeResult: evict oldest record, key=" + r8);
        L18:
            r5.putStringSet(WlanCheckResultProvider.KEY_INDEX, r4).apply();
            OLog.d("WlanWifiCheck", "writeResult: saved key=" + r0 + ", isSafe=" + r18 + ", total=" + r4.size());
        }

        public final void removeResult(Context r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "ssid");
            Intrinsics.checkNotNullParameter(r6, "bssid");
            SharedPreferences r7 = r4.getSharedPreferences(WlanCheckResultProvider.SP_NAME, 0);
            String r3 = wifiKey(r5, r6);
            Set<String> r8 = r7.getStringSet(WlanCheckResultProvider.KEY_INDEX, SetsKt.emptySet());
            if (r8 != null) goto L5;
            r8 = SetsKt.emptySet();
        L5:
            Set<String> r9 = CollectionsKt.toMutableSet(r8);
            if (r9.remove(r3) == true) goto L9;
            OLog.d("WlanWifiCheck", "removeResult: key not found, key=" + r3);
            return;
        L9:
            r7.edit().remove(WlanCheckResultProvider.PREFIX_IS_SAFE + r3).remove(WlanCheckResultProvider.PREFIX_TIMESTAMP + r3).remove(WlanCheckResultProvider.PREFIX_RISKS + r3).putStringSet(WlanCheckResultProvider.KEY_INDEX, r9).apply();
            OLog.d("WlanWifiCheck", "removeResult: removed key=" + r3 + ", remain=" + r9.size());
        }

        private final void removeResultBySsid(Context r8, String r9) {
            SharedPreferences r7 = r8.getSharedPreferences(WlanCheckResultProvider.SP_NAME, 0);
            Set<String> r10 = r7.getStringSet(WlanCheckResultProvider.KEY_INDEX, SetsKt.emptySet());
            if (r10 != null) goto L5;
            r10 = SetsKt.emptySet();
        L5:
            Set<String> r11 = CollectionsKt.toMutableSet(r10);
            ArrayList r2 = new ArrayList();
            Iterator<T> r1 = r11.iterator();
        L7:
            if (r1.hasNext() == false) goto L11;
            Object r3 = r1.next();
            String r4 = (String) r3;
            Intrinsics.checkNotNullExpressionValue(r4, "it");
            if (Intrinsics.areEqual(StringsKt.substringAfter(r4, '|', r4), r9) == false) goto L7;
            r2.add(r3);
            goto L7
        L11:
            ArrayList r5 = r2;
            if (r5.isEmpty() == false) goto L15;
            OLog.d("WlanWifiCheck", "removeResultBySsid: no record");
            return;
        L15:
            SharedPreferences.Editor r12 = r7.edit();
            Iterator r13 = r5.iterator();
        L17:
            if (r13.hasNext() == false) goto L19;
            String r6 = (String) r13.next();
            r12.remove(WlanCheckResultProvider.PREFIX_IS_SAFE + r6).remove(WlanCheckResultProvider.PREFIX_TIMESTAMP + r6).remove(WlanCheckResultProvider.PREFIX_RISKS + r6);
            r11.remove(r6);
            goto L17
        L19:
            r12.putStringSet(WlanCheckResultProvider.KEY_INDEX, r11).apply();
            OLog.d("WlanWifiCheck", "removeResultBySsid: removed " + r5.size() + " record(s), remain=" + r11.size());
        }

        public final void clearResult(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            r2.getSharedPreferences(WlanCheckResultProvider.SP_NAME, 0).edit().clear().apply();
            OLog.d("WlanWifiCheck", "clearResult: all records cleared");
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public WlanCheckResultProvider() {
    }

    public static final /* synthetic */ Uri access$getCALL_URI$cp() {
        return CALL_URI;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r6, String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "method");
        Context r9 = getContext();
        if (r9 != null) goto L6;
        OLog.w("WlanWifiCheck", "call: context is null, method=" + r6);
        return null;
    L6:
        Intrinsics.checkNotNullExpressionValue(r9, "context ?: run {\n       …    return null\n        }");
        OLog.d("WlanWifiCheck", "call: method=" + r6 + ", callingUid=" + Binder.getCallingUid());
        switch(r6.hashCode()) {
            case -736704955: goto L22;
            case -349310916: goto L19;
            case -229723963: goto L16;
            case -152737440: goto L13;
            case 270861145: goto L10;
            default: goto L24;
        };
    L24:
        OLog.w("WlanWifiCheck", "call: unknown method=" + r6);
        return null;
    L10:
        if (r6.equals(METHOD_ADD_TRUSTED) == false) goto L24;
        enforceSelfCaller();
        return handleAddTrusted(r9, r8);
    L13:
        if (r6.equals(METHOD_REMOVE_TRUSTED_BY_SSID) == false) goto L24;
        enforceSelfCaller();
        return handleRemoveTrustedBySsid(r9, r8);
    L16:
        if (r6.equals(METHOD_SAVE_WIFI_RESULT) == false) goto L24;
        enforceSelfCaller();
        return handleSave(r9, r8);
    L19:
        if (r6.equals(METHOD_REMOVE_TRUSTED) == false) goto L24;
        enforceSelfCaller();
        return handleRemoveTrusted(r9, r8);
    L22:
        if (r6.equals(METHOD_QUERY_WIFI_SAFETY) == false) goto L24;
        enforceSystemCaller();
        return handleQuery(r9, r8);
    }

    private final Bundle handleQuery(Context r7, Bundle r8) {
        String r6 = null;
        if (r8 == null) goto L5;
        String r0 = r8.getString("ssid");
    L6:
        String r1 = "";
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        if (r8 == null) goto L11;
        r6 = r8.getString("bssid");
    L11:
        if (r6 == null) goto L14;
        r1 = r6;
    L14:
        boolean r3 = true;
        if (StringsKt.isBlank(r0) == false) goto L17;
    L31:
        OLog.w("WlanWifiCheck", "handleQuery: blank ssid/bssid, return safe by default");
        Bundle r9 = new Bundle();
        r9.putBoolean("is_safe", true);
        return r9;
    L17:
        if (StringsKt.isBlank(r1) == true) goto L31;
        SharedPreferences r10 = r7.getSharedPreferences(SP_NAME, 0);
        String r2 = Companion.access$wifiKey(Companion, r0, r1);
        if (WlanTrustStore.INSTANCE.isTrusted(r7, r2) == false) goto L23;
        OLog.d("WlanWifiCheck", "handleQuery: key=" + r2 + " trusted, return safe");
        Bundle r11 = new Bundle();
        r11.putBoolean("is_safe", true);
        return r11;
    L23:
        Set<String> r12 = r10.getStringSet(KEY_INDEX, SetsKt.emptySet());
        if (r12 != null) goto L26;
        r12 = SetsKt.emptySet();
    L26:
        boolean r13 = r12.contains(r2);
        if (r13 == false) goto L29;
        r3 = r10.getBoolean(PREFIX_IS_SAFE + r2, true);
    L29:
        OLog.d("WlanWifiCheck", "handleQuery: key=" + r2 + ", hit=" + r13 + ", isSafe=" + r3);
        Bundle r14 = new Bundle();
        r14.putBoolean("is_safe", r3);
        return r14;
    L5:
        r0 = null;
        goto L6
    }

    private final Bundle handleSave(Context r9, Bundle r10) {
        if (r10 == null) goto L5;
        String r0 = r10.getString("ssid");
    L7:
        if (r0 != null) goto L9;
        String r5 = "";
    L10:
        if (r10 == null) goto L12;
        String r1 = r10.getString("bssid");
    L13:
        if (r1 != null) goto L15;
        String r6 = "";
    L17:
        if (StringsKt.isBlank(r5) == false) goto L19;
    L31:
        OLog.w("WlanWifiCheck", "handleSave: blank ssid/bssid, skip");
        return null;
    L19:
        if (StringsKt.isBlank(r6) == true) goto L31;
        boolean r2 = true;
        if (r10 == null) goto L24;
        r2 = r10.getBoolean("is_safe", true);
    L24:
        boolean r4 = r2;
        if (r10 == null) goto L28;
        ArrayList<String> r11 = r10.getStringArrayList("risks");
        if (r11 == null) goto L28;
    L29:
        Companion r3 = Companion;
        OLog.d("WlanWifiCheck", "handleSave: key=" + Companion.access$wifiKey(r3, r5, r6) + ", isSafe=" + r4 + ", risks=" + r11);
        Companion.access$writeResult(r3, r9, r4, r5, r6, r11);
        return null;
    L28:
        r11 = new ArrayList();
        goto L29
    L15:
        r6 = r1;
        goto L17
    L12:
        r1 = null;
        goto L13
    L9:
        r5 = r0;
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    private final Bundle handleAddTrusted(Context r4, Bundle r5) {
        if (r5 == null) goto L5;
        String r6 = r5.getString(PARAM_TRUSTED_KEY);
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (StringsKt.isBlank(r6) == false) goto L12;
        OLog.w("WlanWifiCheck", "handleAddTrusted: blank key, skip");
        return null;
    L12:
        OLog.d("WlanWifiCheck", "handleAddTrusted: key=" + r6);
        WlanTrustStore.INSTANCE.writeTrusted(r4, r6);
        return null;
    L5:
        r6 = null;
        goto L6
    }

    private final Bundle handleRemoveTrusted(Context r4, Bundle r5) {
        if (r5 == null) goto L5;
        String r6 = r5.getString(PARAM_TRUSTED_KEY);
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (StringsKt.isBlank(r6) == false) goto L12;
        OLog.w("WlanWifiCheck", "handleRemoveTrusted: blank key, skip");
        return null;
    L12:
        OLog.d("WlanWifiCheck", "handleRemoveTrusted: key=" + r6);
        WlanTrustStore.INSTANCE.writeRemoveTrusted(r4, r6);
        return null;
    L5:
        r6 = null;
        goto L6
    }

    private final Bundle handleRemoveTrustedBySsid(Context r4, Bundle r5) {
        if (r5 == null) goto L5;
        String r6 = r5.getString("ssid");
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (StringsKt.isBlank(r6) == false) goto L12;
        OLog.w("WlanWifiCheck", "handleRemoveTrustedBySsid: blank ssid, skip");
        return null;
    L12:
        OLog.d("WlanWifiCheck", "handleRemoveTrustedBySsid: ssid=" + r6);
        WlanTrustStore.INSTANCE.writeRemoveTrustedBySsid(r4, r6);
        Companion.access$removeResultBySsid(Companion, r4, r6);
        return null;
    L5:
        r6 = null;
        goto L6
    }

    private final void enforceSystemCaller() {
        Context r0 = getContext();
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullExpressionValue(r0, "context ?: throw Securit…\"WLAN check: no context\")");
        if (r0.checkCallingPermission(PERMISSION_ACCESS) != 0) goto L14;
        int r1 = Binder.getCallingUid();
        if (r1 >= 10000) goto L9;
        return;
    L9:
        if (isSystemApp(r0, r1) == true) goto L18;
        OLog.w("WlanWifiCheck", "enforceSystemCaller: caller is not a system app, uid=" + r1);
        throw new SecurityException("WLAN check: caller is not a system app");
    L18:
        return;
    L14:
        OLog.w("WlanWifiCheck", "enforceSystemCaller: permission denied, uid=" + Binder.getCallingUid());
        throw new SecurityException("WLAN check: permission denied");
    L17:
        throw new SecurityException("WLAN check: no context");
    }

    private final void enforceSelfCaller() {
        int r3 = Binder.getCallingUid();
        if (r3 != Process.myUid()) goto L5;
        return;
    L5:
        OLog.w("WlanWifiCheck", "enforceSelfCaller: reject save, callingUid=" + r3 + ", myUid=" + Process.myUid());
        throw new SecurityException("WLAN check: save only allowed from self process");
    }

    private final boolean isSystemApp(Context r8, int r9) {
        String[] r10 = r8.getPackageManager().getPackagesForUid(r9);
        if (r10 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullExpressionValue(r10, "ctx.packageManager.getPa…rUid(uid) ?: return false");
        int r1 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L28;
        String r3 = r10[r2];
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        WlanCheckResultProvider r6 = this;     // Catch: Throwable -> L14
        ApplicationInfo r4 = r8.getPackageManager().getApplicationInfo(r3, 0);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r4, "ctx.packageManager.getApplicationInfo(pkg, 0)");     // Catch: Throwable -> L14
        if ((r4.flags & 129) == 0) goto L11;
        boolean r7 = true;
    L12:
        Object r11 = Result.m774constructorimpl(Boolean.valueOf(r7));     // Catch: Throwable -> L14
    L17:
        if (Result.m780isFailureimpl(r11) == false) goto L20;
        r11 = false;
    L20:
        if (((Boolean) r11).booleanValue() == true) goto L23;
        r2 = r2 + 1;
        goto L6
    L23:
        return true;
    L11:
        r7 = false;
    L14:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L17
    L28:
        return false;
    }

    static {
        Companion = new Companion(null);
        Uri r0 = Uri.parse("content://com.obric.security.wlan.provider");
        Intrinsics.checkNotNullExpressionValue(r0, "Uri.parse(\"content://$AUTHORITY\")");
        CALL_URI = r0;
    }
}
