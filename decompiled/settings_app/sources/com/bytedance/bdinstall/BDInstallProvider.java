package com.bytedance.bdinstall;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes3.dex */
public class BDInstallProvider extends ContentProvider {
    private static final int MATCH_DATA = 65536;
    private static Uri sBaseUri;
    private static Context sContext;
    private static UriMatcher sMatcher;
    private static String sShareAuthority;

    public void com_bytedance_bdinstall_BDInstallProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_bytedance_bdinstall_BDInstallProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public BDInstallProvider() {
        Utils.setIsMainProcess(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        sContext = r2;
        if (r3 == null) goto L5;
        sShareAuthority = r3.authority;
    L5:
        Utils.setIsMainProcess(true);
        super.attachInfo(r2, r3);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (sMatcher == null) goto L17;
    L15:
        BDInstall.registerLifeCycleListener((Application) Utils.getApp(getContext()));     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        th.printStackTrace();
        return true;
    L17:
        init(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    private static void init(Context r3) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r3, BDInstallProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L10;
        UriMatcher r4 = new UriMatcher(-1);
        sMatcher = r4;
        r4.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    private static String getProviderAuthority(Context r5, String r6) {
        if (r5 != null) goto L18;
        return null;
    L18:
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return r5.getPackageName() + ".bdinstall.provider";
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L17;
        ProviderInfo[] r0 = r5.getPackageManager().getPackageInfo(r5.getPackageName(), 8).providers;     // Catch: Exception -> L14
        int r1 = r0.length;     // Catch: Exception -> L14
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L14
        if (r6.equals(r3.name) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return r3.authority;
    }

    static synchronized Uri getContentUri(Context r2, String r3) {
        monitor-enter(BDInstallProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (sBaseUri == null) goto L20;
    L13:
        Uri r4 = sBaseUri.buildUpon().appendPath(r3).build();     // Catch: Throwable -> L16
        monitor-exit(BDInstallProvider.class);
        return r4;
    L20:
        init(r2);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    }

    static Context getFallbackContext() {
        return sContext;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_bytedance_bdinstall_BDInstallProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(BDInstallProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_bytedance_bdinstall_BDInstallProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
