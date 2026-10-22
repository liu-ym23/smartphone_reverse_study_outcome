package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProviders {

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application r1) {
            super(r1);
        }
    }

    @Deprecated
    public ViewModelProviders() {
    }

    private static Application checkApplication(Activity r1) {
        Application r2 = r1.getApplication();
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    private static Activity checkActivity(Fragment r1) {
        FragmentActivity r2 = r1.getActivity();
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    public static ViewModelProvider of(Fragment r1) {
        return of(r1, null);
    }

    public static ViewModelProvider of(FragmentActivity r1) {
        return of(r1, null);
    }

    public static ViewModelProvider of(Fragment r1, ViewModelProvider.Factory r2) {
        Application r0 = checkApplication(checkActivity(r1));
        if (r2 != null) goto L6;
        r2 = ViewModelProvider.AndroidViewModelFactory.getInstance(r0);
    L6:
        return new ViewModelProvider(r1.getViewModelStore(), r2);
    }

    public static ViewModelProvider of(FragmentActivity r1, ViewModelProvider.Factory r2) {
        Application r0 = checkApplication(r1);
        if (r2 != null) goto L6;
        r2 = ViewModelProvider.AndroidViewModelFactory.getInstance(r0);
    L6:
        return new ViewModelProvider(r1.getViewModelStore(), r2);
    }
}
