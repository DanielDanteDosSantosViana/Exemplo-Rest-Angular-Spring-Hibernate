package br.com.athenas.infrastructure.apresentation.view.http.download;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
@RequestMapping("/download")
public class DownloadViewJSON {

	@RequestMapping( value="/pdf" , method = RequestMethod.GET , produces = "application/pdf")
	@ResponseBody
	public ResponseEntity<byte[]> download(HttpServletRequest request){
		try {
			  Document document = new Document();
			  ByteArrayOutputStream baos = new ByteArrayOutputStream();
			  PdfWriter.getInstance(document, baos);
			  document.open();
			  document.add(new Paragraph("Teste NOVO!"));
			  document.close();
			    
			    byte[] contents = baos.toByteArray();
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.parseMediaType("application/pdf"));
	            String filename = "test.pdf";
	            headers.setContentDispositionFormData(filename, filename);
	            
	            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
				return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
