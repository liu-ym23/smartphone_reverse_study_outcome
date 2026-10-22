package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
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
    private static final String[] sClassPrefixList = null;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = null;
    private static final Class<?>[] sConstructorSignature = null;
    private static final int[] sOnClickAttrs = null;
    private final Object[] mConstructorArgs;

    public static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(@NonNull View r1, @NonNull String r2) {
            this.mHostView = r1;
            this.mMethodName = r2;
        }

        private void resolveMethod(@Nullable Context r4) {
        L2:
            if (r4 == null) goto L13;
            if (r4.isRestricted() == true) goto L10;
            Method r0 = r4.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L19
            if (r0 == null) goto L10;
            this.mResolvedMethod = r0;     // Catch: NoSuchMethodException -> L19
            this.mResolvedContext = r4;     // Catch: NoSuchMethodException -> L19
            return;
        L10:
            if ((r4 instanceof ContextWrapper) == true) goto L11;
            r4 = null;
            goto L2
        L11:
            r4 = ((ContextWrapper) r4).getBaseContext();
            goto L2
        L13:
            int r5 = this.mHostView.getId();
            if (r5 != (-1)) goto L16;
            String r6 = "";
        L18:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r6);
        L16:
            r6 = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(r5) + "'";
            goto L18
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View r2) {
            if (this.mResolvedMethod != null) goto L15;
            resolveMethod(this.mHostView.getContext());
        L15:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r2});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
            return;
        L9:
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
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    public AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }

    private void checkOnClickListener(View r2, AttributeSet r3) {
        Context r1 = r2.getContext();
        if ((r1 instanceof ContextWrapper) == true) goto L5;
        return;
    L5:
        if (ViewCompat.hasOnClickListeners(r2) == false) goto L13;
        TypedArray r4 = r1.obtainStyledAttributes(r3, sOnClickAttrs);
        String r5 = r4.getString(0);
        if (r5 == null) goto L10;
        r2.setOnClickListener(new DeclaredOnClickListener(r2, r5));
    L10:
        r4.recycle();
        return;
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
        if (r7.equals("view") == false) goto L27;
        r7 = r8.getAttributeValue(null, "class");
    L27:
        Object[] r3 = this.mConstructorArgs;     // Catch: Throwable -> L16 Exception -> L25
        r3[0] = r6;     // Catch: Throwable -> L16 Exception -> L25
        r3[1] = r8;     // Catch: Throwable -> L16 Exception -> L25
        if ((-1) != r7.indexOf(46)) goto L20;
        int r9 = 0;
    L9:
        String[] r4 = sClassPrefixList;     // Catch: Throwable -> L16 Exception -> L25
        if (r9 >= r4.length) goto L18;
        View r5 = createViewByPrefix(r6, r7, r4[r9]);     // Catch: Throwable -> L16 Exception -> L25
        if (r5 != null) goto L13;
        r9 = r9 + 1;
        goto L9
    L13:
        Object[] r10 = this.mConstructorArgs;
        r10[0] = null;
        r10[1] = null;
        return r5;
    L18:
        Object[] r11 = this.mConstructorArgs;
        r11[0] = null;
        r11[1] = null;
        return null;
    L20:
        View r12 = createViewByPrefix(r6, r7, null);     // Catch: Throwable -> L16 Exception -> L25
        Object[] r13 = this.mConstructorArgs;
        r13[0] = null;
        r13[1] = null;
        return r12;
    L25:
        Object[] r14 = this.mConstructorArgs;
        r14[0] = null;
        r14[1] = null;
        return null;
    L16:
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
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r1, AttributeSet r2) {
        return new AppCompatAutoCompleteTextView(r1, r2);
    }

    @NonNull
    public AppCompatButton createButton(Context r1, AttributeSet r2) {
        return new AppCompatButton(r1, r2);
    }

    @NonNull
    public AppCompatCheckBox createCheckBox(Context r1, AttributeSet r2) {
        return new AppCompatCheckBox(r1, r2);
    }

    @NonNull
    public AppCompatCheckedTextView createCheckedTextView(Context r1, AttributeSet r2) {
        return new AppCompatCheckedTextView(r1, r2);
    }

    @NonNull
    public AppCompatEditText createEditText(Context r1, AttributeSet r2) {
        return new AppCompatEditText(r1, r2);
    }

    @NonNull
    public AppCompatImageButton createImageButton(Context r1, AttributeSet r2) {
        return new AppCompatImageButton(r1, r2);
    }

    @NonNull
    public AppCompatImageView createImageView(Context r1, AttributeSet r2) {
        return new AppCompatImageView(r1, r2);
    }

    @NonNull
    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r1, AttributeSet r2) {
        return new AppCompatMultiAutoCompleteTextView(r1, r2);
    }

    @NonNull
    public AppCompatRadioButton createRadioButton(Context r1, AttributeSet r2) {
        return new AppCompatRadioButton(r1, r2);
    }

    @NonNull
    public AppCompatRatingBar createRatingBar(Context r1, AttributeSet r2) {
        return new AppCompatRatingBar(r1, r2);
    }

    @NonNull
    public AppCompatSeekBar createSeekBar(Context r1, AttributeSet r2) {
        return new AppCompatSeekBar(r1, r2);
    }

    @NonNull
    public AppCompatSpinner createSpinner(Context r1, AttributeSet r2) {
        return new AppCompatSpinner(r1, r2);
    }

    @NonNull
    public AppCompatTextView createTextView(Context r1, AttributeSet r2) {
        return new AppCompatTextView(r1, r2);
    }

    @NonNull
    public AppCompatToggleButton createToggleButton(Context r1, AttributeSet r2) {
        return new AppCompatToggleButton(r1, r2);
    }

    @Nullable
    public View createView(Context r1, String r2, AttributeSet r3) {
        return null;
    }

    public final View createView(View r1, String r2, @NonNull Context r3, @NonNull AttributeSet r4, boolean r5, boolean r6, boolean r7, boolean r8) {
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
        r2.getClass();
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
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
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
    L86:
        if (r11 != null) goto L89;
        if (r3 == r9) goto L89;
        r11 = createViewFromTag(r9, r2, r4);
    L89:
        if (r11 == null) goto L91;
        checkOnClickListener(r11, r4);
    L91:
        return r11;
    L72:
        r11 = createButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L73:
        r11 = createEditText(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L74:
        r11 = createCheckBox(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L75:
        r11 = createAutoCompleteTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L76:
        r11 = createImageView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L77:
        r11 = createToggleButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L78:
        r11 = createRadioButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L79:
        r11 = createSpinner(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L80:
        r11 = createSeekBar(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L81:
        r11 = createImageButton(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L82:
        r11 = createTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L83:
        r11 = createMultiAutoCompleteTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L84:
        r11 = createCheckedTextView(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
    L85:
        r11 = createRatingBar(r9, r4);
        verifyNotNull(r11, r2);
        goto L86
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
