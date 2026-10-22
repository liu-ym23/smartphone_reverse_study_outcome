package com.obric.matrix.common_ui.widget.toast;

import android.content.Context;
import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.matrix.common_ui.utils.b;
import com.obric.matrix.common_ui.utils.c;
import com.obric.matrix.common_ui.utils.e;
import d.g.c.a.d;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/common_ui/widget/toast/ToastLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/text/TextPaint;", "setContent", "", "iconResId", "text", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "shouldUseMultiLine", "", "hasImage", "common_ui_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextPaint f9013f;

    public ToastLayout(Context r2) {
        o.f(r2, "context");
        new LinkedHashMap();
        super(r2);
        TextPaint r3 = new TextPaint();
        r3.setTextSize(c.b(d.g.c.a.a.H));
        this.f9013f = r3;
    }

    private final boolean g(boolean r6, String r7) {
        int r0 = b.a(d.g.f.a.a.f16974a.d());
        float r1 = 0.0f;
        if (r6 == false) goto L5;
        float r2 = c.b(d.g.c.a.a.p);
    L6:
        if (r6 == false) goto L8;
        r1 = c.b(d.g.c.a.a.G);
    L8:
        float r4 = 2;
        if (this.f9013f.measureText(r7) <= ((((r0 - (c.b(d.g.c.a.a.f16743h) * r4)) - (r4 * c.b(d.g.c.a.a.m))) - r2) - r1)) goto L11;
        return true;
    L11:
        return false;
    L5:
        r2 = 0.0f;
        goto L6
    }

    public final void f(@DrawableRes Integer r3, String r4) {
        o.f(r4, "text");
        if (r3 == null) goto L5;
        boolean r0 = true;
    L7:
        if (g(r0, r4) == false) goto L9;
        Context r1 = getContext();
        int r2 = d.f16752b;
    L10:
        ViewGroup.inflate(r1, r2, this);
        TextView r5 = (TextView) findViewById(d.g.c.a.c.f16750b);
        ImageView r6 = (ImageView) findViewById(d.g.c.a.c.f16749a);
        if (r3 != null) goto L13;
        o.e(r6, "imageView");
        e.e(r6);
    L14:
        r5.setText(r4);
        return;
    L13:
        r6.setImageResource(r3.intValue());
        goto L14
    L9:
        r1 = getContext();
        r2 = d.f16751a;
        goto L10
    L5:
        r0 = false;
        goto L7
    }
}
