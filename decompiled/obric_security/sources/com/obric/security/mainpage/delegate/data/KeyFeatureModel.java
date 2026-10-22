package com.obric.security.mainpage.delegate.data;

import com.bytedance.blockframework.framework.core.IBlockModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyFeatureData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "data", "(Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;)V", "getData", "()Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyFeatureModel implements IBlockModel<KeyFeatureData> {
    private final KeyFeatureData data;

    public static /* synthetic */ KeyFeatureModel copy$default(KeyFeatureModel r0, KeyFeatureData r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.getData();
    L6:
        return r0.copy(r1);
    }

    public final KeyFeatureData component1() {
        return getData();
    }

    public final KeyFeatureModel copy(KeyFeatureData r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
        return new KeyFeatureModel(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof KeyFeatureModel) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getData(), ((KeyFeatureModel) r2).getData()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        KeyFeatureData r0 = getData();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "KeyFeatureModel(data=" + getData() + ")";
    }

    public KeyFeatureModel(KeyFeatureData r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.data = r2;
    }

    @Override // com.bytedance.blockframework.framework.core.IBlockModel
    public /* bridge */ /* synthetic */ KeyFeatureData getData() {
        return getData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.blockframework.framework.core.IBlockModel
    public KeyFeatureData getData() {
        return this.data;
    }
}
