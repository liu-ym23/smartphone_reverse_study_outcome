package yd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ies.bullet.ui.common.view.AutoRTLImageView;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap f23247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f23248b;

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.f23247a = new LinkedHashMap();
        this.f23248b = LayoutInflater.from(r5).inflate(R$layout.bullet_title_bar, this, true);
    }

    public final View a(int r5) {
        if (this.f23247a != null) goto L5;
        this.f23247a = new LinkedHashMap();
    L5:
        View r10 = (View) this.f23247a.get(Integer.valueOf(r5));
        if (r10 != null) goto L13;
        View r11 = findViewById(r5);
        if (r11 == null) goto L11;
        Integer r12 = Integer.valueOf(r5);
        this.f23247a.put(r12, r11);
        return r11;
    L11:
        return null;
    L13:
        return r10;
    }

    public final View getTitleBarRootView() {
        return this.f23248b;
    }

    public final void setBackListener(View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "click");
        ((AutoRTLImageView) a(R$id.iv_back)).setOnClickListener(r5);
    }

    public final void setCloseAllListener(View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "click");
        ((AutoRTLImageView) a(R$id.iv_close_all)).setOnClickListener(r5);
    }

    public final void setTitleBarRootView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f23248b = r5;
    }

    public final void setTitleIfMissing(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.TITLE);
        if (((TextView) a(R$id.tv_title)).getText().length() != 0) goto L6;
        ((TextView) a(R$id.tv_title)).setText(r5);
        return;
    }
}
