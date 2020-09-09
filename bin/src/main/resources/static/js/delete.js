function teamDelete() {
	
	let data = {
			
			id : $("#id").val()
			
	}
	
	alert(data.id);
	console.log(JSON.stringify(data));
	
	$.ajax({
		
		type : "delete",
		url : "/teamDelete",
		data : JSON.stringify(data),
		contentType : "application/json; charset=UTF-8",
		dataType : "json"
			
	}).done(function(resp) {
		
		alert("삭제에 성공하였습니다.");
		console.log(resp);
		location.href="/teamList";
		
	}).fail(function(resp) {
		
		alert("삭제에 실패하였습니다.")
		alert(resp);
		
	})
}