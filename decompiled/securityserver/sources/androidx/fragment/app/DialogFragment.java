package androidx.fragment.app;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    int mBackStackId;
    boolean mCancelable;

    @Nullable
    Dialog mDialog;
    private Runnable mDismissRunnable;
    boolean mDismissed;
    private Handler mHandler;
    boolean mShownByMe;
    boolean mShowsDialog;
    int mStyle;
    int mTheme;
    boolean mViewDestroyed;

    public DialogFragment() {
        this.mDismissRunnable = new AnonymousClass1(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    public void dismissInternal(boolean r4, boolean r5) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog r1 = this.mDialog;
        if (r1 == null) goto L13;
        r1.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (r5 == true) goto L13;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L12;
        onDismiss(this.mDialog);
        goto L13
    L12:
        this.mHandler.post(this.mDismissRunnable);
    L13:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L16;
        requireFragmentManager().popBackStack(this.mBackStackId, 1);
        this.mBackStackId = -1;
        return;
    L16:
        FragmentTransaction r6 = requireFragmentManager().beginTransaction();
        r6.remove(this);
        if (r4 == false) goto L19;
        r6.commitAllowingStateLoss();
        return;
    L19:
        r6.commit();
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle r3) {
        super.onActivityCreated(r3);
        if (this.mShowsDialog == true) goto L5;
        return;
    L5:
        View r0 = getView();
        if (r0 != null) goto L8;
    L12:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L15;
        this.mDialog.setOwnerActivity(r1);
    L15:
        this.mDialog.setCancelable(this.mCancelable);
        this.mDialog.setOnCancelListener(this);
        this.mDialog.setOnDismissListener(this);
        if (r3 == null) goto L21;
        Bundle r4 = r3.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r4 == null) goto L22;
        this.mDialog.onRestoreInstanceState(r4);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (r0.getParent() != null) goto L11;
        this.mDialog.setContentView(r0);
        goto L12
    L11:
        throw new IllegalStateException("DialogFragment can not be attached to a container view");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context r1) {
        super.onAttach(r1);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface r1) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r4) {
        super.onCreate(r4);
        this.mHandler = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r0 = true;
    L6:
        this.mShowsDialog = r0;
        if (r4 == null) goto L10;
        this.mStyle = r4.getInt(SAVED_STYLE, 0);
        this.mTheme = r4.getInt(SAVED_THEME, 0);
        this.mCancelable = r4.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = r4.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = r4.getInt(SAVED_BACK_STACK_ID, -1);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle r2) {
        return new Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L9;
        this.mViewDestroyed = true;
        r0.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (this.mDismissed == true) goto L7;
        onDismiss(this.mDialog);
    L7:
        this.mDialog = null;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mShownByMe == false) goto L5;
        return;
    L5:
        if (this.mDismissed == true) goto L9;
        this.mDismissed = true;
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface r1) {
        if (this.mViewDestroyed == true) goto L6;
        dismissInternal(true, true);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r3) {
        if (this.mShowsDialog == false) goto L5;
        Dialog r4 = onCreateDialog(r3);
        this.mDialog = r4;
        if (r4 == null) goto L11;
        setupDialog(r4, this.mStyle);
        return (LayoutInflater) this.mDialog.getContext().getSystemService("layout_inflater");
    L11:
        return (LayoutInflater) this.mHost.getContext().getSystemService("layout_inflater");
    L5:
        return super.onGetLayoutInflater(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r3) {
        super.onSaveInstanceState(r3);
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L7;
        Bundle r1 = r0.onSaveInstanceState();
        if (r1 == null) goto L7;
        r3.putBundle(SAVED_DIALOG_STATE_TAG, r1);
    L7:
        int r2 = this.mStyle;
        if (r2 == 0) goto L10;
        r3.putInt(SAVED_STYLE, r2);
    L10:
        int r4 = this.mTheme;
        if (r4 == 0) goto L13;
        r3.putInt(SAVED_THEME, r4);
    L13:
        boolean r5 = this.mCancelable;
        if (r5 == true) goto L16;
        r3.putBoolean(SAVED_CANCELABLE, r5);
    L16:
        boolean r6 = this.mShowsDialog;
        if (r6 == true) goto L19;
        r3.putBoolean(SAVED_SHOWS_DIALOG, r6);
    L19:
        int r7 = this.mBackStackId;
        if (r7 == (-1)) goto L23;
        r3.putInt(SAVED_BACK_STACK_ID, r7);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        this.mViewDestroyed = false;
        r0.show();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean r1) {
        this.mCancelable = r1;
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.setCancelable(r1);
        return;
    }

    public void setShowsDialog(boolean r1) {
        this.mShowsDialog = r1;
    }

    public void setStyle(int r2, @StyleRes int r3) {
        this.mStyle = r2;
        if (r2 != 2) goto L5;
    L6:
        this.mTheme = R.style.Theme.Panel;
    L7:
        if (r3 == 0) goto L10;
        this.mTheme = r3;
        return;
    L10:
        return;
    L5:
        if (r2 != 3) goto L7;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r2, int r3) {
        if (r3 != 1) goto L5;
    L10:
        r2.requestWindowFeature(1);
        return;
    L5:
        if (r3 == 2) goto L10;
        if (r3 != 3) goto L12;
        r2.getWindow().addFlags(24);
        goto L10
    }

    public void show(@NonNull FragmentManager r2, @Nullable String r3) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r4 = r2.beginTransaction();
        r4.add(this, r3);
        r4.commit();
    }

    public void showNow(@NonNull FragmentManager r2, @Nullable String r3) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r4 = r2.beginTransaction();
        r4.add(this, r3);
        r4.commitNow();
    }

    public int show(@NonNull FragmentTransaction r3, @Nullable String r4) {
        this.mDismissed = false;
        this.mShownByMe = true;
        r3.add(this, r4);
        this.mViewDestroyed = false;
        int r5 = r3.commit();
        this.mBackStackId = r5;
        return r5;
    }
}
