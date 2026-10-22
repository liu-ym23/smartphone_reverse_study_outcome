package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentTransaction.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¨\u0006\u000b"}, d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "tag", "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentTransactionKt {
    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r1, int r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction r7 = r1.add(r2, Fragment.class, r4, r3);
        Intrinsics.checkNotNullExpressionValue(r7, "add(containerViewId, F::class.java, args, tag)");
        return r7;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r2, int r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction r6 = r2.add(r3, Fragment.class, r5, r4);
        Intrinsics.checkNotNullExpressionValue(r6, "add(containerViewId, F::class.java, args, tag)");
        return r6;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r0, String r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction r5 = r0.add(Fragment.class, r2, r1);
        Intrinsics.checkNotNullExpressionValue(r5, "add(F::class.java, args, tag)");
        return r5;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction r5 = r2.add(Fragment.class, r4, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "add(F::class.java, args, tag)");
        return r5;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction r1, int r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction r7 = r1.replace(r2, Fragment.class, r4, r3);
        Intrinsics.checkNotNullExpressionValue(r7, "replace(containerViewId, F::class.java, args, tag)");
        return r7;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction r2, int r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction r6 = r2.replace(r3, Fragment.class, r5, r4);
        Intrinsics.checkNotNullExpressionValue(r6, "replace(containerViewId, F::class.java, args, tag)");
        return r6;
    }
}
