package com.sample.trafficlaws

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var checkBoxMain: CheckBox
    private lateinit var infoTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        checkBoxMain = findViewById(R.id.checkboxTL)
        infoTV = findViewById(R.id.infoTV)

        checkBoxMain.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxMain.text = "Правила дорожного движения"
                infoTV.text = """
                    1. Общие положения
                    ПДД пункт 1.1
                    1.1. Настоящие Правила дорожного движения <*> устанавливают единый порядок дорожного движения на всей территории Российской Федерации. Другие нормативные акты, касающиеся дорожного движения, должны основываться на требованиях Правил и не противоречить им.
                    --------------------------------
                    <*> В дальнейшем - Правила.
                    ПДД пункт 1.2
                    1.2. В Правилах используются следующие основные понятия и термины:
                    "Автомагистраль" - дорога, обозначенная знаком 5.1 <*> и имеющая для каждого направления движения проезжие части, отделенные друг от друга разделительной полосой (а при ее отсутствии - дорожным ограждением), без пересечений в одном уровне с другими дорогами, железнодорожными или трамвайными путями, пешеходными или велосипедными дорожками.
                """.trimIndent()
            } else {
                checkBoxMain.text = "Информация"
                infoTV.text = ""
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}