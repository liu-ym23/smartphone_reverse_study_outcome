package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import obric.widget.editor.SimpleEditor;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneSimulateMotionDelayCommitViewBinding implements ViewBinding {
    public final OButton btnCommit;
    public final SimpleEditor commitEdit;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneSimulateMotionDelayCommitViewBinding(LinearLayout r1, OButton r2, SimpleEditor r3) {
        this.rootView = r1;
        this.btnCommit = r2;
        this.commitEdit = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RevoneSimulateMotionDelayCommitViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneSimulateMotionDelayCommitViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_simulate_motion_delay_commit_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneSimulateMotionDelayCommitViewBinding bind(View r3) {
        int r0 = R.id.btn_commit;
        OButton r1 = (OButton) ViewBindings.findChildViewById(r3, R.id.btn_commit);
        if (r1 == null) goto L9;
        r0 = R.id.commit_edit;
        SimpleEditor r2 = (SimpleEditor) ViewBindings.findChildViewById(r3, R.id.commit_edit);
        if (r2 == null) goto L9;
        return new RevoneSimulateMotionDelayCommitViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
