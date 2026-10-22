package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e0 implements a0 {
    public static final e0 a = null;

    static {
        a = new e0();
    }

    private e0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof PhotoEntity) == false) goto L33;
        PhotoEntity r4 = (PhotoEntity) r3;
        int r2 = ((((((((((((r4.getName().hashCode() + 0) * 31) + r4.getFile().hashCode()) * 31) + r4.getAssetType().name().hashCode()) * 31) + r4.getInAlbum().hashCode()) * 31) + r4.getResolution().hashCode()) * 31) + Long.hashCode(r4.getFileSize())) * 31) + Boolean.hashCode(r4.isFavorite());
        List<String> r0 = r4.getTags();
        if (r0 == null) goto L7;
        r2 = (r2 * 31) + r0.hashCode();
    L7:
        List<PhotoFaceEntity> r1 = r4.getFaces();
        if (r1 == null) goto L10;
        r2 = (r2 * 31) + r1.hashCode();
    L10:
        MetaLocation r5 = r4.getLocation();
        if (r5 == null) goto L13;
        r2 = (r2 * 31) + r5.hashCode();
    L13:
        String r6 = r4.getCaption();
        if (r6 == null) goto L16;
        r2 = (r2 * 31) + r6.hashCode();
    L16:
        String r7 = r4.getOcr();
        if (r7 == null) goto L19;
        r2 = (r2 * 31) + r7.hashCode();
    L19:
        String r8 = r4.getSourcePackageName();
        if (r8 == null) goto L22;
        r2 = (r2 * 31) + r8.hashCode();
    L22:
        String r9 = r4.getSourceAppName();
        if (r9 == null) goto L25;
        r2 = (r2 * 31) + r9.hashCode();
    L25:
        List<VideoFrame> r10 = r4.getVideoFrames();
        if (r10 == null) goto L28;
        r2 = (r2 * 31) + r10.hashCode();
    L28:
        List<VideoFrame> r11 = r4.getSearchFrames();
        if (r11 != null) goto L31;
        return r2;
    L31:
        return (r2 * 31) + r11.hashCode();
    L33:
        throw new IllegalStateException("Check failed.".toString());
    }
}
