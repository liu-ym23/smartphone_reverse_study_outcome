package com.android.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.security.IKeyChainService;
import android.security.KeyChain;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserCredentialsSettings extends OptionsMenuFragment implements AdapterView.OnItemClickListener {
    private static final String TAG = "UserCredentialsSettings";
    private ListView mListView;
    private View mRootView;

    /* JADX INFO: renamed from: com.android.settings.UserCredentialsSettings$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AliasLoader extends AsyncTask<Void, Void, SortedMap<String, Credential>> {
        final /* synthetic */ UserCredentialsSettings this$0;

        private AliasLoader(UserCredentialsSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AliasLoader(UserCredentialsSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ SortedMap<String, Credential> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(SortedMap<String, Credential> r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected SortedMap<String, Credential> doInBackground2(Void... r4) {
            TreeMap r3 = new TreeMap();
            Credential.Type[] r5 = Credential.Type.values();
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            Credential.Type r2 = r5[r1];
            r1 = r1 + 1;
            goto L3
        L5:
            return r3;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(SortedMap<String, Credential> r4) {
            UserCredentialsSettings.access$100(this.this$0).setAdapter(new CredentialAdapter(this.this$0.getContext(), R.layout.user_credential, (Credential[]) r4.values().toArray(new Credential[0])));
        }
    }

    static class Credential implements Parcelable {
        public static final Parcelable.Creator<Credential> CREATOR = null;
        final String alias;
        final EnumSet<Type> storedTypes;

        static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type CA_CERTIFICATE = null;
            public static final Type USER_CERTIFICATE = null;
            public static final Type USER_PRIVATE_KEY = null;
            public static final Type USER_SECRET_KEY = null;
            final String prefix;

            private static /* synthetic */ Type[] $values() {
                return new Type[]{CA_CERTIFICATE, USER_CERTIFICATE, USER_PRIVATE_KEY, USER_SECRET_KEY};
            }

            public static Type valueOf(String r1) {
                return (Type) Enum.valueOf(Type.class, r1);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            static {
                CA_CERTIFICATE = new Type("CA_CERTIFICATE", 0, "CACERT_");
                USER_CERTIFICATE = new Type("USER_CERTIFICATE", 1, "USRCERT_");
                USER_PRIVATE_KEY = new Type("USER_PRIVATE_KEY", 2, "USRPKEY_");
                USER_SECRET_KEY = new Type("USER_SECRET_KEY", 3, "USRSKEY_");
                $VALUES = $values();
            }

            private Type(String r1, int r2, String r3) {
                super(r1, r2);
                this.prefix = r3;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Credential(String r2) {
            this.storedTypes = EnumSet.noneOf(Type.class);
            this.alias = r2;
        }

        Credential(Parcel r10) {
            this(r10.readString());
            long r0 = r10.readLong();
            Type[] r11 = Type.values();
            int r2 = r11.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            Type r4 = r11[r3];
            if (((1 << r4.ordinal()) & r0) == 0) goto L7;
            this.storedTypes.add(r4);
        L7:
            r3 = r3 + 1;
            goto L3
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r5, int r6) {
            r5.writeString(this.alias);
            Iterator r4 = this.storedTypes.iterator();
            long r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L6;
            r0 = r0 | (1 << ((Type) r4.next()).ordinal());
            goto L4
        L6:
            r5.writeLong(r0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private static class CredentialAdapter extends ArrayAdapter<Credential> {
        public CredentialAdapter(Context r1, int r2, Credential[] r3) {
            super(r1, r2, r3);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            int r0 = 0;
            if (r5 != null) goto L5;
            r5 = LayoutInflater.from(getContext()).inflate(R.layout.user_credential, r6, false);
        L5:
            Credential r3 = getItem(r4);
            ((TextView) r5.findViewById(R.id.alias)).setText(r3.alias);
            View r7 = r5.findViewById(R.id.contents_userkey);
            if (r3.storedTypes.contains(Credential.Type.USER_PRIVATE_KEY) == false) goto L8;
            int r8 = 0;
        L9:
            r7.setVisibility(r8);
            View r9 = r5.findViewById(R.id.contents_usercrt);
            if (r3.storedTypes.contains(Credential.Type.USER_CERTIFICATE) == false) goto L12;
            int r10 = 0;
        L13:
            r9.setVisibility(r10);
            View r11 = r5.findViewById(R.id.contents_cacrt);
            if (r3.storedTypes.contains(Credential.Type.CA_CERTIFICATE) == true) goto L17;
            r0 = 8;
        L17:
            r11.setVisibility(r0);
            return r5;
        L12:
            r10 = 8;
            goto L13
        L8:
            r8 = 8;
            goto L9
        }
    }

    public static class CredentialDialogFragment extends DialogFragment {
        private static final String ARG_CREDENTIAL = "credential";
        private static final String TAG = "CredentialDialogFragment";

        private class RemoveCredentialsTask extends AsyncTask<String, Void, Void> {
            private Context context;
            private Fragment targetFragment;
            final /* synthetic */ CredentialDialogFragment this$0;

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ Void doInBackground(String[] r1) {
                return doInBackground2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
                onPostExecute2(r1);
            }

            public RemoveCredentialsTask(CredentialDialogFragment r1, Context r2, Fragment r3) {
                this.this$0 = r1;
                this.context = r2;
                this.targetFragment = r3;
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected Void doInBackground2(String... r6) {
                KeyChain.KeyChainConnection r5 = KeyChain.bind(this.this$0.getContext());     // Catch: InterruptedException -> L17
                IKeyChainService r1 = r5.getService();     // Catch: Throwable -> L10 RemoteException -> L12
                int r2 = r6.length;     // Catch: Throwable -> L10 RemoteException -> L12
                int r3 = 0;
            L5:
                if (r3 >= r2) goto L8;
                r1.removeKeyPair(r6[r3]);     // Catch: Throwable -> L10 RemoteException -> L12
                r3 = r3 + 1;
                goto L5
            L8:
                r5.close();     // Catch: InterruptedException -> L17
                return null;
            L10:
                th = move-exception;
                r5.close();     // Catch: InterruptedException -> L17
                throw th;     // Catch: InterruptedException -> L17
            L12:
                e = move-exception;
                OLog.w(CredentialDialogFragment.TAG, "Removing credentials", e);     // Catch: Throwable -> L10
            L17:
                e = move-exception;
                OLog.w(CredentialDialogFragment.TAG, "Connecting to keychain", e);
                return null;
            }

            /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
            protected void onPostExecute2(Void r1) {
                Fragment r0 = this.targetFragment;
                if ((r0 instanceof UserCredentialsSettings) == false) goto L6;
                ((UserCredentialsSettings) r0).refreshItems();
                return;
            }
        }

        public void com_android_settings_UserCredentialsSettings$CredentialDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_UserCredentialsSettings$CredentialDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_UserCredentialsSettings$CredentialDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_UserCredentialsSettings$CredentialDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public CredentialDialogFragment() {
        }

        public static void show(Fragment r3, Credential r4) {
            Bundle r0 = new Bundle();
            r0.putParcelable(ARG_CREDENTIAL, r4);
            if (r3.getParentFragmentManager().findFragmentByTag(TAG) != null) goto L6;
            CredentialDialogFragment r5 = new CredentialDialogFragment();
            r5.setTargetFragment(r3, -1);
            r5.setArguments(r0);
            r5.show(r3.getParentFragmentManager(), TAG);
            return;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r9) {
            final Credential r10 = (Credential) getArguments().getParcelable(ARG_CREDENTIAL);
            View r0 = getActivity().getLayoutInflater().inflate(R.layout.user_credential_dialog, null);
            ((ViewGroup) r0.findViewById(R.id.credential_container)).addView(new CredentialAdapter(getActivity(), R.layout.user_credential, new Credential[]{r10}).getView(0, null, null));
            UserManager r1 = (UserManager) getContext().getSystemService(PickApplicationActivity.EXTRA_USER);
            AlertDialog.Builder r2 = new AlertDialog.Builder(getActivity()).setView(r0).setTitle(R.string.user_credential_title).setPositiveButton(R.string.done, null);
            final int r3 = UserHandle.myUserId();
            if (MultiSDKAdapterNew.hasBaseUserRestriction(getContext(), "no_config_credentials", r3) == true) goto L6;
            r2.setNegativeButton(R.string.trusted_credentials_remove_label, new AnonymousClass1(this, r3, r10));
        L6:
            return r2.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_UserCredentialsSettings$CredentialDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CredentialDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_UserCredentialsSettings$CredentialDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_UserCredentialsSettings$CredentialDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CredentialDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_UserCredentialsSettings$CredentialDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_UserCredentialsSettings$CredentialDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CredentialDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_UserCredentialsSettings$CredentialDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public void com_android_settings_UserCredentialsSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_UserCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_UserCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UserCredentialsSettings() {
    }

    static /* synthetic */ ListView access$100(UserCredentialsSettings r0) {
        return r0.mListView;
    }

    public void com_android_settings_UserCredentialsSettings__onResume$___twin___() {
        super.onResume();
        refreshItems();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.user_credentials, r3, false);
        this.mRootView = r5;
        ListView r6 = (ListView) r5.findViewById(R.id.credential_list);
        this.mListView = r6;
        r6.setOnItemClickListener(this);
        return this.mRootView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        CredentialDialogFragment.show(this, (Credential) r1.getItemAtPosition(r3));
    }

    protected void refreshItems() {
        if (isAdded() == false) goto L6;
        new AliasLoader(this, null).execute(new Void[0]);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_UserCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UserCredentialsSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UserCredentialsSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UserCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UserCredentialsSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_UserCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UserCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UserCredentialsSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_UserCredentialsSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
