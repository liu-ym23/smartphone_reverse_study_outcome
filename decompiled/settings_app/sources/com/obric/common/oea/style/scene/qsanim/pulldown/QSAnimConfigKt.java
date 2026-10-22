package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: QSAnimConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"withQSAnimConfig", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "Landroid/view/View;", "initScale", "", "initAlpha", "flatChildViews", "", "style_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class QSAnimConfigKt {
    public static /* synthetic */ QSAnimConfig withQSAnimConfig$default(View r0, float r1, float r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return withQSAnimConfig(r0, r1, r2, r3);
    }

    public static final QSAnimConfig withQSAnimConfig(View r1, float r2, float r3, boolean r4) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new QSAnimConfig(r1, r2, r3, r4);
    }
}
