package com.bumptech.glide.manager;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = null;
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final FrameWaiter frameWaiter;
    private final LifecycleRequestManagerRetriever lifecycleRequestManagerRetriever;
    private final ArrayMap<View, Fragment> tempViewToSupportFragment;

    public interface RequestManagerFactory {
        RequestManager build(Glide r1, Lifecycle r2, RequestManagerTreeNode r3, Context r4);
    }

    @Override // android.os.Handler.Callback
    @Deprecated
    public boolean handleMessage(Message r1) {
        return false;
    }

    public RequestManagerRetriever(RequestManagerFactory r2) {
        this.tempViewToSupportFragment = new ArrayMap();
        if (r2 != null) goto L6;
        r2 = DEFAULT_FACTORY;
    L6:
        this.factory = r2;
        this.lifecycleRequestManagerRetriever = new LifecycleRequestManagerRetriever(r2);
        this.frameWaiter = buildFrameWaiter();
    }

    private static FrameWaiter buildFrameWaiter() {
        if (HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED == false) goto L10;
        if (HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED == false) goto L10;
        return new FirstFrameWaiter();
    L10:
        return new DoNothingFirstFrameWaiter();
    }

    private RequestManager getApplicationManager(Context r5) {
        if (this.applicationManager != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.applicationManager != null) goto L8;
        Glide r0 = Glide.get(r5.getApplicationContext());     // Catch: Throwable -> L10
        this.applicationManager = this.factory.build(r0, new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), r5.getApplicationContext());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.applicationManager;
    }

    public RequestManager get(Context r3) {
        if (r3 == null) goto L20;
        if (Util.isOnMainThread() == false) goto L18;
        if ((r3 instanceof Application) == true) goto L18;
        if ((r3 instanceof FragmentActivity) == false) goto L12;
        return get((FragmentActivity) r3);
    L12:
        if ((r3 instanceof ContextWrapper) == false) goto L18;
        ContextWrapper r0 = (ContextWrapper) r3;
        if (r0.getBaseContext().getApplicationContext() == null) goto L18;
        return get(r0.getBaseContext());
    L18:
        return getApplicationManager(r3);
    L20:
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager get(FragmentActivity r8) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        assertNotDestroyed(r8);
        this.frameWaiter.registerSelf(r8);
        boolean r6 = isActivityVisible(r8);
        Glide r3 = Glide.get(r8.getApplicationContext());
        return this.lifecycleRequestManagerRetriever.getOrCreate(r8, r3, r8.getLifecycle(), r8.getSupportFragmentManager(), r6);
    L5:
        return get(r8.getApplicationContext());
    }

    public RequestManager get(Fragment r9) {
        Preconditions.checkNotNull(r9.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread() == false) goto L7;
        return get(r9.getContext().getApplicationContext());
    L7:
        if (r9.getActivity() == null) goto L9;
        this.frameWaiter.registerSelf(r9.getActivity());
    L9:
        FragmentManager r6 = r9.getChildFragmentManager();
        Context r3 = r9.getContext();
        Glide r4 = Glide.get(r3.getApplicationContext());
        return this.lifecycleRequestManagerRetriever.getOrCreate(r3, r4, r9.getLifecycle(), r6, r9.isVisible());
    }

    @Deprecated
    public RequestManager get(Activity r1) {
        return get(r1.getApplicationContext());
    }

    public RequestManager get(View r3) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r3.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity r0 = findActivity(r3.getContext());
        if (r0 != null) goto L11;
        return get(r3.getContext().getApplicationContext());
    L11:
        if ((r0 instanceof FragmentActivity) == false) goto L18;
        FragmentActivity r1 = (FragmentActivity) r0;
        Fragment r4 = findSupportFragment(r3, r1);
        if (r4 == null) goto L16;
        return get(r4);
    L16:
        return get(r1);
    L18:
        return get(r3.getContext().getApplicationContext());
    L5:
        return get(r3.getContext().getApplicationContext());
    }

    private static void findAllSupportFragmentsWithViews(Collection<Fragment> r2, Map<View, Fragment> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        Iterator<Fragment> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L13;
        Fragment r0 = r4.next();
        if (r0 == null) goto L6;
        if (r0.getView() == null) goto L6;
        r3.put(r0.getView(), r0);
        findAllSupportFragmentsWithViews(r0.getChildFragmentManager().getFragments(), r3);
        goto L6
    }

    private Fragment findSupportFragment(View r3, FragmentActivity r4) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(r4.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        View r5 = r4.findViewById(R.id.content);
        Fragment r0 = null;
    L4:
        if (r3.equals(r5) == true) goto L11;
        r0 = this.tempViewToSupportFragment.get(r3);
        if (r0 != null) goto L11;
        if ((r3.getParent() instanceof View) == false) goto L11;
        r3 = (View) r3.getParent();
    L11:
        this.tempViewToSupportFragment.clear();
        return r0;
    }

    private static Activity findActivity(Context r1) {
        if ((r1 instanceof Activity) == false) goto L7;
        return (Activity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return findActivity(((ContextWrapper) r1).getBaseContext());
    }

    private static void assertNotDestroyed(Activity r1) {
        if (r1.isDestroyed() == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @Deprecated
    public RequestManager get(android.app.Fragment r2) {
        if (r2.getActivity() == null) goto L7;
        return get(r2.getActivity().getApplicationContext());
    L7:
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    private static boolean isActivityVisible(Context r0) {
        Activity r1 = findActivity(r0);
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.isFinishing() == false) goto L8;
        return false;
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }
}
