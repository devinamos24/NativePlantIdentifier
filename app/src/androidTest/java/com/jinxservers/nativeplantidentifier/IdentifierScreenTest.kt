package com.jinxservers.nativeplantidentifier

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.jinxservers.nativeplantidentifier.ui.IdentifierScreen
import org.junit.Rule
import org.junit.Test

class IdentifierScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun simple_showsSubtype() {
        rule.onNodeWithText("Simple").performClick()
        rule.onNodeWithText("Unlobed").assertExists()
    }
}