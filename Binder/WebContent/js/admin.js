
$(function(){
	
function detailsUser(){
	

	 $(".newUser").each(function(){
			var $cible=$(this).find(".infoNewUser");
		
			var $data=$(this).find("td").eq(1);
			var champ="email="+$data.text();
			
			$cible.on("click",function(){ 
			
			 $(this).attr("href","/Binder/futureUser?"+champ);
			});
		});

}
detailsUser();

});

