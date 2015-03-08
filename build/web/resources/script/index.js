
$(document).ready(function(){
   
//    $(".left-div :text").on({ 
//          keyup:       function() { extractNumber(this,0,false); }          
//         ,click:       function() { clearText(this); }
//         ,blur:        function() { extractNumber(this,0,false); insertZeroInt(this); }
//         ,onkeypress:  function() { return blockNonNumbers(this, event, false, false);  }
//    });
//    
//    $(".left-div :text").attr("maxlength","2");
//    setDisableInput();
//    $(".box-combo").css("visibility", "hidden");
//    $(".box-text").css("color", "grey");
//    $(".left-div .drink-list :checkbox").change(setDisableInput);
//    
//   
//    $(".box-checkbox").click(function(){
//        if($(this).is(":checked")){
//           $(".box-combo").css("visibility", "visible");
//           $(".box-text").css("color", "black");
//        } else {
//           $(".box-combo").css("visibility", "hidden"); 
//           $(".box-text").css("color", "grey");
//        }
//    });
//    
   
    
//------------------------------------------------------------------------------    
//    function setDisableInput(){
//        var input_array =  $(".left-div .drink-list :text");
//   
//        $(".left-div .drink-list :checkbox").each(function(index, element){
//            if($(element).is(":checked")){
//                $(input_array[index]).removeAttr("disabled");
//            }else{
//                $(input_array[index]).attr("disabled", "disabled");
//            }
//        });
//    };
    
    
//    function loadingFunc() {
//        var loading = '<center><img style="margin-top:100px;" width="60px" height="60px" src="resources/image/loading2.gif" /><p>Yüklənir..</p></center>';
//        $('.box-div').html(loading); 
//    }
   
     
    function requestProcessFunc(data, event_name){
        
        if(data.status === 'begin'){            
            alert('begin');
        } else if(data.status === 'success'){
            alert('success');
        }
    };
    
    
    $('#signin').click(function (){ 
        $(".signin_window").css("display", "block");
        $(".signup_window").css("display", "none");
    });
    
    $('#signup').click(function (){ 
        $(".signup_window").css("display", "block");
        $(".signin_window").css("display", "none");
    });
       
    
}); //ready son

    function requestProcessFunc(data, event_name){
        
        if(data.status === 'begin'){            
//            alert('begin');
            


        } else if(data.status === 'success'){
            
            if(event_name === 'request'){
                $(".btnRequest").css("display", "none");
                $(".sms_code").css("display", "block");
                $(".btnRegister").css("display", "block");
//                document.getElementsByClassName('btnRequest').style.display="none";
//                document.getElementsByClassName('sms_code').style.display="block"; 
//                document.getElementsByClassName('btnRegister').style.display="block";
            } else if (event_name === 'register'){
                $(".btnRegister").css("display", "none");
                $(".password").css("display", "block");
//                document.getElementsByClassName('btnRegister').style.display="none";
//                document.getElementsByClassName('password').style.display="block";
            }
            
        }
    };

