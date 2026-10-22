package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoFaceEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f0 implements a0 {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    private f0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "instance");
        if ((r1 instanceof PhotoFaceEntity) == false) goto L9;
        PhotoFaceEntity r2 = (PhotoFaceEntity) r1;
        int r0 = r2.getName().hashCode() + 0;
        FileEntity r3 = r2.getAvatar();
        if (r3 != null) goto L7;
        return r0;
    L7:
        return (r0 * 31) + r3.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
