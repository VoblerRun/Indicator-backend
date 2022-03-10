import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationServlet extends HttpServlet {

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

        // Принимаем информацию о клиенте
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");

        String password = request.getParameter("password");
        password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username + ":" + password);

        AuthorizationHandler authorizationHandler = new AuthorizationHandler();
        try {
            authorizationHandler.readDataBase(username.substring(0, 3) + password.substring(0, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }



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
        if(true){
            out.print (objectAuthorization);
        }else{
            out.print("Error");
        }
        out.flush();
        out.close();
    }


}
