package androidx.lifecycle;

import h.a.b1;
import h.a.m0;
import h.a.s2;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"JOB_KEY", "", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final m0 getViewModelScope(ViewModel r4) {
        o.f(r4, "<this>");
        m0 r1 = (m0) r4.getTag(JOB_KEY);
        if (r1 == null) goto L5;
        return r1;
    L5:
        Object r5 = r4.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(s2.b(null, 1, null).plus(b1.c().h0())));
        o.e(r5, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (m0) r5;
    }
}
