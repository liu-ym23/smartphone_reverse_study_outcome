package com.obric.oui.avatar;

import android.graphics.Canvas;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAvatarQueueViewV2WithClip extends View implements IOAvatarQueueViewV2WithClipOperation {
    public static final /* synthetic */ int b = 0;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[OAvatarQueueShape.values().length];
            r0[1] = 1;
            r0[0] = 2;
            int[] r1 = new int[OAvatarQueueShape.values().length];
            r1[1] = 1;
            r1[0] = 2;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.avatar.OAvatarQueueViewV2WithClip$onDraw$1, reason: invalid class name */
    @Metadata
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public final Object get() {
            OAvatarQueueViewV2WithClip r1 = (OAvatarQueueViewV2WithClip) this.receiver;
            int r0 = OAvatarQueueViewV2WithClip.b;
            r1.getClass();
            Intrinsics.m("inParam");
            throw null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.f(r2, "canvas");
        super.onDraw(r2);
    }
}
