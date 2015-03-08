

package az.mm.sendwhatsappmessage.Beans;

import az.mm.sendwhatsappmessage.Classes.JerseyClientClass;
import az.mm.sendwhatsappmessage.Classes.MyConstants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author MM
 */
@Named(value = "registration")
@RequestScoped
public class Registration {
    
    JerseyClientClass client = new JerseyClientClass();
    private String nickname;
    private String phone_number;
    private String IMEI;
    private String password;
    private String email;
    private String sms_code;
    private String whatsapp_password="";
    private String event_info;
//    private String btn_name="Send sms code";
//    private String event_name="request";

    
    public void startProcess(String event){
        
        String path="";
        switch(event){
            
            case "request":   
                path = MyConstants.MAIN_PATH+"request/"+phone_number+"/"+IMEI+"/"+nickname;                 
                event_info = client.jerseyClientGet(path);
                if(event_info!= null && event_info.contains("{:}")){
                    JSONObject object = client.parseUnnamedJson(event_info);
                    System.out.println("status--> "+object.get("status"));
                }
                break;
                
            case "register":  
                path = MyConstants.MAIN_PATH+"register/"+phone_number+"/"+IMEI+"/"+nickname+"/"+sms_code;   
                event_info = client.jerseyClientGet(path);
                if(true){
                   whatsapp_password = client.parseUnnamedJson(event_info).get("pw").toString();
                    System.out.println("whatsapp_password-->"+whatsapp_password);
                }
                break;
                
            case "login":     
                path = MyConstants.MAIN_PATH+"login/?username="+phone_number+"&identity="+IMEI+"&nickname="+nickname+"&sms_code="+sms_code+"&whatsapp_password="+whatsapp_password+"&password="+password+"&email="+email;      
                System.out.println("login path--> "+path);
                event_info = client.jerseyClientGet(path);
                if(event_info!=null && event_info.equals("true")){
                    redirectToPage("welcome.xhtml");
                }
                break; 
                
            default:          
//                path = "http://localhost:8080/WhatsApiRestService/rest/whatsapi/";
                redirectToPage("index.xhtml");
                break;
        
        }
        showEventInfo();
        
    }
    


    private void  redirectToPage(String toUrl) {
        try {
            System.out.println("redirectToPage metoduna girdi");
            FacesContext ctx = FacesContext.getCurrentInstance();
            ExternalContext extContext = ctx.getExternalContext();
            String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/" + toUrl));
            extContext.redirect(url);
        } catch (IOException e) {
            System.err.println("redirectToPage catch"+e);
            throw new FacesException(e);
        }
    }
    
    
    
    private void showEventInfo(){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Event Info", event_info);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     
    
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public String getIMEI() { return IMEI; }
    public void setIMEI(String IMEI) { this.IMEI = IMEI; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSms_code() { return sms_code; }
    public void setSms_code(String sms_code) { this.sms_code = sms_code; }

    public String getWhatsapp_password() { return whatsapp_password; }
    public void setWhatsapp_password(String whatsapp_password) { this.whatsapp_password = whatsapp_password; }

//    public String getBtn_name() {
//        return btn_name;
//    }
//
//    public void setBtn_name(String btn_name) {
//        this.btn_name = btn_name;
//    }

    public String getEvent_info() {  return event_info; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    
    
    
    
    
    
    

   
    
}
