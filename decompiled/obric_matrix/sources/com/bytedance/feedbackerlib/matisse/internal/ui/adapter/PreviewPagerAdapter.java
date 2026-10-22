package com.bytedance.feedbackerlib.matisse.internal.ui.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.ui.PreviewItemFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PreviewPagerAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Item> f4415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4416b;

    interface a {
        void a(int r1);
    }

    public PreviewPagerAdapter(FragmentManager r1, a r2) {
        super(r1);
        this.f4415a = new ArrayList();
        this.f4416b = r2;
    }

    public void a(List<Item> r1) {
        this.f4415a.addAll(r1);
    }

    public Item b(int r2) {
        if (this.f4415a.size() > r2) goto L5;
        return null;
    L5:
        return this.f4415a.get(r2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f4415a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int r1) {
        return PreviewItemFragment.c(this.f4415a.get(r1));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object r1) {
        return this.f4415a.indexOf(r1);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r1, int r2, Object r3) {
        super.setPrimaryItem(r1, r2, r3);
        a r0 = this.f4416b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
