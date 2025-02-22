$(document).ready(function(){
	$('#id_err').hide();
	$('#age_err1').hide();
	$('#age_err2').hide();
	$('#pwd_err1').hide();
	$('#pwd_err2').hide();
	
	$('#btnSend').click(function(){
		// 입력 자료 오류 검사 후 자료를 서버로 전송
		// id 검사
		let id = $('#userid').val(); // document.querySelector('#userid').value
		// alert(id);
		if(id.length < 2 || isNaN(id) === false){
			// alert("에러 메세지");
			$('#id_err').show();
			return false;
			}else{
				$('#id_err').hide();
			}
		
		// age 검사	
		let age = $('#age').val(); 	
		if(age.length < 1){
			$('#age_err').show();
			return false;
		}else{
			$('#age_err').hide();
		}	
			
			// age 숫자만 허용
			/*
			for (let i = 0; i < age.length; i++){
				// 1 글자씩 추출 후 Ascii 코드 값 얻기
				let data = age.charAt(i).charCodeAt(0);  
				//age.charAt(i)는 문자열 age에서 i번째 위치의 문자를 가져옵니다.
				//.charCodeAt(0)는 charAt(i)가 반환한 문자열의 0번째 위치에 있는 
				//문자의 ASCII 코드를 가져옵니다. 이는 본질적으로 age 문자열의 i번째 위치에 
				//있는 문자의 ASCII 코드를 가져오는 것과 같습니다.
				//결과는 변수 data에 저장됩니다.
				// alert(data);
				if(data < 48 || data > 57){
	//이 조건문은 data에 저장된 ASCII 코드가 숫자 문자 '0'에서 '9'의 ASCII 코드 범위에 
	//속하지 않는지 확인합니다. '0'에서 '9'의 ASCII 코드는 각각 48에서 57입니다.
    //만약 data가 48보다 작거나 57보다 크다면, 이는 해당 문자가 숫자가 아님을 의미합니다.
					$('#age_err2').show();
					return false;
				}else{
					$('#age_err2').hide();
				}
			}
			*/
			
			/* 방법 중 하나 : 사용자 정의 함수 작성 후 호출
			if(isPositiveInteger_myFunc(age) || age < 15 || age > 100){
				$('#age_err2').show();
				return false;
			}else{
				$('#age_err2').hide();
			}
			*/
			
			// 방법 중 하나 : 사용자 정의 함수(정규표현식 사용) 작성 후 호출
			if(!isValidAge_myFunc(age)){
				$('#age_err2').show();
				return false;
			}else{
				$('#age_err2').hide();
			}

		// 비밀번호 검사
		let pwd1 = $('#pwd1').val();
		if(pwd1.length < 1){
			$('#pwd1').next().show(); // next() : next sibling을 의미
			return false;
		}else{
			$('#pwd1').next().hide(); // next(), prev()
		}
		
		let pwd2 = $('#pwd2').val();
		if(pwd1 !== pwd2){
			$('#pwd_err2').show();
			return false;
		}else{
			$('#pwd_err2').hide();
		}
		
		// form 태그에서 입력한 자료를 서버 파일로 전송
		$("#signFrm").attr('action', 'jq3.jsp').attr('method', 'post').submit();
		


	});	
});

function isPositiveInteger_myFunc(para){ // 내가 만든 함수 
	let num = Number(para);
	return Number.isInteger(num) && num > 0;
}

function isValidAge_myFunc(para){ // 내가 만든 정규표현식 사용 함수 
	let ageRegex = /^(1[5-9]|[2-9][0-9]|100)$/;
	return ageRegex.test(para);  // age가 정규표현식과 일치하는지 텍스트한 값 반환 
}			