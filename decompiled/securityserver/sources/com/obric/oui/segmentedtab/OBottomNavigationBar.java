package com.obric.oui.segmentedtab;

import android.view.View;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.oui.layout.OUIFrameLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomNavigationBar extends OUIFrameLayout {
    @NotNull
    public final OBottomNavActionBar getNavigationBar() {
        return null;
    }

    public final void setMaskBlurRadius(float r5) {
        HashMap r4 = BlurUtils.f131a;
        Method r0 = (Method) r4.get("setBackdropBlurEffect");
        if (r0 == null) goto L14;
    L9:
        r0.invoke(null, new Object[]{2, Float.valueOf(8.0f)});     // Catch: InvocationTargetException -> L5 Throwable -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        throw null;
    L5:
        e = move-exception;
        e.printStackTrace();
        throw null;
    L17:
        throw null;
    L14:
        r0 = View.class.getDeclaredMethod("setBackdropBlurEffect", new Class[]{Integer.TYPE, Float.TYPE});     // Catch: InvocationTargetException -> L5 Throwable -> L7
        r0.setAccessible(true);     // Catch: InvocationTargetException -> L5 Throwable -> L7
        r4.put("setBackdropBlurEffect", r0);     // Catch: InvocationTargetException -> L5 Throwable -> L7
        goto L9
    }
}
