package com.obric.oui.infopanel.content;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.j;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/f0;", "onAttachedToWindow", "()V", "", "text", "setEntranceText", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvEntrance", "Landroid/view/ViewGroup;", "g", "Landroid/view/ViewGroup;", "entranceContainer", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OInfoPanelContentEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f11112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ViewGroup f11113g;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInfoPanelContentEntranceView f11114f;

        a(OInfoPanelContentEntranceView r1) {
            this.f11114f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OInfoPanelContentEntranceView r0 = this.f11114f;
            int r1 = OInfoPanelContentEntranceView.f(r0).getWidth();
            float r2 = 44;
            Resources r3 = Resources.getSystem();
            o.e(r3, "Resources.getSystem()");
            j.b(r0, r1, kotlin.o0.a.a(TypedValue.applyDimension(1, r2, r3.getDisplayMetrics())), true);
            ViewGroup r4 = OInfoPanelContentEntranceView.f(this.f11114f);
            int r6 = OInfoPanelContentEntranceView.f(this.f11114f).getWidth();
            Resources r5 = Resources.getSystem();
            o.e(r5, "Resources.getSystem()");
            j.b(r4, r6, kotlin.o0.a.a(TypedValue.applyDimension(1, r2, r5.getDisplayMetrics())), true);
        }
    }

    public static final /* synthetic */ ViewGroup f(OInfoPanelContentEntranceView r0) {
        return r0.f11113g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
    }

    public final void setEntranceText(CharSequence r2) {
        o.f(r2, "text");
        this.f11112f.setText(r2);
    }
}
