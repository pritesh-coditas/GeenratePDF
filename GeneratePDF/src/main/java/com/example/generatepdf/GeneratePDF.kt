package com.example.generatepdf

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object GeneratePdf {

    fun build(context: Context, userName:String,
              userMobile:String,
              userAddress:String,
              userEmail:String,
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

        val paintHead1 = Paint()
        paintHead1.textSize = 25F
        paintHead1.color = Color.parseColor("#FF03DAC5")

        val paintHead2 = Paint()
        paintHead2.textSize = 14F
        paintHead1.color = Color.parseColor("#49599b")

        val paintHead3 = Paint()
        paintHead3.textSize = 12F
        paintHead3.color = Color.BLACK

        val paintNormalText = Paint()
        paintNormalText.textSize = 10F

        val pageInfo = PdfDocument.PageInfo.Builder(400, 600, 1).create()
        val page = myPdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        canvas.drawText(userName,30F, 40F, paintHead1)
        canvas.drawLine(30F, 30F, 370F, 370F, paintHead1)

        canvas.drawText("personal Details: ", 30F, 60F, paintNormalText)
        canvas.drawText(userMobile, 30F, 80F, paintNormalText)
        canvas.drawText(userAddress, 30F, 100F, paintNormalText)
        canvas.drawText(userEmail, 30F, 120F, paintNormalText)

        canvas.drawLine(140F,30F,140F,30F,paintHead1)

        canvas.drawText("Education details: ",30F, 160F, paintHead1)
        canvas.drawText(schoolName, 30F, 180F, paintNormalText)
        canvas.drawText(schoolMarks, 30F, 200F, paintNormalText)
        canvas.drawText(collegeName, 30F, 220F, paintNormalText)
        canvas.drawText(collegeMarks, 30F, 240F, paintNormalText)
        canvas.drawText(diplomaCollegeName, 30F, 260F, paintNormalText)
        canvas.drawText(diplomaCollegeMarks, 30F, 280F, paintNormalText)
        canvas.drawText(degreeCollegeName, 30F, 300F, paintNormalText)
        canvas.drawText(degreeMarks, 30F, 320F, paintNormalText)

        canvas.drawLine(330F,30F,330F,30F,paintHead1)

        canvas.drawText("Skills details: ",30F, 360F, paintHead1)
        canvas.drawText(programmingLanguage, 30F, 380F, paintNormalText)
        canvas.drawText(softwareTools, 30F, 400F, paintNormalText)
        canvas.drawText(certification, 30F, 420F, paintNormalText)
        canvas.drawText(otherSkills, 30F, 440F, paintNormalText)

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

