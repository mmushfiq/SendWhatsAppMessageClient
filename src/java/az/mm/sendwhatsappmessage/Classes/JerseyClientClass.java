
package az.mm.sendwhatsappmessage.Classes;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author MM
 */
public class JerseyClientClass {
    
     public String jerseyClientGet(String path){
    
        try {

            Client client = Client.create();
            WebResource webResource = client.resource(path);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                                    + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);
            
            return output;

        } catch (Exception e) {
            System.out.println("jerseyClientGet catch-->"+e);
            e.printStackTrace();
            return null;
        }
    }
     
     
//------------------------------------------------------------------------------     
    public JSONObject parseUnnamedJson(String json_text){
        JSONObject jSONObject=null;
        try {
//                Object obj = JSONValue.parse(json_text);
//                JSONArray array = (JSONArray) obj;
//                JSONObject jSONObject = null;
//                for (int i = 0; i < array.size(); i++) {
//                    jSONObject = (JSONObject) array.get(i);
//                    System.out.println(jSONObject.get("length") + "  +  " + jSONObject.get("method") + "  +  " + jSONObject.get("retry_after") + "  +  " + jSONObject.get("status"));
//                }
            jSONObject = (JSONObject) JSONValue.parse(json_text);
//            System.out.println(jSONObject.get("length") + "  +  " + jSONObject.get("method") + "  +  " + jSONObject.get("retry_after") + "  +  " + jSONObject.get("status"));

        } catch (Exception e) {
            System.out.println("parseUnnamedJson catch-->"+e);
            e.printStackTrace();
        }
      return jSONObject;
    }
    
    
//------------------------------------------------------------------------------
     public JSONObject parseNamedJson(String json_text){
         JSONParser parser = new JSONParser();
            ContainerFactory containerFactory = new ContainerFactory() {
                @Override
                public List creatArrayContainer() {
                return new LinkedList();
                }

                @Override
                public Map createObjectContainer() {
                return new LinkedHashMap();
                }
            };

            String s1 = "";
            try {
            Map json = (Map) parser.parse(json_text, containerFactory);
            Iterator iter = json.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                System.out.println(entry.getKey() + "=>" + entry.getValue());
                s1 = JSONValue.toJSONString(entry.getValue());
            }

            } catch (ParseException pe) {
            System.out.println("ParseException-->"+pe);
            }

//            Object obj = JSONValue.parse(s1);
//            JSONArray array = (JSONArray) obj;
//            JSONObject jSONObject = null;
//            for (int i = 0; i < array.size(); i++) {
//            jSONObject = (JSONObject) array.get(i);
            
            /* list cemi 1 setir qaytardigindan jsonarray istifade etmeye ehtiyac yoxdu*/
            JSONObject jSONObject = (JSONObject) JSONValue.parse(s1);
            
            return jSONObject;
            
            }
    }
    

