package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        @NonNull
        @MainThread
        Loader<D> onCreateLoader(int r1, @Nullable Bundle r2);

        @MainThread
        void onLoadFinished(@NonNull Loader<D> r1, D r2);

        @MainThread
        void onLoaderReset(@NonNull Loader<D> r1);
    }

    public LoaderManager() {
    }

    public static void enableDebugLogging(boolean r0) {
        LoaderManagerImpl.DEBUG = r0;
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(@NonNull T r2) {
        return new LoaderManagerImpl(r2, r2.getViewModelStore());
    }

    @MainThread
    public abstract void destroyLoader(int r1);

    @Deprecated
    public abstract void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4);

    @Nullable
    public abstract <D> Loader<D> getLoader(int r1);

    public boolean hasRunningLoaders() {
        return false;
    }

    @NonNull
    @MainThread
    public abstract <D> Loader<D> initLoader(int r1, @Nullable Bundle r2, @NonNull LoaderCallbacks<D> r3);

    public abstract void markForRedelivery();

    @NonNull
    @MainThread
    public abstract <D> Loader<D> restartLoader(int r1, @Nullable Bundle r2, @NonNull LoaderCallbacks<D> r3);
}
