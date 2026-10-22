package com.obric.safecheck.test;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.obric.olog.OLog;
import com.obric.safecheck.R;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbAntiFraudRulesActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/test/GxbAntiFraudRulesActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "buildContent", "", "rules", "", "Lcom/obric/safecheck/database/entity/GxbAntiFraudRuleItem;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAntiFraudRulesActivity extends FragmentActivity {
    private static final Companion Companion = null;

    @Deprecated
    private static final String TAG = "GxbAntiFraudRulesAct";

    /* JADX INFO: compiled from: GxbAntiFraudRulesActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/test/GxbAntiFraudRulesActivity$Companion;", "", "()V", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GxbAntiFraudRulesActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_gxb_anti_fraud_rules);
        TextView r9 = (TextView) findViewById(R.id.tv_gxb_rules_summary);
        TextView r3 = (TextView) findViewById(R.id.tv_gxb_rules_content);
        List<GxbAntiFraudRuleItem> r4 = AntiFraudDatabase.getDatabase(this).gxbAntiFraudRuleDao().getAll();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r9, "summaryView");     // Catch: Throwable -> L10
        r9.setText("gxb_anti_fraud_rules size = " + r4.size());     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r3, "contentView");     // Catch: Throwable -> L10
        if (r4.isEmpty() == false) goto L7;
        String r7 = "(empty)";
    L8:
        r3.setText(r7);     // Catch: Throwable -> L10
        return;
    L7:
        r7 = buildContent(r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        OLog.e(TAG, "load gxb rules failed", th);
        Intrinsics.checkNotNullExpressionValue(r9, "summaryView");
        r9.setText("load failed");
        Intrinsics.checkNotNullExpressionValue(r3, "contentView");
        String r10 = th.getMessage();
        if (r10 == null) goto L14;
        String r11 = r10;
    L15:
        r3.setText(r11);
        return;
    L14:
        r11 = th.toString();
        goto L15
    }

    private final String buildContent(List<GxbAntiFraudRuleItem> r6) {
        StringBuilder r5 = new StringBuilder();
        Iterator<T> r7 = r6.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r1 = r7.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        GxbAntiFraudRuleItem r3 = (GxbAntiFraudRuleItem) r1;
        r5.append('[').append(r0).append("] ruleNo=").append(r3.getRuleNo()).append("\n    ruleId=").append(r3.getRuleId()).append("\n    packetName=").append(r3.getPacketName()).append("\n    ruleType=").append(r3.getRuleType()).append(", ruleState=").append(r3.getRuleState()).append("\n    area=").append(r3.getArea()).append(", areaType=").append(r3.getAreaType()).append("\n    disposeTime=").append(r3.getDisposeTime()).append("\n    appMd5=").append(r3.getAppMd5()).append("\n    signMd5=").append(r3.getSignMd5()).append("\n    signSha1=").append(r3.getSignSha1()).append("\n    signSha256=").append(r3.getSignSha256()).append("\n\n");
        r0 = r2;
        goto L4
    L9:
        String r8 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "sb.toString()");
        return r8;
    }
}
