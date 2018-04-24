$(function() {
   
	$('#withdraw').click(function(){
		$('#model .input').val("");
		$('#model').lightbox_me({
			centered: true
		});
		$('#submit').click(function(){
			$.ajax({
				url: 'withdraw/'+$('#model .input').val(),
			    success: function(data){
					$('#model').trigger('close');
					$('#model .error').hide();
				},
				error: function(){
					$('#pinmodel .error').show();
				}
			});
		});		
	});
	
	$('#deposit').click(function(){
		$('#model .input').val("");
		$('#model').lightbox_me({
			centered: true
		});
		$('#model .submit').click(function(){
			$.ajax('deposit/'+$('#model .input').val());
			$('#model').trigger('close');
		});
	});
	
	$('#balance').click(function(){
		$.get('balance', function(data){
			$('#balancemodel .input').val(data);
			$('#balancemodel').lightbox_me({
				centered:true
			});
			$('#balancemodel .submit').click(function(){
				$('#balancemodel').trigger('close');
			});
		});	
	});
	
	$('#pin').click(function(){
		$('#pinmodel .input').val("");
		$('#pinmodel').lightbox_me({
			
		});
		$('#pinmodel .submit').click(function(){
			$.get('pin/'+$('#pinmodel .input').val()+'/'+$('#pinmodel .account').val(), function(data){
				if(data=='true'){
					$('#pinmodel').trigger('close');
					$('#pinmodel .error').hide();
				}
				else
					$('#pinmodel .error').show();
			});	
			
		});
	});
});
