package com.obric.security.health.ui;

import android.os.Bundle;
import androidx.lifecycle.ViewModelKt;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.securitycenter.api.IEventCallback;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OptimizeCenterViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/security/health/ui/OptimizeCenterViewModel$eventCallback$1", "Lcom/obric/securitycenter/api/IEventCallback$Stub;", "onEvent", "", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeCenterViewModel$eventCallback$1 extends IEventCallback.Stub {
    final /* synthetic */ OptimizeCenterViewModel this$0;

    OptimizeCenterViewModel$eventCallback$1(OptimizeCenterViewModel r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.securitycenter.api.IEventCallback
    public void onEvent(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getMain(), null, new OptimizeCenterViewModel$eventCallback$1$onEvent$1(this, r8, null), 2, null);
    }
}
