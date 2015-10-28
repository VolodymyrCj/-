<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		

		<title>我的账户</title>

		<link type="text/css" rel="stylesheet" href="public(1).css">

		<link type="text/css" rel="stylesheet" href="style(1).css">

	<script language="javascript" src="jsutil.js"></script>
	<script language="javascript">
    
	function submitform(){
		if(check()){
			document.getElementById("f").submit();
		}
	}
	function check() {
		//alert(f['mUserInfo.realName'].value);

		if (document.getElementById("usertel").value==""){
			alert("请输入联系电话！");
			return false;
		}
		if (!isMobil(document.getElementById("usertel").value)){
			alert("请输入正确的联系电话！");
			return false;
		}
		if (document.getElementById("useremail").value=="") {
			alert("请输入电子邮件地址！");
			return false;
		}
		if (!isEmail(document.getElementById("useremail").value)){
			alert("请输入正确的电子邮件地址！");
			return false;
		}
		if (!isChecked(document.getElementsByName("userinfor.sex"))) {
			alert("请选择性别！");
			return false;
		}
		
	
		return true;
	}
	
	function isChecked(obj){
	    for(var i=0; i<obj.length; i ++){
	        if(obj[i].checked){
	        	return true;
	        }
	    }
	    return false;
	}
	
	function isMobil(s) {
	    //var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	    var patrn = /^(13[0-9]{9})|(14[0-9])|(18[0-9])|(15[0-9][0-9]{8})$/;
	    if (!patrn.exec(s)) return false
	    else return true
	}
	
	function isEmail(s) {
	    //var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	    var patrn = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	    if (!patrn.exec(s)) return false
	    else return true
	}
	
	function reset(){
		document.getElementById("f").reset();
	}

</script></head>

	<body style="background:none">

<form  id="f"  method="post" action="updateuser" >
        	<div class="pe_r_img"><img src="pebg2.gif"></div>
        	<div class="pe_r_t"><a href="selectuser?">信息修改</a>|<a href="mypassword.jsp">密码修改</a>|<a href="prepaypass.htm">支付密码申请</a>|<a href="checkIndividuation.htm">安全设置</a></div>
           	<div class="pe_r_title">信息修改</div>
            <div class="pe_r_tab">
<table width="745" border="0">
  <tbody><tr bgcolor="#E9E3D7">
  	<td width="366" height="37">
    <div align="right" class="perco">用户名：</div>
    </td>
    <td width="369">
    	
    	<input type="text" readonly="readonly" style= "background-color:transparent;border:0;" value="<s:property value='userinfor.userid'/>" name="userinfor.userid" size="24" maxlength="40">  
    </td>
  </tr>
  <tr>
  	<td width="366" height="37"><div align="right" class="perco">用户全称：</div></td>
  	<td width="369"><input type="text"  readonly="readonly" style= "background-color:transparent;border:0;" value="<s:property value='userinfor.username'/>" name="userinfor.username" size="24" maxlength="40"> 
    </td>
  </tr>
  <tr bgcolor="#E9E3D7">
  	<td width="366" height="37">
    <div align="right" class="perco">身份证号码：</div>
    </td>
    <td width="369">
    <input type="text"  readonly="readonly" style= "background-color:transparent;border:0;" value="<s:property value='userinfor.useridcard'/>" name="userinfor.useridcard" size="24" maxlength="40"> 
    	
    </td>
  </tr>
  <tr>

  	<td width="366" height="37"><div align="right" class="perco">联系电话：</div></td>
  	<s:if test="%{userinfor.usertel==null}">
  	<td width="369"><input type="text" id="usertel" name="userinfor.usertel" size="24" maxlength="40"><font color="#FF0000"><strong>*</strong></font> </td>
</s:if>  
  	<s:elseif test="%{userinfor.usertel!=null}">
  	<td width="369"><input type="text" id="usertel" value="<s:property value='userinfor.usertel'/>" name="userinfor.usertel" size="24" maxlength="40"><font color="#FF0000"><strong>*</strong></font> </td>
</s:elseif>  
  </tr>
  
  
  <tr bgcolor="#E9E3D7">
  	<td width="366" height="37">
    <div align="right" class="perco">联系E-Mail：</div></td>
      	<s:if test="%{userinfor.usertel==null}">
    <td width="369"><input type="text" id="useremail" name="userinfor.useremail" size="24" maxlength="40"><font color="#FF0000"><strong>*</strong></font></td>
  </s:if>
  <s:if test="%{userinfor.usertel!=null}">
    <td width="369"><input type="text" id="useremail" value="<s:property value='userinfor.useremail'/>" name="userinfor.useremail" size="24" maxlength="40"><font color="#FF0000"><strong>*</strong></font></td>
  </s:if>
  </tr>
  <tr >
  	<td width="366" height="37">
    <div align="right" class="perco">性别：</div></td>
    
      <s:if test="%{userinfor.sex==null}">
    <td width="369">                          
        <input type="radio" name="userinfor.sex" id="mUserInfo.sex0" value="男"><label for="mUserInfo.sex0">男</label>         
        <input type="radio" name="userinfor.sex" id="mUserInfo.sex1" value="女"><label for="mUserInfo.sex1">女</label>
    </td>
    </s:if>
    <s:elseif test='%{userinfor.sex=="男"}'>
    <td width="369">                          
        <input type="radio" name="userinfor.sex" checked="checked" id="mUserInfo.sex0" value="男"><label for="mUserInfo.sex0">男</label>         
        <input type="radio" name="userinfor.sex" id="mUserInfo.sex1" value="女"><label for="mUserInfo.sex1">女</label>
    </td>
    </s:elseif>
 	<s:elseif test='%{userinfor.sex=="女"}'>
     <td width="369">                          
        <input type="radio" name="userinfor.sex" id="mUserInfo.sex0" value="男"><label for="mUserInfo.sex0">男</label>         
        <input type="radio" name="userinfor.sex" checked="checked"id="mUserInfo.sex1" value="女"><label for="mUserInfo.sex1">女</label>
    </td>
    </s:elseif>
  </tr>

  <tr bgcolor="#E9E3D7">
  	<td width="366" height="37">
    <div align="right" class="perco">地址：</div></td>
    <td width="369"><input type="text" value="<s:property value='userinfor.address'/>" name="userinfor.address" size="24" maxlength="40">
   </td>
  </tr>
  <tr >
  	<td width="366" height="37">
    <div align="right" class="perco">当前状态：</div></td>
    <td width="369">正常
    </td>
  </tr>
  <tr bgcolor="#E9E3D7">
  	<td width="366" height="37">
    <div align="right" class="perco">消费上限(元)：</div></td>
    <td width="369">
    
    	<input type="text" style= "background-color:transparent;border:0;" value="<s:property value='userinfor.expend'/>" name="userinfor.expend" size="24" maxlength="40">  

    </td>
  </tr>
  <tr>
  	<td colspan="2" align="center">
    <div>
    <img name="Submit" style="cursor: hand" src="modify.gif" value="修改" onClick="submitform()">
		<img name="Submit" style="cursor: hand" src="reset.gif" value="取消" onClick="reset()">
    </div>
    </td>
  </tr>
</tbody></table>
</div>
</form>
</body></html>