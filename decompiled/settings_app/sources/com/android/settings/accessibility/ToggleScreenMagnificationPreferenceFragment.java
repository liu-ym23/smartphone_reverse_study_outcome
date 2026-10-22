package com.android.settings.accessibility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleScreenMagnificationPreferenceFragment extends ToggleFeaturePreferenceFragment {
    protected VideoPreference mVideoPreference;

    protected class VideoPreference extends Preference {
        private ViewTreeObserver.OnGlobalLayoutListener mLayoutListener;
        private ImageView mVideoBackgroundView;
        final /* synthetic */ ToggleScreenMagnificationPreferenceFragment this$0;

        static /* synthetic */ ImageView access$200(VideoPreference r0) {
            return r0.mVideoBackgroundView;
        }

        public VideoPreference(ToggleScreenMagnificationPreferenceFragment r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r10) {
            super.onBindViewHolder(r10);
            Resources r0 = ToggleScreenMagnificationPreferenceFragment.access$000(this.this$0).getResources();
            final int r6 = r0.getDimensionPixelSize(R.dimen.screen_magnification_video_background_width);
            final int r5 = r0.getDimensionPixelSize(R.dimen.screen_magnification_video_width);
            final int r7 = r0.getDimensionPixelSize(R.dimen.screen_magnification_video_height);
            final int r8 = r0.getDimensionPixelSize(R.dimen.screen_magnification_video_margin_top);
            r10.setDividerAllowedAbove(false);
            r10.setDividerAllowedBelow(false);
            this.mVideoBackgroundView = (ImageView) r10.findViewById(R.id.video_background);
            final VideoView r4 = (VideoView) r10.findViewById(R.id.video);
            r4.setOnPreparedListener(new AnonymousClass1(this));
            r4.setVideoURI(Uri.parse(String.format("%s://%s/%s", new Object[]{"android.resource", ToggleScreenMagnificationPreferenceFragment.access$100(this.this$0).getPackageName(), Integer.valueOf(R.raw.accessibility_screen_magnification)})));
            r4.setMediaController(null);
            this.mLayoutListener = new AnonymousClass2(this, r4, r5, r6, r7, r8);
            this.mVideoBackgroundView.getViewTreeObserver().addOnGlobalLayoutListener(this.mLayoutListener);
        }

        @Override // androidx.preference.Preference
        protected void onPrepareForRemoval() {
            this.mVideoBackgroundView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mLayoutListener);
        }
    }

    public ToggleScreenMagnificationPreferenceFragment() {
    }

    static /* synthetic */ Context access$000(ToggleScreenMagnificationPreferenceFragment r0) {
        return r0.getPrefContext();
    }

    static /* synthetic */ Context access$100(ToggleScreenMagnificationPreferenceFragment r0) {
        return r0.getPrefContext();
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        VideoPreference r4 = new VideoPreference(this, getPrefContext());
        this.mVideoPreference = r4;
        r4.setSelectable(false);
        this.mVideoPreference.setPersistent(false);
        this.mVideoPreference.setLayoutResource(R.layout.video_preference);
        PreferenceScreen r5 = getPreferenceManager().getPreferenceScreen();
        r5.setOrderingAsAdded(false);
        this.mVideoPreference.setOrder(0);
        this.mSummaryPreference.setOrder(1);
        r5.addPreference(this.mVideoPreference);
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onPreferenceToggled(String r1, boolean r2) {
        setMagnificationEnabled(r2 ? 1 : 0);
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onInstallSwitchBarToggleSwitch() {
        super.onInstallSwitchBarToggleSwitch();
        this.mToggleSwitch.setOnBeforeCheckedChangeListener(new AnonymousClass1(this));
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_display_magnification_enabled", 0) != 0) goto L5;
        this.mSwitchBar.setCheckedInternal(false);
    L6:
        VideoView r3 = (VideoView) getView().findViewById(R.id.video);
        if (r3 == null) goto L10;
        r3.start();
        return;
    L10:
        return;
    L5:
        this.mSwitchBar.setCheckedInternal(true);
        goto L6
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mToggleSwitch.isChecked() == true) goto L6;
        setMagnificationEnabled(0);
        return;
    }

    private void setMagnificationEnabled(int r2) {
        Settings.Secure.putInt(getContentResolver(), "accessibility_display_magnification_enabled", r2);
    }

    private static int getScreenWidth(Context r1) {
        Display r2 = ((WindowManager) r1.getSystemService("window")).getDefaultDisplay();
        Point r0 = new Point();
        r2.getSize(r0);
        return r0.x;
    }
}
