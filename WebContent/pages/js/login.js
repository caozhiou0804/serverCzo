$(function() {

	$(".register").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		if (!username) {
			alert("请输入登陆凭证");
			return;
		}
		if (!password) {
			alert("请输入密码");
			return;
		}
//		location.href = "http://www.baidu.com";
		register(username,password);
	});

});

function register(username,password) {
	var url = "http://localhost:8080/WebApp/Userfeature/registeMember";
	var data = {};
	data.username=username;
	data.password=password;
	data.confirm_password=password;
	$.ajax({
		async : false,
		url : url,
		type : 'POST',
		dataType : 'json',
		data : data,
		success : function(result) {
			alert(result.message);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("请求失败，请刷新后重试!" + XMLHttpRequest.status);
		}
	});
}