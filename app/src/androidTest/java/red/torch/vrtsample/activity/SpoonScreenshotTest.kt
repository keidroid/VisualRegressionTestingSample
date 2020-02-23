package red.torch.vrtsample.activity

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.squareup.spoon.SpoonRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import red.torch.vrtsample.MainActivity

@RunWith(AndroidJUnit4::class)
class SpoonScreenshotTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @get:Rule
    val spoonRule = SpoonRule()

    @Test
    fun spoonScreenshotTest() {
        activityScenarioRule.scenario.onActivity { activity ->
            spoonRule.screenshot(activity, "initial_state")
        }
    }
}