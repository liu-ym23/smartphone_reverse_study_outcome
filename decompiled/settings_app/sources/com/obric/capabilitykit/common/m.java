package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class m implements a0 {
    public static final m a = null;

    static {
        a = new m();
    }

    private m() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof AuditoryRecordingEntity) == false) goto L24;
        AuditoryRecordingEntity r3 = (AuditoryRecordingEntity) r2;
        int r1 = ((((((r3.getName().hashCode() + 0) * 31) + Integer.hashCode(r3.getState())) * 31) + r3.getFile().hashCode()) * 31) + Integer.hashCode(r3.getDuration());
        FileEntity r0 = r3.getTranscript();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.hashCode();
    L7:
        String r4 = r3.getSummary();
        if (r4 == null) goto L10;
        r1 = (r1 * 31) + r4.hashCode();
    L10:
        List<String> r5 = r3.getTodoList();
        if (r5 == null) goto L13;
        r1 = (r1 * 31) + r5.hashCode();
    L13:
        List<Integer> r6 = r3.getMarkers();
        if (r6 == null) goto L16;
        r1 = (r1 * 31) + r6.hashCode();
    L16:
        String r7 = r3.getSourceAppName();
        if (r7 == null) goto L19;
        r1 = (r1 * 31) + r7.hashCode();
    L19:
        String r8 = r3.getSourceAppPackage();
        if (r8 != null) goto L22;
        return r1;
    L22:
        return (r1 * 31) + r8.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
