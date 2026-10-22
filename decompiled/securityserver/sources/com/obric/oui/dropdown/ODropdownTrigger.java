package com.obric.oui.dropdown;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.oui.layout.OUILinearLayout;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class ODropdownTrigger extends OUILinearLayout {
    public static final /* synthetic */ KProperty[] l = null;
    public WeakReference k;

    /* JADX INFO: renamed from: com.obric.oui.dropdown.ODropdownTrigger$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    static {
        MutablePropertyReference1Impl r6 = new MutablePropertyReference1Impl(CallableReference.NO_RECEIVER, ODropdownTrigger.class, "active", "getActive()Z", false);
        Reflection.f343a.getClass();
        l = new KProperty[]{r6};
    }

    public final boolean getActive() {
        KProperty r1 = l[0];
        throw null;
    }

    @Nullable
    public final Activity getDropdownActivity() {
        WeakReference r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.m("reference");
        throw null;
    L5:
        return (Activity) r0.get();
    }

    @NotNull
    public final ImageView getIcon() {
        return null;
    }

    @NotNull
    public final TextView getValue() {
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    public final void setActive(boolean r1) {
        KProperty r0 = l[0];
        throw null;
    }

    public final void setDropdownActivity(@Nullable Activity r2) {
        this.k = new WeakReference(r2);
    }
}
