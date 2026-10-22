package com.ss.android.common.app.permission.callback;

import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.q;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bRB\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/common/app/permission/callback/AssistV4Fragment;", "Landroidx/fragment/app/Fragment;", "", "requestCode", "", "", "permissions", "", "grantResults", "Lkotlin/f0;", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lkotlin/Function3;", "f", "Lkotlin/n0/c/q;", "getOnRequestPermissionsResult", "()Lkotlin/n0/c/q;", "setOnRequestPermissionsResult", "(Lkotlin/n0/c/q;)V", "<init>", "()V", "permissions_release"}, k = 1, mv = {1, 1, 15})
public final class AssistV4Fragment extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q<? super Integer, ? super String[], ? super int[], f0> f11861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap f11862g;

    public AssistV4Fragment() {
    }

    public void b() {
        HashMap r0 = this.f11862g;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        o.g(r3, "permissions");
        o.g(r4, "grantResults");
        super.onRequestPermissionsResult(r2, r3, r4);
        q<? super Integer, ? super String[], ? super int[], f0> r1 = this.f11861f;
        if (r1 == null) goto L6;
        r1.f(Integer.valueOf(r2), r3, r4);
        return;
    L6:
        o.v("onRequestPermissionsResult");
        throw null;
    }
}
