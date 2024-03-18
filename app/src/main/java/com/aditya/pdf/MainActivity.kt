package com.aditya.pdf

import android.content.res.Configuration
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rajat.pdfviewer.PdfViewerActivity.Companion.launchPdfFromUrl
import com.rajat.pdfviewer.util.saveTo


class MainActivity : AppCompatActivity() {
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
                            when(val sub = spinnerSub.selectedItem.toString()){
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
                            when(val sub = spinnerSub.selectedItem.toString()){
                                "DAA" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20IV%20sem%2FBTECHIV%20DAA.pdf?alt=media&token=928ab85e-3598-444c-a8ab-00a77dd762cc",sub)

                                "OS" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20IV%20sem%2FIVsem%20OS.pdf?alt=media&token=167cc3da-1d05-4445-a709-d22bea4d45f4",sub)

                                "COA" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20IV%20sem%2FBTECHIV%20COA.pdf?alt=media&token=560150e8-82b9-49e6-9cff-03f83f78f018",sub)

                                "SE & ES" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20IV%20sem%2FIVsem%20SE%20%26%20ES.pdf?alt=media&token=8f180db5-41b5-41c5-8375-001df50d7fc6",sub)

                                "IS" -> openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/Btech%20IV%20sem%2FBTECHIV%20INDUSTRIAL%20SOCIOLOGY%20.pdf?alt=media&token=0fbe6842-65b7-4857-939b-932adc962b57",sub)
                            }
                        }

                    }
                    "VI"-> {
                        Toast.makeText(this, "vi sem btech", Toast.LENGTH_SHORT).show()
                        openAdapter(subsBtechVI)
                        btnGet.setOnClickListener {
                            when(val sub = spinnerSub.selectedItem.toString()){
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
                            when(val sub = spinnerSub.selectedItem.toString()){
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
                            when(val sub = spinnerSub.selectedItem.toString()){
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
                            when(val sub = spinnerSub.selectedItem.toString()){

                                "Cloud Computing"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCA%20IV%2FBCAIV%20Cloud%20computing%20.pdf?alt=media&token=b07f4d07-156e-4408-9437-76a0b6cf779e",sub)

                                "SE & WEB DEV"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCA%20II%20SEM%2FBCA%20IV%2FBCAIV%20SE%20%26%20WEB%20DEV.pdf?alt=media&token=0f151a5f-c892-4917-8cfa-539b3e470e40",sub)
                            }
                        }
                    }
                    "VI"->{
                        openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BCAVI.pdf?alt=media&token=725c3d2f-4d00-43c6-98ee-a4b702969d99","BCA VI")
                        finish()

                    }
                }
            }
            "BBA"->{
                when(semester){
                    "II"->{
                        Toast.makeText(this,"opening BBA $semester semester",Toast.LENGTH_SHORT).show()
                        openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BBA%2FBBAII%20complete.pdf?alt=media&token=ef78d81c-c993-4280-a456-217d376a9dfa","BBA II sem")

                    }
                    "IV"-> {
                        Toast.makeText(this,"opening BBA $semester semester",Toast.LENGTH_SHORT).show()
                        openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BBA%2FBBA%20IV%20complete%20.pdf?alt=media&token=2ad90851-a65f-4ac3-888b-418459e17ade","BBA IV sem")

                    }
                    "VI"->{
                        Toast.makeText(this,"opening BBA $semester semester",Toast.LENGTH_SHORT).show()
                        openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BBA%2FBBA%20VI.pdf?alt=media&token=f6b4bf55-4f45-4282-a021-8d4f4b9ff941","BBA VI sem")

                    }

                }
            }
            "BSc BEd PCM"->{
                when(semester){
                    "IV"->{
                        val subBScBEdPCM = arrayOf("Basic of Organic Chemistry","Algebra and Trigonometry","Solid State and modern Physics","Classroom Management & Learning Teaching Assessment")
                        openAdapter(subBScBEdPCM)
                        btnGet.setOnClickListener {
                            when(val sub = spinnerSub.selectedItem.toString()){
                                "Basic of Organic Chemistry"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BSc%20BEd%20PCM%20IV%20SEM%2FEDUIV%20BASIC%20OF%20ORGANIC%20CHEMISTRY%20.pdf?alt=media&token=231fcb07-b940-4f8c-8072-d990d4ec7872",sub)

                                "Algebra and Trigonometry"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BSc%20BEd%20PCM%20IV%20SEM%2FEDUIV%20ALGEBRA%20AND%20TRIGONOMETRY%20.pdf?alt=media&token=fcfd9aa1-5491-4ed2-b83a-c1f4f8ca7892",sub)

                                "Solid State and modern Physics"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BSc%20BEd%20PCM%20IV%20SEM%2FEDUIV%20SOLID%20STATE%20AND%20MODERN%20PHYSICS%20.pdf?alt=media&token=83ce77d9-64ad-475b-a4ea-de65ea9c193c",sub)

                                "Classroom Management & Learning Teaching Assessment"->openPdf1("https://firebasestorage.googleapis.com/v0/b/sample1-15839.appspot.com/o/BSc%20BEd%20PCM%20IV%20SEM%2FEDUIV%20TEACHING%20LEARNING%20ASSISSMENT%20%26%20CLASSROOM%20MANAGEMENT%20.pdf?alt=media&token=0a6674b3-d1ba-4835-9f70-2a2526fc183d",sub)

                            }
                        }
                    }
                    else->Toast.makeText(this,"coming soon",Toast.LENGTH_SHORT).show()
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
        Toast.makeText(this,"Wait while the pdf is being loaded",Toast.LENGTH_SHORT).show()
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

    override fun onPause() {
        super.onPause()
        finish()
    }
}


