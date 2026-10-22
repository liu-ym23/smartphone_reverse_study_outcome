package com.android.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsFragment extends Fragment {
    private View mContainer;
    private boolean mFirstLaunch;
    private ListView mList;
    private boolean mNeedScroll;
    private ScrollView mScroll;
    private View mTargetView;

    public SettingsFragment() {
        this.mFirstLaunch = true;
    }

    static /* synthetic */ ListView access$000(SettingsFragment r0) {
        return r0.mList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.mNeedScroll = getActivity().getIntent().getBooleanExtra("from_search", false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (this.mNeedScroll == false) goto L24;
        FragmentActivity r5 = getActivity();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.getIntent().getStringExtra("view_id") == null) goto L10;
        int r6 = Integer.parseInt(r5.getIntent().getStringExtra("view_id"));
    L11:
        this.mTargetView = r3.findViewById(r6);
        this.mScroll = (ScrollView) r3.findViewById(R.id.scroll_view);
        this.mList = (ListView) r3.findViewById(android.R.id.list);
        View r7 = this.mContainer;
        if (r7 == null) goto L14;
        this.mTargetView = r7.findViewById(r6);
    L14:
        View r8 = this.mTargetView;
        if (r8 != null) goto L17;
    L19:
        if (r8 == null) goto L26;
        ListView r9 = this.mList;
        if (r9 == null) goto L27;
        r9.getAdapter().registerDataSetObserver(new AnonymousClass2(this));
        return;
    L27:
        return;
    L26:
        return;
    L17:
        if (this.mScroll == null) goto L19;
        r8.getViewTreeObserver().addOnWindowFocusChangeListener(new AnonymousClass1(this));
        return;
    L10:
        r6 = -1;
        goto L11
    }

    public void setupContainer(View r1) {
        this.mContainer = r1;
    }

    public void scroll() {
        if (this.mFirstLaunch == true) goto L5;
        return;
    L5:
        final int[] r0 = new int[2];
        this.mTargetView.getLocationInWindow(r0);
        ScrollView r1 = this.mScroll;
        if (r1 == null) goto L8;
        r1.scrollTo(0, r0[1] - 260);
    L11:
        this.mFirstLaunch = false;
        return;
    L8:
        ListView r2 = this.mList;
        if (r2 == null) goto L11;
        r2.clearFocus();
        this.mList.postDelayed(new AnonymousClass3(this, r0), 20);
        goto L11
    }
}
