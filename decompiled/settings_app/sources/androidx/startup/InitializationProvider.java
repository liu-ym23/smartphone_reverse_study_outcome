package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    public void androidx_startup_InitializationProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        androidx_startup_InitializationProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    public InitializationProvider() {
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r1 = getContext();
        if (r1 == null) goto L11;
        if (r1.getApplicationContext() == null) goto L7;
        AppInitializer.getInstance(r1).discoverAndInitialize();
        return true;
    L7:
        StartupLogger.w("Deferring initialization because `applicationContext` is null.");
        return true;
    L11:
        throw new StartupException("Context cannot be null");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r1) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r1, ContentValues r2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r1, String r2, String[] r3) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new IllegalStateException("Not allowed.");
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void androidx_startup_InitializationProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(InitializationProvider r2) {
        String r0 = r2.getClass().getName();
        r2.androidx_startup_InitializationProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
