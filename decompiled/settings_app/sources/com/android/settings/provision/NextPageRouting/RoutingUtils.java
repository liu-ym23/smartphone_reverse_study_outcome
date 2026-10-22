package com.android.settings.provision.NextPageRouting;

import android.app.Activity;
import android.content.Intent;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoutingUtils {
    private static final INextHandler sNextToAccountHandler = null;
    private static final INextHandler sNextToCloud = null;
    private static final INextHandler sNextToFaceHandler = null;
    private static final INextHandler sNextToPasswordHandler = null;

    public RoutingUtils() {
    }

    public static void startActivityDefault(Activity r0, Intent r1, int r2) {
        r0.startActivityForResult(r1, r2);
        r0.overridePendingTransition(R.anim.slide_in_from_right, 0);
    }

    public static void startActivityDefault2(Activity r0, Intent r1, int r2) {
        r0.startActivityForResult(r1, r2);
        r0.overridePendingTransition(R.anim.slide_in_from_right2, 0);
    }

    public static void startActivityFade(Activity r0, Intent r1, int r2) {
        r0.startActivityForResult(r1, r2);
        r0.overridePendingTransition(R.anim.activity_fade_in, 0);
    }

    public static void finishActivityDefault(Activity r2) {
        r2.finish();
        r2.overridePendingTransition(0, R.anim.slide_out_to_left);
    }

    public static void overrideStarting(Activity r2) {
        r2.overridePendingTransition(R.anim.slide_in_from_right, 0);
    }

    static {
        sNextToCloud = new NextHandlerBase.NextToCloud();
        sNextToAccountHandler = initNextToAccount();
        sNextToPasswordHandler = initNextToPassword();
        sNextToFaceHandler = initNextToFace();
    }

    private static INextHandler initNextToAccount() {
        NextHandlerBase.NextToAccount r0 = new NextHandlerBase.NextToAccount();
        r0.setNext(sNextToCloud);
        return r0;
    }

    private static INextHandler initNextToPassword() {
        NextHandlerBase.NextToPassword r0 = new NextHandlerBase.NextToPassword();
        r0.setNext(sNextToAccountHandler);
        return r0;
    }

    private static INextHandler initNextToFace() {
        NextHandlerBase.NextToFace r0 = new NextHandlerBase.NextToFace();
        r0.setNext(sNextToPasswordHandler);
        return r0;
    }

    public static void nextToFace(Activity r1) {
        sNextToFaceHandler.handleNextPage(r1);
    }

    public static void nextToPassword(Activity r1) {
        sNextToPasswordHandler.handleNextPage(r1);
    }

    public static void nextToAccount(Activity r1) {
        sNextToAccountHandler.handleNextPage(r1);
    }
}
