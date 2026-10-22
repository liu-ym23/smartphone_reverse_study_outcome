package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* JADX INFO: loaded from: classes.dex */
class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager r1) {
        this.mFragmentManager = r1;
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View r9, @NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12) {
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
    L62:
        return null;
    L15:
        if (FragmentFactory.isFragmentClass(r11.getClassLoader(), r13) == false) goto L62;
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
        if (r0 != null) goto L45;
        r0 = this.mFragmentManager.getFragmentFactory().instantiate(r11.getClassLoader(), r13);
        r0.mFromLayout = true;
        if (r2 == 0) goto L39;
        int r14 = r2;
    L40:
        r0.mFragmentId = r14;
        r0.mContainerId = r3;
        r0.mTag = r4;
        r0.mInLayout = true;
        FragmentManager r15 = this.mFragmentManager;
        r0.mFragmentManager = r15;
        r0.mHost = r15.getHost();
        r0.onInflate(this.mFragmentManager.getHost().getContext(), r12, r0.mSavedFragmentState);
        final FragmentStateManager r16 = this.mFragmentManager.addFragment(r0);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L49;
        StringBuilder r17 = new StringBuilder();
        r17.append("Fragment ");
        r17.append(r0);
        String r5 = " has been inflated via the <fragment> tag: id=0x";
    L43:
        r17.append(r5);
        r17.append(Integer.toHexString(r2));
        Log.v("FragmentManager", r17.toString());
    L49:
        ViewGroup r18 = (ViewGroup) r9;
        FragmentStrictMode.onFragmentTagUsage(r0, r18);
        r0.mContainer = r18;
        r16.moveToExpectedState();
        r16.ensureInflatedView();
        View r19 = r0.mView;
        if (r19 == null) goto L59;
        if (r2 == 0) goto L54;
        r19.setId(r2);
    L54:
        if (r0.mView.getTag() != null) goto L56;
        r0.mView.setTag(r4);
    L56:
        r0.mView.addOnAttachStateChangeListener(new AnonymousClass1(this, r16));
        return r0.mView;
    L59:
        throw new IllegalStateException("Fragment " + r13 + " did not create a view.");
    L39:
        r14 = r3;
        goto L40
    L45:
        if (r0.mInLayout == true) goto L61;
        r0.mInLayout = true;
        FragmentManager r110 = this.mFragmentManager;
        r0.mFragmentManager = r110;
        r0.mHost = r110.getHost();
        r0.onInflate(this.mFragmentManager.getHost().getContext(), r12, r0.mSavedFragmentState);
        r16 = this.mFragmentManager.createOrGetFragmentStateManager(r0);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L49;
        r17 = new StringBuilder();
        r17.append("Retained Fragment ");
        r17.append(r0);
        r5 = " has been re-attached via the <fragment> tag: id=0x";
        goto L43
    L61:
        throw new IllegalArgumentException(r12.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r2) + ", tag " + r4 + ", or parent id 0x" + Integer.toHexString(r3) + " with another fragment for " + r13);
    L19:
        r3 = 0;
        goto L20
    L5:
        return new FragmentContainerView(r11, r12, this.mFragmentManager);
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String r2, @NonNull Context r3, @NonNull AttributeSet r4) {
        return onCreateView(null, r2, r3, r4);
    }
}
