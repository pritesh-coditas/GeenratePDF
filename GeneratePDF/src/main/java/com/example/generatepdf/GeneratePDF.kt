package com.example.generatepdf

import android.content.Context
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
        val myPaint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(400, 600, 1).create()
        val page = myPdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        canvas.drawText("Personal details: ",40F, 40F, myPaint)
        canvas.drawText(userName, 40F, 50F, myPaint)
        canvas.drawText(userMobile, 40F, 60F, myPaint)
        canvas.drawText(userAddress, 40F, 70F, myPaint)
        canvas.drawText(userEmail, 40F, 80F, myPaint)

        canvas.drawText("Education details: ",40F, 90F, myPaint)
        canvas.drawText(schoolName, 40F, 1000F, myPaint)
        canvas.drawText(schoolMarks, 40F, 110F, myPaint)
        canvas.drawText(collegeName, 40F, 120F, myPaint)
        canvas.drawText(collegeMarks, 40F, 130F, myPaint)
        canvas.drawText(diplomaCollegeName, 40F, 140F, myPaint)
        canvas.drawText(diplomaCollegeMarks, 40F, 150F, myPaint)
        canvas.drawText(degreeCollegeName, 40F, 160F, myPaint)
        canvas.drawText(degreeMarks, 40F, 170F, myPaint)

        canvas.drawText("Skills details: ",40F, 180F, myPaint)
        canvas.drawText(programmingLanguage, 40F, 190F, myPaint)
        canvas.drawText(softwareTools, 40F, 200F, myPaint)
        canvas.drawText(certification, 40F, 210F, myPaint)
        canvas.drawText(otherSkills, 40F, 220F, myPaint)

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

