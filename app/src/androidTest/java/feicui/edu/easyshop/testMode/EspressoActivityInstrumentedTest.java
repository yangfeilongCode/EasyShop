package feicui.edu.easyshop.testMode;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import feicui.edu.easyshop.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/11/25.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoActivityInstrumentedTest {

    private final String STRING_TEXT="更了认可隔离开人";

    /**
     * 1.
     * 设置启动的Activity规则，也就是要测试哪一个
     */
    @Rule
    public ActivityTestRule<EspressoActivity> activityTestRule=
            new ActivityTestRule<EspressoActivity>(EspressoActivity.class);
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void onClick() throws Exception {
        // 2. 在这里去验证UI
        /**
         * 测试的UI的流程
         * 1. 给EditText输入文本
         * 2. 给Button设置点击事件，点击完之后TextView显示文本
         * 4. 验证TextView的文本是不是输入的文本
         */
        onView(withId(R.id.et_text)).perform(typeText(STRING_TEXT));
        onView(withId(R.id.btn_show)).perform(click());
        String text="hello"+STRING_TEXT+"!";
        onView(withId(R.id.tv_text)).check(matches(withText(text)));
    }

    @After
    public void tearDown() throws Exception {

    }

}