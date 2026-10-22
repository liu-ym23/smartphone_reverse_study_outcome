package vn;

import android.view.ViewGroup;
import com.bytedance.ies.xelement.viewpager.LynxFoldView;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.LynxViewPager;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.obric.oui.infopanel.content.OInfoPanelContentEntranceView;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f22648b;

    public /* synthetic */ h(Object r5, int r10) {
        this.f22647a = r10;
        this.f22648b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = this.f22648b;
        switch(this.f22647a) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        LynxTabBarView r10 = (LynxTabBarView) r5;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        int r11 = LynxTabBarView.f6512k;
        r10.i();
        return;
    L6:
        int r12 = LynxFoldView.f;
        LynxFoldView r13 = (LynxFoldView) r5;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Iterator<LynxBaseUI> r14 = r13.getChildren().iterator();
    L8:
        if (r14.hasNext() == false) goto L30;
        LynxBaseUI r15 = r14.next();
        if ((r15 instanceof LynxViewPager) == false) goto L8;
        Iterator<LynxBaseUI> r16 = ((LynxViewPager) r15).getChildren().iterator();
    L13:
        if (r16.hasNext() == false) goto L31;
        LynxBaseUI r17 = r16.next();
        if ((r17 instanceof LynxTabBarView) == false) goto L13;
        if (r17 == null) goto L29;
        r13.d.add(r17);
        return;
    L29:
        return;
    L31:
        return;
    L30:
        return;
    L19:
        int r18 = OInfoPanelContentEntranceView.f13522i;
        OInfoPanelContentEntranceView r19 = (OInfoPanelContentEntranceView) r5;
        Intrinsics.checkNotNullParameter(r19, "this$0");
        com.lynx.tasm.utils.d.o(r19, r19.f13523h.getWidth(), com.lynx.tasm.utils.a.B(44, r19), true);
        ViewGroup r20 = r19.f13523h;
        com.lynx.tasm.utils.d.o(r20, r20.getWidth(), com.lynx.tasm.utils.a.B(44, r19), true);
        return;
    L21:
        ((e) r5).g();
    }
}
