var ADA='FUCK';
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
		
		
		$cible.on("click",function(){ 
			$(".supp").remove(); // deleting the alert of the last reasearch
			
			var action=$(this).text().trim();
		
			 tableau ["action"]=action;
			 champ=$("#paramRecherche").val().trim();
		
			if(champ.length){
				 tableau[action]=champ;
				 sendData.sendToServletByGet("/Binder/userProfile",tableau,responseGet);
			}
			else{
				$div.attr("class","alert alert-danger alert-dismissible supp").attr("role","alert");
				$div.html("<button type='button' class='close supp' data-dismiss='alert'aria-label='Close'>X</button>come on !!!! what do you want to look for");
				$reSearch.before($div);
				displaytbody(false,$("#repSearch"));
				
			}
		});
}

function displaytbody(bool,$div){
	
	
	if (bool){
		$div.show();
	}
	else{
		
		$tbody.hide();
		$("#add").remove();
	}
	
}

// method succes for the calling of ajax
function succesPost(response){
	
	location.reload(true);
}

function responseGet(response){ //response  sous la forme de  ["title;isbn;genre;auteur"]
	
	var $table=$('#search');
	var $tbody=$('#repSearch');
	var $reSearch=$("#recherche");
	var $div=$('<div />'); 
	if (response=="false"){
		$div.attr("class","alert alert-info alert-dismissible supp").attr("role","alert");
		$div.html("<button type='button' class='close supp' data-dismiss='alert' aria-label='Close' >X</button>this book doesn't exist");
		$reSearch.before($div);
		displaytbody(false,$table);
		
	}
	else{ // des résultats ont été trouvés  on les affiche avec le bouton  ajouter 
		
			$tbody.empty();
			var cible=response.split(",");
			
			displaytbody(true,$table);
		
		$.each(cible,function(index,val){
			var $tr=$('<tr class="cibleRead" />');
			
			$.each(val.split(";"),function(i,v){
				
				var $td=$('<td />').text(v);
				$tr.append($td);
			});
			var $read=$('<td />').append($('<span class="glyphicon glyphicon-folder-open read" aria-hidden="true" />'));
			
			$tbody.append($tr.append($read));
			
			//activation de la lecture
			readingBook($(".cibleRead"));
			
			
			
		});	
		
		var $link=$('<a id="add" />').attr("href","/Binder/userBook");
		
		var $boutonAjouter=$('<button />', {
	
			type: "button", // identifiant de l'élément
			"class":"btn btn-primary add",
			name:"add",
			text:"add New Book",
			
		});
		$link.append($boutonAjouter);
		$table.after($link); // ajout du bouton de redirection vers la page d'ajout d'un nouveau livre
	
	}
}
function readingBook($cibleRead){
	var tableau={};
	
	$cibleRead.each(function(){ //cibleRead pour toutes les balises tr
	
		var $cible=$(this).find(".read"); // td de lecture  
		
		
		$cible.on("click",function(){ 
		
//		 var tableau=sendData.formationBeanRequete($tdHavingdata);
		 tableau["read"]=true;
		 tableau["isbn"]=$cibleRead.find("td").eq(1).text().trim(); // recuperation du isbn
		
		 sendData.sendToServletByPost("/Binder/userProfile",tableau,succesPost);

		});
	});
	
	
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


$(".table").each(function(){
	
	
	$(this).pagination();
});


})();


