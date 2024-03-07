package com.example.pdf

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pdf.databinding.ActivityMainBinding
import com.rajat.pdfviewer.PdfRendererView
import com.rajat.pdfviewer.PdfViewerActivity.Companion.launchPdfFromUrl
import com.rajat.pdfviewer.util.saveTo


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pdfView : PdfRendererView
    private lateinit var spinnerSub : Spinner
    private lateinit var btnGet : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        spinnerSub = findViewById<Spinner>(R.id.spinnerSub)
        btnGet = findViewById<Button>(R.id.btnGet)

        val intent = getIntent()
        val course = intent.getStringExtra("course")
        val semester = intent.getStringExtra("semester")

        var subsBtechIV = arrayOf("Select Subjecct", "DAA", "OS", "SE & ES", "COA", "IS")
        var subBtechII = arrayOf("C","Chemistry","English","IIOT & BCME","Maths","Workshop")
        var subsBba = arrayOf("A", "B", "C", "D", "E")
        var subsBca = arrayOf("Z", "X", "V", "N", "M")


        when(course){
            "B.Tech CSE"-> when(semester){
                    "IV"-> {
                        openAdapter(subsBtechIV)
                        btnGet.setOnClickListener {
                            var sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "DAA" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20DAA.pdf?alt=media&token=3614ec67-3654-4d37-9920-e4f7d684e769")

                                "OS" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20OS.pdf?alt=media&token=e35a1357-253f-47c5-a507-8c7275d6cff1")

                                "COA" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20COA.pdf?alt=media&token=2b61e070-7e94-4c9d-a7dd-100963c28dd7")

                                "SE & ES" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20SE%20%26%20ES.pdf?alt=media&token=7fb424a4-a250-4e52-abfa-46a26be166de")

                                "IS" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20IS%20.pdf?alt=media&token=9c1d433e-5438-465b-9b60-48fe904c6aa9")
                            }
                        }

                    }
                    "II"-> {
                        openAdapter(subBtechII)
                        btnGet.setOnClickListener {
                            var sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "C"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20C.pdf?alt=media&token=99d7059d-a86c-47d5-bca0-232303c3ff3c")
                                "Chemistry"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20CHEMISTRY%20.pdf?alt=media&token=d1f47bfe-7cd6-42f7-9cda-953b584ad82a")
                                "English"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20ENGLISH%20.pdf?alt=media&token=64795551-3591-4282-9259-2c92aececc14")
                                "IIOT & BCME"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20IIOT%20%26%20BCME.pdf?alt=media&token=4a4839f4-ed43-423a-a9a1-7edb324e4b01")
                                "Maths"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20MATHS.pdf?alt=media&token=374b4338-270d-4885-ba78-94bef44d814f")
                                "Workshop"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20WORKSHOP.pdf?alt=media&token=b9373f58-0f89-4f93-9eb9-a961c683c8f2")
                            }
                        }
                    }
                    "VI"-> Toast.makeText(this, "vi sem btech", Toast.LENGTH_SHORT).show()
                    "VIII"-> Toast.makeText(this,"viii sem btech", Toast.LENGTH_SHORT).show()
            }
            "BBA"->{
                when(semester){
                    "II"->{
                        Toast.makeText(this, "bba 2", Toast.LENGTH_SHORT).show()
                    }
                    "IV"-> {
                        Toast.makeText(this, "bba 4", Toast.LENGTH_SHORT).show()
                    }
                    "VI"->{
                        Toast.makeText(this, "bba 6", Toast.LENGTH_SHORT).show()
                    }

                }
            }
            "BCA"->{
                when(semester) {
                    "II"->{

                    }
                    "IV"->{

                    }
                    "VI"->{

                    }
                }
            }
        }

    }


    private fun openAdapter(sub: kotlin.Array<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sub)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSub.adapter = adapter
    }


    private fun openPdf1(url:String) {
        startActivity(
            launchPdfFromUrl(
                context = this,
                pdfUrl = url,
                pdfTitle = "PDF Title",
                saveTo = saveTo.ASK_EVERYTIME,
                enableDownload = false
            )
        )
    }


}


