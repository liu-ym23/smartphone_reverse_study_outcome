package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h0 implements a0 {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    private h0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof RecordingEntity) == false) goto L30;
        RecordingEntity r3 = (RecordingEntity) r2;
        int r1 = ((((r3.getName().hashCode() + 0) * 31) + r3.getFile().hashCode()) * 31) + Integer.hashCode(r3.getDuration());
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
        if (r8 == null) goto L22;
        r1 = (r1 * 31) + r8.hashCode();
    L22:
        String r9 = r3.getRecordType();
        if (r9 == null) goto L25;
        r1 = (r1 * 31) + r9.hashCode();
    L25:
        String r10 = r3.getRecordStatus();
        if (r10 != null) goto L28;
        return r1;
    L28:
        return (r1 * 31) + r10.hashCode();
    L30:
        throw new IllegalStateException("Check failed.".toString());
    }
}
