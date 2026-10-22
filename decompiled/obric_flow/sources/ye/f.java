package ye;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.lynx.tasm.behavior.ui.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxViewpagerItem f23252a;

    public f(Context r5, LynxViewpagerItem r10) {
        Intrinsics.checkNotNullParameter(r10, "viewpagerItem");
        new LinkedHashMap();
        super(r5);
        this.f23252a = r10;
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (getMeasuredWidth() != 0) goto L15;
        ViewParent r11 = getParent();
        if ((r11 instanceof BaseCustomViewPager) == false) goto L7;
        BaseCustomViewPager r12 = (BaseCustomViewPager) r11;
    L8:
        if (r12 == null) goto L10;
        int r13 = r12.getMeasuredWidth();
    L11:
        setMeasuredDimension(r13, View.MeasureSpec.getSize(r10));
        com.lynx.tasm.behavior.ui.b r14 = this.mDrawChildHook;
        if (r14 == null) goto L16;
        r14.performMeasureChildrenUI();
        return;
    L16:
        return;
    L10:
        r13 = this.f23252a.getWidth();
        goto L11
    L7:
        r12 = null;
        goto L8
    }
}
