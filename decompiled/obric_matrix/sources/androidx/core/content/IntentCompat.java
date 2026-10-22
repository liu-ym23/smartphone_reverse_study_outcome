package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class IntentCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static Intent makeMainSelectorActivity(String r0, String r1) {
            return Intent.makeMainSelectorActivity(r0, r1);
        }
    }

    private IntentCompat() {
    }

    @NonNull
    public static Intent createManageUnusedAppRestrictionsIntent(@NonNull Context r5, @NonNull String r6) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r5.getPackageManager()) == false) goto L14;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 31) goto L7;
        Intent r7 = new Intent(PackageManagerCompat.ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", r6, null));
        if (r0 < 30) goto L12;
        return r7;
    L12:
        return r7.setPackage((String) Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(r5.getPackageManager())));
    L7:
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r6, null));
    L14:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    @NonNull
    public static Intent makeMainSelectorActivity(@NonNull String r2, @NonNull String r3) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        Intent r0 = new Intent(r2);
        r0.addCategory(r3);
        return r0;
    L5:
        return Api15Impl.makeMainSelectorActivity(r2, r3);
    }
}
