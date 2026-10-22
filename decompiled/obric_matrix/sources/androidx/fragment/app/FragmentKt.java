package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aJ\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u000b¨\u0006\u000f"}, d2 = {"clearFragmentResult", "", "Landroidx/fragment/app/Fragment;", "requestKey", "", "clearFragmentResultListener", "setFragmentResult", "result", "Landroid/os/Bundle;", "setFragmentResultListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bundle", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentKt {
    public static /* synthetic */ void a(p r0, String r1, Bundle r2) {
        m13setFragmentResultListener$lambda0(r0, r1, r2);
    }

    public static final void clearFragmentResult(Fragment r1, String r2) {
        o.f(r1, "<this>");
        o.f(r2, "requestKey");
        r1.getParentFragmentManager().clearFragmentResult(r2);
    }

    public static final void clearFragmentResultListener(Fragment r1, String r2) {
        o.f(r1, "<this>");
        o.f(r2, "requestKey");
        r1.getParentFragmentManager().clearFragmentResultListener(r2);
    }

    public static final void setFragmentResult(Fragment r1, String r2, Bundle r3) {
        o.f(r1, "<this>");
        o.f(r2, "requestKey");
        o.f(r3, "result");
        r1.getParentFragmentManager().setFragmentResult(r2, r3);
    }

    public static final void setFragmentResultListener(Fragment r2, String r3, final p<? super String, ? super Bundle, f0> r4) {
        o.f(r2, "<this>");
        o.f(r3, "requestKey");
        o.f(r4, "listener");
        r2.getParentFragmentManager().setFragmentResultListener(r3, r2, new e(r4));
    }

    /* JADX INFO: renamed from: setFragmentResultListener$lambda-0, reason: not valid java name */
    private static final void m13setFragmentResultListener$lambda0(p r1, String r2, Bundle r3) {
        o.f(r1, "$tmp0");
        o.f(r2, "p0");
        o.f(r3, "p1");
        r1.invoke(r2, r3);
    }
}
