package com.android.settings.inputmethod;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class KeyboardLayoutDialogFragment extends DialogFragment implements InputManager.InputDeviceListener, LoaderManager.LoaderCallbacks<Keyboards> {
    private static final String KEY_INPUT_DEVICE_IDENTIFIER = "inputDeviceIdentifier";
    private KeyboardLayoutAdapter mAdapter;
    private boolean mHasShownLayoutSelectionScreen;
    private InputManager mIm;
    private int mInputDeviceId;
    private InputDeviceIdentifier mInputDeviceIdentifier;

    private static final class KeyboardLayoutAdapter extends ArrayAdapter<KeyboardLayout> {
        private int mCheckedItem;
        private final LayoutInflater mInflater;

        public KeyboardLayoutAdapter(Context r2) {
            super(r2, 17367470);
            this.mCheckedItem = -1;
            this.mInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
        }

        public void setCheckedItem(int r1) {
            this.mCheckedItem = r1;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r9, View r10, ViewGroup r11) {
            KeyboardLayout r0 = getItem(r9);
            if (r0 == null) goto L5;
            String r1 = r0.getLabel();
            String r2 = r0.getCollection();
        L6:
            String r6 = r2;
            String r5 = r1;
            if (r9 != this.mCheckedItem) goto L9;
            boolean r12 = true;
        L10:
            boolean r7 = r12;
            if (r6.isEmpty() == false) goto L15;
            return inflateOneLine(r10, r11, r5, r7);
        L15:
            return inflateTwoLine(r10, r11, r5, r6, r7);
        L9:
            r12 = false;
            goto L10
        L5:
            r1 = getContext().getString(R.string.keyboard_layout_default_label);
            r2 = "";
            goto L6
        }

        private View inflateOneLine(View r2, ViewGroup r3, String r4, boolean r5) {
            if (r2 != null) goto L4;
        L5:
            r2 = this.mInflater.inflate(android.R.layout.simple_list_item_single_choice, r3, false);
            setTwoLine(r2, false);
        L6:
            CheckedTextView r1 = (CheckedTextView) r2.findViewById(android.R.id.text1);
            if (r1 == null) goto L9;
            r1.setText(r4);
            r1.setChecked(r5);
        L9:
            return r2;
        L4:
            if (isTwoLine(r2) == false) goto L6;
            goto L5
        }

        private View inflateTwoLine(View r2, ViewGroup r3, String r4, String r5, boolean r6) {
            if (r2 != null) goto L4;
        L5:
            r2 = this.mInflater.inflate(17367470, r3, false);
            setTwoLine(r2, true);
        L6:
            TextView r1 = (TextView) r2.findViewById(android.R.id.text1);
            TextView r7 = (TextView) r2.findViewById(android.R.id.text2);
            RadioButton r0 = (RadioButton) r2.findViewById(android.R.id.smallIcon);
            r1.setText(r4);
            r7.setText(r5);
            r0.setChecked(r6);
            return r2;
        L4:
            if (isTwoLine(r2) == true) goto L6;
            goto L5
        }

        private static boolean isTwoLine(View r1) {
            if (r1.getTag() != Boolean.TRUE) goto L5;
            return true;
        L5:
            return false;
        }

        private static void setTwoLine(View r0, boolean r1) {
            r0.setTag(Boolean.valueOf(r1));
        }
    }

    private static final class KeyboardLayoutLoader extends AsyncTaskLoader<Keyboards> {
        private final InputDeviceIdentifier mInputDeviceIdentifier;

        @Override // androidx.loader.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ Keyboards loadInBackground() {
            return loadInBackground();
        }

        public KeyboardLayoutLoader(Context r1, InputDeviceIdentifier r2) {
            super(r1);
            this.mInputDeviceIdentifier = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.loader.content.AsyncTaskLoader
        public Keyboards loadInBackground() {
            new Keyboards();
            InputManager r1 = (InputManager) getContext().getSystemService("input");
            throw null;
        }

        @Override // androidx.loader.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Override // androidx.loader.content.Loader
        protected void onStopLoading() {
            super.onStopLoading();
            cancelLoad();
        }
    }

    public static final class Keyboards {
        public int current;
        public final ArrayList<KeyboardLayout> keyboardLayouts;

        public Keyboards() {
            this.keyboardLayouts = new ArrayList();
            this.current = -1;
        }
    }

    public interface OnSetupKeyboardLayoutsListener {
        void onSetupKeyboardLayouts(InputDeviceIdentifier r1);
    }

    private void showSetupKeyboardLayoutsIfNecessary() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_inputmethod_KeyboardLayoutDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int r1) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_inputmethod_KeyboardLayoutDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(KeyboardLayoutDialogFragment r0, int r1) {
        r0.onKeyboardLayoutClicked(r1);
    }

    static /* synthetic */ void access$100(KeyboardLayoutDialogFragment r0) {
        r0.onSetupLayoutsButtonClicked();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Keyboards> r1, Keyboards r2) {
        onLoadFinished2(r1, r2);
    }

    public KeyboardLayoutDialogFragment() {
        this.mInputDeviceId = -1;
    }

    public KeyboardLayoutDialogFragment(InputDeviceIdentifier r2) {
        this.mInputDeviceId = -1;
        this.mInputDeviceIdentifier = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r2) {
        super.onAttach(r2);
        Context r3 = r2.getBaseContext();
        this.mIm = (InputManager) r3.getSystemService("input");
        this.mAdapter = new KeyboardLayoutAdapter(r3);
    }

    public void com_android_settings_inputmethod_KeyboardLayoutDialogFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        if (r3 == null) goto L5;
        this.mInputDeviceIdentifier = r3.getParcelable(KEY_INPUT_DEVICE_IDENTIFIER);
    L5:
        LoaderManager.getInstance(this).initLoader(0, null, this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putParcelable(KEY_INPUT_DEVICE_IDENTIFIER, this.mInputDeviceIdentifier);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        FragmentActivity r6 = getActivity();
        LayoutInflater r0 = LayoutInflater.from(r6);
        AlertDialog.Builder r7 = new AlertDialog.Builder(r6).setTitle(R.string.keyboard_layout_dialog_title).setPositiveButton(R.string.keyboard_layout_dialog_setup_button, new AnonymousClass2(this)).setSingleChoiceItems(this.mAdapter, -1, new AnonymousClass1(this)).setView(r0.inflate(R.layout.keyboard_layout_dialog_switch_hint, null));
        updateSwitchHintVisibility();
        return r7.create();
    }

    public void com_android_settings_inputmethod_KeyboardLayoutDialogFragment__onResume$___twin___() {
        super.onResume();
        this.mIm.registerInputDeviceListener(this, null);
        InputDevice r0 = this.mIm.getInputDeviceByDescriptor(this.mInputDeviceIdentifier.getDescriptor());
        if (r0 != null) goto L6;
        dismiss();
        return;
    L6:
        this.mInputDeviceId = r0.getId();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mIm.unregisterInputDeviceListener(this);
        this.mInputDeviceId = -1;
        super.onPause();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        dismiss();
    }

    private void onSetupLayoutsButtonClicked() {
        ((OnSetupKeyboardLayoutsListener) getTargetFragment()).onSetupKeyboardLayouts(this.mInputDeviceIdentifier);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        show(getActivity().getSupportFragmentManager(), "layout");
    }

    private void onKeyboardLayoutClicked(int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 >= this.mAdapter.getCount()) goto L11;
        KeyboardLayout r4 = this.mAdapter.getItem(r3);
        if (r4 == null) goto L8;
        this.mIm.setCurrentKeyboardLayoutForInputDevice(this.mInputDeviceIdentifier, r4.getDescriptor());
    L8:
        dismiss();
        return;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<Keyboards> onCreateLoader(int r1, Bundle r2) {
        return new KeyboardLayoutLoader(getActivity().getBaseContext(), this.mInputDeviceIdentifier);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<Keyboards> r2, Keyboards r3) {
        this.mAdapter.clear();
        this.mAdapter.addAll(r3.keyboardLayouts);
        this.mAdapter.setCheckedItem(r3.current);
        AlertDialog r4 = (AlertDialog) getDialog();
        if (r4 == null) goto L5;
        r4.getListView().setItemChecked(r3.current, true);
    L5:
        updateSwitchHintVisibility();
        showSetupKeyboardLayoutsIfNecessary();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Keyboards> r1) {
        this.mAdapter.clear();
        updateSwitchHintVisibility();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int r3) {
        int r0 = this.mInputDeviceId;
        if (r0 < 0) goto L7;
        if (r3 != r0) goto L8;
        LoaderManager.getInstance(this).restartLoader(0, null, this);
        return;
    L8:
        return;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int r2) {
        int r0 = this.mInputDeviceId;
        if (r0 < 0) goto L7;
        if (r2 != r0) goto L8;
        dismiss();
        return;
    L8:
        return;
    }

    private void updateSwitchHintVisibility() {
        AlertDialog r0 = (AlertDialog) getDialog();
        if (r0 == null) goto L10;
        View r1 = r0.findViewById(android.R.id.edittext_container);
        if (this.mAdapter.getCount() <= 1) goto L7;
        int r2 = 0;
    L8:
        r1.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_inputmethod_KeyboardLayoutDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyboardLayoutDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_KeyboardLayoutDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_KeyboardLayoutDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyboardLayoutDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_inputmethod_KeyboardLayoutDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_inputmethod_KeyboardLayoutDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyboardLayoutDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_inputmethod_KeyboardLayoutDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
