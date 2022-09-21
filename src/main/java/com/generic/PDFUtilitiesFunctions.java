package com.generic;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class PDFUtilitiesFunctions extends PDFTextStripper {

	private static List<String> pDFWords = new ArrayList<String>();
	private static Pojo objPojo;
	
    private PDFUtilitiesFunctions(Pojo pojo) throws IOException {
    	PDFUtilitiesFunctions.objPojo=pojo;
    }
    
    
    /**
	 * @Method : getAndVerifyPDFTextData
	 * @Description : This Utility function is for to verify PDF text content is preset or not in PDF file.
	 * @param : strFileName,intSetPDFPageNo,strTextToSearch
	 * @author :  SDET Developer
	 */
    public static boolean getAndVerifyPDFTextData(String strFileName,int intSetPDFPageNo,String strTextToSearch) {
        PDDocument document = null;
        boolean blnFlag=false;
        String fileName =System.getProperty("user.dir")+"/src/test/resources/downloads/"+strFileName+"";
       
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new PDFUtilitiesFunctions(objPojo);
            stripper.setSortByPosition( true );
            stripper.setStartPage(intSetPDFPageNo);
            stripper.setEndPage( document.getNumberOfPages() );
            Writer strWriter = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, strWriter);
            
            for(String strWord:pDFWords){
            	String strTxt=strWord;
            	System.out.println("PDF Text data : "+strTxt);
           // 	objPojo.getObjUtilities().consoleLogPrinter(strTxt); 
                
                if(strTxt.equals(strTextToSearch)){
                	objPojo.getObjUtilities().logReporter("Search Text Found in PDF content -----> "+ strTxt, true);
                	blnFlag=true;
                	break;
                }else {
					
				}
            }
            return blnFlag;
        } catch (InvalidPasswordException eInvalidPasswordException) {
        	System.out.println("Error Message ------> "+eInvalidPasswordException.toString());
        	eInvalidPasswordException.printStackTrace();
        	return false;
		} catch (IOException ioException) {
        	System.out.println("Error Message ------> "+ioException.toString());
        	ioException.printStackTrace();
        	return false;
		}
        finally {
            if( document != null ) {
                try {
					document.close();
				} catch (IOException exception) {
		        	System.out.println("Error Message ------> "+exception.toString());
					exception.printStackTrace();
				}
            }
            
        }
    }
    
    /**
	 * @Method : writeString
	 * @Description : Override the default functionality of PDFTextStripper.writeString()
	 * @param : str,textPositions
	 * @author :  SDET Developer
	 */
    protected void writeString(String strVal, List<TextPosition> strTextPositions) throws IOException {
        String[] wordsInputStream = strVal.split(getWordSeparator());
        if(wordsInputStream!=null){
            for(String strWord :wordsInputStream){
            	pDFWords.add(strWord);
            }
        }
    }
    
	
    
    public static void getPDFData(String strPDFFileName,String strTextFileName){
    	 PDDocument pdDocument;
    	 BufferedWriter wr;
    	 try {
    	         File input = new File(strPDFFileName);
    	         File output = new File(strTextFileName);
    	         pdDocument = PDDocument.load(input);
    	         System.out.println(pdDocument.getNumberOfPages());
    	         System.out.println(pdDocument.isEncrypted());
    	         //pd.save("SvaveFilename.pdf");
    	         PDFTextStripper stripper = new PDFTextStripper();
    	         wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
    	         stripper.writeText(pdDocument, wr);
    	         if (pdDocument != null) {
    	        	 pdDocument.close();
    	         }
    	        wr.close();
    	 } catch (Exception exception){
    		 	 System.out.println("I got ERROR EXCEPTION : "+exception.getMessage());
    	         exception.printStackTrace();
    	        } 
    	     }
    
    
    
    
    
    
    
    
} 