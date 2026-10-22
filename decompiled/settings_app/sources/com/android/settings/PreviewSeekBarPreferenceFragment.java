package com.android.settings;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.android.settings.widget.DotsPageIndicator;
import com.android.settings.widget.LabeledSeekBar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PreviewSeekBarPreferenceFragment extends SettingsPreferenceFragment {
    protected int mActivityLayoutResId;
    protected int mCurrentIndex;
    protected String[] mEntries;
    protected int mInitialIndex;
    private TextView mLabel;
    private View mLarger;
    private DotsPageIndicator mPageIndicator;
    private ViewPager.OnPageChangeListener mPageIndicatorPageChangeListener;
    private ViewPager.OnPageChangeListener mPreviewPageChangeListener;
    private ViewPager mPreviewPager;
    private PreviewPagerAdapter mPreviewPagerAdapter;
    protected int[] mPreviewSampleResIds;
    private View mSmaller;

    private class onPreviewSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        private boolean mSeekByTouch;
        final /* synthetic */ PreviewSeekBarPreferenceFragment this$0;

        private onPreviewSeekBarChangeListener(PreviewSeekBarPreferenceFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ onPreviewSeekBarChangeListener(PreviewSeekBarPreferenceFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            PreviewSeekBarPreferenceFragment.access$000(this.this$0, r2, true);
            if (this.mSeekByTouch == true) goto L6;
            this.this$0.commit();
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r1) {
            this.mSeekByTouch = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r2) {
            if (PreviewSeekBarPreferenceFragment.access$100(this.this$0).isAnimating() == false) goto L5;
            PreviewSeekBarPreferenceFragment.access$100(this.this$0).setAnimationEndAction(new AnonymousClass1(this));
        L6:
            this.mSeekByTouch = false;
            return;
        L5:
            this.this$0.commit();
            goto L6
        }
    }

    protected abstract void commit();

    protected abstract Configuration createConfig(Configuration r1, int r2);

    public PreviewSeekBarPreferenceFragment() {
        this.mPreviewPageChangeListener = new AnonymousClass3(this);
        this.mPageIndicatorPageChangeListener = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(PreviewSeekBarPreferenceFragment r0, int r1, boolean r2) {
        r0.setPreviewLayer(r1, r2);
    }

    static /* synthetic */ PreviewPagerAdapter access$100(PreviewSeekBarPreferenceFragment r0) {
        return r0.mPreviewPagerAdapter;
    }

    static /* synthetic */ ViewPager access$300(PreviewSeekBarPreferenceFragment r0) {
        return r0.mPreviewPager;
    }

    static /* synthetic */ void access$400(PreviewSeekBarPreferenceFragment r0, int r1) {
        r0.setPagerIndicatorContentDescription(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        View r11 = super.onCreateView(r8, r9, r10);
        ViewGroup r12 = (ViewGroup) r11.findViewById(android.R.id.list_container);
        r12.removeAllViews();
        View r13 = r8.inflate(this.mActivityLayoutResId, r12, false);
        r12.addView(r13);
        this.mLabel = (TextView) r13.findViewById(R.id.current_label);
        int r14 = Math.max(1, this.mEntries.length - 1);
        final LabeledSeekBar r2 = (LabeledSeekBar) r13.findViewById(R.id.seek_bar);
        r2.setLabels(this.mEntries);
        r2.setMax(r14);
        r2.setProgress(this.mInitialIndex);
        r2.setOnSeekBarChangeListener(new onPreviewSeekBarChangeListener(this, null));
        View r15 = r13.findViewById(R.id.smaller);
        this.mSmaller = r15;
        r15.setOnClickListener(new AnonymousClass1(this, r2));
        View r16 = r13.findViewById(R.id.larger);
        this.mLarger = r16;
        r16.setOnClickListener(new AnonymousClass2(this, r2));
        if (this.mEntries.length != 1) goto L5;
        r2.setEnabled(false);
    L5:
        Context r17 = getPrefContext();
        Configuration r3 = r17.getResources().getConfiguration();
        if (r3.getLayoutDirection() != 1) goto L8;
        boolean r4 = true;
    L9:
        Configuration[] r5 = new Configuration[this.mEntries.length];
        int r6 = 0;
    L11:
        if (r6 >= this.mEntries.length) goto L13;
        r5[r6] = createConfig(r3, r6);
        r6 = r6 + 1;
        goto L11
    L13:
        this.mPreviewPager = (ViewPager) r13.findViewById(R.id.preview_pager);
        PreviewPagerAdapter r7 = new PreviewPagerAdapter(r17, r4, this.mPreviewSampleResIds, r5);
        this.mPreviewPagerAdapter = r7;
        this.mPreviewPager.setAdapter(r7);
        ViewPager r18 = this.mPreviewPager;
        if (r4 == false) goto L16;
        int r19 = this.mPreviewSampleResIds.length - 1;
    L17:
        r18.setCurrentItem(r19);
        this.mPreviewPager.addOnPageChangeListener(this.mPreviewPageChangeListener);
        DotsPageIndicator r20 = (DotsPageIndicator) r13.findViewById(R.id.page_indicator);
        this.mPageIndicator = r20;
        if (this.mPreviewSampleResIds.length <= 1) goto L20;
        r20.setViewPager(this.mPreviewPager);
        this.mPageIndicator.setVisibility(0);
        this.mPageIndicator.setOnPageChangeListener(this.mPageIndicatorPageChangeListener);
    L21:
        setPreviewLayer(this.mInitialIndex, false);
        return r11;
    L20:
        r20.setVisibility(8);
        goto L21
    L16:
        r19 = 0;
        goto L17
    L8:
        r4 = false;
        goto L9
    }

    private void setPreviewLayer(int r5, boolean r6) {
        this.mLabel.setText(this.mEntries[r5]);
        View r0 = this.mSmaller;
        boolean r1 = false;
        if (r5 <= 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setEnabled(r3);
        View r2 = this.mLarger;
        if (r5 >= (this.mEntries.length - 1)) goto L9;
        r1 = true;
    L9:
        r2.setEnabled(r1);
        setPagerIndicatorContentDescription(this.mPreviewPager.getCurrentItem());
        this.mPreviewPagerAdapter.setPreviewLayer(r5, this.mCurrentIndex, this.mPreviewPager.getCurrentItem(), r6);
        this.mCurrentIndex = r5;
        return;
    L5:
        r3 = false;
        goto L6
    }

    private void setPagerIndicatorContentDescription(int r6) {
        this.mPageIndicator.setContentDescription(getPrefContext().getString(R.string.preview_page_indicator_content_description, new Object[]{Integer.valueOf(r6 + 1), Integer.valueOf(this.mPreviewSampleResIds.length)}));
    }
}
