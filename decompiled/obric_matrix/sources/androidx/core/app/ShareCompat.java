package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    @RequiresApi(16)
    private static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static String escapeHtml(CharSequence r0) {
            return Html.escapeHtml(r0);
        }

        @DoNotInline
        static void migrateExtraStreamToClipData(@NonNull Intent r8, @NonNull ArrayList<Uri> r9) {
            ClipData r2 = new ClipData(null, new String[]{r8.getType()}, new ClipData.Item(r8.getCharSequenceExtra("android.intent.extra.TEXT"), r8.getStringExtra(IntentCompat.EXTRA_HTML_TEXT), null, r9.get(0)));
            int r0 = r9.size();
            int r1 = 1;
        L3:
            if (r1 >= r0) goto L5;
            r2.addItem(new ClipData.Item(r9.get(r1)));
            r1 = r1 + 1;
            goto L3
        L5:
            r8.setClipData(r2);
            r8.addFlags(1);
        }

        @DoNotInline
        static void removeClipData(@NonNull Intent r1) {
            r1.setClipData(null);
            r1.setFlags(r1.getFlags() & (-2));
        }
    }

    public static class IntentBuilder {

        @Nullable
        private ArrayList<String> mBccAddresses;

        @Nullable
        private ArrayList<String> mCcAddresses;

        @Nullable
        private CharSequence mChooserTitle;

        @NonNull
        private final Context mContext;

        @NonNull
        private final Intent mIntent;

        @Nullable
        private ArrayList<Uri> mStreams;

        @Nullable
        private ArrayList<String> mToAddresses;

        public IntentBuilder(@NonNull Context r4) {
            this.mContext = (Context) Preconditions.checkNotNull(r4);
            Intent r0 = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = r0;
            r0.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, r4.getPackageName());
            r0.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, r4.getPackageName());
            r0.addFlags(524288);
        L4:
            if ((r4 instanceof ContextWrapper) == false) goto L9;
            if ((r4 instanceof Activity) == true) goto L7;
            r4 = ((ContextWrapper) r4).getBaseContext();
            goto L4
        L7:
            Activity r5 = (Activity) r4;
        L10:
            if (r5 == null) goto L15;
            ComponentName r6 = r5.getComponentName();
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, r6);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, r6);
            return;
        L15:
            return;
        L9:
            r5 = null;
            goto L10
        }

        private void combineArrayExtra(String r5, ArrayList<String> r6) {
            String[] r0 = this.mIntent.getStringArrayExtra(r5);
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            String[] r3 = new String[r6.size() + r2];
            r6.toArray(r3);
            if (r0 == null) goto L9;
            System.arraycopy(r0, 0, r3, r6.size(), r2);
        L9:
            this.mIntent.putExtra(r5, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        private void combineArrayExtra(@Nullable String r5, @NonNull String[] r6) {
            Intent r4 = getIntent();
            String[] r0 = r4.getStringArrayExtra(r5);
            if (r0 == null) goto L5;
            int r2 = r0.length;
        L6:
            String[] r3 = new String[r6.length + r2];
            if (r0 == null) goto L9;
            System.arraycopy(r0, 0, r3, 0, r2);
        L9:
            System.arraycopy(r6, 0, r3, r2, r6.length);
            r4.putExtra(r5, r3);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        @NonNull
        @Deprecated
        public static IntentBuilder from(@NonNull Activity r1) {
            return new IntentBuilder(r1);
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String r2) {
            if (this.mBccAddresses != null) goto L5;
            this.mBccAddresses = new ArrayList();
        L5:
            this.mBccAddresses.add(r2);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] r2) {
            combineArrayExtra("android.intent.extra.BCC", r2);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String r2) {
            if (this.mCcAddresses != null) goto L5;
            this.mCcAddresses = new ArrayList();
        L5:
            this.mCcAddresses.add(r2);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] r2) {
            combineArrayExtra("android.intent.extra.CC", r2);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String r2) {
            if (this.mToAddresses != null) goto L5;
            this.mToAddresses = new ArrayList();
        L5:
            this.mToAddresses.add(r2);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] r2) {
            combineArrayExtra("android.intent.extra.EMAIL", r2);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri r2) {
            if (this.mStreams != null) goto L5;
            this.mStreams = new ArrayList();
        L5:
            this.mStreams.add(r2);
            return this;
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        @NonNull
        Context getContext() {
            return this.mContext;
        }

        @NonNull
        public Intent getIntent() {
            int r0 = Build.VERSION.SDK_INT;
            ArrayList<String> r1 = this.mToAddresses;
            if (r1 == null) goto L5;
            combineArrayExtra("android.intent.extra.EMAIL", r1);
            this.mToAddresses = null;
        L5:
            ArrayList<String> r2 = this.mCcAddresses;
            if (r2 == null) goto L8;
            combineArrayExtra("android.intent.extra.CC", r2);
            this.mCcAddresses = null;
        L8:
            ArrayList<String> r3 = this.mBccAddresses;
            if (r3 == null) goto L11;
            combineArrayExtra("android.intent.extra.BCC", r3);
            this.mBccAddresses = null;
        L11:
            ArrayList<Uri> r4 = this.mStreams;
            boolean r5 = true;
            if (r4 != null) goto L14;
        L16:
            r5 = false;
        L18:
            if (r5 == true) goto L29;
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList<Uri> r6 = this.mStreams;
            if (r6 != null) goto L22;
        L26:
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            if (r0 < 16) goto L33;
            Api16Impl.removeClipData(this.mIntent);
        L33:
            return this.mIntent;
        L22:
            if (r6.isEmpty() == true) goto L26;
            this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
            if (r0 < 16) goto L33;
        L31:
            Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            goto L33
        L29:
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            if (r0 < 16) goto L33;
        L14:
            if (r4.size() <= 1) goto L16;
            goto L16
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int r2) {
            return setChooserTitle(this.mContext.getText(r2));
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence r1) {
            this.mChooserTitle = r1;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] r3) {
            this.mIntent.putExtra("android.intent.extra.BCC", r3);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] r3) {
            this.mIntent.putExtra("android.intent.extra.CC", r3);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] r3) {
            if (this.mToAddresses == null) goto L5;
            this.mToAddresses = null;
        L5:
            this.mIntent.putExtra("android.intent.extra.EMAIL", r3);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String r3) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, r3);
            if (this.mIntent.hasExtra("android.intent.extra.TEXT") == true) goto L5;
            setText(Html.fromHtml(r3));
        L5:
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri r2) {
            this.mStreams = null;
            if (r2 == null) goto L5;
            addStream(r2);
        L5:
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String r3) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", r3);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence r3) {
            this.mIntent.putExtra("android.intent.extra.TEXT", r3);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String r2) {
            this.mIntent.setType(r2);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";

        @Nullable
        private final ComponentName mCallingActivity;

        @Nullable
        private final String mCallingPackage;

        @NonNull
        private final Context mContext;

        @NonNull
        private final Intent mIntent;

        @Nullable
        private ArrayList<Uri> mStreams;

        public IntentReader(@NonNull Activity r2) {
            this((Context) Preconditions.checkNotNull(r2), r2.getIntent());
        }

        public IntentReader(@NonNull Context r1, @NonNull Intent r2) {
            this.mContext = (Context) Preconditions.checkNotNull(r1);
            this.mIntent = (Intent) Preconditions.checkNotNull(r2);
            this.mCallingPackage = ShareCompat.getCallingPackage(r2);
            this.mCallingActivity = ShareCompat.getCallingActivity(r2);
        }

        @NonNull
        @Deprecated
        public static IntentReader from(@NonNull Activity r1) {
            return new IntentReader(r1);
        }

        private static void withinStyle(StringBuilder r3, CharSequence r4, int r5, int r6) {
        L2:
            if (r5 >= r6) goto L28;
            char r0 = r4.charAt(r5);
            if (r0 != '<') goto L8;
            String r1 = "&lt;";
        L6:
            r3.append(r1);
        L27:
            r5 = r5 + 1;
            goto L2
        L8:
            if (r0 != '>') goto L11;
            r1 = "&gt;";
            goto L6
        L11:
            if (r0 != '&') goto L14;
            r1 = "&amp;";
            goto L6
        L14:
            if (r0 <= '~') goto L16;
        L26:
            r3.append("&#");
            r3.append(r0);
            r1 = ";";
            goto L6
        L16:
            if (r0 < ' ') goto L26;
            if (r0 != ' ') goto L25;
        L19:
            int r2 = r5 + 1;
            if (r2 >= r6) goto L24;
            if (r4.charAt(r2) != ' ') goto L24;
            r3.append("&nbsp;");
            r5 = r2;
        L24:
            r3.append(' ');
            goto L27
        L25:
            r3.append(r0);
            goto L27
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getActivityIcon(this.mCallingActivity);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling activity", e);
            return null;
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getApplicationIcon(this.mCallingPackage);
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve icon for calling application", e);
            return null;
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage != null) goto L5;
            return null;
        L5:
            PackageManager r0 = this.mContext.getPackageManager();
            return r0.getApplicationLabel(r0.getApplicationInfo(this.mCallingPackage, 0));
        L8:
            e = move-exception;
            Log.e(TAG, "Could not retrieve label for calling application", e);
            return null;
        }

        @Nullable
        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String r0 = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (r0 != null) goto L13;
            CharSequence r3 = getText();
            if ((r3 instanceof Spanned) == true) goto L14;
            if (r3 != null) goto L9;
            return r0;
        L9:
            if (Build.VERSION.SDK_INT >= 16) goto L16;
            StringBuilder r1 = new StringBuilder();
            withinStyle(r1, r3, 0, r3.length());
            return r1.toString();
        L16:
            return Api16Impl.escapeHtml(r3);
        L14:
            return Html.toHtml((Spanned) r3);
        L13:
            return r0;
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        @Nullable
        public Uri getStream(int r4) {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r0 = this.mStreams;
            if (r0 == null) goto L12;
            Object r3 = r0.get(r4);
        L11:
            return (Uri) r3;
        L12:
            if (r4 != 0) goto L15;
            r3 = this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            goto L11
        L15:
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + r4);
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        public int getStreamCount() {
            if (this.mStreams == null) goto L5;
        L7:
            ArrayList<Uri> r0 = this.mStreams;
            if (r0 == null) goto L12;
            return r0.size();
        L12:
            return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        L5:
            if (isMultipleShare() == false) goto L7;
            this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            goto L7
        }

        @Nullable
        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String r1 = this.mIntent.getAction();
            if ("android.intent.action.SEND".equals(r1) == false) goto L5;
        L8:
            return true;
        L5:
            if ("android.intent.action.SEND_MULTIPLE".equals(r1) == true) goto L8;
            return false;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    private ShareCompat() {
    }

    @Deprecated
    public static void configureMenuItem(@NonNull Menu r1, @IdRes int r2, @NonNull IntentBuilder r3) {
        MenuItem r4 = r1.findItem(r2);
        if (r4 == null) goto L7;
        configureMenuItem(r4, r3);
        return;
    L7:
        throw new IllegalArgumentException("Could not find menu item with id " + r2 + " in the supplied menu");
    }

    @Deprecated
    public static void configureMenuItem(@NonNull MenuItem r3, @NonNull IntentBuilder r4) {
        ActionProvider r0 = r3.getActionProvider();
        if ((r0 instanceof ShareActionProvider) == true) goto L5;
        ShareActionProvider r1 = new ShareActionProvider(r4.getContext());
    L6:
        r1.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + r4.getContext().getClass().getName());
        r1.setShareIntent(r4.getIntent());
        r3.setActionProvider(r1);
        if (Build.VERSION.SDK_INT < 16) goto L9;
        return;
    L9:
        if (r3.hasSubMenu() == true) goto L13;
        r3.setIntent(r4.createChooserIntent());
        return;
    L13:
        return;
    L5:
        r1 = (ShareActionProvider) r0;
        goto L6
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity r1) {
        Intent r0 = r1.getIntent();
        ComponentName r2 = r1.getCallingActivity();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return getCallingActivity(r0);
    }

    @Nullable
    static ComponentName getCallingActivity(@NonNull Intent r1) {
        ComponentName r0 = (ComponentName) r1.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ComponentName) r1.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity r1) {
        Intent r0 = r1.getIntent();
        String r2 = r1.getCallingPackage();
        if (r2 != null) goto L7;
        if (r0 != null) goto L6;
        return r2;
    L6:
        return getCallingPackage(r0);
    L7:
        return r2;
    }

    @Nullable
    static String getCallingPackage(@NonNull Intent r1) {
        String r0 = r1.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
    }
}
