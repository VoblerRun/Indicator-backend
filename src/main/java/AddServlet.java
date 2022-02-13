import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {

    public class ReturnAuthorizationProfile{
        public String tokenSession = "";
        public Boolean isSuccessAuthorization = false;

        public ReturnAuthorizationProfile(){}

        public void setTokenSession(String tokenSession){
            this.tokenSession = tokenSession;
        }

        public String getTokenSession(){
            return this.tokenSession;
        }

        public void setIsSuccessAuthorization(Boolean isSuccessAuthorization){
            this.isSuccessAuthorization = isSuccessAuthorization;
        }

        public Boolean getIsSuccessAuthorization(){
            return this.isSuccessAuthorization;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionDataBase connectionDataBase = new ConnectionDataBase();
        try {
            connectionDataBase.readDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Принимаем информацию о клиенте
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");

        String password = request.getParameter("password");
        password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username + ":" + password);


        ReturnAuthorizationProfile returnAuthorizationProfile = new ReturnAuthorizationProfile();
        returnAuthorizationProfile.isSuccessAuthorization = true;
        returnAuthorizationProfile.tokenSession = "test-token-8966222";

        // Возвращаем информацию клиенту
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String objectAuthorization = mapper.writeValueAsString(returnAuthorizationProfile);
        System.out.println(objectAuthorization);
        if( true ){
            out.print (objectAuthorization);
//            out.print ("«Пароль:» + пароль");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }


}
