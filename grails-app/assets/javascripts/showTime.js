// Show time - Simple Ajax
console.log("Hello showtime");
$(document).ready( function(){
    console.log("In document ready");
    $('#time').load("/cs4760progassign/home/showTime");
    $('#timeLink').click(function(){
        $('#time').load(this.href); return false;
    });
});