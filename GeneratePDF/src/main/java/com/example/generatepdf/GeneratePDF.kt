package com.example.generatepdf

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object GeneratePdf {

    fun build(context: Context, userName:String,
              userMobile:String,
              userEmail:String,
              userAddress:String,
              schoolName:String,
              schoolMarks:String,
              collegeName:String,
              collegeMarks:String,
              diplomaCollegeName: String,
              diplomaCollegeMarks: String,
              degreeCollegeName: String,
              degreeMarks: String,
              programmingLanguage: String,
              softwareTools: String,
              certification: String,
              otherSkills: String,
              projectTitle:String,
              projectDescription:String,
              companyName:String,
              companyExperienceYear:String,
              totalExperience:String
    ) {
        val myPdfDocument = PdfDocument()

        val bold = Typeface.DEFAULT_BOLD

        val paintHead1 = Paint()
        paintHead1.textSize = 25F
        paintHead1.color = Color.parseColor("#49599b")

        val paintLine = Paint()
        paintLine.strokeWidth = 2F
        paintLine.color = Color.parseColor("#FF03DAC5")

        val paintHead2 = Paint()
        paintHead2.textSize = 14F
        paintHead2.typeface = bold
        paintHead2.color = Color.parseColor("#FF03DAC5")

        val paintHead3 = Paint()
        paintHead3.textSize = 11F
        paintHead3.style = Paint.Style.FILL_AND_STROKE
        paintHead3.color = Color.BLACK

        val paintNormalText = Paint()
        paintNormalText.textSize = 10F

        val paintBoldText = Paint()
        paintBoldText.textSize = 10F
        paintBoldText.typeface = bold

        val paragraphText = TextPaint()
        paragraphText.color = Color.BLACK
        paragraphText.textSize = 10F

        val pageInfo = PdfDocument.PageInfo.Builder(400, 700, 1).create()
        val page = myPdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        var x = 0F
        var y = 0F

        // userName
        canvas.drawText(userName, 20F, 40F, paintHead1)

        //line
        canvas.drawLine(20F,50F,380F,50F,paintLine)

        canvas.drawText("Personal Details :", 30F, 70F, paintHead2)
        canvas.drawText("Mobile No. :", 35F, 90F, paintHead3) // mobile
        canvas.drawText(userMobile, 100F, 90F, paintNormalText)
        canvas.drawText("Email :", 35F, 110F, paintHead3) // email
        canvas.drawText(userEmail, 70F, 110F, paintNormalText)
        canvas.drawText("Address :", 35F, 130F, paintHead3) // address
        // canvas.drawText(userAddress, 90F, 130F, paintNormalText)

        val userAddressTextLayout =
            StaticLayout(
                userAddress,
                paragraphText,
                300,
                Layout.Alignment.ALIGN_NORMAL,
                1.0f,
                0.0f,
                true
            )
        canvas.save()
        canvas.translate(85F, 118F)
        userAddressTextLayout.draw(canvas)
        canvas.restore()

        canvas.drawText("Education details :", 30F, 160F, paintHead2)
        canvas.drawText("School Name :", 35F, 180F, paintHead3) // 10th School name
        val schoolNameTextLayout =
            StaticLayout(
                schoolName,
                paragraphText,
                250,
                Layout.Alignment.ALIGN_NORMAL,
                1.0f,
                0.0f,
                true
            )
        canvas.save()
        canvas.translate(40F, 185F)
        schoolNameTextLayout.draw(canvas)
        canvas.restore()
        canvas.drawText(schoolMarks, 300F, 198F, paintBoldText)

        canvas.drawText("College Name :", 35F, 225F, paintHead3)
        // canvas.drawText(collegeName, 40F, 240F, paintNormalText)
        val collegeNameTextLayout =
            StaticLayout(
                collegeName,
                paragraphText,
                250,
                Layout.Alignment.ALIGN_NORMAL,
                1.0f,
                0.0f,
                true
            )
        canvas.save()
        canvas.translate(40F, 230F)
        collegeNameTextLayout.draw(canvas)
        canvas.restore()
        canvas.drawText(collegeMarks, 300F, 240F, paintBoldText)

        y = 245F

        if(diplomaCollegeName.isNotEmpty()){
            canvas.drawText("Diploma College Name :", 35F, y+30F, paintHead3)
            //  canvas.drawText(diplomaCollegeName, 40F, y+40F, paintNormalText)
            val diplomaCollegeTextLayout =
                StaticLayout(
                    diplomaCollegeName,
                    paragraphText,
                    250,
                    Layout.Alignment.ALIGN_NORMAL,
                    1.0f,
                    0.0f,
                    true
                )
            canvas.save()
            canvas.translate(40F, y+35F)
            diplomaCollegeTextLayout.draw(canvas)
            canvas.restore()
            canvas.drawText(diplomaCollegeMarks, 300F, y+47F, paintBoldText)
            y = 290F
        }

        canvas.drawText("Degree College Name :", 35F, y+25F, paintHead3)
        //    canvas.drawText(degreeCollegeName, 40F, y+40F, paintNormalText)
        val degreeCollegeNameTextLayout =
            StaticLayout(
                degreeCollegeName,
                paragraphText,
                250,
                Layout.Alignment.ALIGN_NORMAL,
                1.0f,
                0.0f,
                true
            )
        canvas.save()
        canvas.translate(40F, y+28F)
        degreeCollegeNameTextLayout.draw(canvas)
        canvas.restore()
        canvas.drawText(degreeMarks, 300F, y+40F, paintBoldText)

        canvas.drawText("Skills details: ", 30F, y+70F, paintHead2)
        canvas.drawText("Programming languages :", 35F, y+90F, paintHead3)
        canvas.drawText(programmingLanguage, 170F, y+90F, paintNormalText)
        canvas.drawText("Software tools :", 35F, y+110F, paintHead3)
        canvas.drawText(softwareTools, 120F, y+110F, paintNormalText)
        canvas.drawText("Certifications :", 35F, y+130F, paintHead3)
        canvas.drawText(certification, 120F, y+130F, paintNormalText)
        canvas.drawText("Other Skills :", 35F, y+150F, paintHead3)
        canvas.drawText(otherSkills, 110F, y+150F, paintNormalText)

        canvas.drawText("Project details: ", 30F, y+180F, paintHead2)
        canvas.drawText("Project name :", 35F, y+200F, paintHead3)
        canvas.drawText(projectTitle, 110F, y+200F, paintNormalText)
        canvas.drawText("Project Description :", 35F, y+220F, paintHead3)

        /*       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                  StaticLayout.Builder.obtain(projectDescription, 0, projectDescription.length, mTextPaint, 11)
                       .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                       .setLineSpacing(1.0f, 0.0f)
                       .setIncludePad(false)
                       .build()
        }*/

        val projectDescriptionTextLayout =
            StaticLayout(
                projectDescription,
                paragraphText,
                320,
                Layout.Alignment.ALIGN_NORMAL,
                1.0f,
                0.0f,
                true
            )
        canvas.save()
        canvas.translate(40F, y+225F)
        projectDescriptionTextLayout.draw(canvas)
        canvas.restore()

        y += 225F+projectDescriptionTextLayout.height

        if(companyName.isNotEmpty()) {
            canvas.drawText("Experience details: ", 30F, y + 30F, paintHead2)
            canvas.drawText("Company name :", 35F, y + 50F, paintHead3)
            canvas.drawText(companyName, 120F, y + 50F, paintNormalText)
            canvas.drawText("Experience in company :", 35F, y + 70F, paintHead3)
            canvas.drawText(companyExperienceYear, 160F, y + 70F, paintNormalText)
            canvas.drawText("Total Experience :", 35F, y + 90F, paintHead3)
            canvas.drawText(totalExperience, 130F, y + 90F, paintNormalText)
        }

        myPdfDocument.finishPage(page)

        val file = File(context.getExternalFilesDir("/"), "resumePDF.pdf")

        try {
            myPdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(context, "PDF file generated successfully.", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(context, "PDF file not generated.", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
        myPdfDocument.close()
    }
}

