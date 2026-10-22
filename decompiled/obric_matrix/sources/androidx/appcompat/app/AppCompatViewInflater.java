package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final int[] sAccessibilityHeading = null;
    private static final int[] sAccessibilityPaneTitle = null;
    private static final String[] sClassPrefixList = null;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = null;
    private static final Class<?>[] sConstructorSignature = null;
    private static final int[] sOnClickAttrs = null;
    private static final int[] sScreenReaderFocusable = null;
    private final Object[] mConstructorArgs;

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(@NonNull View r1, @NonNull String r2) {
            this.mHostView = r1;
            this.mMethodName = r2;
        }

        private void resolveMethod(@Nullable Context r6) {
        L2:
            if (r6 == null) goto L13;
            if (r6.isRestricted() == true) goto L10;
            Method r0 = r6.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L19
            if (r0 == null) goto L10;
            this.mResolvedMethod = r0;     // Catch: NoSuchMethodException -> L19
            this.mResolvedContext = r6;     // Catch: NoSuchMethodException -> L19
            return;
        L10:
            if ((r6 instanceof ContextWrapper) == true) goto L11;
            r6 = null;
            goto L2
        L11:
            r6 = ((ContextWrapper) r6).getBaseContext();
            goto L2
        L13:
            int r7 = this.mHostView.getId();
            if (r7 != (-1)) goto L16;
            String r8 = "";
        L18:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r8);
        L16:
            r8 = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(r7) + "'";
            goto L18
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View r4) {
            if (this.mResolvedMethod != null) goto L13;
            resolveMethod(this.mHostView.getContext());
        L13:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r4});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L10
            return;
        L10:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L7:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }
    }

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{R.attr.onClick};
        sAccessibilityHeading = new int[]{R.attr.accessibilityHeading};
        sAccessibilityPaneTitle = new int[]{R.attr.accessibilityPaneTitle};
        sScreenReaderFocusable = new int[]{R.attr.screenReaderFocusable};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    public AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }

    private void backportAccessibilityAttributes(@NonNull Context r3, @NonNull View r4, @NonNull AttributeSet r5) {
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 19) goto L5;
        return;
    L5:
        if (r2 > 28) goto L19;
        TypedArray r6 = r3.obtainStyledAttributes(r5, sAccessibilityHeading);
        if (r6.hasValue(0) == false) goto L10;
        ViewCompat.setAccessibilityHeading(r4, r6.getBoolean(0, false));
    L10:
        r6.recycle();
        TypedArray r7 = r3.obtainStyledAttributes(r5, sAccessibilityPaneTitle);
        if (r7.hasValue(0) == false) goto L13;
        ViewCompat.setAccessibilityPaneTitle(r4, r7.getString(0));
    L13:
        r7.recycle();
        TypedArray r8 = r3.obtainStyledAttributes(r5, sScreenReaderFocusable);
        if (r8.hasValue(0) == false) goto L16;
        ViewCompat.setScreenReaderFocusable(r4, r8.getBoolean(0, false));
    L16:
        r8.recycle();
        return;
    }

    private void checkOnClickListener(View r3, AttributeSet r4) {
        Context r2 = r3.getContext();
        if ((r2 instanceof ContextWrapper) == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 15) goto L7;
    L9:
        TypedArray r5 = r2.obtainStyledAttributes(r4, sOnClickAttrs);
        String r6 = r5.getString(0);
        if (r6 == null) goto L12;
        r3.setOnClickListener(new DeclaredOnClickListener(r3, r6));
    L12:
        r5.recycle();
        return;
    L7:
        if (ViewCompat.hasOnClickListeners(r3) == true) goto L9;
    }

    private View createViewByPrefix(Context r3, String r4, String r5) {
        SimpleArrayMap<String, Constructor<? extends View>> r0 = sConstructorMap;
        Constructor<? extends View> r1 = r0.get(r4);
        if (r1 != null) goto L8;
        if (r5 != null) goto L12;
        String r6 = r4;
    L7:
        r1 = Class.forName(r6, false, r3.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);     // Catch: Exception -> L10
        r0.put(r4, r1);     // Catch: Exception -> L10
        goto L8
    L12:
        r6 = r5 + r4;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r1.setAccessible(true);     // Catch: Exception -> L10
        return r1.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context r6, String r7, AttributeSet r8) {
        if (r7.equals("view") == false) goto L26;
        r7 = r8.getAttributeValue(null, "class");
    L26:
        Object[] r3 = this.mConstructorArgs;     // Catch: Throwable -> L21 Exception -> L24
        r3[0] = r6;     // Catch: Throwable -> L21 Exception -> L24
        r3[1] = r8;     // Catch: Throwable -> L21 Exception -> L24
        if ((-1) != r7.indexOf(46)) goto L18;
        int r9 = 0;
    L9:
        String[] r4 = sClassPrefixList;     // Catch: Throwable -> L21 Exception -> L24
        if (r9 >= r4.length) goto L16;
        View r5 = createViewByPrefix(r6, r7, r4[r9]);     // Catch: Throwable -> L21 Exception -> L24
        if (r5 != null) goto L13;
        r9 = r9 + 1;
        goto L9
    L13:
        Object[] r10 = this.mConstructorArgs;
        r10[0] = null;
        r10[1] = null;
        return r5;
    L16:
        Object[] r11 = this.mConstructorArgs;
        r11[0] = null;
        r11[1] = null;
        return null;
    L18:
        View r12 = createViewByPrefix(r6, r7, null);     // Catch: Throwable -> L21 Exception -> L24
        Object[] r13 = this.mConstructorArgs;
        r13[0] = null;
        r13[1] = null;
        return r12;
    L24:
        Object[] r14 = this.mConstructorArgs;
        r14[0] = null;
        r14[1] = null;
        return null;
    L21:
        th = move-exception;
        Object[] r15 = this.mConstructorArgs;
        r15[0] = null;
        r15[1] = null;
        throw th;
    }

    private static Context themifyContext(Context r2, AttributeSet r3, boolean r4, boolean r5) {
        TypedArray r6 = r2.obtainStyledAttributes(r3, androidx.appcompat.R.styleable.View, 0, 0);
        if (r4 == false) goto L5;
        int r7 = r6.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0);
    L6:
        if (r5 == false) goto L11;
        if (r7 != 0) goto L11;
        r7 = r6.getResourceId(androidx.appcompat.R.styleable.View_theme, 0);
        if (r7 == 0) goto L11;
        Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
    L11:
        r6.recycle();
        if (r7 != 0) goto L14;
        return r2;
    L14:
        if ((r2 instanceof ContextThemeWrapper) == false) goto L18;
        if (((ContextThemeWrapper) r2).getThemeResId() != r7) goto L18;
        return r2;
    L18:
        return new ContextThemeWrapper(r2, r7);
    L5:
        r7 = 0;
        goto L6
    }

    private void verifyNotNull(View r2, String r3) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r3 + ">, but returned null");
    }

    @NonNull
    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r1, AttributeSet r2) {
        return new AppCompatAutoCompleteTextView(r1, r2);
    }

    @NonNull
    protected AppCompatButton createButton(Context r1, AttributeSet r2) {
        return new AppCompatButton(r1, r2);
    }

    @NonNull
    protected AppCompatCheckBox createCheckBox(Context r1, AttributeSet r2) {
        return new AppCompatCheckBox(r1, r2);
    }

    @NonNull
    protected AppCompatCheckedTextView createCheckedTextView(Context r1, AttributeSet r2) {
        return new AppCompatCheckedTextView(r1, r2);
    }

    @NonNull
    protected AppCompatEditText createEditText(Context r1, AttributeSet r2) {
        return new AppCompatEditText(r1, r2);
    }

    @NonNull
    protected AppCompatImageButton createImageButton(Context r1, AttributeSet r2) {
        return new AppCompatImageButton(r1, r2);
    }

    @NonNull
    protected AppCompatImageView createImageView(Context r1, AttributeSet r2) {
        return new AppCompatImageView(r1, r2);
    }

    @NonNull
    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r1, AttributeSet r2) {
        return new AppCompatMultiAutoCompleteTextView(r1, r2);
    }

    @NonNull
    protected AppCompatRadioButton createRadioButton(Context r1, AttributeSet r2) {
        return new AppCompatRadioButton(r1, r2);
    }

    @NonNull
    protected AppCompatRatingBar createRatingBar(Context r1, AttributeSet r2) {
        return new AppCompatRatingBar(r1, r2);
    }

    @NonNull
    protected AppCompatSeekBar createSeekBar(Context r1, AttributeSet r2) {
        return new AppCompatSeekBar(r1, r2);
    }

    @NonNull
    protected AppCompatSpinner createSpinner(Context r1, AttributeSet r2) {
        return new AppCompatSpinner(r1, r2);
    }

    @NonNull
    protected AppCompatTextView createTextView(Context r1, AttributeSet r2) {
        return new AppCompatTextView(r1, r2);
    }

    @NonNull
    protected AppCompatToggleButton createToggleButton(Context r1, AttributeSet r2) {
        return new AppCompatToggleButton(r1, r2);
    }

    @Nullable
    protected View createView(Context r1, String r2, AttributeSet r3) {
        return null;
    }

    @Nullable
    public final View createView(@Nullable View r1, @NonNull String r2, @NonNull Context r3, @NonNull AttributeSet r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        if (r5 == false) goto L5;
        if (r1 == null) goto L5;
        Context r9 = r1.getContext();
    L6:
        if (r6 == true) goto L8;
        if (r7 == true) goto L8;
    L9:
        if (r8 == false) goto L11;
        r9 = TintContextWrapper.wrap(r9);
    L11:
        r2.hashCode();
        byte r10 = -1;
        switch(r2.hashCode()) {
            case -1946472170: goto L67;
            case -1455429095: goto L63;
            case -1346021293: goto L59;
            case -938935918: goto L55;
            case -937446323: goto L51;
            case -658531749: goto L47;
            case -339785223: goto L43;
            case 776382189: goto L39;
            case 799298502: goto L35;
            case 1125864064: goto L31;
            case 1413872058: goto L27;
            case 1601505219: goto L23;
            case 1666676343: goto L19;
            case 2001146706: goto L15;
            default: goto L70;
        };
    L70:
        switch(r10) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L73;
            case 13: goto L72;
            default: goto L71;
        };
    L71:
        View r11 = createView(r9, r2, r4);
    L87:
        if (r11 != null) goto L90;
        if (r3 == r9) goto L90;
        r11 = createViewFromTag(r9, r2, r4);
    L90:
        if (r11 == null) goto L92;
        checkOnClickListener(r11, r4);
        backportAccessibilityAttributes(r9, r11, r4);
    L92:
        return r11;
    L72:
        r11 = createButton(r9, r4);
    L83:
        verifyNotNull(r11, r2);
        goto L87
    L73:
        r11 = createEditText(r9, r4);
        goto L83
    L74:
        r11 = createCheckBox(r9, r4);
        goto L83
    L75:
        r11 = createAutoCompleteTextView(r9, r4);
        goto L83
    L76:
        r11 = createImageView(r9, r4);
        goto L83
    L77:
        r11 = createToggleButton(r9, r4);
        goto L83
    L78:
        r11 = createRadioButton(r9, r4);
        goto L83
    L79:
        r11 = createSpinner(r9, r4);
        goto L83
    L80:
        r11 = createSeekBar(r9, r4);
        goto L83
    L81:
        r11 = createImageButton(r9, r4);
        goto L83
    L82:
        r11 = createTextView(r9, r4);
        goto L83
    L84:
        r11 = createMultiAutoCompleteTextView(r9, r4);
        goto L83
    L85:
        r11 = createCheckedTextView(r9, r4);
        goto L83
    L86:
        r11 = createRatingBar(r9, r4);
        goto L83
    L15:
        if (r2.equals("Button") == false) goto L70;
        r10 = 13;
        goto L70
    L19:
        if (r2.equals("EditText") == false) goto L70;
        r10 = 12;
        goto L70
    L23:
        if (r2.equals("CheckBox") == false) goto L70;
        r10 = 11;
        goto L70
    L27:
        if (r2.equals("AutoCompleteTextView") == false) goto L70;
        r10 = 10;
        goto L70
    L31:
        if (r2.equals("ImageView") == false) goto L70;
        r10 = 9;
        goto L70
    L35:
        if (r2.equals("ToggleButton") == false) goto L70;
        r10 = 8;
        goto L70
    L39:
        if (r2.equals("RadioButton") == false) goto L70;
        r10 = 7;
        goto L70
    L43:
        if (r2.equals("Spinner") == false) goto L70;
        r10 = 6;
        goto L70
    L47:
        if (r2.equals("SeekBar") == false) goto L70;
        r10 = 5;
        goto L70
    L51:
        if (r2.equals("ImageButton") == false) goto L70;
        r10 = 4;
        goto L70
    L55:
        if (r2.equals("TextView") == false) goto L70;
        r10 = 3;
        goto L70
    L59:
        if (r2.equals("MultiAutoCompleteTextView") == false) goto L70;
        r10 = 2;
        goto L70
    L63:
        if (r2.equals("CheckedTextView") == false) goto L70;
        r10 = 1;
        goto L70
    L67:
        if (r2.equals("RatingBar") == false) goto L70;
        r10 = 0;
    L8:
        r9 = themifyContext(r9, r4, r6, r7);
    L5:
        r9 = r3;
        goto L6
    }
}
