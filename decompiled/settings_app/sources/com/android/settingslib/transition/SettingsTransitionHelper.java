package com.android.settingslib.transition;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class SettingsTransitionHelper {
    public static final String EXTRA_PAGE_TRANSITION_TYPE = "page_transition_type";
    private static final String TAG = "SettingsTransitionHelper";

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionType {
        public static final int TRANSITION_FADE = 2;
        public static final int TRANSITION_NONE = -1;
        public static final int TRANSITION_SHARED_AXIS = 0;
        public static final int TRANSITION_SLIDE = 1;
    }

    public static void applyBackwardTransition(Activity r0) {
    }

    public static void applyBackwardTransition(Fragment r0) {
    }

    public static void applyForwardTransition(Activity r0) {
    }

    public static void applyForwardTransition(Fragment r0) {
    }

    public SettingsTransitionHelper() {
    }
}
