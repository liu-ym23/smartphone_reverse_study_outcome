package com.obric.security.mainpage.block;

import com.bytedanceos.storage.AbstractMeasurementReceiver;
import com.bytedanceos.storage.StorageMeasurement;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StorageManagerBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/security/mainpage/block/StorageManagerBlock$mReceiver$1", "Lcom/bytedanceos/storage/AbstractMeasurementReceiver;", "updateApproximate", "", "meas", "Lcom/bytedanceos/storage/StorageMeasurement;", "totalSize", "", "availSize", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class StorageManagerBlock$mReceiver$1 extends AbstractMeasurementReceiver {
    final /* synthetic */ StorageManagerBlock this$0;

    StorageManagerBlock$mReceiver$1(StorageManagerBlock r1) {
        this.this$0 = r1;
    }

    @Override // com.bytedanceos.storage.AbstractMeasurementReceiver, com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
    public void updateApproximate(StorageMeasurement r1, long r2, long r4) {
        Intrinsics.checkNotNullParameter(r1, "meas");
        final String r3 = StorageManagerBlock.access$formatSize(this.this$0, r4);
        OTextView r5 = StorageManagerBlock.access$getLabel$p(this.this$0);
        if (r5 == null) goto L6;
        r5.post(new StorageManagerBlock$mReceiver$1$updateApproximate$1(this, r3));
        return;
    }
}
