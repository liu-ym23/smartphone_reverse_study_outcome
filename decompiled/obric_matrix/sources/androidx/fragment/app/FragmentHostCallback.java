package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    @Nullable
    private final Activity mActivity;

    @NonNull
    private final Context mContext;
    final FragmentManager mFragmentManager;

    @NonNull
    private final Handler mHandler;
    private final int mWindowAnimations;

    FragmentHostCallback(@Nullable Activity r2, @NonNull Context r3, @NonNull Handler r4, int r5) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = r2;
        this.mContext = (Context) Preconditions.checkNotNull(r3, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(r4, "handler == null");
        this.mWindowAnimations = r5;
    }

    public FragmentHostCallback(@NonNull Context r2, @NonNull Handler r3, int r4) {
        if ((r2 instanceof Activity) == false) goto L5;
        Activity r0 = (Activity) r2;
    L6:
        this(r0, r2, r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    FragmentHostCallback(@NonNull FragmentActivity r3) {
        this(r3, r3, new Handler(), 0);
    }

    @Nullable
    Activity getActivity() {
        return this.mActivity;
    }

    @NonNull
    Context getContext() {
        return this.mContext;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Handler getHandler() {
        return this.mHandler;
    }

    public void onDump(@NonNull String r1, @Nullable FileDescriptor r2, @NonNull PrintWriter r3, @Nullable String[] r4) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int r1) {
        return null;
    }

    @Nullable
    public abstract E onGetHost();

    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    @Deprecated
    public void onRequestPermissionsFromFragment(@NonNull Fragment r1, @NonNull String[] r2, int r3) {
    }

    public boolean onShouldSaveFragmentState(@NonNull Fragment r1) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String r1) {
        return false;
    }

    public void onStartActivityFromFragment(@NonNull Fragment r2, @SuppressLint({"UnknownNullness"}) Intent r3, int r4) {
        onStartActivityFromFragment(r2, r3, r4, null);
    }

    public void onStartActivityFromFragment(@NonNull Fragment r1, @SuppressLint({"UnknownNullness"}) Intent r2, int r3, @Nullable Bundle r4) {
        if (r3 != (-1)) goto L7;
        ContextCompat.startActivity(this.mContext, r2, r4);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void onStartIntentSenderFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) {
        if (r12 != (-1)) goto L7;
        ActivityCompat.startIntentSenderForResult(this.mActivity, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}
