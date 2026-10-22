package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleRequestManagerRetriever {
    private final RequestManagerRetriever.RequestManagerFactory factory;
    final Map<androidx.lifecycle.Lifecycle, RequestManager> lifecycleToRequestManager;

    private final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {
        private final FragmentManager childFragmentManager;
        final /* synthetic */ LifecycleRequestManagerRetriever this$0;

        SupportRequestManagerTreeNode(LifecycleRequestManagerRetriever r1, FragmentManager r2) {
            this.this$0 = r1;
            this.childFragmentManager = r2;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            HashSet r0 = new HashSet();
            getChildFragmentsRecursive(this.childFragmentManager, r0);
            return r0;
        }

        private void getChildFragmentsRecursive(FragmentManager r5, Set<RequestManager> r6) {
            List<Fragment> r7 = r5.getFragments();
            int r0 = r7.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            Fragment r2 = r7.get(r1);
            getChildFragmentsRecursive(r2.getChildFragmentManager(), r6);
            RequestManager r3 = this.this$0.getOnly(r2.getLifecycle());
            if (r3 == null) goto L7;
            r6.add(r3);
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    LifecycleRequestManagerRetriever(RequestManagerRetriever.RequestManagerFactory r2) {
        this.lifecycleToRequestManager = new HashMap();
        this.factory = r2;
    }

    RequestManager getOnly(androidx.lifecycle.Lifecycle r1) {
        Util.assertMainThread();
        return this.lifecycleToRequestManager.get(r1);
    }

    RequestManager getOrCreate(Context r4, Glide r5, final androidx.lifecycle.Lifecycle r6, FragmentManager r7, boolean r8) {
        Util.assertMainThread();
        RequestManager r0 = getOnly(r6);
        if (r0 != null) goto L9;
        LifecycleLifecycle r1 = new LifecycleLifecycle(r6);
        RequestManager r9 = this.factory.build(r5, r1, new SupportRequestManagerTreeNode(this, r7), r4);
        this.lifecycleToRequestManager.put(r6, r9);
        r1.addListener(new AnonymousClass1(this, r6));
        if (r8 == false) goto L8;
        r9.onStart();
    L8:
        return r9;
    L9:
        return r0;
    }
}
