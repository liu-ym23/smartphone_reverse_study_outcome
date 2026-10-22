package com.obric.oui.push;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.oui.window.bean.WindowSizeClass;
import d.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPush {

    /* JADX INFO: renamed from: com.obric.oui.push.OPush$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements NotificationLabel.GestureListener {
        @Override // com.obric.oui.push.NotificationLabel.GestureListener
        public final void a() {
            ((PushQueue) PushQueue.f273a.getValue()).getClass();
            throw null;
        }

        @Override // com.obric.oui.push.NotificationLabel.GestureListener
        public final void b() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.push.OPush$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.push.OPush$3, reason: invalid class name */
    @Metadata
    final class AnonymousClass3 implements PopupWindow.OnDismissListener {
        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            throw null;
        }
    }

    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f272a = 0;

        @Metadata
        public static final class Companion {
        }

        static {
            b.b("Resources.getSystem()", 1, 16);
            b.b("Resources.getSystem()", 1, 24);
            b.b("Resources.getSystem()", 1, 48);
        }
    }

    @Metadata
    public static final class Companion {

        @Metadata
        public final /* synthetic */ class WhenMappings {
            static {
                int[] r0 = new int[WindowSizeClass.values().length];
                r0[WindowSizeClass.b.ordinal()] = 1;
                r0[WindowSizeClass.c.ordinal()] = 2;
                r0[WindowSizeClass.e.ordinal()] = 3;
                r0[WindowSizeClass.f.ordinal()] = 4;
                r0[WindowSizeClass.i.ordinal()] = 5;
            }
        }
    }
}
