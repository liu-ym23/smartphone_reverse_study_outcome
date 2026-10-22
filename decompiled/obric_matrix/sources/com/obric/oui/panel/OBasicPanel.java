package com.obric.oui.panel;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\rJ-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000e8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lkotlin/f0;", "onStart", "()V", "Lcom/obric/oui/panel/OBasicPanel$a;", "I", "Lcom/obric/oui/panel/OBasicPanel$a;", "getConfig", "()Lcom/obric/oui/panel/OBasicPanel$a;", "setConfig", "(Lcom/obric/oui/panel/OBasicPanel$a;)V", "config", "<init>", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OBasicPanel extends OBasicPanelFragment {
    protected a I;

    public static final class a {
        public final View a() {
            throw null;
        }
    }

    public static final class b {
    }

    static {
    }

    public OBasicPanel() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.f(r1, "inflater");
        a r0 = this.I;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L8;
        o.v("config");
        throw null;
    L8:
        r0.a();
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.I != null) goto L12;
        Dialog r0 = getDialog();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isShowing() != true) goto L14;
        Dialog r2 = getDialog();
        if (r2 == null) goto L15;
        r2.cancel();
        return;
    L15:
        return;
    L14:
        return;
    }
}
