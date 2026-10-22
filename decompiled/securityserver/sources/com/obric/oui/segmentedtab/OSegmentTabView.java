package com.obric.oui.segmentedtab;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSegmentTabView extends OTouchAnimView {
    public static int j;
    public final String f;
    public int i;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public OSegmentTabView(@NotNull Context r2, @Nullable AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3, 0);
        StringBuilder r4 = new StringBuilder("OSegmentTabView_");
        int r5 = j;
        j = r5 + 1;
        r4.append(r5);
        this.f = r4.toString();
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final boolean a() {
        return true;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final void b(String r3, float r4) {
        L.a(this.f, "onTouchAnimUpdate, scene: " + r3 + ", animFraction: " + r4);
        int r0 = r3.hashCode();
        if (r0 != (-1965932727)) goto L5;
        r3.equals("release_anim");
    L9:
        RangesKt.b((int) ((1 - (r4 * 0.5f)) * this.i), 0, 255);
        Intrinsics.m("iconView");
        throw null;
    L5:
        if (r0 != 1870923917) goto L9;
        r3.equals("press_anim");
        goto L9
    }

    public final void setOriginIconAlpha(int r1) {
        this.i = r1;
    }
}
