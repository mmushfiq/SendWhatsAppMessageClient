
package az.mm.sendwhatsappmessage.Beans;

import az.mm.sendwhatsappmessage.Classes.JerseyClientClass;
import az.mm.sendwhatsappmessage.Classes.MyConstants;
import az.mm.sendwhatsappmessage.Classes.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import org.json.simple.JSONObject;

/**
 *
 * @author MM
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable{

  JerseyClientClass client = new JerseyClientClass();
  private String nickname_or_number;
  private String password;
  private String path;
  private List<Users> user_list = new ArrayList<>();
  private String to;
  private String body_text;
  private Users user = new Users();

    public String signIn() {
        path = MyConstants.MAIN_PATH+"controluser/" + nickname_or_number + "/" + password;
        String response = client.jerseyClientGet(path);

        if (response.equals("ok")) {
            System.out.println("Bele istifadechi movcuddur");
            path = MyConstants.MAIN_PATH+"userdata/" + nickname_or_number;
            String list = client.jerseyClientGet(path);
            System.out.println("list-->" + list);
            JSONObject json_user = new JerseyClientClass().parseNamedJson(list);
            System.out.println("json_user name: " + json_user.get("nickname"));

            user_list.add(new Users(json_user.get("phone").toString(), json_user.get("nickname").toString(), json_user.get("pw").toString(), json_user.get("email").toString(), json_user.get("wpw").toString(), json_user.get("imei").toString(), json_user.get("sms_code").toString(), json_user.get("rdate").toString()));

            return "welcome?faces-redirect=true";
        } else {
            return null;
        }
    }
  
    
    public String sendMessage(){
        System.out.println("send mesage metoduna girdi");
        System.out.println("user nickname="+user_list.get(0).getNickname());
//        path = MyConstants.MAIN_PATH+"send/"+user.getPhone()+"/"+user.getImei()+"/"+user.getNickname()+"/"+user.getWpw()+"/"+to+"/"+body_text;
        path = MyConstants.MAIN_PATH+"send?username="+user_list.get(0).getPhone()+"&identity="+user_list.get(0).getImei()+"&nickname="+user_list.get(0).getNickname()+"&whatsapp_password="+user_list.get(0).getWpw()+"&to="+to+"&body_text="+body_text;
        System.out.println("send path--> "+path);
        String response = client.jerseyClientGet(path);
        System.out.println("send_message response--> "+response);
        
        return null;
    }
  
  
    private String[] phone_numbers;

    public String showCheckedNumbers(){
        System.out.println("numbers-->"+phone_numbers.toString());
        for(int i=0; i<phone_numbers.length; i++){
            System.out.println(i+"="+phone_numbers[i]);
        }
        
        return null;
    }
  
  
  
  
  public String getNickname_or_number() { return nickname_or_number; }
  public void setNickname_or_number(String nickname_or_number) { this.nickname_or_number = nickname_or_number; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
    
  public String[] getPhone_numbers() { return phone_numbers; }
  public void setPhone_numbers(String[] phone_numbers) { this.phone_numbers = phone_numbers; }

  public List<Users> getUser_list() { return user_list; }
  public void setUser_list(List<Users> user_list) { this.user_list = user_list; }

  public String getTo() { return to; }
  public void setTo(String to) { this.to = to; }
  
  public String getBody_text() { return body_text; }
  public void setBody_text(String body_text) { this.body_text = body_text; }

  public Users getUser() { return user; }
  public void setUser(Users user) { this.user = user; }


    
    
    
}
