package com.obric.matrix.account.ui;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.obric.matrix.account.larksso.LarkSSOChecker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/obric/matrix/account/ui/LarkSSOCheckFragment$networkObserver$1", "Landroidx/lifecycle/Observer;", "", "onChanged", "", "value", "(Ljava/lang/Boolean;)V", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LarkSSOCheckFragment$networkObserver$1 implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LarkSSOCheckFragment f8764a;

    LarkSSOCheckFragment$networkObserver$1(LarkSSOCheckFragment r1) {
        this.f8764a = r1;
    }

    public static /* synthetic */ void a(LarkSSOCheckFragment r0) {
        c(r0);
    }

    private static final void c(LarkSSOCheckFragment r3) {
        kotlin.n0.d.o.f(r3, "this$0");
        if (r3.isAdded() == true) goto L5;
    L9:
        com.obric.matrix.r.c.c.s("LarkSSOCheckFragment", "fragment is detached.");
        return;
    L5:
        if (r3.getActivity() == null) goto L9;
        LarkSSOCheckFragment.q(r3, true);
        LarkSSOChecker r0 = LarkSSOCheckFragment.j(r3);
        FragmentActivity r1 = r3.requireActivity();
        kotlin.n0.d.o.e(r1, "this@LarkSSOCheckFragment.requireActivity()");
        r0.v(r1, LarkSSOCheckFragment.i(r3));
    }

    public void b(Boolean r4) {
        if (LarkSSOCheckFragment.k(this.f8764a) == false) goto L5;
        return;
    L5:
        com.obric.matrix.r.c.c.b("LarkSSOCheckFragment", "network observe: called " + r4);
        if (r4 != null) goto L8;
    L18:
        LarkSSOCheckFragment.r(this.f8764a);
        return;
    L8:
        if (r4.booleanValue() == false) goto L18;
        d.g.d.c.c r5 = LarkSSOCheckFragment.l(this.f8764a);
        if (r5 == null) goto L13;
        r5.dismiss();
    L13:
        com.obric.matrix.account.r.d r6 = LarkSSOCheckFragment.m(this.f8764a);
        if (r6 == null) goto L16;
        r6.a().removeObserver(this);
        Handler r7 = LarkSSOCheckFragment.g(this.f8764a);
        final LarkSSOCheckFragment r3 = this.f8764a;
        r7.postDelayed(new g(r3), LarkSSOCheckFragment.d(r3));
        return;
    L16:
        kotlin.n0.d.o.v("netwrokViewModel");
        throw null;
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Boolean r1) {
        b(r1);
    }
}
