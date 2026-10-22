package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.bytedance.securityserver.observer.SettingsViaMatrixListener;
import com.bytedance.securityserver.trustcircle.account.AccountStatusListener;
import com.bytedance.securityserver.trustcircle.account.AccountUtils;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsConfig;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import com.obric.oui.common.style.OUIEffectHelper;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int r1, Object r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L18;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            default: goto L4;
        };
    L4:
        Context r5 = ((AccountStatusListener) this.c).b;
        AccountUtils.a(r5, 0);
        AccountUtils.a(r5, 1);
        if (AccountUtils.i(r5, 0) == 0) goto L22;
        Log.e("SecurityServer-AccountStatusListener", "issue account cert chain failed");
        AccountUtils.h(r5, 0);
        return;
    L22:
        return;
    L8:
        ((OUIEffectHelper) this.c).b = true;
        return;
    L10:
        MatrixTeaManager.b((MatrixTeaManager) this.c);
        return;
    L12:
        SettingsViaMatrixListener r6 = (SettingsViaMatrixListener) this.c;
        Context r0 = r6.b;
        String r1 = r0.getPackageName();
        PackageInfo r2 = r0.getPackageManager().getPackageInfo(r1, 0);     // Catch: Exception -> L15
        MatrixSettingsConfig r3 = new MatrixSettingsConfig.Builder().setPackageName(r2.packageName).setVersionCode(r2.versionCode).setIsBoe(false).setVersionName(r2.versionName).build();     // Catch: Exception -> L15
        MatrixSettingsManager.Companion r4 = MatrixSettingsManager.Companion;     // Catch: Exception -> L15
        r4.init(r0, r3);     // Catch: Exception -> L15
        r4.getInstance().addSettingsUpdateListener(r6);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Log.e("SettingsViaMatrixListener", "Failed to get package info", e);
        return;
    L18:
        Carousel.a((Carousel) this.c);
    }
}
