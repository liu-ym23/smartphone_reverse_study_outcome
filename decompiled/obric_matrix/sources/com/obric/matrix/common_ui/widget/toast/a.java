package com.obric.matrix.common_ui.widget.toast;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.DrawableRes;
import d.g.c.a.b;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\nJ\"\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/common_ui/widget/toast/ToastUtils;", "", "()V", "currentToast", "Landroid/widget/Toast;", "failure", "", "context", "Landroid/content/Context;", "textResId", "", "text", "", "show", "showWithIcon", "iconResId", "success", "warning", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Toast f9015b;

    static {
        f9014a = new a();
    }

    private a() {
    }

    public final void a(Context r2, String r3) {
        o.f(r3, "text");
        b(r2, b.f16748a, r3);
    }

    public final void b(Context r2, @DrawableRes int r3, String r4) {
        o.f(r4, "text");
        Toast r1 = f9015b;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        if (r2 != null) goto L7;
        r2 = d.g.f.a.a.f16974a.d();
    L7:
        Toast r5 = new Toast(r2);
        ToastLayout r0 = new ToastLayout(r2);
        r0.f(Integer.valueOf(r3), r4);
        r5.setView(r0);
        r5.setDuration(1);
        r5.setGravity(55, 0, 0);
        f9015b = r5;
        r5.show();
    }
}
