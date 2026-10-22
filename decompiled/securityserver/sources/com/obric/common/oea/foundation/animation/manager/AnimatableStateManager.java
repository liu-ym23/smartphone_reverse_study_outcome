package com.obric.common.oea.foundation.animation.manager;

import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimatableStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RunMode f120a;
    public RepeatMode b;
    public List c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference f121d;
    public long e;
    public int f;
    public float g;
    public long h;
    public long i;
    public boolean j;

    public final void a(boolean r4) {
        WeakReference r0 = this.f121d;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Iterator r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((AnimationInfo) r1.next()).b(false, false, r4);
        goto L7
    L9:
        this.e = 0;
        this.f = -1;
        this.g = 1.0f;
        this.h = 0;
        this.i = 0;
    }
}
