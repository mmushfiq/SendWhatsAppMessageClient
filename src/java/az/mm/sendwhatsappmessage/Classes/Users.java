
package az.mm.sendwhatsappmessage.Classes;

import java.io.Serializable;

/**
 *
 * @author MM
 */


public class Users implements Serializable{
    private String phone;
    private String nickname;
    private String pw; //password
    private String email;
    private String wpw; //whatsapp password
    private String imei;
    private String sms_code;
    private String rdate;
    

    
    
    public Users() {
    }

    public Users(String phone, String nickname, String pw, String email, String wpw, String imei, String sms_code, String rdate) {
        this.phone = phone;
        this.nickname = nickname;
        this.pw = pw;
        this.email = email;
        this.wpw = wpw;
        this.imei = imei;
        this.sms_code = sms_code;
        this.rdate = rdate;
    }
  
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getPw() { return pw; }
    public void setPw(String pw) { this.pw = pw; }

    public String getWpw() { return wpw; }
    public void setWpw(String wpw) { this.wpw = wpw; }

    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }

    public String getSms_code() { return sms_code; }
    public void setSms_code(String sms_code) { this.sms_code = sms_code; }

    public String getRdate() { return rdate; }
    public void setRdate(String rdate) { this.rdate = rdate; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
      
}
