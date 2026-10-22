package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.ss.android.http.legacy.protocol.HTTP;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    public static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        public OreoCallback(ActionMode.Callback r1, TextView r2) {
            this.mCallback = r1;
            this.mTextView = r2;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(HTTP.PLAIN_TEXT_TYPE);
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r2, TextView r3) {
            Intent r1 = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r3));
            ActivityInfo r4 = r2.activityInfo;
            return r1.setClassName(r4.packageName, r4.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context r4, PackageManager r5) {
            ArrayList r0 = new ArrayList();
            if ((r4 instanceof Activity) == true) goto L5;
            return r0;
        L5:
            Iterator<ResolveInfo> r6 = r5.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r6.hasNext() == false) goto L11;
            ResolveInfo r1 = r6.next();
            if (isSupportedActivity(r1, r4) == false) goto L7;
            r0.add(r1);
            goto L7
        L11:
            return r0;
        }

        private boolean isEditable(TextView r1) {
            if ((r1 instanceof Editable) == true) goto L5;
        L9:
            return false;
        L5:
            if (r1.onCheckIsTextEditor() == false) goto L9;
            if (r1.isEnabled() == false) goto L9;
            return true;
        }

        private boolean isSupportedActivity(ResolveInfo r3, Context r4) {
            if (r4.getPackageName().equals(r3.activityInfo.packageName) == false) goto L5;
            return true;
        L5:
            ActivityInfo r2 = r3.activityInfo;
            if (r2.exported == true) goto L8;
            return false;
        L8:
            String r5 = r2.permission;
            if (r5 != null) goto L11;
            return true;
        L11:
            if (r4.checkSelfPermission(r5) != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private void recomputeProcessTextMenuItems(Menu r9) {
            Context r0 = this.mTextView.getContext();
            PackageManager r1 = r0.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L28;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r2 = Class.forName("com.android.internal.view.menu.MenuBuilder");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r2;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r2.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L28:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r3 = r9.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r4 = r9.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r4 < 0) goto L22;
            MenuItem r6 = r9.getItem(r4);     // Catch: Throwable -> L27
            if (r6.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r6.getIntent().getAction()) == false) goto L21;
            r3.invoke(r9, new Object[]{Integer.valueOf(r4)});     // Catch: Throwable -> L27
        L21:
            r4 = r4 - 1;
            goto L15
        L22:
            List<ResolveInfo> r5 = getSupportedActivities(r0, r1);
            int r7 = 0;
        L24:
            if (r7 >= r5.size()) goto L37;
            ResolveInfo r8 = r5.get(r7);
            r9.add(0, 0, r7 + 100, r8.loadLabel(r1)).setIntent(createProcessTextIntentForResolveInfo(r8, this.mTextView)).setShowAsAction(1);
            r7 = r7 + 1;
            goto L24
        L37:
            return;
        L11:
            if (this.mMenuBuilderClass.isInstance(r9) == false) goto L13;
            r3 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return this.mCallback.onActionItemClicked(r1, r2);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return this.mCallback.onCreateActionMode(r1, r2);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r1) {
            this.mCallback.onDestroyActionMode(r1);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r1, Menu r2) {
            recomputeProcessTextMenuItems(r2);
            return this.mCallback.onPrepareActionMode(r1, r2);
        }
    }

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(@NonNull TextView r0) {
        return r0.getAutoSizeMaxTextSize();
    }

    public static int getAutoSizeMinTextSize(@NonNull TextView r0) {
        return r0.getAutoSizeMinTextSize();
    }

    public static int getAutoSizeStepGranularity(@NonNull TextView r0) {
        return r0.getAutoSizeStepGranularity();
    }

    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView r0) {
        return r0.getAutoSizeTextAvailableSizes();
    }

    public static int getAutoSizeTextType(@NonNull TextView r0) {
        return r0.getAutoSizeTextType();
    }

    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView r0) {
        Preconditions.checkNotNull(r0);
        return r0.getCompoundDrawableTintList();
    }

    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView r0) {
        Preconditions.checkNotNull(r0);
        return r0.getCompoundDrawableTintMode();
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView r0) {
        return r0.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView r1) {
        return r1.getPaddingTop() - r1.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView r1) {
        return r1.getPaddingBottom() + r1.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@NonNull TextView r0) {
        return r0.getMaxLines();
    }

    public static int getMinLines(@NonNull TextView r0) {
        return r0.getMinLines();
    }

    @RequiresApi(18)
    private static int getTextDirection(@NonNull TextDirectionHeuristic r4) {
        TextDirectionHeuristic r0 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (r4 != r0) goto L5;
        return 1;
    L5:
        TextDirectionHeuristic r2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (r4 != r2) goto L9;
        return 1;
    L9:
        if (r4 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r4 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r4 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r4 != TextDirectionHeuristics.LOCALE) goto L24;
        return 5;
    L24:
        if (r4 != r2) goto L27;
        return 6;
    L27:
        if (r4 != r0) goto L30;
        return 7;
    L30:
        return 1;
    }

    @RequiresApi(18)
    private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView r4) {
        if ((r4.getTransformationMethod() instanceof PasswordTransformationMethod) == true) goto L5;
        boolean r2 = true;
        if ((r4.getInputType() & 15) != 3) goto L18;
        byte r5 = Character.getDirectionality(DecimalFormatSymbols.getInstance(r4.getTextLocale()).getDigitStrings()[0].codePointAt(0));
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L16;
        return TextDirectionHeuristics.LTR;
    L16:
        return TextDirectionHeuristics.RTL;
    L18:
        if (r4.getLayoutDirection() == 1) goto L22;
        r2 = false;
    L22:
        switch(r4.getTextDirection()) {
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L28;
            default: goto L23;
        };
    L23:
        if (r2 == false) goto L26;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L26:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L28:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L30:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L32:
        return TextDirectionHeuristics.LOCALE;
    L34:
        return TextDirectionHeuristics.RTL;
    L36:
        return TextDirectionHeuristics.LTR;
    L38:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L5:
        return TextDirectionHeuristics.LTR;
    }

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView r1) {
        return new PrecomputedTextCompat.Params(r1.getTextMetricsParams());
    }

    private static Field retrieveField(String r3) {
        Field r0 = null;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r0;
    L5:
        Log.e(LOG_TAG, "Could not retrieve " + r3 + " field.");
        return r0;
    }

    private static int retrieveIntFromField(Field r1, TextView r2) {
        return r1.getInt(r2);
    L4:
        Log.d(LOG_TAG, "Could not retrieve value of " + r1.getName() + " field.");
        return -1;
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView r0, int r1, int r2, int r3, int r4) {
        r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView r0, @NonNull int[] r1, int r2) {
        r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
    }

    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView r0, int r1) {
        r0.setAutoSizeTextTypeWithDefaults(r1);
    }

    public static void setCompoundDrawableTintList(@NonNull TextView r0, @Nullable ColorStateList r1) {
        Preconditions.checkNotNull(r0);
        r0.setCompoundDrawableTintList(r1);
    }

    public static void setCompoundDrawableTintMode(@NonNull TextView r0, @Nullable PorterDuff.Mode r1) {
        Preconditions.checkNotNull(r0);
        r0.setCompoundDrawableTintMode(r1);
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView r0, @Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        r0.setCompoundDrawablesRelative(r1, r2, r3, r4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r0, @Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView r0, @NonNull ActionMode.Callback r1) {
        r0.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r0, r1));
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView r0, @IntRange(from = 0) @Px int r1) {
        Preconditions.checkArgumentNonnegative(r1);
        r0.setFirstBaselineToTopHeight(r1);
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView r3, @IntRange(from = 0) @Px int r4) {
        Preconditions.checkArgumentNonnegative(r4);
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (r3.getIncludeFontPadding() == false) goto L5;
        int r1 = r0.bottom;
    L7:
        if (r4 <= Math.abs(r1)) goto L10;
        int r5 = r4 - r1;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r5);
        return;
    L10:
        return;
    L5:
        r1 = r0.descent;
        goto L7
    }

    public static void setLineHeight(@NonNull TextView r2, @IntRange(from = 0) @Px int r3) {
        Preconditions.checkArgumentNonnegative(r3);
        int r0 = r2.getPaint().getFontMetricsInt(null);
        if (r3 == r0) goto L6;
        r2.setLineSpacing(r3 - r0, 1.0f);
        return;
    }

    public static void setPrecomputedText(@NonNull TextView r0, @NonNull PrecomputedTextCompat r1) {
        r0.setText(r1.getPrecomputedText());
    }

    public static void setTextAppearance(@NonNull TextView r0, @StyleRes int r1) {
        r0.setTextAppearance(r1);
    }

    public static void setTextMetricsParams(@NonNull TextView r2, @NonNull PrecomputedTextCompat.Params r3) {
        r2.setTextDirection(getTextDirection(r3.getTextDirection()));
        r2.getPaint().set(r3.getTextPaint());
        r2.setBreakStrategy(r3.getBreakStrategy());
        r2.setHyphenationFrequency(r3.getHyphenationFrequency());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView r0, @NonNull ActionMode.Callback r1) {
        return r1;
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r0, @DrawableRes int r1, @DrawableRes int r2, @DrawableRes int r3, @DrawableRes int r4) {
        r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
    }
}
