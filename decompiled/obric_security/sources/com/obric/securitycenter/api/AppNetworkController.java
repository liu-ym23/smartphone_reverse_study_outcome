package com.obric.securitycenter.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: AppNetworkController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J \u0010#\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\bH\u0002J\u001a\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\bH\u0002J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0018\u0010.\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J(\u0010/\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR\u001b\u0010\u0016\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0017\u0010\r¨\u00061"}, d2 = {"Lcom/obric/securitycenter/api/AppNetworkController;", "", "()V", "ANDROID_APP_APP_OPS_MANAGER", "", "ANDROID_APP_SMT_OPS_MANAGER", "CTX_SMT", "MODE_ALLOWED_FALLBACK", "", "MODE_IGNORED_FALLBACK", "TAG", "modeAllowed", "getModeAllowed", "()I", "modeAllowed$delegate", "Lkotlin/Lazy;", "modeIgnored", "getModeIgnored", "modeIgnored$delegate", "opNetMobile", "getOpNetMobile", "opNetMobile$delegate", "opNetWifi", "getOpNetWifi", "opNetWifi$delegate", "allowAllNetwork", "", "context", "Landroid/content/Context;", "packageName", "allowMobileData", "allowWlan", "blockAllNetwork", "blockMobileData", "blockWlan", "getMode", "opCode", "getOpIntProperty", "name", "fallback", "isMobileDataAllowed", "isWlanAllowed", "obtainOpsManager", "readStatic", "className", "fieldName", "resolveUid", "setOp", SearchConfigType.KEY_MODE, "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppNetworkController {
    private static final String ANDROID_APP_APP_OPS_MANAGER = "android.app.AppOpsManager";
    private static final String ANDROID_APP_SMT_OPS_MANAGER = "android.app.SmtOpsManager";
    private static final String CTX_SMT = "com.bytedanceos.api.ContextSmt";
    public static final AppNetworkController INSTANCE = null;
    private static final int MODE_ALLOWED_FALLBACK = 0;
    private static final int MODE_IGNORED_FALLBACK = 1;
    private static final String TAG = "AppNetworkController";
    private static final Lazy modeAllowed$delegate = null;
    private static final Lazy modeIgnored$delegate = null;
    private static final Lazy opNetMobile$delegate = null;
    private static final Lazy opNetWifi$delegate = null;

    private AppNetworkController() {
    }

    public static final /* synthetic */ int access$getOpIntProperty(AppNetworkController r0, String r1, int r2) {
        return r0.getOpIntProperty(r1, r2);
    }

    static {
        INSTANCE = new AppNetworkController();
        opNetMobile$delegate = LazyKt.lazy(AppNetworkController$opNetMobile$2.INSTANCE);
        opNetWifi$delegate = LazyKt.lazy(AppNetworkController$opNetWifi$2.INSTANCE);
        modeAllowed$delegate = LazyKt.lazy(AppNetworkController$modeAllowed$2.INSTANCE);
        modeIgnored$delegate = LazyKt.lazy(AppNetworkController$modeIgnored$2.INSTANCE);
    }

    private final int getOpNetMobile() {
        return ((Number) opNetMobile$delegate.getValue()).intValue();
    }

    private final int getOpNetWifi() {
        return ((Number) opNetWifi$delegate.getValue()).intValue();
    }

    private final int getModeAllowed() {
        return ((Number) modeAllowed$delegate.getValue()).intValue();
    }

    private final int getModeIgnored() {
        return ((Number) modeIgnored$delegate.getValue()).intValue();
    }

    @JvmStatic
    public static final boolean blockMobileData(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "packageName");
        AppNetworkController r0 = INSTANCE;
        return r0.setOp(r3, r4, r0.getOpNetMobile(), r0.getModeIgnored());
    }

    @JvmStatic
    public static final boolean allowMobileData(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "packageName");
        AppNetworkController r0 = INSTANCE;
        return r0.setOp(r3, r4, r0.getOpNetMobile(), r0.getModeAllowed());
    }

    @JvmStatic
    public static final boolean blockWlan(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "packageName");
        AppNetworkController r0 = INSTANCE;
        return r0.setOp(r3, r4, r0.getOpNetWifi(), r0.getModeIgnored());
    }

    @JvmStatic
    public static final boolean allowWlan(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "packageName");
        AppNetworkController r0 = INSTANCE;
        return r0.setOp(r3, r4, r0.getOpNetWifi(), r0.getModeAllowed());
    }

    @JvmStatic
    public static final boolean blockAllNetwork(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        boolean r0 = blockMobileData(r1, r2);
        boolean r3 = blockWlan(r1, r2);
        if (r0 == false) goto L6;
        if (r3 == false) goto L6;
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final boolean allowAllNetwork(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        boolean r0 = allowMobileData(r1, r2);
        boolean r3 = allowWlan(r1, r2);
        if (r0 == false) goto L6;
        if (r3 == false) goto L6;
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final boolean isMobileDataAllowed(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        AppNetworkController r0 = INSTANCE;
        if (r0.getMode(r2, r3, r0.getOpNetMobile()) != r0.getModeAllowed()) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isWlanAllowed(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        AppNetworkController r0 = INSTANCE;
        if (r0.getMode(r2, r3, r0.getOpNetWifi()) != r0.getModeAllowed()) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean setOp(Context r12, String r13, int r14, int r15) {
        if (TextUtils.isEmpty(r13) == false) goto L6;
        Log.e(TAG, "setOp skipped, packageName empty");
        return false;
    L6:
        if (r14 >= 0) goto L9;
        Log.e(TAG, "setOp skipped, opCode invalid");
        return false;
    L9:
        int r1 = resolveUid(r12, r13);
        if (r1 >= 0) goto L13;
        Log.e(TAG, "setOp skipped, uid not found, pkg=" + r13);
        return false;
    L13:
        Object r16 = obtainOpsManager(r12);
        if (r16 != null) goto L22;
        Log.e(TAG, "setOp skipped, ops manager null");
        return false;
    L22:
        Method r11 = r16.getClass().getMethod("setMode", new Class[]{Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE});     // Catch: Throwable -> L19
        r11.setAccessible(true);     // Catch: Throwable -> L19
        r11.invoke(r16, new Object[]{Integer.valueOf(r14), Integer.valueOf(r1), r13, Integer.valueOf(r15)});     // Catch: Throwable -> L19
        Log.d(TAG, "setOp ok, pkg=" + r13 + " uid=" + r1 + " op=" + r14 + " mode=" + r15);     // Catch: Throwable -> L19
        return true;
    L19:
        th = move-exception;
        Log.e(TAG, "setOp failed, pkg=" + r13, th);
        return false;
    }

    private final int getMode(Context r10, String r11, int r12) {
        if (TextUtils.isEmpty(r11) == true) goto L35;
        if (r12 < 0) goto L36;
        int r0 = resolveUid(r10, r11);
        if (r0 >= 0) goto L9;
        return -1;
    L9:
        Object r9 = obtainOpsManager(r10);
        if (r9 != null) goto L33;
        return -1;
    L33:
        Method r13 = r9.getClass().getMethod("getOpsForPackage", new Class[]{Integer.TYPE, String.class, int[].class});     // Catch: Throwable -> L30
        r13.setAccessible(true);     // Catch: Throwable -> L30
        Object r14 = r13.invoke(r9, new Object[]{Integer.valueOf(r0), r11, new int[]{r12}});     // Catch: Throwable -> L30
        List r15 = null;
        if ((r14 instanceof List) == false) goto L15;
        List r16 = (List) r14;     // Catch: Throwable -> L30
    L16:
        if (r16 == null) goto L29;
        Object r17 = CollectionsKt.firstOrNull(r16);     // Catch: Throwable -> L30
        if (r17 == null) goto L29;
        Object r18 = r17.getClass().getMethod("getOps", new Class[0]).invoke(r17, new Object[0]);     // Catch: Throwable -> L30
        if ((r18 instanceof List) == false) goto L23;
        r15 = (List) r18;     // Catch: Throwable -> L30
    L23:
        if (r15 == null) goto L29;
        Object r19 = CollectionsKt.firstOrNull(r15);     // Catch: Throwable -> L30
        if (r19 == null) goto L29;
        Object r20 = r19.getClass().getMethod("getMode", new Class[0]).invoke(r19, new Object[0]);     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L30
        return ((Integer) r20).intValue();
    L29:
        return -1;
    L15:
        r16 = null;
    L30:
        th = move-exception;
        Log.e(TAG, "getMode failed, pkg=" + r11, th);
        return -1;
    L36:
        return -1;
    L35:
        return -1;
    }

    private final Object obtainOpsManager(Context r3) {
        Context r2 = r3.getApplicationContext();
        if (r2 == null) goto L36;
        r3 = r2;
    L36:
        Object r0 = Class.forName(CTX_SMT).getField("SMT_OPS_SERVICE").get(null);     // Catch: Throwable -> L33
        if ((r0 instanceof String) == false) goto L10;
        String r1 = (String) r0;     // Catch: Throwable -> L33
    L11:
        String r4 = r1;     // Catch: Throwable -> L33
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L34;
        Object r6 = r3.getSystemService(r1);     // Catch: Throwable -> L33
        if (r6 == null) goto L34;
        return r6;
    L14:
        if (r4.length() == 0) goto L17;
        r5 = false;
        goto L18
    L10:
        r1 = null;
    L34:
        Object r7 = Context.class.getField("APP_OPS_SERVICE").get(null);     // Catch: Throwable -> L30
        if ((r7 instanceof String) == false) goto L25;
        String r8 = (String) r7;     // Catch: Throwable -> L30
    L26:
        if (r8 != null) goto L28;
        return null;
    L28:
        return r3.getSystemService(r8);
    L25:
        r8 = null;
    L30:
        th = move-exception;
        Log.e(TAG, "obtainOpsManager failed", th);
        return null;
    }

    static /* synthetic */ int getOpIntProperty$default(AppNetworkController r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        return r0.getOpIntProperty(r1, r2);
    }

    private final int getOpIntProperty(String r2, int r3) {
        Object r0 = readStatic(ANDROID_APP_SMT_OPS_MANAGER, r2);
        if (r0 != null) goto L6;
        r0 = readStatic(ANDROID_APP_APP_OPS_MANAGER, r2);
    L6:
        if ((r0 instanceof Integer) == false) goto L8;
        Integer r1 = (Integer) r0;
    L9:
        if (r1 != null) goto L11;
        return r3;
    L11:
        return r1.intValue();
    L8:
        r1 = null;
        goto L9
    }

    private final Object readStatic(String r1, String r2) {
        Field r3 = Class.forName(r1).getField(r2);     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        return r3.get(null);
    L8:
        return null;
    }

    private final int resolveUid(Context r4, String r5) {
    L12:
        return r4.getPackageManager().getApplicationInfo(r5, 0).uid;
    L7:
        Log.e(TAG, "resolveUid NameNotFoundException, pkg=" + r5);
        return -1;
    L5:
        th = move-exception;
        Log.e(TAG, "resolveUid failed, pkg=" + r5, th);
        return -1;
    }
}
