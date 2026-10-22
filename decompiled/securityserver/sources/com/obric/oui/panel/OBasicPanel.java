package com.obric.oui.panel;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OBasicPanel extends OBasicPanelFragment {

    @Metadata
    public static final class Builder {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof Builder) == false) goto L16;
            ((Builder) r1).getClass();
            if (Intrinsics.a(null, null) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.a(null, null) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.a(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.a(null, null) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.a(null, null) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(0) * 1507551809;
        }

        public final String toString() {
            return "Builder(maxPanelHeight=0, useToneBg=false, isExpandable=false, header=null, content=null, floatHeader=false, backgroundDimEnable=false, adaptNavBarColor=false, navBarColor=null, clipTopCorner=false, dismissListener=null, retainInstance=false, autoSwitchDayNight=false, onCancelListener=null, removeMinHeight=false)";
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class PadCompatConfig {

        @Metadata
        public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
            public static final /* synthetic */ CloseIconStyle[] b = null;

            static {
                b = new CloseIconStyle[]{new CloseIconStyle("BLACK_NO_BG", 0), new CloseIconStyle("WHITE_WITH_BG", 1), new CloseIconStyle("BLACK_WITH_BG", 2)};
            }

            public static CloseIconStyle valueOf(String r1) {
                return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r1);
            }

            public static CloseIconStyle[] values() {
                return (CloseIconStyle[]) b.clone();
            }
        }

        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof PadCompatConfig) == false) goto L8;
            ((PadCompatConfig) r1).getClass();
            if (Intrinsics.a(null, null) == true) goto L13;
            return false;
        L13:
            return true;
        L8:
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "PadCompatConfig(isEnabled=false, isMultiPanel=false, closeIconStyle=null, forceEnable=false)";
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.OBasicPanel$onCreateView$1, reason: invalid class name */
    @Metadata
    final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public final Object get() {
            ((OBasicPanel) this.receiver).getClass();
            Intrinsics.m("config");
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.panel.OBasicPanel$onStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata
    final /* synthetic */ class C00391 extends PropertyReference0Impl {
        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public final Object get() {
            ((OBasicPanel) this.receiver).getClass();
            Intrinsics.m("config");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.f(r1, "inflater");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L11;
        Dialog r2 = getDialog();
        if (r2 == null) goto L12;
        r2.cancel();
        return;
    L12:
        return;
    }
}
