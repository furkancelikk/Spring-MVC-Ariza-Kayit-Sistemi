package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Istemcinin response ile donecek verinin tipini bilip ona göre verinin istemci tarafında
        // dogru gosterilmesi saglaniyor
        response.setContentType("text/html;charset=UTF-8");

        // Response nesnesine içerik yazmak için PrintWriter nesnesi oluşturuluyor
        PrintWriter writer = null;

        // Browser’ın hangi HTML versiyonunu kullanılacağı belirtilir. Örnekte HTML 5 kullanılmış
        String responseHeader = "<!doctype html>";

        responseHeader += "<html><head>";
        responseHeader += "<meta http-equiv='Content-Type' content='text/htmlcharset=UTF-8'>";
        responseHeader += "<title>Servlet'den Merhaba!</title>";
        responseHeader += "<title>Servlet'den Merhaba!</title>";

        try {
            writer = response.getWriter(); //IOException’ı fırlattığı için Exception Handling mekanizmasında kullanılması gerekiyor.

            writer.println(responseHeader);

            writer.println("<body>");
            writer.println("<h1>Anasayfa</h1>");

            // Istek bilgileri yazdiriliyor
            HttpSession session = request.getSession();
            writer.println("<p>Bağlantı Adresi: <strong>" + request.getRemoteAddr() + "</strong></p>");
            writer.println("<p>İstek URI: <strong>" + request.getRequestURI() + "</strong></p>");
            writer.println("<p>Protokol: <strong>" + request.getProtocol() + "</strong></p>");
            writer.println("<p>İstek Metodu: <strong>" + request.getMethod() + "</strong></p>");
            writer.println("<p>Session Id: <strong>" + session.getId() + "</strong></p>");
            writer.println("<p>Session Oluşturulma Zamanı: <strong>"
                    + convertTime(session.getCreationTime()) + "</strong></p>");
            writer.println("<p>Session Son İstek Zamanı: <strong>"
                    + convertTime(session.getLastAccessedTime()) + "</strong></p>");
            writer.println("<p>Session Yeni Mi?: <strong>"
                    + (session.isNew() ? "Evet" : "Hayır") + "</strong></p>");
            writer.println("</body>");
            writer.println("</html>");

        }catch (IOException ioException){
            ioException.printStackTrace();
        }finally {
            writer.close(); // Yazdırıcı kapatılıyor
//            writer.flush(); İçeriğin yazdırılması tetikleniyor
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private String convertTime(long creationTime) {
        Date time = new Date(creationTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(time);
    }
}
