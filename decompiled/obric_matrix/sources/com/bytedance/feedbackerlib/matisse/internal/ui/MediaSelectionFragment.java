package com.bytedance.feedbackerlib.matisse.internal.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.feedbackerlib.e;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.k.f.a.g;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import com.bytedance.feedbackerlib.matisse.internal.model.AlbumMediaCollection;
import com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.MediaGridInset;

/* JADX INFO: loaded from: classes.dex */
public class MediaSelectionFragment extends Fragment implements AlbumMediaCollection.a, AlbumMediaAdapter.c, AlbumMediaAdapter.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AlbumMediaCollection f4396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RecyclerView f4397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AlbumMediaAdapter f4398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f4399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AlbumMediaAdapter.c f4400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AlbumMediaAdapter.e f4401k;

    public interface a {
        com.bytedance.feedbackerlib.matisse.internal.model.a c();
    }

    public MediaSelectionFragment() {
        this.f4396f = new AlbumMediaCollection();
    }

    public static MediaSelectionFragment b(Album r3) {
        MediaSelectionFragment r0 = new MediaSelectionFragment();
        Bundle r1 = new Bundle();
        r1.putParcelable("extra_album", r3);
        r0.setArguments(r1);
        return r0;
    }

    public void c() {
        this.f4398h.notifyDataSetChanged();
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.model.AlbumMediaCollection.a
    public void e() {
        this.f4398h.f(null);
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter.e
    public void f(Album r2, Item r3, int r4) {
        AlbumMediaAdapter.e r5 = this.f4401k;
        if (r5 == null) goto L6;
        r5.f((Album) getArguments().getParcelable("extra_album"), r3, r4);
        return;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.model.AlbumMediaCollection.a
    public void h(Cursor r1) {
        this.f4398h.f(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle r7) {
        super.onActivityCreated(r7);
        Album r8 = (Album) getArguments().getParcelable("extra_album");
        AlbumMediaAdapter r0 = new AlbumMediaAdapter(getContext(), this.f4399i.c(), this.f4397g);
        this.f4398h = r0;
        r0.j(this);
        this.f4398h.k(this);
        this.f4397g.setHasFixedSize(true);
        c r1 = c.b();
        if (r1.n <= 0) goto L5;
        int r2 = g.a(getContext(), r1.n);
    L6:
        this.f4397g.setLayoutManager(new GridLayoutManager(getContext(), r2));
        int r3 = getResources().getDimensionPixelSize(com.bytedance.feedbackerlib.c.n);
        this.f4397g.addItemDecoration(new MediaGridInset(r2, r3, false));
        this.f4397g.setAdapter(this.f4398h);
        this.f4396f.c(getActivity(), this);
        this.f4396f.b(r8, r1.f4355k);
        this.f4400j.onUpdate();
        return;
    L5:
        r2 = r1.m;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        super.onAttach(r2);
        if ((r2 instanceof a) == false) goto L12;
        this.f4399i = (a) r2;
        if ((r2 instanceof AlbumMediaAdapter.c) == false) goto L8;
        this.f4400j = (AlbumMediaAdapter.c) r2;
    L8:
        if ((r2 instanceof AlbumMediaAdapter.e) == false) goto L13;
        this.f4401k = (AlbumMediaAdapter.e) r2;
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Context must implement SelectionProvider.");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater r1, @Nullable ViewGroup r2, @Nullable Bundle r3) {
        return r1.inflate(f.n, r2, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4396f.d();
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter.c
    public void onUpdate() {
        AlbumMediaAdapter.c r0 = this.f4400j;
        if (r0 == null) goto L6;
        r0.onUpdate();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, @Nullable Bundle r2) {
        super.onViewCreated(r1, r2);
        this.f4397g = (RecyclerView) r1.findViewById(e.W);
    }
}
