package com.obric.oui.avatar;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.PerfConsts;
import d.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAvatarGroupView extends ConstraintLayout {

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[OAvatar.AvatarSize.values().length];
            r0[2] = 1;
            r0[3] = 2;
            r0[4] = 3;
            r0[5] = 4;
            r0[6] = 5;
            r0[7] = 6;
            r0[8] = 7;
        }
    }

    @NotNull
    public final OAvatar getTopAvatar() {
        return null;
    }

    @NotNull
    public final OAvatar getUnderAvatar() {
        return null;
    }

    public final void setAvatarGroupSize(@NotNull OAvatar.AvatarSize r3) {
        Intrinsics.f(r3, PerfConsts.PERF_DISK_FILE_SIZE);
        switch(r3.ordinal()) {
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("disallow the size: " + r3);
    L7:
        if (r3.b < 56) goto L10;
        int r2 = 3;
    L9:
        b.b("Resources.getSystem()", 1, r2);
        throw null;
    L10:
        r2 = 2;
        goto L9
    }
}
