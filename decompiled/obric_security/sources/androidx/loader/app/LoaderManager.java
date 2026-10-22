package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        Loader<D> onCreateLoader(int r1, Bundle r2);

        void onLoadFinished(Loader<D> r1, D r2);

        void onLoaderReset(Loader<D> r1);
    }

    public abstract void destroyLoader(int r1);

    @Deprecated
    public abstract void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4);

    public abstract <D> Loader<D> getLoader(int r1);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract <D> Loader<D> initLoader(int r1, Bundle r2, LoaderCallbacks<D> r3);

    public abstract void markForRedelivery();

    public abstract <D> Loader<D> restartLoader(int r1, Bundle r2, LoaderCallbacks<D> r3);

    public LoaderManager() {
    }

    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(T r2) {
        return new LoaderManagerImpl(r2, r2.getViewModelStore());
    }

    public static void enableDebugLogging(boolean r0) {
        LoaderManagerImpl.DEBUG = r0;
    }
}
