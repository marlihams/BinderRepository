(function($){

    $.fn.pagination=function(options){

        var defauts={
            
             'limite':6,
             'vitesse':400
        };

        var parametres=$.extend(defauts,options);

        return this.each(function(){ // permet de chainer les fonctions 
           
            var $tr=$(this).find('tr').slice(1); // recuperation des lignes du tableau sauf le titre
      		
      		var taille=$tr.length;
      		

            //creation des élements de navigation
            var $nav=$("<ul class='pager'></ul>");
            
         
            // ajout des flèches de direction droite et gauche 
            $nav.append('<li  class="navigation" rel="previous"><a >Previous</a></li>');
            
            $nav.append('<li  class="navigation" rel="next"><a >Next</a></li>');
            $nav.wrap("<nav></nav>");
            

            $(this).after($nav);
           
            $tr.hide();
            $tr.slice(0,parametres.limite).show();
             var debut=0;
             var end=parametres.limite;

            var $li=$nav.find('.navigation');
            var $old,decallage;
           
            $li.on('click',function(){
            

            	$old=$tr.slice(debut ,end);
            	
                if ($(this).attr("rel")=="previous"){
                    debut -=parametres.limite;

                    debut= debut >0 ? debut:0;

                }
                else{
                	decallage=taille-parametres.limite < debut ? debut:taille-parametres.limite;
                	
                    debut=(end+parametres.limite) >= taille ? decallage :end;
                }
               
              end=debut+parametres.limite;
              
                  $old.fadeOut('slow',function(){
              

                //Une fois l'élément invisible, on le fait réapparaitre rapidement !

                $tr.slice(debut ,end).fadeIn(parametres.vitesse);

            });

            });
             }) ;  

        };
})(jQuery);