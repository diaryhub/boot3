/**
 * 
 */
 

 $("#delbtn").click(function(){
	$.ajax({
		type:"DELETE",
		url:"../cart/1",
		success:function(data){
			console.log(data.trim());
		},
		error:function(){}
	});
	
});

$("#cart").click(function(){
	let productNum = $(this).attr("data-pn");
	let count=2;
	$.ajax({
		type:"POST",
		url:"../cart/"+productNum+"/"+count,
		success:function(data){
			console.log("Data : "+data);
			let check = confirm("장바구니로 이동");
		}
		
	});
	
});
 
 function getList(){
 $.ajax({
	type:"GET",
	url:"../cart/2",
	success:function(data){
		console.log(data);
		console.log(data[0].num);
		
	},
	error:function(){}
});
};