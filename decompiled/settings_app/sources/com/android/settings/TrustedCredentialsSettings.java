package com.android.settings;

import android.content.Intent;
import android.content.pm.UserInfo;
import android.net.http.SslCertificate;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.security.IKeyChainService;
import android.security.KeyChain;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.net.ObricSslCertificate;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.tab.OTabLayout;
import com.obric.privacy.GrantUtil;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.ButtonTabGroup;

/* JADX INFO: loaded from: classes2.dex */
public class TrustedCredentialsSettings extends BaseFragment {
    public static final String ARG_SHOW_NEW_FOR_USER = "ARG_SHOW_NEW_FOR_USER";
    private static final String TAG = "TrustedCredentialsSettings";
    private static final String USER_ACTION = "com.android.settings.TRUSTED_CREDENTIALS_USER";
    private OSheet mCertDialog;
    private int mCurrentSelectIndex;
    private final SparseArray<KeyChain.KeyChainConnection> mKeyChainConnectionByProfileId;
    private OPopover mPopOver;
    private FrameLayout mSystemTab;
    private ButtonTabGroup mTypeSwitchButtonTab;
    private UserManager mUserManager;
    private FrameLayout mUserTab;
    private OTabLayout tabLayout;

    /* JADX INFO: renamed from: com.android.settings.TrustedCredentialsSettings$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab = null;

        static {
            int[] r0 = new int[Tab.values().length];
            $SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab = r0;
            r0[Tab.SYSTEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab[Tab.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private class AdapterData {
        private final TrustedCertificateAdapterCommons mAdapter;
        private final SparseArray<List<CertHolder>> mCertHoldersByUserId;
        private final Tab mTab;
        final /* synthetic */ TrustedCredentialsSettings this$0;

        private class AliasLoader extends AsyncTask<Void, Integer, SparseArray<List<CertHolder>>> {
            private View mList;
            private OProgressView mProgressBar;
            final /* synthetic */ AdapterData this$1;

            private AliasLoader(AdapterData r1) {
                this.this$1 = r1;
            }

            /* synthetic */ AliasLoader(AdapterData r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ SparseArray<List<CertHolder>> doInBackground(Void[] r1) {
                return doInBackground2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onPostExecute(SparseArray<List<CertHolder>> r1) {
                onPostExecute2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onProgressUpdate(Integer[] r1) {
                onProgressUpdate2(r1);
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                View r0 = this.this$1.this$0.findViewByIdNullable(Tab.access$1700(AdapterData.access$1400(this.this$1)));
                this.mProgressBar = (OProgressView) r0.findViewById(Tab.access$1800(AdapterData.access$1400(this.this$1)));
                this.mList = r0.findViewById(AdapterData.access$1900(this.this$1).getListViewId(AdapterData.access$1400(this.this$1)));
                this.mProgressBar.setVisibility(0);
                this.mList.setVisibility(8);
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected SparseArray<List<CertHolder>> doInBackground2(Void... r27) {
                String r1 = TrustedCredentialsSettings.TAG;
                SparseArray<List<CertHolder>> r2 = new SparseArray();
                List<UserHandle> r3 = TrustedCredentialsSettings.access$1300(this.this$1.this$0).getUserProfiles();     // Catch: InterruptedException -> L36 RemoteException -> L40
                int r4 = r3.size();     // Catch: InterruptedException -> L36 RemoteException -> L40
                SparseArray r5 = new SparseArray(r4);     // Catch: InterruptedException -> L36 RemoteException -> L40
                int r7 = 0;
                int r8 = 0;
            L4:
                int r9 = 10;
                if (r7 >= r4) goto L13;
                UserHandle r10 = r3.get(r7);     // Catch: InterruptedException -> L36 RemoteException -> L40
                int r11 = r10.getIdentifier();     // Catch: InterruptedException -> L36 RemoteException -> L40
                if (r11 != 10) goto L10;
            L12:
                r7 = r7 + 1;     // Catch: InterruptedException -> L36 RemoteException -> L40
                goto L4
            L10:
                if (this.this$1.this$0.isAdded() == false) goto L12;
                KeyChain.KeyChainConnection r12 = KeyChain.bindAsUser(this.this$1.this$0.getActivity(), r10);     // Catch: InterruptedException -> L36 RemoteException -> L40
                TrustedCredentialsSettings.access$2000(this.this$1.this$0).put(r11, r12);     // Catch: InterruptedException -> L36 RemoteException -> L40
                List r13 = Tab.access$2100(AdapterData.access$1400(this.this$1), r12.getService());     // Catch: InterruptedException -> L36 RemoteException -> L40
                r8 = r8 + r13.size();     // Catch: InterruptedException -> L36 RemoteException -> L40
                r5.put(r11, r13);     // Catch: InterruptedException -> L36 RemoteException -> L40
                goto L12
            L13:
                int r14 = 0;
                int r15 = 0;
            L14:
                if (r14 >= r4) goto L35;
                int r16 = r3.get(r14).getIdentifier();     // Catch: InterruptedException -> L36 RemoteException -> L40
                if (r16 != r9) goto L18;
            L17:
                String r24 = r1;
                List<UserHandle> r20 = r3;
                int r21 = r4;
                SparseArray r22 = r5;
            L34:
                r14 = r14 + 1;
                r3 = r20;
                r4 = r21;
                r5 = r22;
                r1 = r24;
                r9 = 10;
                goto L14
            L18:
                List r17 = (List) r5.get(r16);     // Catch: InterruptedException -> L36 RemoteException -> L40
                if (this.this$1.this$0.isAdded() == false) goto L17;
                IKeyChainService r18 = ((KeyChain.KeyChainConnection) TrustedCredentialsSettings.access$2000(this.this$1.this$0).get(r16)).getService();     // Catch: InterruptedException -> L36 RemoteException -> L40
                ArrayList r19 = new ArrayList(r8);     // Catch: InterruptedException -> L36 RemoteException -> L40
                if (r17 == null) goto L17;
                int r110 = r17.size();     // Catch: InterruptedException -> L36 RemoteException -> L40
                int r23 = 0;
            L24:
                if (r23 >= r110) goto L28;
                String r6 = (String) r17.get(r23);     // Catch: InterruptedException -> L36 RemoteException -> L40
                List<UserHandle> r25 = r3;
                int r26 = r4;
                SparseArray r28 = r5;
                int r29 = r110;
                String r210 = r1;
                ArrayList r30 = r19;
                IKeyChainService r211 = r18;
                List r31 = r17;
                r30.add(new CertHolder(r18, AdapterData.access$1900(this.this$1), AdapterData.access$1400(this.this$1), r6, KeyChain.toCertificate(r18.getEncodedCaCertificate(r6, true)), r16, null));     // Catch: InterruptedException -> L30 RemoteException -> L32
                r15 = r15 + 1;     // Catch: InterruptedException -> L30 RemoteException -> L32
                publishProgress(new Integer[]{Integer.valueOf(r15), Integer.valueOf(r8)});     // Catch: InterruptedException -> L30 RemoteException -> L32
                r23 = r23 + 1;     // Catch: InterruptedException -> L30 RemoteException -> L32
                r19 = r30;
                r17 = r31;
                r3 = r25;
                r4 = r26;
                r5 = r28;
                r110 = r29;
                r1 = r210;
                r18 = r211;
            L32:
                e = e;
                String r32 = r210;
            L42:
                OLog.e(r32, "Remote exception while loading aliases.", e);
                return new SparseArray();
            L30:
                e = e;
            L38:
                OLog.e(r210, "InterruptedException while loading aliases.", e);
                return new SparseArray();
            L28:
                r24 = r1;
                r20 = r3;
                r21 = r4;
                r22 = r5;
                ArrayList r33 = r19;
                Collections.sort(r33);     // Catch: InterruptedException -> L30 RemoteException -> L32
                r2.put(r16, r33);     // Catch: InterruptedException -> L30 RemoteException -> L32
                goto L34
            L35:
                return r2;
            L40:
                e = e;
                r32 = r1;
            L36:
                e = e;
                r210 = r1;
                goto L38
            }

            /* JADX INFO: renamed from: onProgressUpdate, reason: avoid collision after fix types in other method */
            protected void onProgressUpdate2(Integer... r2) {
                int r3 = r2[0].intValue();
                this.mProgressBar.setProgress(r3);
            }

            /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
            protected void onPostExecute2(SparseArray<List<CertHolder>> r7) {
                AdapterData.access$1200(this.this$1).clear();
                int r0 = r7.size();
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L5;
                AdapterData.access$1200(this.this$1).put(r7.keyAt(r2), r7.valueAt(r2));
                r2 = r2 + 1;
                goto L3
            L5:
                AdapterData.access$1900(this.this$1).notifyDataSetChanged();
                this.mProgressBar.setVisibility(8);
                this.mList.setVisibility(0);
                this.mProgressBar.setProgress(0);
            }
        }

        /* synthetic */ AdapterData(TrustedCredentialsSettings r1, Tab r2, TrustedCertificateAdapterCommons r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ SparseArray access$1200(AdapterData r0) {
            return r0.mCertHoldersByUserId;
        }

        static /* synthetic */ Tab access$1400(AdapterData r0) {
            return r0.mTab;
        }

        static /* synthetic */ TrustedCertificateAdapterCommons access$1900(AdapterData r0) {
            return r0.mAdapter;
        }

        private AdapterData(TrustedCredentialsSettings r1, Tab r2, TrustedCertificateAdapterCommons r3) {
            this.this$0 = r1;
            this.mCertHoldersByUserId = new SparseArray();
            this.mAdapter = r3;
            this.mTab = r2;
        }

        public void remove(CertHolder r2) {
            SparseArray<List<CertHolder>> r1 = this.mCertHoldersByUserId;
            if (r1 == null) goto L8;
            List<CertHolder> r3 = r1.get(r2.mProfileId);
            if (r3 == null) goto L9;
            r3.remove(r2);
            return;
        L9:
            return;
        }
    }

    private class AliasOperation extends AsyncTask<Void, Void, Boolean> {
        private final CertHolder mCertHolder;
        final /* synthetic */ TrustedCredentialsSettings this$0;

        /* synthetic */ AliasOperation(TrustedCredentialsSettings r1, CertHolder r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        private AliasOperation(TrustedCredentialsSettings r1, CertHolder r2) {
            this.this$0 = r1;
            this.mCertHolder = r2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... r5) {
            KeyChain.KeyChainConnection r2 = (KeyChain.KeyChainConnection) TrustedCredentialsSettings.access$2000(this.this$0).get(this.mCertHolder.mProfileId);     // Catch: RemoteException -> L13 IllegalStateException -> L16 CertificateEncodingException -> L19
            if (r2 == null) goto L6;
            IKeyChainService r3 = r2.getService();     // Catch: RemoteException -> L13 IllegalStateException -> L16 CertificateEncodingException -> L19
            if (CertHolder.access$000(this.mCertHolder) == false) goto L12;
            r3.installCaCertificate(CertHolder.access$3500(this.mCertHolder).getEncoded());     // Catch: RemoteException -> L13 IllegalStateException -> L16 CertificateEncodingException -> L19
            return true;
        L12:
            return Boolean.valueOf(r3.deleteCaCertificate(CertHolder.access$3400(this.mCertHolder)));
        L6:
            return false;
        L13:
            e = move-exception;
            OLog.w(TrustedCredentialsSettings.TAG, "Error while toggling alias " + CertHolder.access$3400(this.mCertHolder), e);
            return false;
        L16:
            e = move-exception;
            OLog.w(TrustedCredentialsSettings.TAG, "Error while toggling alias " + CertHolder.access$3400(this.mCertHolder), e);
            return false;
        L19:
            e = move-exception;
            OLog.w(TrustedCredentialsSettings.TAG, "Error while toggling alias " + CertHolder.access$3400(this.mCertHolder), e);
            return false;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r2) {
            Tab.access$3600(CertHolder.access$100(this.mCertHolder), r2.booleanValue(), this.mCertHolder);
        }
    }

    private static class CertHolder implements Comparable<CertHolder> {
        private final TrustedCertificateAdapterCommons mAdapter;
        private final String mAlias;
        private boolean mDeleted;
        public int mProfileId;
        private final IKeyChainService mService;
        private final SslCertificate mSslCert;
        private final String mSubjectPrimary;
        private final String mSubjectSecondary;
        private final Tab mTab;
        private final X509Certificate mX509Cert;

        /* synthetic */ CertHolder(IKeyChainService r1, TrustedCertificateAdapterCommons r2, Tab r3, String r4, X509Certificate r5, int r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        static /* synthetic */ boolean access$000(CertHolder r0) {
            return r0.mDeleted;
        }

        static /* synthetic */ boolean access$002(CertHolder r0, boolean r1) {
            r0.mDeleted = r1;
            return r1;
        }

        static /* synthetic */ Tab access$100(CertHolder r0) {
            return r0.mTab;
        }

        static /* synthetic */ TrustedCertificateAdapterCommons access$200(CertHolder r0) {
            return r0.mAdapter;
        }

        static /* synthetic */ String access$2600(CertHolder r0) {
            return r0.mSubjectPrimary;
        }

        static /* synthetic */ String access$2700(CertHolder r0) {
            return r0.mSubjectSecondary;
        }

        static /* synthetic */ SslCertificate access$2900(CertHolder r0) {
            return r0.mSslCert;
        }

        static /* synthetic */ String access$3400(CertHolder r0) {
            return r0.mAlias;
        }

        static /* synthetic */ X509Certificate access$3500(CertHolder r0) {
            return r0.mX509Cert;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(CertHolder r1) {
            return compareTo2(r1);
        }

        private CertHolder(IKeyChainService r3, TrustedCertificateAdapterCommons r4, Tab r5, String r6, X509Certificate r7, int r8) {
            this.mProfileId = r8;
            this.mService = r3;
            this.mAdapter = r4;
            this.mTab = r5;
            this.mAlias = r6;
            this.mX509Cert = r7;
            SslCertificate r9 = new SslCertificate(r7);
            this.mSslCert = r9;
            String r10 = r9.getIssuedTo().getCName();
            String r11 = r9.getIssuedTo().getOName();
            String r0 = r9.getIssuedTo().getUName();
            if (r11.isEmpty() == true) goto L9;
            if (r10.isEmpty() == true) goto L7;
            this.mSubjectPrimary = r11;
            this.mSubjectSecondary = r10;
        L17:
            this.mDeleted = Tab.access$2300(r5, r3, r6);     // Catch: RemoteException -> L14
            return;
        L14:
            e = move-exception;
            OLog.e(TrustedCredentialsSettings.TAG, "Remote exception while checking if alias " + this.mAlias + " is deleted.", e);
            this.mDeleted = false;
            return;
        L7:
            this.mSubjectPrimary = r11;
            this.mSubjectSecondary = r0;
            goto L17
        L9:
            if (r10.isEmpty() == true) goto L11;
            this.mSubjectPrimary = r10;
            this.mSubjectSecondary = "";
            goto L17
        L11:
            this.mSubjectPrimary = r9.getIssuedTo().getDName();
            this.mSubjectSecondary = "";
            goto L17
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(CertHolder r3) {
            int r0 = this.mSubjectPrimary.compareToIgnoreCase(r3.mSubjectPrimary);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return this.mSubjectSecondary.compareToIgnoreCase(r3.mSubjectSecondary);
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof CertHolder) == true) goto L7;
            return false;
        L7:
            return this.mAlias.equals(((CertHolder) r2).mAlias);
        }

        public int hashCode() {
            return this.mAlias.hashCode();
        }

        public boolean isBytedanceCertificate() {
            return "Technology Co.,Ltd.".equals(this.mSubjectPrimary);
        }
    }

    interface OnCertItemClickListener {
        void onCertItemClick(View r1, int r2, int r3);
    }

    private static final enum Tab extends Enum<Tab> {
        private static final /* synthetic */ Tab[] $VALUES = null;
        public static final Tab SYSTEM = null;
        public static final Tab USER = null;
        private boolean isShowExpand;
        private final boolean mCheckbox;
        private final int mExpandableList;
        private final int mList;
        private final int mProgress;
        private final String mTag;
        private final int mView;

        private static /* synthetic */ Tab[] $values() {
            return new Tab[]{SYSTEM, USER};
        }

        static /* synthetic */ int access$1700(Tab r0) {
            return r0.mView;
        }

        static /* synthetic */ int access$1800(Tab r0) {
            return r0.mProgress;
        }

        static /* synthetic */ List access$2100(Tab r0, IKeyChainService r1) throws RemoteException {
            return r0.getAliases(r1);
        }

        static /* synthetic */ boolean access$2300(Tab r0, IKeyChainService r1, String r2) throws RemoteException {
            return r0.deleted(r1, r2);
        }

        static /* synthetic */ boolean access$2800(Tab r0) {
            return r0.mCheckbox;
        }

        static /* synthetic */ int access$3100(Tab r0, CertHolder r1) {
            return r0.getButtonLabel(r1);
        }

        static /* synthetic */ int access$3200(Tab r0, CertHolder r1) {
            return r0.getButtonConfirmation(r1);
        }

        static /* synthetic */ void access$3600(Tab r0, boolean r1, CertHolder r2) {
            r0.postOperationUpdate(r1, r2);
        }

        static /* synthetic */ boolean access$400(Tab r0) {
            return r0.isShowExpand;
        }

        static /* synthetic */ int access$500(Tab r0) {
            return r0.mExpandableList;
        }

        static /* synthetic */ int access$600(Tab r0) {
            return r0.mList;
        }

        public static Tab valueOf(String r1) {
            return (Tab) Enum.valueOf(Tab.class, r1);
        }

        public static Tab[] values() {
            return (Tab[]) $VALUES.clone();
        }

        static {
            SYSTEM = new Tab("SYSTEM", 0, SettingsSwitchKeyUtil.SettingTable.System, R.id.system_tab, R.id.system_progress, R.id.system_list, R.id.system_expandable_list, true);
            USER = new Tab("USER", 1, PickApplicationActivity.EXTRA_USER, R.id.user_tab, R.id.user_progress, R.id.user_list, R.id.user_expandable_list, false);
            $VALUES = $values();
        }

        private Tab(String r1, int r2, String r3, int r4, int r5, int r6, int r7, boolean r8) {
            super(r1, r2);
            this.isShowExpand = false;
            this.mTag = r3;
            this.mView = r4;
            this.mProgress = r5;
            this.mList = r6;
            this.mExpandableList = r7;
            this.mCheckbox = r8;
        }

        public boolean isShowExpand() {
            return this.isShowExpand;
        }

        public void setShowExpand(boolean r1) {
            this.isShowExpand = r1;
        }

        private List<String> getAliases(IKeyChainService r2) throws RemoteException {
            int r1 = AnonymousClass8.$SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab[ordinal()];
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return MultiSDKAdapter.getSystemCaAliases(r2);
        L9:
            return MultiSDKAdapter.getUserCaAliases(r2);
        L11:
            return MultiSDKAdapter.getSystemCaAliases(r2);
        }

        private boolean deleted(IKeyChainService r3, String r4) throws RemoteException {
            int r0 = AnonymousClass8.$SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab[ordinal()];
            if (r0 == 1) goto L11;
            if (r0 != 2) goto L9;
            return false;
        L9:
            throw new AssertionError("invalid tab: " + this);
        L11:
            return !r3.containsCaAlias(r4);
        }

        private int getButtonLabel(CertHolder r4) {
            int r3 = AnonymousClass8.$SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab[ordinal()];
            if (r3 == 1) goto L13;
            if (r3 != 2) goto L7;
            return R.string.trusted_credentials_remove_label;
        L7:
            if (CertHolder.access$000(r4) == false) goto L9;
            return R.string.trusted_credentials_enable_label;
        L9:
            return R.string.trusted_credentials_disable_label;
        L13:
            if (CertHolder.access$000(r4) == false) goto L15;
            return R.string.trusted_credentials_enable_label;
        L15:
            return R.string.trusted_credentials_disable_label;
        }

        private int getButtonConfirmation(CertHolder r4) {
            int r3 = AnonymousClass8.$SwitchMap$com$android$settings$TrustedCredentialsSettings$Tab[ordinal()];
            if (r3 == 1) goto L13;
            if (r3 != 2) goto L7;
            return R.string.trusted_credentials_remove_confirmation;
        L7:
            if (CertHolder.access$000(r4) == false) goto L9;
            return R.string.trusted_credentials_enable_confirmation;
        L9:
            return R.string.trusted_credentials_disable_confirmation;
        L13:
            if (CertHolder.access$000(r4) == false) goto L15;
            return R.string.trusted_credentials_enable_confirmation;
        L15:
            return R.string.trusted_credentials_disable_confirmation;
        }

        private void postOperationUpdate(boolean r1, CertHolder r2) {
            if (r1 == true) goto L4;
            CertHolder.access$200(r2).load();
            return;
        L4:
            if (CertHolder.access$100(r2).mCheckbox == false) goto L6;
            CertHolder.access$002(r2, !CertHolder.access$000(r2));
        L7:
            CertHolder.access$200(r2).notifyDataSetChanged();
            return;
        L6:
            CertHolder.access$200(r2).remove(r2);
            goto L7
        }
    }

    private class TrustedCertificateAdapter extends BaseAdapter implements TrustedCertificateAdapterCommons {
        private final AdapterData mData;
        private OnCertItemClickListener mOnSettingsItemClickListener;
        final /* synthetic */ TrustedCredentialsSettings this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        /* synthetic */ TrustedCertificateAdapter(TrustedCredentialsSettings r1, Tab r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        private TrustedCertificateAdapter(TrustedCredentialsSettings r3, Tab r4) {
            this.this$0 = r3;
            this.mData = new AdapterData(r3, r4, this, null);
            load();
        }

        public void setOnSettingsItemClickListener(OnCertItemClickListener r1) {
            this.mOnSettingsItemClickListener = r1;
        }

        @Override // com.android.settings.TrustedCredentialsSettings.TrustedCertificateAdapterCommons
        public void remove(CertHolder r1) {
            this.mData.remove(r1);
        }

        @Override // com.android.settings.TrustedCredentialsSettings.TrustedCertificateAdapterCommons
        public int getListViewId(Tab r1) {
            return Tab.access$600(r1);
        }

        @Override // com.android.settings.TrustedCredentialsSettings.TrustedCertificateAdapterCommons
        public void load() {
            AdapterData r2 = this.mData;
            Objects.requireNonNull(r2);
            new AdapterData.AliasLoader(r2, null).execute(new Void[0]);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (AdapterData.access$1200(this.mData) != null) goto L5;
        L11:
            return 0;
        L5:
            if (AdapterData.access$1200(this.mData).size() == 0) goto L11;
            List r2 = (List) AdapterData.access$1200(this.mData).valueAt(0);
            if (r2 == null) goto L11;
            return r2.size();
        }

        @Override // android.widget.Adapter
        public CertHolder getItem(int r2) {
            return (CertHolder) ((List) AdapterData.access$1200(this.mData).valueAt(0)).get(r2);
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            return TrustedCredentialsSettings.access$1500(this.this$0, getItem(r10), AdapterData.access$1400(this.mData), r11, r12, 0, getCount(), r10, this.mOnSettingsItemClickListener);
        }
    }

    private interface TrustedCertificateAdapterCommons {
        int getListViewId(Tab r1);

        void load();

        void notifyDataSetChanged();

        void remove(CertHolder r1);
    }

    private class TrustedCertificateExpandableAdapter extends BaseExpandableListAdapter implements TrustedCertificateAdapterCommons {
        private AdapterData mData;
        private OnCertItemClickListener mOnSettingsItemClickListener;
        final /* synthetic */ TrustedCredentialsSettings this$0;

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int r1, int r2) {
            return r2;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int r1, int r2) {
            return true;
        }

        /* synthetic */ TrustedCertificateExpandableAdapter(TrustedCredentialsSettings r1, Tab r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // android.widget.ExpandableListAdapter
        public /* bridge */ /* synthetic */ Object getChild(int r1, int r2) {
            return getChild(r1, r2);
        }

        @Override // android.widget.ExpandableListAdapter
        public /* bridge */ /* synthetic */ Object getGroup(int r1) {
            return getGroup(r1);
        }

        private TrustedCertificateExpandableAdapter(TrustedCredentialsSettings r3, Tab r4) {
            this.this$0 = r3;
            this.mData = new AdapterData(r3, r4, this, null);
            load();
        }

        public void setOnSettingsItemClickListener(OnCertItemClickListener r1) {
            this.mOnSettingsItemClickListener = r1;
        }

        @Override // com.android.settings.TrustedCredentialsSettings.TrustedCertificateAdapterCommons
        public void remove(CertHolder r1) {
            this.mData.remove(r1);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return AdapterData.access$1200(this.mData).size();
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int r1) {
            List r0 = (List) AdapterData.access$1200(this.mData).valueAt(r1);
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public UserHandle getGroup(int r2) {
            return new UserHandle(AdapterData.access$1200(this.mData).keyAt(r2));
        }

        @Override // android.widget.ExpandableListAdapter
        public CertHolder getChild(int r1, int r2) {
            return (CertHolder) ((List) AdapterData.access$1200(this.mData).valueAt(r1)).get(r2);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int r1) {
            return AdapterData.access$1200(this.mData).keyAt(r1);
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int r1, boolean r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = Utils.inflateCategoryHeader((LayoutInflater) this.this$0.getActivity().getSystemService("layout_inflater"), r4);
        L4:
            TextView r5 = (TextView) r3.findViewById(android.R.id.title);
            UserHandle r6 = getGroup(r1);
            UserInfo r0 = TrustedCredentialsSettings.access$1300(this.this$0).getUserInfo(r6.getIdentifier());
            if (r0 != null) goto L7;
        L9:
            if (r0 != null) goto L11;
        L13:
            OLog.e(TrustedCredentialsSettings.TAG, "userInfo is null.");
        L14:
            r5.setTextAlignment(6);
            return r3;
        L11:
            if (r0.isManagedProfile() == true) goto L13;
            r5.setText(R.string.category_personal);
            goto L14
        L7:
            if (r0.isManagedProfile() == false) goto L9;
            r5.setText(R.string.category_work);
            goto L14
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int r10, int r11, boolean r12, View r13, ViewGroup r14) {
            return TrustedCredentialsSettings.access$1500(this.this$0, getChild(r10, r11), AdapterData.access$1400(this.mData), r13, r14, r10, getChildrenCount(r10), r11, this.mOnSettingsItemClickListener);
        }

        @Override // com.android.settings.TrustedCredentialsSettings.TrustedCertificateAdapterCommons
        public void load() {
            AdapterData r2 = this.mData;
            Objects.requireNonNull(r2);
            new AdapterData.AliasLoader(r2, null).execute(new Void[0]);
        }

        @Override // com.android.settings.TrustedCredentialsSettings.TrustedCertificateAdapterCommons
        public int getListViewId(Tab r1) {
            return Tab.access$500(r1);
        }
    }

    private static class ViewHolder {
        private OCardListItem itemView;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ OCardListItem access$2500(ViewHolder r0) {
            return r0.itemView;
        }

        static /* synthetic */ OCardListItem access$2502(ViewHolder r0, OCardListItem r1) {
            r0.itemView = r1;
            return r1;
        }
    }

    public void com_android_settings_TrustedCredentialsSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_TrustedCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_TrustedCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TrustedCredentialsSettings() {
        this.mKeyChainConnectionByProfileId = new SparseArray();
        this.mCurrentSelectIndex = -1;
    }

    static /* synthetic */ UserManager access$1300(TrustedCredentialsSettings r0) {
        return r0.mUserManager;
    }

    static /* synthetic */ View access$1500(TrustedCredentialsSettings r0, CertHolder r1, Tab r2, View r3, ViewGroup r4, int r5, int r6, int r7, OnCertItemClickListener r8) {
        return r0.getViewForCertificate(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    static /* synthetic */ SparseArray access$2000(TrustedCredentialsSettings r0) {
        return r0.mKeyChainConnectionByProfileId;
    }

    static /* synthetic */ void access$300(TrustedCredentialsSettings r0, int r1) {
        r0.setSelect(r1);
    }

    static /* synthetic */ OPopover access$3000(TrustedCredentialsSettings r0) {
        return r0.mPopOver;
    }

    static /* synthetic */ OPopover access$3002(TrustedCredentialsSettings r0, OPopover r1) {
        r0.mPopOver = r1;
        return r1;
    }

    static /* synthetic */ OSheet access$800(TrustedCredentialsSettings r0) {
        return r0.mCertDialog;
    }

    static /* synthetic */ OSheet access$802(TrustedCredentialsSettings r0, OSheet r1) {
        r0.mCertDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$900(TrustedCredentialsSettings r0, CertHolder r1) {
        r0.showCertDialog(r1);
    }

    public void com_android_settings_TrustedCredentialsSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mUserManager = (UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.trusted_credentials, r3, false);
        this.tabLayout = (OTabLayout) this.mRootView.findViewById(R.id.tabLayout);
        this.mSystemTab = (FrameLayout) findViewByIdNullable(R.id.system_tab);
        this.mUserTab = (FrameLayout) findViewByIdNullable(R.id.user_tab);
        ArrayList r5 = new ArrayList(2);
        r5.add(getResources().getString(R.string.trusted_credentials_system_tab));
        r5.add(getResources().getString(R.string.trusted_credentials_user_tab));
        this.tabLayout.addOnTabSelectedListener(new AnonymousClass1(this));
        initTab(Tab.SYSTEM);
        initTab(Tab.USER);
        Intent r6 = getActivity().getIntent();
        if (r6 != null) goto L5;
    L7:
        setSelect(0);
    L9:
        return this.mRootView;
    L5:
        if (USER_ACTION.equals(r6.getAction()) == false) goto L7;
        setSelect(1);
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        View r5 = this.mRootView;
        if (r5 != null) goto L6;
        return;
    L6:
        if (Tab.access$400(Tab.SYSTEM) == false) goto L8;
        UIUtils.fitMaskTitle(this, r5, (ListView) this.mSystemTab.findViewById(Tab.access$500(Tab.SYSTEM)), UIUtils.INSTANCE.dp2px(152));
    L10:
        if (Tab.access$400(Tab.USER) == false) goto L12;
        UIUtils.fitMaskTitle(this, r5, (ListView) this.mUserTab.findViewById(Tab.access$500(Tab.USER)), UIUtils.INSTANCE.dp2px(152));
        return;
    L12:
        UIUtils.fitMaskTitle(this, r5, (ListView) this.mUserTab.findViewById(Tab.access$600(Tab.USER)), UIUtils.INSTANCE.dp2px(152));
        return;
    L8:
        UIUtils.fitMaskTitle(this, r5, (ListView) this.mSystemTab.findViewById(Tab.access$600(Tab.SYSTEM)), UIUtils.INSTANCE.dp2px(152));
        goto L10
    }

    private void setSelect(int r5) {
        if (this.mCurrentSelectIndex != r5) goto L5;
        return;
    L5:
        this.mCurrentSelectIndex = r5;
        FrameLayout r0 = this.mSystemTab;
        int r1 = 0;
        if (r5 != 0) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        FrameLayout r2 = this.mUserTab;
        if (r5 == 1) goto L13;
        r1 = 8;
    L13:
        r2.setVisibility(r1);
        this.tabLayout.selectTab(r5);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        closeKeyChainConnections();
        super.onDestroy();
    }

    private void closeKeyChainConnections() {
        int r0 = this.mKeyChainConnectionByProfileId.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (this.mKeyChainConnectionByProfileId.valueAt(r1) == null) goto L7;
        this.mKeyChainConnectionByProfileId.valueAt(r1).close();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.mKeyChainConnectionByProfileId.clear();
    }

    private void initTab(Tab r5) {
        List<UserHandle> r0 = this.mUserManager.getUserProfiles();
        int r1 = r0.size();
        Iterator<UserHandle> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r2.next().getIdentifier() != 10) goto L4;
        r1 = r1 - 1;
        goto L4
    L8:
        AnonymousClass1 r3 = null;
        if (r1 <= 1) goto L11;
        ExpandableListView r4 = (ExpandableListView) findViewByIdNullable(Tab.access$500(r5));
        final TrustedCertificateExpandableAdapter r6 = new TrustedCertificateExpandableAdapter(this, r5, r3);
        r4.setAdapter(r6);
        r6.setOnSettingsItemClickListener(new AnonymousClass2(this, r6));
        r5.setShowExpand(true);
        return;
    L11:
        ListView r7 = (ListView) findViewByIdNullable(Tab.access$600(r5));
        r5.setShowExpand(false);
        final TrustedCertificateAdapter r8 = new TrustedCertificateAdapter(this, r5, r3);
        r8.setOnSettingsItemClickListener(new AnonymousClass3(this, r8));
        r7.setAdapter(r8);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(r7);
    }

    private View getViewForCertificate(CertHolder r4, Tab r5, View r6, ViewGroup r7, final int r8, int r9, final int r10, final OnCertItemClickListener r11) {
        if (r6 != null) goto L5;
        r6 = LayoutInflater.from(getActivity()).inflate(R.layout.trusted_credential, r7, false);
        ViewHolder r12 = new ViewHolder(null);
        ViewHolder.access$2502(r12, (OCardListItem) r6);
        r6.setTag(r12);
    L6:
        OCardListItemUtils.setTitle(ViewHolder.access$2500(r12), CertHolder.access$2600(r4));
        OCardListItemUtils.setSubTitleString(ViewHolder.access$2500(r12), CertHolder.access$2700(r4));
        OCardListItemUtils.initCardItemInAdapter(ViewHolder.access$2500(r12), r9, r10);
        if (Tab.access$2800(r5) == false) goto L13;
        ViewHolder.access$2500(r12).showCustomEnd(true);
        OCardListItem r13 = ViewHolder.access$2500(r12);
        if (CertHolder.access$000(r4) == true) goto L11;
        int r14 = R.string.trusted_credential;
    L12:
        OCardListItemUtils.setTrailingText(r13, getString(r14));
    L14:
        ViewHolder.access$2500(r12).setOnContentClickListener(new TrustedCredentialsSettings$$ExternalSyntheticLambda0(r11, r8, r10));
        return r6;
    L11:
        r14 = R.string.untrusted_credential;
        goto L12
    L13:
        ViewHolder.access$2500(r12).showCustomEnd(false);
        goto L14
    L5:
        r12 = (ViewHolder) r6.getTag();
        goto L6
    }

    static /* synthetic */ void lambda$getViewForCertificate$0(OnCertItemClickListener r0, int r1, int r2, View r3) {
        if (r0 == null) goto L5;
        r0.onCertItemClick(r3, r1, r2);
        return;
    }

    private void showCertDialog(final CertHolder r21) {
        FragmentActivity r2 = getActivity();
        if (r2 != null) goto L6;
        OLog.e(TAG, "showCertDialog, activity is null, return");
        return;
    L6:
        CertHolder.access$2900(r21).inflateCertificateView(getActivity());
        OSheet r3 = new OSheet(r2, 0);
        this.mCertDialog = r3;
        r3.setHeightMode(OSheet.HeightMode.FULL_HEIGHT);
        this.mCertDialog.setSystemInsetsAppearanceLight(null);
        this.mCertDialog.enableIgnoreInsetBottom(false);
        this.mCertDialog.setHeader(OSheet.Header.MODAL, null, null, getString(R.string.ssl_certificate), null, false, null, new AnonymousClass4(this), null, null, null, null, null, null);
        final ArrayList<View> r4 = new ArrayList();
        final ArrayList<String> r5 = new ArrayList();
        addCertChain(r21, r4, r5);
        View r6 = getActivity().getLayoutInflater().inflate(R.layout.trusted_credential_dropdown, null);
        final OCardListItem r7 = (OCardListItem) r6.findViewById(R.id.dropdown);
        if (r5.isEmpty() == false) goto L9;
        String r8 = "";
    L10:
        OCardListItemUtils.setTrailingMultiText(r7, r8);
        r7.setOnContentClickListener(new AnonymousClass5(this, r5, r7, r4));
        LinearLayout r9 = new LinearLayout(getActivity());
        r9.setOrientation(1);
        r9.addView(r6);
        int r10 = 0;
    L12:
        if (r10 >= r4.size()) goto L28;
        View r11 = r4.get(r10);
        int r12 = 8;
        if (r10 == 0) goto L16;
        r11.setVisibility(8);
    L16:
        r9.addView(r11);
        if (r21.isBytedanceCertificate() == true) goto L27;
        ViewGroup r13 = (ViewGroup) ((ViewGroup) r11).getChildAt(0);
        OCardListItem r14 = (OCardListItem) LayoutInflater.from(getActivity()).inflate(R.layout.trusted_credential_details, r13, false);
        if (r13 == null) goto L21;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -2);
        r15.topMargin = UIUtils.INSTANCE.dp2px(20);
        r13.addView(r14, r15);
    L21:
        r13.addView(new View(getActivity()), new ViewGroup.LayoutParams(-1, UIUtils.INSTANCE.dp2px(32)));
        TextView r16 = (TextView) ((ViewGroup) r14.getCustomStartView()).findViewById(R.id.settings_text);
        r16.setText(Tab.access$3100(CertHolder.access$100(r21), r21));
        r16.setTextColor(getActivity().getColor(R.color.oui_functional_red_6));
        r14.setOnContentClickListener(new AnonymousClass6(this, r21));
        if ((!this.mUserManager.hasUserRestriction("no_config_credentials", new UserHandle(r21.mProfileId))) == false) goto L24;
        r12 = 0;
    L24:
        r14.setVisibility(r12);
        if (DevicePolicyUtils.hasUserRestriction(getActivity(), "no_config_credentials") == false) goto L27;
        OCardListItemUtils.setContentContainerEnabled(r14, false);
        r14.getContentContainer().setClickable(true);
    L27:
        r10 = r10 + 1;
        goto L12
    L28:
        this.mCertDialog.setFooterView(null);
        this.mCertDialog.setClearDimFlag(false);
        this.mCertDialog.setOnDismissListener(new AnonymousClass7(this));
        this.mCertDialog.setBodyView(r9);
        this.mCertDialog.show();
        return;
    L9:
        r8 = r5.get(0);
        goto L10
    }

    private void addCertChain(CertHolder r8, ArrayList<View> r9, ArrayList<String> r10) {
        KeyChain.KeyChainConnection r0 = this.mKeyChainConnectionByProfileId.get(r8.mProfileId);     // Catch: RemoteException -> L14
        if (r0 != null) goto L5;
        return;
    L5:
        IKeyChainService r1 = r0.getService();     // Catch: RemoteException -> L14
        List r2 = r1.getCaCertificateChainAliases(CertHolder.access$3400(r8), true);     // Catch: RemoteException -> L14
        int r3 = r2.size();     // Catch: RemoteException -> L14
        ArrayList r4 = new ArrayList(r3);     // Catch: RemoteException -> L14
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L9;
        r4.add(KeyChain.toCertificate(r1.getEncodedCaCertificate((String) r2.get(r5), true)));     // Catch: RemoteException -> L14
        r5 = r5 + 1;
        goto L6
    L9:
        Iterator r11 = r4.iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        addCertDetails((X509Certificate) r11.next(), r9, r10);
        goto L11
    L13:
        return;
    L14:
        e = move-exception;
        OLog.e(TAG, "RemoteException while retrieving certificate chain for root " + CertHolder.access$3400(r8), e);
    }

    private void addCertDetails(X509Certificate r2, ArrayList<View> r3, ArrayList<String> r4) {
        ObricSslCertificate r0 = new ObricSslCertificate(r2);
        r3.add(r0.inflateCertificateView(getActivity()));
        r4.add(r0.getIssuedTo().getCName());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_TrustedCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TrustedCredentialsSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_TrustedCredentialsSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TrustedCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TrustedCredentialsSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_TrustedCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TrustedCredentialsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TrustedCredentialsSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_TrustedCredentialsSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
