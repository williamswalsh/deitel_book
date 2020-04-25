package signatures;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

//import com.amazonaws.AmazonClientException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.CrlClientOnline;
import com.itextpdf.text.pdf.security.LtvTimestamp;
import com.itextpdf.text.pdf.security.LtvVerification;
import com.itextpdf.text.pdf.security.OcspClient;
import com.itextpdf.text.pdf.security.OcspClientBouncyCastle;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import com.itextpdf.text.pdf.security.TSAClient;
import com.itextpdf.text.pdf.security.TSAClientBouncyCastle;
//import models.document.Document;
//import models.document.DocumentRepository;
//import models.document.EbeanDocumentRepository;
//
//import play.Logger;
//import play.Play;
//import play.libs.F.Option;
//import services.document.content.DocumentContentService;
//import services.document.content.DocumentContentServiceProvider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidParameterException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;


public class SignaturePresenceChecker {

    /**
     * Check if the document has a signature
     *
     * @param docBytes - the byte[] of the document
     */
    private static boolean hasSignature (final byte[] docBytes) throws IOException {
        final PdfReader reader = new PdfReader(docBytes);
        final AcroFields fields = reader.getAcroFields();
        final List<String> signatureNames = fields.getSignatureNames();

        boolean hasSignature = !signatureNames.isEmpty();
        return hasSignature;
    }

    /**
     * Get the timestamp expiration date from the document
     *
     * @param docBytes - the byte[] of the document
     */
    public static Date getExpirationDateFromDocBytes(final byte[] docBytes) {
        try {
            if ( hasSignature(docBytes) ) {
                final Certificate[] chain = getPdfPKCS7FromDocBytes(docBytes).getSignCertificateChain();
                final X509Certificate x509Certificate = X509Certificate.getInstance(chain[chain.length - 1].getEncoded());
                return x509Certificate.getNotAfter();
            }else{
                return null;
            }
        } catch (IOException | CertificateException | CertificateEncodingException e) {
            System.err.println("getExpirationDateFromBytes - An error occured when getting the expiration date"
                    + " from bytes :" + e.getMessage());
        }
        return null;
    }

    private static PdfPKCS7 getPdfPKCS7FromDocBytes(final byte[] docBytes) throws IOException {
        final PdfReader reader = new PdfReader(docBytes);
        final AcroFields fields = reader.getAcroFields();
        final List<String> names = fields.getSignatureNames();
        final String signatureName = names.get(names.size() - 1);
        return fields.verifySignature(signatureName);
    }

    public static void main(String[] args) throws IOException {
// Path pdfPath = Paths.get("/Users/will/delete_contents_weekly/tallaght_invalid_cert/ea6b1519-cf8a-4547-91a9-9fc5e26f85f1.pdf"); // Invalid Signature -> 2 signatures present
            Path pdfPath = Paths.get("/Users/will/delete_contents_weekly/8cd2ddb0-af72-448f-8d4d-c1d81be569e3.pdf"); // Bad signature
//        //Path pdfPath = Paths.get("/Users/will/Dropbox (Digitary)/Company/WilliamWalsh/Sample Distinct Docs/sample_unsigned_sales_doc.pdf"); // Unsigned doc -> 0 signatures
            final byte[] docBytes = Files.readAllBytes(pdfPath);

        final PdfReader reader = new PdfReader(docBytes);
        final AcroFields fields = reader.getAcroFields();
        final List<String> signatureNames = fields.getSignatureNames();
        boolean hasSignature = !signatureNames.isEmpty();
        System.out.println("Ans: " + hasSignature);
        System.out.println("Has element: " + !signatureNames.isEmpty());
//
        for(String sign: signatureNames){
            System.out.println(sign);
        }
//        final byte[] docBytes = null;
//        final PdfReader reader = new PdfReader(docBytes);

    }
}
