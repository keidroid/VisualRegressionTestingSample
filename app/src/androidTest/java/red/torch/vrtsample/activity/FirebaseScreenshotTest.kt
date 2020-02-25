package red.torch.vrtsample.activity

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.google.android.libraries.cloudtesting.screenshots.ScreenShotter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import red.torch.vrtsample.MainActivity

@RunWith(AndroidJUnit4::class)
class FirebaseScreenshotTest {

    @get:Rule
    val activityTestRule
            = ActivityTestRule(MainActivity::class.java, true, true)

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun firebaseScreenshotTest1() {
        ScreenShotter.takeScreenshot("main_screen_1", activityTestRule.activity)
    }

    @Test
    fun firebaseScreenshotTest2() {
        ScreenShotter.takeScreenshot("main_screen_2", activityTestRule.activity)
    }
}