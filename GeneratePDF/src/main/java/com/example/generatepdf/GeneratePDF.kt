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
              otherSkills: String
    ) {
        val myPdfDocument = PdfDocument()

        val paintForText = Paint()
        paintForText.textSize = 40F
        paintForText.color = Color.BLUE

        val myPaint = Paint()
        myPaint.textSize = 20F

        val pageInfo = PdfDocument.PageInfo.Builder(400, 600, 1).create()
        val page = myPdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        canvas.drawText("Personal details: ",30F, 40F, paintForText)
        canvas.drawText(userName, 30F, 60F, myPaint)
        canvas.drawText(userMobile, 30F, 80F, myPaint)
        canvas.drawText(userAddress, 30F, 100F, myPaint)
        canvas.drawText(userEmail, 30F, 120F, myPaint)

        canvas.drawText("Education details: ",30F, 160F, paintForText)
        canvas.drawText(schoolName, 30F, 180F, myPaint)
        canvas.drawText(schoolMarks, 30F, 200F, myPaint)
        canvas.drawText(collegeName, 30F, 220F, myPaint)
        canvas.drawText(collegeMarks, 30F, 240F, myPaint)
        canvas.drawText(diplomaCollegeName, 30F, 260F, myPaint)
        canvas.drawText(diplomaCollegeMarks, 30F, 280F, myPaint)
        canvas.drawText(degreeCollegeName, 30F, 300F, myPaint)
        canvas.drawText(degreeMarks, 30F, 320F, myPaint)

        canvas.drawText("Skills details: ",30F, 360F, paintForText)
        canvas.drawText(programmingLanguage, 30F, 380F, myPaint)
        canvas.drawText(softwareTools, 30F, 400F, myPaint)
        canvas.drawText(certification, 30F, 420F, myPaint)
        canvas.drawText(otherSkills, 30F, 440F, myPaint)

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

