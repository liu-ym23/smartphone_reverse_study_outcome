package com.obric.security.mainpage.block;

import android.os.Bundle;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.oui.text.OTextView;
import com.obric.security.service.SecurityServiceBinder;
import com.obric.securitycenter.api.Const;
import com.obric.securitycenter.api.IEventCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrashCleanBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/security/mainpage/block/TrashCleanBlock$eventCallback$1", "Lcom/obric/securitycenter/api/IEventCallback$Stub;", "onEvent", "", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TrashCleanBlock$eventCallback$1 extends IEventCallback.Stub {
    final /* synthetic */ TrashCleanBlock this$0;

    TrashCleanBlock$eventCallback$1(TrashCleanBlock r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.securitycenter.api.IEventCallback
    public void onEvent(Bundle r5) {
        if (r5 == null) goto L4;
        String r6 = r5.getString("event");
    L6:
        if (Intrinsics.areEqual(r6, Const.EVENT_SCAN_TASK_FINISH) == false) goto L8;
    L9:
        SecurityServiceBinder r7 = TrashCleanBlock.access$getSecurityCenterService$p(this.this$0);
        if (r7 == null) goto L12;
        long r2 = r7.getTrashTotalSize();
    L14:
        if (r2 != 0) goto L19;
        OTextView r8 = TrashCleanBlock.access$getLabel$p(this.this$0);
        if (r8 == null) goto L23;
        r8.post(new TrashCleanBlock$eventCallback$1$onEvent$1(this));
        return;
    L23:
        return;
    L19:
        final ByteUnitPair r9 = ByteConverter.convert(r2, "B", 1000);
        OTextView r0 = TrashCleanBlock.access$getLabel$p(this.this$0);
        if (r0 == null) goto L25;
        r0.post(new TrashCleanBlock$eventCallback$1$onEvent$2(this, r9));
        return;
    L25:
        return;
    L12:
        r2 = 0;
        goto L14
    L8:
        if (Intrinsics.areEqual(r6, Const.EVENT_CLEAR_TASK_FINISH) == true) goto L9;
        return;
    L4:
        r6 = null;
        goto L6
    }
}
