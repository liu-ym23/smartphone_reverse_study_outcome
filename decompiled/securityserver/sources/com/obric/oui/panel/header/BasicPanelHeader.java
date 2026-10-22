package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.bytedance.securityserver.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class BasicPanelHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContextThemeWrapper f254a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f255d;

    public BasicPanelHeader(Context r1) {
        this.c = false;
        this.f255d = 0;
        this.b = true;
    }

    public static ContextThemeWrapper a(BasicPanelHeader r2, Context r3) {
        boolean r0 = r2.c;
        r2.getClass();
        int r1 = r2.f255d;
        if (r1 != 0) goto L10;
        if (r0 == false) goto L7;
        ContextThemeWrapper r4 = new ContextThemeWrapper(r3, R.style.OBasicPanelDayNightSwitch);
    L8:
        r2.f254a = r4;
        return r4;
    L7:
        r4 = new ContextThemeWrapper(r3, R.style.OBasicPanelConstLight);
        goto L8
    L10:
        return new ContextThemeWrapper(r3, r1);
    }

    public abstract View b();
}
