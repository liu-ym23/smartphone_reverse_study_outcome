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
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static boolean getIncludeFontPadding(TextView r0) {
            return r0.getIncludeFontPadding();
        }

        @DoNotInline
        static int getMaxLines(TextView r0) {
            return r0.getMaxLines();
        }

        @DoNotInline
        static int getMinLines(TextView r0) {
            return r0.getMinLines();
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Drawable[] getCompoundDrawablesRelative(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }

        @DoNotInline
        static int getLayoutDirection(View r0) {
            return r0.getLayoutDirection();
        }

        @DoNotInline
        static int getTextDirection(View r0) {
            return r0.getTextDirection();
        }

        @DoNotInline
        static Locale getTextLocale(TextView r0) {
            return r0.getTextLocale();
        }

        @DoNotInline
        static void setCompoundDrawablesRelative(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelative(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setTextDirection(View r0, int r1) {
            r0.setTextDirection(r1);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getBreakStrategy(TextView r0) {
            return r0.getBreakStrategy();
        }

        @DoNotInline
        static ColorStateList getCompoundDrawableTintList(TextView r0) {
            return r0.getCompoundDrawableTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getCompoundDrawableTintMode(TextView r0) {
            return r0.getCompoundDrawableTintMode();
        }

        @DoNotInline
        static int getHyphenationFrequency(TextView r0) {
            return r0.getHyphenationFrequency();
        }

        @DoNotInline
        static void setBreakStrategy(TextView r0, int r1) {
            r0.setBreakStrategy(r1);
        }

        @DoNotInline
        static void setCompoundDrawableTintList(TextView r0, ColorStateList r1) {
            r0.setCompoundDrawableTintList(r1);
        }

        @DoNotInline
        static void setCompoundDrawableTintMode(TextView r0, PorterDuff.Mode r1) {
            r0.setCompoundDrawableTintMode(r1);
        }

        @DoNotInline
        static void setHyphenationFrequency(TextView r0, int r1) {
            r0.setHyphenationFrequency(r1);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static DecimalFormatSymbols getInstance(Locale r0) {
            return DecimalFormatSymbols.getInstance(r0);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAutoSizeMaxTextSize(TextView r0) {
            return r0.getAutoSizeMaxTextSize();
        }

        @DoNotInline
        static int getAutoSizeMinTextSize(TextView r0) {
            return r0.getAutoSizeMinTextSize();
        }

        @DoNotInline
        static int getAutoSizeStepGranularity(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static int[] getAutoSizeTextAvailableSizes(TextView r0) {
            return r0.getAutoSizeTextAvailableSizes();
        }

        @DoNotInline
        static int getAutoSizeTextType(TextView r0) {
            return r0.getAutoSizeTextType();
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }

        @DoNotInline
        static void setAutoSizeTextTypeWithDefaults(TextView r0, int r1) {
            r0.setAutoSizeTextTypeWithDefaults(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String[] getDigitStrings(DecimalFormatSymbols r0) {
            return r0.getDigitStrings();
        }

        @DoNotInline
        static PrecomputedText.Params getTextMetricsParams(TextView r0) {
            return r0.getTextMetricsParams();
        }

        @DoNotInline
        static void setFirstBaselineToTopHeight(TextView r0, int r1) {
            r0.setFirstBaselineToTopHeight(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    private static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback r1, TextView r2) {
            this.mCallback = r1;
            this.mTextView = r2;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
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

        @NonNull
        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMaxTextSize(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMaxTextSize(r2);
    L7:
        if ((r2 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r2).getAutoSizeMaxTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMinTextSize(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMinTextSize(r2);
    L7:
        if ((r2 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r2).getAutoSizeMinTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeStepGranularity(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeStepGranularity(r2);
    L7:
        if ((r2 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r2).getAutoSizeStepGranularity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextAvailableSizes(r2);
    L7:
        if ((r2 instanceof AutoSizeableTextView) == false) goto L11;
        return ((AutoSizeableTextView) r2).getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeTextType(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextType(r2);
    L7:
        if ((r2 instanceof AutoSizeableTextView) == true) goto L9;
        return 0;
    L9:
        return ((AutoSizeableTextView) r2).getAutoSizeTextType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintList(r2);
    L7:
        if ((r2 instanceof TintableCompoundDrawablesView) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) r2).getSupportCompoundDrawablesTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintMode(r2);
    L7:
        if ((r2 instanceof TintableCompoundDrawablesView) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) r2).getSupportCompoundDrawablesTintMode();
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 18) goto L7;
        return Api17Impl.getCompoundDrawablesRelative(r4);
    L7:
        if (r0 < 17) goto L17;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r4) == 1) goto L12;
        r1 = false;
    L12:
        Drawable[] r5 = r4.getCompoundDrawables();
        if (r1 == false) goto L15;
        Drawable r2 = r5[2];
        Drawable r3 = r5[0];
        r5[0] = r2;
        r5[2] = r3;
    L15:
        return r5;
    L17:
        return r4.getCompoundDrawables();
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView r1) {
        return r1.getPaddingTop() - r1.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView r1) {
        return r1.getPaddingBottom() + r1.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMaxLines(r2);
    L7:
        if (sMaxModeFieldFetched == true) goto L9;
        sMaxModeField = retrieveField("mMaxMode");
        sMaxModeFieldFetched = true;
    L9:
        Field r0 = sMaxModeField;
        if (r0 != null) goto L12;
        return -1;
    L12:
        if (retrieveIntFromField(r0, r2) == 1) goto L14;
        return -1;
    L14:
        if (sMaximumFieldFetched == true) goto L16;
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
    L16:
        Field r1 = sMaximumField;
        if (r1 != null) goto L19;
        return -1;
    L19:
        return retrieveIntFromField(r1, r2);
    }

    public static int getMinLines(@NonNull TextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinLines(r2);
    L7:
        if (sMinModeFieldFetched == true) goto L9;
        sMinModeField = retrieveField("mMinMode");
        sMinModeFieldFetched = true;
    L9:
        Field r0 = sMinModeField;
        if (r0 != null) goto L12;
        return -1;
    L12:
        if (retrieveIntFromField(r0, r2) == 1) goto L14;
        return -1;
    L14:
        if (sMinimumFieldFetched == true) goto L16;
        sMinimumField = retrieveField("mMinimum");
        sMinimumFieldFetched = true;
    L16:
        Field r1 = sMinimumField;
        if (r1 != null) goto L19;
        return -1;
    L19:
        return retrieveIntFromField(r1, r2);
    }

    @RequiresApi(18)
    private static int getTextDirection(@NonNull TextDirectionHeuristic r2) {
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
        return 1;
    L6:
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L9;
        return 1;
    L9:
        if (r2 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r2 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r2 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r2 != TextDirectionHeuristics.LOCALE) goto L25;
        return 5;
    L25:
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L29;
        return 6;
    L29:
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L32;
        return 7;
    L32:
        return 1;
    }

    @RequiresApi(18)
    private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView r4) {
        if ((r4.getTransformationMethod() instanceof PasswordTransformationMethod) == true) goto L5;
        boolean r2 = false;
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if ((r4.getInputType() & 15) != 3) goto L20;
        byte r5 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(Api17Impl.getTextLocale(r4)))[0].codePointAt(0));
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L18;
        return TextDirectionHeuristics.LTR;
    L18:
        return TextDirectionHeuristics.RTL;
    L20:
        if (Api17Impl.getLayoutDirection(r4) != 1) goto L23;
        r2 = true;
    L23:
        switch(Api17Impl.getTextDirection(r4)) {
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            default: goto L24;
        };
    L24:
        if (r2 == false) goto L39;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L39:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L27:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L29:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L31:
        return TextDirectionHeuristics.LOCALE;
    L33:
        return TextDirectionHeuristics.RTL;
    L35:
        return TextDirectionHeuristics.LTR;
    L37:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L5:
        return TextDirectionHeuristics.LTR;
    }

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 28) goto L5;
        PrecomputedTextCompat.Params.Builder r1 = new PrecomputedTextCompat.Params.Builder(new TextPaint(r4.getPaint()));
        if (r0 < 23) goto L10;
        r1.setBreakStrategy(Api23Impl.getBreakStrategy(r4));
        r1.setHyphenationFrequency(Api23Impl.getHyphenationFrequency(r4));
    L10:
        if (r0 < 18) goto L13;
        r1.setTextDirection(getTextDirectionHeuristic(r4));
    L13:
        return r1.build();
    L5:
        return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(r4));
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5, r6);
        return;
    L6:
        if ((r2 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r2).setAutoSizeTextTypeUniformWithConfiguration(r3, r4, r5, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView r2, @NonNull int[] r3, int r4) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r2, r3, r4);
        return;
    L6:
        if ((r2 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r2).setAutoSizeTextTypeUniformWithPresetSizes(r3, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView r2, int r3) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeWithDefaults(r2, r3);
        return;
    L6:
        if ((r2 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r2).setAutoSizeTextTypeWithDefaults(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintList(@NonNull TextView r2, @Nullable ColorStateList r3) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintList(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintableCompoundDrawablesView) == false) goto L10;
        ((TintableCompoundDrawablesView) r2).setSupportCompoundDrawablesTintList(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintMode(@NonNull TextView r2, @Nullable PorterDuff.Mode r3) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintMode(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintableCompoundDrawablesView) == false) goto L10;
        ((TintableCompoundDrawablesView) r2).setSupportCompoundDrawablesTintMode(r3);
        return;
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView r2, @Nullable Drawable r3, @Nullable Drawable r4, @Nullable Drawable r5, @Nullable Drawable r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelative(r2, r3, r4, r5, r6);
        return;
    L6:
        if (r0 < 17) goto L18;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        Drawable r7 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawables(r7, r4, r3, r6);
        return;
    L13:
        r7 = r3;
        goto L14
    L18:
        r2.setCompoundDrawables(r3, r4, r5, r6);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r2, @DrawableRes int r3, @DrawableRes int r4, @DrawableRes int r5, @DrawableRes int r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r2, r3, r4, r5, r6);
        return;
    L6:
        if (r0 < 17) goto L18;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        int r7 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawablesWithIntrinsicBounds(r7, r4, r3, r6);
        return;
    L13:
        r7 = r3;
        goto L14
    L18:
        r2.setCompoundDrawablesWithIntrinsicBounds(r3, r4, r5, r6);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r2, @Nullable Drawable r3, @Nullable Drawable r4, @Nullable Drawable r5, @Nullable Drawable r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r2, r3, r4, r5, r6);
        return;
    L6:
        if (r0 < 17) goto L18;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        Drawable r7 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawablesWithIntrinsicBounds(r7, r4, r3, r6);
        return;
    L13:
        r7 = r3;
        goto L14
    L18:
        r2.setCompoundDrawablesWithIntrinsicBounds(r3, r4, r5, r6);
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView r0, @NonNull ActionMode.Callback r1) {
        r0.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r0, r1));
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView r3, @IntRange(from = 0) @Px int r4) {
        Preconditions.checkArgumentNonnegative(r4);
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        Api28Impl.setFirstBaselineToTopHeight(r3, r4);
        return;
    L6:
        Paint.FontMetricsInt r1 = r3.getPaint().getFontMetricsInt();
        if (r0 >= 16) goto L9;
    L12:
        int r2 = r1.top;
    L14:
        if (r4 <= Math.abs(r2)) goto L17;
        int r5 = r4 + r2;
        r3.setPadding(r3.getPaddingLeft(), r5, r3.getPaddingRight(), r3.getPaddingBottom());
        return;
    L17:
        return;
    L9:
        if (Api16Impl.getIncludeFontPadding(r3) == true) goto L12;
        r2 = r1.ascent;
        goto L14
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView r3, @IntRange(from = 0) @Px int r4) {
        Preconditions.checkArgumentNonnegative(r4);
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L8:
        int r1 = r0.bottom;
    L10:
        if (r4 <= Math.abs(r1)) goto L13;
        int r5 = r4 - r1;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r5);
        return;
    L13:
        return;
    L5:
        if (Api16Impl.getIncludeFontPadding(r3) == true) goto L8;
        r1 = r0.descent;
        goto L10
    }

    public static void setLineHeight(@NonNull TextView r2, @IntRange(from = 0) @Px int r3) {
        Preconditions.checkArgumentNonnegative(r3);
        int r0 = r2.getPaint().getFontMetricsInt(null);
        if (r3 == r0) goto L6;
        r2.setLineSpacing(r3 - r0, 1.0f);
        return;
    }

    public static void setPrecomputedText(@NonNull TextView r2, @NonNull PrecomputedTextCompat r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        PrecomputedTextCompat r4 = r3.getPrecomputedText();
    L5:
        r2.setText(r4);
        return;
    L6:
        boolean r0 = getTextMetricsParams(r2).equalsWithoutTextDirection(r3.getParams());
        r4 = r3;
        if (r0 == true) goto L5;
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static void setTextAppearance(@NonNull TextView r2, @StyleRes int r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r2.setTextAppearance(r3);
        return;
    L5:
        r2.setTextAppearance(r2.getContext(), r3);
    }

    public static void setTextMetricsParams(@NonNull TextView r2, @NonNull PrecomputedTextCompat.Params r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 18) goto L6;
        Api17Impl.setTextDirection(r2, getTextDirection(r3.getTextDirection()));
    L6:
        if (r0 >= 23) goto L11;
        float r1 = r3.getTextPaint().getTextScaleX();
        r2.getPaint().set(r3.getTextPaint());
        if (r1 != r2.getTextScaleX()) goto L10;
        r2.setTextScaleX((r1 / 2.0f) + 1.0f);
    L10:
        r2.setTextScaleX(r1);
        return;
    L11:
        r2.getPaint().set(r3.getTextPaint());
        Api23Impl.setBreakStrategy(r2, r3.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(r2, r3.getHyphenationFrequency());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r2) {
        if ((r2 instanceof OreoCallback) == true) goto L5;
        return r2;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return r2;
    L7:
        return ((OreoCallback) r2).getWrappedCallback();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView r2, @Nullable ActionMode.Callback r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 26) goto L5;
    L12:
        return r3;
    L5:
        if (r0 > 27) goto L12;
        if ((r3 instanceof OreoCallback) == true) goto L12;
        if (r3 == null) goto L12;
        return new OreoCallback(r3, r2);
    }
}
