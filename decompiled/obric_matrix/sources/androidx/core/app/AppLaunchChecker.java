package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.core.content.IntentCompat;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class AppLaunchChecker {
    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";

    @Deprecated
    public AppLaunchChecker() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_androidx_core_app_AppLaunchChecker_com_obric_matrix_SPLancet_getSharedPreferences(Activity r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_androidx_core_app_AppLaunchChecker_com_obric_matrix_SPLancet_getSharedPreferences2(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static boolean hasStartedFromLauncher(@NonNull Context r2) {
        return INVOKEVIRTUAL_androidx_core_app_AppLaunchChecker_com_obric_matrix_SPLancet_getSharedPreferences2(r2, SHARED_PREFS_NAME, 0).getBoolean(KEY_STARTED_FROM_LAUNCHER, false);
    }

    public static void onActivityCreate(@NonNull Activity r4) {
        SharedPreferences r0 = INVOKEVIRTUAL_androidx_core_app_AppLaunchChecker_com_obric_matrix_SPLancet_getSharedPreferences(r4, SHARED_PREFS_NAME, 0);
        if (r0.getBoolean(KEY_STARTED_FROM_LAUNCHER, false) == false) goto L5;
        return;
    L5:
        Intent r5 = r4.getIntent();
        if (r5 != null) goto L9;
        return;
    L9:
        if ("android.intent.action.MAIN".equals(r5.getAction()) == true) goto L11;
        return;
    L11:
        if (r5.hasCategory("android.intent.category.LAUNCHER") == false) goto L13;
    L14:
        r0.edit().putBoolean(KEY_STARTED_FROM_LAUNCHER, true).apply();
        return;
    L13:
        if (r5.hasCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER) == true) goto L14;
    }
}
