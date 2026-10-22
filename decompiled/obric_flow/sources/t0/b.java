package t0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.applet.login.BaseLoginCardView;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.r;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void addAppBackGroundListener(f r5);

    String appThemeBackgroundColor();

    void changeNightMode(boolean r5);

    String conversationIdToBotId(String r5);

    void createAppletConversations();

    AIFragmentBase createAppletFragment(String r5);

    com.bytedance.ai.widget.cache.b createWidgetResourceLoader(ConversationWidgetData r5, r r10);

    String currFloatingViewId();

    Activity currentActivity();

    Activity findMainActivity();

    Map getAccountInfo();

    Map getCommonParameters();

    Pair getFloatViewRestriction(Activity r5);

    BaseLoginCardView getNativeLoginCard();

    int getStatusBarHeight(Context r5);

    Boolean ignoreLowVersionWhenUpdate(String r5, String r10, long r11);

    Object isContextClearedMessage(String r5, Continuation r10);

    boolean isDarkMode();

    void navigateApplet(Context r5, Bundle r10);

    int navigationBarBgColor(Context r5);

    View.OnLongClickListener obtainWidgetLongClickListener(WidgetContainer r5);

    void onAppletPayloadChanged(String r5, String r10);

    void registerAppBackgroundListener(c r5);

    void registerWidgetHostLifecycle(e r5);

    void removeAppBackGroundListener(f r5);

    boolean resendUserQueryAfterLogin(String r5, boolean r10, String r11);
}
