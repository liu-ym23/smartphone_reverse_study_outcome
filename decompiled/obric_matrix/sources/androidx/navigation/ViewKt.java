package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/view/View;", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewKt {
    public static final NavController findNavController(View r1) {
        o.f(r1, "<this>");
        return Navigation.findNavController(r1);
    }
}
