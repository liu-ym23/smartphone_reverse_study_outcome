package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.bytedance.common.utility.k;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.h;
import com.bytedance.feedbackerlib.j.e;

/* JADX INFO: loaded from: classes.dex */
public class IncapableDialog extends DialogFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f4429f = null;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AlertDialog f4430f;

        a(IncapableDialog r1, AlertDialog r2) {
            this.f4430f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f4430f.dismiss();
        }
    }

    static {
        f4429f = e.e();
    }

    public IncapableDialog() {
    }

    public static IncapableDialog b(String r3, String r4) {
        IncapableDialog r0 = new IncapableDialog();
        Bundle r1 = new Bundle();
        r1.putString("extra_title", r3);
        r1.putString("extra_message", r4);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle r5) {
        String r6 = getArguments().getString("extra_title");
        View r0 = LayoutInflater.from(getContext()).inflate(f.f4029f, null);
        TextView r1 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.c1);
        TextView r2 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.I0);
        r1.setText(r6);
        String r7 = f4429f.g("key_i_know");
        if (k.b(r7, "no translation") == false) goto L5;
        r7 = "我知道了";
    L5:
        r2.setText(r7);
        AlertDialog r8 = new AlertDialog.Builder(getActivity(), h.f4048c).setCancelable(true).setView(r0).create();
        r2.setOnClickListener(new a(this, r8));
        return r8;
    }
}
