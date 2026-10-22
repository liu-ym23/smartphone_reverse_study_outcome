package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    static class Api15Impl {
        private Api15Impl() {
        }

        static Intent makeMainSelectorActivity(String r0, String r1) {
            return Intent.makeMainSelectorActivity(r0, r1);
        }
    }

    private IntentCompat() {
    }

    public static Intent makeMainSelectorActivity(String r0, String r1) {
        return Api15Impl.makeMainSelectorActivity(r0, r1);
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context r2, String r3) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r2.getPackageManager()) == false) goto L7;
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r3, null));
    L7:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }
}
