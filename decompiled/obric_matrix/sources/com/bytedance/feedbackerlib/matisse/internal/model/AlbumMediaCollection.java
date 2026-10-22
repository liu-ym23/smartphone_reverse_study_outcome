package com.bytedance.feedbackerlib.matisse.internal.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.loader.AlbumMediaLoader;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AlbumMediaCollection implements LoaderManager.LoaderCallbacks<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f4372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoaderManager f4373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4374c;

    public interface a {
        void e();

        void h(Cursor r1);
    }

    public AlbumMediaCollection() {
    }

    public void a(@Nullable Album r2) {
        b(r2, false);
    }

    public void b(@Nullable Album r3, boolean r4) {
        Bundle r0 = new Bundle();
        r0.putParcelable("args_album", r3);
        r0.putBoolean("args_enable_capture", r4);
        this.f4373b.initLoader(2, r0, this);
    }

    public void c(@NonNull FragmentActivity r2, @NonNull a r3) {
        this.f4372a = new WeakReference(r2);
        this.f4373b = r2.getSupportLoaderManager();
        this.f4374c = r3;
    }

    public void d() {
        LoaderManager r0 = this.f4373b;
        if (r0 == null) goto L5;
        r0.destroyLoader(2);
    L5:
        this.f4374c = null;
    }

    public void e(Loader<Cursor> r1, Cursor r2) {
        if (this.f4372a.get() != null) goto L5;
        return;
    L5:
        this.f4374c.h(r2);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int r3, Bundle r4) {
        Context r2 = this.f4372a.get();
        if (r2 != null) goto L5;
        return null;
    L5:
        Album r0 = (Album) r4.getParcelable("args_album");
        if (r0 != null) goto L8;
        return null;
    L8:
        boolean r1 = false;
        if (r0.h() == false) goto L14;
        if (r4.getBoolean("args_enable_capture", false) == false) goto L14;
        r1 = true;
    L14:
        return AlbumMediaLoader.f(r2, r0, r1);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        e(r1, r2);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> r1) {
        if (this.f4372a.get() != null) goto L5;
        return;
    L5:
        this.f4374c.e();
    }
}
