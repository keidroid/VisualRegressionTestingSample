package red.torch.vrtsample.activity

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import red.torch.vrtsample.MainActivity

@RunWith(AndroidJUnit4::class)
class FacebookScreenshotTest {

    @get:Rule
    val activityTestRule
            = ActivityTestRule(MainActivity::class.java, true, true)

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun facebookScreenshotTest() {
        Screenshot.snapActivity(activityTestRule.activity).record()
    }
}