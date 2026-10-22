package obric.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public final class FeedbackLauncher {
    private static final String CLS_FEEDBACK_ACTIVITY = "com.obric.feedback.activity.FeedbackActivity";
    private static final String CLS_FEEDBACK_ENTRY_ACTIVITY = "com.obric.feedbackserviceproject.FeedbackEntryActivity";
    private static final String PKG_FEEDBACK = "com.obric.feedback";
    private static final String PKG_FEEDBACK_SHELL = "com.obric.feedbackserviceproject";

    public interface IntentExtender {
        void extend(Intent r1);
    }

    private FeedbackLauncher() {
    }

    public static boolean startFeedback(Context r1) {
        return startFeedback(r1, null, null);
    }

    public static boolean startFeedback(Context r1, Bundle r2) {
        return startFeedback(r1, r2, null);
    }

    public static boolean startFeedback(Context r3, Bundle r4, IntentExtender r5) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (startActivitySafely(r3, buildFeedbackIntent(new ComponentName(PKG_FEEDBACK_SHELL, CLS_FEEDBACK_ENTRY_ACTIVITY), r4, r5)) == false) goto L10;
        return true;
    L10:
        return startActivitySafely(r3, buildFeedbackIntent(new ComponentName("com.obric.feedback", CLS_FEEDBACK_ACTIVITY), r4, r5));
    }

    public static Intent buildFeedbackIntent(Context r1) {
        return buildFeedbackIntent(r1, null, null);
    }

    public static Intent buildFeedbackIntent(Context r1, Bundle r2) {
        return buildFeedbackIntent(r1, r2, null);
    }

    public static Intent buildFeedbackIntent(Context r0, Bundle r1, IntentExtender r2) {
        return buildFeedbackIntent(resolveFeedbackComponent(r0), r1, r2);
    }

    private static Intent buildFeedbackIntent(ComponentName r1, Bundle r2, IntentExtender r3) {
        Intent r0 = new Intent();
        r0.setComponent(r1);
        if (r2 == null) goto L5;
        r0.putExtras(r2);
    L5:
        if (r3 == null) goto L7;
        r3.extend(r0);
    L7:
        r0.setComponent(r1);
        r0.addFlags(872415232);
        return r0;
    }

    private static boolean startActivitySafely(Context r0, Intent r1) {
        r0.startActivity(r1);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    private static ComponentName resolveFeedbackComponent(Context r2) {
        if (isPackageInstalled(r2, PKG_FEEDBACK_SHELL) == false) goto L7;
        return new ComponentName(PKG_FEEDBACK_SHELL, CLS_FEEDBACK_ENTRY_ACTIVITY);
    L7:
        return new ComponentName("com.obric.feedback", CLS_FEEDBACK_ACTIVITY);
    }

    private static boolean isPackageInstalled(Context r2, String r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        if (r3.length() == 0) goto L11;
        r2.getPackageManager().getPackageInfo(r3, 0);     // Catch: Exception -> L12
        return true;
    L11:
        return false;
    }
}
