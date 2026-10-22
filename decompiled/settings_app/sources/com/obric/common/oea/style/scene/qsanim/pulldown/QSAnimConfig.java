package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QSAnimConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "", "view", "Landroid/view/View;", "initScale", "", "initAlpha", "flatChildViews", "", "(Landroid/view/View;FFZ)V", "getFlatChildViews", "()Z", "getInitAlpha", "()F", "getInitScale", "getView", "()Landroid/view/View;", "toString", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class QSAnimConfig {
    private final boolean flatChildViews;
    private final float initAlpha;
    private final float initScale;
    private final View view;

    public QSAnimConfig(View r2, float r3, float r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.view = r2;
        this.initScale = r3;
        this.initAlpha = r4;
        this.flatChildViews = r5;
    }

    public final View getView() {
        return this.view;
    }

    public final float getInitScale() {
        return this.initScale;
    }

    public final float getInitAlpha() {
        return this.initAlpha;
    }

    public /* synthetic */ QSAnimConfig(View r2, float r3, float r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 1.0f;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 1.0f;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    public final boolean getFlatChildViews() {
        return this.flatChildViews;
    }

    public String toString() {
        return "QSAnimConfig(view: " + this.view.getClass().getSimpleName() + ", initScale: " + this.initScale + ", initAlpha: " + this.initAlpha + ", flatChildViews: " + this.flatChildViews + ')';
    }
}
