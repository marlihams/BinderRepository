
$(function(){
	

//$(".linkRecherche").on("click",function(e){
//
//var champ=$(this).text();
//
//$("#paramRecherche").attr("name",champ);
//$("#recherche").submit();
//
//});

$(".newAccount").on("click",function(){
	
	$("#formNewAccount").slideDown("slow");
	
});


// utilitaire d'utilisation de ajax 
var sendData={
		
	formationBeanRequete:function($objet){
		var array={};
		$objet.each(function(){
			array[this.className]=$(this).text();		
		});
		return array;
	},
	formationUrlRequete:function($objet){
		
		var chaine="";
		$objet.each(function(){
			chaine+=this.className+"="+$(this).text()+"&";		
		});
		return chaine;
		
	},
	sendToServletByPost:function(requete,objet,fonction){
		$.post(requete,objet,fonction);
	},
	sendToServletByGet:function(requete,objet,fonction){

		$.get(requete,objet,fonction,"text");
	}	
	};

function removingBookLu(){
$(".cible").each(function(){

	var $cible=$(this).find(".remove");
	
	var $tdHavingdata=$(this).find("td").filter(":not(.remove)");
	
	$cible.on("click",function(){ 
	 var tableau=sendData.formationBeanRequete($tdHavingdata);
	 sendData.sendToServletByPost("/Binder/userProfile",tableau,succesPost);

	});
});

}

function searchingBook(){
	var $reSearch=$('#recherche');
		var tableau={};
		 var $div=$('<div />'); 
		var $cible=$(".linkRecherche");
		var champ="";
		$(".supp").remove(); // deleting the alert of the last reasearch
		$cible.on("click",function(){ 
			
			var action=$(this).text().trim();
		
			 tableau ["action"]=action;
			 champ=$("#paramRecherche").val().trim();
		
			if(champ.length){
				 tableau[action]=champ;
				 sendData.sendToServletByGet("/Binder/userProfile",tableau,responseGet);
			}
			else{
				$div.attr("class","alert alert-danger alert-dismissible supp").attr("role","alert");
				$div.html("<button type='button' class='close' data-dismiss='alert'aria-label='Close'>X</button>come on !!!! what do you want to look for");
				$reSearch.before($div);
				
			}
		});
}

// method succes for the calling of ajax
function succesPost(response){
	
	location.reload(true);
}
function responseGet(response){ //response  sous la forme de  ["title;isbn;genre;auteur"]
	var $table=$('#search');
	var $reSearch=$("#recherche");
	var $div=$('<div />'); 
	if (response=="false"){
		$div.html("<button type='button' class='close' data-dismiss='alert'aria-label='Close'>X</button>come on !!!! what do you want to look for");
		$reSearch.before($div);
	}
	else{
		
		var cible=response.split(",");
		
	var $tbody=$table.find('#repSearch');
	
	$table.show();
	$tbody.empty();
	$.each(cible,function(index,val){
		var $tr=$('<tr/>');
		$.each(val.split(";"),function(i,v){
			
			var $td=$('<td />').text(v);
			$tr.append($td);
		});
		var $read=$('<td />').append($('<span class="glyphicon glyphicon-folder-open" aria-hidden="true" />'));
		
		$tbody.append($tr.append($read));
	});	
	
	$(".linkRecherche").attr("href","#search");
	}
	
}

function evaluationBook() {
 $(".cibleEvaluation").each(function(){
	var $cible=$(this).find(".evaluation");
	
	var $tdHavingdata=$(this).find("td").filter(":not(.evaluation)").filter(":not(.decoration)");
	
	$cible.on("click",function(){ 
	
	 var chaine=sendData.formationUrlRequete($tdHavingdata);
	 chaine+="evaluation=true";
	 $(this).find("a").attr("href","/Binder/userBook?"+chaine);
	});
});

}

removingBookLu();
evaluationBook();
searchingBook();


})();


