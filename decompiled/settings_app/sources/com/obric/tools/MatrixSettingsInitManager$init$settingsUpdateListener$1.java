package com.obric.tools;

import android.content.Context;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixSettingsInitManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/tools/MatrixSettingsInitManager$init$settingsUpdateListener$1", "Lcom/obric/matrix/platform/sdk/ones/settings/SettingsUpdateListener;", "onSettingsUpdate", "", Constants.KEY_CONFIG, "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MatrixSettingsInitManager$init$settingsUpdateListener$1 implements SettingsUpdateListener {
    final /* synthetic */ Context $context;

    public static /* synthetic */ void $r8$lambda$fKOUL8iPkImSVyw6xG2t6HQuRLw(Context r0) {
        onSettingsUpdate$lambda$0(r0);
    }

    MatrixSettingsInitManager$init$settingsUpdateListener$1(Context r1) {
        this.$context = r1;
    }

    @Override // com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener
    public void onSettingsUpdate(String r2) {
        MatrixSettingsInitManager r0 = MatrixSettingsInitManager.INSTANCE;
        if (r2 != null) goto L5;
        r2 = MatrixSettingsInitManager.access$readAllSettings(MatrixSettingsInitManager.INSTANCE);
    L5:
        MatrixSettingsInitManager.access$updateSettingsCache(r0, r2);
        final Context r1 = this.$context;
        ThreadUtils.postOnMainThread(new MatrixSettingsInitManager$init$settingsUpdateListener$1$$ExternalSyntheticLambda0(r1));
    }

    private static final void onSettingsUpdate$lambda$0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "$context");
        OLog.i("MatrixTeaInitManager", "Settings-setting onSettingsUpdate: ");
        MatrixSettingsInitManager.access$handlePushPermissionConfig(MatrixSettingsInitManager.INSTANCE, r2);
    }
}
