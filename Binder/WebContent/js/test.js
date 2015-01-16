
function evaluation(){

	var  $form=$("#form2");
	var disabled=$("input:disabled");

$(".formEval").on("click",function(){
	
	disabled.removeAttr("disabled");
	$form.submit();
});

}

evaluation();