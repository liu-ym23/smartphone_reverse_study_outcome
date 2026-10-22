package com.bytedance.feedbackerlib.matisse.internal.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.bytedance.feedbackerlib.matisse.internal.loader.AlbumLoader;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AlbumCollection implements LoaderManager.LoaderCallbacks<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f4367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoaderManager f4368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4371e;

    public interface a {
        void b();

        void d(Cursor r1);
    }

    public AlbumCollection() {
    }

    public int a() {
        return this.f4370d;
    }

    public void b() {
        this.f4368b.initLoader(1, null, this);
    }

    public void c(FragmentActivity r2, a r3) {
        this.f4367a = new WeakReference(r2);
        this.f4368b = r2.getSupportLoaderManager();
        this.f4369c = r3;
    }

    public void d() {
        LoaderManager r0 = this.f4368b;
        if (r0 == null) goto L5;
        r0.destroyLoader(1);
    L5:
        this.f4369c = null;
    }

    public void e(Loader<Cursor> r1, Cursor r2) {
        if (this.f4367a.get() != null) goto L6;
        return;
    L6:
        if (this.f4371e == true) goto L9;
        this.f4371e = true;
        this.f4369c.d(r2);
        return;
    }

    public void f(Bundle r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f4370d = r2.getInt("state_current_selection");
    }

    public void g(Bundle r2) {
        r2.putInt("state_current_selection", this.f4370d);
    }

    public void h(int r1) {
        this.f4370d = r1;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int r1, Bundle r2) {
        Context r3 = this.f4367a.get();
        if (r3 != null) goto L6;
        return null;
    L6:
        this.f4371e = false;
        return AlbumLoader.e(r3);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        e(r1, r2);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> r1) {
        if (this.f4367a.get() != null) goto L5;
        return;
    L5:
        this.f4369c.b();
    }
}
