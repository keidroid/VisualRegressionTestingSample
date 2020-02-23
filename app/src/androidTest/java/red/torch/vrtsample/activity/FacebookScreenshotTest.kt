package red.torch.vrtsample.activity

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import red.torch.vrtsample.MainActivity


@RunWith(AndroidJUnit4::class)
class FacebookScreenshot22Test {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun facebookScreenshotTest() {
        activityScenarioRule.scenario.onActivity {
            Screenshot.snapActivity(it)
        }
    }
}