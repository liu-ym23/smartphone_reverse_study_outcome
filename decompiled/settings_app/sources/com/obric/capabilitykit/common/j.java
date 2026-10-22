package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j implements a0 {
    public static final j a = null;

    static {
        a = new j();
    }

    private j() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof AlarmEntity) == false) goto L15;
        AlarmEntity r3 = (AlarmEntity) r2;
        int r1 = ((((r3.getName().hashCode() + 0) * 31) + r3.getStartTime().hashCode()) * 31) + Boolean.hashCode(r3.isEnabled());
        List<Integer> r0 = r3.getRepeatDayOfWeek();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.hashCode();
    L7:
        int r4 = (r1 * 31) + Boolean.hashCode(r3.getCloseInHoliday());
        String r5 = r3.getDate();
        if (r5 == null) goto L10;
        r4 = (r4 * 31) + r5.hashCode();
    L10:
        Boolean r6 = r3.isRinging();
        if (r6 != null) goto L13;
        return r4;
    L13:
        return (r4 * 31) + Boolean.hashCode(r6.booleanValue());
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }
}
