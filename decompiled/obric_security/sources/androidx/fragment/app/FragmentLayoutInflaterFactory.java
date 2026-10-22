package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;

/* JADX INFO: loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager r1) {
        this.mFragmentManager = r1;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        return onCreateView(null, r2, r3, r4);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View r9, String r10, Context r11, AttributeSet r12) {
        if (FragmentContainerView.class.getName().equals(r10) == true) goto L5;
        Fragment r0 = null;
        if ("fragment".equals(r10) == true) goto L9;
        return null;
    L9:
        String r13 = r12.getAttributeValue(null, "class");
        TypedArray r1 = r11.obtainStyledAttributes(r12, R.styleable.Fragment);
        if (r13 != null) goto L12;
        r13 = r1.getString(R.styleable.Fragment_android_name);
    L12:
        int r2 = r1.getResourceId(R.styleable.Fragment_android_id, -1);
        String r4 = r1.getString(R.styleable.Fragment_android_tag);
        r1.recycle();
        if (r13 != null) goto L15;
    L61:
        return null;
    L15:
        if (FragmentFactory.isFragmentClass(r11.getClassLoader(), r13) == false) goto L61;
        if (r9 == null) goto L19;
        int r3 = r9.getId();
    L20:
        if (r3 != (-1)) goto L26;
        if (r2 != (-1)) goto L26;
        if (r4 != null) goto L26;
        throw new IllegalArgumentException(r12.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r13);
    L26:
        if (r2 == (-1)) goto L28;
        r0 = this.mFragmentManager.findFragmentById(r2);
    L28:
        if (r0 != null) goto L31;
        if (r4 == null) goto L31;
        r0 = this.mFragmentManager.findFragmentByTag(r4);
    L31:
        if (r0 != null) goto L35;
        if (r3 == (-1)) goto L35;
        r0 = this.mFragmentManager.findFragmentById(r3);
    L35:
        if (r0 != null) goto L44;
        r0 = this.mFragmentManager.getFragmentFactory().instantiate(r11.getClassLoader(), r13);
        r0.mFromLayout = true;
        if (r2 == 0) goto L39;
        int r14 = r2;
    L40:
        r0.mFragmentId = r14;
        r0.mContainerId = r3;
        r0.mTag = r4;
        r0.mInLayout = true;
        r0.mFragmentManager = this.mFragmentManager;
        r0.mHost = this.mFragmentManager.getHost();
        r0.onInflate(this.mFragmentManager.getHost().getContext(), r12, r0.mSavedFragmentState);
        final FragmentStateManager r15 = this.mFragmentManager.addFragment(r0);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L48;
        Log.v(TAG, "Fragment " + r0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(r2));
    L48:
        r0.mContainer = (ViewGroup) r9;
        r15.moveToExpectedState();
        r15.ensureInflatedView();
        if (r0.mView == null) goto L58;
        if (r2 == 0) goto L53;
        r0.mView.setId(r2);
    L53:
        if (r0.mView.getTag() != null) goto L55;
        r0.mView.setTag(r4);
    L55:
        r0.mView.addOnAttachStateChangeListener(new AnonymousClass1(this, r15));
        return r0.mView;
    L58:
        throw new IllegalStateException("Fragment " + r13 + " did not create a view.");
    L39:
        r14 = r3;
        goto L40
    L44:
        if (r0.mInLayout == true) goto L60;
        r0.mInLayout = true;
        r0.mFragmentManager = this.mFragmentManager;
        r0.mHost = this.mFragmentManager.getHost();
        r0.onInflate(this.mFragmentManager.getHost().getContext(), r12, r0.mSavedFragmentState);
        r15 = this.mFragmentManager.createOrGetFragmentStateManager(r0);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L48;
        Log.v(TAG, "Retained Fragment " + r0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(r2));
        goto L48
    L60:
        throw new IllegalArgumentException(r12.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r2) + ", tag " + r4 + ", or parent id 0x" + Integer.toHexString(r3) + " with another fragment for " + r13);
    L19:
        r3 = 0;
        goto L20
    L5:
        return new FragmentContainerView(r11, r12, this.mFragmentManager);
    }
}
