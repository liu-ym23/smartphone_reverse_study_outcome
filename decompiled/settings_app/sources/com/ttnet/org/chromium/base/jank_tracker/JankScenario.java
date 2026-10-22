package com.ttnet.org.chromium.base.jank_tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface JankScenario {
    public static final int NEW_TAB_PAGE = 3;
    public static final int OMNIBOX_FOCUS = 2;
    public static final int OPEN_LINK_IN_NEW_TAB = 6;
    public static final int PERIODIC_REPORTING = 1;
    public static final int STARTUP = 4;
    public static final int START_SURFACE_HOMEPAGE = 7;
    public static final int START_SURFACE_TAB_SWITCHER = 8;
    public static final int TAB_SWITCHER = 5;
}
