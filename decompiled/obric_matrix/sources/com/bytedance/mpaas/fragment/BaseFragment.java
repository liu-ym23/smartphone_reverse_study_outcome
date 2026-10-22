package com.bytedance.mpaas.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.k.b.a.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/mpaas/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "", "requestCode", "", "", "permissions", "", "grantResults", "Lkotlin/f0;", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "<init>", "()V", "launch_release"}, k = 1, mv = {1, 1, 15})
public abstract class BaseFragment extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap f5259f;

    public BaseFragment() {
    }

    public void b() {
        HashMap r0 = this.f5259f;
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
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L6;
        e.b().i(r1, r3, r4);
        return;
    }
}
