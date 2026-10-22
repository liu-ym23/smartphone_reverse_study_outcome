package com.android.settings.fingerprint;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: SettingsForDoubaoPorvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J3\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016JS\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001cJ=\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/android/settings/fingerprint/SettingsForDoubaoPorvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "authority", "", "method", "arg", "extras", "delete", "", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", PowerUsageDetail.EXTRA_DETAIL_VALUES, "Landroid/content/ContentValues;", "onCreate", "", IndexDatabaseHelper.SavedQueriesColums.QUERY, "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsForDoubaoPorvider extends ContentProvider {
    public static final Companion Companion = null;
    private static final String HAS_AI_FINGERPRINT = "has_ai_fingerprint";
    private static final String TAG = "SettingsForDoubaoPorvider";

    /* JADX INFO: compiled from: SettingsForDoubaoPorvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/settings/fingerprint/SettingsForDoubaoPorvider$Companion;", "", "()V", "HAS_AI_FINGERPRINT", "", "TAG", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_settings_fingerprint_SettingsForDoubaoPorvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_fingerprint_SettingsForDoubaoPorvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, SliceBroadcastRelay.EXTRA_URI);
        return 0;
    }

    public SettingsForDoubaoPorvider() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r3, String r4, String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r3, "authority");
        Intrinsics.checkNotNullParameter(r4, "method");
        Bundle r7 = new Bundle();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        SettingsForDoubaoPorvider r2 = this;     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r4, HAS_AI_FINGERPRINT) == false) goto L8;
        Context r8 = getContext();     // Catch: Throwable -> L12
        if (r8 == null) goto L9;
        FingerprintUtil.Companion r9 = FingerprintUtil.Companion;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L12
        boolean r10 = r9.hasFingerprint(r8);     // Catch: Throwable -> L12
        OLog.i(TAG, "hasFingerprint = " + r10);     // Catch: Throwable -> L12
        r7.putBoolean(HAS_AI_FINGERPRINT, r10);     // Catch: Throwable -> L12
        goto L8
    L9:
        Unit r11 = null;
    L10:
        Object r12 = Result.m1508constructorimpl(r11);     // Catch: Throwable -> L12
    L14:
        Throwable r13 = Result.m1511exceptionOrNullimpl(r12);
        if (r13 == null) goto L17;
        OLog.e(TAG, "call error: " + r13.getMessage());
    L17:
        return r7;
    L8:
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_SettingsForDoubaoPorvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SettingsForDoubaoPorvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_SettingsForDoubaoPorvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
