let u_id = document.getElementsByName('name');
let u_pw = document.getElementsByName('pw');

console.log(u_id);

function call(){


	if(isEmpty(u_id)){
		alert("ユーザーIDを入力してください。");
		u_id.value = "";
		u_id.focus();
		return false;
	}

	if(isEmpty(u_pw)){
		alert("ユーザーIDを入力してください。");
		u_pw.value = "";
		u_pw.focus();
		return false;
	}

	if(cnt == 1){
		return false;
	}

	return true;

}
