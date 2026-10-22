package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ReportFragment extends Fragment {
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener mProcessListener;

    interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }

        LifecycleCallbacks() {
        }

        static void registerIn(Activity r1) {
            r1.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity r1, Bundle r2) {
            ReportFragment.dispatch(r1, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity r1) {
            ReportFragment.dispatch(r1, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity r1) {
            ReportFragment.dispatch(r1, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity r1) {
            ReportFragment.dispatch(r1, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity r1) {
            ReportFragment.dispatch(r1, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity r1) {
            ReportFragment.dispatch(r1, Lifecycle.Event.ON_DESTROY);
        }
    }

    private void dispatch(Lifecycle.Event r1) {
    }

    public ReportFragment() {
    }

    public static void injectIfNeededIn(Activity r3) {
        LifecycleCallbacks.registerIn(r3);
        FragmentManager r4 = r3.getFragmentManager();
        if (r4.findFragmentByTag(REPORT_FRAGMENT_TAG) != null) goto L6;
        r4.beginTransaction().add(new ReportFragment(), REPORT_FRAGMENT_TAG).commit();
        r4.executePendingTransactions();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void dispatch(Activity r1, Lifecycle.Event r2) {
        if ((r1 instanceof LifecycleRegistryOwner) == false) goto L7;
        ((LifecycleRegistryOwner) r1).getLifecycle().handleLifecycleEvent(r2);
        return;
    L7:
        if ((r1 instanceof LifecycleOwner) == false) goto L12;
        Lifecycle r3 = ((LifecycleOwner) r1).getLifecycle();
        if ((r3 instanceof LifecycleRegistry) == false) goto L13;
        ((LifecycleRegistry) r3).handleLifecycleEvent(r2);
        return;
    L13:
        return;
    }

    static ReportFragment get(Activity r1) {
        return (ReportFragment) r1.getFragmentManager().findFragmentByTag(REPORT_FRAGMENT_TAG);
    }

    private void dispatchCreate(ActivityInitializationListener r1) {
        if (r1 == null) goto L5;
        r1.onCreate();
        return;
    }

    private void dispatchStart(ActivityInitializationListener r1) {
        if (r1 == null) goto L5;
        r1.onStart();
        return;
    }

    private void dispatchResume(ActivityInitializationListener r1) {
        if (r1 == null) goto L5;
        r1.onResume();
        return;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        dispatchCreate(this.mProcessListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        dispatchStart(this.mProcessListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        dispatchResume(this.mProcessListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.mProcessListener = null;
    }

    void setProcessListener(ActivityInitializationListener r1) {
        this.mProcessListener = r1;
    }
}
