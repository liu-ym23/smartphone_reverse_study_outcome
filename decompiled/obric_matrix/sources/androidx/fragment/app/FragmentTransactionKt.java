package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¨\u0006\u000b"}, d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", "F", "Landroidx/fragment/app/Fragment;", "containerViewId", "", LocationMonitorConst.TAG, "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r0, @IdRes int r1, String r2, Bundle r3) {
        o.f(r0, "<this>");
        o.j(4, "F");
        throw null;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r0, String r1, Bundle r2) {
        o.f(r0, "<this>");
        o.f(r1, LocationMonitorConst.TAG);
        o.j(4, "F");
        throw null;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r0, int r1, String r2, Bundle r3, int r4, Object r5) {
        int r6 = r4 & 2;
        int r7 = r4 & 4;
        o.f(r0, "<this>");
        o.j(4, "F");
        throw null;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r0, String r1, Bundle r2, int r3, Object r4) {
        int r5 = r3 & 2;
        o.f(r0, "<this>");
        o.f(r1, LocationMonitorConst.TAG);
        o.j(4, "F");
        throw null;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction r0, @IdRes int r1, String r2, Bundle r3) {
        o.f(r0, "<this>");
        o.j(4, "F");
        throw null;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction r0, int r1, String r2, Bundle r3, int r4, Object r5) {
        int r6 = r4 & 2;
        int r7 = r4 & 4;
        o.f(r0, "<this>");
        o.j(4, "F");
        throw null;
    }
}
