package com.bennyhuo.github.view

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bennyhuo.dsl.layout.v1.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            setBackgroundColor(Color.RED)

            button {
                text = "Button 1"
                layoutWeight = 1f

                setBackgroundColor(Color.YELLOW)
            }

            frameLayout {
                layoutHeight = MATCH_PARENT
                layoutWidth = WRAP_CONTENT

                layoutGravity = Gravity.RIGHT

                verticalLayout {

                }
            }
        }
    }
}