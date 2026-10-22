package com.android.settings.intelligent;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BotIdSelectFragment extends BaseFragment implements View.OnClickListener {
    private BotIdSelectAdapter mAdapter;
    private String[] mBotIdMap;
    private String[] mBotList;
    private String[] mBotListValue;
    private String mDefaultBotId;
    private int mDefaultBotIdIndex;
    private RecyclerView mListview;

    public class BotIdSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        final /* synthetic */ BotIdSelectFragment this$0;

        class BotIdSelectViewHolder extends RecyclerView.ViewHolder {
            private OListItemSettings item;
            final /* synthetic */ BotIdSelectAdapter this$1;

            public BotIdSelectViewHolder(BotIdSelectAdapter r1, View r2) {
                this.this$1 = r1;
                super(r2);
                this.item = (OListItemSettings) r2.findViewById(R.id.item_check);
            }

            public void bindData(Context r2, String r3, int r4) {
                OListItemSettings r0 = this.item;
                if (r0 == null) goto L12;
                if (r3 == null) goto L13;
                r0.setTitleString(r3);
                if (BotIdSelectFragment.access$000(this.this$1.this$0) != r4) goto L9;
                ImageView r5 = new ImageView(r2);
                r5.setImageResource(R.drawable.icon_check_confirm_rounded);
                this.item.setTrailingView(r5);
                this.item.mTrailingElement.setVisibility(0);
            L10:
                this.item.setId(r4);
                this.item.setOnClickListener(this.this$1.this$0);
                return;
            L9:
                this.item.mTrailingElement.setVisibility(4);
                goto L10
            L13:
                return;
            }
        }

        public BotIdSelectAdapter(BotIdSelectFragment r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new BotIdSelectViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(R.layout.list_content_item_check_oui, r3, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            String r0 = BotIdSelectFragment.access$400(this.this$0)[r4];
            if ((r3 instanceof BotIdSelectViewHolder) == false) goto L6;
            ((BotIdSelectViewHolder) r3).bindData(this.this$0.mContext, r0, r4);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return BotIdSelectFragment.access$400(this.this$0).length;
        }
    }

    public void com_android_settings_intelligent_BotIdSelectFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_intelligent_BotIdSelectFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_intelligent_BotIdSelectFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_intelligent_BotIdSelectFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ int access$000(BotIdSelectFragment r0) {
        return r0.mDefaultBotIdIndex;
    }

    static /* synthetic */ int access$002(BotIdSelectFragment r0, int r1) {
        r0.mDefaultBotIdIndex = r1;
        return r1;
    }

    static /* synthetic */ String access$100(BotIdSelectFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String[] access$200(BotIdSelectFragment r0) {
        return r0.mBotIdMap;
    }

    static /* synthetic */ void access$300(BotIdSelectFragment r0, String r1) {
        r0.setBotId(r1);
    }

    static /* synthetic */ String[] access$400(BotIdSelectFragment r0) {
        return r0.mBotList;
    }

    public BotIdSelectFragment() {
        super(R.layout.global_assistant_bot_id_select);
        this.mDefaultBotIdIndex = -1;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        RecyclerView r4 = (RecyclerView) findViewByIdNullable(R.id.list_view);
        this.mListview = r4;
        r4.setLayoutManager(new LinearLayoutManager(this.mContext));
        getBotInfo();
        BotIdSelectAdapter r5 = new BotIdSelectAdapter(this);
        this.mAdapter = r5;
        this.mListview.setAdapter(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.Bundle] */
    private void getBotInfo() {
        ContentProviderClient r1 = 0;
        Bundle r2 = null;
        r2 = null;
        ContentProviderClient r3 = null;
        OLog.e("nicholas", "query provider start");     // Catch: Throwable -> L13 RemoteException -> L15
        ContentProviderClient r4 = getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assistant.data"));     // Catch: Throwable -> L13 RemoteException -> L15
        if (r4 != null) goto L39;
    L10:
        OLog.e("nicholas", "query provider end");     // Catch: Throwable -> L6 RemoteException -> L8
        r1 = r2;
        if (r4 == null) goto L21;
        r4.close();
        r1 = r2;
    L21:
        if (r1 == 0) goto L44;
        this.mDefaultBotId = r1.getString("default_bot_id");
        OLog.d(this.TAG, "default_bot_id = " + this.mDefaultBotId);
        String[] r0 = r1.getStringArray("bots_list");
        ArrayList r5 = new ArrayList();
        this.mBotListValue = new String[r0.length];
        this.mBotIdMap = new String[r0.length];
        this.mBotList = new String[r0.length];
        if (r0 == null) goto L31;
        int r6 = 0;
    L26:
        if (r6 >= r0.length) goto L31;
        if (r0[r6].contains(this.mDefaultBotId) == false) goto L30;
        this.mDefaultBotIdIndex = r6;
    L30:
        r5.add(r0[r6]);
        this.mBotListValue[r6] = String.valueOf(r6);
        this.mBotIdMap[r6] = getBotIdString(r0[r6]);
        OLog.d(this.TAG, "bot = " + r0[r6]);
        r6 = r6 + 1;
    L31:
        this.mBotList = (String[]) r5.toArray(this.mBotList);
        return;
    L44:
        return;
    L8:
        e = e;
        Bundle r7 = r2;
        r3 = r4;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L13
        if (r3 == null) goto L20;
        r3.close();
    L20:
        r1 = r7;
    L6:
        th = th;
        r1 = r4;
    L33:
        if (r1 == 0) goto L35;
        r1.close();
    L35:
        throw th;
    L39:
        r2 = r4.call("getBotInfo", null, null);     // Catch: Throwable -> L6 RemoteException -> L8
    L13:
        th = th;
    L15:
        e = e;
        r7 = null;
        goto L17
    }

    private String getBotIdString(String r1) {
        String[] r0 = r1.split(HanziToPinyin.Token.SEPARATOR);
        return r0[r0.length - 1];
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        final int r5 = r4.getId();
        OLog.d(this.TAG, "chooseIndex = " + r5);
        if (r5 >= 0) goto L5;
    L9:
        OLog.e(this.TAG, "select index is error");
        return;
    L5:
        if (r5 >= this.mBotList.length) goto L9;
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(getActivity()).horizontalButton();
        r0.title(R.string.change_bot_id_title);
        r0.positiveButton(R.string.agree, new AnonymousClass1(this, r5));
        r0.negativeButton(R.string.disagree, new AnonymousClass2(this));
        r0.build().show();
    }

    private void setBotId(String r5) {
        ContentProviderClient r0 = null;
        ContentProviderClient r1 = SettingsApplication.getContext().getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assistant.data"));     // Catch: Throwable -> L11 RemoteException -> L13
        if (r1 != null) goto L27;
    L9:
        if (r1 == null) goto L18;
    L10:
        r1.close();
    L18:
        if (r0 != null) goto L20;
        OLog.e(this.TAG, "result is null, update failed");
        return;
    L20:
        OLog.e(this.TAG, "result is not null, update success");
        return;
    L27:
        Bundle r2 = new Bundle();     // Catch: RemoteException -> L7 Throwable -> L22
        r2.putString("bot_id", r5);     // Catch: RemoteException -> L7 Throwable -> L22
        r0 = r1.call("setBotId", null, r2);     // Catch: RemoteException -> L7 Throwable -> L22
    L7:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L22
        if (r1 == null) goto L18;
    L22:
        th = th;
        r0 = r1;
    L24:
        if (r0 == null) goto L26;
        r0.close();
    L26:
        throw th;
    L13:
        e = e;
        r1 = null;
    L11:
        th = th;
        goto L24
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_intelligent_BotIdSelectFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BotIdSelectFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_BotIdSelectFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_BotIdSelectFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BotIdSelectFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_intelligent_BotIdSelectFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_BotIdSelectFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BotIdSelectFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_BotIdSelectFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
