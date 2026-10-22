package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class t extends AppCompatTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.obric.oui.calendar.v.h f10924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DayOfWeek f10925g;

    public t(Context r2, DayOfWeek r3) {
        super(r2);
        this.f10924f = com.obric.oui.calendar.v.h.f10932a;
        setGravity(17);
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setTextAlignment(4);
    L5:
        a(r3);
    }

    public void a(DayOfWeek r2) {
        this.f10925g = r2;
        setText(this.f10924f.a(r2));
    }

    public void b(@Nullable com.obric.oui.calendar.v.h r1) {
        if (r1 != null) goto L4;
        r1 = com.obric.oui.calendar.v.h.f10932a;
    L4:
        this.f10924f = r1;
        a(this.f10925g);
    }
}
