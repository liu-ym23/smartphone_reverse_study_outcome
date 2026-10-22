package com.obric.common.oea.foundation.animation.parser;

import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.AnimationLifecycleListener;
import com.obric.common.oea.foundation.animation.command.AnimationCommand;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimatableSubmitter {
    public static AnimationManager a(float r10, View r11, RunMode r12, float r13, RepeatMode r14, List r15, Function3 r16, final Function2 r17) {
        Intrinsics.f(r15, "animationCommands");
        ArrayList r6 = new ArrayList();
        Iterator r0 = r15.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r6.add(((AnimationCommand) r0.next()).a());
        goto L4
    L6:
        if (r11 == null) goto L19;
        AnimationInfo r1 = (AnimationInfo) AnimationLifecycleListener.b.get(r11);
        if (r1 == null) goto L10;
        float r2 = r1.k;
    L11:
        Iterator r3 = r6.iterator();
    L13:
        if (r3.hasNext() == false) goto L19;
        AnimationInfo r4 = (AnimationInfo) r3.next();
        if (r4.i != null) goto L17;
        OEALogger.a("AnimatableSubmitter", "没指定初始速度，重设velocity " + r2);
        r4.i = Float.valueOf(r2);
    L18:
        AnimationLifecycleListener.b.put(r11, r4);
        goto L13
    L17:
        OEALogger.a("AnimatableSubmitter", "指定了初始速度，" + r4.i);
        goto L18
    L10:
        r2 = 0.0f;
    L19:
        final AnimationManager r9 = new AnimationManager();
        ArrayList r5 = AnimationLifecycleListener.f101a;
        r5.add(r9);
        OEALogger.e("addAnimationManager, size: " + r5.size());
        r9.c(r10, r11, r12, r13, r14, r6, r16, new AnimatableSubmitter$animate$2(r17, r9));
        return r9;
    }
}
