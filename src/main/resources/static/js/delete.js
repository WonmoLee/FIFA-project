function teamDelete() {
	
	let data = {
			
			id : $("#id").val()
			
	}
	
	$.ajax({
		
		type : "delete",
		url : "/teamDelete",
		data : JSON.stringify(data),
		contentType : "application/json; charset=UTF-8",
		dataType : "text"
			
	}).done(function(resp) {
		
		alert("삭제에 성공하였습니다.");
		console.log(resp);
		location.href="/teamList";
		
	}).fail(function(resp) {
		
		alert("삭제에 실패하였습니다.")
		alert(resp);
		
	})
}

function stardiumDelete() {
	
	let data = {
			
			id : $("#id").val()
			
	}
	
	$.ajax({
		
		type : "delete",
		url : "/stardiumDelete",
		data : JSON.stringify(data),
		contentType : "application/json; charset=UTF-8",
		dataType : "text"
			
	}).done(function(resp) {
		
		alert("삭제에 성공하였습니다.");
		console.log(resp);
		location.href="/stardiumList";
		
	}).fail(function(resp) {
		
		alert("삭제에 실패하였습니다.")
		alert(resp);
		
	})
}

function playerDelete() {
	
	let data = {
			
			id : $("#id").val()
			
	}
	
	$.ajax({
		
		type : "delete",
		url : "/playerDelete",
		data : JSON.stringify(data),
		contentType : "application/json; charset=UTF-8",
		dataType : "text"
			
	}).done(function(resp) {
		
		alert("삭제에 성공하였습니다.");
		console.log(resp);
		location.href="/playerList";
		
	}).fail(function(resp) {
		
		alert("삭제에 실패하였습니다.")
		alert(resp);
		
	})
}