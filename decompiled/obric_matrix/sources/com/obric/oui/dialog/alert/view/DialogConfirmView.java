package com.obric.oui.dialog.alert.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.checkbox.OCheckBox;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "Landroid/widget/TextView;", "getNormalTextView", "()Landroid/widget/TextView;", "getLinkTextView", "Lkotlin/f0;", "onAttachedToWindow", "()V", "f", "Lcom/obric/oui/checkbox/OCheckBox;", "checkBox", "g", "Landroid/widget/TextView;", "tvNormal", "h", "tvLink", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "clickContainer", "Landroid/widget/RelativeLayout;", "i", "Landroid/widget/RelativeLayout;", "linkContainer", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class DialogConfirmView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OCheckBox f10957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f10958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextView f10959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RelativeLayout f10960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ViewGroup f10961j;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DialogConfirmView f10962f;

        a(DialogConfirmView r1) {
            this.f10962f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            DialogConfirmView.f(this.f10962f).performClick();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DialogConfirmView f10963f;

        b(DialogConfirmView r1) {
            this.f10963f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.f10963f.getCheckBox().performClick();
        }
    }

    public static final /* synthetic */ TextView f(DialogConfirmView r0) {
        return r0.f10959h;
    }

    public final OCheckBox getCheckBox() {
        return this.f10957f;
    }

    public final TextView getLinkTextView() {
        return this.f10959h;
    }

    public final TextView getNormalTextView() {
        return this.f10958g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r0 = getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) r0;
        this.f10960i.setPadding(0, r1.getPaddingTop(), 0, r1.getPaddingBottom());
        this.f10960i.setOnClickListener(new a(this));
        r1.setPadding(r1.getPaddingLeft(), 0, r1.getPaddingRight(), 0);
        this.f10961j.setOnClickListener(new b(this));
        return;
    }
}
