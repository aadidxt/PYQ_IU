package com.example.pdf

import android.content.res.Configuration
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.example.pdf.databinding.ActivityMainBinding
//import com.rajat.pdfviewer.PdfRendererView
import com.rajat.pdfviewer.PdfViewerActivity.Companion.launchPdfFromUrl
import com.rajat.pdfviewer.util.saveTo


class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var pdfView : PdfRendererView
    private lateinit var spinnerSub : Spinner
    private lateinit var btnGet : Button

    private fun isDarkModeOn(): Boolean {
        val nightModeFlags = getResources().configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        if (isDarkModeOn()) {
            setTheme(R.style.AppTheme_Dark)
        } else {
            setTheme(R.style.AppTheme)
        }

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        spinnerSub = findViewById<Spinner>(R.id.spinnerSub)
        btnGet = findViewById<Button>(R.id.btnGet)

        val intent = getIntent()
        val course = intent.getStringExtra("course")
        val semester = intent.getStringExtra("semester")

        val subsBtechIV = arrayOf("Select Subjecct", "DAA", "OS", "SE & ES", "COA", "IS")
        val subsBtechII = arrayOf("C","Chemistry","English","IIOT & BCME","Maths","Workshop")
        val subsBtechVI = arrayOf("Computer Network","Internet Technology","Multimedia & PHP & Linux Administration","Compiler Design","Software Project Management","Software testing")
        val subsBtechVIII = arrayOf("Mobile Computing","Cryptography and Network Security","Software Quality Management","Big Data & .NET framework & Distributed DB & wireless Comm.")

        val subsBCAII = arrayOf("IIOT","Python","OS & Numerical and Statistical Approaches","DSA")
        val subsBCAIV = arrayOf("Cloud Computing","SE & WEB DEV")

        when(course){
            "B.Tech CSE"-> {
                when(semester){
                    "II"-> {
                        openAdapter(subsBtechII)
                        btnGet.setOnClickListener {
                            val sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "C"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20C.pdf?alt=media&token=99d7059d-a86c-47d5-bca0-232303c3ff3c",sub)

                                "Chemistry"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20CHEMISTRY%20.pdf?alt=media&token=d1f47bfe-7cd6-42f7-9cda-953b584ad82a",sub)

                                "English"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20ENGLISH%20.pdf?alt=media&token=64795551-3591-4282-9259-2c92aececc14",sub)

                                "IIOT & BCME"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20IIOT%20%26%20BCME.pdf?alt=media&token=4a4839f4-ed43-423a-a9a1-7edb324e4b01",sub)

                                "Maths"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20MATHS.pdf?alt=media&token=374b4338-270d-4885-ba78-94bef44d814f",sub)

                                "Workshop"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%202nd%20sem%2FIIsem%20WORKSHOP.pdf?alt=media&token=b9373f58-0f89-4f93-9eb9-a961c683c8f2",sub)
                            }
                        }
                    }
                    "IV"-> {
                        openAdapter(subsBtechIV)
                        btnGet.setOnClickListener {
                            val sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "DAA" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20DAA.pdf?alt=media&token=3614ec67-3654-4d37-9920-e4f7d684e769",sub)

                                "OS" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20OS.pdf?alt=media&token=e35a1357-253f-47c5-a507-8c7275d6cff1",sub)

                                "COA" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20COA.pdf?alt=media&token=2b61e070-7e94-4c9d-a7dd-100963c28dd7",sub)

                                "SE & ES" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20SE%20%26%20ES.pdf?alt=media&token=7fb424a4-a250-4e52-abfa-46a26be166de",sub)

                                "IS" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/IVsem%20IS%20.pdf?alt=media&token=9c1d433e-5438-465b-9b60-48fe904c6aa9",sub)
                            }
                        }

                    }
                    "VI"-> {
                        Toast.makeText(this, "vi sem btech", Toast.LENGTH_SHORT).show()
                        openAdapter(subsBtechVI)
                        btnGet.setOnClickListener {
                            val sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "Computer Network"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20VIsem%2FVIsem%20Computer%20network%20.pdf?alt=media&token=a844daa1-6269-4a68-8784-782bab4812ea",sub)

                                "Internet Technology"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20VIsem%2FVIsem%20Internet%20technology%20.pdf?alt=media&token=7f76d02f-b6f1-4af9-aec5-1505ea9f97c2",sub)

                                "Multimedia & PHP & Linux Administration"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20VIsem%2FVIsem%20MM%20LA%20PHP.pdf?alt=media&token=d2deb078-d089-4e6e-9980-f8dd584fb09c",sub)

                                "Compiler Design"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20VIsem%2FVIsem%20compiler%20design%20.pdf?alt=media&token=71714a3c-f54f-429c-98c2-45ab2b986410",sub)

                                "Software Project Management"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20VIsem%2FVIsem%20software%20project%20management%20.pdf?alt=media&token=d16aae97-0a92-4f7d-98db-51357a3882d3",sub)

                                "Software testing"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20VIsem%2FVIsem%20software%20testing%20.pdf?alt=media&token=399eadb1-62d6-432b-b331-045c2f2d1cac",sub)
                            }
                        }
                    }
                    "VIII"-> {
                        Toast.makeText(this, "viii sem btech", Toast.LENGTH_SHORT).show()
                        openAdapter(subsBtechVIII)
                        btnGet.setOnClickListener {
                            val sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "Mobile Computing"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/B.tech%20VIII%20SEM%2FVIIIsem%20Mobile%20computing%20.pdf?alt=media&token=e154aeb6-40a7-4d0b-be56-beb4bfa17956",sub)

                                "Cryptography and Network Security"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/B.tech%20VIII%20SEM%2FVIIIsem%20cryptography%20and%20network%20security%20.pdf?alt=media&token=7b178104-eeec-44c6-8577-0e7b98657379",sub)

                                "Software Quality Management"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/B.tech%20VIII%20SEM%2FVIIIsem%20software%20quality%20management%20.pdf?alt=media&token=59434365-7313-4a7b-9576-71799720eee8",sub)

                                "Big Data & .NET framework & Distributed DB & wireless Comm."->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/B.tech%20VIII%20SEM%2FVIIIsem%20bigdata%20.net%20distributed%20db%20wireless%20comm.pdf?alt=media&token=366eff9a-3fd3-46d8-99f1-a608055a6032",sub)

                            }
                        }
                    }
                }
            }
            "BCA"->{
                when(semester) {
                    "II"->{
                        openAdapter(subsBCAII)
                        btnGet.setOnClickListener {
                            val sub = spinnerSub.selectedItem.toString()
                            when(sub){
                                "IIOT"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCSII%20IIOT.pdf?alt=media&token=3a67b2e8-9f92-446b-a95e-667fe992cdfd",sub)

                                "Python"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCSII%20python%20.pdf?alt=media&token=d12d0799-6e36-4154-a443-a67c81169cf9",sub)

                                "OS & Numerical and Statistical Approaches"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCAII%20OS%20NST.pdf?alt=media&token=c5a6eddb-dee9-4dc5-b6f3-876e510fdffe",sub)

                                "DSA"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCAII%20DSA%20.pdf?alt=media&token=9cd599af-3541-4fb0-9cac-3afca5be6b1e",sub)

                            }
                        }
                    }
                    "IV"->{
                        openAdapter(subsBCAIV)
                        btnGet.setOnClickListener {
                            val sub = spinnerSub.selectedItem.toString()
                            when(sub){

                                "Cloud Computing"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCA%20IV%2FBCAIV%20Cloud%20computing%20.pdf?alt=media&token=b07f4d07-156e-4408-9437-76a0b6cf779e",sub)

                                "SE & WEB DEV"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCA%20IV%2FBCAIV%20SE%20%26%20WEB%20DEV.pdf?alt=media&token=0f151a5f-c892-4917-8cfa-539b3e470e40",sub)
                            }
                        }
                    }
                    "VI"->{
                        openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCAVI.pdf?alt=media&token=725c3d2f-4d00-43c6-98ee-a4b702969d99","BCA VI")

                    }
                }
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
        }

    }


    private fun openAdapter(sub: Array<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sub)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSub.adapter = adapter
    }


    private fun openPdf1(url:String,title:String) {
        startActivity(
            launchPdfFromUrl(
                context = this,
                pdfUrl = url,
                pdfTitle = title,
                saveTo = saveTo.ASK_EVERYTIME,
                enableDownload = false
            )
        )
    }
}


