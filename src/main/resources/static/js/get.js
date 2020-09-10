function getPlayer(teamId) {
	
	$.ajax({
		
		type: "get",
		url: "/getPlayer/" + teamId,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
		
	}).done(function(resp) {
		
		$("#playerData").empty();
		for(var player of resp){
			
			var data = "";
			
			if(player.retiredPlayer == null){
				
				var data = 	
					"				<tr>\r\n" + 
					"					<th>"+player.id+"</th>\r\n" + 
					"					<th>"+player.playerName+"</th>\r\n" + 
					"					<th>"+player.position+"</th>\r\n" + 
	 				"					<th></th>\r\n" + 
	 				"					<th></th>\r\n" + 
					"				</tr>";
					
			} else {
				
				var data = 	
					"				<tr>\r\n" + 
					"					<th>"+player.id+"</th>\r\n" + 
					"					<th>"+player.playerName+"</th>\r\n" + 
					"					<th>"+player.position+"</th>\r\n" + 
	 				"					<th>"+player.retiredPlayer.reason+"</th>\r\n" + 
	 				"					<th>"+player.retiredPlayer.createDate+"</th>\r\n" + 
					"				</tr>";
					
			}
			
			$("#playerData").append(data);
			
		}
		
	}).fail(function(error) {
		
		alert(error);
		
	});
}