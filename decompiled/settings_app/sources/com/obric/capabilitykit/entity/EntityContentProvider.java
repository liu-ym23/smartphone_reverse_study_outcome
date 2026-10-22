package com.obric.capabilitykit.entity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.version.EntityUpdateVersionParams;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016JO\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001cJ;\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContentProvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "callingPackageSafely", "delete", "", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", PowerUsageDetail.EXTRA_DETAIL_VALUES, "Landroid/content/ContentValues;", "onCreate", "", IndexDatabaseHelper.SavedQueriesColums.QUERY, "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityContentProvider extends ContentProvider {
    public static final a a = null;
    public static final String b = "EntityContentProvider";
    public static final String c = "data_check";
    public static final String d = "reindex_all_data";
    public static final String e = "update_entity_version";
    public static final String f = "sync_data_indexed_types";
    public static final long g = 2500;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContentProvider$Companion;", "", "()V", "DATA_CHECK", "", "ON_ENTITY_VERSION_UPDATE", "REINDEX_ALL_DATA", "SYNC_DATA_INDEXED_TYPES", "TAG", "WAIT_ENTITY_PROVIDER_INIT_TIME_MS", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        a = new a(null);
    }

    public EntityContentProvider() {
    }

    private final String a() {
        return getCallingPackage();
    L4:
        e = move-exception;
        Logger r1 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        Context r4 = getContext();
        if (r4 == null) goto L8;
        String r5 = r4.getPackageName();
    L9:
        r1.w(b, r2.append(r5).append(" run method, callingPackage failed").toString(), e);
        return null;
    L8:
        r5 = null;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r16, String r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r16, "method");
        Bundle r3 = new Bundle();
        String r4 = a();
        Logger r5 = Logger.INSTANCE;
        StringBuilder r6 = new StringBuilder();
        Context r7 = getContext();
        String r8 = null;
        if (r7 == null) goto L5;
        String r9 = r7.getPackageName();
    L6:
        r5.d(b, r6.append(r9).append(" run method: ").append(r16).append(" from pkg: ").append(r4).append(", call:").toString());
        if (PackageUtils.INSTANCE.checkSignature(r4) == true) goto L10;
        r5.i(b, "signatures not match");
        r3.putBoolean(EntityUpdateVersionParams.RESULT_KEY, false);
        return r3;
    L10:
        long r11 = Binder.clearCallingIdentity();
        EntityProvider r10 = EntityProvider.INSTANCE;     // Catch: Throwable -> L56
        r10.waitEntityProviderInit(2500);     // Catch: Throwable -> L56
        if (r10.isInitialized() == false) goto L50;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L56
        Context r14 = getContext();     // Catch: Throwable -> L56
        if (r14 == null) goto L16;
        String r15 = r14.getPackageName();     // Catch: Throwable -> L56
    L17:
        r5.d(b, r13.append(r15).append(" run method: ").append(r16).append(", start:").toString());     // Catch: Throwable -> L56
        int r19 = r16.hashCode();     // Catch: Throwable -> L56
        if (r19 == (-1184655032)) goto L42;
        if (r19 == 1555726002) goto L36;
        if (r19 == 1604538419) goto L25;
    L58:
        Binder.restoreCallingIdentity(r11);
        Logger r0 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder();
        Context r12 = getContext();
        if (r12 == null) goto L61;
        r8 = r12.getPackageName();
    L61:
        r0.d(b, r2.append(r8).append(" run method: ").append(r16).append(" pkg: ").append(a()).append(" END.").toString());
        return r3;
    L25:
        if (r16.equals(c) == false) goto L58;
        if (r18 == null) goto L33;
        ArrayList<Integer> r1 = r18.getIntegerArrayList(f);     // Catch: Throwable -> L56
        if (r1 == null) goto L33;
        List<Integer> r20 = CollectionsKt.toList(r1);     // Catch: Throwable -> L56
        if (r20 == null) goto L33;
    L34:
        r10.syncData(r20);     // Catch: Throwable -> L56
    L33:
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L56
        goto L34
    L36:
        if (r16.equals(e) == false) goto L58;
        if (r10.reDonateCheck$capabilitykit_release(r17) == false) goto L58;
        r3.putBoolean(EntityUpdateVersionParams.RESULT_KEY, true);     // Catch: Throwable -> L56
        goto L58
    L42:
        if (r16.equals(d) == false) goto L58;
        PackageUtils r21 = PackageUtils.INSTANCE;     // Catch: Throwable -> L56
        if (r4 != null) goto L48;
        r4 = "";
    L48:
        if (r21.isMemoryPackageName(r4) == false) goto L58;
        r5.i(b, "run reindex_all_data method start");     // Catch: Throwable -> L56
        r10.reindexEntityData$capabilitykit_release();     // Catch: Throwable -> L56
        r5.i(b, "run reindex_all_data method end");     // Catch: Throwable -> L56
        goto L58
    L16:
        r15 = null;
        goto L17
    L50:
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L56
        Context r23 = getContext();     // Catch: Throwable -> L56
        if (r23 == null) goto L53;
        String r24 = r23.getPackageName();     // Catch: Throwable -> L56
    L54:
        r5.w(b, r22.append(r24).append(" run method: ").append(r16).append(", not initialized").toString());     // Catch: Throwable -> L56
        goto L58
    L53:
        r24 = null;
    L56:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        Logger.INSTANCE.e(b, "error: " + th.getMessage());     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Binder.restoreCallingIdentity(r11);
        throw th;
    L5:
        r9 = null;
        goto L6
    }

    public void com_obric_capabilitykit_entity_EntityContentProvider__onCreate$___twin___() {
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
        com_obric_capabilitykit_entity_EntityContentProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        EntityProvider r0 = EntityProvider.INSTANCE;
        Context r1 = getContext();
        if (r1 == null) goto L5;
        Context r2 = r1.getApplicationContext();
    L6:
        Intrinsics.checkNotNull(r2);
        r0.setSContext(r2);
        EntityContextHolder.INSTANCE.init(r0.getSContext());
        return true;
    L5:
        r2 = null;
        goto L6
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

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_obric_capabilitykit_entity_EntityContentProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(EntityContentProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_obric_capabilitykit_entity_EntityContentProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
