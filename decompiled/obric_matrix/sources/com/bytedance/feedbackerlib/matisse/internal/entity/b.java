package com.bytedance.feedbackerlib.matisse.internal.entity;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.IncapableDialog;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4344c;

    public b(int r2, String r3, String r4) {
        this.f4342a = 0;
        this.f4342a = r2;
        this.f4343b = r3;
        this.f4344c = r4;
    }

    public b(String r2) {
        this.f4342a = 0;
        this.f4344c = r2;
    }

    public static void a(Context r2, b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.f4342a;
        if (r0 != 1) goto L7;
        IncapableDialog.b(r3.f4343b, r3.f4344c).show(((FragmentActivity) r2).getSupportFragmentManager(), IncapableDialog.class.getName());
        return;
    L7:
        if (r0 == 2) goto L11;
        Toast.makeText(r2, r3.f4344c, 0).show();
        return;
    }
}
