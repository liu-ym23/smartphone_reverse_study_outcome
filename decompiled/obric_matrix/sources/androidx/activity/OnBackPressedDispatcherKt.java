package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher r1, LifecycleOwner r2, final boolean r3, final l<? super OnBackPressedCallback, f0> r4) {
        o.f(r1, "<this>");
        o.f(r4, "onBackPressed");
        OnBackPressedCallback r0 = new OnBackPressedDispatcherKt$addCallback$callback$1(r3, r4);
        if (r2 == null) goto L5;
        r1.addCallback(r2, r0);
    L6:
        return r0;
    L5:
        r1.addCallback(r0);
        goto L6
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher r0, LifecycleOwner r1, boolean r2, l r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = true;
    L9:
        return addCallback(r0, r1, r2, r3);
    }
}
