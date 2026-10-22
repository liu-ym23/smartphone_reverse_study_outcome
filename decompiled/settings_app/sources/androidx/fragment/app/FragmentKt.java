package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aJ\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u000b¨\u0006\u000f"}, d2 = {"clearFragmentResult", "", "Landroidx/fragment/app/Fragment;", "requestKey", "", "clearFragmentResultListener", "setFragmentResult", "result", "Landroid/os/Bundle;", "setFragmentResultListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", "fragment-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentKt {
    public static /* synthetic */ void $r8$lambda$cAbpDuLr9JltDVsW0IHODze0S8c(Function2 r0, String r1, Bundle r2) {
        setFragmentResultListener$lambda$0(r0, r1, r2);
    }

    public static final void setFragmentResult(Fragment r1, String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "requestKey");
        Intrinsics.checkNotNullParameter(r3, "result");
        r1.getParentFragmentManager().setFragmentResult(r2, r3);
    }

    public static final void clearFragmentResult(Fragment r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "requestKey");
        r1.getParentFragmentManager().clearFragmentResult(r2);
    }

    public static final void setFragmentResultListener(Fragment r2, String r3, final Function2<? super String, ? super Bundle, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "requestKey");
        Intrinsics.checkNotNullParameter(r4, "listener");
        r2.getParentFragmentManager().setFragmentResultListener(r3, r2, new FragmentKt$$ExternalSyntheticLambda0(r4));
    }

    private static final void setFragmentResultListener$lambda$0(Function2 r1, String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        r1.invoke(r2, r3);
    }

    public static final void clearFragmentResultListener(Fragment r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "requestKey");
        r1.getParentFragmentManager().clearFragmentResultListener(r2);
    }
}
